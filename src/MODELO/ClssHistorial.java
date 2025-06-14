
package MODELO;

import CONTROLADOR.ClaseConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClssHistorial {
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
  public void Guardar(int cod_emple, String nom_empleado, String ape_empleado, String temail_empleado,
                      String dir_empleado )
   {
    try
        {
        conn.MetodoConectar();
        sql=conn.con.prepareStatement("insert into empleado values(?,?,?)");
//        sql.setInt(1, cod_cargo);
//        sql.setString(2, Nom_empl);
//        sql.setDouble(3, salario_cargo);
        
                
        sql.execute(); //Ejecuta la instrucción SQL
        conn.cerrar();
        }
        catch(Exception ex)
        {
          System.out.println("ERROR AL GUARDAR TABLA CARGOS...");
        }
   }
    
    
    
   public void ComboEmpleado(){
  
   try{
             conn.MetodoConectar();
             sql=conn.con.prepareStatement("select * from empleado");
             rs=sql.executeQuery();
             sql.executeQuery();
             datos=sql.getResultSet();
         }
   catch(Exception ex)
    {
     System.out.println("ERROR AL BUSCAR");
    } 
    }
   
  public void ListarEmpleado(String nom_empleado){
 
   try{
    conn.MetodoConectar();
    sql=conn.con.prepareStatement("select * from empleado where nom_empleado=?");
    sql.setString(1, nom_empleado);
    sql.executeQuery();
    datos=sql.getResultSet();

   }
    catch(Exception es){
    System.out.println("error al cargar"+es.getMessage());
    }
    }
    
    
    
}
