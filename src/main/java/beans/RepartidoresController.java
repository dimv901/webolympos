package beans;

import entities.Repartidores;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "repartidoresController")
@ViewScoped
public class RepartidoresController extends AbstractController<Repartidores> {

    public RepartidoresController() {
        // Inform the Abstract parent controller of the concrete Repartidores Entity
        super(Repartidores.class);
    }

}
