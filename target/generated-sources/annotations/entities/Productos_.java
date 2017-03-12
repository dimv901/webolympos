package entities;

import entities.ComprobantesVentaDetalle;
import entities.MovimientoStock;
import entities.OrdenCompraDetalle;
import entities.PedidosDetalle;
import entities.ProductoFamilias;
import entities.Proveedores;
import entities.Stock;
import entities.TipoImpuestos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-12T19:43:26")
@StaticMetamodel(Productos.class)
public class Productos_ { 

    public static volatile SingularAttribute<Productos, String> descripcion;
    public static volatile CollectionAttribute<Productos, ComprobantesVentaDetalle> comprobantesVentaDetalleCollection;
    public static volatile CollectionAttribute<Productos, Stock> stockCollection;
    public static volatile SingularAttribute<Productos, TipoImpuestos> idTipoImpuesto;
    public static volatile CollectionAttribute<Productos, MovimientoStock> movimientoStockCollection;
    public static volatile CollectionAttribute<Productos, OrdenCompraDetalle> ordenCompraDetalleCollection;
    public static volatile SingularAttribute<Productos, Double> precioCosto;
    public static volatile SingularAttribute<Productos, String> urlImagen;
    public static volatile SingularAttribute<Productos, String> codigoBarra;
    public static volatile CollectionAttribute<Productos, PedidosDetalle> pedidosDetalleCollection;
    public static volatile SingularAttribute<Productos, byte[]> foto;
    public static volatile SingularAttribute<Productos, Proveedores> idProveedor;
    public static volatile SingularAttribute<Productos, Date> fechaCreacion;
    public static volatile SingularAttribute<Productos, Date> fechaActualizacion;
    public static volatile SingularAttribute<Productos, Integer> id;
    public static volatile SingularAttribute<Productos, Double> precioVenta;
    public static volatile SingularAttribute<Productos, ProductoFamilias> idProductoFamilia;
    public static volatile SingularAttribute<Productos, Boolean> activo;

}