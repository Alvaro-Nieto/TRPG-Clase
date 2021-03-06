/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;
import juego.controlador.ControladorPartida;

/**
 *
 * @author Álvaro
 */
public class TableroFrame extends javax.swing.JFrame{

    private Celda[][] celdas;
    private int ancho; // Tiene que se multiplo de numCeldas
    private int alto; // Tiene que se multiplo de numCeldas
    private final int numCeldas = 12;
    private final int HUECO = 2;
    private JPanel panelContenedor;
    private LateralFrame lateral;
    private ControladorPartida controlador;
    
    /**
     * Constructor.
     * Crea el tablero con sus celdas y lo dibuja.
     * Tablero es a su vez un JFrame (ventana). Deberiamos separar en dos clases
     * 
     * @param controlador Controlador de la partida
     */
    public TableroFrame(ControladorPartida controlador) {
        this.controlador = controlador;
        initComponents(); // Inicia el contenedor y layouts
        panelContenedor.setBackground(new Color(25,38,48)); // Si se ve rojo, algo no va bien
        iniciaCeldas();
        controlador.setTableroFrame(this);
        DespliegueFrame despliegueF = controlador.getControladorJuego().getDespliegueF();
        this.setLocation((int)despliegueF.getLocation().getX() + despliegueF.getWidth() + 5, (int)despliegueF.getLocation().getY());
        controlador.marcaRegiones();
        this.redimensionar('M');
        
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
                celdas[i][j].addMouseListener(controlador); // El mouseListener es esta misma clase
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

        this.setTitle("LOTR - Tablero");
        panelContenedor = new javax.swing.JPanel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        
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

    public int getNumCeldas() {
        return numCeldas;
    }
    
    public void redimensionar(char letra){
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int medida;
        switch(letra){
            case 'P':
                medida = multiploDesde(height / 2);
                break;
            case 'G':
                medida = multiploDesde(height - 120);
                break;
            default:
                medida = multiploDesde((int) (height / 1.5));
        }
        this.ancho = medida + (HUECO*numCeldas +HUECO);
        this.alto = ancho;
        this.panelContenedor.setSize(ancho,alto);
        this.panelContenedor.setPreferredSize(new Dimension(ancho,alto));
        this.dibujaCeldas();
        this.pack();
    }
    
    public void setLateralFrame(LateralFrame lateral){
        this.lateral = lateral;
        this.setLocation((int)lateral.getLocation().getX() + lateral.getWidth() + 5, (int)lateral.getLocation().getY());
    }
    
    public Celda[][] getCeldas() {
        return celdas;
    }
    
}
