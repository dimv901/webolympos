package beans;

import entities.FormasPago;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "formasPagoController")
@ViewScoped
public class FormasPagoController extends AbstractController<FormasPago> {

    public FormasPagoController() {
        // Inform the Abstract parent controller of the concrete FormasPago Entity
        super(FormasPago.class);
    }

}
