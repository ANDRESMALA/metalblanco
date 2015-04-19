/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import static controladores.AuthBean.USER_KEY;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import metalblanco.map.com.Usuario;
import modelo.UserBean;

/**
 *
 * @author andresmalagueno
 */
@ManagedBean
@RequestScoped
public class JSFMusuario {

 private Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(USER_KEY);
    public JSFMusuario() {
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
}
