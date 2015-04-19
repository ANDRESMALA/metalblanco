/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.ClientesDao;
import dao.ComunaDao;
import dao.CotizacionDao;
import dao.DetalleCotizacionDao;

import dao.ProductosDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import metalblanco.map.com.Cliente;
import metalblanco.map.com.Comuna;
import metalblanco.map.com.Cotizacion;
import metalblanco.map.com.DetalleDeCotizacion;

import metalblanco.map.com.Productos;

/**
 *
 * @author andresmalagueno
 */
public class BussinesModelModCotizacion implements Serializable{
    
    
    private CotizacionDao cot = new CotizacionDao();
    private Validadores validador=new Validadores();
    Cotizacion cotizacion=new Cotizacion();
    
    DetalleCotizacionDao dtc=new DetalleCotizacionDao();
    
    private DetalleDeCotizacion midetalle=new DetalleDeCotizacion ();
    
    
    
    private ArrayList<Producto> listatemporal=new ArrayList<Producto>() ;
   
    
    
    private Comuna comuna=new Comuna();
    private Cliente cliente=new Cliente();
    private ClientesDao cli=new ClientesDao();
    private ComunaDao com=new ComunaDao();
    private Productos producto=new Productos();
    private ProductosDao pro=new ProductosDao();
    private CalcularSubtotal subt=new CalcularSubtotal();
    private DetalleCotizacionDao detDao=new DetalleCotizacionDao();
    Cotizacion cotizacion2=new Cotizacion();
    
    
    public BussinesModelModCotizacion() {}
    
    
    
    
    // me trae con el numcot  la cotizacion 
//    desde la base de datos la llena en un objeto 
//    cotizacion y lo devuelve al controlador
    public Cotizacion traerCotizacion(String numcot){
        
        if(validador.isInt2(numcot)==true){
            int numcotizacion=Integer.parseInt(numcot);
            cotizacion=cot.buscarCotizacion(numcotizacion);
           
         }
        return cotizacion;
    
    }
    
    
//     traspasa el detalle de la cotizacion consultada a un arraylist
//     y lo devuelve al controlador
      public ArrayList<Producto> traspasarDetCotaTemporal(Cotizacion cot){
        
        for(DetalleDeCotizacion det:detDao.findAlldetCot(cot.getNumCotizacion())){
           
            Producto linproducto =new Producto();
            linproducto.setCodProducto(det.getCodProducto());
            linproducto.setDescripcion(det.getDescripcion());
            linproducto.setCantidad(det.getCantidad());
            linproducto.setValorUnitario(det.getValorUnitario());
            linproducto.setDescuento(det.getDescuento());
            linproducto.setSubTotal(det.getSubtotal());
           
            this.listatemporal.add(linproducto);
        
            
        }
        return listatemporal;
      }
      
      
      public Double calcularSubtotales(String cantidad,Double precio,Double descuento){
        
        CalcularSubtotal subt=new CalcularSubtotal();  
        Double subtotal=(subt.Calcular(precio,Integer.parseInt(cantidad),descuento));
        return subtotal;
        
     }
       
        
        
        
      public HashMap<String, Double> hacerCalculos(ArrayList<Producto> listaTemporal){
    
            HashMap<String, Double>  map = new HashMap();
        
            double suma=0;
            for(Producto p:listaTemporal){
                suma+=p.getSubTotal();
            }
        
            Double neto=suma;
            Double iva=subt.iva(neto);
            Double total=subt.total(neto, iva);
        
            map.put("neto", neto);
            map.put("iva", iva);
            map.put("total", total);
            return map;
        
     }
    
     public void addCotMod(HashMap map){
         
         cotizacion2.setNumCotizacion(Integer.parseInt(map.get("numcot").toString()));
         cotizacion2.setFecha((Date)map.get("fecha"));
         cotizacion2.setRutCliente(map.get("rut").toString());
         cotizacion2.setRazonSocial(map.get("razon").toString());
         cotizacion2.setDireccion(map.get("direccion").toString());
         cotizacion2.setTelefono(map.get("telefono").toString());
         cotizacion2.setEmail(map.get("email").toString());
         cotizacion2.setComuna(map.get("comuna").toString());
         cotizacion2.setCiudad(map.get("ciudad").toString());
         cotizacion2.setNomContacto(map.get("nomcont").toString());
//         cotizacion.setVendedor(map.get("vendedor").toString());
         cotizacion2.setNeto(Double.parseDouble(map.get("neto").toString()));
         cotizacion2.setIva(Double.parseDouble(map.get("iva").toString()));
         cotizacion2.setTotal(Double.parseDouble(map.get("total").toString()));
         cot.init();
         cot.modificarCot(cotizacion2);
         cot.close();
         detDao.init();
         detDao.eliminarselectos(cotizacion2.getNumCotizacion());
         detDao.close();
         
         
     } 
     
     
     public void eliminarTodo(){
        
        listatemporal.clear();
    }
     
     public void rec(ArrayList<Producto> listatemporal2 ){
     
     for( Producto p:listatemporal2 ){

                DetalleDeCotizacion midetalle=new DetalleDeCotizacion ();
                midetalle.setCOTIZACIONnumcotizacion(cotizacion2);
                midetalle.setCodProducto(p.getCodProducto());
                midetalle.setDescripcion(p.getDescripcion());
                midetalle.setCantidad(p.getCantidad());
                midetalle.setValorUnitario(p.getValorUnitario());
                midetalle.setDescuento(p.getDescuento());
                midetalle.setSubtotal(p.getSubTotal());
                detDao.init();
                detDao.insertar(midetalle);
                detDao.close();
            
        }
     
     }
     
     
     
      
//      trae el cliente solicitado devuelve un OBJ  cliente al controlador
              
       public Cliente traerCliente(String rutCliente){
            cliente=cli.buscarCliente(rutCliente);
        return cliente;
      }
    
//      trae el producto solicitado devuelve un OBJ producto al controlador      
       public Productos traerProducto(String productos){
            producto=pro.buscarProducto(productos);
       return producto;
        
      }

    
    
    
    
    
    
    
    

     
    
}
