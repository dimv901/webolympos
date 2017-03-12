package beans;

import entities.PedidosCabecera;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "pedidosCabeceraController")
@ViewScoped
public class PedidosCabeceraController extends AbstractController<PedidosCabecera> {

    public PedidosCabeceraController() {
        // Inform the Abstract parent controller of the concrete PedidosCabecera Entity
        super(PedidosCabecera.class);
    }

}
