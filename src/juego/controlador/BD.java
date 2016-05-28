
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

public class BD {
  public static void creaBaseDeDatos () throws Exception {
    Connection connection = null;
    Statement statement = null;
    try {
      Class.forName("org.gjt.mm.mysql.Driver").newInstance();
      connection = DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "");
      JOptionPane.showMessageDialog(null,"Conectado");
      statement = connection.createStatement();
      statement.executeUpdate("CREATE DATABASE Juego");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (statement != null) {
        try {
          statement.close();
        } catch (SQLException e) {
        } 
      }
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
        }
      }
    }
    creaTablas();
  }
  public static void creaTablas () throws Exception {   
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Juego", "root", "");
    Statement st = con.createStatement();
    try{
    st.executeUpdate("CREATE TABLE jugadores (" +
        "  Nick varchar(20) NOT NULL," +
        "  Contraseña varchar(8) NOT NULL," +
        "  CONSTRAINT pk_jugadores PRIMARY KEY (Nick));");
    st.executeUpdate("CREATE TABLE partida (" +
        "  ganador varchar(20) NOT NULL," +
        "  perdedor varchar(20) NOT NULL," +
        "  CONSTRAINT fk_ganador_nick FOREIGN KEY (ganador) REFERENCES jugadores(Nick)," +
        "  CONSTRAINT fk_perdedor_nick FOREIGN KEY (perdedor) REFERENCES jugadores(Nick)" +            
        ");");
    st.executeUpdate("CREATE TABLE unidades (" +
        "  Nombre varchar(50) NOT NULL," +
        "  Faccion varchar(10) NOT NULL," +
        "  Combate int(3) NOT NULL," +
        "  Fuerza int(3) NOT NULL," +
        "  Defensa int(3) NOT NULL," +
        "  Num_Ataques int(3) NOT NULL," +
        "  Heridas int(3) NOT NULL," +
        "  Tipo_Unidad varchar(20) NOT NULL," +
        "  Coste int(2) NOT NULL," +
        "  Ruta_Img varchar(50) NOT NULL," +
        "  CONSTRAINT pk_unidades PRIMARY KEY (Nombre));");
    st.executeUpdate("INSERT INTO unidades VALUES('Guerrero de minas Thirith', 'Bien', 3, 3, 5, 1, 1, 'Infantería', 7, './imagenes/bien/guerrminas.jpg')"); 
    st.executeUpdate("INSERT INTO unidades VALUES('Caballero de Minas Thirith', 'Bien', 3, 3, 5, 2, 2, 'Caballería', 15, './imagenes/bien/caballerominas.jpg')");
    st.executeUpdate("INSERT INTO unidades VALUES('Guardia del Patio del Manantial', 'Bien', 4, 3, 6, 1, 1, 'Infantería', 10, './imagenes/bien/guardiapatio.jpg')");
    st.executeUpdate("INSERT INTO unidades VALUES('Guardia de la ciudadela', 'Bien', 4, 3, 5, 1, 1, 'Infantería', 8, './imagenes/bien/guardiapatio.jpg')");
    st.executeUpdate("INSERT INTO unidades VALUES('Caballero de Dol Amroth', 'Bien', 4, 3, 6, 1, 1, 'Infantería', 9, './imagenes/bien/caballerodol.jpg')");
    st.executeUpdate("INSERT INTO unidades VALUES('Capitán de Minas Thirith', 'Bien', 4, 4, 6, 2, 2, 'Infantería', 17, './imagenes/bien/capitanminas.jpg')");
    st.executeUpdate("INSERT INTO unidades VALUES('Faramir', 'Bien', 5, 4, 5, 2, 2, 'Infantería', 20, './imagenes/bien/faramir.jpg')");
    st.executeUpdate("INSERT INTO unidades VALUES('Berengond', 'Bien', 4, 4, 6, 1, 1, 'Infantería', 11, './imagenes/bien/beregond.jpg')");
    st.executeUpdate("INSERT INTO unidades VALUES('Imrahil', 'Bien', 6, 4, 7, 3, 3, 'Infantería', 27, './imagenes/bien/imrahil.jpg')");
    st.executeUpdate("INSERT INTO unidades VALUES('Damrod', 'Bien', 4, 4, 5, 1, 1, 'Infantería', 9, './imagenes/bien/damrod.jpg')");
    st.executeUpdate("INSERT INTO unidades VALUES('Rey de los hombres', 'Bien', 5, 4, 4, 2, 2, 'Infantería', 16, './imagenes/bien/reyhombres.jpg')");
    st.executeUpdate("INSERT INTO unidades VALUES('Capitán de Dol Amroth', 'Bien', 4, 4, 7, 2, 2, 'Infantería', 18, './imagenes/bien/capitandol.jpg')");
    st.executeUpdate("INSERT INTO unidades VALUES('Shagrat', 'Mal', 5, 5, 5, 2, 2, 'Infantería', 18, './imagenes/mal/shagrot.jpg')");
    st.executeUpdate("INSERT INTO unidades VALUES('Gorbag', 'Mal', 4, 4, 5, 2, 2, 'Infantería', 15, './imagenes/mal/gorbag.jpg')");
    st.executeUpdate("INSERT INTO unidades VALUES('Capitán Orco', 'Mal', 4, 4, 5, 2, 2, 'Infantería', 15, './imagenes/mal/capitanorco.jpg')");
    st.executeUpdate("INSERT INTO unidades VALUES('Capitán Uruk-hai', 'Mal', 5, 5, 5, 2, 2, 'Infantería', 17, './imagenes/mal/capitanuruk.jpg')");
    st.executeUpdate("INSERT INTO unidades VALUES('Jefe Troll', 'Mal', 7, 7, 8, 3, 3, 'Monstruo', 90, './imagenes/mal/jefetroll.jpg')");
    st.executeUpdate("INSERT INTO unidades VALUES('Guerrero Orco', 'Mal', 3, 3, 4, 1, 1, 'Infantería', 5, './imagenes/mal/guerreroorco.jpg')");
    st.executeUpdate("INSERT INTO unidades VALUES('Orco de Morannon', 'Mal', 3, 4, 5, 1, 1, 'Infantería', 7, './imagenes/mal/orcomoranon.jpg')");
    st.executeUpdate("INSERT INTO unidades VALUES('Jinete de Huargo', 'Mal', 3, 4, 4, 2, 2, 'Caballería', 14, './imagenes/mal/jinetehuargo.jpg')");
    st.executeUpdate("INSERT INTO unidades VALUES('Uruk-hai de Mordor', 'Mal', 4, 4, 4, 1, 1, 'Infantería', 8, './imagenes/mal/urukmordor.jpg')");
    st.executeUpdate("INSERT INTO unidades VALUES('Grishnákh', 'Mal', 4, 4, 5, 2, 2, 'Infantería', 15, './imagenes/mal/grisnackh.jpg')");
    st.executeUpdate("INSERT INTO unidades VALUES('Troll de Mordor', 'Mal', 7, 7, 7, 3, 3, 'Monstruo', 70, './imagenes/mal/trollmordor.jpg')");
    }
    catch(Exception e)
            {}
    finally {
      
          st.close();

          con.close();

      }
    }
}
