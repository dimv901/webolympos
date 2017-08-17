package entities;

import entities.Productos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-08-16T23:45:36")
@StaticMetamodel(TipoImpuestos.class)
public class TipoImpuestos_ { 

    public static volatile SingularAttribute<TipoImpuestos, String> descripcion;
    public static volatile SingularAttribute<TipoImpuestos, Double> valor;
    public static volatile CollectionAttribute<TipoImpuestos, Productos> productosCollection;
    public static volatile SingularAttribute<TipoImpuestos, Date> fechaCreacion;
    public static volatile SingularAttribute<TipoImpuestos, Date> fechaActualizacion;
    public static volatile SingularAttribute<TipoImpuestos, Integer> id;

}