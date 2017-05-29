package beans;

import beans.util.JsfUtil;
import controllers.UsuariosMovilesFacade;
import controllers.UsuariosWebFacade;
import entities.UsuariosMoviles;
import entities.UsuariosWeb;
import entities.Vendedores;
import java.util.ResourceBundle;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "vendedoresController")
@ViewScoped
public class VendedoresController extends AbstractController<Vendedores> {

    @Inject
    UsuariosMovilesFacade ejbUsuariosMovilesFacade;

    @Inject
    UsuariosWebFacade ejbUsuariosWebFacade;

    public VendedoresController() {
        // Inform the Abstract parent controller of the concrete Vendedores Entity
        super(Vendedores.class);
    }

    @Override
    public void saveNew(ActionEvent event) {
        boolean createSalesmen = false;
        try {
            super.saveNew(event); //To change body of generated methods, choose Tools | Templates.
            createSalesmen = true;
        } catch (Exception e) {

        }

        try {
            if (createSalesmen) {
                if (getSelected().getAndroid()) {
                    UsuariosMoviles um = new UsuariosMoviles();
                    um.setDescripcion(getSelected().getNombre() + " " + getSelected().getApellido());
                    um.setUsuario(getSelected().getCedula());
                    um.setPassword(getSelected().getCedula().substring(0, 3));
                    um.setActivo(getSelected().getActivo());
                    um.setResetPassword(true);
                    ejbUsuariosMovilesFacade.create(um);
                } else {
                    UsuariosWeb uw = new UsuariosWeb();
                    uw.setDescripcion(getSelected().getNombre() + " " + getSelected().getApellido());
                    uw.setUsuario(getSelected().getCedula());
                    uw.setPassword(getSelected().getCedula().substring(0, 3));
                    uw.setActivo(getSelected().getActivo());
                    uw.setResetPassword(true);
                    ejbUsuariosWebFacade.create(uw);
                }
            }
        } catch (Exception e) {

        }
    }

}
