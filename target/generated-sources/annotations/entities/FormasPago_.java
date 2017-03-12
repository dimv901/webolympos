package entities;

import entities.Clientes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-12T19:43:26")
@StaticMetamodel(FormasPago.class)
public class FormasPago_ { 

    public static volatile SingularAttribute<FormasPago, String> descripcion;
    public static volatile SingularAttribute<FormasPago, Date> fechaActalizacion;
    public static volatile SingularAttribute<FormasPago, Date> fechaCreacion;
    public static volatile CollectionAttribute<FormasPago, Clientes> clientesCollection;
    public static volatile SingularAttribute<FormasPago, Integer> id;

}