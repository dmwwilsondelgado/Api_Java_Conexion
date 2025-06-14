
package MODELO;

import CONTROLADOR.ClaseConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PRINCIPAL
 */
public class ClaseCargo {
    
    ClaseConexion conn= new ClaseConexion();
    public PreparedStatement sql; //PERMITE TRABAJAR SENTENCIAS SQL INICIALIZA CONSULTAS
    //La interfaz ResultSet proporciona métodos para recuperar y manipular los resultados de las consultas ejecutadas (EJECUTA CONSULTAS)
    public ResultSet datos, rs;
    //JTABLE ES UNA HERRAMIENTA VISUAL DE JAVA QUE SIRVE PARA PODER DIBUJAR TABLAS, CON SUS RESPECTIVAS FILAS Y COLUMNAS
    JTable modelo=new  JTable();
    // DefaultTableModel MODIFICAR DATOS EN SU INTERIOR, AÑADIR FILAS O COLUMNAS Y DARLE A CADA COLUMNA EL NOMBRE QUE SE DESEE.
    DefaultTableModel tabla=new DefaultTableModel();
    //suministra tres métodos diferentes para ejecutar sentencias SQL, executeQuery, executeUpdate y execute.
    Statement sent; 
    
   public void Guardar(int cod_cargo, String nom_cargo, double salario_cargo)
   {
    try
        {
        conn.MetodoConectar();
        sql=conn.con.prepareStatement("insert into cargo values(?,?,?)");
        //sql.setInt(1, cod_cargo);
        sql.setInt(1, cod_cargo);
        sql.setString(2, nom_cargo);
        sql.setDouble(3, salario_cargo);               
        sql.execute(); //Ejecuta la instrucción SQL
        conn.cerrar();
        }
        catch(Exception ex)
        {
          System.out.println("ERROR AL GUARDAR TABLA CARGOS...");
        }
   }
   
   public void Modificar(int codigo, String nom_cargo, double salario_cargo)
   {    
       try
            {
            conn.MetodoConectar();
            sql=conn.con.prepareStatement("update cargo  set cod_cargo=?, nom_cargo=?, salario_cargo=? where cod_cargo="+codigo);
            sql.setInt(1, codigo);
            sql.setString(2,nom_cargo);
            sql.setDouble(3,salario_cargo);
            sql.executeUpdate();
            conn.cerrar();
            JOptionPane.showMessageDialog(null,"REGISTRO ACTUALIZADO EXICTOSAMENTE","ACTUALIZADO",JOptionPane.INFORMATION_MESSAGE);
            }
      catch(Exception ex)
        {
          System.out.println("ERROR AL ACTUALAR DATOS EN LA TABLA CARGOS...");
        } 
}
   
 public void Buscar(int cod_cargo)  
 {
    try{
        conn.MetodoConectar();
        sql=conn.con.prepareStatement("select * from cargo where cod_cargo=?");
        sql.setInt(1, cod_cargo);
        sql.executeQuery();
        datos=sql.getResultSet();
    }
    catch(Exception ex)
    {
      System.out.println("ERROR AL BUSCAR DATOS...");
    }
 
 }
 
 public void Eliminar(int codigo)
 {
     try{
        // System.out.println("codigo: "+codigo);
          conn.MetodoConectar();  
          sql=conn.con.prepareStatement("delete from cargo where cod_cargo="+codigo);
          sql.executeUpdate();
          conn.cerrar();
          JOptionPane.showMessageDialog(null,"SE HA BORRADO EL REGISTRO EXICTOSAMENTE","BORRADO",JOptionPane.INFORMATION_MESSAGE);
        }
     catch(Exception ex){
          System.out.println("ERROR AL ELIMINAR LOS DATOS...");
     } 
 }        
 
 public void llenar_tabla(){
 try{
            conn.MetodoConectar();
            sql=conn.con.prepareStatement("select * from cargo ");
            String titulos[]={"CODIGO CARGO","NOMBRE CARGO", "SALARIO" };
           
            rs=sql.executeQuery();
            datos=sql.getResultSet(); //EJECUTA LA SENENCIA SQL  Y DEVUELVE CONJUNTO DE DATOS DE LA TABLA
            conn.cerrar();
}
catch(Exception ex)
         {
             System.out.println("ERROR AL BUSCAR");
         }   
 
 
 }
  public void listar_combo_cargos(){
  
   try{
             conn.MetodoConectar();
             sql=conn.con.prepareStatement("select * from cargo ");
             rs=sql.executeQuery();
             sql.executeQuery();
             datos=sql.getResultSet();
         }
   catch(Exception ex)
    {
     System.out.println("ERROR AL BUSCAR");
    } 
    }
  
  
  
 public void listar_cargo(String nom_cargo){
 
   try{
    conn.MetodoConectar();
    sql=conn.con.prepareStatement("select * from cargo where nom_cargo=?");
    sql.setString(1, nom_cargo);
    sql.executeQuery();
    datos=sql.getResultSet();

   }
    catch(Exception es){
    System.out.println("error al cargar"+es.getMessage());
    }
    }
 
}