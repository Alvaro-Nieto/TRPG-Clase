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
    private static Thread hiloMusical;
    
    public static void startHiloMusical(){
        hiloMusical = new Thread(() ->{
            String songName = "champions.mp3";
            //String pathToMp3 = ".\\src\\juego\\"+"sonidos\\"+ songName;
            String pathToMp3 = "/juego/sonidos/"+ songName;
            System.out.println(pathToMp3);
            try{
                InputStream is = Sonidos.class.getResourceAsStream(pathToMp3);
                Player playMP3 = new Player(is);
                new Thread(()->{
                    boolean fallo = false;
                    while(!fallo && !Thread.interrupted()){
                        try {
                            playMP3.play();
                        } catch (JavaLayerException ex) {
                            Logger.getLogger(Sonidos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }).start();
                while(true){
                    if(Thread.interrupted()){
                        playMP3.close();
                        break;
                    }
                }
            }  catch(JavaLayerException e){
                System.out.println(e);
            }
        });
        if(!hiloMusical.isAlive())
            hiloMusical.start();
    }
    public static void stopHiloMusical(){
        if(hiloMusical != null && hiloMusical.isAlive())
            hiloMusical.interrupt();
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
