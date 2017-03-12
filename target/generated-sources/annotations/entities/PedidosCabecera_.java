package entities;

import entities.Clientes;
import entities.ComprobantesVentaCabecera;
import entities.PedidosDetalle;
import entities.Vendedores;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-12T19:43:26")
@StaticMetamodel(PedidosCabecera.class)
public class PedidosCabecera_ { 

    public static volatile SingularAttribute<PedidosCabecera, Double> latitud;
    public static volatile SingularAttribute<PedidosCabecera, String> estado;
    public static volatile SingularAttribute<PedidosCabecera, Double> longitud;
    public static volatile CollectionAttribute<PedidosCabecera, PedidosDetalle> pedidosDetalleCollection;
    public static volatile CollectionAttribute<PedidosCabecera, ComprobantesVentaCabecera> comprobantesVentaCabeceraCollection;
    public static volatile SingularAttribute<PedidosCabecera, Clientes> idCliente;
    public static volatile SingularAttribute<PedidosCabecera, Vendedores> idVendedor;
    public static volatile SingularAttribute<PedidosCabecera, Date> fechaCreacion;
    public static volatile SingularAttribute<PedidosCabecera, Date> fechaActualizacion;
    public static volatile SingularAttribute<PedidosCabecera, Date> fechaPedido;
    public static volatile SingularAttribute<PedidosCabecera, Integer> id;
    public static volatile SingularAttribute<PedidosCabecera, Double> importe;

}