package Programa;

import Estructura.Grafo;
import GamePlay.Jugador;
import Libreria.Dijkstra;

/*Librerias a usar*/

/**
 *
 * @author live
 */
public class CityPoliTablero 
{
    //Variables globales
    
    //Clases a usar
    private Grafo controlador_grafo;
    private Dijkstra controlador_disjkstra;
    private Jugador control_jugador;
    //Constructores
    public CityPoliTablero()
    {
        this.controlador_grafo = new Grafo();
        this.controlador_disjkstra = new Dijkstra();
        this.control_jugador = new Jugador();
    }
    //Gets and Sets
    
    //Funciones
    
    //...
}
