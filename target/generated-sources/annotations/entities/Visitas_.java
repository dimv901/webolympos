package entities;

import entities.Clientes;
import entities.MotivosNoCompra;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-12-11T13:40:41")
@StaticMetamodel(Visitas.class)
public class Visitas_ { 

    public static volatile SingularAttribute<Visitas, Double> latitud;
    public static volatile SingularAttribute<Visitas, Double> longitud;
    public static volatile SingularAttribute<Visitas, Clientes> idCliente;
    public static volatile SingularAttribute<Visitas, Date> fechaCreacion;
    public static volatile SingularAttribute<Visitas, Date> fechaActualizacion;
    public static volatile SingularAttribute<Visitas, MotivosNoCompra> idMotivo;
    public static volatile SingularAttribute<Visitas, Integer> id;

}