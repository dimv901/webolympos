package entities;

import entities.Clientes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-12-11T13:40:41")
@StaticMetamodel(FormasPago.class)
public class FormasPago_ { 

    public static volatile SingularAttribute<FormasPago, String> descripcion;
    public static volatile SingularAttribute<FormasPago, Date> fechaActalizacion;
    public static volatile SingularAttribute<FormasPago, Date> fechaCreacion;
    public static volatile CollectionAttribute<FormasPago, Clientes> clientesCollection;
    public static volatile SingularAttribute<FormasPago, Integer> id;

}