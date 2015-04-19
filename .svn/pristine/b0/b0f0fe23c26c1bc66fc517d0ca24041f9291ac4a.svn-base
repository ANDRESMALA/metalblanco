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
import metalblanco.map.com.NotaDeVenta;

/**
 *
 * @author andresmalagueno
 */
public class NotaDeVentaDao implements Serializable{
    private EntityManagerFactory emf=null;
    private EntityManager em=null;

    public NotaDeVentaDao() {
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
    
    
    
     public void insertar(NotaDeVenta nota){
        
                em.getTransaction().begin();
                em.persist(nota);
                em.getTransaction().commit();
                
    }
     
         //trae el ultimo numero de bota de venta
    public int getMaxId(){
        this.init();
        int id=0;
        em = this.emf.createEntityManager();
            try{
                id = em.createQuery("SELECT MAX(f.numNotaDeVenta) FROM NotaDeVenta  f",Integer.class).getSingleResult();
            }
            catch(Exception e){
    
            id=0;
        }
    return id;
   
    
    }
    
     public NotaDeVenta buscarCotizacion(int numnota){
        this.init();
        return em.find(NotaDeVenta.class,numnota);
    }
     
     public void modificarCot(NotaDeVenta notaMod){
        em.getTransaction().begin();
        NotaDeVenta nota=new NotaDeVenta();
        nota=em.find(NotaDeVenta.class, notaMod.getNumNotaDeVenta());
        nota.setRutCliente(notaMod.getRutCliente());
        nota.setNomContacto(notaMod.getNomContacto());
        nota.setFecha(notaMod.getFecha());
        nota.setRazonSocial(notaMod.getRazonSocial());
        nota.setDireccion(notaMod.getDireccion());
        nota.setTelefono(notaMod.getTelefono());
        nota.setEmail(notaMod.getEmail());
        nota.setComuna(notaMod.getComuna());
        nota.setCiudad(notaMod.getCiudad());
        nota.setEstadoDelPago(notaMod.getEstadoDelPago());
        nota.setEstadoFacturacion(notaMod.getEstadoFacturacion());
        nota.setTipoDePago(notaMod.getTipoDePago());
        nota.setPrimerCheque(notaMod.getPrimerCheque());
        nota.setSegundoCheque(notaMod.getSegundoCheque());
        nota.setTercerCheque(notaMod.getTercerCheque());
        nota.setNombreCheque(notaMod.getNombreCheque());
        nota.setBanco(notaMod.getBanco());
        nota.setVendedor("andres");//debo modificar aqui por el usuario que esta loggeado
        nota.setNeto(notaMod.getNeto());
        nota.setIva(notaMod.getIva());
        nota.setTotal(notaMod.getTotal());
        em.merge(nota);
        em.getTransaction().commit();
        
    
    }
    
}
