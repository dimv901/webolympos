package entities;

import entities.Moviles;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-08-16T23:45:36")
@StaticMetamodel(Repartidores.class)
public class Repartidores_ { 

    public static volatile SingularAttribute<Repartidores, String> cedula;
    public static volatile SingularAttribute<Repartidores, String> apellido;
    public static volatile SingularAttribute<Repartidores, Moviles> idMovil;
    public static volatile SingularAttribute<Repartidores, Date> fechaCreacion;
    public static volatile SingularAttribute<Repartidores, Date> fechaActualizacion;
    public static volatile SingularAttribute<Repartidores, Integer> id;
    public static volatile SingularAttribute<Repartidores, String> nombre;
    public static volatile SingularAttribute<Repartidores, Boolean> activo;

}