/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.OrdenCompraDetalle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diego
 */
@Stateless
public class OrdenCompraDetalleFacade extends AbstractFacade<OrdenCompraDetalle> {

    @PersistenceContext(unitName = "py.com.fpuna_WebOlympos_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenCompraDetalleFacade() {
        super(OrdenCompraDetalle.class);
    }
    
}
