package entities;

import entities.Productos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-09-03T12:39:49")
@StaticMetamodel(ProductoFamilias.class)
public class ProductoFamilias_ { 

    public static volatile SingularAttribute<ProductoFamilias, String> descripcion;
    public static volatile CollectionAttribute<ProductoFamilias, Productos> productosCollection;
    public static volatile SingularAttribute<ProductoFamilias, Date> fechaCreacion;
    public static volatile SingularAttribute<ProductoFamilias, Date> fechaActualizacion;
    public static volatile SingularAttribute<ProductoFamilias, Integer> id;

}