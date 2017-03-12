package beans;

import entities.MotivosNoCompra;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "motivosNoCompraController")
@ViewScoped
public class MotivosNoCompraController extends AbstractController<MotivosNoCompra> {

    public MotivosNoCompraController() {
        // Inform the Abstract parent controller of the concrete MotivosNoCompra Entity
        super(MotivosNoCompra.class);
    }

}
