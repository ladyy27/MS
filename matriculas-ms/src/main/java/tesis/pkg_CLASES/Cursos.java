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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thesis
 */
@Entity
@Table(name = "cursos")
@XmlRootElement

@NamedQueries({
    @NamedQuery(name = "Cursos.findAll", query = "SELECT c FROM Cursos c")
    , @NamedQuery(name = "Cursos.findByIdCurso", query = "SELECT c FROM Cursos c WHERE c.idCurso = :idCurso")
    , @NamedQuery(name = "Cursos.findByNombreCurso", query = "SELECT c FROM Cursos c WHERE c.nombreCurso = :nombreCurso")
    , @NamedQuery(name = "Cursos.findByNumHoras", query = "SELECT c FROM Cursos c WHERE c.numHoras = :numHoras")})

public class Cursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_curso")
    private Integer idCurso;
    @Size(max = 1024)
    @Column(name = "nombre_curso")
    private String nombreCurso;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "num_horas")
    private Integer numHoras;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private CategoriaCurso idCategoria;
    @JoinColumn(name = "id_periodo", referencedColumnName = "id_periodo")
    @ManyToOne(optional = false)
    private Periodo idPeriodo;
    @JoinColumn(name = "id_tutor", referencedColumnName = "id_tutor")
    @ManyToOne(optional = false)
    private Tutor idTutor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCurso")
    private List<Matriculas> matriculasList;

    public Cursos() {
    }

    public Cursos(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(Integer numHoras) {
        this.numHoras = numHoras;
    }

    public CategoriaCurso getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(CategoriaCurso idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Periodo getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Periodo idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Tutor getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Tutor idTutor) {
        this.idTutor = idTutor;
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
        hash += (idCurso != null ? idCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cursos)) {
            return false;
        }
        Cursos other = (Cursos) object;
        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_CLASES.Cursos[ idCurso=" + idCurso + " ]";
    }
    
}
