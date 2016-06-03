/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;

/**
 *
 * @author Adrian
 */
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
        this.jugador = j;
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
    
    public Unidad(ResultSet rs, Jugador j){
        this(rs);
        this.jugador = j;
    }
    
    /*
    public Unidad(String nombre,int combate,int fuerza,int defensa,int numAtaques,int heridas,Jugador jugador, String tipo){
        this.nombre=nombre;
        this.combate=combate;
        this.fuerza=fuerza;
        this.defensa=defensa;
        this.numAtaques=numAtaques;
        this.heridas=heridas;
        this.jugador = jugador;
        this.tipo = tipo;
      
        this.haActuado = false;
        // DEPENDE DE LA BD
        this.setImagen("");
        setFichaAuto(tipo);
    }
    */
    
    private void setFichaAuto() {
        switch (tipo) {
            case "Infantería":
                this.movimientos = MOV_INFANTERIA;
                if(this.faccion.equals("Bien"))
                    this.setFicha("/juego/imagenes/fichas/ficha_naranja_infanteria.gif");
                else
                    this.setFicha("/juego/imagenes/fichas/ficha_verde_infanteria.gif");
                break;
            case "Caballería":
                this.movimientos = MOV_CABALLERIA;
                if(this.faccion.equals("Bien"))
                    this.setFicha("/juego/imagenes/fichas/ficha_naranja_caballeria.gif");
                else
                    this.setFicha("/juego/imagenes/fichas/ficha_verde_caballeria.gif");
                break;
            case "Monstruo":
                this.movimientos = MOV_MONSTRUO;
                if(this.faccion.equals("Bien"))
                    this.setFicha("/juego/imagenes/fichas/ficha_naranja_monstruo.gif");
                else
                    this.setFicha("/juego/imagenes/fichas/ficha_verde_monstruo.gif");
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
    
      /*
    @Override
    public String toString(){
        String mensaje = "Datos:\n " +"Nombre: " + this.nombre + "\nCombate: " + this.combate + "\nFuerza: " 
               + this.fuerza + "\nDefensa: " + this.defensa +  "\nNumero de ataques: " + this.numAtaques 
               + "\nHeridas: " + this.heridas;
        return mensaje;
    }*/

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
