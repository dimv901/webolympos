package beans;

import entities.Stock;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "stockController")
@ViewScoped
public class StockController extends AbstractController<Stock> {

    public StockController() {
        // Inform the Abstract parent controller of the concrete Stock Entity
        super(Stock.class);
    }

}
