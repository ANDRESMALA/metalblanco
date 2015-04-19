/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.ClientesDao;
import dao.ComunaDao;
import dao.CotizacionDao;
import dao.DetalleCotizacionDao;
import dao.DetalleNotaDeVentaDao;
import dao.NotaDeVentaDao;
import dao.ProductosDao;
import dao.UsuarioDao;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import metalblanco.map.com.Cliente;
import metalblanco.map.com.Comuna;
import metalblanco.map.com.Cotizacion;
import metalblanco.map.com.DetalleDeCotizacion;
import metalblanco.map.com.DetalleNotaDeVenta;
import metalblanco.map.com.NotaDeVenta;
import metalblanco.map.com.Productos;
import modelo.BussinesModelCotizacion;
import modelo.CalcularSubtotal;
import modelo.Mensajes;
import modelo.Producto;
import modelo.Reportes;
import modelo.Validadores;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author andresmalagueno
 */
@ManagedBean
@ViewScoped
public class JSFMNotaDeVenta {
    
    

    

    private Comuna comuna=new Comuna();
    private Cliente cliente=new Cliente();
    private ClientesDao cli=new ClientesDao();
    private CotizacionDao cot=new CotizacionDao();
    
    private ComunaDao com=new ComunaDao();
    private Productos producto=new Productos();
    private ProductosDao pro=new ProductosDao();
    private Validadores validador=new Validadores();
    private ArrayList<Producto> listatemporal=new ArrayList<Producto>();
    private CalcularSubtotal subt=new CalcularSubtotal();
    private Reportes reporte=new Reportes();
    private NotaDeVenta notadeVenta=new NotaDeVenta();
    private DetalleNotaDeVenta detalleNotaDeVenta=new DetalleNotaDeVenta();
    private NotaDeVentaDao not=new NotaDeVentaDao();
    private DetalleNotaDeVentaDao detnot=new DetalleNotaDeVentaDao();
    private UsuarioDao usua=new UsuarioDao();
    private DetalleDeCotizacion midetalle=new DetalleDeCotizacion ();
    private Mensajes mensaje=new Mensajes();
    private BussinesModelCotizacion bussines=new BussinesModelCotizacion();
    private ArrayList<String> estaPagado=new ArrayList();
    private ArrayList<String> estafactu=new ArrayList();
    private ArrayList<String> estatipo=new ArrayList();
    private ArrayList<String> bancos=new ArrayList();
    
    
    private List<Productos> listaProductos=pro.findAllProductos();
    private List<Cliente> listaClientes=cli.findAllClientes();
    private List<Cotizacion> listaCotizaciones=cot.findAllCotizaciones();
    private SelectItem[] categoriaOptions=this.createFilterOptions();
    
    
    private String laComuna ="";
    private String laCiudad ="";
    private String estadoDelPago="";
    private String estadoDeFacturacion="";
    private String tipoDePago="";
    private int primerCheque=0;
    private int segundoCheque=0;
    private int tercerCheque=0;
    private int numcotTemp=0;
    private int indice;
    
    private String  nombreCheque="";
    private String banco="";
    private String rut="";
    private String codigo="";
    private String codigoProducto="";
    private String descripcion="";
    private String cantidad="0";
    private String numCot="";
    private String fecha;
    
    private double descuento=0.0;
    private double Precio=0.0;
    private double subtotal=0.0;
    private double neto=0.0;
    private double iva=0.0;
    private double total=0.0;
    
    private StreamedContent file=null;       
    
    Date mifechaactual=new Date();
    
    



    public JSFMNotaDeVenta() {
        this.llenarcombos();
    }   
    
    
    public void llenarcombos(){
       estaPagado.add("no pagado");
       estaPagado.add("pagado");
       
       estafactu.add("no facturado");
       estafactu.add("facturado");
       
       estatipo.add("contado");
       estatipo.add("cheque");
       
       bancos.add("");
       bancos.add("banco estado");
       bancos.add("santander");
       
               
    }
    public void borrarcombos(){
        
       estaPagado.clear();
       this.estafactu.clear();
       estatipo.clear();
       bancos.clear();
    }
    


