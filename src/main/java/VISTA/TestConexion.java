package VISTA;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Propietario
 */
import MODELO.Conexion;
import java.sql.Connection;
public class TestConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection con = Conexion.conectar();
        if (con != null) {
            System.out.println("¡Está conectado a la base de datos!");
        } else {
            System.out.println("Error al conectar.");
        }
    }
    
}
