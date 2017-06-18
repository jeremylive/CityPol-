package Programa;

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

/*Librerias a usar*/
/**
 *
 * @author live
 */
public class CityPoliTablero extends Thread {
    //Variables globales

    //Clases a usar
    private JsonManager json;
    private Grafo controlador_grafo;
    private VisualGraphics visualG;
    private Jugador jugadorA;
    private Jugador jugadorB;
    private NodoGrafo posA, destinoA;
    private NodoGrafo posB, destinoB;
    private Random random;
    private Reto retoA, retoB;
    private VisualMap interfaz;
    private Mazo mazoPaises;
    private Graphics panelTablero;
    private boolean reset;
    /**
     * Rutas calculadas para los jugadores
     */
    private int progresoA, progresoB;

    private LinkedList<NodoGrafo> rutaActualA;
    private LinkedList<NodoGrafo> rutaActualB;
    Retos retosA;
    Retos retosB;

    /**
     * Crea un controlador del tablero para el gameplay
     */
    public CityPoliTablero() {
        this.controlador_grafo = null;
        this.jugadorA = new Jugador();
        this.jugadorB = new Jugador();
        this.random = new Random();
        this.mazoPaises = new Mazo();
        json = new JsonManager();
        reset = false;
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
    public void setControlador_grafo(Grafo controlador_grafo) {
        this.controlador_grafo = controlador_grafo;
    }
<<<<<<< HEAD

    

=======
    public void start() {
        ventanaTablero.start();
    }
>>>>>>> a83ce6d9440325e12da968707d687c812e2592b0
    //Funciones
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

    private void updateGrafo(){
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
                x = random.nextInt(IConstants.panelWidth - IConstants.medidaNodo) + IConstants.medidaNodo;
                y = random.nextInt(IConstants.panelHeight - IConstants.altoSeparador - IConstants.medidaNodo) + IConstants.altoSeparador - IConstants.medidaNodo;
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
                DecimalFormat df2 = new DecimalFormat(".#");
                hipotenusa = Double.valueOf(df2.format(hipotenusa));
                controlador_grafo.addBorde("", origen, destino, hipotenusa);
                updateGrafo();
                try {
                    Thread.sleep(IConstants.sleep);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CityPoliTablero.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    public LinkedList<NodoGrafo> dijkstra(NodoGrafo a, NodoGrafo b){
        return controlador_grafo.getPathFromAtoB(a, b);
    }
    public NodoGrafo randomPos(){
        return controlador_grafo.getNodo(random.nextInt(controlador_grafo.getNodos().size() - 1));
    }
    public void nuevoReto() {
        retosA = new Retos();
        retosB = new Retos();
        progresoA = 0;
        progresoB = 0;
        posA = randomPos();
        posB = randomPos();
        retoA = retosA.getRetos().get(progresoA);
        retoB = retosB.getRetos().get(progresoB);
        
        do{
            destinoA = randomPos();
        }while(destinoA.getLugar().getTipos()[0].equals(retoA.tipoLugar));
        do{
            destinoB = randomPos();
        }while(destinoB.getLugar().getTipos()[0].equals(retoB.tipoLugar));
        rutaActualA = dijkstra(posA, destinoA);
        rutaActualB = dijkstra(posB, destinoB);
        reset = false;
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

    public void avanzarA(){
        
    }
    public void avanzarB(){
        
    }

    @Override
    public void run() {
        System.out.println("Comienza tablero");
        interfaz = new VisualMap();
        interfaz.setVisible(true);
        setPanelTablero(interfaz.getGraphics());
        visualG = new VisualGraphics(interfaz, controlador_grafo);
        interfaz.setAux(visualG);
        visualG.start();
        boolean turno = true;

        while (interfaz.isActive()) {

            if (interfaz.isSacarCarta()) {
                //Saco una carta random del deck de paises
                Carta nueva = mazoPaises.mazoLugares.get(random.nextInt(mazoPaises.mazoLugares.size()));
                //Le cambio el tablero a la interraz
                Set<String> tipos =new HashSet<>();
                while(tipos.size()< IConstants.pedidosPorJuego){
                    String tipo = IConstants.tipos[random.nextInt(IConstants.tipos.length-1)];
                    tipos.add(tipo);
                } 
                String[] nuevo = new String[IConstants.pedidosPorJuego];
                Iterator<String> it = tipos.iterator();
                for(int i =0 ; i<nuevo.length;i++)
                {
                    if(it.hasNext())
                        nuevo[i] = it.next();
                    else
                        break;
                }
                setControlador_grafo(json.construirGrafo(interfaz,nuevo, nueva.getLatitud(), nueva.getLongitud(), (String) interfaz.getjComboBox1().getSelectedItem()));
                crearPosicionesNodos();
                crearConexiones();
                interfaz.cartaDesplegada();
                reset = true;
            }
            if (controlador_grafo != null) {
                if (reset) {
                    nuevoReto();
                }
                interfaz.getLblRetoA().setText(retosA.getRetos().get(progresoA).toString());
                interfaz.getLblRetoB().setText(retosB.getRetos().get(progresoB).toString());
                if (interfaz.isThrowDice()) {
                    int sleep = 20;
                    Dado dado = new Dado();
                    while (sleep < 500) {
                        interfaz.getLblDice().setText("DICE : " + dado.throwDice());
                        try {
                            Thread.sleep(sleep);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(CityPoliTablero.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        sleep += 40;
                    }
                    for (int k = 0; k < dado.getDice(); k++) {
                        if (turno) {
                            avanzarA();
                        } else {
                            avanzarB();
                        }
                    }
                    turno = !turno;

                    interfaz.setThrowDice(false);
                }
                if (progresoA == 3) {
                    System.out.println("Ha ganado el A");
                }
                if (progresoB == 3) {
                    System.out.println("Ha ganado el B");
                }

            }

        }
        visualG.setTerminar(true);
        //Podria devolverse al login para jugar otra partida con jugadores diferentes
        System.out.println("PArtida terminada");
    }

}
