package entities;

import entities.Ciudades;
import entities.Clientes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-05-28T18:46:58")
@StaticMetamodel(Departamentos.class)
public class Departamentos_ { 

    public static volatile SingularAttribute<Departamentos, String> descripcion;
    public static volatile SingularAttribute<Departamentos, Date> fechaCreacion;
    public static volatile SingularAttribute<Departamentos, Date> fechaActualizacion;
    public static volatile CollectionAttribute<Departamentos, Clientes> clientesCollection;
    public static volatile SingularAttribute<Departamentos, Integer> id;
    public static volatile CollectionAttribute<Departamentos, Ciudades> ciudadesCollection;

}