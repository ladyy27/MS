/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesis.pkg_CLASES;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thesis
 */
@Entity
@Table(name = "tutor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tutor.findAll", query = "SELECT t FROM Tutor t")
    , @NamedQuery(name = "Tutor.findByIdTutor", query = "SELECT t FROM Tutor t WHERE t.idTutor = :idTutor")
    , @NamedQuery(name = "Tutor.findByCItutor", query = "SELECT t FROM Tutor t WHERE t.cItutor = :cItutor")
    , @NamedQuery(name = "Tutor.findByNombreTutor", query = "SELECT t FROM Tutor t WHERE t.nombreTutor = :nombreTutor")
    , @NamedQuery(name = "Tutor.findByApellidoTutor", query = "SELECT t FROM Tutor t WHERE t.apellidoTutor = :apellidoTutor")
    , @NamedQuery(name = "Tutor.findByEMail", query = "SELECT t FROM Tutor t WHERE t.eMail = :eMail")
    , @NamedQuery(name = "Tutor.findByUsername", query = "SELECT t FROM Tutor t WHERE t.username = :username")
    , @NamedQuery(name = "Tutor.findByPassword", query = "SELECT t FROM Tutor t WHERE t.password = :password")
    , @NamedQuery(name = "Tutor.findByRol", query = "SELECT t FROM Tutor t WHERE t.rol = :rol")})
public class Tutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tutor")
    private Integer idTutor;
    @Size(max = 11)
    @Column(name = "CI_tutor")
    private String cItutor;
    @Size(max = 1024)
    @Column(name = "nombre_tutor")
    private String nombreTutor;
    @Size(max = 1024)
    @Column(name = "apellido_tutor")
    private String apellidoTutor;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 1024)
    @Column(name = "e_mail")
    private String eMail;
    @Lob
    @Size(max = 65535)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 45)
    @Column(name = "username")
    private String username;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rol")
    private int rol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTutor")
    private List<Cursos> cursosList;

    public Tutor() {
    }

    public Tutor(Integer idTutor) {
        this.idTutor = idTutor;
    }

    public Tutor(Integer idTutor, int rol) {
        this.idTutor = idTutor;
        this.rol = rol;
    }

    public Integer getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Integer idTutor) {
        this.idTutor = idTutor;
    }

    public String getCItutor() {
        return cItutor;
    }

    public void setCItutor(String cItutor) {
        this.cItutor = cItutor;
    }

    public String getNombreTutor() {
        return nombreTutor;
    }

    public void setNombreTutor(String nombreTutor) {
        this.nombreTutor = nombreTutor;
    }

    public String getApellidoTutor() {
        return apellidoTutor;
    }

    public void setApellidoTutor(String apellidoTutor) {
        this.apellidoTutor = apellidoTutor;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
    public List<Cursos> getCursosList() {
        return cursosList;
    }

    public void setCursosList(List<Cursos> cursosList) {
        this.cursosList = cursosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTutor != null ? idTutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tutor)) {
            return false;
        }
        Tutor other = (Tutor) object;
        if ((this.idTutor == null && other.idTutor != null) || (this.idTutor != null && !this.idTutor.equals(other.idTutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_CLASES.Tutor[ idTutor=" + idTutor + " ]";
    }
    
}
