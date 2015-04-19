/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalblanco.map.com;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andresmalagueno
 */
@Entity
@Table(name = "NOTA_DE_VENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotaDeVenta.findAll", query = "SELECT n FROM NotaDeVenta n"),
    @NamedQuery(name = "NotaDeVenta.findByNumNotaDeVenta", query = "SELECT n FROM NotaDeVenta n WHERE n.numNotaDeVenta = :numNotaDeVenta"),
    @NamedQuery(name = "NotaDeVenta.findByFecha", query = "SELECT n FROM NotaDeVenta n WHERE n.fecha = :fecha"),
    @NamedQuery(name = "NotaDeVenta.findByRutCliente", query = "SELECT n FROM NotaDeVenta n WHERE n.rutCliente = :rutCliente"),
    @NamedQuery(name = "NotaDeVenta.findByRazonSocial", query = "SELECT n FROM NotaDeVenta n WHERE n.razonSocial = :razonSocial"),
    @NamedQuery(name = "NotaDeVenta.findByNomContacto", query = "SELECT n FROM NotaDeVenta n WHERE n.nomContacto = :nomContacto"),
    @NamedQuery(name = "NotaDeVenta.findByDireccion", query = "SELECT n FROM NotaDeVenta n WHERE n.direccion = :direccion"),
    @NamedQuery(name = "NotaDeVenta.findByTelefono", query = "SELECT n FROM NotaDeVenta n WHERE n.telefono = :telefono"),
    @NamedQuery(name = "NotaDeVenta.findByEmail", query = "SELECT n FROM NotaDeVenta n WHERE n.email = :email"),
    @NamedQuery(name = "NotaDeVenta.findByComuna", query = "SELECT n FROM NotaDeVenta n WHERE n.comuna = :comuna"),
    @NamedQuery(name = "NotaDeVenta.findByCiudad", query = "SELECT n FROM NotaDeVenta n WHERE n.ciudad = :ciudad"),
    @NamedQuery(name = "NotaDeVenta.findByVendedor", query = "SELECT n FROM NotaDeVenta n WHERE n.vendedor = :vendedor"),
    @NamedQuery(name = "NotaDeVenta.findByObservacion", query = "SELECT n FROM NotaDeVenta n WHERE n.observacion = :observacion"),
    @NamedQuery(name = "NotaDeVenta.findByNeto", query = "SELECT n FROM NotaDeVenta n WHERE n.neto = :neto"),
    @NamedQuery(name = "NotaDeVenta.findByIva", query = "SELECT n FROM NotaDeVenta n WHERE n.iva = :iva"),
    @NamedQuery(name = "NotaDeVenta.findByTotal", query = "SELECT n FROM NotaDeVenta n WHERE n.total = :total"),
    @NamedQuery(name = "NotaDeVenta.findByDespacho", query = "SELECT n FROM NotaDeVenta n WHERE n.despacho = :despacho"),
    @NamedQuery(name = "NotaDeVenta.findByDescuento", query = "SELECT n FROM NotaDeVenta n WHERE n.descuento = :descuento"),
    @NamedQuery(name = "NotaDeVenta.findByEstadoDelPago", query = "SELECT n FROM NotaDeVenta n WHERE n.estadoDelPago = :estadoDelPago"),
    @NamedQuery(name = "NotaDeVenta.findByEstadoFacturacion", query = "SELECT n FROM NotaDeVenta n WHERE n.estadoFacturacion = :estadoFacturacion"),
    @NamedQuery(name = "NotaDeVenta.findByTipoDePago", query = "SELECT n FROM NotaDeVenta n WHERE n.tipoDePago = :tipoDePago"),
    @NamedQuery(name = "NotaDeVenta.findByNumeroDeFactura", query = "SELECT n FROM NotaDeVenta n WHERE n.numeroDeFactura = :numeroDeFactura"),
    @NamedQuery(name = "NotaDeVenta.findByPrimerCheque", query = "SELECT n FROM NotaDeVenta n WHERE n.primerCheque = :primerCheque"),
    @NamedQuery(name = "NotaDeVenta.findBySegundoCheque", query = "SELECT n FROM NotaDeVenta n WHERE n.segundoCheque = :segundoCheque"),
    @NamedQuery(name = "NotaDeVenta.findByTercerCheque", query = "SELECT n FROM NotaDeVenta n WHERE n.tercerCheque = :tercerCheque"),
    @NamedQuery(name = "NotaDeVenta.findByNombreCheque", query = "SELECT n FROM NotaDeVenta n WHERE n.nombreCheque = :nombreCheque"),
    @NamedQuery(name = "NotaDeVenta.findByBanco", query = "SELECT n FROM NotaDeVenta n WHERE n.banco = :banco")})
