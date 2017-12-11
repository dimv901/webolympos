package entities;

import entities.InventarioDetalle;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-12-11T13:40:41")
@StaticMetamodel(InventarioCabecera.class)
public class InventarioCabecera_ { 

    public static volatile SingularAttribute<InventarioCabecera, Date> fechaCierre;
    public static volatile SingularAttribute<InventarioCabecera, String> estado;
    public static volatile CollectionAttribute<InventarioCabecera, InventarioDetalle> inventarioDetalleCollection;
    public static volatile SingularAttribute<InventarioCabecera, Date> fechaInventario;
    public static volatile SingularAttribute<InventarioCabecera, Integer> id;

}