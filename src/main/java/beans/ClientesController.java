package beans;

import entities.Clientes;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@Named(value = "clientesController")
@ViewScoped
public class ClientesController extends AbstractController<Clientes> {

    private MapModel model = new DefaultMapModel();
    private Marker marker;
    private StreamedContent picture;

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public ClientesController() {
        // Inform the Abstract parent controller of the concrete Clientes Entity
        super(Clientes.class);
    }

    public MapModel getModel() {
        if (getSelected().getGeolocalizado() == true) {
            model.addOverlay(new Marker(new LatLng(getSelected().getLatitude(), getSelected().getLongitud()), getSelected().getNombreNegocio()));
        }
        return model;
    }

    public void setModel(MapModel model) {
        this.model = model;
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }

    public StreamedContent getPicture() throws IOException {
        InputStream stream = null;
        if (getSelected().isTieneFoto() == true) {
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
