package entities;

import entities.ComprobantesCompraCabecera;
import entities.OrdenCompraCabecera;
import entities.Paises;
import entities.Productos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-17T10:40:54")
@StaticMetamodel(Proveedores.class)
public class Proveedores_ { 

    public static volatile SingularAttribute<Proveedores, String> descripcion;
    public static volatile SingularAttribute<Proveedores, String> ruc;
    public static volatile CollectionAttribute<Proveedores, ComprobantesCompraCabecera> comprobantesCompraCabeceraCollection;
    public static volatile SingularAttribute<Proveedores, Paises> idPais;
    public static volatile CollectionAttribute<Proveedores, OrdenCompraCabecera> ordenCompraCabeceraCollection;
    public static volatile SingularAttribute<Proveedores, Date> fechaActuaizacion;
    public static volatile SingularAttribute<Proveedores, String> direccion;
    public static volatile CollectionAttribute<Proveedores, Productos> productosCollection;
    public static volatile SingularAttribute<Proveedores, Date> fechaCreacion;
    public static volatile SingularAttribute<Proveedores, Integer> id;
    public static volatile SingularAttribute<Proveedores, String> telefono;
    public static volatile SingularAttribute<Proveedores, String> email;

}