/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import static juego.controlador.BD.getUnidad;
import juego.modelo.Jugador;
import juego.modelo.Partida;
import juego.modelo.Unidad;
import juego.vista.Celda;
import juego.vista.DespliegueFrame;
import juego.vista.LateralFrame;
import juego.vista.TableroFrame;

/**
 * Se encarga de manejar toda la lógica de la partida y hace de intermediario
 * entre el tablero y el lateral
 * 
 * Recibe los eventos de las Celdas en el tablero. (Actua como MouseListener)
 * @author Álvaro
 */
public class ControladorPartida  implements MouseListener{
    private final Border B_NORMAL = null;
    private final Border B_ENEMIGO = BorderFactory.createLineBorder(Color.RED,3);
    private final Border B_SELEC = BorderFactory.createLineBorder(Color.BLUE,3);
    private final Border B_MOVIMIENTO = BorderFactory.createLineBorder(Color.GREEN,3);
    private final Border B_RATON = BorderFactory.createLineBorder(Color.CYAN,3);
    
    private TableroFrame tableroFrame;
    private LateralFrame lateralFrame;
    private DespliegueFrame despliegueFrame;
    private Celda[][] celdas;
    private Jugador j1;
    private Jugador j2;
    private Celda celdaSeleccionada;
    private Celda celdaTemp;
    private Partida partida;
    
    // QUITAR DESPUES
    int cuentaUnidad = 0;
    private Unidad unidadTemp;
    // QUITAR DESPUES
    private final ControladorJuego controladorJuego;
    
    
    /**
     * Constructor
     */
    public ControladorPartida(Partida partida, ControladorJuego controladorJuego) {
        this.controladorJuego = controladorJuego;
        this.partida = partida;
        this.j1 = partida.getJ1();
        this.j2 = partida.getJ2();
    }

    public ControladorJuego getControladorJuego() {
        return controladorJuego;
    }

    public void setDespliegueFrame(DespliegueFrame despliegueFrame) {
        this.despliegueFrame = despliegueFrame;
    }
    
    public void setLateralFrame(LateralFrame lateralFrame){
        this.lateralFrame = lateralFrame;
        lateralFrame.escribeLinea("Turno: "+partida.getContTurnos()+" ("+partida.getTurnoNombre()+")"+"\n");
    }
    
    public  void setTableroFrame(TableroFrame tableroFrame){
        this.tableroFrame = tableroFrame;
        this.celdas = tableroFrame.getCeldas();
    }
    
    public void nuevoTurno() {
        Sonidos.nuevoTurno();
        Celda celda;
        //JOptionPane.showMessageDialog(tableroFrame,"Nuevo TURNO");
        partida.nuevoTurno();
        if(haySeleccionada())
            liberaEstadoCeldas();
  
        // Reinicia el estado de todas las Unidades
        for(int i = 0;i < celdas.length;i++){
            for(int j = 0;j < celdas[i].length;j++){
                celda = celdas[i][j];
                if(!celda.isEmpty()){
                    celda.getUnidad().setHaActuado(false);
                    celda.repaint();
                }
            }
        }
        lateralFrame.escribeLinea("Turno: "+partida.getContTurnos()+" ("+partida.getTurnoNombre()+")"+"\n");
    }

    public void buscaMovimientos(int desplazamiento, Celda celda){
        buscador(desplazamiento, celda, null);
    }
    
    private void buscador(int desplazamiento, Celda celdaInicial, Celda celdaAnterior){
        int indiceY = celdaInicial.getIndiceY();
        int indiceX = celdaInicial.getIndiceX();
        if((celdaInicial.isEmpty()) || celdaAnterior == null){
            if(celdaAnterior != null)
                celdaInicial.setBorder(B_MOVIMIENTO);
            if(celdaInicial.getUnidad() == null || (celdaInicial.getUnidad() != null && !unidadEsJugadorActual(celdaInicial)))
                celdaInicial.setMarcada(true);
            if(desplazamiento!= 0){
                for(int i = indiceY - 1; i <= indiceY + 1; i++){
                    for(int j = indiceX - 1; j <= indiceX + 1; j++){
                        try{
                            if((celdaAnterior == null || !celdaAnterior.equals(celdas[i][j])) &&
                            (celdas[i][j].getIndiceY() == celdaInicial.getIndiceY() || celdas[i][j].getIndiceX() == celdaInicial.getIndiceX())){
                                
                                buscador(desplazamiento-1,celdas[i][j],celdaInicial);
                            }
                         }catch(ArrayIndexOutOfBoundsException aioobe){}
                    }
                }
            }
        } else if(!celdaInicial.isEmpty() && sonEnemigos(celdaInicial,celdaSeleccionada)){
            celdaInicial.setBorder(B_ENEMIGO);
            celdaInicial.setMarcada(true);
        } else if(sonEnemigos(celdaInicial,celdaSeleccionada)){
            // por si acaso
        }
    }

