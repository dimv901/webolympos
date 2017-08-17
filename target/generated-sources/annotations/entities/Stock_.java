package entities;

import entities.Productos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-08-16T23:45:36")
@StaticMetamodel(Stock.class)
public class Stock_ { 

    public static volatile SingularAttribute<Stock, Date> fechaCreacion;
    public static volatile SingularAttribute<Stock, Date> fechaActualizacion;
    public static volatile SingularAttribute<Stock, Integer> id;
    public static volatile SingularAttribute<Stock, Double> cantidad;
    public static volatile SingularAttribute<Stock, Productos> stock;

}