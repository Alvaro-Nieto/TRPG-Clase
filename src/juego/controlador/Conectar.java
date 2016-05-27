
package juego.controlador;

/**
 *
 * @author Miguel
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.io.*;

public class Conectar {
  public static void main (String[] args) throws Exception {
    Connection connection = null;
    Statement statement = null;
    try {
      Class.forName("org.gjt.mm.mysql.Driver").newInstance();
      String url = "jdbc:mysql://localhost/mysql";
      connection = DriverManager.getConnection(url, "root", "");
      JOptionPane.showMessageDialog(null,"Conectado");
      statement = connection.createStatement();
      String hrappSQL = "CREATE DATABASE Juego";
      statement.executeUpdate(hrappSQL);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (statement != null) {
        try {
          statement.close();
        } catch (SQLException e) {
        } // nothing we can do
      }
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
        } // nothing we can do
      }
    }
    creaTablas();
  }
  public static void creaTablas () throws Exception {
    String user = "root";
    String pass = "";   
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Juego", user, pass);
    Statement st = con.createStatement();
    try{
    String table = "CREATE TABLE jugadores (" +
"  Nick varchar(20) NOT NULL," +
"  Contraseña varchar(8) NOT NULL" +
");";
    st.executeUpdate(table);
    table = "CREATE TABLE partida (" +
"  ganador varchar(20) NOT NULL," +
"  perdedor varchar(20) NOT NULL" +
");";
    st.executeUpdate(table);}
    catch(Exception e)
            {}
    finally {
      
          st.close();

          con.close();

      }
    }
}
