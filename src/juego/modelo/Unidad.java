
package juego.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class Unidad {
    
    private final static int MOV_INFANTERIA = 2;
    private final static int MOV_MONSTRUO = 3;
    private final static int MOV_CABALLERIA = 5;
    
    private int combate;
    private int fuerza;
    private int defensa;
    private int numAtaques;
    private int heridas;
    private String nombre;
    private String faccion;
    private ImageIcon ficha;
    private ImageIcon imagen;
    private int movimientos;
    private int coste;
    private Jugador jugador;
    private String tipo;
    private boolean haActuado;
    
    public Unidad(){
    
    }
    
    public Unidad(Unidad unidad, Jugador j){
        this.nombre = unidad.getNombre();
        this.combate = unidad.getCombate();
        this.fuerza = unidad.getFuerza();
        this.defensa = unidad.getDefensa();
        this.numAtaques = unidad.getNumAtaques();
        this.heridas = unidad.getHeridas();
        this.tipo = unidad.getTipo();
        this.coste = unidad.getCoste();
        this.setImagen(unidad.getImagen());
        this.faccion = unidad.getFaccion();
        this.haActuado = false;
        this.jugador = j;
        setFichaAuto();
    }
    
    public Unidad(ResultSet rs){
        try {
            this.nombre = rs.getString("Nombre");
            this.combate = rs.getInt("Combate");
            this.fuerza = rs.getInt("Fuerza");
            this.defensa = rs.getInt("Defensa");
            this.numAtaques = rs.getInt("Num_Ataques");
            this.heridas = rs.getInt("Heridas");
            this.tipo = rs.getString("Tipo_Unidad");
            this.coste = rs.getInt("Coste");
            this.setImagen(rs.getString("Ruta_Img"));
            this.faccion = rs.getString("Faccion");
            this.haActuado = false;
            setFichaAuto();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    private void setFichaAuto() {
        switch (tipo) {
            case "Infantería":
                this.movimientos = MOV_INFANTERIA;
                if(this.faccion.equals("Bien"))
                    this.setFicha("/juego/imagenes/fichas/ficha_bien_infanteria.gif");
                else
                    this.setFicha("/juego/imagenes/fichas/ficha_mal_infanteria.gif");
                break;
            case "Caballería":
                this.movimientos = MOV_CABALLERIA;
                if(this.faccion.equals("Bien"))
                    this.setFicha("/juego/imagenes/fichas/ficha_bien_caballeria.gif");
                else
                    this.setFicha("/juego/imagenes/fichas/ficha_mal_caballeria.gif");
                break;
            case "Monstruo":
                this.movimientos = MOV_MONSTRUO;
                if(this.faccion.equals("Bien"))
                    this.setFicha("/juego/imagenes/fichas/ficha_bien_monstruo.gif");
                else
                    this.setFicha("/juego/imagenes/fichas/ficha_mal_monstruo.gif");
                break;
        }
    }

    public String getFaccion() {
        return faccion;
    }

    public int getCoste() {
        return coste;
    }

    
    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }
    
    public void setImagen(String ruta) {
        this.imagen = new ImageIcon(getClass().getResource(ruta));
    }
    
    public ImageIcon getFicha() {
        return ficha;
    }

    public void setFicha(ImageIcon ficha) {
        this.ficha = ficha;
    }
    public void setFicha(String ruta) {
        this.ficha = new ImageIcon(getClass().getResource(ruta));
    }

    public int getCombate() {
        return combate;
    }

    public void setCombate(int combate) {
        this.combate = combate;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getNumAtaques() {
        return numAtaques;
    }

    public void setNumAtaques(int numAtaques) {
        this.numAtaques = numAtaques;
    }

    public int getHeridas() {
        return heridas;
    }

    public void setHeridas(int heridas) {
        this.heridas = heridas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(int movimientos) {
        this.movimientos = movimientos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    

    public Jugador getJugador() {
        return jugador;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
    public void setFigura(String figura){
        ficha = new ImageIcon(getClass().getResource(figura));
    }
    
    public void quitaFigura(){
        ficha = null;
    }
    
    public boolean haActuado() {
        return this.haActuado;
    }
    
    public void setHaActuado(boolean haActuado) {
        this.haActuado = haActuado;
    }
    
}
