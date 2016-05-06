/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Álvaro
 */
public class TableroFrame extends javax.swing.JFrame implements MouseListener{

    private Celda[][] celdas;
    private final int ancho = 800; // Tiene que se multiplo de numCeldas
    private final int alto = ancho; // Tiene que se multiplo de numCeldas
    private final int numCeldas = 16;
    private JPanel panelContenedor;
    
    /**
     * Constructor.
     * Crea el tablero con sus celdas y lo dibuja.
     * Tablero es a su vez un JFrame (ventana). Deberiamos separar en dos clases
     */
    public TableroFrame() {
        initComponents(); // Inicia el contenedor y layouts
        iniciaCeldas(); // Crea el tablero y todas sus celda
        panelContenedor.setBackground(Color.red); // Si se ve rojo, algo no va bien
        panelContenedor.repaint(); // Dibuja todo
    }

    /**
     * Se ejecuta en el constructor
     */
    private void iniciaCeldas() {
        boolean colorSw = false; // Va alternando para cambiar entre dos colores
        int x = 0; // Coordenada X donde se dibuja
        int y = 0; // Coordenada Y donde se dibuja
        int sumador = ancho / numCeldas; // Distancia entre cada celda
        this.celdas = new Celda[numCeldas][numCeldas]; // Celdas que componen el tablero
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                celdas[i][j] = new Celda(panelContenedor, colorSw,j,i,numCeldas);
                celdas[i][j].setLocation(x, y);
                celdas[i][j].addMouseListener(this); // El mouseListener es esta misma clase
                panelContenedor.add(celdas[i][j]); // Se añaden todas a un contedor JPanel
                x += sumador; // Suma la distancia para dibujar la siguiente
                colorSw = !colorSw; // Cambia color de fondo
            }
            colorSw = !colorSw; // Cambia color de fondo
            x = 0; // Nueva fila
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
        
        panelContenedor = new javax.swing.JPanel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
    
    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Celda celda = (Celda) e.getSource();
        System.out.println(
                "¡Clic en celda: ["+celda.getIndiceY()+","+celda.getIndiceX()+"]!"
        );
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Celda celda = (Celda) e.getSource();
        System.out.println(
                "¡PULSADO: ["+celda.getIndiceY()+","+celda.getIndiceX()+"]!"
        );
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Celda celda = (Celda) e.getSource();
        System.out.println(
                "¡SOLTADO: ["+celda.getIndiceY()+","+celda.getIndiceX()+"]!"
        );
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Celda celda = (Celda) e.getSource();
        celda.setBorder(BorderFactory.createLineBorder(Color.CYAN));
        System.out.println(
                "¡El puntero entra en la celda: ["+celda.getIndiceY()+","+celda.getIndiceX()+"]!"
        );
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Celda celda = (Celda) e.getSource(); 
        celda.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
}
