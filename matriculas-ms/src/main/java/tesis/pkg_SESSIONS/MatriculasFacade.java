/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesis.pkg_SESSIONS;

import tesis.pkg_CLASES.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import javax.ejb.Stateless;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import tesis.pkg_DATOS.*; 

/**
 *
 * @author thesis
 */
//@Stateless
//public class MatriculasFacade extends AbstractFacade<Matriculas> {
@Service
public class MatriculasFacade{
    //se puede llamar al jdb de la conexcion??

    private Connection connection = new conexionBD().getConection();

    //@PersistenceContext(unitName = "com.tesis_srcl3_war_1.0-SNAPSHOTPU")
    //private EntityManager em;

    //@Override
    /*protected EntityManager getEntityManager() {
        return em;
    }*/
    //Singleton
    //1. Variable estatica privada
    private static final MatriculasFacade mf = new MatriculasFacade();

    //2. Constructor privado
    /*private MatriculasFacade() {
       
    }*/

    private MatriculasFacade() {
        //super(Matriculas.class);
    }

    //3.metodo de acceso publico estatico
    public static MatriculasFacade getMatricula() {
        return mf;
    }

    public ArrayList<Matriculas> matriculasByCurso(int idcurso) {
        ArrayList<Matriculas> listaMatriculasPorCurso = new ArrayList<Matriculas>();

        try {
            CallableStatement statement = connection.prepareCall("{CALL matByCurso(?)}");
            statement.setInt("_idcurso", idcurso);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Estudiantes est = new Estudiantes();
                est.setIdEstudiante(resultSet.getInt("id_estudiante"));
                est.setNombres(resultSet.getString("nombres"));
                est.setApellidos(resultSet.getString("apellidos"));
                Cursos cur = new Cursos();
                cur.setIdCurso(resultSet.getInt("id_curso"));
                Matriculas mat = new Matriculas();
                mat.setIdMatricula(resultSet.getInt("idMatricula"));
                mat.setEstado(resultSet.getString("estado"));
                mat.setFechaMat(resultSet.getDate("fecha_mat"));
                mat.setIdEstudiante(est);
                mat.setIdCurso(cur);
                listaMatriculasPorCurso.add(mat);
            }
            return listaMatriculasPorCurso;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
