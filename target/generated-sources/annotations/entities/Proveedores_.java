package entities;

import entities.ComprobantesCompraCabecera;
import entities.Paises;
import entities.Productos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-08-16T23:45:36")
@StaticMetamodel(Proveedores.class)
public class Proveedores_ { 

    public static volatile SingularAttribute<Proveedores, String> descripcion;
    public static volatile SingularAttribute<Proveedores, String> ruc;
    public static volatile CollectionAttribute<Proveedores, ComprobantesCompraCabecera> comprobantesCompraCabeceraCollection;
    public static volatile SingularAttribute<Proveedores, Paises> idPais;
    public static volatile SingularAttribute<Proveedores, Date> fechaActuaizacion;
    public static volatile SingularAttribute<Proveedores, String> direccion;
    public static volatile SingularAttribute<Proveedores, Date> fechaCreacion;
    public static volatile SingularAttribute<Proveedores, Integer> id;
    public static volatile CollectionAttribute<Proveedores, Productos> idProducto;
    public static volatile SingularAttribute<Proveedores, String> telefono;
    public static volatile SingularAttribute<Proveedores, String> email;

}