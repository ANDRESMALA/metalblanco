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
@Table(name = "CIUDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c"),
    @NamedQuery(name = "Ciudad.findByCodCiudad", query = "SELECT c FROM Ciudad c WHERE c.codCiudad = :codCiudad"),
    @NamedQuery(name = "Ciudad.findByNombreCiudad", query = "SELECT c FROM Ciudad c WHERE c.nombreCiudad = :nombreCiudad")})
public class Ciudad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codCiudad")
    private String codCiudad;
    @Column(name = "nombreCiudad")
    private String nombreCiudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cIUDADcodCiudad")
    private Collection<Comuna> comunaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cIUDADcodCiudad")
    private Collection<DatosEmpresa> datosEmpresaCollection;

    public Ciudad() {
    }

    public Ciudad(String codCiudad) {
        this.codCiudad = codCiudad;
    }

    public String getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(String codCiudad) {
        this.codCiudad = codCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    @XmlTransient
    public Collection<Comuna> getComunaCollection() {
        return comunaCollection;
    }

    public void setComunaCollection(Collection<Comuna> comunaCollection) {
        this.comunaCollection = comunaCollection;
    }

    @XmlTransient
    public Collection<DatosEmpresa> getDatosEmpresaCollection() {
        return datosEmpresaCollection;
    }

    public void setDatosEmpresaCollection(Collection<DatosEmpresa> datosEmpresaCollection) {
        this.datosEmpresaCollection = datosEmpresaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCiudad != null ? codCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.codCiudad == null && other.codCiudad != null) || (this.codCiudad != null && !this.codCiudad.equals(other.codCiudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metalblanco.map.com.Ciudad[ codCiudad=" + codCiudad + " ]";
    }
    
}
