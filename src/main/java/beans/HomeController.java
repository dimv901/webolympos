/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import utils.SessionUtils;

/**
 *
 * @author Diego
 */
@Named(value = "homeController")
@ViewScoped
public class HomeController  implements Serializable{

    private String user;

    /**
     * Creates a new instance of HomeController
     */
    public HomeController() {
    }

    public String getUser() {
        if (user == null) {
            user = SessionUtils.getUserDescription();
        }
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
