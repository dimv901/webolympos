package beans;

import entities.MovimientoStock;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "movimientoStockController")
@ViewScoped
public class MovimientoStockController extends AbstractController<MovimientoStock> {

    public MovimientoStockController() {
        // Inform the Abstract parent controller of the concrete MovimientoStock Entity
        super(MovimientoStock.class);
    }

}
