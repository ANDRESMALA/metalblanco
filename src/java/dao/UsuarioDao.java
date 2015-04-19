/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import metalblanco.map.com.Usuario;

/**
 *
 * @author andresmalagueno
 */
public class UsuarioDao {
    
    
    private EntityManagerFactory emf=null;
    private EntityManager em=null;

    public UsuarioDao() {
    }
    
    
    
    public void init(){
    
     emf=Persistence.createEntityManagerFactory("MetalBlancoPU");
     em=emf.createEntityManager();
    
    }
    
    public void close(){
        if(emf!=null){
        em.close();
        }
    }
    
    
    public Usuario buscarUsuario(int CodUsuario){
     this.init();
     return em.find(Usuario.class,CodUsuario);
     
     
     
    }
    
    
    public Usuario buscarUser(String user){
        
     Usuario usuario=new Usuario();

          this.init();
          Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.username = :username");
          usuario=(Usuario) query.setParameter ( "username",user).getSingleResult();
          this.close();

     return usuario;
    }
    
    public boolean existeUsuario(String user,String password,String tipo){
        this.init();
        boolean respuesta=false;
        Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.username=:id AND u.password=:pass AND u.tIPODEUSUARIOidtipodeusuario.cargo=:tipo"); 
        query . setParameter ( "id" , user ); 
        query . setParameter ( "pass" , password );  
        query . setParameter ( "tipo" , tipo ); 
        try{
            Usuario us = (Usuario)query.getSingleResult();
            respuesta=true;
        }catch(javax.persistence.NoResultException e ){
        
            respuesta=false;
        
        }
        return respuesta;
     
     
     }
}
