package Programa;
//Bibliotecas a usar

import Controlador.JsonManager;
import Estructura.Conexion;
import Estructura.Grafo;
import Estructura.NodoGrafo;
import GamePlay.Carta;
import GamePlay.Dado;
import GamePlay.Jugador;
import GamePlay.Mazo;
import GamePlay.Reto;
import GamePlay.Retos;
import Interfaz.VisualGraphics;
import Interfaz.VisualMap;
import Libreria.Dijkstra;
import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author live y edgerik
 */
public class CityPoliTablero extends Thread {

    //Variables globales
    //Clases a usar
    private final JsonManager json;
    private Grafo controlador_grafo;
    private VisualGraphics visualG;
    private Jugador jugadorA;
    private Jugador jugadorB;
    private NodoGrafo posA, destinoA;
    private NodoGrafo posB, destinoB;
    private final Random random;
    private Reto retoA, retoB;
    private VisualMap interfaz;
    private Mazo mazoPaises;
    private Graphics panelTablero;
    private boolean reset;
    private boolean turno;
    private int totalVisitados;
    private int visitasA, visitasB;
    private int progresoA, progresoB;   //Rutas calculadas para los jugadores
    private int pasosA, pasosB;
    private double puntosA, puntosB, puntosTotal;
    private LinkedList<NodoGrafo> rutaActualA;
    private LinkedList<NodoGrafo> rutaActualB;
    private Retos retosA;
    private Retos retosB;

    /**
     * Crea un controlador del tablero para el gameplay
     */
    public CityPoliTablero()
    {
        this.controlador_grafo = null;
        this.jugadorA = new Jugador();
        this.jugadorB = new Jugador();
        this.random = new Random();
        this.mazoPaises = new Mazo();
        this.json = new JsonManager();
        this.reset = false;
        this.visualG = null;
        this.posA = null;
        this.destinoA = null;
        this.posB = null;
        this.destinoB = null;
        this.retoA = null;
        this.retoB = null;
        this.interfaz = null;
        this.panelTablero = null;
        this.turno = true;
        this.progresoA = 0;
        this.progresoB = 0;
        puntosA = 0.0;
        puntosB = 0.0;
        puntosTotal = 0.0;
        visitasA = 0;
        visitasB = 0;
        totalVisitados = 0;
        this.rutaActualA = null;
        this.rutaActualB = null;
        this.retosA = null;
        this.retosB = null;
    }

    //Gets and Sets
    public Jugador getJugadorB() {
        return jugadorB;
    }

    public Grafo getControlador_grafo() {
        return controlador_grafo;
    }

    public void setJugadorA(Jugador jugadorA) {
        this.jugadorA = jugadorA;
    }

    public void setJugadorB(Jugador jugadorB) {
        this.jugadorB = jugadorB;
    }

    public boolean setControlador_grafo(Grafo controlador_grafo) {
        this.controlador_grafo = controlador_grafo;
        return this.controlador_grafo == null;
    }

    public Jugador getJugadorA() {
        return jugadorA;
    }

    public VisualMap getInterfaz() {
        return interfaz;
    }

    public void setInterfaz(VisualMap interfaz) {
        this.interfaz = interfaz;
    }

    public Mazo getMazoPaises() {
        return mazoPaises;
    }

    public void setMazoPaises(Mazo mazoPaises) {
        this.mazoPaises = mazoPaises;
    }

    public Graphics getPanelTablero() {
        return panelTablero;
    }

    public void setPanelTablero(Graphics panelTablero) {
        this.panelTablero = panelTablero;
    }

    public VisualGraphics getVisualG() {
        return visualG;
    }
    public void setVisualG(VisualGraphics visualG) {
        this.visualG = visualG;
    }

    public boolean isReset() {
        return reset;
    }

    public void setReset(boolean reset) {
        this.reset = reset;
    }

    public int getProgresoA() {
        return progresoA;
    }

    public void setProgresoA(int progresoA) {
        this.progresoA = progresoA;
    }

    public int getProgresoB() {
        return progresoB;
    }

    public void setProgresoB(int progresoB) {
        this.progresoB = progresoB;
    }

    public Retos getRetosA() {
        return retosA;
    }

    public void setRetosA(Retos retosA) {
        this.retosA = retosA;
    }

    public Retos getRetosB() {
        return retosB;
    }

    public void setRetosB(Retos retosB) {
        this.retosB = retosB;
    }

    public NodoGrafo getDestinoA() {
        return destinoA;
    }

    public NodoGrafo getDestinoB() {
        return destinoB;
    }

    public NodoGrafo getPosA() {
        return posA;
    }

