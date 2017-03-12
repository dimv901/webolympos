package beans;

import entities.TipoImpuestos;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "tipoImpuestosController")
@ViewScoped
public class TipoImpuestosController extends AbstractController<TipoImpuestos> {

    public TipoImpuestosController() {
        // Inform the Abstract parent controller of the concrete TipoImpuestos Entity
        super(TipoImpuestos.class);
    }

}
