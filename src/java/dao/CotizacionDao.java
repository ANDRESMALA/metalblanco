/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import metalblanco.map.com.Cotizacion;

/**
 *
 * @author andresmalagueno
 */
public class CotizacionDao implements Serializable {
    private EntityManagerFactory emf=null;
    private EntityManager em=null;

    public CotizacionDao() {
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
    
    
    
     public void insertar(Cotizacion cotizacion){
        
                em.getTransaction().begin();
                em.persist(cotizacion);
                em.getTransaction().commit();
                
    }
     
     
     //trae el ultimo numero de cotizacion
    public int getMaxId(){
    this.init();
    int id=0;
    em = this.emf.createEntityManager();
        try{
        id = em.createQuery("SELECT MAX(f.numCotizacion) FROM Cotizacion  f",Integer.class).getSingleResult();
        }
        catch(Exception e){
    
            id=0;
        }
    return id;
   
    
    } 
    
    
    public Cotizacion buscarCotizacion(int numcot){
        this.init();
        return em.find(Cotizacion.class,numcot);
    }
    
    
    public void modificarCot(Cotizacion cot_mod){
        em.getTransaction().begin();
        Cotizacion cot=new Cotizacion();
        cot=em.find(Cotizacion.class, cot_mod.getNumCotizacion());
        
        cot.setRutCliente(cot_mod.getRutCliente());
        cot.setFecha(cot_mod.getFecha());
        cot.setRazonSocial(cot_mod.getRazonSocial());
        cot.setDireccion(cot_mod.getDireccion());
        cot.setTelefono(cot_mod.getTelefono());
        cot.setEmail(cot_mod.getEmail());
        cot.setComuna(cot_mod.getComuna());
        cot.setCiudad(cot_mod.getCiudad());
        cot.setNomContacto(cot_mod.getNomContacto());
        cot.setVendedor("andres");//debo modificar aqui por el usuario que esta loggeado
        cot.setNeto(cot_mod.getNeto());
        cot.setIva(cot_mod.getIva());
        cot.setTotal(cot_mod.getTotal());
        em.merge(cot);
        em.getTransaction().commit();
        
    
    }
      
    public List<Cotizacion> findAllCotizaciones() {
            this.init();
            List<Cotizacion> cotizacion;
            Query query = em.createQuery("SELECT c FROM Cotizacion c");
            cotizacion=query.getResultList();
            this.close();
            return cotizacion;
    }
   
}
