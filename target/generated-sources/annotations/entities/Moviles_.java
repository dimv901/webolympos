package entities;

import entities.Repartidores;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-12-11T13:40:40")
@StaticMetamodel(Moviles.class)
public class Moviles_ { 

    public static volatile SingularAttribute<Moviles, String> marca;
    public static volatile SingularAttribute<Moviles, String> matricula;
    public static volatile CollectionAttribute<Moviles, Repartidores> repartidoresCollection;
    public static volatile SingularAttribute<Moviles, Date> fechaCreacion;
    public static volatile SingularAttribute<Moviles, Date> fechaActualizacion;
    public static volatile SingularAttribute<Moviles, Integer> id;
    public static volatile SingularAttribute<Moviles, String> modelo;

}