    public void traerCliente(){
        if(cli.buscarCliente(this.getRut())==null || this.cliente == null){
           mensaje.Mensajes(2); 
        }else{
        cliente=cli.buscarCliente(this.getRut());
        
        this.setLaComuna(cliente.getCOMUNAcodComuna().getNomComuna());
        this.setLaCiudad(cliente.getCOMUNAcodComuna().getCIUDADcodCiudad().getNombreCiudad());
        this.setFecha(this.convFecha(mifechaactual));
        }
        
    }
    
    public void onRowSelectCli(SelectEvent event) {
        this.setRut(((Cliente)event.getObject()).getRutCliente());
        this.traerCliente();
    }
    
    private String convFecha(Date fecha) {
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY");
        return (sdf.format(fecha));
    }
    
    public void imprimir(){

        
        System.out.println(estadoDelPago);
        System.out.println(estadoDeFacturacion);
        System.out.println(tipoDePago);
        System.out.println(banco);
        
    
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
        this.setLaComuna("");
        this.setLaCiudad("");
        this.setRut("");
        
        this.setEstadoDelPago("no pagado");
        this.setEstadoDeFacturacion("no facturado");
        this.setTipoDePago("contado");
        this.setBanco("");
        
        
        this.setTercerCheque(0);
        this.setSegundoCheque(0);
        this.setPrimerCheque(0);
        
        
        this.borrarcombos();
        this.llenarcombos();
    }
    
