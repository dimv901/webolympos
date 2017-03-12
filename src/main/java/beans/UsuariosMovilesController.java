package beans;

import entities.UsuariosMoviles;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "usuariosMovilesController")
@ViewScoped
public class UsuariosMovilesController extends AbstractController<UsuariosMoviles> {

    public UsuariosMovilesController() {
        // Inform the Abstract parent controller of the concrete UsuariosMoviles Entity
        super(UsuariosMoviles.class);
    }

}
