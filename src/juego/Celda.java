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
    private int indiceX; // Indice J en el array
    private int indiceY; // Indice I en el array
    private boolean colorSw; // Sirver para ir cambiando entre dos colores
    private ImageIcon img; // Imagen en la celda. Cambiar más adelante por objeto FIGURA
    private Color color1;
    private Color color2;
    private boolean selected;
    public boolean marcada;
    
    public Celda(boolean colorSw, int indiceX, int indiceY, int numCeldas){
        //this.color1 = new Color(107,62,25);
        //this.color2 = new Color(255,228,196);
        this.selected = false;
        this.color1 = new Color(255,255,255);
        this.color2 = new Color(200,200,200);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.indiceX = indiceX;
        this.indiceY = indiceY;
        if(colorSw){
            this.setBackground(color1);
        }else{
            this.setBackground(color2);
        }
        this.colorSw = colorSw;
        //this.setFigura("./imagenes/mal/gorbag.jpg");
    }
    
    /**
     * Este método define como se dibuja y se llamará automaticamente
     * Primero lo dibujamos usando la clase padre y despues dibujamos la figura
     * @param g 
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int modificador = (int)(this.getSize().getWidth() * 0.2);
        if(!this.isEmpty())
            g.drawImage(img.getImage(), modificador / 2, modificador / 2, (int)this.getSize().getWidth() - modificador, (int)this.getSize().getHeight() - modificador, null);
    }    

    public boolean isMarcada() {
        return marcada;
    }

    public void setMarcada(boolean marcada) {
        this.marcada = marcada;
    }
    
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
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
    public void oscurece(){
        int diff = 30;
        Color nuevoColor;
        if(colorSw){
            nuevoColor = (new Color(color1.getRed()-diff,color1.getGreen()-diff,color1.getBlue()-diff));
        } else{
            nuevoColor = (new Color(color2.getRed()-diff,color2.getGreen()-diff,color2.getBlue()-diff));
        }
        this.setBackground(nuevoColor);
    }
    public void aclara(){
        if(colorSw){
            this.setBackground(color1);;
        } else{
            this.setBackground(color2);
        }
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
    }
}
