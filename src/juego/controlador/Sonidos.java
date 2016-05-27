/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.controlador;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Álvaro
 */
public class Sonidos {
    private static Player playerHilo;
    private static boolean repetirCancion;
    
    public static void startHiloMusical(){
        Sonidos.repetirCancion = true;
        String songName = "champions.mp3";
        String pathToMp3 = "/juego/sonidos/"+ songName;
        new Thread( ()->{
            while(Sonidos.repetirCancion){
                try {
                    InputStream is = Sonidos.class.getResourceAsStream(pathToMp3);
                    playerHilo = new Player(is);
                    playerHilo.play();
                } catch (JavaLayerException ex) {
                    Sonidos.repetirCancion = false;
                    if(playerHilo != null)
                        playerHilo.close();
                }
            }
        }).start();
    }
    
    public static void stopHiloMusical(){
        Sonidos.repetirCancion = false;
        playerHilo.close();
    }
    
    public static void nuevoTurno(){
        new Thread(() ->{
            String songName = "turno.mp3";
            String pathToMp3 = "/juego/sonidos/"+ songName;
            try{
                InputStream is = Sonidos.class.getResourceAsStream(pathToMp3);
                Player playMP3 = new Player(is);
                playMP3.play();
            }  catch(Exception e){
                 System.out.println(e);
            }
        }).start();
    }
}
