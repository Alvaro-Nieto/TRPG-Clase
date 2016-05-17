/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

/**
 *
 * @author Álvaro
 */
public class Partida {
    int contTurnos;
    int turno;
    Jugador j1;
    Jugador j2;
    public Partida(Jugador j1, Jugador j2){
        this.contTurnos = 0;
        this.j1 = j1;
        this.j2 = j2;
        this.turno = 2;
    }
    public Jugador getJugadorActual(){
        return turno == 1 ? j1 : j2;
    }
    public String getTurnoNombre(){
        return turno == 1 ? j1.getNombre() : j2.getNombre();
    }
    public void nuevoTurno(){
        turno = turno == 1 ? 2 : 1;
        contTurnos++;
    }

    public int getContTurnos() {
        return contTurnos;
    }

    public void setContTurnos(int contTurnos) {
        this.contTurnos = contTurnos;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public Jugador getJ1() {
        return j1;
    }

    public void setJ1(Jugador j1) {
        this.j1 = j1;
    }

    public Jugador getJ2() {
        return j2;
    }

    public void setJ2(Jugador j2) {
        this.j2 = j2;
    }
    
    
}
