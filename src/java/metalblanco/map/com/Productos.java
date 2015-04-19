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
@Table(name = "PRODUCTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByCodProducto", query = "SELECT p FROM Productos p WHERE p.codProducto = :codProducto"),
    @NamedQuery(name = "Productos.findByDescripcionProducto", query = "SELECT p FROM Productos p WHERE p.descripcionProducto = :descripcionProducto"),
    @NamedQuery(name = "Productos.findByValorNetoDeCompra", query = "SELECT p FROM Productos p WHERE p.valorNetoDeCompra = :valorNetoDeCompra"),
    @NamedQuery(name = "Productos.findByValorNetoDeVenta", query = "SELECT p FROM Productos p WHERE p.valorNetoDeVenta = :valorNetoDeVenta"),
    @NamedQuery(name = "Productos.findByIvaDeCompra", query = "SELECT p FROM Productos p WHERE p.ivaDeCompra = :ivaDeCompra"),
    @NamedQuery(name = "Productos.findByDescuento", query = "SELECT p FROM Productos p WHERE p.descuento = :descuento"),
    @NamedQuery(name = "Productos.findByStock", query = "SELECT p FROM Productos p WHERE p.stock = :stock"),
    @NamedQuery(name = "Productos.findByStockSeguridad", query = "SELECT p FROM Productos p WHERE p.stockSeguridad = :stockSeguridad"),
    @NamedQuery(name = "Productos.findByImagen", query = "SELECT p FROM Productos p WHERE p.imagen = :imagen")})
public class Productos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_producto")
    private String codProducto;
    @Column(name = "descripcion_producto")
    private String descripcionProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_neto_de_compra")
    private Double valorNetoDeCompra;
    @Column(name = "valor_neto_de_venta")
    private Double valorNetoDeVenta;
    @Column(name = "iva_de_compra")
    private Double ivaDeCompra;
    @Column(name = "descuento")
    private Double descuento;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "stock_seguridad")
    private Integer stockSeguridad;
    @Column(name = "imagen")
    private String imagen;
    @JoinColumn(name = "CATEGORIA_id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private Categoria cATEGORIAidcategoria;
    @JoinColumn(name = "PROVEEDOR_rut_proveedor", referencedColumnName = "rut_proveedor")
    @ManyToOne(optional = false)
    private Proveedor pROVEEDORrutproveedor;
    @JoinColumn(name = "USUARIO_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario uSUARIOidusuario;

    public Productos() {
    }

    public Productos(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public Double getValorNetoDeCompra() {
        return valorNetoDeCompra;
    }

    public void setValorNetoDeCompra(Double valorNetoDeCompra) {
        this.valorNetoDeCompra = valorNetoDeCompra;
    }

    public Double getValorNetoDeVenta() {
        return valorNetoDeVenta;
    }

    public void setValorNetoDeVenta(Double valorNetoDeVenta) {
        this.valorNetoDeVenta = valorNetoDeVenta;
    }

    public Double getIvaDeCompra() {
        return ivaDeCompra;
    }

    public void setIvaDeCompra(Double ivaDeCompra) {
        this.ivaDeCompra = ivaDeCompra;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStockSeguridad() {
        return stockSeguridad;
    }

    public void setStockSeguridad(Integer stockSeguridad) {
        this.stockSeguridad = stockSeguridad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Categoria getCATEGORIAidcategoria() {
        return cATEGORIAidcategoria;
    }

    public void setCATEGORIAidcategoria(Categoria cATEGORIAidcategoria) {
        this.cATEGORIAidcategoria = cATEGORIAidcategoria;
    }

    public Proveedor getPROVEEDORrutproveedor() {
        return pROVEEDORrutproveedor;
    }

    public void setPROVEEDORrutproveedor(Proveedor pROVEEDORrutproveedor) {
        this.pROVEEDORrutproveedor = pROVEEDORrutproveedor;
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
        hash += (codProducto != null ? codProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.codProducto == null && other.codProducto != null) || (this.codProducto != null && !this.codProducto.equals(other.codProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metalblanco.map.com.Productos[ codProducto=" + codProducto + " ]";
    }
    
}
