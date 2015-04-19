
package modelo;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ANDRES
 */
public class Validadores implements Serializable {
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public Validadores() {}
    
    
 public boolean validarRut(String rut) {  
  
    boolean validacion = false;  
    try {  
  
    rut = rut.replace(".", "");  
    rut = rut.replace("-", "");  
    int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));  
  
    char dv = rut.charAt(rut.length() - 1);  
  
    int m = 0, s = 1;  
    for (; rutAux != 0; rutAux /= 10) {  
    s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;  
    }  
    if (dv == (char) (s != 0 ? s + 47 : 75)) {  
    validacion = true;  
    }  
  
    } catch (java.lang.NumberFormatException e) {  
    } catch (Exception e) {  
    }  
    return validacion;  
}
 public boolean isInt(int str) {
    try {
        
       String strg=Integer.toString(str);
       if(Integer.parseInt(strg)>0)
        return true;
       else
           return false;
    } catch (NumberFormatException nfe) {}
    return false;
}
 
 
  public boolean isInt2(String str) {
    try {
        
       
       if(Integer.parseInt(str)>0)
        return true;
       else
           return false;
    } catch (NumberFormatException nfe) {}
    return false;
}

 
    /**
     * Validate given email with regular expression.
     * 
     * @param email
     *            email for validation
     * @return true valid email, otherwise false
     */
    public  boolean validateEmail(String email) {
 
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
 
    }

    //public boolean isInt() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
    
    public boolean isDouble(String cadena) {
       cadena = cadena.trim();
       boolean respuesta;
       try{
           Double.parseDouble(cadena);
           respuesta=true;
        }catch(NumberFormatException nfe){
            respuesta=false;
        }
       
       return respuesta;
 
        
    }
   
    
   
}
