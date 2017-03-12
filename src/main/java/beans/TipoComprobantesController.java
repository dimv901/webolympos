package beans;

import entities.TipoComprobantes;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "tipoComprobantesController")
@ViewScoped
public class TipoComprobantesController extends AbstractController<TipoComprobantes> {

    public TipoComprobantesController() {
        // Inform the Abstract parent controller of the concrete TipoComprobantes Entity
        super(TipoComprobantes.class);
    }

}
