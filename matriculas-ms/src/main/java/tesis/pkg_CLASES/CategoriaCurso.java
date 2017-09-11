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
@Table(name = "categoria_curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaCurso.findAll", query = "SELECT c FROM CategoriaCurso c")
    , @NamedQuery(name = "CategoriaCurso.findByIdCategoria", query = "SELECT c FROM CategoriaCurso c WHERE c.idCategoria = :idCategoria")
    , @NamedQuery(name = "CategoriaCurso.findByNombreCategoria", query = "SELECT c FROM CategoriaCurso c WHERE c.nombreCategoria = :nombreCategoria")
    , @NamedQuery(name = "CategoriaCurso.findByRangoedadInicio", query = "SELECT c FROM CategoriaCurso c WHERE c.rangoedadInicio = :rangoedadInicio")
    , @NamedQuery(name = "CategoriaCurso.findByRangoedadFin", query = "SELECT c FROM CategoriaCurso c WHERE c.rangoedadFin = :rangoedadFin")})
public class CategoriaCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @Size(max = 1024)
    @Column(name = "nombre_categoria")
    private String nombreCategoria;
    @Column(name = "rango_edadInicio")
    private Integer rangoedadInicio;
    @Column(name = "rango_edadFin")
    private Integer rangoedadFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria")
    private List<Cursos> cursosList;

    public CategoriaCurso() {
    }

    public CategoriaCurso(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Integer getRangoedadInicio() {
        return rangoedadInicio;
    }

    public void setRangoedadInicio(Integer rangoedadInicio) {
        this.rangoedadInicio = rangoedadInicio;
    }

    public Integer getRangoedadFin() {
        return rangoedadFin;
    }

    public void setRangoedadFin(Integer rangoedadFin) {
        this.rangoedadFin = rangoedadFin;
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
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaCurso)) {
            return false;
        }
        CategoriaCurso other = (CategoriaCurso) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_CLASES.CategoriaCurso[ idCategoria=" + idCategoria + " ]";
    }
    
}
