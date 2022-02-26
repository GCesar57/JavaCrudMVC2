/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

//import com.mysql.jdbc.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author phoenix055
 */
public class Conexion {
    private String base = "javacrudoop";
    private String user = "root";
    private String pass = "";
    private String url = "jdbc:mysql://localhost:3306/"+base;
    private Connection conn = null;
    //
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection)DriverManager.getConnection(this.url, this.user, this.pass);
            System.out.println("Connectado con exito...");
        } catch (SQLException e) {
            System.out.println("Error: "+e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }//
}
