/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesis.pkg_DATOS;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ela
 */

public class conexionBD {
    private Connection conection = null;
    public Connection getConection() {
        if (conection == null) {
            try {
                Driver driver = new com.mysql.jdbc.Driver();
                DriverManager.registerDriver(driver);
                //conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/srcl", "root", "root");
                conection = DriverManager.getConnection("jdbc:mysql://172.18.0.3:3306/srcl", "root", "root");
            } catch (SQLException ex) {
                ex.printStackTrace();
                Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conection;
    }
    
}