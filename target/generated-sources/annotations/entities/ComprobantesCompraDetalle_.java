package entities;

import entities.ComprobantesCompraCabecera;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-05-28T18:46:58")
@StaticMetamodel(ComprobantesCompraDetalle.class)
public class ComprobantesCompraDetalle_ { 

    public static volatile SingularAttribute<ComprobantesCompraDetalle, Double> precio;
    public static volatile SingularAttribute<ComprobantesCompraDetalle, ComprobantesCompraCabecera> idCabecera;
    public static volatile SingularAttribute<ComprobantesCompraDetalle, Date> fechaCreacion;
    public static volatile SingularAttribute<ComprobantesCompraDetalle, Date> fechaActualizacion;
    public static volatile SingularAttribute<ComprobantesCompraDetalle, Integer> id;
    public static volatile SingularAttribute<ComprobantesCompraDetalle, Integer> idProducto;
    public static volatile SingularAttribute<ComprobantesCompraDetalle, Double> cantidad;
    public static volatile SingularAttribute<ComprobantesCompraDetalle, Double> importe;

}