package entities;

import entities.PedidosCabecera;
import entities.Productos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-08-16T23:45:36")
@StaticMetamodel(PedidosDetalle.class)
public class PedidosDetalle_ { 

    public static volatile SingularAttribute<PedidosDetalle, Double> precio;
    public static volatile SingularAttribute<PedidosDetalle, PedidosCabecera> idCabecera;
    public static volatile SingularAttribute<PedidosDetalle, Date> fechaCreacion;
    public static volatile SingularAttribute<PedidosDetalle, Date> fechaActualizacion;
    public static volatile SingularAttribute<PedidosDetalle, Integer> id;
    public static volatile SingularAttribute<PedidosDetalle, Double> cantidad;
    public static volatile SingularAttribute<PedidosDetalle, Productos> idProducto;
    public static volatile SingularAttribute<PedidosDetalle, Double> importe;

}