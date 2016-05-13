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
    private ImageIcon img;
    private int movimientos;
    
    public Unidad()
    {
    
    }

    
    
    public Unidad(String nombre,int combate,int fuerza,int defensa,int numAtaques,int heridas)
    {
      this.nombre=nombre;
      this.combate=combate;
      this.fuerza=fuerza;
      this.defensa=defensa;
      this.numAtaques=numAtaques;
      this.heridas=heridas;
      
    }
    
    public ImageIcon getImg() {
        return img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }
    public void setImg(String ruta) {
        this.img = new ImageIcon(getClass().getResource(ruta));
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
      

     @Override
    public String toString()
    {
        String mensaje="Datos:\n " +"Nombre: " + this.nombre + "\nCombate: " + this.combate + "\nFuerza: " 
               + this.fuerza + "\nDefensa: " + this.defensa +  "\nNumero de ataques: " + this.numAtaques 
               + "\nHeridas: " + this.heridas;
        return mensaje;
    }
            
      
    public void setFigura(String figura){
        img = new ImageIcon(getClass().getResource(figura));
    }
    
    public void quitaFigura(){
        img = null;
    }
    
 

    private boolean isEmpty() {
        return this.img == null;
    }
    
}
