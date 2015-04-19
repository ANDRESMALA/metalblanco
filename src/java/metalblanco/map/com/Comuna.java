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
@Table(name = "COMUNA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comuna.findAll", query = "SELECT c FROM Comuna c"),
    @NamedQuery(name = "Comuna.findByCodComuna", query = "SELECT c FROM Comuna c WHERE c.codComuna = :codComuna"),
    @NamedQuery(name = "Comuna.findByNomComuna", query = "SELECT c FROM Comuna c WHERE c.nomComuna = :nomComuna")})
public class Comuna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codComuna")
    private String codComuna;
    @Column(name = "nomComuna")
    private String nomComuna;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cOMUNAcodComuna")
    private Collection<Proveedor> proveedorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cOMUNAcodComuna")
    private Collection<Cliente> clienteCollection;
    @JoinColumn(name = "CIUDAD_codCiudad", referencedColumnName = "codCiudad")
    @ManyToOne(optional = false)
    private Ciudad cIUDADcodCiudad;

    public Comuna() {
    }

    public Comuna(String codComuna) {
        this.codComuna = codComuna;
    }

    public String getCodComuna() {
        return codComuna;
    }

    public void setCodComuna(String codComuna) {
        this.codComuna = codComuna;
    }

    public String getNomComuna() {
        return nomComuna;
    }

    public void setNomComuna(String nomComuna) {
        this.nomComuna = nomComuna;
    }

    @XmlTransient
    public Collection<Proveedor> getProveedorCollection() {
        return proveedorCollection;
    }

    public void setProveedorCollection(Collection<Proveedor> proveedorCollection) {
        this.proveedorCollection = proveedorCollection;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    public Ciudad getCIUDADcodCiudad() {
        return cIUDADcodCiudad;
    }

    public void setCIUDADcodCiudad(Ciudad cIUDADcodCiudad) {
        this.cIUDADcodCiudad = cIUDADcodCiudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codComuna != null ? codComuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comuna)) {
            return false;
        }
        Comuna other = (Comuna) object;
        if ((this.codComuna == null && other.codComuna != null) || (this.codComuna != null && !this.codComuna.equals(other.codComuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metalblanco.map.com.Comuna[ codComuna=" + codComuna + " ]";
    }
    
}
