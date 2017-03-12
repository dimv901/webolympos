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
import javax.persistence.Lob;
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
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findById", query = "SELECT p FROM Productos p WHERE p.id = :id")
    , @NamedQuery(name = "Productos.findByDescripcion", query = "SELECT p FROM Productos p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Productos.findByCodigoBarra", query = "SELECT p FROM Productos p WHERE p.codigoBarra = :codigoBarra")
    , @NamedQuery(name = "Productos.findByActivo", query = "SELECT p FROM Productos p WHERE p.activo = :activo")
    , @NamedQuery(name = "Productos.findByPrecioVenta", query = "SELECT p FROM Productos p WHERE p.precioVenta = :precioVenta")
    , @NamedQuery(name = "Productos.findByPrecioCosto", query = "SELECT p FROM Productos p WHERE p.precioCosto = :precioCosto")
    , @NamedQuery(name = "Productos.findByUrlImagen", query = "SELECT p FROM Productos p WHERE p.urlImagen = :urlImagen")
    , @NamedQuery(name = "Productos.findByFechaCreacion", query = "SELECT p FROM Productos p WHERE p.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Productos.findByFechaActualizacion", query = "SELECT p FROM Productos p WHERE p.fechaActualizacion = :fechaActualizacion")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 100)
    @Column(name = "codigo_barra")
    private String codigoBarra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_venta")
    private double precioVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_costo")
    private double precioCosto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "url_imagen")
    private String urlImagen;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<PedidosDetalle> pedidosDetalleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<Stock> stockCollection;
    @JoinColumn(name = "id_producto_familia", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductoFamilias idProductoFamilia;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proveedores idProveedor;
    @JoinColumn(name = "id_tipo_impuesto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoImpuestos idTipoImpuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<MovimientoStock> movimientoStockCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<ComprobantesVentaDetalle> comprobantesVentaDetalleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<OrdenCompraDetalle> ordenCompraDetalleCollection;

    public Productos() {
    }

    public Productos(Integer id) {
        this.id = id;
    }

    public Productos(Integer id, byte[] foto, String descripcion, boolean activo, double precioVenta, double precioCosto, String urlImagen) {
        this.id = id;
        this.foto = foto;
        this.descripcion = descripcion;
        this.activo = activo;
        this.precioVenta = precioVenta;
        this.precioCosto = precioCosto;
        this.urlImagen = urlImagen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
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

    @XmlTransient
    public Collection<PedidosDetalle> getPedidosDetalleCollection() {
        return pedidosDetalleCollection;
    }

    public void setPedidosDetalleCollection(Collection<PedidosDetalle> pedidosDetalleCollection) {
        this.pedidosDetalleCollection = pedidosDetalleCollection;
    }

    @XmlTransient
    public Collection<Stock> getStockCollection() {
        return stockCollection;
    }

    public void setStockCollection(Collection<Stock> stockCollection) {
        this.stockCollection = stockCollection;
    }

    public ProductoFamilias getIdProductoFamilia() {
        return idProductoFamilia;
    }

    public void setIdProductoFamilia(ProductoFamilias idProductoFamilia) {
        this.idProductoFamilia = idProductoFamilia;
    }

    public Proveedores getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedores idProveedor) {
        this.idProveedor = idProveedor;
    }

    public TipoImpuestos getIdTipoImpuesto() {
        return idTipoImpuesto;
    }

    public void setIdTipoImpuesto(TipoImpuestos idTipoImpuesto) {
        this.idTipoImpuesto = idTipoImpuesto;
    }

    @XmlTransient
    public Collection<MovimientoStock> getMovimientoStockCollection() {
        return movimientoStockCollection;
    }

    public void setMovimientoStockCollection(Collection<MovimientoStock> movimientoStockCollection) {
        this.movimientoStockCollection = movimientoStockCollection;
    }

    @XmlTransient
    public Collection<ComprobantesVentaDetalle> getComprobantesVentaDetalleCollection() {
        return comprobantesVentaDetalleCollection;
    }

    public void setComprobantesVentaDetalleCollection(Collection<ComprobantesVentaDetalle> comprobantesVentaDetalleCollection) {
        this.comprobantesVentaDetalleCollection = comprobantesVentaDetalleCollection;
    }

    @XmlTransient
    public Collection<OrdenCompraDetalle> getOrdenCompraDetalleCollection() {
        return ordenCompraDetalleCollection;
    }

    public void setOrdenCompraDetalleCollection(Collection<OrdenCompraDetalle> ordenCompraDetalleCollection) {
        this.ordenCompraDetalleCollection = ordenCompraDetalleCollection;
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
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Productos[ id=" + id + " ]";
    }
    
}
