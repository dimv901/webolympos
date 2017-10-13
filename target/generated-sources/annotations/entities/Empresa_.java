package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-09-03T12:39:49")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile SingularAttribute<Empresa, String> nombreFantasia;
    public static volatile SingularAttribute<Empresa, String> ruc;
    public static volatile SingularAttribute<Empresa, String> razonSocial;
    public static volatile SingularAttribute<Empresa, String> direccion;
    public static volatile SingularAttribute<Empresa, Date> fechaCreacion;
    public static volatile SingularAttribute<Empresa, Date> fechaActualizacion;
    public static volatile SingularAttribute<Empresa, Integer> id;
    public static volatile SingularAttribute<Empresa, String> telefono;
    public static volatile SingularAttribute<Empresa, String> email;

}