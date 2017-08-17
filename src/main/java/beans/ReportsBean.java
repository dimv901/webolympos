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
import entities.InventarioCabecera;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "reportsBean")
@ViewScoped
public class ReportsBean extends AbstractReportBean {

    private String NOMBRE_DEL_REPORTE;
    Map<String, Object> parametrosDelReporte = new HashMap<String, Object>();
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected String getCompileFileName() {
        return NOMBRE_DEL_REPORTE;
    }

    @Override
    protected Map<String, Object> getReportParameters() {
        return parametrosDelReporte;
    }
    /* repetir este método para cada reporte para este caso reporte de horario de médico*/

    public String reporteInventario(InventarioCabecera cabecera) {
        parametrosDelReporte.put("id", cabecera.getId() == null ? 0 : cabecera.getId());
        NOMBRE_DEL_REPORTE = "invetario";
        try {
            super.prepareReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
