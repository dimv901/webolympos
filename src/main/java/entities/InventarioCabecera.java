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
@Table(name = "inventario_cabecera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventarioCabecera.findAll", query = "SELECT i FROM InventarioCabecera i")
    , @NamedQuery(name = "InventarioCabecera.findById", query = "SELECT i FROM InventarioCabecera i WHERE i.id = :id")
    , @NamedQuery(name = "InventarioCabecera.findByEstado", query = "SELECT i FROM InventarioCabecera i WHERE i.estado = :estado")
    , @NamedQuery(name = "InventarioCabecera.findByFechaInventario", query = "SELECT i FROM InventarioCabecera i WHERE i.fechaInventario = :fechaInventario")
    , @NamedQuery(name = "InventarioCabecera.findByFechaCierre", query = "SELECT i FROM InventarioCabecera i WHERE i.fechaCierre = :fechaCierre")})
public class InventarioCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inventario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInventario;
    @Column(name = "fecha_cierre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCabecera")
    private Collection<InventarioDetalle> inventarioDetalleCollection;

    public InventarioCabecera() {
    }

    public InventarioCabecera(Integer id) {
        this.id = id;
    }

    public InventarioCabecera(Integer id, String estado, Date fechaInventario) {
        this.id = id;
        this.estado = estado;
        this.fechaInventario = fechaInventario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaInventario() {
        return fechaInventario;
    }

    public void setFechaInventario(Date fechaInventario) {
        this.fechaInventario = fechaInventario;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    @XmlTransient
    public Collection<InventarioDetalle> getInventarioDetalleCollection() {
        return inventarioDetalleCollection;
    }

    public void setInventarioDetalleCollection(Collection<InventarioDetalle> inventarioDetalleCollection) {
        this.inventarioDetalleCollection = inventarioDetalleCollection;
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
        if (!(object instanceof InventarioCabecera)) {
            return false;
        }
        InventarioCabecera other = (InventarioCabecera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.InventarioCabecera[ id=" + id + " ]";
    }

}
