package beans;

import entities.ComprobantesCompraCabecera;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "comprobantesCompraCabeceraController")
@ViewScoped
public class ComprobantesCompraCabeceraController extends AbstractController<ComprobantesCompraCabecera> {

    public ComprobantesCompraCabeceraController() {
        // Inform the Abstract parent controller of the concrete ComprobantesCompraCabecera Entity
        super(ComprobantesCompraCabecera.class);
    }

}
