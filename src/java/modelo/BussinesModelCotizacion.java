/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;


/**
 *
 * @author andresmalagueno
 */
public class BussinesModelCotizacion implements Serializable{

    public BussinesModelCotizacion() {
    }
     
    
    public int validaIngreso(String rut,Double total){
        int respuesta=0;
        
        if(rut.equals("")|| rut==null) {
            respuesta=1;
        }else if(total==0.0) {
            respuesta=2;
        }else{
            respuesta=3;
        }
         return respuesta;
    
    }
    
    public void validaDetalle(){}
    
    
    
}
