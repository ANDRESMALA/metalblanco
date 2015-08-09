/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;



import static controladores.AuthBean.USER_KEY;
import modelo.Producto;
import dao.ClientesDao;
import dao.ComunaDao;
import dao.CotizacionDao;
import dao.DetalleCotizacionDao;
import dao.ProductosDao;
import dao.UsuarioDao;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import metalblanco.map.com.Cliente;
import metalblanco.map.com.Comuna;
import metalblanco.map.com.Cotizacion;
import metalblanco.map.com.DetalleDeCotizacion;
import metalblanco.map.com.Productos;
import metalblanco.map.com.Usuario;
import modelo.BussinesModelCotizacion;
import modelo.CalcularSubtotal;
import modelo.Mensajes;
import modelo.Reportes;
import modelo.UserBean;
import modelo.Validadores;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author andresmalagueno
 */
@ManagedBean
@ViewScoped
public class JSFMCotizaciones implements Serializable {
    
    
    private Comuna comuna=new Comuna();
    private Cliente cliente=new Cliente();
    private ClientesDao cli=new ClientesDao();
    private ComunaDao com=new ComunaDao();
    private Productos producto=new Productos();
    private ProductosDao pro=new ProductosDao();
    private Validadores validador=new Validadores();
    private ArrayList<Producto> listatemporal=new ArrayList<Producto>();
    private CalcularSubtotal subt=new CalcularSubtotal(); 
    private CotizacionDao cot = new CotizacionDao();
    private DetalleCotizacionDao detDao=new DetalleCotizacionDao();
    private UsuarioDao usua=new UsuarioDao();
    private DetalleDeCotizacion midetalle=new DetalleDeCotizacion ();
    private Mensajes mensaje=new Mensajes();
    private BussinesModelCotizacion bussines=new BussinesModelCotizacion();
    private List<Productos> listaProductos=pro.findAllProductos();
    private List<Cliente> listaClientes=cli.findAllClientes();
    private SelectItem[] categoriaOptions=this.createFilterOptions();

    
    
    Reportes reporte=new Reportes();
    private StreamedContent file=null;       
    int numcotTemp=0;
    private String rut="";
    
    private String codigo="";
    private String codigoProducto="";
    private String descripcion="";
    private double descuento=0.0;
    private double Precio=0.0;
    private double subtotal=0.0;
    private String cantidad="0";
    private double neto=0.0;
    private double iva=0.0;
    private double total=0.0;
    private String numCot="";
    private String fecha;
    Date mifechaactual=new Date();
    private int indice;
    
   
    
 

    
    
    
    public JSFMCotizaciones() {
        
        
    }
    
    public void traerCliente(){
        if(cli.buscarCliente(this.getRut())==null || this.cliente.equals(null)){
           mensaje.Mensajes(2); 
        }else{
        cliente=cli.buscarCliente(this.getRut());
//       cliente.setNomComercial(cli.buscarCliente(cliente.getRutCliente()).getNomComercial());
        comuna=com.buscarComuna(cliente.getCOMUNAcodComuna().getCodComuna());
        }
        
    }
    
    public void onRowSelectCli(SelectEvent event) {
        this.setRut(((Cliente)event.getObject()).getRutCliente());
        this.traerCliente();
    }
    
    
    
    
    public void limpiarCliente(){
    
        this.cliente.setRutCliente("");
        this.cliente.setNomComercial("");
        this.cliente.setDireccion("");
        this.cliente.setCuentaCorriente("");
        this.cliente.setEmail("");
        this.cliente.setNomContacto("");
        this.cliente.setRepresentante("");
        this.cliente.setTelefono("");
        this.comuna.setNomComuna("");
        this.setRut("");
    }
    
    public void traerProducto(){
        
        if(pro.buscarProducto(this.codigoProducto)==null || this.codigoProducto.equals(null)){
            mensaje.Mensajes(1);
        }else{
        producto=pro.buscarProducto(this.getCodigoProducto());
        this.setCodigo(producto.getCodProducto());
        this.setDescripcion(producto.getDescripcionProducto());
        this.setPrecio(producto.getValorNetoDeVenta());
        this.setDescuento(producto.getDescuento());
        }
    }
    
    
     private SelectItem[] createFilterOptions()  {  
        SelectItem[] options = new SelectItem[listaProductos.size()+1];  
        int i=1; 
        options[0]=new SelectItem("","Select");
        for(Productos p:listaProductos){
            options[i]=new SelectItem(p.getCATEGORIAidcategoria().getNombreCategoria(),p.getCATEGORIAidcategoria().getNombreCategoria());  
          i++;
        }
        return options;  
    } 
 
    public void onRowSelect(SelectEvent event) {
        this.setCodigoProducto(((Productos)event.getObject()).getCodProducto());
        this.traerProducto();
    }
 
    
    
