package beans;

import entities.Moviles;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "movilesController")
@ViewScoped
public class MovilesController extends AbstractController<Moviles> {

    public MovilesController() {
        // Inform the Abstract parent controller of the concrete Moviles Entity
        super(Moviles.class);
    }

}