    private boolean sonEnemigos(Celda celda1,Celda celda2) {
        return !celda1.getUnidad().getJugador().equals(celda2.getUnidad().getJugador());
    }
    
    private void mueve(Celda origen, Celda destino){
        Unidad unidad = origen.getUnidad();
        origen.quitaUnidad();
        destino.setUnidad(unidad);
        origen.repaint();
        destino.repaint();
    }
    private void liberaEstadoCeldas() {
        celdaSeleccionada = null;
        if(controladorJuego.getEstado() == Estado.JUGANDO)
            lateralFrame.limpiaDatos();

        for(Celda[] celdasArr : celdas){
            for(Celda celda : celdasArr){
                celda.setSelected(false);
                celda.setMarcada(false);
                celda.setBorder(B_NORMAL);
            }
        }
    }

    private void manejaClicIzquierdo(Celda celdaClic) {
            // PARA PRUEBAS
            if(lateralFrame.btnPrueba1()){
                cuentaUnidad++;
                //unidadTemp = new Unidad("Jinete Huargo"+cuentaUnidad,3,2,2,2,3,j1,"Caballeria");
                unidadTemp = new Unidad(getUnidad("Damrod"),j1);
                //unidadTemp.setMovimientos(5);
                //unidadTemp.setImagen("/juego/imagenes/mal/jinetehuargo.jpg");
                celdaClic.setUnidad(unidadTemp);
            } 
            else if(lateralFrame.btnPrueba2()){
                cuentaUnidad++;
                //unidadTemp = new Unidad("Jefe Troll"+cuentaUnidad,3,2,2,2,3,j2,"Monstruo");
                unidadTemp = new Unidad(getUnidad("Jefe Troll"),j2);
                //unidadTemp.setMovimientos(3);
                //unidadTemp.setImagen("/juego/imagenes/mal/jefetroll.jpg");
                celdaClic.setUnidad(unidadTemp);
            } // PARA PRUEBAS FIN

            // DURANTE LA PARTIDA
            else if (celdaClic.isMarcada() && !celdaSeleccionada.getUnidad().haActuado()){
                if(celdaClic.isEmpty()){
                    celdaSeleccionada.getUnidad().setHaActuado(true);
                    mueve(celdaSeleccionada,celdaClic);
                    liberaEstadoCeldas();
                    compruebaFinTurno();
                } else if(sonEnemigos(celdaClic,celdaSeleccionada)){
                    combate(celdaClic);
                    compruebaFinTurno();
                } 
                Sonidos.chasquido();
                compruebaFinPartida();
            } else if(!celdaClic.isEmpty() && unidadEsJugadorActual(celdaClic) ){
                selecciona(celdaClic);
                if(!celdaSeleccionada.getUnidad().haActuado())
                    buscaMovimientos(celdaClic.getUnidad().getMovimientos(),celdaClic);
            }
            celdaClic.repaint();
        
    }

