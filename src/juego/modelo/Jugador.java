/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.modelo;

/**
 *
 * @author Adrian
 */
public class Jugador {

     private String nombre;
     private int clasificacion;
     private int victorias;
     private int derrotas;
     private int numero;

     public Jugador(String nombre, int numero){
         this.nombre = nombre;
         this.numero = numero;
     }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }
     
    
}
