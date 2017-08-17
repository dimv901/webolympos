package beans;

import beans.util.JsfUtil;
import controllers.ProductoFamiliasFacade;
import controllers.ProductosFacade;
import entities.InventarioCabecera;
import entities.InventarioDetalle;
import entities.ProductoFamilias;
import entities.Productos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.apache.commons.collections.CollectionUtils;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

@Named(value = "inventarioCabeceraController")
@ViewScoped
public class InventarioCabeceraController extends AbstractController<InventarioCabecera> {

    private DualListModel<ProductoFamilias> dualListItems;
    private List<ProductoFamilias> familiaTarget;
    private List<ProductoFamilias> familiaSource;

    @EJB
    private ProductoFamiliasFacade productoFamiliasService;
    @EJB
    private ProductosFacade productoService;

    public InventarioCabeceraController() {
        // Inform the Abstract parent controller of the concrete InventarioCabecera Entity
        super(InventarioCabecera.class);
    }

    @PostConstruct
    public void init() {
        getFamiliaSource();
        familiaTarget = new ArrayList();
        dualListItems = new DualListModel<>(familiaSource, familiaTarget);
    }

    public DualListModel<ProductoFamilias> getDualListItems() {
        return dualListItems;
    }

    public void setDualListItems(DualListModel<ProductoFamilias> dualListItems) {
        this.dualListItems = dualListItems;
    }

    public List<ProductoFamilias> getFamiliaTarget() {
        return familiaTarget;
    }

    public void setFamiliaTarget(List<ProductoFamilias> familiaTarget) {
        this.familiaTarget = familiaTarget;
    }

    public List<ProductoFamilias> getFamiliaSource() {
        if (familiaSource == null) {
            familiaSource = productoFamiliasService.findAll();
        }
        return familiaSource;
    }

    public void setFamiliaSource(List<ProductoFamilias> familiaSource) {
        this.familiaSource = familiaSource;
    }

    @Override
    public InventarioCabecera prepareCreate(ActionEvent event) {
        familiaTarget = new ArrayList();
        dualListItems = new DualListModel<>(familiaSource, familiaTarget);
        return super.prepareCreate(event); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveNew(ActionEvent event) {
        List<ProductoFamilias> familiaList = new ArrayList<>();
        List<Productos> productosList = new ArrayList<>();
        List<InventarioDetalle> detalleList = new ArrayList<>();

        if (familiaTarget.isEmpty()) {
            JsfUtil.addErrorMessage("Debe agregar al menos un item al inventario.");
            return;
        }

        try {
            getSelected().setEstado("ABIERTO");
            getSelected().setFechaInventario(new Date());
            for (ProductoFamilias pf : familiaTarget) {
                for (Productos p : pf.getProductosCollection()) {
                    InventarioDetalle id = new InventarioDetalle();
                    id.setIdCabecera(getSelected());
                    id.setIdProducto(p);
                    id.setIdProductoFamilia(pf);
                    id.setCantidadActual(p.getStock().getCantidad());
                    id.setCantidadRegistrada(0);
                    id.setCantidadDiferencia(0);
                    detalleList.add(id);
                }
            }
            getSelected().setInventarioDetalleCollection(detalleList);
            super.saveNew(event); //To change body of generated methods, choose Tools | Templates.
        } catch (EJBException e) {
            e.printStackTrace();
        }
    }

    public void onTransfer(TransferEvent event) {
        for (Object item : event.getItems()) {
            ProductoFamilias pf = (ProductoFamilias) item;
            familiaTarget.add(pf);
        }
    }

    public void onCellEdit(CellEditEvent event) {
        org.primefaces.component.api.UIColumn col = event.getColumn();
        DataTable o = (DataTable) event.getSource();
        InventarioDetalle entity = (InventarioDetalle) ((DataTable) event.getComponent()).getRowData();
        Object oldValue = event.getOldValue();  //here i get old value
        Object newValue = event.getNewValue(); //new value
        InventarioDetalle info = (InventarioDetalle) o.getRowData();
        double actual = info.getCantidadActual();
        double registrada = info.getCantidadRegistrada();

        double diferencia = actual - registrada;
        info.setCantidadDiferencia(diferencia);

        System.out.println("row index in event method " + event.getRowIndex());
        System.out.println("old value" + oldValue);
        System.out.println("new value" + newValue);
        //System.out.println("column2 :" + col.getHeaderText());//header text value
        ((InventarioDetalle) CollectionUtils.get(getSelected().getInventarioDetalleCollection(), event.getRowIndex())).setCantidadDiferencia(diferencia);
        //JsfUtil.addSuccessMessage("Diferencia: " + diferencia);
        //FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Diferencia", String.valueOf(diferencia));
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        FacesContext context = FacesContext.getCurrentInstance();
        InventarioDetalle item = context.getApplication().evaluateExpressionGet(context, "#{item}", InventarioDetalle.class);

        String updateClientId = o.getClientId() + ":" + o.getRowIndex() + ":diference";
        RequestContext.getCurrentInstance().update(updateClientId);

        String componentId = ((DataTable) event.getSource()).getClientId(FacesContext.getCurrentInstance()) + ":" + event.getRowIndex() + ":updateTgtRow";
        RequestContext.getCurrentInstance().execute("document.getElementById('" + componentId + "').click()");

        //RequestContext.getCurrentInstance().update(":datalist:diference");
    }

    @Override
    public void save(ActionEvent event) {
        if(getSelected()!=null){
            getSelected().setEstado("CERRADO");
            getSelected().setFechaCierre(new Date());
        }
        super.save(event); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
