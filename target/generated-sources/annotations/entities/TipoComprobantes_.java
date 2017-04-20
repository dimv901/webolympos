package entities;

import entities.ComprobantesCompraCabecera;
import entities.ComprobantesVentaCabecera;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-17T10:40:54")
@StaticMetamodel(TipoComprobantes.class)
public class TipoComprobantes_ { 

    public static volatile SingularAttribute<TipoComprobantes, String> descripcion;
    public static volatile CollectionAttribute<TipoComprobantes, ComprobantesVentaCabecera> comprobantesVentaCabeceraCollection;
    public static volatile CollectionAttribute<TipoComprobantes, ComprobantesCompraCabecera> comprobantesCompraCabeceraCollection;
    public static volatile SingularAttribute<TipoComprobantes, Date> fechaCreacion;
    public static volatile SingularAttribute<TipoComprobantes, Date> fechaActualizacion;
    public static volatile SingularAttribute<TipoComprobantes, Integer> id;

}