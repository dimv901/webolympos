package beans;

import beans.util.JsfUtil;
import entities.Ciudades;
import entities.Clientes;
import entities.Departamentos;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
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
    private List<Ciudades> listaCiudades;

    @ManagedProperty("#{bundle}")
    private ResourceBundle bundle;

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public ClientesController() {
        // Inform the Abstract parent controller of the concrete Clientes Entity
        super(Clientes.class);
        FacesContext context = FacesContext.getCurrentInstance();
        bundle = context.getApplication().getResourceBundle(context, "bundle");
    }

    public MapModel getModel() {
        if (getSelected().getGeolocalizado() == true) {
            model.addOverlay(new Marker(new LatLng(getSelected().getLatitud(), getSelected().getLongitud()), getSelected().getNombreNegocio()));
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

    public void onDepartamentoChange(ValueChangeEvent event) {
        Departamentos d = (Departamentos) event.getNewValue();
        setListaCiudades(new ArrayList<>(d.getCiudadesCollection()));
    }

    public List<Ciudades> getListaCiudades() {
        return listaCiudades;
    }

    public void setListaCiudades(List<Ciudades> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    @Override
    public void saveNew(ActionEvent event) {
        if (getSelected().getDomingo() == false
                && getSelected().getLunes() == false
                && getSelected().getMartes() == false
                && getSelected().getMiercoles() == false
                && getSelected().getJueves() == false
                && getSelected().getViernes() == false
                && getSelected().getSabado() == false) {
            JsfUtil.addErrorMessage(bundle.getString("ErrorDiaVisita"));
            return;
        }
        super.saveNew(event); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(ActionEvent event) {
        if (getSelected().getDomingo() == false
                && getSelected().getLunes() == false
                && getSelected().getMartes() == false
                && getSelected().getMiercoles() == false
                && getSelected().getJueves() == false
                && getSelected().getViernes() == false
                && getSelected().getSabado() == false) {
            JsfUtil.addErrorMessage(bundle.getString("ErrorDiaVisita"));
            return;
        }
        super.saveNew(event); //To change body of generated methods, choose Tools | Templates.
    }

}
