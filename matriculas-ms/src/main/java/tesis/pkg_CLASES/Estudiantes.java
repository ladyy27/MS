/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesis.pkg_CLASES;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thesis
 */
@Entity
@Table(name = "estudiantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiantes.findAll", query = "SELECT e FROM Estudiantes e")
    , @NamedQuery(name = "Estudiantes.findByIdEstudiante", query = "SELECT e FROM Estudiantes e WHERE e.idEstudiante = :idEstudiante")
    , @NamedQuery(name = "Estudiantes.findByCi", query = "SELECT e FROM Estudiantes e WHERE e.ci = :ci")
    , @NamedQuery(name = "Estudiantes.findByFechaNac", query = "SELECT e FROM Estudiantes e WHERE e.fechaNac = :fechaNac")
    , @NamedQuery(name = "Estudiantes.findByEMail", query = "SELECT e FROM Estudiantes e WHERE e.eMail = :eMail")
    , @NamedQuery(name = "Estudiantes.findByUsername", query = "SELECT e FROM Estudiantes e WHERE e.username = :username")
    , @NamedQuery(name = "Estudiantes.findByPassword", query = "SELECT e FROM Estudiantes e WHERE e.password = :password")
    , @NamedQuery(name = "Estudiantes.findByRol", query = "SELECT e FROM Estudiantes e WHERE e.rol = :rol")})
public class Estudiantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estudiante")
    private Integer idEstudiante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "CI")
    private String ci;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "fecha_nac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 1024)
    @Column(name = "e_mail")
    private String eMail;
    @Size(max = 45)
    @Column(name = "username")
    private String username;
    @Size(max = 8)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rol")
    private int rol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstudiante")
    private List<Matriculas> matriculasList;

    public Estudiantes() {
    }

    public Estudiantes(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Estudiantes(Integer idEstudiante, String ci, String nombres, String apellidos, int rol) {
        this.idEstudiante = idEstudiante;
        this.ci = ci;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.rol = rol;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    @XmlTransient
    public List<Matriculas> getMatriculasList() {
        return matriculasList;
    }

    public void setMatriculasList(List<Matriculas> matriculasList) {
        this.matriculasList = matriculasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudiante != null ? idEstudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiantes)) {
            return false;
        }
        Estudiantes other = (Estudiantes) object;
        if ((this.idEstudiante == null && other.idEstudiante != null) || (this.idEstudiante != null && !this.idEstudiante.equals(other.idEstudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_CLASES.Estudiantes[ idEstudiante=" + idEstudiante + " ]";
    }
    
}
