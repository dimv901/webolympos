package beans;

import entities.Paises;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "paisesController")
@ViewScoped
public class PaisesController extends AbstractController<Paises> {

    public PaisesController() {
        // Inform the Abstract parent controller of the concrete Paises Entity
        super(Paises.class);
    }

    public String pageCreate(){
        return "WEB-INF/include/entity/paises/Create.xhtml";
    }

    
}
