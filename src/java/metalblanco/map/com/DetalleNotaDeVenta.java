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
@Table(name = "DETALLE_NOTA_DE_VENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleNotaDeVenta.findAll", query = "SELECT d FROM DetalleNotaDeVenta d"),
    @NamedQuery(name = "DetalleNotaDeVenta.findByIdDetNotVenta", query = "SELECT d FROM DetalleNotaDeVenta d WHERE d.idDetNotVenta = :idDetNotVenta"),
    @NamedQuery(name = "DetalleNotaDeVenta.findByCodProducto", query = "SELECT d FROM DetalleNotaDeVenta d WHERE d.codProducto = :codProducto"),
    @NamedQuery(name = "DetalleNotaDeVenta.findByDescripcion", query = "SELECT d FROM DetalleNotaDeVenta d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "DetalleNotaDeVenta.findByCantidad", query = "SELECT d FROM DetalleNotaDeVenta d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleNotaDeVenta.findByValorUnitario", query = "SELECT d FROM DetalleNotaDeVenta d WHERE d.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "DetalleNotaDeVenta.findByDescuento", query = "SELECT d FROM DetalleNotaDeVenta d WHERE d.descuento = :descuento"),
    @NamedQuery(name = "DetalleNotaDeVenta.findBySubtotal", query = "SELECT d FROM DetalleNotaDeVenta d WHERE d.subtotal = :subtotal")})
public class DetalleNotaDeVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_det_not_venta")
    private Integer idDetNotVenta;
    @Column(name = "cod_producto")
    private String codProducto;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_unitario")
    private Double valorUnitario;
    @Column(name = "descuento")
    private Double descuento;
    @Column(name = "subtotal")
    private Double subtotal;
    @JoinColumn(name = "NOTA_DE_VENTA_num_nota_de_venta", referencedColumnName = "num_nota_de_venta")
    @ManyToOne(optional = false)
    private NotaDeVenta nOTADEVENTAnumnotadeventa;

    public DetalleNotaDeVenta() {
    }

    public DetalleNotaDeVenta(Integer idDetNotVenta) {
        this.idDetNotVenta = idDetNotVenta;
    }

    public Integer getIdDetNotVenta() {
        return idDetNotVenta;
    }

    public void setIdDetNotVenta(Integer idDetNotVenta) {
        this.idDetNotVenta = idDetNotVenta;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public NotaDeVenta getNOTADEVENTAnumnotadeventa() {
        return nOTADEVENTAnumnotadeventa;
    }

    public void setNOTADEVENTAnumnotadeventa(NotaDeVenta nOTADEVENTAnumnotadeventa) {
        this.nOTADEVENTAnumnotadeventa = nOTADEVENTAnumnotadeventa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetNotVenta != null ? idDetNotVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleNotaDeVenta)) {
            return false;
        }
        DetalleNotaDeVenta other = (DetalleNotaDeVenta) object;
        if ((this.idDetNotVenta == null && other.idDetNotVenta != null) || (this.idDetNotVenta != null && !this.idDetNotVenta.equals(other.idDetNotVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metalblanco.map.com.DetalleNotaDeVenta[ idDetNotVenta=" + idDetNotVenta + " ]";
    }
    
}
