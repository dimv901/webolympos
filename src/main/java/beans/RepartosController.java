package beans;

import entities.Repartos;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "repartosController")
@ViewScoped
public class RepartosController extends AbstractController<Repartos> {

    public RepartosController() {
        // Inform the Abstract parent controller of the concrete Repartos Entity
        super(Repartos.class);
    }

}
