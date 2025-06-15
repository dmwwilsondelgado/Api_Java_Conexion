/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author wilso
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Usuario {
    Conexion conexion = new Conexion();

    public boolean login(String correo, String password) {
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND password = ?";
        try (Connection con = conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, correo);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            return rs.next(); // true si encuentra al usuario

        } catch (Exception e) {
            System.out.println("Error al verificar login: " + e.getMessage());
            return false;
        }
    }
}
