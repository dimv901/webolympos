package entities;

import entities.Circuitos;
import entities.Ciudades;
import entities.Departamentos;
import entities.FormasPago;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-09-03T12:39:48")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile SingularAttribute<Clientes, String> ruc;
    public static volatile SingularAttribute<Clientes, Boolean> domingo;
    public static volatile SingularAttribute<Clientes, Boolean> miercoles;
    public static volatile SingularAttribute<Clientes, String> emailTitular;
    public static volatile SingularAttribute<Clientes, Boolean> martes;
    public static volatile SingularAttribute<Clientes, Circuitos> idCircuito;
    public static volatile SingularAttribute<Clientes, String> contactoTitular;
    public static volatile SingularAttribute<Clientes, Integer> horaVisita;
    public static volatile SingularAttribute<Clientes, Ciudades> idCiudad;
    public static volatile SingularAttribute<Clientes, Departamentos> idDepartamento;
    public static volatile SingularAttribute<Clientes, Double> longitud;
    public static volatile SingularAttribute<Clientes, String> razonSocial;
    public static volatile SingularAttribute<Clientes, Boolean> geolocalizado;
    public static volatile SingularAttribute<Clientes, Boolean> sabado;
    public static volatile SingularAttribute<Clientes, Integer> id;
    public static volatile SingularAttribute<Clientes, Boolean> lunes;
    public static volatile SingularAttribute<Clientes, String> telefonoNegocio;
    public static volatile SingularAttribute<Clientes, Double> latitud;
    public static volatile SingularAttribute<Clientes, String> barrio;
    public static volatile SingularAttribute<Clientes, FormasPago> idFormaPago;
    public static volatile SingularAttribute<Clientes, String> callePrincipal;
    public static volatile SingularAttribute<Clientes, Integer> numeroCasa;
    public static volatile SingularAttribute<Clientes, Boolean> jueves;
    public static volatile SingularAttribute<Clientes, String> nombreTitular;
    public static volatile SingularAttribute<Clientes, Boolean> viernes;
    public static volatile SingularAttribute<Clientes, String> fotoUrl;
    public static volatile SingularAttribute<Clientes, Boolean> tieneFoto;
    public static volatile SingularAttribute<Clientes, byte[]> foto;
    public static volatile SingularAttribute<Clientes, String> cedulaTitular;
    public static volatile SingularAttribute<Clientes, String> emailNegocio;
    public static volatile SingularAttribute<Clientes, Date> fechaCreacion;
    public static volatile SingularAttribute<Clientes, Date> fechaActualizacion;
    public static volatile SingularAttribute<Clientes, String> calleSecundaria;
    public static volatile SingularAttribute<Clientes, String> nombreNegocio;
    public static volatile SingularAttribute<Clientes, String> referencia;

}