    private void clickEnDespliegue(MouseEvent e) {
        Celda celda = (Celda) e.getSource();
        int puntos = partida.getJugadorActual().getPuntos();
        if(SwingUtilities.isLeftMouseButton(e)){
            if(celda.isEmpty()){
                int coste = ((Unidad)despliegueFrame.cBoxUnidades.getSelectedItem()).getCoste();
                if(puntos - coste >= 0){
                    Unidad unidad = new Unidad(
                        (Unidad)despliegueFrame.cBoxUnidades.getSelectedItem(),
                        partida.getJugadorActual()
                    );
                    celda.setUnidad(unidad);
                    partida.getJugadorActual().setPuntos(puntos - coste);
                } else{
                    JOptionPane.showMessageDialog(tableroFrame, "No puedes permitirte esa unidad");
                }
            }
        }
        else if(SwingUtilities.isRightMouseButton(e)){
            if(!celda.isEmpty()){
                partida.getJugadorActual().setPuntos(partida.getJugadorActual().getPuntos() + celda.getUnidad().getCoste()); 
                celda.quitaUnidad();
                celda.repaint();
            }
        }
        despliegueFrame.actualizaDatos();
        
        celda.repaint();
    }

    private void compruebaFinPartida(){
        boolean j1TieneUnidades = false;
        boolean j2TieneUnidades = false;
        Celda celda;
        for(int i = 0;i < celdas.length && (!j1TieneUnidades || !j2TieneUnidades);i++){
            for(int j = 0;j < celdas[i].length && (!j1TieneUnidades || !j2TieneUnidades);j++){
                celda = celdas[i][j];
                if (!celda.isEmpty())
                    if(celda.getUnidad().getJugador().getNumero() == 1)
                        j1TieneUnidades = true;
                    else
                        j2TieneUnidades = true;
            }
        }
        if(!j1TieneUnidades || !j2TieneUnidades){
            String ganador;
            if(!j1TieneUnidades)
                ganador = partida.getJ2().getNombre();
            else
                ganador = partida.getJ1().getNombre();
            JOptionPane.showMessageDialog(tableroFrame, "Partida finalizada. "+ganador+" ha ganado.");
            controladorJuego.startInicio();
            Sonidos.stopHiloMusical();
            lateralFrame.dispose();
            tableroFrame.dispose();
        }
            
    }
    
    private void selecciona(Celda celda) {
        liberaEstadoCeldas();
        lateralFrame.actualizaDatosSelec(celda);
        celdaSeleccionada = celda;
        celda.setSelected(true);
        celda.setBorder(B_SELEC);
    }

    private boolean haySeleccionada() {
        return celdaSeleccionada != null;
    }

    private boolean unidadEsJugadorActual(Celda celda) {
        return celda.getUnidad().getJugador().equals(partida.getJugadorActual());
    }
    
    private void combate(Celda celdaAtacada) {
        celdaSeleccionada.getUnidad().setHaActuado(true);
        lateralFrame.escribeLinea("##Combate##\n");
        Unidad uAtacante = celdaSeleccionada.getUnidad();
        Unidad uDefensora = celdaAtacada.getUnidad();
        Unidad ganadora = Pelea.ataques(uAtacante,  uDefensora);
        //System.out.println("--------------------- SUCEDE COMBATE ---------------------");
        lateralFrame.escribeLinea(uAtacante.getNombre()+"("+uAtacante.getJugador().getNombre()+")"+" ataca a "+uDefensora.getNombre()+"("+uDefensora.getJugador().getNombre()+")"+"\n");
        if(ganadora.equals(uAtacante)){
           // System.out.println("GANA ATACANTE");  
            lateralFrame.escribeLinea("Gana "+uAtacante.getNombre()+"\n");
            if(uDefensora.getHeridas() <= 0){
                lateralFrame.escribeLinea("Muere "+uDefensora.getNombre()+"\n");
                Sonidos.muerte();
                //System.out.println("MUERE DEFENSOR");
            } else{
                celdaTemp = celdaAtacada;
                retrocede(celdaAtacada);
            }
            mueve(celdaSeleccionada,celdaAtacada);
            lateralFrame.repaint();
        } else{
            lateralFrame.escribeLinea("Gana "+uDefensora.getNombre()+"\n");
            if(uAtacante.getHeridas() <= 0){
                lateralFrame.escribeLinea("Muere "+uAtacante.getNombre()+"\n");
                Sonidos.muerte();
                //System.out.println("MUERE ATACANTE");
                celdaSeleccionada.quitaUnidad();
            } else{
                /*
                 * TODO Desarrollar método que calcule donde debe quedar el atacante
                 * cuando pierde el combate
                 * Una posibilidad es darle a elegir que casilla quiere
                 */
                // TODO calculaMovimiento();
            }
            //System.out.println("GANA DEFENSOR");
        }
        //System.out.println("---ATACANTE---\n##########\n"+uAtacante+"\n##########");
        //System.out.println("---DEFENSOR---\n##########\n"+uDefensora+"\n##########");
        //System.out.println("--------------------- TERMINA COMBATE ---------------------");
        lateralFrame.repaint();
        liberaEstadoCeldas();
        //System.out.println(celdaSeleccionada.getUnidad().equals(celda.getUnidad()));
    }

