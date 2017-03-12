package beans;

import entities.ComprobantesCompraDetalle;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "comprobantesCompraDetalleController")
@ViewScoped
public class ComprobantesCompraDetalleController extends AbstractController<ComprobantesCompraDetalle> {

    public ComprobantesCompraDetalleController() {
        // Inform the Abstract parent controller of the concrete ComprobantesCompraDetalle Entity
        super(ComprobantesCompraDetalle.class);
    }

}
