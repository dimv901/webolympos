package entities;

import entities.Clientes;
import entities.MotivosNoCompra;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-17T10:40:54")
@StaticMetamodel(Visitas.class)
public class Visitas_ { 

    public static volatile SingularAttribute<Visitas, Clientes> idCliente;
    public static volatile SingularAttribute<Visitas, Date> fechaCreacion;
    public static volatile SingularAttribute<Visitas, Date> fechaActualizacion;
    public static volatile SingularAttribute<Visitas, MotivosNoCompra> idMotivo;
    public static volatile SingularAttribute<Visitas, Integer> id;

}