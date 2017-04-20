/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.UsuariosWeb;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Diego
 */
@Named(value = "loginController")
@ViewScoped
public class LoginController extends AbstractController<UsuariosWeb> {


    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }
    
   

}
