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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thesis
 */
@Entity
@Table(name = "matriculas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matriculas.findAll", query = "SELECT m FROM Matriculas m")
    , @NamedQuery(name = "Matriculas.findByIdMatricula", query = "SELECT m FROM Matriculas m WHERE m.idMatricula = :idMatricula")
    //, @NamedQuery(name = "Matriculas.findByIdCurso", query = "SELECT m FROM Matriculas m WHERE m.id_curso = :idCurso")
    , @NamedQuery(name = "Matriculas.findByEstado", query = "SELECT m FROM Matriculas m WHERE m.estado = :estado")
    , @NamedQuery(name = "Matriculas.findByFechaMat", query = "SELECT m FROM Matriculas m WHERE m.fechaMat = :fechaMat")})
public class Matriculas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMatricula")
    private Integer idMatricula;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha_mat")
    @Temporal(TemporalType.DATE)
    private Date fechaMat;
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso")
    @ManyToOne(optional = false)
    private Cursos idCurso;
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_estudiante")
    @ManyToOne(optional = false)
    private Estudiantes idEstudiante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMatricula")
    private List<RegistroNotas> registroNotasList;

    public Matriculas() {
    }

    public Matriculas(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Integer getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaMat() {
        return fechaMat;
    }

    public void setFechaMat(Date fechaMat) {
        this.fechaMat = fechaMat;
    }

    public Cursos getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Cursos idCurso) {
        this.idCurso = idCurso;
    }

    public Estudiantes getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Estudiantes idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @XmlTransient
    public List<RegistroNotas> getRegistroNotasList() {
        return registroNotasList;
    }

    public void setRegistroNotasList(List<RegistroNotas> registroNotasList) {
        this.registroNotasList = registroNotasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatricula != null ? idMatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matriculas)) {
            return false;
        }
        Matriculas other = (Matriculas) object;
        if ((this.idMatricula == null && other.idMatricula != null) || (this.idMatricula != null && !this.idMatricula.equals(other.idMatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_CLASES.Matriculas[ idMatricula=" + idMatricula + " ]";
    }
    
}
