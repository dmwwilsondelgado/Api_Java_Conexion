/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.io.*;
import java.sql.SQLException;

/**
 *
 * @author wilso
 */
public class Conexion {
    public PreparedStatement sql; // trabajo para las sentecias de sql 
    public ResultSet datos;// traer datos de la bd
    public Connection con=null; // conexion ala base de datos

    public final String url = "jdbc:mysql://localhost:3306/floresteria_encanto_database";
    public final String user = "wilsondelgado";
    public final String password = "1102717619";
    public Connection conexion;
    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return conexion;
    }
}
