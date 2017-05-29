package beans;

import beans.util.ComprasDetalle;
import beans.util.JsfUtil;
import controllers.ProductosFacade;
import controllers.StockFacade;
import entities.ComprobantesCompraCabecera;
import entities.ComprobantesCompraDetalle;
import entities.Productos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "comprobantesCompraCabeceraController")
@ViewScoped
public class ComprobantesCompraCabeceraController extends AbstractController<ComprobantesCompraCabecera> {

    @Inject
    ProductosFacade ejbProductos;

    @Inject
    StockFacade ejbStock;

    private Productos producto;
    private List<Productos> productoList;

    private ComprobantesCompraDetalle comprobantesCompraDetalle;
    private List<ComprobantesCompraDetalle> comprobantesCompraDetalleList;

    //CONTENEDORES DEL DETALLE
    private List<ComprasDetalle> comprasDetalleList;
    private List<ComprasDetalle> comprasDetalleView;
    private ComprasDetalle comprasDetalleSelected;
    private ComprasDetalle comprasItemDetalle;

    public ComprobantesCompraCabeceraController() {
        // Inform the Abstract parent controller of the concrete ComprobantesCompraCabecera Entity
        super(ComprobantesCompraCabecera.class);
        comprobantesCompraDetalle = new ComprobantesCompraDetalle();
        comprobantesCompraDetalleList = new ArrayList<>();
        comprasDetalleList = new ArrayList<>();
        comprasItemDetalle = new ComprasDetalle();
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public List<Productos> getProductoList() {
        if (productoList == null) {
            productoList = ejbProductos.findAll();
        }
        return productoList;
    }

    public ComprobantesCompraDetalle getComprobantesCompraDetalle() {
        return comprobantesCompraDetalle;
    }

    public void setComprobantesCompraDetalle(ComprobantesCompraDetalle comprobantesCompraDetalle) {
        this.comprobantesCompraDetalle = comprobantesCompraDetalle;
    }

    public List<ComprobantesCompraDetalle> getComprobantesCompraDetalleList() {
        return comprobantesCompraDetalleList;
    }

    public void setComprobantesCompraDetalleList(List<ComprobantesCompraDetalle> comprobantesCompraDetalleList) {
        this.comprobantesCompraDetalleList = comprobantesCompraDetalleList;
    }

    public List<ComprasDetalle> getComprasDetalleList() {
        return comprasDetalleList;
    }

    public void setComprasDetalleList(List<ComprasDetalle> comprasDetalleList) {
        this.comprasDetalleList = comprasDetalleList;
    }

    public ComprasDetalle getComprasDetalleSelected() {
        return comprasDetalleSelected;
    }

    public void setComprasDetalleSelected(ComprasDetalle comprasDetalleSelected) {
        this.comprasDetalleSelected = comprasDetalleSelected;
    }

    public ComprasDetalle getComprasItemDetalle() {
        return comprasItemDetalle;
    }

    public void setComprasItemDetalle(ComprasDetalle comprasItemDetalle) {
        this.comprasItemDetalle = comprasItemDetalle;
    }

    public void agregarItemADetalle() {
        if (comprasItemDetalle.getProducto() == null) {
            JsfUtil.addErrorMessage("Debe seleccionar un producto.");
            return;
        }

        if (comprasItemDetalle.getCantidad() == 0) {
            JsfUtil.addErrorMessage("La cantidad no es valida.");
            return;
        }

        if (comprasItemDetalle.getPrecioUnitario() == 0) {
            JsfUtil.addErrorMessage("EL precio no es valido.");
            return;
        }

        double importe = comprasItemDetalle.getCantidad() * comprasItemDetalle.getPrecioUnitario();
        comprasItemDetalle.setImporte(importe);

        if (comprasDetalleList.contains(comprasItemDetalle)) {
            JsfUtil.addErrorMessage("Ya existe el producto en la lista.");
        } else {
            comprasDetalleList.add(comprasItemDetalle);
            JsfUtil.addSuccessMessage("El producto se agrego a la lista.");
            comprasItemDetalle = new ComprasDetalle();
        }
    }

    public void eliminarItem(ComprasDetalle item) {
        try {
            comprasDetalleList.remove(item);
            JsfUtil.addSuccessMessage("Producto eliminado.");
        } catch (Exception e) {
        }
    }

    @Override
    public void saveNew(ActionEvent event) {
        boolean savedInvoice = false;
        double totalInvoice = 0;
        if (comprasDetalleList.isEmpty()) {
            JsfUtil.addErrorMessage("Debe agregar detalles al comprobante.");
            return;
        }

        for (ComprasDetalle dt : comprasDetalleList) {
            ComprobantesCompraDetalle ccd = new ComprobantesCompraDetalle();
            ccd.setPrecio(dt.getPrecioUnitario());
            ccd.setCantidad(dt.getCantidad());
            ccd.setImporte(dt.getImporte());
            ccd.setIdProducto(dt.getProducto().getId());
            ccd.setFechaCreacion(new Date());
            ccd.setIdCabecera(getSelected());
            comprobantesCompraDetalleList.add(ccd);
            totalInvoice = totalInvoice + dt.getImporte();
        }

        if (totalInvoice != getSelected().getTotalComprobante()) {
            JsfUtil.addErrorMessage("El monto total del comprobante no es igual al detalle.");
            return;
        }

        getSelected().setComprobantesCompraDetalleCollection(comprobantesCompraDetalleList);

        try {
            super.saveNew(event);
            savedInvoice = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.print(e);
        }

        if (savedInvoice) {
            try {
                for (ComprasDetalle dt : comprasDetalleList) {
                    Productos p = ejbProductos.find(dt.getProducto().getId());
                    p.getStock().setCantidad(dt.getCantidad());
                    p.getStock().setFechaActualizacion(new Date());
                    ejbStock.edit(p.getStock());
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.err.print(e);
            }
        }
    }

    public List<ComprasDetalle> getComprasDetalleView() {
        comprasDetalleView = new ArrayList<>();
        if (getSelected() != null) {
            for (ComprobantesCompraDetalle dt : getSelected().getComprobantesCompraDetalleCollection()) {
                ComprasDetalle cmp = new ComprasDetalle();
                cmp.setCantidad(dt.getCantidad());
                cmp.setImporte(dt.getImporte());
                cmp.setPrecioUnitario(dt.getPrecio());
                cmp.setProducto(ejbProductos.find(dt.getIdProducto()));
                comprasDetalleView.add(cmp);
            }
        }
        return comprasDetalleView;
    }

    public void setComprasDetalleView(List<ComprasDetalle> comprasDetalleView) {
        this.comprasDetalleView = comprasDetalleView;
    }

}
