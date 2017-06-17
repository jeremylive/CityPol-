package Programa;

import Controlador.JsonManager;
import Estructura.Grafo;
import GamePlay.Jugador;
import Interfaz.VisualMap;
import Libreria.Dijkstra;
import java.util.Random;

/*Librerias a usar*/
/**
 *
 * @author live
 */
public class CityPoliTablero implements Runnable {
    //Variables globales

    //Clases a usar
    private final Thread ventanaTablero;
    private JsonManager json;
    private Grafo controlador_grafo;
    private Jugador jugadorA;
    private Jugador jugadorB;
    private Random random;
    private VisualMap interfaz;

    /**
     * Crea un controlador del tablero para el gameplay
     */
    public CityPoliTablero() {
        this.controlador_grafo = new Grafo();
        this.jugadorA = new Jugador();
        this.jugadorB = new Jugador();
        this.ventanaTablero = new Thread();
        this.random = new Random();
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

    public void start() {
        ventanaTablero.start();
    }

    //Funciones
    //...
    public Jugador getJugadorA() {
        return jugadorA;
    }

    @Override
    public void run() {
        System.out.println("Comienza tablero");
        interfaz = new VisualMap();
        interfaz.setVisible(true);
        boolean cambiarTablero = true;
        while (interfaz.isActive()) {
            
            if(cambiarTablero)
            {
                
                interfaz.update(json.construirGrafo(IConstants.tipos, 0, 0));
            }
            
            
        }
    }
}
