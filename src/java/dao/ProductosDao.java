
package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import metalblanco.map.com.Productos;

/**
 *
 * @author andresmalagueno
 */
public class ProductosDao implements Serializable {
    private EntityManagerFactory emf=null;
    private EntityManager em=null; 

    public ProductosDao() {
    }
    
     public void init() {
       emf = Persistence.createEntityManagerFactory("MetalBlancoPU");
       em  = emf.createEntityManager();
    }
 
    public void close() {
       if (emf!=null)
           emf.close();
    }
    
     /////////////////////////////////////////BUSCAR PRODUCTO
    public Productos buscarProducto(String codigo){
        this.init();
        return em.find(Productos.class,codigo);
    }
    
    public List<Productos> findAllProductos() {
            this.init();
            List<Productos> productos;
            Query query = em.createQuery("SELECT p FROM Productos p");
            productos=query.getResultList();
            this.close();
            return productos;
    }
    
}
