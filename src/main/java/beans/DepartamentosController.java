package beans;

import entities.Departamentos;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "departamentosController")
@ViewScoped
public class DepartamentosController extends AbstractController<Departamentos> {

    public DepartamentosController() {
        // Inform the Abstract parent controller of the concrete Departamentos Entity
        super(Departamentos.class);
    }

}
