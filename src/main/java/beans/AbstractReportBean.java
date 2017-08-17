/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Fernando
 */
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.j2ee.servlets.BaseHttpServlet;
import utils.Database;


//import dao.Database;
public abstract class AbstractReportBean {

    public enum ExportOption {

        PDF, HTML, EXCEL, RTF
    }
    private ExportOption exportOption = ExportOption.PDF;
    //private ExportOption exportOption; dejar asi para las otras opciones
    private final String COMPILE_DIR = "resources/reports/";
    //private String compileFileName = "productlist";//name of your compiled report file
    private String message;

    public AbstractReportBean() {
        super();
        setExportOption(ExportOption.PDF);
    }

    protected void prepareReport() throws JRException, IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

        ServletContext context = (ServletContext) externalContext.getContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

        ReportConfigUtil.compileReport(context, getCompileDir(), getCompileFileName());
        System.out.println(getCompileDir() + " - " + getCompileFileName());
        File reportFile = new File(ReportConfigUtil.getJasperFilePath(context, getCompileDir(), getCompileFileName() + ".jasper"));

        ///////////////////
        Connection conn = null;
        try {
            conn = Database.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        /////////////////////
        JasperPrint jasperPrint = ReportConfigUtil.fillReport(reportFile, getReportParameters(), conn);

        if (getExportOption().equals(ExportOption.HTML)) {
            ReportConfigUtil.exportReportAsHtml(jasperPrint, response.getWriter());
        } else if (getExportOption().equals(ExportOption.EXCEL)) {
            ReportConfigUtil.exportReportAsExcel(jasperPrint, response.getWriter());
        } else {
            request.getSession().setAttribute(BaseHttpServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);
            response.sendRedirect(request.getContextPath() + "/servlets/report/" + getExportOption());
            System.out.println(request.getPathInfo()+" - "+request.getContextPath()+ " - "+response.getLocale());
//            response.setContentType("application/pdf");
//            response.setHeader("Expires", "0");
//            response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
//            response.setHeader("Content-Disposition", "inline;filename=PDF" );
//            response.setHeader("Accept-Ranges", "bytes");
//
//            File nfsPDF = new File("/servlets/report/PDF");
//            FileInputStream fis = new FileInputStream(nfsPDF);
//            BufferedInputStream bis = new BufferedInputStream(fis);
//            ServletOutputStream sos = response.getOutputStream();
//            byte[] buffer = new byte[2048];
//            while (true) {
//                int bytesRead = bis.read(buffer, 0, buffer.length);
//                if (bytesRead < 0) {
//                    break;
//                }
//                sos.write(buffer, 0, bytesRead);
//                sos.flush();
//            }
//            sos.flush();
//            bis.close();
        }

        FacesContext.getCurrentInstance().responseComplete();

    }

    public ExportOption getExportOption() {
        return exportOption;
    }

    public void setExportOption(ExportOption exportOption) {
        this.exportOption = exportOption;
    }

    protected Map<String, Object> getReportParameters() {
        return new HashMap<String, Object>();
    }

    protected String getCompileDir() {
        return COMPILE_DIR;
    }

    protected abstract String getCompileFileName();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
