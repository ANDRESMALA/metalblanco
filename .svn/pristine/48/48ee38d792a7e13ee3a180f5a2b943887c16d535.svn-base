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
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByRutCliente", query = "SELECT c FROM Cliente c WHERE c.rutCliente = :rutCliente"),
    @NamedQuery(name = "Cliente.findByNomComercial", query = "SELECT c FROM Cliente c WHERE c.nomComercial = :nomComercial"),
    @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email"),
    @NamedQuery(name = "Cliente.findByNomContacto", query = "SELECT c FROM Cliente c WHERE c.nomContacto = :nomContacto"),
    @NamedQuery(name = "Cliente.findByCuentaCorriente", query = "SELECT c FROM Cliente c WHERE c.cuentaCorriente = :cuentaCorriente"),
    @NamedQuery(name = "Cliente.findByRepresentante", query = "SELECT c FROM Cliente c WHERE c.representante = :representante"),
    @NamedQuery(name = "Cliente.findByGiro", query = "SELECT c FROM Cliente c WHERE c.giro = :giro")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rut_cliente")
    private String rutCliente;
    @Basic(optional = false)
    @Column(name = "nom_comercial")
    private String nomComercial;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;
    @Column(name = "nom_contacto")
    private String nomContacto;
    @Column(name = "cuenta_corriente")
    private String cuentaCorriente;
    @Column(name = "representante")
    private String representante;
    @Column(name = "giro")
    private String giro;
    @JoinColumn(name = "COMUNA_codComuna", referencedColumnName = "codComuna")
    @ManyToOne(optional = false)
    private Comuna cOMUNAcodComuna;

    public Cliente() {
    }

    public Cliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public Cliente(String rutCliente, String nomComercial, String direccion) {
        this.rutCliente = rutCliente;
        this.nomComercial = nomComercial;
        this.direccion = direccion;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
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

    public String getNomContacto() {
        return nomContacto;
    }

    public void setNomContacto(String nomContacto) {
        this.nomContacto = nomContacto;
    }

    public String getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(String cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    public Comuna getCOMUNAcodComuna() {
        return cOMUNAcodComuna;
    }

    public void setCOMUNAcodComuna(Comuna cOMUNAcodComuna) {
        this.cOMUNAcodComuna = cOMUNAcodComuna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutCliente != null ? rutCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.rutCliente == null && other.rutCliente != null) || (this.rutCliente != null && !this.rutCliente.equals(other.rutCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metalblanco.map.com.Cliente[ rutCliente=" + rutCliente + " ]";
    }
    
}
