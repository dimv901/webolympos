package entities;

import entities.Visitas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-12-11T13:40:40")
@StaticMetamodel(MotivosNoCompra.class)
public class MotivosNoCompra_ { 

    public static volatile SingularAttribute<MotivosNoCompra, String> descripcion;
    public static volatile CollectionAttribute<MotivosNoCompra, Visitas> visitasCollection;
    public static volatile SingularAttribute<MotivosNoCompra, Date> fechaCreacion;
    public static volatile SingularAttribute<MotivosNoCompra, Date> fechaActualizacion;
    public static volatile SingularAttribute<MotivosNoCompra, Integer> id;

}