package entities;

import entities.Clientes;
import entities.Vendedores;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-12T19:43:26")
@StaticMetamodel(Circuitos.class)
public class Circuitos_ { 

    public static volatile SingularAttribute<Circuitos, String> descripcion;
    public static volatile SingularAttribute<Circuitos, String> codigo;
    public static volatile SingularAttribute<Circuitos, Date> fechaCreacion;
    public static volatile SingularAttribute<Circuitos, Date> fechaActualizacion;
    public static volatile CollectionAttribute<Circuitos, Vendedores> vendedoresCollection;
    public static volatile CollectionAttribute<Circuitos, Clientes> clientesCollection;
    public static volatile SingularAttribute<Circuitos, Integer> id;

}