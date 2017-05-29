/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.util;

import entities.Productos;
import java.io.Serializable;

/**
 *
 * @author Diego
 */
public class ComprasDetalle implements Serializable{


    private Double precioUnitario;
    private Double importe;
    private Double cantidad;
    private Productos producto;

    public ComprasDetalle() {
    }

    

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "ComprasDetalle{" + "precioUnitario=" + precioUnitario + ", importe=" + importe + ", cantidad=" + cantidad + ", producto=" + producto + '}';
    }


}
