package entities;

import entities.Proveedores;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-12-11T13:40:41")
@StaticMetamodel(Paises.class)
public class Paises_ { 

    public static volatile SingularAttribute<Paises, String> descripcion;
    public static volatile SingularAttribute<Paises, String> abreviatura;
    public static volatile CollectionAttribute<Paises, Proveedores> proveedoresCollection;
    public static volatile SingularAttribute<Paises, Date> fechaCreacion;
    public static volatile SingularAttribute<Paises, Date> fechaActualizacion;
    public static volatile SingularAttribute<Paises, Integer> id;

}