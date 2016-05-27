/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import juego.controlador.ControladorPartida;
import juego.vista.LateralFrame;
import juego.vista.TableroFrame;

/**
 * Clase principal con el main
 * Lanza un hilo que crea el Tablero( la ventana )
 * @author Álvaro
 */
public class Juego {
    public static TableroFrame tableroF;
    public static LateralFrame lateralF;
    public static ControladorPartida controlador;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TableroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        // Controlador que maneja los eventos y actua entre los frames
        controlador = new ControladorPartida();
        
        /* Crea el tablero */
        java.awt.EventQueue.invokeLater(() -> {
            tableroF = new TableroFrame(controlador);
            tableroF.setVisible(false);
            
        });
        
        // Crea el lateral lo muestra y establece las referencias.
        java.awt.EventQueue.invokeLater(() -> {
            lateralF = new LateralFrame(controlador);
            lateralF.setVisible(true);
            tableroF.setLateralFrame(lateralF);
            controlador.setTableroFrame(tableroF);
        });
        
    }
    
}
