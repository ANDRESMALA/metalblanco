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
import metalblanco.map.com.DetalleNotaDeVenta;


/**
 *
 * @author andresmalagueno
 */
public class DetalleNotaDeVentaDao implements Serializable{
    private EntityManagerFactory emf=null;
    private EntityManager em=null;
    
    public void init(){
    
        emf=Persistence.createEntityManagerFactory("MetalBlancoPU");
        em=emf.createEntityManager();
    
    }
    
    public void close(){
        if(emf!=null){
        em.close();
        }
    }
    
    public void insertar(DetalleNotaDeVenta detNotaDeVenta){
        
                em.getTransaction().begin();
                em.persist(detNotaDeVenta);
                em.getTransaction().commit();
         
    }
    
    public void eliminarselectos(int codigo){
        
        em.getTransaction().begin();
        Query query = em.createQuery("delete  FROM DetalleNotaDeVenta d WHERE d.nOTADEVENTAnumnotadeventa.numNotaDeVenta =:numnota");
        query.setParameter("numnota",codigo).executeUpdate();
        em.getTransaction().commit();
    }
    
    public Collection<DetalleNotaDeVenta> findAlldetCot(int codigo) {
            this.init();
            Collection<DetalleNotaDeVenta> detallenota;
            Query query = em.createQuery("SELECT d FROM DetalleNotaDeVenta d WHERE d.nOTADEVENTAnumnotadeventa.numNotaDeVenta =:numnota");
            detallenota=query.setParameter("numnota",codigo).getResultList();
            return detallenota;
    }
     
     
    
    
    
    
}
