/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author Propietario
 */

import  java.sql.*;
import javax.swing.JOptionPane;
public class UsuarioDAO {
    private Connection conexion;
    public UsuarioDAO(Connection conexion){
        this.conexion = conexion; // cramoes el constructor para hacer la conexion 
    }
    public boolean validarUusario(String correo, String password ,String TipoUsuario){
        String sql= "SELECT * FROM usuarios WHERE correo =  ? and password = ? and tipo_usuario = ? ";
        // Preparedstatem Objeto para prepara las consultas  
        try (PreparedStatement obj = conexion.prepareStatement(sql)){
            obj.setString(1, correo);
            obj.setString(2, password);
            obj.setString(3, TipoUsuario);
            ResultSet rs = obj.executeQuery(); //executeQuery() metodo  del Prepared stamtem que prepara las cosultas de select 
            return rs.next();
        } catch (Exception e) {
            System.err.println("Eror No se Pudo Validar el usuario intentelo de Nuevo"+e.getMessage());
            return false;
        } 
    }
    public boolean RegistrarUsuario(String nombre, String apellido, String correo,String password, String TipoUsuario){
        String sql = "INSERT INTO usuarios(nombre_usuario,apellido_usuario,correo,password,tipo_usuario) VALUES (?,?,?,?,?)";
        try (PreparedStatement obj = conexion.prepareStatement(sql)){
            obj.setString(1, nombre);
            obj.setString(2, apellido);
            obj.setString(3, correo);
            obj.setString(4, password);
            obj.setString(5, TipoUsuario);
            //executeUpdate(); // Metodo para actulizar e ingresar consultas sql 
            int filasafectadas = obj.executeUpdate();
            return filasafectadas > 0;
        } catch (Exception e) {
            System.out.println("Error No se Pudo Crear el Usuario");
            return false;
        }
    }
    public void eliminarUsuarioPorId(int idUsuario) {
    String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
    try (PreparedStatement obj = conexion.prepareStatement(sql)) {
        obj.setInt(1, idUsuario);
        int filasAfectadas = obj.executeUpdate();
        
        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el usuario.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.getMessage());
    }
    }
    public boolean actualizarUsuario(int idUsuario, String nombre, String apellido, String correo, String password, String tipoUsuario) {
         String sql = "UPDATE usuarios SET nombre_usuario = ?, apellido_usuario = ?, correo = ?, password = ?, tipo_usuario = ? WHERE id_usuario = ?";
         try (PreparedStatement obj = conexion.prepareStatement(sql)) {
            obj.setString(1, nombre);
            obj.setString(2, apellido);
            obj.setString(3, correo);
            obj.setString(4, password);
            obj.setString(5, tipoUsuario);
            obj.setInt(6, idUsuario);
            
            int filas = obj.executeUpdate(); // recorremos las filas y actulizamos 
            return filas > 0 ;   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al actulizar intente de nuevo "+e.getMessage());
            return false;
        }
    }

}
