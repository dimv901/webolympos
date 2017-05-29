package beans;

import beans.util.JsfUtil;
import entities.Productos;
import entities.Stock;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

@Named(value = "productosController")
@ViewScoped
public class ProductosController extends AbstractController<Productos> {

    private UploadedFile uploadedFile;
    private final String filePath = "c://imagenes//productos//";
    private StreamedContent picture;

    public ProductosController() {
        // Inform the Abstract parent controller of the concrete Productos Entity
        super(Productos.class);
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public void handleFileUpload(FileUploadEvent event) {
        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UploadImagenProducto"));
        setUploadedFile(event.getFile());
    }

    @Override
    public void saveNew(ActionEvent event) {
        try {
            //To change body of generated methods, choose Tools | Templates.  
            if (uploadedFile != null) {
                if (storeImage()) {
                    Stock st = new Stock();
                    getSelected().setTieneFoto(true);
                    getSelected().setFotoUrl(filePath + getSelected().getCodigoBarra() + ".jpg");
                    getSelected().setStock(st);
                    st.setStock(getSelected());
                    super.saveNew(event);
                } else {
                    JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle").getString("ErrorSaveImagenProducto"));
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
        try {
            //To change body of generated methods, choose Tools | Templates.  
            if (uploadedFile != null) {
                if (storeImage()) {
                    getSelected().setTieneFoto(true);
                    getSelected().setFotoUrl(filePath + getSelected().getCodigoBarra() + ".jpg");
                    super.save(event);
                } else {
                    JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle").getString("ErrorSaveImagenProducto"));
                }
            } else {
                super.save(event);
            }
        } catch (Exception e) {
            System.err.print(e);
        }
    }

    public boolean storeImage() {
        boolean createImage = false;
        try {
            InputStream input = uploadedFile.getInputstream();
            BufferedImage scaledImage = Scalr.resize(ImageIO.read(input), 400);
            String filename = getSelected().getCodigoBarra();
            String extension = ".jpg";
            File f = new File(filePath + filename + extension);
            ImageIO.write(scaledImage, "jpeg", f);
            // FileUtils.copyInputStreamToFile(ImageIO. input, f);
            createImage = true;
        } catch (IOException ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, e);
        }
        return createImage;
    }

    @Override
    public void delete(ActionEvent event) {
        //To change body of generated methods, choose Tools | Templates.
        if (getSelected().getTieneFoto()) {
            if (removeImage()) {
                super.delete(event);
            } else {
                JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle").getString("ErrorDeleteImagenProducto"));
            }
        } else {
            super.delete(event);
        }
    }

    public boolean removeImage() {
        boolean deleteImage = false;
        try {
            Path path = Paths.get(getSelected().getFotoUrl());
            deleteImage = Files.deleteIfExists(path);
        } catch (IOException ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deleteImage;
    }

    public StreamedContent getPicture() throws IOException {
        InputStream stream = null;
        if (getSelected().getTieneFoto() == true) {
            try {
                stream = new FileInputStream(new File(getSelected().getFotoUrl()));
                picture = new DefaultStreamedContent(new ByteArrayInputStream(IOUtils.toByteArray(stream)), "image/png");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (stream != null) {
                        stream.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return picture;
    }

    public void setPicture(StreamedContent picture) {
        this.picture = picture;
    }

}