public class NotaDeVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_nota_de_venta")
    private Integer numNotaDeVenta;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "rut_cliente")
    private String rutCliente;
    @Basic(optional = false)
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "nom_contacto")
    private String nomContacto;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;
    @Column(name = "comuna")
    private String comuna;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "vendedor")
    private String vendedor;
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @Column(name = "neto")
    private double neto;
    @Basic(optional = false)
    @Column(name = "iva")
    private double iva;
    @Basic(optional = false)
    @Column(name = "total")
    private double total;
    @Column(name = "despacho")
    private String despacho;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "descuento")
    private Double descuento;
    @Basic(optional = false)
    @Column(name = "estado_del_pago")
    private String estadoDelPago;
    @Basic(optional = false)
    @Column(name = "estado_facturacion")
    private String estadoFacturacion;
    @Basic(optional = false)
    @Column(name = "tipo_de_pago")
    private String tipoDePago;
    @Column(name = "numero_de_factura")
    private Integer numeroDeFactura;
    @Column(name = "primer_cheque")
    private Integer primerCheque;
    @Column(name = "segundo_cheque")
    private Integer segundoCheque;
    @Column(name = "tercer_cheque")
    private Integer tercerCheque;
    @Column(name = "nombre_cheque")
    private String nombreCheque;
    @Column(name = "banco")
    private String banco;
    @JoinColumn(name = "USUARIO_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario uSUARIOidusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nOTADEVENTAnumnotadeventa")
    private Collection<DetalleNotaDeVenta> detalleNotaDeVentaCollection;

    public NotaDeVenta() {
    }

    public NotaDeVenta(Integer numNotaDeVenta) {
        this.numNotaDeVenta = numNotaDeVenta;
    }

    public NotaDeVenta(Integer numNotaDeVenta, Date fecha, String rutCliente, String razonSocial, String direccion, double neto, double iva, double total, String estadoDelPago, String estadoFacturacion, String tipoDePago) {
        this.numNotaDeVenta = numNotaDeVenta;
        this.fecha = fecha;
        this.rutCliente = rutCliente;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.neto = neto;
        this.iva = iva;
        this.total = total;
        this.estadoDelPago = estadoDelPago;
        this.estadoFacturacion = estadoFacturacion;
        this.tipoDePago = tipoDePago;
    }

    public Integer getNumNotaDeVenta() {
        return numNotaDeVenta;
    }

    public void setNumNotaDeVenta(Integer numNotaDeVenta) {
        this.numNotaDeVenta = numNotaDeVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNomContacto() {
        return nomContacto;
    }

    public void setNomContacto(String nomContacto) {
        this.nomContacto = nomContacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public double getNeto() {
        return neto;
    }

    public void setNeto(double neto) {
        this.neto = neto;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDespacho() {
        return despacho;
    }

    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public String getEstadoDelPago() {
        return estadoDelPago;
    }

    public void setEstadoDelPago(String estadoDelPago) {
        this.estadoDelPago = estadoDelPago;
    }

    public String getEstadoFacturacion() {
        return estadoFacturacion;
    }

    public void setEstadoFacturacion(String estadoFacturacion) {
        this.estadoFacturacion = estadoFacturacion;
    }

    public String getTipoDePago() {
        return tipoDePago;
    }

    public void setTipoDePago(String tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public Integer getNumeroDeFactura() {
        return numeroDeFactura;
    }

    public void setNumeroDeFactura(Integer numeroDeFactura) {
        this.numeroDeFactura = numeroDeFactura;
    }

    public Integer getPrimerCheque() {
        return primerCheque;
    }

    public void setPrimerCheque(Integer primerCheque) {
        this.primerCheque = primerCheque;
    }

    public Integer getSegundoCheque() {
        return segundoCheque;
    }

    public void setSegundoCheque(Integer segundoCheque) {
        this.segundoCheque = segundoCheque;
    }

    public Integer getTercerCheque() {
        return tercerCheque;
    }

    public void setTercerCheque(Integer tercerCheque) {
        this.tercerCheque = tercerCheque;
    }

    public String getNombreCheque() {
        return nombreCheque;
    }

    public void setNombreCheque(String nombreCheque) {
        this.nombreCheque = nombreCheque;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Usuario getUSUARIOidusuario() {
        return uSUARIOidusuario;
    }

    public void setUSUARIOidusuario(Usuario uSUARIOidusuario) {
        this.uSUARIOidusuario = uSUARIOidusuario;
    }

    @XmlTransient
    public Collection<DetalleNotaDeVenta> getDetalleNotaDeVentaCollection() {
        return detalleNotaDeVentaCollection;
    }

    public void setDetalleNotaDeVentaCollection(Collection<DetalleNotaDeVenta> detalleNotaDeVentaCollection) {
        this.detalleNotaDeVentaCollection = detalleNotaDeVentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numNotaDeVenta != null ? numNotaDeVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaDeVenta)) {
            return false;
        }
        NotaDeVenta other = (NotaDeVenta) object;
        if ((this.numNotaDeVenta == null && other.numNotaDeVenta != null) || (this.numNotaDeVenta != null && !this.numNotaDeVenta.equals(other.numNotaDeVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metalblanco.map.com.NotaDeVenta[ numNotaDeVenta=" + numNotaDeVenta + " ]";
    }
    
}
