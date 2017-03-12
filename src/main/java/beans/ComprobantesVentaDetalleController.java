package beans;

import entities.ComprobantesVentaDetalle;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "comprobantesVentaDetalleController")
@ViewScoped
public class ComprobantesVentaDetalleController extends AbstractController<ComprobantesVentaDetalle> {

    public ComprobantesVentaDetalleController() {
        // Inform the Abstract parent controller of the concrete ComprobantesVentaDetalle Entity
        super(ComprobantesVentaDetalle.class);
    }

}
