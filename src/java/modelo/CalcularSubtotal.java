/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author andresmalagueno
 */
public class CalcularSubtotal implements Serializable {

    private Double Subtotal;
    
    private Double iva;
    
    private Double total;
    
    
    
    public CalcularSubtotal() {}

   
    public Double Calcular(Double precio,int cantidad,Double descuento){
        
        
        Subtotal=cantidad*precio-(cantidad*precio*descuento/100);
        return Subtotal;
    }
    
    public Double iva(Double neto){
       
        this.setIva(neto*0.19);
        return this.getIva();
    }
    
    public Double total(Double neto,Double iva){
        this.setTotal(neto+iva);
    return this.getTotal();
    }
    
    
    //metodos getter
    
    
    public Double getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(Double Subtotal) {
        this.Subtotal = Subtotal;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

 
    
    
    
}
