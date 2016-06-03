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
    private String faccion;
    private int numero;
    private int puntos;

    public Jugador(String nombre, int numero, int puntos){
        this.nombre = nombre;
        this.numero = numero;
        this.puntos = puntos;
        /*
         * De momento las facciones son fijas segun el número
         * esto puede cambiar en el futuro
         */
        if(numero == 1)
            faccion = "Bien";
        else
            faccion = "Mal";
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    
    public String getFaccion() {
        return faccion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

}
