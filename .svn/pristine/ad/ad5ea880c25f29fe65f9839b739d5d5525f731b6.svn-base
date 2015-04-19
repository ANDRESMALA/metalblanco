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
@Table(name = "FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByNumFactura", query = "SELECT f FROM Factura f WHERE f.numFactura = :numFactura"),
    @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "Factura.findByRutCliente", query = "SELECT f FROM Factura f WHERE f.rutCliente = :rutCliente"),
    @NamedQuery(name = "Factura.findByRazonSocial", query = "SELECT f FROM Factura f WHERE f.razonSocial = :razonSocial"),
    @NamedQuery(name = "Factura.findByGiro", query = "SELECT f FROM Factura f WHERE f.giro = :giro"),
    @NamedQuery(name = "Factura.findByDireccion", query = "SELECT f FROM Factura f WHERE f.direccion = :direccion"),
    @NamedQuery(name = "Factura.findByTelefono", query = "SELECT f FROM Factura f WHERE f.telefono = :telefono"),
    @NamedQuery(name = "Factura.findByEmail", query = "SELECT f FROM Factura f WHERE f.email = :email"),
    @NamedQuery(name = "Factura.findByComuna", query = "SELECT f FROM Factura f WHERE f.comuna = :comuna"),
    @NamedQuery(name = "Factura.findByCiudad", query = "SELECT f FROM Factura f WHERE f.ciudad = :ciudad"),
    @NamedQuery(name = "Factura.findByVendedor", query = "SELECT f FROM Factura f WHERE f.vendedor = :vendedor"),
    @NamedQuery(name = "Factura.findByNeto", query = "SELECT f FROM Factura f WHERE f.neto = :neto"),
    @NamedQuery(name = "Factura.findByDescuento", query = "SELECT f FROM Factura f WHERE f.descuento = :descuento"),
    @NamedQuery(name = "Factura.findByIva", query = "SELECT f FROM Factura f WHERE f.iva = :iva"),
    @NamedQuery(name = "Factura.findByTotal", query = "SELECT f FROM Factura f WHERE f.total = :total"),
    @NamedQuery(name = "Factura.findByEstadoDelPago", query = "SELECT f FROM Factura f WHERE f.estadoDelPago = :estadoDelPago"),
    @NamedQuery(name = "Factura.findByEstadoFacturacion", query = "SELECT f FROM Factura f WHERE f.estadoFacturacion = :estadoFacturacion"),
    @NamedQuery(name = "Factura.findByTipoDePago", query = "SELECT f FROM Factura f WHERE f.tipoDePago = :tipoDePago")})
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_factura")
    private Integer numFactura;
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
    @Basic(optional = false)
    @Column(name = "giro")
    private String giro;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "comuna")
    private String comuna;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "vendedor")
    private String vendedor;
    @Basic(optional = false)
    @Column(name = "neto")
    private double neto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "descuento")
    private Double descuento;
    @Basic(optional = false)
    @Column(name = "iva")
    private double iva;
    @Basic(optional = false)
    @Column(name = "total")
    private String total;
    @Basic(optional = false)
    @Column(name = "estado_del_pago")
    private String estadoDelPago;
    @Basic(optional = false)
    @Column(name = "estado_facturacion")
    private String estadoFacturacion;
    @Basic(optional = false)
    @Column(name = "tipo_de_pago")
    private String tipoDePago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fACTURAnumfactura")
    private Collection<DetalleFactura> detalleFacturaCollection;
    @JoinColumn(name = "USUARIO_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario uSUARIOidusuario;

    public Factura() {
    }

    public Factura(Integer numFactura) {
        this.numFactura = numFactura;
    }

    public Factura(Integer numFactura, Date fecha, String rutCliente, String razonSocial, String giro, String direccion, String telefono, String email, String comuna, String ciudad, double neto, double iva, String total, String estadoDelPago, String estadoFacturacion, String tipoDePago) {
        this.numFactura = numFactura;
        this.fecha = fecha;
        this.rutCliente = rutCliente;
        this.razonSocial = razonSocial;
        this.giro = giro;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.comuna = comuna;
        this.ciudad = ciudad;
        this.neto = neto;
        this.iva = iva;
        this.total = total;
        this.estadoDelPago = estadoDelPago;
        this.estadoFacturacion = estadoFacturacion;
        this.tipoDePago = tipoDePago;
    }

    public Integer getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(Integer numFactura) {
        this.numFactura = numFactura;
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

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
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

    public double getNeto() {
        return neto;
    }

    public void setNeto(double neto) {
        this.neto = neto;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
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

    @XmlTransient
    public Collection<DetalleFactura> getDetalleFacturaCollection() {
        return detalleFacturaCollection;
    }

    public void setDetalleFacturaCollection(Collection<DetalleFactura> detalleFacturaCollection) {
        this.detalleFacturaCollection = detalleFacturaCollection;
    }

    public Usuario getUSUARIOidusuario() {
        return uSUARIOidusuario;
    }

    public void setUSUARIOidusuario(Usuario uSUARIOidusuario) {
        this.uSUARIOidusuario = uSUARIOidusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numFactura != null ? numFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.numFactura == null && other.numFactura != null) || (this.numFactura != null && !this.numFactura.equals(other.numFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metalblanco.map.com.Factura[ numFactura=" + numFactura + " ]";
    }
    
}
