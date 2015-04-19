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
import metalblanco.map.com.Cliente;



public class ClientesDao implements Serializable{
    private EntityManagerFactory emf=null;
    private EntityManager em=null;

    public ClientesDao() {
    }
    
    
 public void init() {
       emf = Persistence.createEntityManagerFactory("MetalBlancoPU");
       em  = emf.createEntityManager();
   }
 
 public void close() {
       if (emf!=null)
           emf.close();
   }
 
 public List<Cliente> findAllClientes() {
            this.init();
            List<Cliente> clientes;
            Query query = em.createQuery("SELECT c FROM Cliente c");
            clientes=query.getResultList();
            this.close();
            return clientes;
    }
 /////////////////////////////////////////BUSCAR CLIENTE
 public Cliente buscarCliente(String rut){
     this.init();
     return em.find(Cliente.class,rut);
}
 ///////////////////////////////////////INSERTAR CLIENTES
 public void insertar(Cliente cliente) {
     
    Cliente c = em.find(Cliente.class, cliente.getRutCliente());
            if (c==null) {
                em.getTransaction().begin();
                em.persist(cliente);
                em.getTransaction().commit();
                
            }
    
    }
 
 
 
 
 
}
