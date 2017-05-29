package entities;

import entities.OrdenCompraCabecera;
import entities.Productos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-05-28T18:46:58")
@StaticMetamodel(OrdenCompraDetalle.class)
public class OrdenCompraDetalle_ { 

    public static volatile SingularAttribute<OrdenCompraDetalle, Double> precio;
    public static volatile SingularAttribute<OrdenCompraDetalle, OrdenCompraCabecera> idCabecera;
    public static volatile SingularAttribute<OrdenCompraDetalle, Date> fechaCreacion;
    public static volatile SingularAttribute<OrdenCompraDetalle, Date> fechaActualizacion;
    public static volatile SingularAttribute<OrdenCompraDetalle, Integer> id;
    public static volatile SingularAttribute<OrdenCompraDetalle, Double> cantidad;
    public static volatile SingularAttribute<OrdenCompraDetalle, Productos> idProducto;
    public static volatile SingularAttribute<OrdenCompraDetalle, Double> importe;

}