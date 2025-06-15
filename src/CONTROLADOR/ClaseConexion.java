package CONTROLADOR;
// iMPORTACION DE CLASES PARA SOPORTE DE CONEXION
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.*;


public class ClaseConexion {
    public PreparedStatement sql; // TRABAJO EN SENTENCIAS DE SQL
    public ResultSet datos;   // TRAER DATOS DE LA BD
    public Connection con=null;  // CONEXIÓN A LA BASE DE DATOS
    
public void MetodoConectar(){
//ESTABLECE  LA URL DE CONEXION BD
//DONDE LOCALHOST ES EL SERVIDOR Y 3306 PUERTO Y  EL NOMBRE DE LA BD(EMPRESA)

           String db="jdbc:mysql://localhost:3306/empresa";
           String usuario="wilsondelgado"; 
           String password="1102717619";
           try
           {   
               //SE OBTIENE EL DRIVE CONTROLADOR PARA MYSQL
               String controlador="com.mysql.jdbc.Driver"; // driver Mysql
               System.out.println("CONEXION CON BASE DE DATOS...." +db);
               //clase de controlador JDBC 
               Class.forName(controlador);
              // Establecer una conexión mediante la instrucción DriverManager.getConnection () .
               con=DriverManager.getConnection(db,usuario,password); // conectar la bd
               System.out.println("CONEXION EXITOSA");
           }
           catch(Exception ex)
           {
            System.out.println("Error "+ex.getMessage());
           }
    
    
    }
    
    public void cerrar(){
    
    if(con==null)
    {
    try
    { con.close();}
    catch(Exception ex)
     { }
    }
    
    }
    
}
