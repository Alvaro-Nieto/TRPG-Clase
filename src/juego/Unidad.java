/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import javax.swing.ImageIcon;

/**
 *
 * @author Adrian
 */
public class Unidad {
    
    private int combate;
    private int fuerza;
    private int defensa;
    private int numAtaques;
    private int heridas;
    private String nombre;
    private ImageIcon ficha;
    private ImageIcon imagen;
    private int movimientos;
    private Jugador jugador;
    private String tipo;
    
    public Unidad()
    {
    
    }

    public Unidad(String nombre,int combate,int fuerza,int defensa,int numAtaques,int heridas,Jugador jugador, String tipo){
        this.nombre=nombre;
        this.combate=combate;
        this.fuerza=fuerza;
        this.defensa=defensa;
        this.numAtaques=numAtaques;
        this.heridas=heridas;
        this.jugador = jugador;
        this.tipo = tipo;
      
        // DEPENDE DE LA BD
        this.setImagen("");
        // DEPENDE DE LA BD
        switch(tipo){
            case "Infanteria":
            if(this.jugador.getNumero()==1)
                this.setFicha("./imagenes/fichas/ficha_naranja_infanteria.gif");
            else
                this.setFicha("./imagenes/fichas/ficha_verde_infanteria.gif");
            break;
            case "Caballeria":
            if(this.jugador.getNumero()==1)
                this.setFicha("./imagenes/fichas/ficha_naranja_caballeria.gif");
            else
                this.setFicha("./imagenes/fichas/ficha_verde_caballeria.gif");
            break;
            case "Monstruo":
            if(this.jugador.getNumero()==1)
                this.setFicha("./imagenes/fichas/ficha_naranja_monstruo.gif");
            else
                this.setFicha("./imagenes/fichas/ficha_verde_monstruo.gif");
            break;
      }
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

    public int getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(int movimientos) {
        this.movimientos = movimientos;
    }
    
    
     public void setNombre(String nombre)
    {
      this.nombre=nombre;
    }
     
     public String getNombre()
     {
       return this.nombre;
     }
     
    public void setCombate(int combate)
    {
      this.combate=combate;
    }
    
    public int getCombate()
     {
       return this.combate;
     }
    
     public void setFuerza(int fuerza)
    {
      this.fuerza=fuerza;
    }
     
     public int getFuerza()
     {
       return this.fuerza;
     }
     
     public void setDefensa(int defensa)
    {
      this.defensa=defensa;
    }
     
      public int getDefensa()
     {
       return this.defensa;
     }
     
      public void setNumAtaques(int numAtaques)
    {
      this.numAtaques=numAtaques;
    }
      
       public int getNumAtaques()
     {
       return this.numAtaques;
     }
           
      
      public void setHeridas(int heridas)
    {
      this.heridas=heridas;
    }
      
       public int getHeridas()
     {
       return this.heridas;
     }

    public Jugador getJugador() {
        return jugador;
    }
      

     @Override
    public String toString()
    {
        String mensaje="Datos:\n " +"Nombre: " + this.nombre + "\nCombate: " + this.combate + "\nFuerza: " 
               + this.fuerza + "\nDefensa: " + this.defensa +  "\nNumero de ataques: " + this.numAtaques 
               + "\nHeridas: " + this.heridas;
        return mensaje;
    }
            
      
    public void setFigura(String figura){
        ficha = new ImageIcon(getClass().getResource(figura));
    }
    
    public void quitaFigura(){
        ficha = null;
    }
    
 
/*
    private boolean isEmpty() {
        return this.ficha == null;
    }*/
    
}
