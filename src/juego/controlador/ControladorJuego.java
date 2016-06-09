/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.controlador;

import juego.modelo.Jugador;
import juego.modelo.Partida;
import juego.vista.ClasificacionFrame;
import juego.vista.DespliegueFrame;
import juego.vista.InicioFrame;
import juego.vista.LateralFrame;
import juego.vista.TableroFrame;

/**
 *
 * @author Álvaro
 */
enum Estado{
    INICIO, DESPLIEGUE, JUGANDO
}

public class ControladorJuego {
    ControladorPartida controladorPartida;
    ClasificacionFrame clasificacionFrame;
    DespliegueFrame despliegueF;
    TableroFrame tableroF;
    LateralFrame lateralF;
    Partida partida;
    InicioFrame inicioF;
    Estado estado;
    
    public ControladorJuego(){
        
    }
    
    private void nuevoEstado(){
        if(estado == Estado.INICIO){
            estado = Estado.DESPLIEGUE;
        } else if (estado == Estado.DESPLIEGUE){
            estado = Estado.JUGANDO;
        } else{
            estado = Estado.INICIO;
        }
    }
    
    public void startInicio(){
        nuevoEstado();
        controladorPartida = null;
        despliegueF = null;
        tableroF = null;
        lateralF = null;
        partida = null;
        inicioF = null;
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            inicioF = new InicioFrame(this);
            inicioF.setVisible(true);
        });
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            clasificacionFrame = new ClasificacionFrame(this);
        });
    }
    public void startDespliegue(String j1,String j2,int puntos){
        controladorPartida = new ControladorPartida(new Partida(new Jugador(j1,1,puntos),new Jugador(j2,2,puntos)),this);
        
        java.awt.EventQueue.invokeLater(() -> {
            despliegueF = new DespliegueFrame(controladorPartida);
            despliegueF.setVisible(true);
        });
        
        /* Crea el tablero */
        java.awt.EventQueue.invokeLater(() -> {
            tableroF = new TableroFrame(controladorPartida);
            tableroF.setVisible(true);
        });
        nuevoEstado();
        
    }
    
    public void startPartida(){
        // Crea el lateral lo muestra y establece las referencias.
        java.awt.EventQueue.invokeLater(() -> {
            lateralF = new LateralFrame(controladorPartida);
            lateralF.setVisible(true);
            tableroF.setLateralFrame(lateralF);
            controladorPartida.setTableroFrame(tableroF);
        });
        nuevoEstado();
    }

    public ControladorPartida getControladorPartida() {
        return controladorPartida;
    }

    public void setControladorPartida(ControladorPartida controladorPartida) {
        this.controladorPartida = controladorPartida;
    }

    public DespliegueFrame getDespliegueF() {
        return despliegueF;
    }

    public void setDespliegueF(DespliegueFrame despliegueF) {
        this.despliegueF = despliegueF;
    }

    public TableroFrame getTableroF() {
        return tableroF;
    }

    public ClasificacionFrame getClasificacionFrame() {
        return clasificacionFrame;
    }
    
    
    public void setTableroF(TableroFrame tableroF) {
        this.tableroF = tableroF;
    }

    public LateralFrame getLateralF() {
        return lateralF;
    }

    public void setLateralF(LateralFrame lateralF) {
        this.lateralF = lateralF;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public InicioFrame getInicioF() {
        return inicioF;
    }

    public void setInicioF(InicioFrame inicioF) {
        this.inicioF = inicioF;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
}

