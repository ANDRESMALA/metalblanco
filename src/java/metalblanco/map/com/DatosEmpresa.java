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
@Table(name = "DATOS_EMPRESA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatosEmpresa.findAll", query = "SELECT d FROM DatosEmpresa d"),
    @NamedQuery(name = "DatosEmpresa.findByRutEmpresa", query = "SELECT d FROM DatosEmpresa d WHERE d.rutEmpresa = :rutEmpresa"),
    @NamedQuery(name = "DatosEmpresa.findByNomComercial", query = "SELECT d FROM DatosEmpresa d WHERE d.nomComercial = :nomComercial"),
    @NamedQuery(name = "DatosEmpresa.findByDireccion", query = "SELECT d FROM DatosEmpresa d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "DatosEmpresa.findByTelefono", query = "SELECT d FROM DatosEmpresa d WHERE d.telefono = :telefono"),
    @NamedQuery(name = "DatosEmpresa.findByEmail", query = "SELECT d FROM DatosEmpresa d WHERE d.email = :email"),
    @NamedQuery(name = "DatosEmpresa.findByNombreContacto", query = "SELECT d FROM DatosEmpresa d WHERE d.nombreContacto = :nombreContacto"),
    @NamedQuery(name = "DatosEmpresa.findByCuentaCorriente", query = "SELECT d FROM DatosEmpresa d WHERE d.cuentaCorriente = :cuentaCorriente"),
    @NamedQuery(name = "DatosEmpresa.findByIva", query = "SELECT d FROM DatosEmpresa d WHERE d.iva = :iva")})
public class DatosEmpresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rut_empresa")
    private Integer rutEmpresa;
    @Basic(optional = false)
    @Column(name = "nom_comercial")
    private String nomComercial;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "nombre_contacto")
    private String nombreContacto;
    @Basic(optional = false)
    @Column(name = "cuenta_corriente")
    private String cuentaCorriente;
    @Basic(optional = false)
    @Column(name = "iva")
    private double iva;
    @JoinColumn(name = "CIUDAD_codCiudad", referencedColumnName = "codCiudad")
    @ManyToOne(optional = false)
    private Ciudad cIUDADcodCiudad;

    public DatosEmpresa() {
    }

    public DatosEmpresa(Integer rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    public DatosEmpresa(Integer rutEmpresa, String nomComercial, String direccion, String telefono, String email, String nombreContacto, String cuentaCorriente, double iva) {
        this.rutEmpresa = rutEmpresa;
        this.nomComercial = nomComercial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.nombreContacto = nombreContacto;
        this.cuentaCorriente = cuentaCorriente;
        this.iva = iva;
    }

    public Integer getRutEmpresa() {
        return rutEmpresa;
    }

    public void setRutEmpresa(Integer rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
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

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(String cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
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
        hash += (rutEmpresa != null ? rutEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosEmpresa)) {
            return false;
        }
        DatosEmpresa other = (DatosEmpresa) object;
        if ((this.rutEmpresa == null && other.rutEmpresa != null) || (this.rutEmpresa != null && !this.rutEmpresa.equals(other.rutEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metalblanco.map.com.DatosEmpresa[ rutEmpresa=" + rutEmpresa + " ]";
    }
    
}
