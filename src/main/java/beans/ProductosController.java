package beans;

import entities.Productos;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.apache.commons.io.FileUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@Named(value = "productosController")
@ViewScoped
public class ProductosController extends AbstractController<Productos> {

    private UploadedFile uploadedFile;
    private String filePath = "c://imagenes//productos//";

    public ProductosController() {
        // Inform the Abstract parent controller of the concrete Productos Entity
        super(Productos.class);
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Exito", "El archivo se subio correctamente.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        setUploadedFile(event.getFile());
    }

    @Override
    public void saveNew(ActionEvent event) {
        try {
            //To change body of generated methods, choose Tools | Templates.  
            if (uploadedFile != null) {
                if (storeFile()) {
                    getSelected().setTieneFoto(true);
                    getSelected().setFotoUrl(filePath + getSelected().getCodigoBarra() + ".jpg");
                    super.saveNew(event);
                } else {
                    FacesMessage message = new FacesMessage("Error", "Error al guardar la imagen del producto.");
                    message.setSeverity(FacesMessage.SEVERITY_ERROR);
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
            } else {
                super.saveNew(event);
            }
        } catch (Exception e) {
            System.err.print(e);
        }
    }

    @Override
    public void save(ActionEvent event) {
         super.save(event); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public boolean storeFile() {
        boolean createImage = false;
        try {
            InputStream input = uploadedFile.getInputstream();
            String filename = getSelected().getCodigoBarra();
            String extension = ".jpg";
            File f = new File(filePath + filename + extension);
            FileUtils.copyInputStreamToFile(input, f);
            createImage = true;
        } catch (IOException ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, e);
        }
        return createImage;
    }

}
