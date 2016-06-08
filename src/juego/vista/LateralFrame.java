/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.vista;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import juego.controlador.ControladorPartida;
import juego.controlador.Sonidos;

/**
 * JFrame que muestra los datos durante la partida
 * @author Álvaro
 */
public class LateralFrame extends javax.swing.JFrame{
    
    private TableroFrame tablero;
    private ControladorPartida controlador;
    
    /**
     * Constructor
     */
    public LateralFrame(ControladorPartida controlador) {
        this.controlador = controlador;
        initComponents(); // Inicia los componentes del diseñador
        this.getContentPane().setBackground( new Color(0,0,0) );
        tablero = controlador.getControladorJuego().getTableroF();
        this.setLocation(5, 5);
        controlador.setLateralFrame(this);
        btnMusica.doClick();
        btnTablero.setSelected(true);
        //btnTablero.doClick();
    }

    public void escribeLinea(String linea){
        txtArea.append(linea);
    }
    
    public void tableroCerrando(){
        this.btnTablero.setSelected(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTablero = new javax.swing.JToggleButton();
        cBoxSize = new javax.swing.JComboBox<>();
        txtHeridas = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        labelNombre = new javax.swing.JLabel();
        labelHeridas = new javax.swing.JLabel();
        labelImagen = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btnTurno = new javax.swing.JButton();
        btnMusica = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        txtFuerza = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDefensa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCombate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ponme un nombre");
        setResizable(false);

        btnTablero.setBackground(new java.awt.Color(0, 0, 0));
        btnTablero.setFont(new java.awt.Font("Ringbearer", 1, 10)); // NOI18N
        btnTablero.setForeground(new java.awt.Color(255, 255, 255));
        btnTablero.setText("Tablero");
        btnTablero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableroActionPerformed(evt);
            }
        });

        cBoxSize.setBackground(new java.awt.Color(0, 0, 0));
        cBoxSize.setFont(new java.awt.Font("Ringbearer", 1, 10)); // NOI18N
        cBoxSize.setForeground(new java.awt.Color(255, 255, 255));
        cBoxSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grande", "Mediano", "Pequeño" }));
        cBoxSize.setSelectedIndex(1);
        cBoxSize.setToolTipText("");
        cBoxSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxSizeActionPerformed(evt);
            }
        });

        txtHeridas.setEditable(false);
        txtHeridas.setBackground(new java.awt.Color(0, 0, 0));
        txtHeridas.setFont(new java.awt.Font("Ringbearer", 1, 14)); // NOI18N
        txtHeridas.setForeground(new java.awt.Color(255, 255, 255));
        txtHeridas.setFocusable(false);
        txtHeridas.setRequestFocusEnabled(false);

        txtNombre.setEditable(false);
        txtNombre.setBackground(new java.awt.Color(0, 0, 0));
        txtNombre.setFont(new java.awt.Font("Ringbearer", 1, 10)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setFocusable(false);
        txtNombre.setRequestFocusEnabled(false);

        labelNombre.setBackground(new java.awt.Color(0, 0, 0));
        labelNombre.setFont(new java.awt.Font("Ringbearer", 1, 10)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setText("Nombre");

        labelHeridas.setBackground(new java.awt.Color(0, 0, 0));
        labelHeridas.setFont(new java.awt.Font("Ringbearer", 1, 10)); // NOI18N
        labelHeridas.setForeground(new java.awt.Color(255, 255, 255));
        labelHeridas.setText("Heridas");

        labelImagen.setBackground(new java.awt.Color(0, 0, 0));
        labelImagen.setForeground(new java.awt.Color(255, 255, 255));
        labelImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        labelImagen.setFocusable(false);
        labelImagen.setOpaque(true);

        txtArea.setBackground(new java.awt.Color(0, 0, 0));
        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        txtArea.setForeground(new java.awt.Color(255, 255, 255));
        txtArea.setRows(5);
        txtArea.setFocusable(false);
        jScrollPane1.setViewportView(txtArea);

        btnTurno.setBackground(new java.awt.Color(0, 0, 0));
        btnTurno.setFont(new java.awt.Font("Ringbearer", 1, 10)); // NOI18N
        btnTurno.setForeground(new java.awt.Color(255, 255, 255));
        btnTurno.setText("Pasar turno");
        btnTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurnoActionPerformed(evt);
            }
        });

        btnMusica.setBackground(new java.awt.Color(0, 0, 0));
        btnMusica.setFont(new java.awt.Font("Ringbearer", 1, 10)); // NOI18N
        btnMusica.setForeground(new java.awt.Color(255, 255, 255));
        btnMusica.setText("Música");
        btnMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusicaActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Ringbearer", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Fuerza");

        txtFuerza.setEditable(false);
        txtFuerza.setBackground(new java.awt.Color(0, 0, 0));
        txtFuerza.setFont(new java.awt.Font("Ringbearer", 1, 14)); // NOI18N
        txtFuerza.setForeground(new java.awt.Color(255, 255, 255));
        txtFuerza.setFocusable(false);

        jLabel2.setText("jLabel2");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Ringbearer", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Defensa");

        txtDefensa.setEditable(false);
        txtDefensa.setBackground(new java.awt.Color(0, 0, 0));
        txtDefensa.setFont(new java.awt.Font("Ringbearer", 1, 14)); // NOI18N
        txtDefensa.setForeground(new java.awt.Color(255, 255, 255));
        txtDefensa.setFocusable(false);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Ringbearer", 1, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Combate");

        txtCombate.setEditable(false);
        txtCombate.setBackground(new java.awt.Color(0, 0, 0));
        txtCombate.setFont(new java.awt.Font("Ringbearer", 1, 14)); // NOI18N
        txtCombate.setForeground(new java.awt.Color(255, 255, 255));
        txtCombate.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(labelHeridas)
                                    .addComponent(labelNombre))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDefensa, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                            .addComponent(txtHeridas))
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel1))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCombate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFuerza, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtNombre))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(btnMusica))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(cBoxSize, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnTablero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnTurno, javax.swing.GroupLayout.Alignment.LEADING)))))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHeridas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelHeridas)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDefensa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtFuerza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCombate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTurno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTablero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cBoxSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cBoxSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxSizeActionPerformed
        // TODO add your handling code here:
        switch(this.cBoxSize.getSelectedIndex()){
            case 0:
                tablero.redimensionar('G');
                break;
            case 1:
                tablero.redimensionar('M');
                break;
            case 2:
                tablero.redimensionar('P');
                break;
        }
    }//GEN-LAST:event_cBoxSizeActionPerformed

    private void btnTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurnoActionPerformed
        controlador.nuevoTurno();
    }//GEN-LAST:event_btnTurnoActionPerformed

    private void btnMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusicaActionPerformed
        if(btnMusica.isSelected()){
            Sonidos.startHiloMusical();
        } else{
            Sonidos.stopHiloMusical();
        }
    }//GEN-LAST:event_btnMusicaActionPerformed

    private void btnTableroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableroActionPerformed
        // TODO add your handling code here:
        
        if(btnTablero.isSelected()){
            tablero.setVisible(true);
        } else{
            tablero.setVisible(false);
        }
    }//GEN-LAST:event_btnTableroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnMusica;
    private javax.swing.JToggleButton btnTablero;
    private javax.swing.JButton btnTurno;
    private javax.swing.JComboBox<String> cBoxSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelHeridas;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtCombate;
    private javax.swing.JTextField txtDefensa;
    private javax.swing.JTextField txtFuerza;
    private javax.swing.JTextField txtHeridas;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    public void actualizaDatosSelec(Celda celda) {
        txtNombre.setText(celda.getUnidad().getNombre());
        txtHeridas.setText(String.valueOf(celda.getUnidad().getHeridas()));
        txtFuerza.setText(String.valueOf(celda.getUnidad().getFuerza()));
        txtDefensa.setText(String.valueOf(celda.getUnidad().getDefensa()));
        txtCombate.setText(String.valueOf(celda.getUnidad().getCombate()));
        labelImagen.setIcon(new ImageIcon(celda.getUnidad().getImagen().getImage().getScaledInstance(labelImagen.getWidth(), labelImagen.getHeight(), Image.SCALE_DEFAULT)));
    }

    public void limpiaDatos() {
        txtNombre.setText("");
        txtHeridas.setText("");
        txtFuerza.setText("");
        txtDefensa.setText("");
        txtCombate.setText("");
        labelImagen.setIcon(null);
    }
    
    
}
