/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalblanco.map.com;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andresmalagueno
 */
@Entity
@Table(name = "PROVEEDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByRutProveedor", query = "SELECT p FROM Proveedor p WHERE p.rutProveedor = :rutProveedor"),
    @NamedQuery(name = "Proveedor.findByNomComercial", query = "SELECT p FROM Proveedor p WHERE p.nomComercial = :nomComercial"),
    @NamedQuery(name = "Proveedor.findByDireccion", query = "SELECT p FROM Proveedor p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Proveedor.findByTelefono", query = "SELECT p FROM Proveedor p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Proveedor.findByEmail", query = "SELECT p FROM Proveedor p WHERE p.email = :email"),
    @NamedQuery(name = "Proveedor.findByCondicionDePago", query = "SELECT p FROM Proveedor p WHERE p.condicionDePago = :condicionDePago")})
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rut_proveedor")
    private String rutProveedor;
    @Basic(optional = false)
    @Column(name = "nom_comercial")
    private String nomComercial;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;
    @Column(name = "condicion_de_pago")
    private String condicionDePago;
    @JoinColumn(name = "COMUNA_codComuna", referencedColumnName = "codComuna")
    @ManyToOne(optional = false)
    private Comuna cOMUNAcodComuna;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pROVEEDORrutproveedor")
    private Collection<Productos> productosCollection;

    public Proveedor() {
    }

    public Proveedor(String rutProveedor) {
        this.rutProveedor = rutProveedor;
    }

    public Proveedor(String rutProveedor, String nomComercial) {
        this.rutProveedor = rutProveedor;
        this.nomComercial = nomComercial;
    }

    public String getRutProveedor() {
        return rutProveedor;
    }

    public void setRutProveedor(String rutProveedor) {
        this.rutProveedor = rutProveedor;
    }

    public String getNomComercial() {
        return nomComercial;
    }

    public void setNomComercial(String nomComercial) {
        this.nomComercial = nomComercial;
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

    public String getCondicionDePago() {
        return condicionDePago;
    }

    public void setCondicionDePago(String condicionDePago) {
        this.condicionDePago = condicionDePago;
    }

    public Comuna getCOMUNAcodComuna() {
        return cOMUNAcodComuna;
    }

    public void setCOMUNAcodComuna(Comuna cOMUNAcodComuna) {
        this.cOMUNAcodComuna = cOMUNAcodComuna;
    }

    @XmlTransient
    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutProveedor != null ? rutProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.rutProveedor == null && other.rutProveedor != null) || (this.rutProveedor != null && !this.rutProveedor.equals(other.rutProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metalblanco.map.com.Proveedor[ rutProveedor=" + rutProveedor + " ]";
    }
    
}
