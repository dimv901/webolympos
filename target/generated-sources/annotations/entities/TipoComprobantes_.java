package entities;

import entities.ComprobantesCompraCabecera;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-12-11T13:40:40")
@StaticMetamodel(TipoComprobantes.class)
public class TipoComprobantes_ { 

    public static volatile SingularAttribute<TipoComprobantes, String> descripcion;
    public static volatile CollectionAttribute<TipoComprobantes, ComprobantesCompraCabecera> comprobantesCompraCabeceraCollection;
    public static volatile SingularAttribute<TipoComprobantes, Date> fechaCreacion;
    public static volatile SingularAttribute<TipoComprobantes, Date> fechaActualizacion;
    public static volatile SingularAttribute<TipoComprobantes, Integer> id;

}