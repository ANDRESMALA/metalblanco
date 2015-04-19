/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import metalblanco.map.com.Comuna;

/**
 *
 * @author andresmalagueno
 */
public class ComunaDao implements Serializable {
    private EntityManagerFactory emf=null;
    private EntityManager em=null;
    
    public ComunaDao(){
    
    };
    
    public void init(){
    
        emf=Persistence.createEntityManagerFactory("MetalBlancoPU");
        em=emf.createEntityManager();
     
    }
    
    public void close(){
    
     if (emf!=null)
           emf.close();
    }
    
    public Comuna buscarComuna(String CodComuna){
     this.init();
     return em.find(Comuna.class,CodComuna);
}
    
}
