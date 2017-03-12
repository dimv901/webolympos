package beans;

import entities.UsuariosWeb;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "usuariosWebController")
@ViewScoped
public class UsuariosWebController extends AbstractController<UsuariosWeb> {

    public UsuariosWebController() {
        // Inform the Abstract parent controller of the concrete UsuariosWeb Entity
        super(UsuariosWeb.class);
    }

}
