/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

/**
 * Celda hereda de JPanel, por lo tanto posee todos sus métodos
 * @author Álvaro
 */
public class Celda extends JPanel{
    private int x,y; // Tamaño de la celda
    private int indiceX; // Indice J en el array
    private int indiceY; // Indice I en el array
    private boolean color; // Sirver para ir cambiando entre dos colores
    private ImageIcon img; // Imagen en la celda. Cambiar más adelante por objeto FIGURA
    
    public Celda(JPanel jPanel1, boolean color, int indiceX, int indiceY, int numCeldas){
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.x = jPanel1.getWidth() / numCeldas;
        this.y = jPanel1.getHeight() / numCeldas;
        this.indiceX = indiceX;
        this.indiceY = indiceY;
        this.setSize(x, y);
        if(color){
            this.setBackground(new Color(107,62,25));
        }else{
            this.setBackground(new Color(255,228,196));
        }
        this.color = color;
    }
    
    /**
     * Este método define como se dibuja y se llamará automaticamente
     * Primero lo dibujamos usando la clase padre y despues dibujamos la figura
     * @param g 
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(!this.isEmpty())
            g.drawImage(img.getImage(), 0, 0, x, y, null);
        
    }    
    
    public boolean getColor(){
        return this.color;
    }
    
    public int getIndiceX(){
        return this.indiceX;
    }
    
    public int getIndiceY(){
        return this.indiceY;
    }
    
    public void setFigura(String figura){
        img = new ImageIcon(getClass().getResource(figura));
    }
    
    public void quitaFigura(){
        img = null;
    }
    
    /**
     * @return Devuelve true si está vacia
     */
    public boolean isEmpty(){
        return this.img == null;
    }
}
