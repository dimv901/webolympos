package beans;

import entities.Visitas;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "visitasController")
@ViewScoped
public class VisitasController extends AbstractController<Visitas> {

    public VisitasController() {
        // Inform the Abstract parent controller of the concrete Visitas Entity
        super(Visitas.class);
    }

}
