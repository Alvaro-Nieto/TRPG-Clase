/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.vista;

import com.sun.glass.events.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import juego.controlador.BD;
import juego.controlador.ControladorPartida;
import juego.controlador.Sonidos;
import juego.modelo.Unidad;

/**
 *
 * @author Adrian
 */
public class DespliegueFrame extends javax.swing.JFrame {

    private final ControladorPartida controladorPartida;
    private String faccion;
    private Unidad unidadSelec;
    

    /**
     * Creates new form DespliegueFrame
     */
    public DespliegueFrame(ControladorPartida controladorPartida) {
        initComponents();
        this.setLocation(5, 5); 
        this.controladorPartida = controladorPartida;
        this.controladorPartida.setDespliegueFrame(this);
        cargaUnidades();

    }

    private void cargaUnidades() {
        cBoxUnidades.removeAllItems();
        faccion = controladorPartida.getPartida().getJugadorActual().getFaccion();
        for(Unidad unidad : BD.getUnidades(faccion)){
            cBoxUnidades.addItem(unidad);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelImagen = new javax.swing.JLabel();
        txtJuActual = new javax.swing.JLabel();
        cBoxUnidades = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtHeridas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFuerza = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDefensa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCombate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMovimientos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCoste = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPuntos = new javax.swing.JTextField();
        btnFin = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPuntosDespues = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOTR - Despliegue");
        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(400, 658));
        setMinimumSize(new java.awt.Dimension(400, 658));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 658));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(400, 658));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 658));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 658));
        jPanel1.setLayout(null);

        labelImagen.setForeground(new java.awt.Color(255, 255, 255));
        labelImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jPanel1.add(labelImagen);
        labelImagen.setBounds(10, 10, 120, 120);

        txtJuActual.setBackground(new Color(0,0,0,150));
        txtJuActual.setFont(new java.awt.Font("Ringbearer", 1, 36)); // NOI18N
        txtJuActual.setForeground(new java.awt.Color(255, 255, 255));
        txtJuActual.setText(" JUGADOR 1");
        txtJuActual.setToolTipText("");
        txtJuActual.setOpaque(true);
        jPanel1.add(txtJuActual);
        txtJuActual.setBounds(140, 10, 240, 60);

        cBoxUnidades.setBackground(new java.awt.Color(204, 255, 255));
        cBoxUnidades.setFont(new java.awt.Font("Ringbearer", 1, 14)); // NOI18N
        cBoxUnidades.setForeground(new java.awt.Color(255, 255, 255));
        cBoxUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxUnidadesActionPerformed(evt);
            }
        });
        cBoxUnidades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cBoxUnidadesKeyPressed(evt);
            }
        });
        jPanel1.add(cBoxUnidades);
        cBoxUnidades.setBounds(100, 160, 280, 30);

        jLabel1.setBackground(new Color(0,0,0,150));
        jLabel1.setFont(new java.awt.Font("Ringbearer", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Nombre");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 160, 80, 30);

        jLabel2.setBackground(new Color(0,0,0,150));
        jLabel2.setFont(new java.awt.Font("Ringbearer", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" Heridas");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 220, 120, 30);

        txtHeridas.setEditable(false);
        txtHeridas.setBackground(new java.awt.Color(0, 0, 0));
        txtHeridas.setFont(new java.awt.Font("Ringbearer", 1, 14)); // NOI18N
        txtHeridas.setForeground(new java.awt.Color(255, 255, 255));
        txtHeridas.setFocusable(false);
        jPanel1.add(txtHeridas);
        txtHeridas.setBounds(140, 220, 50, 30);

        jLabel3.setBackground(new Color(0,0,0,150));
        jLabel3.setFont(new java.awt.Font("Ringbearer", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" Fuerza");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(200, 220, 120, 30);

        txtFuerza.setEditable(false);
        txtFuerza.setBackground(new java.awt.Color(0, 0, 0));
        txtFuerza.setFont(new java.awt.Font("Ringbearer", 1, 14)); // NOI18N
        txtFuerza.setForeground(new java.awt.Color(255, 255, 255));
        txtFuerza.setFocusable(false);
        jPanel1.add(txtFuerza);
        txtFuerza.setBounds(330, 220, 50, 30);

        jLabel4.setBackground(new Color(0,0,0,150));
        jLabel4.setFont(new java.awt.Font("Ringbearer", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(" Defensa");
        jLabel4.setToolTipText("");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 260, 120, 30);

        txtDefensa.setEditable(false);
        txtDefensa.setBackground(new java.awt.Color(0, 0, 0));
        txtDefensa.setFont(new java.awt.Font("Ringbearer", 1, 14)); // NOI18N
        txtDefensa.setForeground(new java.awt.Color(255, 255, 255));
        txtDefensa.setFocusable(false);
        jPanel1.add(txtDefensa);
        txtDefensa.setBounds(140, 260, 50, 30);

        jLabel5.setBackground(new Color(0,0,0,150));
        jLabel5.setFont(new java.awt.Font("Ringbearer", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(" Combate");
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(200, 260, 120, 30);

        txtCombate.setEditable(false);
        txtCombate.setBackground(new java.awt.Color(0, 0, 0));
        txtCombate.setFont(new java.awt.Font("Ringbearer", 1, 14)); // NOI18N
        txtCombate.setForeground(new java.awt.Color(255, 255, 255));
        txtCombate.setFocusable(false);
        jPanel1.add(txtCombate);
        txtCombate.setBounds(330, 260, 50, 30);

        jLabel6.setBackground(new Color(0,0,0,150));
        jLabel6.setFont(new java.awt.Font("Ringbearer", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(" Movimientos");
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 300, 120, 30);

        txtMovimientos.setEditable(false);
        txtMovimientos.setBackground(new java.awt.Color(0, 0, 0));
        txtMovimientos.setFont(new java.awt.Font("Ringbearer", 1, 14)); // NOI18N
        txtMovimientos.setForeground(new java.awt.Color(255, 255, 255));
        txtMovimientos.setFocusable(false);
        jPanel1.add(txtMovimientos);
        txtMovimientos.setBounds(140, 300, 50, 30);

        jLabel7.setBackground(new Color(0,0,0,150));
        jLabel7.setFont(new java.awt.Font("Ringbearer", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(" Coste");
        jLabel7.setToolTipText("");
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(200, 300, 120, 30);

        txtCoste.setEditable(false);
        txtCoste.setBackground(new java.awt.Color(0, 0, 0));
        txtCoste.setFont(new java.awt.Font("Ringbearer", 1, 14)); // NOI18N
        txtCoste.setForeground(new java.awt.Color(255, 255, 255));
        txtCoste.setFocusable(false);
        jPanel1.add(txtCoste);
        txtCoste.setBounds(330, 300, 50, 30);

        jLabel8.setBackground(new Color(0,0,0,150));
        jLabel8.setFont(new java.awt.Font("Ringbearer", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText(" Puntos");
        jLabel8.setToolTipText("");
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 340, 120, 30);

        txtPuntos.setEditable(false);
        txtPuntos.setBackground(new java.awt.Color(0, 0, 0));
        txtPuntos.setFont(new java.awt.Font("Ringbearer", 1, 14)); // NOI18N
        txtPuntos.setForeground(new java.awt.Color(255, 255, 255));
        txtPuntos.setFocusable(false);
        jPanel1.add(txtPuntos);
        txtPuntos.setBounds(140, 340, 50, 30);

        btnFin.setBackground(new java.awt.Color(0, 0, 0));
        btnFin.setFont(new java.awt.Font("Ringbearer", 1, 12)); // NOI18N
        btnFin.setForeground(new java.awt.Color(255, 255, 255));
        btnFin.setText("Terminar desplegado");
        btnFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinActionPerformed(evt);
            }
        });
        jPanel1.add(btnFin);
        btnFin.setBounds(110, 550, 185, 43);

        jLabel9.setBackground(new Color(0,0,0,150));
        jLabel9.setFont(new java.awt.Font("Ringbearer", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("  Despliega tus unidades");
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(140, 90, 200, 30);

        jLabel10.setBackground(new Color(0,0,0,150));
        jLabel10.setFont(new java.awt.Font("Ringbearer", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText(" Puntos - Coste");
        jLabel10.setOpaque(true);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(200, 340, 120, 30);

        txtPuntosDespues.setEditable(false);
        txtPuntosDespues.setBackground(new java.awt.Color(0, 0, 0));
        txtPuntosDespues.setFont(new java.awt.Font("Ringbearer", 1, 14)); // NOI18N
        txtPuntosDespues.setForeground(new java.awt.Color(255, 255, 255));
        txtPuntosDespues.setFocusable(false);
        jPanel1.add(txtPuntosDespues);
        txtPuntosDespues.setBounds(330, 340, 50, 30);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juego/imagenes/fondo-bien.png"))); // NOI18N
        jLabel11.setText("jLabel11");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(0, 0, 444, 658);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cBoxUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxUnidadesActionPerformed
        actualizaDatos();
    }//GEN-LAST:event_cBoxUnidadesActionPerformed

    public void actualizaDatos() {
        unidadSelec = (Unidad) cBoxUnidades.getSelectedItem();
        if(unidadSelec != null){
            txtHeridas.setText(String.valueOf(unidadSelec.getHeridas()));
            txtFuerza.setText(String.valueOf(unidadSelec.getFuerza()));
            txtCombate.setText(String.valueOf(unidadSelec.getCombate()));
            txtMovimientos.setText(String.valueOf(unidadSelec.getMovimientos()));
            txtCoste.setText(String.valueOf(unidadSelec.getCoste()));
            txtDefensa.setText(String.valueOf(unidadSelec.getDefensa()));
            labelImagen.setIcon(new ImageIcon(unidadSelec.getImagen().getImage().getScaledInstance(labelImagen.getWidth(), labelImagen.getHeight(), Image.SCALE_DEFAULT)));
            
            txtPuntos.setText(String.valueOf(controladorPartida.getPartida().getJugadorActual().getPuntos()));
            txtPuntosDespues.setText(String.valueOf(
                controladorPartida.getPartida().getJugadorActual().getPuntos() - unidadSelec.getCoste())
            );
            if(Integer.parseInt(txtPuntosDespues.getText()) < 0){
                txtPuntosDespues.setBackground(Color.red);
            } else
                txtPuntosDespues.setBackground(null);
        }
    }
    

    private void btnFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinActionPerformed
        // TODO add your handling code here:
        Sonidos.chasquido();
        if(controladorPartida.getPartida().getJugadorActual().getNumero() == 1){
            controladorPartida.getPartida().nuevoTurno();
            txtJuActual.setText(" JUGADOR 2");
            cargaUnidades();
            this.jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juego/imagenes/fondo-mal.png")));
            controladorPartida.liberaEstadoCeldas();
            controladorPartida.marcaRegiones();
        }
        else{
            controladorPartida.liberaEstadoCeldas();
            controladorPartida.getPartida().resetTurnos();
            controladorPartida.getControladorJuego().startPartida();
            this.dispose();
        }
        
    }//GEN-LAST:event_btnFinActionPerformed
    
    private void cBoxUnidadesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cBoxUnidadesKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            btnFin.doClick();
    }//GEN-LAST:event_cBoxUnidadesKeyPressed

    public Unidad getUnidadSelec() {
        return unidadSelec;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFin;
    public javax.swing.JComboBox cBoxUnidades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JTextField txtCombate;
    private javax.swing.JTextField txtCoste;
    private javax.swing.JTextField txtDefensa;
    private javax.swing.JTextField txtFuerza;
    private javax.swing.JTextField txtHeridas;
    private javax.swing.JLabel txtJuActual;
    private javax.swing.JTextField txtMovimientos;
    private javax.swing.JTextField txtPuntos;
    private javax.swing.JTextField txtPuntosDespues;
    // End of variables declaration//GEN-END:variables
}


