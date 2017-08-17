package beans;

import beans.util.JsfUtil;
import controllers.UsuariosMovilesFacade;
import controllers.UsuariosWebFacade;
import controllers.VendedoresFacade;
import entities.Circuitos;
import entities.UsuariosMoviles;
import entities.UsuariosWeb;
import entities.Vendedores;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Named(value = "vendedoresController")
@ViewScoped
public class VendedoresController extends AbstractController<Vendedores> {

    @PersistenceContext(unitName = "py.com.fpuna_WebOlympos_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @EJB
    UsuariosMovilesFacade ejbUsuariosMovilesFacade;

    @EJB
    UsuariosWebFacade ejbUsuariosWebFacade;

    @EJB
    VendedoresFacade ejbVendedoresFacade;

    @ManagedProperty("#{bundle}")
    private ResourceBundle bundle;

    public VendedoresController() {
        // Inform the Abstract parent controller of the concrete Vendedores Entity
        super(Vendedores.class);
        FacesContext context = FacesContext.getCurrentInstance();
        bundle = context.getApplication().getResourceBundle(context, "bundle");
    }

    @Override
    public void saveNew(ActionEvent event) {
        boolean createSalesmen = false;
        try {
            getSelected().setDescripcion(getSelected().getNombre() + " " + getSelected().getApellido());
            if (circuitoYaAsignado(getSelected().getIdCircuito())) {
                JsfUtil.addErrorMessage(bundle.getString("ErrorCircuitoYaAsignado"));
                return;
            }
            super.saveNew(event); //To change body of generated methods, choose Tools | Templates.
            createSalesmen = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (createSalesmen) {
                if (getSelected().getAndroid()) {
                    UsuariosMoviles um = new UsuariosMoviles();
                    um.setDescripcion(getSelected().getNombre() + " " + getSelected().getApellido());
                    um.setUsuario(getSelected().getCedula());
                    um.setPassword(getSelected().getCedula().substring(0, 3));
                    um.setActivo(getSelected().getActivo());
                    um.setResetPassword(false);
                    ejbUsuariosMovilesFacade.create(um);

                } else {
                    UsuariosWeb uw = new UsuariosWeb();
                    uw.setDescripcion(getSelected().getNombre() + " " + getSelected().getApellido());
                    uw.setUsuario(getSelected().getCedula());
                    uw.setPassword(getSelected().getCedula().substring(0, 3));
                    uw.setActivo(getSelected().getActivo());
                    uw.setResetPassword(false);
                    ejbUsuariosWebFacade.create(uw);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(ActionEvent event) {
        getSelected().setDescripcion(getSelected().getNombre() + " " + getSelected().getApellido());
        if (circuitoYaAsignado(getSelected().getIdCircuito())) {
            JsfUtil.addErrorMessage(bundle.getString("ErrorCircuitoYaAsignado"));
            return;
        }
        super.save(event); //To change body of generated methods, choose Tools | Templates.
    }

    public void onCircuitoChange(ValueChangeEvent event) {
        Circuitos c = (Circuitos) event.getNewValue();
        if (circuitoYaAsignado(c)) {
            JsfUtil.addErrorMessage(bundle.getString("ErrorCircuitoYaAsignado"));
        }
    }

    public boolean circuitoYaAsignado(Circuitos c) {
        try {
            Query q = em.createNamedQuery("Vendedores.findByCircuito");
            q.setParameter("idCircuito", c);
            Vendedores v = (Vendedores) q.getSingleResult();
            if (v != null) {
                if (!v.getId().equals(getSelected().getId())) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
