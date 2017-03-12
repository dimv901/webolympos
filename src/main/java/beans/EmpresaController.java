package beans;

import entities.Empresa;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "empresaController")
@ViewScoped
public class EmpresaController extends AbstractController<Empresa> {

    public EmpresaController() {
        // Inform the Abstract parent controller of the concrete Empresa Entity
        super(Empresa.class);
    }

}
