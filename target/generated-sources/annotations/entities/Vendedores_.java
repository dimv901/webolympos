package entities;

import entities.Circuitos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-08-16T23:45:36")
@StaticMetamodel(Vendedores.class)
public class Vendedores_ { 

    public static volatile SingularAttribute<Vendedores, String> descripcion;
    public static volatile SingularAttribute<Vendedores, String> cedula;
    public static volatile SingularAttribute<Vendedores, String> apellido;
    public static volatile SingularAttribute<Vendedores, Boolean> android;
    public static volatile SingularAttribute<Vendedores, Date> fechaCreacion;
    public static volatile SingularAttribute<Vendedores, Date> fechaActualizacion;
    public static volatile SingularAttribute<Vendedores, Integer> id;
    public static volatile SingularAttribute<Vendedores, Circuitos> idCircuito;
    public static volatile SingularAttribute<Vendedores, String> telefonoContacto;
    public static volatile SingularAttribute<Vendedores, String> nombre;
    public static volatile SingularAttribute<Vendedores, Boolean> activo;

}