    public void traerProducto(){
        
        if(pro.buscarProducto(this.codigoProducto)==null || this.codigoProducto == null){
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
        CalcularSubtotal subto=new CalcularSubtotal();  
        this.setSubtotal(subto.Calcular(this.Precio,Integer.parseInt(this.getCantidad()),this.descuento));
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

            if(this.buscarCodigoEnTemp(this.getCodigoProducto())==true){

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
    
    
    //metodo que busca en un arraylist que e la lista temporal de productos agregados en la nota de venta
    //devuelve un true si es encontrado
    public boolean buscarCodigoEnTemp(String codigoProducto){
    
        boolean respuesta = false;
        for(int i=0;i<listatemporal.size();i++){
        
            if(listatemporal.get(i).getCodProducto().equals(codigoProducto)){
            
                indice=i;
                respuesta=true;
        
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
    
    public void agregarNotadeVenta() throws IOException{
        
        
        int numero =bussines.validaIngreso(rut,total);
    
        switch(numero){
        
            
            case 1:
                mensaje.Mensajes(7); 
                break;
            case 2:
                 mensaje.Mensajes(8);
                break;
            case 3:
            NotaDeVenta nota=new NotaDeVenta();
            nota.setRutCliente(this.getCliente().getRutCliente());
            nota.setFecha(this.mifechaactual);
            nota.setRazonSocial(this.getCliente().getNomComercial());
            nota.setDireccion(this.getCliente().getDireccion());
            nota.setTelefono(this.getCliente().getTelefono());
            nota.setEmail(this.getCliente().getEmail());
            nota.setNomContacto(this.getCliente().getNomContacto());
            nota.setComuna(this.getLaComuna());
            nota.setCiudad(this.getLaCiudad());
            nota.setVendedor(usua.buscarUsuario(1).getNombre());
            nota.setEstadoDelPago(this.getEstadoDelPago());
            nota.setEstadoFacturacion(this.getEstadoDeFacturacion());
            nota.setTipoDePago(this.getTipoDePago());
            nota.setPrimerCheque(this.getPrimerCheque());
            nota.setSegundoCheque(this.getSegundoCheque());
            nota.setTercerCheque(this.getTercerCheque());
            nota.setNombreCheque(this.getNombreCheque());
            nota.setBanco(this.getBanco());
            
            
            nota.setNeto(this.getNeto());
            nota.setIva(this.getIva());
            nota.setTotal(this.getTotal());
            nota.setUSUARIOidusuario(usua.buscarUsuario(1));
            not.init();
            not.insertar(nota);
            not.close();
            this.setNumCot(Integer.toString(not.getMaxId()));
            
            for( Producto p:listatemporal ){
        
        
                DetalleNotaDeVenta midetalle=new DetalleNotaDeVenta();
            
                midetalle.setNOTADEVENTAnumnotadeventa(nota);
                midetalle.setCodProducto(p.getCodProducto());
                midetalle.setDescripcion(p.getDescripcion());
                midetalle.setCantidad(p.getCantidad());
                midetalle.setValorUnitario(p.getValorUnitario());
                midetalle.setDescuento(p.getDescuento());
                midetalle.setSubtotal(p.getSubTotal());
                detnot.init();
                detnot.insertar(midetalle);
                detnot.close();
                }
                
                mensaje.MensajesConParametro(1,this.getNumCot());
                this.numcotTemp=Integer.parseInt(this.getNumCot());
                this.limpiarNota();
               break;
            
         default: 
            break; 
         }
        
        numero=0;
   
    }
    
    
    
    
    
    public void limpiarNota(){
    
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
     
     ////////////////////////////////////////////////metodos Get And Set
    
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

    public String getEstadoDelPago() {
        return estadoDelPago;
    }

    public void setEstadoDelPago(String estadoDelPago) {
        this.estadoDelPago = estadoDelPago;
    }

    public String getEstadoDeFacturacion() {
        return estadoDeFacturacion;
    }

    public void setEstadoDeFacturacion(String estadoDeFacturacion) {
        this.estadoDeFacturacion = estadoDeFacturacion;
    }

    public String getTipoDePago() {
        return tipoDePago;
    }

    public void setTipoDePago(String tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public int getPrimerCheque() {
        return primerCheque;
    }

    public void setPrimerCheque(int primerCheque) {
        this.primerCheque = primerCheque;
    }

    public int getSegundoCheque() {
        return segundoCheque;
    }

    public void setSegundoCheque(int segundoCheque) {
        this.segundoCheque = segundoCheque;
    }

    public int getTercerCheque() {
        return tercerCheque;
    }

    public void setTercerCheque(int tercerCheque) {
        this.tercerCheque = tercerCheque;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNombreCheque() {
        return nombreCheque;
    }

    public void setNombreCheque(String nombreCheque) {
        this.nombreCheque = nombreCheque;
    }

    public String getLaComuna() {
        return laComuna;
    }

    public void setLaComuna(String laComuna) {
        this.laComuna = laComuna;
    }

    public String getLaCiudad() {
        return laCiudad;
    }

    public void setLaCiudad(String laCiudad) {
        this.laCiudad = laCiudad;
    }

    public ArrayList<String> getEstaPagado() {
        return estaPagado;
    }

    public void setEstaPagado(ArrayList<String> estaPagado) {
        this.estaPagado = estaPagado;
    }


    public ArrayList<String> getEstatipo() {
        return estatipo;
    }

    public void setEstatipo(ArrayList<String> estatipo) {
        this.estatipo = estatipo;
    }

    public ArrayList<String> getBancos() {
        return bancos;
    }

    public void setBancos(ArrayList<String> bancos) {
        this.bancos = bancos;
    }

    public ArrayList<String> getEstafactu() {
        return estafactu;
    }

    public void setEstafactu(ArrayList<String> estafactu) {
        this.estafactu = estafactu;
    }

    public List<Cotizacion> getListaCotizaciones() {
        return listaCotizaciones;
    }

    public void setListaCotizaciones(List<Cotizacion> listaCotizaciones) {
        this.listaCotizaciones = listaCotizaciones;
    }

    
    
}
