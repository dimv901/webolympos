package converters;

import entities.UsuariosWeb;
import controllers.UsuariosWebFacade;
import beans.util.JsfUtil;
import controllers.DepartamentosFacade;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;

@FacesConverter(value = "usuariosWebConverter")
public class UsuariosWebConverter implements Converter {

    @Inject
    private UsuariosWebFacade ejbFacade;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }

        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        Context ctx = null;
        try {
            ctx = new InitialContext();
        } catch (NamingException ex) {
            Logger.getLogger(UsuariosWebConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ctx != null) {
            try {
                String lookupString;
                if (servletContext != null) {
                    lookupString = "java:global" + servletContext.getContextPath() + "/" + UsuariosWebFacade.class.getSimpleName();
                } else {
                    lookupString = "java:global/" + UsuariosWebFacade.class.getSimpleName();
                }
                ejbFacade = (UsuariosWebFacade) ctx.lookup(lookupString);
            } catch (NamingException ex) {
                Logger.getLogger(UsuariosWebConverter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return this.ejbFacade.find(getKey(value));
    }

    java.lang.Integer getKey(String value) {
        java.lang.Integer key;
        key = Integer.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Integer value) {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof UsuariosWeb) {
            UsuariosWeb o = (UsuariosWeb) object;
            return getStringKey(o.getId());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), UsuariosWeb.class.getName()});
            return null;
        }
    }

}
