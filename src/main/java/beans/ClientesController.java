package beans;

import entities.Clientes;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "clientesController")
@ViewScoped
public class ClientesController extends AbstractController<Clientes> {

    public ClientesController() {
        // Inform the Abstract parent controller of the concrete Clientes Entity
        super(Clientes.class);
    }

}
