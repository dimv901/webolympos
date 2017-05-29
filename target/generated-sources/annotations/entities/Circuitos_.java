package entities;

import entities.Clientes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-05-28T18:46:57")
@StaticMetamodel(Circuitos.class)
public class Circuitos_ { 

    public static volatile SingularAttribute<Circuitos, String> descripcion;
    public static volatile SingularAttribute<Circuitos, String> codigo;
    public static volatile SingularAttribute<Circuitos, Date> fechaCreacion;
    public static volatile SingularAttribute<Circuitos, Date> fechaActualizacion;
    public static volatile CollectionAttribute<Circuitos, Clientes> clientesCollection;
    public static volatile SingularAttribute<Circuitos, Integer> id;

}