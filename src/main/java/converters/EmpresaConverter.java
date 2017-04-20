package converters;

import entities.Empresa;
import controllers.EmpresaFacade;
import beans.util.JsfUtil;
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

@FacesConverter(value = "empresaConverter")
public class EmpresaConverter implements Converter {

    @Inject
    private EmpresaFacade ejbFacade;

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
            Logger.getLogger(EmpresaConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ctx != null) {
            try {
                String lookupString;
                if (servletContext != null) {
                    lookupString = "java:global" + servletContext.getContextPath() + "/" + EmpresaFacade.class.getSimpleName();
                } else {
                    lookupString = "java:global/" + EmpresaFacade.class.getSimpleName();
                }
                ejbFacade = (EmpresaFacade) ctx.lookup(lookupString);
            } catch (NamingException ex) {
                Logger.getLogger(EmpresaConverter.class.getName()).log(Level.SEVERE, null, ex);
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
        if (object instanceof Empresa) {
            Empresa o = (Empresa) object;
            return getStringKey(o.getId());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Empresa.class.getName()});
            return null;
        }
    }

}
