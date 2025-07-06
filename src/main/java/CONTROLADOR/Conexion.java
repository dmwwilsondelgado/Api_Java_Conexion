/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

/**
 *
 * @author Propietario
 */

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/floresteria_encanto";
    private static final String USER = "wilsondelgado";
    private static final String PASW = "1102717619";
    

    public static Connection conectar() {
        try {
            Connection getconexion = DriverManager.getConnection(URL, USER, PASW);
            JOptionPane.showMessageDialog(null, "✅ Conexión exitosa");
            System.out.println("Conexión Exitosa");
            return getconexion; // AQUÍ DEVUELVES LA CONEXIÓN
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Conexión fallida: " + e.getMessage());
            return null;
        }
        
    }
}

