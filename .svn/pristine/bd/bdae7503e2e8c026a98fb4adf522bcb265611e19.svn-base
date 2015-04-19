/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author andresmalagueno
 */
public class ModCotizacionDAO {
     private EntityManagerFactory emf=null;
    private EntityManager em=null;

    public ModCotizacionDAO() {
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
    
   
    
    
}
