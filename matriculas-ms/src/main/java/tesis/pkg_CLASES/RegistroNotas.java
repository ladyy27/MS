/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesis.pkg_CLASES;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thesis
 */
@Entity
@Table(name = "registro_notas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroNotas.findAll", query = "SELECT r FROM RegistroNotas r")
    , @NamedQuery(name = "RegistroNotas.findByIdRegistro", query = "SELECT r FROM RegistroNotas r WHERE r.idRegistro = :idRegistro")
    , @NamedQuery(name = "RegistroNotas.findByNotaTest1", query = "SELECT r FROM RegistroNotas r WHERE r.notaTest1 = :notaTest1")
    , @NamedQuery(name = "RegistroNotas.findByNotaTest2", query = "SELECT r FROM RegistroNotas r WHERE r.notaTest2 = :notaTest2")
    , @NamedQuery(name = "RegistroNotas.findByNotaFinal", query = "SELECT r FROM RegistroNotas r WHERE r.notaFinal = :notaFinal")
    , @NamedQuery(name = "RegistroNotas.findByEstado", query = "SELECT r FROM RegistroNotas r WHERE r.estado = :estado")})
public class RegistroNotas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRegistro")
    private Integer idRegistro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "notaTest1")
    private Double notaTest1;
    @Column(name = "notaTest2")
    private Double notaTest2;
    @Column(name = "notaFinal")
    private Double notaFinal;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idMatricula", referencedColumnName = "idMatricula")
    @ManyToOne(optional = false)
    private Matriculas idMatricula;

    public RegistroNotas() {
    }

    public RegistroNotas(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Double getNotaTest1() {
        return notaTest1;
    }

    public void setNotaTest1(Double notaTest1) {
        this.notaTest1 = notaTest1;
    }

    public Double getNotaTest2() {
        return notaTest2;
    }

    public void setNotaTest2(Double notaTest2) {
        this.notaTest2 = notaTest2;
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Matriculas getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Matriculas idMatricula) {
        this.idMatricula = idMatricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistro != null ? idRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroNotas)) {
            return false;
        }
        RegistroNotas other = (RegistroNotas) object;
        if ((this.idRegistro == null && other.idRegistro != null) || (this.idRegistro != null && !this.idRegistro.equals(other.idRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_CLASES.RegistroNotas[ idRegistro=" + idRegistro + " ]";
    }
    
}
