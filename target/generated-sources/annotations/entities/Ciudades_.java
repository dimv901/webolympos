package entities;

import entities.Clientes;
import entities.Departamentos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-09-03T12:39:49")
@StaticMetamodel(Ciudades.class)
public class Ciudades_ { 

    public static volatile SingularAttribute<Ciudades, String> descripcion;
    public static volatile SingularAttribute<Ciudades, Departamentos> idDepartamento;
    public static volatile SingularAttribute<Ciudades, Date> fechaCreacion;
    public static volatile SingularAttribute<Ciudades, Date> fechaActualizacion;
    public static volatile CollectionAttribute<Ciudades, Clientes> clientesCollection;
    public static volatile SingularAttribute<Ciudades, Integer> id;

}