package beans;

import entities.Vendedores;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "vendedoresController")
@ViewScoped
public class VendedoresController extends AbstractController<Vendedores> {

    public VendedoresController() {
        // Inform the Abstract parent controller of the concrete Vendedores Entity
        super(Vendedores.class);
    }

 }
