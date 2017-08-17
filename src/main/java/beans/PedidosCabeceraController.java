package beans;

import beans.util.ComprasDetalle;
import beans.util.JsfUtil;
import controllers.ProductosFacade;
import controllers.StockFacade;
import controllers.VendedoresFacade;
import entities.PedidosCabecera;
import entities.PedidosDetalle;
import entities.Productos;
import entities.Stock;
import entities.Vendedores;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utils.SessionUtils;

@Named(value = "pedidosCabeceraController")
@ViewScoped
public class PedidosCabeceraController extends AbstractController<PedidosCabecera> {

    @PersistenceContext(unitName = "py.com.fpuna_WebOlympos_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    @EJB
    private ProductosFacade productosService;
    @EJB
    private StockFacade stockService;
    @EJB
    private VendedoresFacade vendedoresService;

    private Productos producto;
    private List<Productos> productoList;
    private double totalPedido;

    private List<ComprasDetalle> pedidosDetalleView;
    private ComprasDetalle pedidosItemDetalle;
    private List<ComprasDetalle> pedidosDetalleList;
    private ComprasDetalle pedidosDetalleSelected;
    private List<PedidosDetalle> pedidosDetalleCaberaList;
    private Vendedores vendedor;

    public PedidosCabeceraController() {
        // Inform the Abstract parent controller of the concrete PedidosCabecera Entity
        super(PedidosCabecera.class);
        pedidosDetalleList = new ArrayList<>();
        pedidosItemDetalle = new ComprasDetalle();
        pedidosDetalleCaberaList = new ArrayList<>();

    }

    /*@PostConstruct
    public void init() {
        checkVendedor();
    }*/

    private boolean checkVendedor() {
        boolean isVendor = false;
        Query qVendedor = em.createNamedQuery("Vendedores.findByCedula");
        qVendedor.setParameter("cedula", SessionUtils.getUserName());
        try {
            Vendedores v = (Vendedores) qVendedor.getSingleResult();
            if (v != null) {
                System.out.println("vendedor no nulo");
                setVendedor(v);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public PedidosCabecera prepareCreate(ActionEvent event) {
        if (!checkVendedor()) {
            JsfUtil.addErrorMessage("Su usuario no cuenta con perfil de vendedor");
        } else {
            pedidosDetalleList = new ArrayList<>();
            pedidosItemDetalle = new ComprasDetalle();
            pedidosDetalleCaberaList = new ArrayList<>();
            return super.prepareCreate(event); //To change body of generated methods, choose Tools | Templates.
        }
        return null;
    }

    public Vendedores getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedores vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public void delete(ActionEvent event) {
        for (PedidosDetalle detalle : getSelected().getPedidosDetalleCollection()) {
            Query qProducto = em.createNamedQuery("Productos.findById");
            qProducto.setParameter("id", detalle.getIdProducto().getId());
            try {
                Productos p = (Productos) qProducto.getSingleResult();
                if (p != null) {
                    Stock s = p.getStock();
                    double currentStock = s.getCantidad() + detalle.getCantidad();
                    s.setCantidad(currentStock);
                    stockService.edit(s);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        super.delete(event); //To change body of generated methods, choose Tools | Templates.
    }

    public List<ComprasDetalle> getPedidosDetalleView() {
        pedidosDetalleView = new ArrayList<>();
        if (getSelected() != null) {
            if (getSelected().getPedidosDetalleCollection() != null) {
                for (PedidosDetalle pd : getSelected().getPedidosDetalleCollection()) {
                    ComprasDetalle cmp = new ComprasDetalle();
                    cmp.setCantidad(pd.getCantidad());
                    cmp.setImporte(pd.getImporte());
                    cmp.setPrecioUnitario(pd.getPrecio());
                    cmp.setProducto(productosService.find(pd.getIdProducto().getId()));
                    pedidosDetalleView.add(cmp);
                }
            }

        }
        return pedidosDetalleView;
    }

    public void setPedidosDetalleView(List<ComprasDetalle> pedidosDetalleView) {
        this.pedidosDetalleView = pedidosDetalleView;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public List<Productos> getProductoList() {
        if (productoList == null) {
            productoList = productosService.findAll();
        }
        return productoList;
    }

    public void setProductoList(List<Productos> productoList) {
        this.productoList = productoList;
    }

    public ComprasDetalle getPedidosItemDetalle() {
        return pedidosItemDetalle;
    }

    public void setPedidosItemDetalle(ComprasDetalle pedidosItemDetalle) {
        this.pedidosItemDetalle = pedidosItemDetalle;
    }

    public List<ComprasDetalle> getPedidosDetalleList() {
        return pedidosDetalleList;
    }

    public void setPedidosDetalleList(List<ComprasDetalle> pedidosDetalleList) {
        this.pedidosDetalleList = pedidosDetalleList;
    }

    public ComprasDetalle getPedidosDetalleSelected() {
        return pedidosDetalleSelected;
    }

    public void setPedidosDetalleSelected(ComprasDetalle pedidosDetalleSelected) {
        this.pedidosDetalleSelected = pedidosDetalleSelected;
    }

    public void estimateTotal() {
        double total = 0;
        for (ComprasDetalle dt : pedidosDetalleList) {
            total = total + dt.getImporte();
        }
        setTotalPedido(total);
    }

    public void agregarItemADetalle() {
        if (pedidosItemDetalle.getProducto() == null) {
            JsfUtil.addErrorMessage("Debe seleccionar un producto.");
            return;
        }

        if (pedidosItemDetalle.getCantidad() == null || pedidosItemDetalle.getCantidad() == 0) {
            JsfUtil.addErrorMessage("La cantidad no es valida.");
            return;
        }

        double importe = pedidosItemDetalle.getCantidad() * pedidosItemDetalle.getProducto().getPrecioVenta();
        pedidosItemDetalle.setImporte(importe);

        if (pedidosDetalleList.contains(pedidosItemDetalle)) {
            JsfUtil.addErrorMessage("Ya existe el producto en la lista.");
        } else {
            pedidosDetalleList.add(pedidosItemDetalle);
            JsfUtil.addSuccessMessage("El producto se agrego a la lista.");
            pedidosItemDetalle = new ComprasDetalle();
            estimateTotal();
        }
    }

    public void eliminarItem(ComprasDetalle item) {
        try {
            pedidosDetalleList.remove(item);
            JsfUtil.addSuccessMessage("Producto eliminado.");
            estimateTotal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveNew(ActionEvent event) {
        boolean savedOrder = false;
        double totalOrder = 0;
        if (pedidosDetalleList.isEmpty()) {
            JsfUtil.addErrorMessage("Debe agregar detalles al pedido.");
            return;
        }

        for (ComprasDetalle dt : pedidosDetalleList) {
            PedidosDetalle ccd = new PedidosDetalle();
            ccd.setPrecio(dt.getProducto().getPrecioVenta());
            ccd.setCantidad(dt.getCantidad());
            ccd.setImporte(dt.getImporte());
            ccd.setIdProducto(dt.getProducto());
            ccd.setFechaCreacion(new Date());
            ccd.setIdCabecera(getSelected());
            pedidosDetalleCaberaList.add(ccd);
            totalOrder = totalOrder + dt.getImporte();
        }
        getSelected().setIdVendedor(getVendedor());
        getSelected().setImporte(totalOrder);
        getSelected().setEstado("PENDIENTE");
        getSelected().setFechaPedido(new Date());
        getSelected().setFechaCreacion(new Date());
        getSelected().setPedidosDetalleCollection(pedidosDetalleCaberaList);

        try {
            super.saveNew(event);
            savedOrder = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.print(e);
        }

        if (savedOrder) {
            try {
                for (ComprasDetalle dt : pedidosDetalleList) {
                    Productos p = productosService.find(dt.getProducto().getId());
                    double currentStock = p.getStock().getCantidad() - dt.getCantidad();
                    p.getStock().setCantidad(currentStock);
                    p.getStock().setFechaActualizacion(new Date());
                    stockService.edit(p.getStock());
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.err.print(e);
            }
        }
    }

    public List<PedidosDetalle> getPedidosDetalleCaberaList() {
        return pedidosDetalleCaberaList;
    }

    public void setPedidosDetalleCaberaList(List<PedidosDetalle> pedidosDetalleCaberaList) {
        this.pedidosDetalleCaberaList = pedidosDetalleCaberaList;
    }

    public double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(double totalPedido) {
        this.totalPedido = totalPedido;
    }

}
