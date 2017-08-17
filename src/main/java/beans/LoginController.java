/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.util.JsfUtil;
import controllers.UsuariosWebFacade;
import entities.UsuariosWeb;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import utils.SessionUtils;

/**
 *
 * @author Diego
 */
@Named(value = "loginController")
@ViewScoped
public class LoginController extends AbstractController<UsuariosWeb> {

    private String usuario;
    private String password;
    @Inject
    private UsuariosWebFacade usuariosWebService;
    @PersistenceContext(unitName = "py.com.fpuna_WebOlympos_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @ManagedProperty("#{bundle}")
    private ResourceBundle bundle;

    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
        super(UsuariosWeb.class);
        FacesContext context = FacesContext.getCurrentInstance();
        bundle = context.getApplication().getResourceBundle(context, "bundle");
    }

    public void doLogin(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        UsuariosWeb us = null;

        try {
            Query q = em.createNamedQuery("UsuariosWeb.findByUsuario");
            q.setParameter("usuario", usuario);
            us = (UsuariosWeb) q.getSingleResult();
        } catch (Exception e) {
            System.err.print(e);
        }

        if (us == null) {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, bundle.getString("ErrorLogin"));
            JsfUtil.addErrorMessage(bundle.getString("ErrorLogin"));
            return;
        }

        if (!us.getPassword().equals(password)) {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, bundle.getString("ErrorLogin"));
            JsfUtil.addErrorMessage(bundle.getString("ErrorLogin"));
        } else {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("descripcion", us.getDescripcion());
            session.setAttribute("usuarioid", us.getId());
            session.setAttribute("usuario", us.getUsuario());
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("empty-page.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void doLogout(ActionEvent event) {
        try {
            SessionUtils.logout();
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect("login.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
