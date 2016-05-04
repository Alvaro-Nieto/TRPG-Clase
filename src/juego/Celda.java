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
    private boolean colorSw; // Sirver para ir cambiando entre dos colores
    private ImageIcon img; // Imagen en la celda. Cambiar más adelante por objeto FIGURA
    private Color color1;
    private Color color2;
    
    public Celda(JPanel jPanel1, boolean colorSw, int indiceX, int indiceY, int numCeldas){
        this.color1 = new Color(107,62,25);
        this.color2 = new Color(255,228,196);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.x = jPanel1.getWidth() / numCeldas;
        this.y = jPanel1.getHeight() / numCeldas;
        this.indiceX = indiceX;
        this.indiceY = indiceY;
        this.setSize(x, y);
        if(colorSw){
            this.setBackground(color1);
        }else{
            this.setBackground(color2);
        }
        this.colorSw = colorSw;
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
    
    public boolean getColorSw(){
        return this.colorSw;
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
    
    public void setColor(Color color1, Color color2){
        this.color1 = color1;
        this.color2 = color2;
        if(colorSw){
            this.setBackground(color1);
        }else{
            this.setBackground(color2);
        }
        //this.repaint();
    }
}
