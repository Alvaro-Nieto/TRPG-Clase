
package juego.controlador;

/**
 *
 * @author Miguel
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import juego.modelo.Jugador;
import juego.modelo.Unidad;

public class BD {
    
    private static Connection conexion;
    
    public static boolean conecta(){
        boolean conectado = false;
        try {
            if(conexion != null && conexion.isValid(10)){
                conectado =  true;
            } else{
                try {
                    Class.forName("org.gjt.mm.mysql.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Juego2", "root", "");
                    conexion = connection;
                    conectado = conexion != null && conexion.isValid(10);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println(ex);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return conectado;
    }
    
    public static void desconecta(){
        try {
            if(conexion != null)
                conexion.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static Connection getConexion() {
        return conexion;
    }

    private static void creaBaseDeDatos (){
        Connection connection;
        Statement statement = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "");
            statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE Juego2");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                
            }
        }
    }
    
    private static void creaTablas (Connection con){   
        Statement st = null;
        try {
            st = con.createStatement();
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
                "  Coste int(3) NOT NULL," +
                "  Ruta_Img varchar(50) NOT NULL," +
                "  CONSTRAINT pk_unidades PRIMARY KEY (Nombre));");
            st.executeUpdate("INSERT INTO unidades VALUES('Guerrero de minas Thirith', 'Bien', 3, 3, 5, 1, 1, 'Infantería', 7, '/juego/imagenes/bien/guerrminas.jpg')"); 
            st.executeUpdate("INSERT INTO unidades VALUES('Caballero de Minas Thirith', 'Bien', 3, 3, 5, 2, 2, 'Caballería', 15, '/juego/imagenes/bien/caballerominas.jpg')");
            st.executeUpdate("INSERT INTO unidades VALUES('Guardia del Patio del Manantial', 'Bien', 4, 3, 6, 1, 1, 'Infantería', 10, '/juego/imagenes/bien/guardiapatio.jpg')");
            st.executeUpdate("INSERT INTO unidades VALUES('Guardia de la ciudadela', 'Bien', 4, 3, 5, 1, 1, 'Infantería', 8, '/juego/imagenes/bien/guardiapatio.jpg')");
            st.executeUpdate("INSERT INTO unidades VALUES('Caballero de Dol Amroth', 'Bien', 4, 3, 6, 1, 1, 'Infantería', 9, '/juego/imagenes/bien/caballerodol.jpg')");
            st.executeUpdate("INSERT INTO unidades VALUES('Capitán de Minas Thirith', 'Bien', 4, 4, 6, 2, 2, 'Infantería', 17, '/juego/imagenes/bien/capitanminas.jpg')");
            st.executeUpdate("INSERT INTO unidades VALUES('Faramir', 'Bien', 5, 4, 5, 2, 2, 'Infantería', 20, '/juego/imagenes/bien/faramir.jpg')");
            st.executeUpdate("INSERT INTO unidades VALUES('Berengond', 'Bien', 4, 4, 6, 1, 1, 'Infantería', 11, '/juego/imagenes/bien/beregond.jpg')");
            st.executeUpdate("INSERT INTO unidades VALUES('Imrahil', 'Bien', 6, 4, 7, 3, 3, 'Infantería', 27, '/juego/imagenes/bien/imrahil.jpg')");
            st.executeUpdate("INSERT INTO unidades VALUES('Damrod', 'Bien', 4, 4, 5, 1, 1, 'Infantería', 9, '/juego/imagenes/bien/damrod.jpg')");
            st.executeUpdate("INSERT INTO unidades VALUES('Rey de los hombres', 'Bien', 5, 4, 4, 2, 2, 'Infantería', 16, '/juego/imagenes/bien/reyhombres.jpg')");
            st.executeUpdate("INSERT INTO unidades VALUES('Capitán de Dol Amroth', 'Bien', 4, 4, 7, 2, 2, 'Infantería', 18, '/juego/imagenes/bien/capitandol.jpg')");
            st.executeUpdate("INSERT INTO unidades VALUES('Shagrat', 'Mal', 5, 5, 5, 2, 2, 'Infantería', 18, '/juego/imagenes/mal/shagrot.jpg')");
            st.executeUpdate("INSERT INTO unidades VALUES('Gorbag', 'Mal', 4, 4, 5, 2, 2, 'Infantería', 15, '/juego/imagenes/mal/gorbag.jpg')");
            st.executeUpdate("INSERT INTO unidades VALUES('Capitán Orco', 'Mal', 4, 4, 5, 2, 2, 'Infantería', 15, '/juego/imagenes/mal/capitanorco.jpg')");
            st.executeUpdate("INSERT INTO unidades VALUES('Capitán Uruk-hai', 'Mal', 5, 5, 5, 2, 2, 'Infantería', 17, '/juego/imagenes/mal/capitanuruk.jpg')");
            st.executeUpdate("INSERT INTO unidades VALUES('Jefe Troll', 'Mal', 7, 7, 8, 3, 3, 'Monstruo', 120, '/juego/imagenes/mal/jefetroll.jpg')");
            st.executeUpdate("INSERT INTO unidades VALUES('Guerrero Orco', 'Mal', 3, 3, 4, 1, 1, 'Infantería', 5, '/juego/imagenes/mal/guerreroorco.jpg')");
            st.executeUpdate("INSERT INTO unidades VALUES('Orco de Morannon', 'Mal', 3, 4, 5, 1, 1, 'Infantería', 7, '/juego/imagenes/mal/orcomoranon.jpg')");
            st.executeUpdate("INSERT INTO unidades VALUES('Jinete de Huargo', 'Mal', 3, 4, 4, 2, 2, 'Caballería', 14, '/juego/imagenes/mal/jinetehuargo.jpg')");
            st.executeUpdate("INSERT INTO unidades VALUES('Uruk-hai de Mordor', 'Mal', 4, 4, 4, 1, 1, 'Infantería', 8, '/juego/imagenes/mal/urukmordor.jpg')");
            st.executeUpdate("INSERT INTO unidades VALUES('Grishnákh', 'Mal', 4, 4, 5, 2, 2, 'Infantería', 15, '/juego/imagenes/mal/grisnackh.jpg')");
            st.executeUpdate("INSERT INTO unidades VALUES('Troll de Mordor', 'Mal', 7, 7, 7, 3, 3, 'Monstruo', 100, '/juego/imagenes/mal/trollmordor.jpg')");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                if(st!=null)
                    st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public static void generaBD() {
        creaBaseDeDatos();
        if (conecta())
            creaTablas(getConexion());
        else 
            System.out.println("No se ha podido crear las tablas y/o insertar las filas");
    }
    
    /*
     * PARA PRUEBAS
     */
    public static void main (String []args){
        //generaBD();
        //Unidad unidad = new Unidad(getUnidad("Jefe Troll"),new Jugador("prueba",1));
        //System.out.println(unidad);
        for(Unidad unidad: getUnidades("Bien")){
            System.out.println(unidad.toString());
        }
    }
    
    public static ResultSet getUnidad(String nombreUnidad){
        ResultSet rs = null;
        if(conecta()){
            try {
                PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM unidades WHERE Nombre = ?");
                stmt.setString(1, nombreUnidad);

                rs = stmt.executeQuery();
                rs.next();
                if(!rs.isLast()){
                    rs = null;
                    System.out.println("Ha devuelto más de una tupla");
                } 
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return rs;
    }
    
    public static List<Unidad> getUnidades(String faccion){
        
        List<Unidad> unidades = new ArrayList<>();
        ResultSet rs = null;
        if(conecta()){
            try {
                PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM unidades WHERE Faccion = ?");
                stmt.setString(1, faccion);
                rs = stmt.executeQuery();
                while(rs.next()){
                    unidades.add(new Unidad(rs));
                } 
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return unidades;
    }
}
