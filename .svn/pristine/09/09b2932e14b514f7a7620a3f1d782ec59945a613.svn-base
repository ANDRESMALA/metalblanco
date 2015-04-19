/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author andresmalagueno
 */
public class Mensajes implements Serializable{

    public Mensajes() {
    }
    
    
    
    public String Mensajes (int numero){
        
        switch(numero) {
    case 1: 
        FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO,"EL PRODUCTO SOLICITADO NO EXISTE", ""));
        break;
    case 2: 
         FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO,"EL CLIENTE SOLICITADO NO EXISTE", ""));
        break;
    case 3: 
        FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_ERROR,"LA CANTIDAD NO PUEDE SER UN CAMPO VACIO", ""));
        break;
     case 4: 
        FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_ERROR,"LA CANTIDAD DEBE SER UN NUMERO ENTERO", ""));    
        break;
     case 5:
        FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO,"LA COTIZACION FUE INGRESADA CON EXITO,AHORA PUEDE GENERAR EL INFORME", ""));
         break;
     case 6: 
        FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_ERROR,"DEBE CREAR LA COTIZACION", ""));
        break;
      case 7: 
        FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_ERROR,"LA CABECERA NO PUEDE ESTAR VACIA", ""));
        break;   
      case 8: 
        FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_ERROR,"LA COTIZACION DEBE CONTENER UN DETALLE", "FAVOR LLENAR EL DETALLE"));
        break;  
       case 9: 
        FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_ERROR,"DEBE GENERAR O GUARDAR LA COTIZACION", ""));
        break;    
       case 10: 
        FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_ERROR,"DEBE LIMPIAR EL FORMULARIO", ""));
        break;  
       case 11: 
        FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_ERROR,"EL NUMERO DE COTIZACION NO PUEDE SER VACIO", ""));
        break;
        case 12: 
        FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_ERROR,"EL NUMERO DE COTIZACION DEBE SER UN ENTERO", ""));
        break;
        case 13: 
        FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_ERROR,"LA COTIZACION BUSCADA NO EXISTE", ""));
        break;
        case 14: 
        FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO,"LA COTIZACION MODIFICADA CON EXITO", ""));
        break;
        case 15: 
        FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO,"VA A AGREGAR UNA LINEA SIN CODIGO", "FAVOR AGREGAR CODIGO"));
        break;
        case 16: 
        FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO,"VA A AGREGAR UNA LINEA SIN DETALLE", "FAVOR CONSULTAR PRODUCTO BUSCADO"));
        break;
      default: 
     
     break;
 }
        
        
        return null;
}
    
    public String MensajesConParametro (int numero,String parametro){
          switch(numero) {
    case 1: 
        FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO,"LA COTIZACION CREADA ES", parametro));
        break;
    }
        return null;
    

}
}