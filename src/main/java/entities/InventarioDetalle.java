/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "inventario_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventarioDetalle.findAll", query = "SELECT i FROM InventarioDetalle i")
    , @NamedQuery(name = "InventarioDetalle.findById", query = "SELECT i FROM InventarioDetalle i WHERE i.id = :id")
    , @NamedQuery(name = "InventarioDetalle.findByCantidadActual", query = "SELECT i FROM InventarioDetalle i WHERE i.cantidadActual = :cantidadActual")
    , @NamedQuery(name = "InventarioDetalle.findByCantidadRegistrada", query = "SELECT i FROM InventarioDetalle i WHERE i.cantidadRegistrada = :cantidadRegistrada")
    , @NamedQuery(name = "InventarioDetalle.findByCantidadDiferencia", query = "SELECT i FROM InventarioDetalle i WHERE i.cantidadDiferencia = :cantidadDiferencia")})
public class InventarioDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_actual")
    private double cantidadActual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_registrada")
    private double cantidadRegistrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_diferencia")
    private double cantidadDiferencia;
    @JoinColumn(name = "id_cabecera", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InventarioCabecera idCabecera;
    @JoinColumn(name = "id_producto_familia", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductoFamilias idProductoFamilia;
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Productos idProducto;

    public InventarioDetalle() {
    }

    public InventarioDetalle(Integer id) {
        this.id = id;
    }

    public InventarioDetalle(Integer id, double cantidadActual, double cantidadRegistrada, double cantidadDiferencia) {
        this.id = id;
        this.cantidadActual = cantidadActual;
        this.cantidadRegistrada = cantidadRegistrada;
        this.cantidadDiferencia = cantidadDiferencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(double cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public double getCantidadRegistrada() {
        return cantidadRegistrada;
    }

    public void setCantidadRegistrada(double cantidadRegistrada) {
        this.cantidadRegistrada = cantidadRegistrada;
    }

    public double getCantidadDiferencia() {
        return cantidadDiferencia;
    }

    public void setCantidadDiferencia(double cantidadDiferencia) {
        this.cantidadDiferencia = cantidadDiferencia;
    }

    public InventarioCabecera getIdCabecera() {
        return idCabecera;
    }

    public void setIdCabecera(InventarioCabecera idCabecera) {
        this.idCabecera = idCabecera;
    }

    public ProductoFamilias getIdProductoFamilia() {
        return idProductoFamilia;
    }

    public void setIdProductoFamilia(ProductoFamilias idProductoFamilia) {
        this.idProductoFamilia = idProductoFamilia;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
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
        if (!(object instanceof InventarioDetalle)) {
            return false;
        }
        InventarioDetalle other = (InventarioDetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InventarioDetalle{" + "id=" + id + ", cantidadActual=" + cantidadActual + ", cantidadRegistrada=" + cantidadRegistrada + ", cantidadDiferencia=" + cantidadDiferencia + ", idCabecera=" + idCabecera + ", idProductoFamilia=" + idProductoFamilia + ", idProducto=" + idProducto + '}';
    }

}
