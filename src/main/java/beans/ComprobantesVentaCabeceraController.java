package beans;

import entities.ComprobantesVentaCabecera;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "comprobantesVentaCabeceraController")
@ViewScoped
public class ComprobantesVentaCabeceraController extends AbstractController<ComprobantesVentaCabecera> {

    public ComprobantesVentaCabeceraController() {
        // Inform the Abstract parent controller of the concrete ComprobantesVentaCabecera Entity
        super(ComprobantesVentaCabecera.class);
    }

}