    /**
     * TODO Todavia no funciona correctamente
     */
    private void retrocede(Celda celdaAtacada) {
        int indiceYAnterior;
        if(partida.getJugadorActual().getNumero()==1)
            indiceYAnterior = celdaAtacada.getIndiceY()-1;
        else
            indiceYAnterior = celdaAtacada.getIndiceY()+1;
        if(indiceYAnterior < 0 || indiceYAnterior >= celdas.length){
            if (celdaTemp == null)
                celdaTemp = celdaAtacada;
            lateralFrame.escribeLinea("Muere "+celdaTemp.getUnidad().getNombre()+"-\"Por acorralamiento\"\n");
            celdaTemp.quitaUnidad();
            celdaTemp = null;
            Sonidos.muerte();
        } else{
            Celda celdaAnterior = celdas[indiceYAnterior][celdaAtacada.getIndiceX()];
            if(celdaAnterior.isEmpty()){
                celdaAnterior.setUnidad(celdaAtacada.getUnidad());
                celdaAnterior.repaint();
            } else{  
                retrocede(celdaAnterior);
                mueve(celdaAtacada,celdaAnterior);
            }
        }
    }
    
    private void compruebaFinTurno(){
        boolean acabaTurno = true;
        Celda celda;
        for(int i = 0;i < celdas.length && acabaTurno;i++){
            for(int j = 0;j < celdas[i].length && acabaTurno;j++){
                celda = celdas[i][j];
                if (!celda.isEmpty() && 
                    unidadEsJugadorActual(celda) &&
                    !celda.getUnidad().haActuado())
                    
                    acabaTurno = false;                                    
            }
        }
        if(acabaTurno)
            this.nuevoTurno();
        
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        // Sin uso de momento
        /*
         * Interesa más mousePressed dado que no hace falta soltar el boton
         */
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        Celda celda = (Celda) e.getSource();
        if(controladorJuego.getEstado() == Estado.DESPLIEGUE){
            clickEnDespliegue(e);
        } else{
            if(SwingUtilities.isLeftMouseButton(e)){
                manejaClicIzquierdo(celda);
            }
            // PARA PRUEBAS
            else if(SwingUtilities.isRightMouseButton(e)){
                if(!celda.isEmpty()){
                    celda.quitaUnidad();
                    celda.repaint();
                }
                liberaEstadoCeldas();
            } 
            // PARA PRUEBAS FIN
            else if(SwingUtilities.isMiddleMouseButton(e)){
                if(celda.isEmpty())
                    lateralFrame.limpiaDatos();
                else
                    lateralFrame.actualizaDatosSelec(celda);
            } 
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        if(SwingUtilities.isMiddleMouseButton(e)){
            if(celdaSeleccionada != null)
                lateralFrame.actualizaDatosSelec(celdaSeleccionada);
            else
                lateralFrame.limpiaDatos();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Celda celda = (Celda) e.getSource();
        if(!celda.isSelected() && !celda.isMarcada()){
            celda.setBorder(B_RATON);
            
        }
        if(SwingUtilities.isMiddleMouseButton(e)){
            if(celda.isEmpty())
                lateralFrame.limpiaDatos();
            else
                lateralFrame.actualizaDatosSelec(celda);
        }
        celda.oscurece();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Celda celda = (Celda) e.getSource(); 
        if(!celda.isSelected() && !celda.isMarcada()){
            celda.setBorder(B_NORMAL);
        }
        celda.aclara();
    }

    public Partida getPartida() {
        return partida;
    }
    
    
}
