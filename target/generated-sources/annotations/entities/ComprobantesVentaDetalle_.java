package entities;

import entities.ComprobantesVentaCabecera;
import entities.Productos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-12-11T13:40:41")
@StaticMetamodel(ComprobantesVentaDetalle.class)
public class ComprobantesVentaDetalle_ { 

    public static volatile SingularAttribute<ComprobantesVentaDetalle, Double> precio;
    public static volatile SingularAttribute<ComprobantesVentaDetalle, ComprobantesVentaCabecera> idCabecera;
    public static volatile SingularAttribute<ComprobantesVentaDetalle, Date> fechaCreacion;
    public static volatile SingularAttribute<ComprobantesVentaDetalle, Date> fechaActualizacion;
    public static volatile SingularAttribute<ComprobantesVentaDetalle, Integer> id;
    public static volatile SingularAttribute<ComprobantesVentaDetalle, Double> cantidad;
    public static volatile SingularAttribute<ComprobantesVentaDetalle, Productos> idProducto;
    public static volatile SingularAttribute<ComprobantesVentaDetalle, Double> importe;

}