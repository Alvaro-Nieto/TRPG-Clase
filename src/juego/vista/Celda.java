/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.vista;

import juego.modelo.Unidad;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Graphics;

/**
 * Celda hereda de JPanel, por lo tanto posee todos sus métodos
 * @author Álvaro
 */
public class Celda extends JPanel{
    
    private int indiceX; // Indice J en el array
    private int indiceY; // Indice I en el array
    private boolean colorSw; // Sirve para ir cambiando entre dos colores
    private Unidad unidad;
    private Color color1;
    private Color color2;
    private boolean selected;
    private boolean marcada;
    
    public Celda(boolean colorSw, int indiceX, int indiceY, int numCeldas){
        this.selected = false;
        this.color1 = new Color(252,155,87);
        this.color2 = new Color(135,203,250);
        this.indiceX = indiceX;
        this.indiceY = indiceY;
        if(colorSw){
            this.setBackground(color1);
        }else{
            this.setBackground(color2);
        }
        this.colorSw = colorSw;
    }
    
    /**
     * Este método define como se dibuja y se llamará automaticamente
     * Primero lo dibujamos usando la clase padre y despues dibujamos la imagen
     * @param g 
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int modificador = (int)(this.getSize().getWidth() * 0.2);
        if(!this.isEmpty()){
            g.drawImage(this.unidad.getFicha().getImage(), modificador / 2, modificador / 2, (int)this.getSize().getWidth() - modificador, (int)this.getSize().getHeight() - modificador, null);
            g.setFont(new Font("Arial",1,(int)this.getHeight()/4));
            
            g.drawString("J"+String.valueOf(unidad.getJugador().getNumero()), 0,(int)this.getHeight() - g.getFontMetrics().getHeight() /8);
            
            if(this.unidad.haActuado()){
                g.drawString("X", (int)this.getWidth() - g.getFontMetrics().getWidths()[0],(int)this.getHeight() - g.getFontMetrics().getHeight() /8);
                this.oscurece();
            } else
                this.aclara();
        } else
            this.aclara();
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
    
    public void setUnidad(Unidad unidad){
        this.unidad = unidad;
    }

    public Unidad getUnidad() {
        return unidad;
    }
    
    public void quitaUnidad(){
        this.unidad = null;
    }
    
    public void oscurece(){
        int diff = 70;
        Color nuevoColor;
        if(colorSw){
            nuevoColor = (new Color(color1.getRed()-diff,color1.getGreen()-diff,color1.getBlue()));
        } else{
            nuevoColor = (new Color(color2.getRed()-diff,color2.getGreen()-diff,color2.getBlue()));
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
     * @return Devuelve true si no hay unidad en esta celda
     */
    public boolean isEmpty(){
        return this.unidad == null;
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
