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
 *
 * @author Álvaro
 */
public class Celda extends JPanel{
    //private JPanel jPanel;
    private int x,y;
    private int indiceX;
    private int indiceY;
    private boolean color;
    private ImageIcon Img;
    
    public Celda(JPanel jPanel1, boolean color, int indiceX, int indiceY, int numCeldas){
        //this.jPanel = new JPanel();
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        Img = new ImageIcon(getClass().getResource(""));
        this.x = jPanel1.getWidth() / numCeldas;
        this.y = jPanel1.getHeight() / numCeldas;
        this.indiceX = indiceX;
        this.indiceY = indiceY;
        this.setSize(x, y);
        if(color){
            this.setBackground(new Color(107,62,25));
            this.color = color;
        }
        else{
            this.setBackground(new Color(255,228,196));
            this.color = color;
        }
        
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(Img.getImage(), 0, 0, x, y, null);
        
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
        Img = new ImageIcon(getClass().getResource(figura));
    }
    
    public void quitaFigura(){
        Img = new ImageIcon(getClass().getResource(""));
    }
    /*
    public JPanel getJPanel(){
        return this.jPanel;
    }*/
}
