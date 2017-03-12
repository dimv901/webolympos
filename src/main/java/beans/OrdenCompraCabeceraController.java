package beans;

import entities.OrdenCompraCabecera;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "ordenCompraCabeceraController")
@ViewScoped
public class OrdenCompraCabeceraController extends AbstractController<OrdenCompraCabecera> {

    public OrdenCompraCabeceraController() {
        // Inform the Abstract parent controller of the concrete OrdenCompraCabecera Entity
        super(OrdenCompraCabecera.class);
    }

}
