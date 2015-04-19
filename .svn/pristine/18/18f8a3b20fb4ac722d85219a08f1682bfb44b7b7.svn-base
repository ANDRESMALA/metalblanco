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
@Table(name = "DETALLE_FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d"),
    @NamedQuery(name = "DetalleFactura.findByIdDetFactura", query = "SELECT d FROM DetalleFactura d WHERE d.idDetFactura = :idDetFactura"),
    @NamedQuery(name = "DetalleFactura.findByCodProducto", query = "SELECT d FROM DetalleFactura d WHERE d.codProducto = :codProducto"),
    @NamedQuery(name = "DetalleFactura.findByDescripcion", query = "SELECT d FROM DetalleFactura d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "DetalleFactura.findByCantidad", query = "SELECT d FROM DetalleFactura d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleFactura.findByValorUnitario", query = "SELECT d FROM DetalleFactura d WHERE d.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "DetalleFactura.findByDescuento", query = "SELECT d FROM DetalleFactura d WHERE d.descuento = :descuento"),
    @NamedQuery(name = "DetalleFactura.findBySubtotal", query = "SELECT d FROM DetalleFactura d WHERE d.subtotal = :subtotal")})
public class DetalleFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_det_factura")
    private Integer idDetFactura;
    @Column(name = "cod_producto")
    private String codProducto;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cantidad")
    private String cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_unitario")
    private Double valorUnitario;
    @Column(name = "descuento")
    private Double descuento;
    @Column(name = "subtotal")
    private Double subtotal;
    @JoinColumn(name = "FACTURA_num_factura", referencedColumnName = "num_factura")
    @ManyToOne(optional = false)
    private Factura fACTURAnumfactura;

    public DetalleFactura() {
    }

    public DetalleFactura(Integer idDetFactura) {
        this.idDetFactura = idDetFactura;
    }

    public Integer getIdDetFactura() {
        return idDetFactura;
    }

    public void setIdDetFactura(Integer idDetFactura) {
        this.idDetFactura = idDetFactura;
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

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
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

    public Factura getFACTURAnumfactura() {
        return fACTURAnumfactura;
    }

    public void setFACTURAnumfactura(Factura fACTURAnumfactura) {
        this.fACTURAnumfactura = fACTURAnumfactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetFactura != null ? idDetFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFactura)) {
            return false;
        }
        DetalleFactura other = (DetalleFactura) object;
        if ((this.idDetFactura == null && other.idDetFactura != null) || (this.idDetFactura != null && !this.idDetFactura.equals(other.idDetFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metalblanco.map.com.DetalleFactura[ idDetFactura=" + idDetFactura + " ]";
    }
    
}
