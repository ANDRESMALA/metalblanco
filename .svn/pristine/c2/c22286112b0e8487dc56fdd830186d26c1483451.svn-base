/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalblanco.map.com;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andresmalagueno
 */
@Entity
@Table(name = "DETALLE_DE_COTIZACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleDeCotizacion.findAll", query = "SELECT d FROM DetalleDeCotizacion d"),
    @NamedQuery(name = "DetalleDeCotizacion.findByIdDetDeCot", query = "SELECT d FROM DetalleDeCotizacion d WHERE d.idDetDeCot = :idDetDeCot"),
    @NamedQuery(name = "DetalleDeCotizacion.findByCodProducto", query = "SELECT d FROM DetalleDeCotizacion d WHERE d.codProducto = :codProducto"),
    @NamedQuery(name = "DetalleDeCotizacion.findByDescripcion", query = "SELECT d FROM DetalleDeCotizacion d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "DetalleDeCotizacion.findByCantidad", query = "SELECT d FROM DetalleDeCotizacion d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleDeCotizacion.findByValorUnitario", query = "SELECT d FROM DetalleDeCotizacion d WHERE d.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "DetalleDeCotizacion.findByDescuento", query = "SELECT d FROM DetalleDeCotizacion d WHERE d.descuento = :descuento"),
    @NamedQuery(name = "DetalleDeCotizacion.findBySubtotal", query = "SELECT d FROM DetalleDeCotizacion d WHERE d.subtotal = :subtotal")})
public class DetalleDeCotizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_det_de_cot")
    private Integer idDetDeCot;
    @Basic(optional = false)
    @Column(name = "cod_producto")
    private String codProducto;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "valor_unitario")
    private double valorUnitario;
    @Basic(optional = false)
    @Column(name = "descuento")
    private double descuento;
    @Basic(optional = false)
    @Column(name = "subtotal")
    private double subtotal;
    @JoinColumn(name = "COTIZACION_num_cotizacion", referencedColumnName = "num_cotizacion")
    @ManyToOne(optional = false)
    private Cotizacion cOTIZACIONnumcotizacion;

    public DetalleDeCotizacion() {
    }

    public DetalleDeCotizacion(Integer idDetDeCot) {
        this.idDetDeCot = idDetDeCot;
    }

    public DetalleDeCotizacion(Integer idDetDeCot, String codProducto, String descripcion, int cantidad, double valorUnitario, double descuento, double subtotal) {
        this.idDetDeCot = idDetDeCot;
        this.codProducto = codProducto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.descuento = descuento;
        this.subtotal = subtotal;
    }

    public Integer getIdDetDeCot() {
        return idDetDeCot;
    }

    public void setIdDetDeCot(Integer idDetDeCot) {
        this.idDetDeCot = idDetDeCot;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Cotizacion getCOTIZACIONnumcotizacion() {
        return cOTIZACIONnumcotizacion;
    }

    public void setCOTIZACIONnumcotizacion(Cotizacion cOTIZACIONnumcotizacion) {
        this.cOTIZACIONnumcotizacion = cOTIZACIONnumcotizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetDeCot != null ? idDetDeCot.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleDeCotizacion)) {
            return false;
        }
        DetalleDeCotizacion other = (DetalleDeCotizacion) object;
        if ((this.idDetDeCot == null && other.idDetDeCot != null) || (this.idDetDeCot != null && !this.idDetDeCot.equals(other.idDetDeCot))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metalblanco.map.com.DetalleDeCotizacion[ idDetDeCot=" + idDetDeCot + " ]";
    }
    
}
