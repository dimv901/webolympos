package beans;

import entities.PedidosDetalle;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "pedidosDetalleController")
@ViewScoped
public class PedidosDetalleController extends AbstractController<PedidosDetalle> {

    public PedidosDetalleController() {
        // Inform the Abstract parent controller of the concrete PedidosDetalle Entity
        super(PedidosDetalle.class);
    }

}
