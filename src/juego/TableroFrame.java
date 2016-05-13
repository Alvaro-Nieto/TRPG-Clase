/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Álvaro
 */
public class TableroFrame extends javax.swing.JFrame implements WindowListener{

    private Celda[][] celdas;
    private int ancho; // Tiene que se multiplo de numCeldas
    private int alto; // Tiene que se multiplo de numCeldas
    private final int numCeldas = 32;
    private final int HUECO = 2;
    private JPanel panelContenedor;
    private LateralFrame lateral;
    
    /**
     * Constructor.
     * Crea el tablero con sus celdas y lo dibuja.
     * Tablero es a su vez un JFrame (ventana). Deberiamos separar en dos clases
     */
    public TableroFrame() {
        this.ancho = multiploDesde(750) + (HUECO*numCeldas +HUECO);
        this.alto = ancho;
        initComponents(); // Inicia el contenedor y layouts
        //iniciaCeldas(); // Crea el tablero y todas sus celda
        panelContenedor.setBackground(Color.BLACK); // Si se ve rojo, algo no va bien
        //panelContenedor.repaint(); // Dibuja todo
    }

    /*
     * Se ejecuta en el constructor
     */
    private void iniciaCeldas() {
        boolean colorSw = false; // Va alternando para cambiar entre dos colores
        this.celdas = new Celda[numCeldas][numCeldas]; // Celdas que componen el tablero
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                celdas[i][j] = new Celda(colorSw,j,i,numCeldas);
                celdas[i][j].addMouseListener(lateral); // El mouseListener es esta misma clase
                panelContenedor.add(celdas[i][j]); // Se añaden todas a un contedor JPanel
                colorSw = !colorSw; // Cambia color de fondo
            }
            if(numCeldas % 2 == 0)
                colorSw = !colorSw; // Cambia color de fondo si numCeldas es par
        }
        this.dibujaCeldas();
    }
    
    /*
     * Es llamado al iniciar las celdas y cada vez que cambia el tamaño
     */
    private void dibujaCeldas(){
        int x = HUECO; // Coordenada X donde se dibuja
        int y = HUECO; // Coordenada Y donde se dibuja
        int sumador = ancho / numCeldas; // Distancia entre cada celda
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                celdas[i][j].setLocation(x, y);
                celdas[i][j].setSize(ancho / numCeldas -HUECO, alto / numCeldas -HUECO);
                x += sumador; // Suma la distancia para dibujar la siguiente
            }
            x = HUECO; // Nueva fila
            y += sumador; // Suma la distancia para dibujar la siguiente
        }
    }
    
    /**
     * Método basado en el autogenerado por NetBeans
     * Pero este ES ESCRITO A MANO
     * Hay que revisar los layouts que pueden no ser correctos
     */
    @SuppressWarnings("unchecked")                   
    private void initComponents() {

        this.setTitle("Tablero - \"EL JUEGO DE BATALLAS ESTRATEGICAS\"");
        this.addWindowListener(this);
        panelContenedor = new javax.swing.JPanel();
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        //setSize(new java.awt.Dimension(ancho, alto));

        //this.setPreferredSize(new java.awt.Dimension(ancho, alto));
        //this.setSize(new java.awt.Dimension(ancho, alto));
        
        panelContenedor.setPreferredSize(new java.awt.Dimension(ancho, alto));

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        )
                    .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        this.pack();
    }      
    
    public int multiploDesde(int desde){
        boolean encontrado = false;
        while(!encontrado && desde < 1024){
            if(desde % numCeldas == 0){
                encontrado = true;
            } else{
                desde++;
            }
        }
        return desde;
    }
    
    public void redimensionar(char letra){
        int medida;
        switch(letra){
            case 'P':
                medida = multiploDesde(450);
                break;
            case 'G':
                medida = multiploDesde(950);
                break;
            default:
                medida = multiploDesde(750);
        }
        this.ancho = medida;
        this.alto = medida;
        this.panelContenedor.setSize(medida,medida);
        this.panelContenedor.setPreferredSize(new Dimension(medida,medida));
        this.dibujaCeldas();
        this.pack();
    }
    
    public void setLateralFrame(LateralFrame lateral){
        this.lateral = lateral;
        iniciaCeldas();
        this.setLocation((int)lateral.getLocation().getX() + lateral.getWidth() + 5, (int)lateral.getLocation().getY());
    }
    
    public Celda[][] getCeldas() {
        return celdas;
    }
    

    @Override
    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.setVisible(false);
        lateral.tableroCerrando();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
