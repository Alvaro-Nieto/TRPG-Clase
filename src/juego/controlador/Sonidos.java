/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.controlador;

import java.io.InputStream;
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
    
    private static void play(String nombre){
        new Thread(() ->{
            try{
                InputStream is = Sonidos.class.getResourceAsStream("/juego/sonidos/"+nombre+".mp3");
                Player playMP3 = new Player(is);
                playMP3.play();
            }  catch(Exception e){
                 System.out.println(e);
            }
        }).start();
    }
    
    public static void nuevoTurno(){
        Sonidos.play("turno");
    }
    
    public static void chasquido(){
        Sonidos.play("click");
    }
    
    public static void muerte(){
        Sonidos.play("grito");
    }
    
    public static void victoria(){
        Sonidos.play("victoria");
    }
}
