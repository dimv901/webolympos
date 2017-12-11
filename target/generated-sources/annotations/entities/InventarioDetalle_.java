package entities;

import entities.InventarioCabecera;
import entities.ProductoFamilias;
import entities.Productos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-12-11T13:40:41")
@StaticMetamodel(InventarioDetalle.class)
public class InventarioDetalle_ { 

    public static volatile SingularAttribute<InventarioDetalle, Double> cantidadActual;
    public static volatile SingularAttribute<InventarioDetalle, InventarioCabecera> idCabecera;
    public static volatile SingularAttribute<InventarioDetalle, Integer> id;
    public static volatile SingularAttribute<InventarioDetalle, Double> cantidadRegistrada;
    public static volatile SingularAttribute<InventarioDetalle, Productos> idProducto;
    public static volatile SingularAttribute<InventarioDetalle, Double> cantidadDiferencia;
    public static volatile SingularAttribute<InventarioDetalle, ProductoFamilias> idProductoFamilia;

}