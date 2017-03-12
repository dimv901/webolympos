package beans;

import entities.Ciudades;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "ciudadesController")
@ViewScoped
public class CiudadesController extends AbstractController<Ciudades> {

    public CiudadesController() {
        // Inform the Abstract parent controller of the concrete Ciudades Entity
        super(Ciudades.class);
    }

}
