/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controllers.ClientesFacade;
import controllers.PedidosCabeceraFacade;
import controllers.VendedoresFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Diego
 */
@Named(value = "resumeController")
@ViewScoped
public class ResumeController implements Serializable {

    private int orderTodayQuantity;
    private int revenueTodayAmount;
    private int activeQuantityClients;
    private int activeQuantitySalesmen;

    @EJB
    private ClientesFacade clientesFacade;
    @EJB
    private VendedoresFacade vendedoresFacade;
    @EJB
    private PedidosCabeceraFacade pedidosFacade;

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
    }

    public int getOrderTodayQuantity() {
        return orderTodayQuantity;
    }

    public void setOrderTodayQuantity(int orderTodayQuantity) {
        this.orderTodayQuantity = orderTodayQuantity;
    }

    public int getRevenueTodayAmount() {
        return revenueTodayAmount;
    }

    public void setRevenueTodayAmount(int revenueTodayAmount) {
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

}
