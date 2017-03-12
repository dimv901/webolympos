package beans;

import entities.ProductoFamilias;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "productoFamiliasController")
@ViewScoped
public class ProductoFamiliasController extends AbstractController<ProductoFamilias> {

    public ProductoFamiliasController() {
        // Inform the Abstract parent controller of the concrete ProductoFamilias Entity
        super(ProductoFamilias.class);
    }

}
