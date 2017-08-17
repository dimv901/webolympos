package entities;

import entities.ComprobantesCompraDetalle;
import entities.Proveedores;
import entities.TipoComprobantes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-08-16T23:45:36")
@StaticMetamodel(ComprobantesCompraCabecera.class)
public class ComprobantesCompraCabecera_ { 

    public static volatile SingularAttribute<ComprobantesCompraCabecera, Double> totalGravadas10;
    public static volatile SingularAttribute<ComprobantesCompraCabecera, String> numeroComprobante;
    public static volatile SingularAttribute<ComprobantesCompraCabecera, Double> totalGravadas5;
    public static volatile SingularAttribute<ComprobantesCompraCabecera, Date> fechaComprobante;
    public static volatile CollectionAttribute<ComprobantesCompraCabecera, ComprobantesCompraDetalle> comprobantesCompraDetalleCollection;
    public static volatile SingularAttribute<ComprobantesCompraCabecera, Double> totalIva10;
    public static volatile SingularAttribute<ComprobantesCompraCabecera, Double> totalExentas;
    public static volatile SingularAttribute<ComprobantesCompraCabecera, TipoComprobantes> idTipoComprobante;
    public static volatile SingularAttribute<ComprobantesCompraCabecera, Double> totalIva5;
    public static volatile SingularAttribute<ComprobantesCompraCabecera, Proveedores> idProveedor;
    public static volatile SingularAttribute<ComprobantesCompraCabecera, Date> fechaActualizacion;
    public static volatile SingularAttribute<ComprobantesCompraCabecera, Date> fechaCreacion;
    public static volatile SingularAttribute<ComprobantesCompraCabecera, Integer> id;
    public static volatile SingularAttribute<ComprobantesCompraCabecera, Double> totalComprobante;

}