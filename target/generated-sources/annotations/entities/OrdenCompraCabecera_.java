package entities;

import entities.OrdenCompraDetalle;
import entities.Proveedores;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-12T19:43:26")
@StaticMetamodel(OrdenCompraCabecera.class)
public class OrdenCompraCabecera_ { 

    public static volatile SingularAttribute<OrdenCompraCabecera, Date> fecha;
    public static volatile SingularAttribute<OrdenCompraCabecera, Double> total;
    public static volatile SingularAttribute<OrdenCompraCabecera, Proveedores> idProveedor;
    public static volatile SingularAttribute<OrdenCompraCabecera, Date> fechaCreacion;
    public static volatile SingularAttribute<OrdenCompraCabecera, Date> fechaActualizacion;
    public static volatile SingularAttribute<OrdenCompraCabecera, Integer> id;
    public static volatile CollectionAttribute<OrdenCompraCabecera, OrdenCompraDetalle> ordenCompraDetalleCollection;

}