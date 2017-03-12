package beans;

import entities.Circuitos;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "circuitosController")
@ViewScoped
public class CircuitosController extends AbstractController<Circuitos> {

    public CircuitosController() {
        // Inform the Abstract parent controller of the concrete Circuitos Entity
        super(Circuitos.class);
    }

}
