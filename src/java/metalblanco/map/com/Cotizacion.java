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
@Table(name = "COTIZACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotizacion.findAll", query = "SELECT c FROM Cotizacion c"),
    @NamedQuery(name = "Cotizacion.findByNumCotizacion", query = "SELECT c FROM Cotizacion c WHERE c.numCotizacion = :numCotizacion"),
    @NamedQuery(name = "Cotizacion.findByFecha", query = "SELECT c FROM Cotizacion c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Cotizacion.findByRutCliente", query = "SELECT c FROM Cotizacion c WHERE c.rutCliente = :rutCliente"),
    @NamedQuery(name = "Cotizacion.findByRazonSocial", query = "SELECT c FROM Cotizacion c WHERE c.razonSocial = :razonSocial"),
    @NamedQuery(name = "Cotizacion.findByDireccion", query = "SELECT c FROM Cotizacion c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Cotizacion.findByTelefono", query = "SELECT c FROM Cotizacion c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Cotizacion.findByEmail", query = "SELECT c FROM Cotizacion c WHERE c.email = :email"),
    @NamedQuery(name = "Cotizacion.findByComuna", query = "SELECT c FROM Cotizacion c WHERE c.comuna = :comuna"),
    @NamedQuery(name = "Cotizacion.findByCiudad", query = "SELECT c FROM Cotizacion c WHERE c.ciudad = :ciudad"),
    @NamedQuery(name = "Cotizacion.findByVendedor", query = "SELECT c FROM Cotizacion c WHERE c.vendedor = :vendedor"),
    @NamedQuery(name = "Cotizacion.findByNeto", query = "SELECT c FROM Cotizacion c WHERE c.neto = :neto"),
    @NamedQuery(name = "Cotizacion.findByIva", query = "SELECT c FROM Cotizacion c WHERE c.iva = :iva"),
    @NamedQuery(name = "Cotizacion.findByTotal", query = "SELECT c FROM Cotizacion c WHERE c.total = :total"),
    @NamedQuery(name = "Cotizacion.findByNomContacto", query = "SELECT c FROM Cotizacion c WHERE c.nomContacto = :nomContacto"),
    @NamedQuery(name = "Cotizacion.findByDescuento", query = "SELECT c FROM Cotizacion c WHERE c.descuento = :descuento")})
public class Cotizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_cotizacion")
    private Integer numCotizacion;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "rut_cliente")
    private String rutCliente;
    @Column(name = "razon_social")
    private String razonSocial;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "neto")
    private Double neto;
    @Column(name = "iva")
    private Double iva;
    @Column(name = "total")
    private Double total;
    @Column(name = "nom_contacto")
    private String nomContacto;
    @Column(name = "descuento")
    private Double descuento;
    @JoinColumn(name = "USUARIO_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario uSUARIOidusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cOTIZACIONnumcotizacion")
    private Collection<DetalleDeCotizacion> detalleDeCotizacionCollection;

    public Cotizacion() {
    }

    public Cotizacion(Integer numCotizacion) {
        this.numCotizacion = numCotizacion;
    }

    public Integer getNumCotizacion() {
        return numCotizacion;
    }

    public void setNumCotizacion(Integer numCotizacion) {
        this.numCotizacion = numCotizacion;
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

    public String getNomContacto() {
        return nomContacto;
    }

    public void setNomContacto(String nomContacto) {
        this.nomContacto = nomContacto;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Usuario getUSUARIOidusuario() {
        return uSUARIOidusuario;
    }

    public void setUSUARIOidusuario(Usuario uSUARIOidusuario) {
        this.uSUARIOidusuario = uSUARIOidusuario;
    }

    @XmlTransient
    public Collection<DetalleDeCotizacion> getDetalleDeCotizacionCollection() {
        return detalleDeCotizacionCollection;
    }

    public void setDetalleDeCotizacionCollection(Collection<DetalleDeCotizacion> detalleDeCotizacionCollection) {
        this.detalleDeCotizacionCollection = detalleDeCotizacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numCotizacion != null ? numCotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotizacion)) {
            return false;
        }
        Cotizacion other = (Cotizacion) object;
        if ((this.numCotizacion == null && other.numCotizacion != null) || (this.numCotizacion != null && !this.numCotizacion.equals(other.numCotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metalblanco.map.com.Cotizacion[ numCotizacion=" + numCotizacion + " ]";
    }
    
}