    public void setPosA(NodoGrafo posA) {
        this.posA = posA;
    }

    public NodoGrafo getPosB() {
        return posB;
    }

    public void setPosB(NodoGrafo posB) {
        this.posB = posB;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public int getPasosA() {
        return pasosA;
    }

    public void setPasosA(int pasosA) {
        this.pasosA = pasosA;
    }

    public int getPasosB() {
        return pasosB;
    }

    public void setPasosB(int pasosB) {
        this.pasosB = pasosB;
    }

    public LinkedList<NodoGrafo> getRutaActualA() {
        return rutaActualA;
    }

    public void setRutaActualA(LinkedList<NodoGrafo> rutaActualA) {
        this.rutaActualA = rutaActualA;
    }

    public LinkedList<NodoGrafo> getRutaActualB() {
        return rutaActualB;
    }

    public void setRutaActualB(LinkedList<NodoGrafo> rutaActualB) {
        this.rutaActualB = rutaActualB;
    }
        private void updateGrafo() {
        visualG.setControlador_grafo(controlador_grafo);
    }

    /**
     * Brinda posiciones aletorias a los nodos para poder pintarlos
     */
    public void crearPosicionesNodos() {
        int x = 0, y = 0;
        List<NodoGrafo> nodos = controlador_grafo.getNodos();

        for (NodoGrafo nodo : nodos) {
            do {
                x = random.nextInt(IConstants.panelWidth - (IConstants.medidaNodo*IConstants.escalaImagen)) + IConstants.medidaNodo;
                y = random.nextInt(IConstants.panelHeight - (IConstants.medidaNodo*IConstants.escalaImagen)) - IConstants.medidaNodo;
            } while (controlador_grafo.inListaPuntos(x, y));

            nodo.setPosX(x);
            nodo.setPosY(y);

            updateGrafo();
            try {
                Thread.sleep(IConstants.sleep);
            } catch (InterruptedException ex) {
                Logger.getLogger(CityPoliTablero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Mide las distancias de nodo a nodo y crea conexiones entre ellos
     * dependiendo del la latitud y longitud del Lugar del Nodo
     */
    public void crearConexiones() {
        double distanciaX, distanciaY, hipotenusa;
        List<NodoGrafo> nodos = controlador_grafo.getNodos();

        for (NodoGrafo origen : nodos) {
            NodoGrafo destino;

            for (int i = 0; i < IConstants.conexionesPorNodo; i++) {
                int ran = random.nextInt(nodos.size());
                destino = nodos.get(ran);
                distanciaX = controlador_grafo.getDistancia(origen.getLugar().getLatitud(), destino.getLugar().getLatitud());
                distanciaY = controlador_grafo.getDistancia(origen.getLugar().getLongitud(), destino.getLugar().getLongitud());
                distanciaX = Math.pow(distanciaX, 2);
                distanciaY = Math.pow(distanciaY, 2);
                hipotenusa = Math.sqrt(distanciaX + distanciaY);
                hipotenusa = hipotenusa * IConstants.escalaDistancia;
                
                hipotenusa = form(hipotenusa);
                controlador_grafo.addBorde("", origen, destino, hipotenusa);
                updateGrafo();
//
//                try {
//                    Thread.sleep(5);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(CityPoliTablero.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }

        }
    }
    public double form(double x){
        DecimalFormat df2 = new DecimalFormat(".#");
        return Double.valueOf(df2.format(x));
    }

    /**
     *
     * @param a
     * @param b
     * @param player
     * @return
     */
    public LinkedList<NodoGrafo> dijkstra(NodoGrafo a, NodoGrafo b, boolean player) {
        return controlador_grafo.getPathFromAtoB(a, b, player);
    }

    /**
     *
     * @return
     */
    public NodoGrafo randomPos() {
        if (controlador_grafo.getNodos().size() > 0) {
            return controlador_grafo.getNodo(random.nextInt(controlador_grafo.getNodos().size() - 1));
        } else {
            return null;
        }
    }

    public void randomA() {
        try {
            posA = randomPos();
            pasosA = 0;
        } catch (NullPointerException e) {
        }
    }

    public void randomB() {
        try {
            posB = randomPos();
            pasosB=0;
        } catch (NullPointerException e) {

        }
    }
    public boolean isInRutaA(Conexion c) {
        for (int i = 1; i < rutaActualA.size(); i++) {
            Conexion aux = controlador_grafo.getConexion(rutaActualA.get(i - 1), rutaActualA.get(i));
            if (aux != null) {
                if (aux.getOrigen().getName().equals(c.getOrigen().getName()) && aux.getDestino().getName().equals(c.getDestino().getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isInRutaB(Conexion c) {
        for (int i = 1; i < rutaActualB.size(); i++) {
            Conexion aux = controlador_grafo.getConexion(rutaActualB.get(i - 1), rutaActualB.get(i));
            if (aux != null) {
                if (aux.getOrigen().getName().equals(c.getOrigen().getName()) && aux.getDestino().getName().equals(c.getDestino().getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     */
    public void nuevoReto() {
        retosA = new Retos();
        retosB = new Retos();
        progresoA = 0;
        progresoB = 0;
        puntosA = 0;
        puntosB = 0;
        puntosTotal = 0;
        interfaz.getLblRateA().setText("0.0");
        interfaz.getLblRateB().setText("0.0");
        visitasA = 0;
        visitasB = 0;
        totalVisitados = 0;
        randomA();
        randomB();
        updateGrafo();
        reset = false;
    }

    public void reCalA() {
        do {
            destinoA = randomPos();

        } while (destinoA.getLugar().getTipos()[0].equals(retoA.tipoLugar));

        rutaActualA = dijkstra(posA, destinoA, true);

    }

    public void reCalB() {
        do {
            destinoB = randomPos();
        } while (destinoB.getLugar().getTipos()[0].equals(retoB.tipoLugar));

        rutaActualB = dijkstra(posB, destinoB, false);
    }

    public void reCalcularRutas() {
        destinoA = randomPos();
        if (destinoA != null) {
            reCalA();
            reCalB();
            updateGrafo();
        }
    }
    public boolean avanzarA() {
        if (rutaActualA != null) {
            pasosA++;

            if (rutaActualA.size() - 1 == pasosA) {
                progresoA++;
                posA = rutaActualA.get(pasosA);
                puntosTotal += posA.getLugar().getPuntaje();
                jugadorA.setRanking(jugadorA.getRanking() + puntosA);
                randomA();
                reCalA();
                return true;
            } else {
                try{
                    posA = rutaActualA.get(pasosA);
                }catch(IndexOutOfBoundsException e){
                    System.out.println("SI SE CAE es por el index out ");
                    randomA();
                    reCalA();
                }
            }
//            System.out.println("PosA " + posA.getName());
//            rutaActualA = dijkstra(posA, destinoA, true);
//            for (NodoGrafo nodoGrafo : rutaActualA) {
//                System.out.println("Nodo rutA" + nodoGrafo.getName());
//            }
        }
        return false;
    }

    public boolean avanzarB() {
        if (rutaActualB != null) {
            pasosB++;
            if (rutaActualB.size() - 1 == pasosB) {
                progresoB++;
                posB = rutaActualB.get(pasosB);
                puntosTotal += posB.getLugar().getPuntaje();
                jugadorB.setRanking(jugadorB.getRanking() + puntosB);
                randomB();
                reCalB();
                return true;
            } else {
                try{
                    posB = rutaActualB.get(pasosB);
                }catch(IndexOutOfBoundsException e){
                    
                    System.out.println("SI SE CAE es por el index out ");
                    randomB();
                    reCalB();
                }
            }
//            rutaActualB = dijkstra(posB, destinoB, false);
//            for (NodoGrafo nodoGrafo : rutaActualB) {
//                System.out.println("Nodo RUTAb" + nodoGrafo.getName());
//            }
        }
        return false;
    }
    /**
     * Logica de juego del tablero
     */
    public void gameplay() {
        if (reset) {
            nuevoReto();
            retoA = retosA.getRetos().get(progresoA);
            retoB = retosB.getRetos().get(progresoB);
            reCalcularRutas();
        }
        interfaz.getLblRetoA().setText(retosA.getRetos().get(progresoA).toString());
        interfaz.getLblRetoB().setText(retosB.getRetos().get(progresoB).toString());
        interfaz.getLblPuntosA().setText(form(puntosA)+"");
        interfaz.getLblPuntosB().setText(form(puntosB)+"");
        interfaz.getLblRateA().setText(""+form(jugadorA.getRanking()));
        interfaz.getLblRateB().setText(""+form(jugadorB.getRanking()));
        interfaz.getLblvisitasA().setText(visitasA+"");
        interfaz.getLblvisitasB().setText(visitasB+"");
        interfaz.getLblvisitasTotal().setText(totalVisitados+"");
        
        if (interfaz.isThrowDice()) {
            int sleep = 100;
            Dado dado = new Dado();

            while (sleep > 0) {
                interfaz.getLblDice().setText("DADO : "+"( " + dado.throwDice()+" )");
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CityPoliTablero.class.getName()).log(Level.SEVERE, null, ex);
                }
                sleep -= 5;
            }
            try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CityPoliTablero.class.getName()).log(Level.SEVERE, null, ex);
                }

            for (int k = 0; k < dado.getDice(); k++) {
                totalVisitados++;
                if (turno) {
                    visitasA++;
                    if (avanzarA()) {
                        break;
                    }
                } else {
                    visitasB++;
                    if (avanzarB()) {
                        break;
                    }
                }
                updateGrafo();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CityPoliTablero.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            turno = !turno;
            if(turno){
                interfaz.getLblturno().setText("Turno de: A" );
            }else{
                interfaz.getLblturno().setText("Turno de: B" );
            }
            

            interfaz.setThrowDice(false);
        }
        interfaz.getProgressA().setValue(progresoA * 100 / IConstants.cantidadRetos);
        if (progresoA == IConstants.cantidadRetos) {
            JOptionPane.showMessageDialog(interfaz,"Se suma total para A y total/2 para B","RETOS COMPLETADOS", JOptionPane.INFORMATION_MESSAGE);
            jugadorA.setRanking(jugadorA.getRanking()+puntosTotal);
            jugadorB.setRanking(jugadorB.getRanking()+puntosTotal/2);
            reset = true;
        }
        interfaz.getProgressB().setValue(progresoB * 100 / IConstants.cantidadRetos);
        if (progresoB == IConstants.cantidadRetos) {
            JOptionPane.showMessageDialog(interfaz,"Se suma total para B y total/2 para A","RETOS COMPLETADOS", JOptionPane.INFORMATION_MESSAGE);
            jugadorB.setRanking(jugadorB.getRanking()+puntosTotal);
            jugadorA.setRanking(jugadorA.getRanking()+puntosTotal/2);
            reset = true;
        }

    }

    /**
     *
     */
    @Override
    public void run() {
        interfaz = new VisualMap();
        interfaz.setExtendedState(interfaz.MAXIMIZED_BOTH);
        interfaz.setVisible(true);
        setPanelTablero(interfaz.getGraphics());
        visualG = new VisualGraphics(interfaz, controlador_grafo, this);
        interfaz.setAux(visualG);
        visualG.start();
        turno = true;
        boolean cerrarTablero = true;
        while (cerrarTablero) {

            if (interfaz.isSacarCarta()) {
                //Saco una carta random del deck de paises
                Carta nueva = mazoPaises.mazoLugares.get(random.nextInt(mazoPaises.mazoLugares.size()));
                //Le cambio el tablero a la interraz
                Set<String> tipos = new HashSet<>();
                int progreso = 5;
                interfaz.getApiProgress().setValue(progreso);
                interfaz.getLblEstadoApi().setText("Cargando datos de jugadores...");
                while (tipos.size() < IConstants.pedidosPorJuego) {
                    String tipo = IConstants.tipos[random.nextInt(IConstants.tipos.length - 1)];
                    tipos.add(tipo);
                    progreso++;
                    interfaz.getApiProgress().setValue(progreso);

                }
                String[] nuevo = new String[IConstants.pedidosPorJuego];
                Iterator<String> it = tipos.iterator();

                for (int i = 0; i < nuevo.length; i++) {
                    progreso++;
                    interfaz.getApiProgress().setValue(progreso);
                    
                    if (it.hasNext()) {
                        nuevo[i] = it.next();
                    } else {
                        break;
                    }
                }
                interfaz.getLblEstadoApi().setText("Esperando conexion...");
                if (setControlador_grafo(json.construirGrafo(interfaz, nuevo, nueva.getLatitud(), nueva.getLongitud(), (String) interfaz.getjComboBox1().getSelectedItem()))) {
                    //JOptionPane.showInternalMessageDialog(null, "Problema...", "Parece haber una mala conexion", JOptionPane.ERROR_MESSAGE);
                    interfaz.getLblEstadoApi().setText("Parece que no hay conexion... Conectese e intente de nuevo");
                    cerrarTablero = false;
                } else {
                    crearPosicionesNodos();
                    crearConexiones();
                    interfaz.getApiProgress().setValue(100);
                    interfaz.cartaDesplegada();
                    reset = true;
                    interfaz.getLblEstadoApi().setText("Carga satisfactoria");
                }
                
            }
            if (controlador_grafo != null) {
                gameplay();
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(CityPoliTablero.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        visualG.setTerminar(true);
        //Podria devolverse al login para jugar otra partida con jugadores diferentes
        System.out.println("Partida terminada");
    }

    /**
     * Muestro en la itnerfaz principal, los datos del juego
     */
    public void muestroInfo() {

    }
}
