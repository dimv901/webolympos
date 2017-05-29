package entities;

import entities.ComprobantesVentaCabecera;
import entities.Repartidores;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-05-28T18:46:58")
@StaticMetamodel(Repartos.class)
public class Repartos_ { 

    public static volatile SingularAttribute<Repartos, Boolean> entregado;
    public static volatile SingularAttribute<Repartos, ComprobantesVentaCabecera> idComprobanteVenta;
    public static volatile SingularAttribute<Repartos, Date> fechaCreacion;
    public static volatile SingularAttribute<Repartos, Date> fechaActualizacion;
    public static volatile SingularAttribute<Repartos, Repartidores> idRepartidor;
    public static volatile SingularAttribute<Repartos, Integer> id;
    public static volatile SingularAttribute<Repartos, Date> fechaEntregado;

}