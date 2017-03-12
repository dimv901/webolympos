package beans;

import entities.OrdenCompraDetalle;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "ordenCompraDetalleController")
@ViewScoped
public class OrdenCompraDetalleController extends AbstractController<OrdenCompraDetalle> {

    public OrdenCompraDetalleController() {
        // Inform the Abstract parent controller of the concrete OrdenCompraDetalle Entity
        super(OrdenCompraDetalle.class);
    }

}
