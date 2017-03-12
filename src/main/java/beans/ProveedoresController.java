package beans;

import entities.Proveedores;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "proveedoresController")
@ViewScoped
public class ProveedoresController extends AbstractController<Proveedores> {

    public ProveedoresController() {
        // Inform the Abstract parent controller of the concrete Proveedores Entity
        super(Proveedores.class);
    }

}
