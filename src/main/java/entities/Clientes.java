/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findById", query = "SELECT c FROM Clientes c WHERE c.id = :id")
    , @NamedQuery(name = "Clientes.findByNombreTitular", query = "SELECT c FROM Clientes c WHERE c.nombreTitular = :nombreTitular")
    , @NamedQuery(name = "Clientes.findByCedulaTitular", query = "SELECT c FROM Clientes c WHERE c.cedulaTitular = :cedulaTitular")
    , @NamedQuery(name = "Clientes.findByContactoTitular", query = "SELECT c FROM Clientes c WHERE c.contactoTitular = :contactoTitular")
    , @NamedQuery(name = "Clientes.findByEmail", query = "SELECT c FROM Clientes c WHERE c.email = :email")
    , @NamedQuery(name = "Clientes.findByRazonSocial", query = "SELECT c FROM Clientes c WHERE c.razonSocial = :razonSocial")
    , @NamedQuery(name = "Clientes.findByNombreNegocio", query = "SELECT c FROM Clientes c WHERE c.nombreNegocio = :nombreNegocio")
    , @NamedQuery(name = "Clientes.findByRuc", query = "SELECT c FROM Clientes c WHERE c.ruc = :ruc")
    , @NamedQuery(name = "Clientes.findByBarrio", query = "SELECT c FROM Clientes c WHERE c.barrio = :barrio")
    , @NamedQuery(name = "Clientes.findByCallePrincipal", query = "SELECT c FROM Clientes c WHERE c.callePrincipal = :callePrincipal")
    , @NamedQuery(name = "Clientes.findByCalleSecundaria", query = "SELECT c FROM Clientes c WHERE c.calleSecundaria = :calleSecundaria")
    , @NamedQuery(name = "Clientes.findByNumeroCasa", query = "SELECT c FROM Clientes c WHERE c.numeroCasa = :numeroCasa")
    , @NamedQuery(name = "Clientes.findByReferencia", query = "SELECT c FROM Clientes c WHERE c.referencia = :referencia")
    , @NamedQuery(name = "Clientes.findByGeolocalizado", query = "SELECT c FROM Clientes c WHERE c.geolocalizado = :geolocalizado")
    , @NamedQuery(name = "Clientes.findByLatitude", query = "SELECT c FROM Clientes c WHERE c.latitude = :latitude")
    , @NamedQuery(name = "Clientes.findByLongitud", query = "SELECT c FROM Clientes c WHERE c.longitud = :longitud")
    , @NamedQuery(name = "Clientes.findByFechaCreacion", query = "SELECT c FROM Clientes c WHERE c.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Clientes.findByFechaActualizacion", query = "SELECT c FROM Clientes c WHERE c.fechaActualizacion = :fechaActualizacion")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_titular")
    private String nombreTitular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cedula_titular")
    private String cedulaTitular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "contacto_titular")
    private String contactoTitular;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "razon_social")
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_negocio")
    private String nombreNegocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ruc")
    private String ruc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "barrio")
    private String barrio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "calle_principal")
    private String callePrincipal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "calle_secundaria")
    private String calleSecundaria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_casa")
    private int numeroCasa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "geolocalizado")
    private boolean geolocalizado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitude")
    private double latitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitud")
    private double longitud;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @JoinColumn(name = "id_circuito", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Circuitos idCircuito;
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ciudades idCiudad;
    @JoinColumn(name = "id_departamento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Departamentos idDepartamento;
    @JoinColumn(name = "id_forma_pago", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FormasPago idFormaPago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<Visitas> visitasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<ComprobantesVentaCabecera> comprobantesVentaCabeceraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<PedidosCabecera> pedidosCabeceraCollection;

    public Clientes() {
    }

    public Clientes(Integer id) {
        this.id = id;
    }

    public Clientes(Integer id, String nombreTitular, String cedulaTitular, String contactoTitular, String razonSocial, String nombreNegocio, String ruc, String barrio, String callePrincipal, String calleSecundaria, int numeroCasa, String referencia, boolean geolocalizado, double latitude, double longitud) {
        this.id = id;
        this.nombreTitular = nombreTitular;
        this.cedulaTitular = cedulaTitular;
        this.contactoTitular = contactoTitular;
        this.razonSocial = razonSocial;
        this.nombreNegocio = nombreNegocio;
        this.ruc = ruc;
        this.barrio = barrio;
        this.callePrincipal = callePrincipal;
        this.calleSecundaria = calleSecundaria;
        this.numeroCasa = numeroCasa;
        this.referencia = referencia;
        this.geolocalizado = geolocalizado;
        this.latitude = latitude;
        this.longitud = longitud;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getCedulaTitular() {
        return cedulaTitular;
    }

    public void setCedulaTitular(String cedulaTitular) {
        this.cedulaTitular = cedulaTitular;
    }

    public String getContactoTitular() {
        return contactoTitular;
    }

    public void setContactoTitular(String contactoTitular) {
        this.contactoTitular = contactoTitular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    public void setCalleSecundaria(String calleSecundaria) {
        this.calleSecundaria = calleSecundaria;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public boolean getGeolocalizado() {
        return geolocalizado;
    }

    public void setGeolocalizado(boolean geolocalizado) {
        this.geolocalizado = geolocalizado;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Circuitos getIdCircuito() {
        return idCircuito;
    }

    public void setIdCircuito(Circuitos idCircuito) {
        this.idCircuito = idCircuito;
    }

    public Ciudades getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudades idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Departamentos getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamentos idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public FormasPago getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(FormasPago idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    @XmlTransient
    public Collection<Visitas> getVisitasCollection() {
        return visitasCollection;
    }

    public void setVisitasCollection(Collection<Visitas> visitasCollection) {
        this.visitasCollection = visitasCollection;
    }

    @XmlTransient
    public Collection<ComprobantesVentaCabecera> getComprobantesVentaCabeceraCollection() {
        return comprobantesVentaCabeceraCollection;
    }

    public void setComprobantesVentaCabeceraCollection(Collection<ComprobantesVentaCabecera> comprobantesVentaCabeceraCollection) {
        this.comprobantesVentaCabeceraCollection = comprobantesVentaCabeceraCollection;
    }

    @XmlTransient
    public Collection<PedidosCabecera> getPedidosCabeceraCollection() {
        return pedidosCabeceraCollection;
    }

    public void setPedidosCabeceraCollection(Collection<PedidosCabecera> pedidosCabeceraCollection) {
        this.pedidosCabeceraCollection = pedidosCabeceraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Clientes[ id=" + id + " ]";
    }
    
}
