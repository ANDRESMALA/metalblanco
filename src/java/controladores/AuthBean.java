/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.UsuarioDao;
import modelo.UserBean;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import metalblanco.map.com.Usuario;

/**
 *
 * @author andresmalagueno
 */
@ManagedBean
@RequestScoped
public class AuthBean {

   public final static String USER_KEY="auth_user";

    private String user;
    private String password;
    UsuarioDao usuarioDao=new UsuarioDao();
    Usuario miUsuario=new Usuario();
    private Usuario usuario;
    /** Creates a new instance of AuthBean */
    public AuthBean() {
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * 
     * @param e
     * @throws IOException
     */
    public void doLogin(ActionEvent e) throws IOException{
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        String url = "";
        
        if(isAdmin(user, password,"administrador")==true)
        {

           miUsuario=usuarioDao.buscarUser(user);
            url = extContext.encodeActionURL( context.getApplication().getViewHandler().getActionURL(context, "/principal/index"));
            extContext.getSessionMap().put(USER_KEY,miUsuario);
            extContext.redirect(url);
            
           
            return;
        }
        if(isSuperAdmin(user, password,"superadministrador"))
        {

            url = extContext.encodeActionURL( context.getApplication().getViewHandler().getActionURL(context, "/principal/index"+ ""));
            miUsuario=usuarioDao.buscarUser(user);
            extContext.getSessionMap().put(USER_KEY,miUsuario);
            extContext.redirect(url);
            return;
        }
      FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO,"USUARIO O CLAVE INCORRECTA", ""));
    }

    /**
     *
     * @param user
     * @param password
     * @return
     */
    private boolean isAdmin(String user, String password,String tipo){
        
        return usuarioDao.existeUsuario(user,password,tipo);
        //Aqui se puede validar hacia una base de datos
    }

    /**
     *
     * @param user
     * @param password
     * @return
     */
    private boolean isSuperAdmin(String user, String password,String tipo){
        return usuarioDao.existeUsuario(user,password,tipo);
        //Aqui se puede validar hacia una base de datos
    }

    /**
     * 
     * @return
     */
    public String getLoggedUserName(){
        return ((UserBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(USER_KEY)).toString();
    }

    /**
     * 
     * @throws IOException
     */
    public void logout() throws IOException{
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        extContext.getSessionMap().remove(USER_KEY);
        String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/login.faces"));
        extContext.redirect(url);
    }
    

    
    
    
    
}
