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
@Table(name = "TIPO_DE_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDeUsuario.findAll", query = "SELECT t FROM TipoDeUsuario t"),
    @NamedQuery(name = "TipoDeUsuario.findByIdTipoDeUsuario", query = "SELECT t FROM TipoDeUsuario t WHERE t.idTipoDeUsuario = :idTipoDeUsuario"),
    @NamedQuery(name = "TipoDeUsuario.findByCargo", query = "SELECT t FROM TipoDeUsuario t WHERE t.cargo = :cargo")})
public class TipoDeUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipo_de_usuario")
    private Integer idTipoDeUsuario;
    @Column(name = "cargo")
    private String cargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tIPODEUSUARIOidtipodeusuario")
    private Collection<Usuario> usuarioCollection;

    public TipoDeUsuario() {
    }

    public TipoDeUsuario(Integer idTipoDeUsuario) {
        this.idTipoDeUsuario = idTipoDeUsuario;
    }

    public Integer getIdTipoDeUsuario() {
        return idTipoDeUsuario;
    }

    public void setIdTipoDeUsuario(Integer idTipoDeUsuario) {
        this.idTipoDeUsuario = idTipoDeUsuario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDeUsuario != null ? idTipoDeUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDeUsuario)) {
            return false;
        }
        TipoDeUsuario other = (TipoDeUsuario) object;
        if ((this.idTipoDeUsuario == null && other.idTipoDeUsuario != null) || (this.idTipoDeUsuario != null && !this.idTipoDeUsuario.equals(other.idTipoDeUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metalblanco.map.com.TipoDeUsuario[ idTipoDeUsuario=" + idTipoDeUsuario + " ]";
    }
    
}
