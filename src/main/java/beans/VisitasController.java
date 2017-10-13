package beans;

import entities.Visitas;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.apache.commons.lang3.time.DateUtils;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@Named(value = "visitasController")
@ViewScoped
public class VisitasController extends AbstractController<Visitas> {

    private MapModel model = new DefaultMapModel();
    private Marker marker;

    public VisitasController() {
        // Inform the Abstract parent controller of the concrete Visitas Entity
        super(Visitas.class);
        model = new DefaultMapModel();
    }

    public MapModel getModel() {
        if (getSelected() != null) {
            model.addOverlay(new Marker(new LatLng(getSelected().getLatitud(), getSelected().getLongitud()), getSelected().getIdCliente().getNombreNegocio()));
        }
        return model;
    }

    public void setModel(MapModel model) {
        this.model = model;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }

    public boolean filterByDate(Object value, Object filter, Locale locale) {

        if (filter == null) {
            return true;
        }

        if (value == null) {
            return false;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime((Date) value);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return DateUtils.truncatedEquals((Date) filter, cal.getTime(), Calendar.DATE);
    }

}
