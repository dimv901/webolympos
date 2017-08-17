package beans;

import entities.InventarioDetalle;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "inventarioDetalleController")
@ViewScoped
public class InventarioDetalleController extends AbstractController<InventarioDetalle> {

    public InventarioDetalleController() {
        // Inform the Abstract parent controller of the concrete InventarioDetalle Entity
        super(InventarioDetalle.class);
    }

}