    public void calcularSubtotales(){
        
        if(validador.isInt2(this.getCantidad())==true){
        CalcularSubtotal subt=new CalcularSubtotal();  
        this.setSubtotal(subt.Calcular(this.Precio,Integer.parseInt(this.getCantidad()),this.descuento));
        }else{
    
            mensaje.Mensajes(4);
        }
    }
    
    
    public void ingresarLinea(){
        
       if(this.codigoProducto.equals("")){
       
        mensaje.Mensajes(15);
       }else if(this.descripcion.equals("")){
       
           mensaje.Mensajes(16);
       
       }else{ 
            Producto linproducto =new Producto();
            linproducto.setCodProducto(this.getCodigo());
            linproducto.setDescripcion(this.getDescripcion());
            linproducto.setCantidad(Integer.parseInt(this.getCantidad()));
            linproducto.setValorUnitario(this.getPrecio());
            linproducto.setDescuento(this.getDescuento());
            linproducto.setSubTotal(this.getSubtotal());

            if(this.buscar(this.getCodigoProducto())==true){

               int cant=listatemporal.get(indice).getCantidad();
               double subt=listatemporal.get(indice).getSubTotal();
               linproducto.setCantidad(Integer.parseInt(this.getCantidad())+cant);
               linproducto.setSubTotal(this.getSubtotal()+subt);
               listatemporal.set(indice, linproducto);

            }else{

               this.listatemporal.add(linproducto);
            }
       }
            this.limpiarProd();
            this.hacerCalculos();
    }
    
    
    
    public boolean buscar(String nombreB){
    
        boolean respuesta = false;
        for(int i=0;i<listatemporal.size();i++){
        
            if(listatemporal.get(i).getCodProducto().equals(this.getCodigoProducto())){
            
                indice=i;
                respuesta=true;
                break;
        
            }else{
                respuesta=false;
            }
         
        }
        return respuesta;
    }
    
    
    public void limpiarProd(){
                this.setCodigoProducto("");
                this.setCodigo("");
                this.setDescripcion("");
                this.setPrecio(0.0);
                this.setCantidad("0");
                this.setDescuento(0.0);
                this.setSubtotal(0.0);
    }
    
   
    
    public void eliminarLinea(Producto producto){
        listatemporal.remove(producto);
        this.hacerCalculos();
    } 
    
    public void eliminarTodo(){
        
        listatemporal.clear();
    
    }
    
    public void hacerCalculos(){
        
        double suma=0;
    
        for(Producto p:listatemporal){
            suma+=p.getSubTotal();
        }
        
        this.setNeto(suma);
        this.setIva(subt.iva(neto));
        this.setTotal(subt.total(neto, iva));
    }
  //--------------------------------------
    
    public void agregarCot() throws IOException{
        
        
        int numero =bussines.validaIngreso(rut,total);
    
        switch(numero){
        
            
            case 1:
                mensaje.Mensajes(7); 
                break;
            case 2:
                 mensaje.Mensajes(8);
                break;
            case 3:
            Cotizacion cotizacion=new Cotizacion();
            cotizacion.setRutCliente(this.getCliente().getRutCliente());
            cotizacion.setFecha(this.mifechaactual);
            cotizacion.setRazonSocial(this.getCliente().getNomComercial());
            cotizacion.setDireccion(this.getCliente().getDireccion());
            cotizacion.setTelefono(this.getCliente().getTelefono());
            cotizacion.setEmail(this.getCliente().getEmail());
            cotizacion.setNomContacto(this.getCliente().getNomContacto());
            cotizacion.setComuna(this.getCliente().getCOMUNAcodComuna().getNomComuna());
            cotizacion.setCiudad(this.getCliente().getCOMUNAcodComuna().getCIUDADcodCiudad().getNombreCiudad());
            cotizacion.setVendedor(usua.buscarUsuario(1).getNombre());
            cotizacion.setNeto(this.getNeto());
            cotizacion.setIva(this.getIva());
            cotizacion.setTotal(this.getTotal());
            cotizacion.setUSUARIOidusuario(usua.buscarUsuario(1));
            cot.init();
            cot.insertar(cotizacion);
            cot.close();
            this.setNumCot(Integer.toString(cot.getMaxId()));
            
            for( Producto p:listatemporal ){
        
        
                DetalleDeCotizacion midetalle=new DetalleDeCotizacion ();
            
                midetalle.setCOTIZACIONnumcotizacion(cotizacion);
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
                
                mensaje.MensajesConParametro(1,this.getNumCot());
                this.numcotTemp=Integer.parseInt(this.getNumCot());
                this.limpiarCot();
               break;
            
         default: 
            break; 
         }
        
        numero=0;
   
    }
    
    
    
    
    
    public void limpiarCot(){
    
                this.limpiarCliente();
                this.limpiarProd();
                this.eliminarTodo();
                this.hacerCalculos();
                this.setNumCot("");
        
    }
   //--------------------------------------
  
     public String generateReport(final String reference){
        
        
        try{
            if(this.numcotTemp!=0){
                reporte.reporte(this.numcotTemp);
            }else{
                mensaje.Mensajes(9);
            }
            numcotTemp=0;
        
        }catch(Exception e){
           mensaje.Mensajes(9);
        }
        
        return "cotizaciones.faces";
    } //--------------------------------------
     
     
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }


    public Double getNeto() {
        return neto;
    }

    public void setNeto(Double neto) {
        this.neto = neto;
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

    public String getNumCot() {
        return numCot;
    }

    public void setNumCot(String numCot) {
        this.numCot = numCot;
    }

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
  
    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public ArrayList<Producto> getListatemporal() {
        return listatemporal;
    }

    public void setListatemporal(ArrayList<Producto> listatemporal) {
        this.listatemporal = listatemporal;
    }

        public List<Productos> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public SelectItem[] getCategoriaOptions() {
        return categoriaOptions;
    }

    public void setCategoriaOptions(SelectItem[] categoriaOptions) {
        this.categoriaOptions = categoriaOptions;
    }


}
