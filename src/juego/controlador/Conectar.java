
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
    st.executeUpdate(table);
    table = "CREATE TABLE unidades (" +
"  Nombre varchar(50) NOT NULL," +
"  Faccion varchar(10) NOT NULL," +
"  Combate int(3) NOT NULL," +
"  Fuerza int(3) NOT NULL," +
"  Defensa int(3) NOT NULL," +
"  Num_Ataques int(3) NOT NULL," +
"  Heridas int(3) NOT NULL," +
"  Tipo_Unidad varchar(20) NOT NULL," +
"  Coste int(2) NOT NULL," +
"  Ruta_Img varchar(30) NOT NULL" +
");";
    st.executeUpdate(table);
    table = "INSERT INTO unidades (Nombre, Faccion, Combate, Fuerza, Defensa, Num_Ataques, Heridas, Tipo_Unidad, Coste, Ruta_Img) VALUES" +
"('Guerrero de minas Thirith', 'Bien', 3, 3, 5, 1, 1, 'Infantería', 7, './imagenes/bien/guerrminas.jpg')," +
"('Caballero de Minas Thirith', 'Bien', 3, 3, 5, 2, 2, 'Caballería', 15, './imagenes/bien/caballerominas.jpg')," +
"('Guardia del Patio del Manantial', 'Bien', 4, 3, 6, 1, 1, 'Infantería', 10, './imagenes/bien/guardiapatio.jpg')," +
"('Guardia de la ciudadela', 'Bien', 4, 3, 5, 1, 1, 'Infantería', 8, './imagenes/bien/guardiapatio.jpg')," +
"('Caballero de Dol Amroth', 'Bien', 4, 3, 6, 1, 1, 'Infantería', 9, './imagenes/bien/caballerodol.jpg')," +
"('Capitán de Minas Thirith', 'Bien', 4, 4, 6, 2, 2, 'Infantería', 17, './imagenes/bien/capitanminas.jpg')," +
"('Faramir', 'Bien', 5, 4, 5, 2, 2, 'Infantería', 20, './imagenes/bien/faramir.jpg')," +
"('Berengond', 'Bien', 4, 4, 6, 1, 1, 'Infantería', 11, './imagenes/bien/beregond.jpg')," +
"('Imrahil', 'Bien', 6, 4, 7, 3, 3, 'Infantería', 27, './imagenes/bien/imrahil.jpg')," +
"('Damrod', 'Bien', 4, 4, 5, 1, 1, 'Infantería', 9, './imagenes/bien/damrod.jpg')," +
"('Rey de los hombres', 'Bien', 5, 4, 4, 2, 2, 'Infantería', 16, './imagenes/bien/reyhombres.jpg')," +
"('Capitán de Dol Amroth', 'Bien', 4, 4, 7, 2, 2, 'Infantería', 18, './imagenes/bien/capitandol.jpg')," +
"('Shagrat', 'Mal', 5, 5, 5, 2, 2, 'Infantería', 18, './imagenes/mal/shagrot.jpg')," +
"('Gorbag', 'Mal', 4, 4, 5, 2, 2, 'Infantería', 15, './imagenes/mal/gorbag.jpg')," +
"('Capitán Orco', 'Mal', 4, 4, 5, 2, 2, 'Infantería', 15, './imagenes/mal/capitanorco.jpg')," +
"('Capitán Uruk-hai', 'Mal', 5, 5, 5, 2, 2, 'Infantería', 17, './imagenes/mal/capitanuruk.jpg')," +
"('Jefe Troll', 'Mal', 7, 7, 8, 3, 3, 'Monstruo', 90, './imagenes/mal/jefetroll.jpg')," +
"('Guerrero Orco', 'Mal', 3, 3, 4, 1, 1, 'Infantería', 5, './imagenes/mal/guerreroorco.jpg')," +
"('Orco de Morannon', 'Mal', 3, 4, 5, 1, 1, 'Infantería', 7, './imagenes/mal/orcomoranon.jpg')," +
"('Jinete de Huargo', 'Mal', 3, 4, 4, 2, 2, 'Caballería', 14, './imagenes/mal/jinetehuargo.jpg')," +
"('Uruk-hai de Mordor', 'Mal', 4, 4, 4, 1, 1, 'Infantería', 8, './imagenes/mal/urukmordor.jpg')," +
"('Grishnákh', 'Mal', 4, 4, 5, 2, 2, 'Infantería', 15, './imagenes/mal/grisnackh.jpg')," +
"('Troll de Mordor', 'Mal', 7, 7, 7, 3, 3, 'Monstruo', 70, './imagenes/mal/trollmordor.jpg');";
    st.executeUpdate(table);}
    catch(Exception e)
            {}
    finally {
      
          st.close();

          con.close();

      }
    }
}
