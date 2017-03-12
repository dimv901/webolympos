package entities;

import entities.Circuitos;
import entities.Ciudades;
import entities.ComprobantesVentaCabecera;
import entities.Departamentos;
import entities.FormasPago;
import entities.PedidosCabecera;
import entities.Visitas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-12T19:43:26")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile SingularAttribute<Clientes, String> ruc;
    public static volatile SingularAttribute<Clientes, Double> latitude;
    public static volatile SingularAttribute<Clientes, Circuitos> idCircuito;
    public static volatile SingularAttribute<Clientes, String> contactoTitular;
    public static volatile SingularAttribute<Clientes, Ciudades> idCiudad;
    public static volatile SingularAttribute<Clientes, Departamentos> idDepartamento;
    public static volatile SingularAttribute<Clientes, String> razonSocial;
    public static volatile SingularAttribute<Clientes, Double> longitud;
    public static volatile SingularAttribute<Clientes, Boolean> geolocalizado;
    public static volatile SingularAttribute<Clientes, Integer> id;
    public static volatile SingularAttribute<Clientes, String> email;
    public static volatile CollectionAttribute<Clientes, Visitas> visitasCollection;
    public static volatile SingularAttribute<Clientes, String> barrio;
    public static volatile SingularAttribute<Clientes, FormasPago> idFormaPago;
    public static volatile SingularAttribute<Clientes, String> callePrincipal;
    public static volatile SingularAttribute<Clientes, Integer> numeroCasa;
    public static volatile SingularAttribute<Clientes, String> nombreTitular;
    public static volatile CollectionAttribute<Clientes, ComprobantesVentaCabecera> comprobantesVentaCabeceraCollection;
    public static volatile SingularAttribute<Clientes, String> cedulaTitular;
    public static volatile SingularAttribute<Clientes, Date> fechaCreacion;
    public static volatile SingularAttribute<Clientes, Date> fechaActualizacion;
    public static volatile CollectionAttribute<Clientes, PedidosCabecera> pedidosCabeceraCollection;
    public static volatile SingularAttribute<Clientes, String> calleSecundaria;
    public static volatile SingularAttribute<Clientes, String> nombreNegocio;
    public static volatile SingularAttribute<Clientes, String> referencia;

}