/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import metalblanco.map.com.DetalleDeCotizacion;


/**
 *
 * @author andresmalagueno
 */
public class DetalleCotizacionDao implements Serializable{
    private EntityManagerFactory emf=null;
    private EntityManager em=null;

    public DetalleCotizacionDao() {
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
    
    
    
     public void insertar(DetalleDeCotizacion detCotizacion){
        
                em.getTransaction().begin();
                em.persist(detCotizacion);
                em.getTransaction().commit();
         
    }
     
     
     public void eliminarselectos(int codigo){
        
        em.getTransaction().begin();
        Query query = em.createQuery("delete  FROM DetalleDeCotizacion d WHERE d.cOTIZACIONnumcotizacion.numCotizacion =:numcotizacion");
        query.setParameter("numcotizacion",codigo).executeUpdate();
        em.getTransaction().commit();
        
    
    
     }
     
     public Collection<DetalleDeCotizacion> findAlldetCot(int codigo) {
            this.init();
            Collection<DetalleDeCotizacion> detallecot;
            Query query = em.createQuery("SELECT d FROM DetalleDeCotizacion d WHERE d.cOTIZACIONnumcotizacion.numCotizacion =:numcotizacion");
//            try{
                detallecot=query.setParameter("numcotizacion",codigo).getResultList();
//            }catch(Exception e){
//               detallecot=null;
//            }
               
            return detallecot;
    }
     
     
}//fin de clase

