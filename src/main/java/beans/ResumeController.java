/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controllers.ClientesFacade;
import controllers.PedidosCabeceraFacade;
import controllers.VendedoresFacade;
import controllers.VisitasFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Diego
 */
@Named(value = "resumeController")
@ViewScoped
public class ResumeController implements Serializable {
    
    private int orderTodayQuantity;
    private double revenueTodayAmount;
    private int activeQuantityClients;
    private int activeQuantitySalesmen;
    private int visitsQuantity;
    private int visitsaleQuantity;
    
    @PersistenceContext(unitName = "py.com.fpuna_WebOlympos_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    @EJB
    private ClientesFacade clientesFacade;
    @EJB
    private VendedoresFacade vendedoresFacade;
    @EJB
    private PedidosCabeceraFacade pedidosFacade;
    @EJB
    private VisitasFacade visitasFacade;

    /**
     * Creates a new instance of ResumeController
     */
    public ResumeController() {
        
    }
    
    @PostConstruct
    void init() {
        loadValues();
    }
    
    private void loadValues() {
        int countSalesmen = vendedoresFacade.count();
        setActiveQuantitySalesmen(countSalesmen);
        
        int countClients = clientesFacade.count();
        setActiveQuantityClients(countClients);
        
        countOrdersToday();
        sumOrdersToday();
        countVisitsToday();
        
        setVisitsaleQuantity(getVisitsQuantity() + getOrderTodayQuantity());
    }
    
    public int getOrderTodayQuantity() {
        return orderTodayQuantity;
    }
    
    public void setOrderTodayQuantity(int orderTodayQuantity) {
        this.orderTodayQuantity = orderTodayQuantity;
    }
    
    public double getRevenueTodayAmount() {
        return revenueTodayAmount;
    }
    
    public void setRevenueTodayAmount(double revenueTodayAmount) {
        this.revenueTodayAmount = revenueTodayAmount;
    }
    
    public int getActiveQuantityClients() {
        return activeQuantityClients;
    }
    
    public void setActiveQuantityClients(int activeQuantityClients) {
        this.activeQuantityClients = activeQuantityClients;
    }
    
    public int getActiveQuantitySalesmen() {
        return activeQuantitySalesmen;
    }
    
    public void setActiveQuantitySalesmen(int activeQuantitySalesmen) {
        this.activeQuantitySalesmen = activeQuantitySalesmen;
    }
    
    public int getVisitsQuantity() {
        return visitsQuantity;
    }
    
    public void setVisitsQuantity(int visitsQuantity) {
        this.visitsQuantity = visitsQuantity;
    }
    
    private void countOrdersToday() {
        try {
            Query q = em.createNativeQuery("select cast(fecha_creacion as date)  from pedidos_cabecera where cast(fecha_creacion as date) = cast(CURRENT_DATE as date)");
            setOrderTodayQuantity(q.getResultList().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void sumOrdersToday() {
        try {
            Query q = em.createNativeQuery("select coalesce (sum(importe),0 )from pedidos_cabecera where cast(fecha_creacion as date) = cast(CURRENT_DATE as date)");
            setRevenueTodayAmount(Double.parseDouble(String.valueOf(q.getSingleResult())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void countVisitsToday() {
        try {
            Query q = em.createNativeQuery("select cast(fecha_creacion as date)  from visitas where cast(fecha_creacion as date) = cast(CURRENT_DATE as date)");
            setVisitsQuantity(q.getResultList().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int getVisitsaleQuantity() {
        return visitsaleQuantity;
    }
    
    public void setVisitsaleQuantity(int visitsaleQuantity) {
        this.visitsaleQuantity = visitsaleQuantity;
    }
    
}
