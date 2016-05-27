
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

public class Conectar {
  public static void main(String[] args) throws Exception {
    Connection connection = null;
    Statement statement = null;
    try {
      Class.forName("org.gjt.mm.mysql.Driver").newInstance();
      String url = "jdbc:mysql://localhost/mysql";
      connection = DriverManager.getConnection(url, "root", "");
      JOptionPane.showMessageDialog(null,"Conectado");
      statement = connection.createStatement();
      String hrappSQL = "CREATE DATABASE Miguel";
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
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Miguel", user, pass);
    Statement st = con.createStatement();
    try{
    String table = "CREATE TABLE java_DataTypes2(typ_boolean BOOL, "
        + "typ_byte          TINYINT, typ_short         SMALLINT, "
        + "typ_int           INTEGER, typ_long          BIGINT, "
        + "typ_float         FLOAT,   typ_double        DOUBLE PRECISION, "
        + "typ_bigdecimal    DECIMAL(13,0), typ_string        VARCHAR(254), "
        + "typ_date          DATE,    typ_time          TIME, " + "typ_timestamp     TIMESTAMP, "
        + "typ_asciistream   TEXT,    typ_binarystream  LONGBLOB, " + "typ_blob          BLOB)";

    st.executeUpdate(table);}
    catch(Exception e)
            {}
    finally {
      
          st.close();

          con.close();

      }
    }  
  }
