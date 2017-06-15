package Estructura;

import Programa.IConstants;
import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Clase Singleton para manejo global de esta
 *
 * @author edgerik
 */
public class Grafo implements Observable{

    private static Grafo Instance;
    private List<NodoGrafo> nodos;
    private List<Borde> conexiones;
    private Dijkstra dijkstra;
    private Random random;
    private ArrayList<Point> puntosEnPantalla;

    /**
     * Por si acaso
     */
    public Grafo() {
        this.nodos = null;
        this.conexiones = null;
        this.dijkstra = new Dijkstra();
        this.random = new Random();
        this.puntosEnPantalla = new ArrayList<>();
    }

    /**
     * Constructor del grafo
     *
     * @param nodos Lista de nodos
     * @param conexiones Lista de arcos o bordes
     */
    private Grafo(List<NodoGrafo> nodos, List<Borde> conexiones) {
        this.nodos = nodos;
        this.conexiones = conexiones;
        this.dijkstra = new Dijkstra();
        this.random = new Random();
        this.puntosEnPantalla = new ArrayList<>();
    }

    /**
     * Patron singleton para manejar el grafo y sus funciones desde cualquier
     * clase
     *
     * @param nodos Lista de nodos que tendrá el arbol
     * @param conexiones Conexiones o rutas de nodo a nodo
     * @return Instancia de grafo
     */
    public synchronized static Grafo getInstance(List<NodoGrafo> nodos, List<Borde> conexiones) {
        if (Instance == null) {
            Instance = new Grafo(nodos, conexiones);
        }
        return Instance;

    }

    /**
     *
     * @return Instancia global de Grafo
     */
    public synchronized static Grafo getInstance() {
        if (Instance == null) {
            Instance = new Grafo();
        }
        return Instance;

    }

    /**
     * Agregar nodo a la lista
     *
     * @param nuevo El nodo a insertar
     */
    public void addNodo(NodoGrafo nuevo) {
        nodos.add(nuevo);
    }

    /**
     * Tomar las rutas más cercanas a nodos
     *
     * @param nodo El nodo del cual sacar rutas
     */
    public void getDijkstraPaths(NodoGrafo nodo) {
        dijkstra = new Dijkstra(this);
        dijkstra.buscarRutas(nodo);
    }

    /**
     * Devuelve la ruta más cercana del nodo fuente al nodo destino
     *
     * @param fuente Punto de salida
     * @param destino Punto de llegada
     * @return Lista de nodos por los cuales pasar para llegar (Ruta más corta)
     */
    public LinkedList<NodoGrafo> getPathFromAtoB(int fuente, int destino) {
        getDijkstraPaths(getNodo(fuente));
        return getPathTo(getNodo(destino));
    }

    /**
     * Devuelve el nodo en la lista de nodos del grafo
     *
     * @param indice para buscar en lista
     * @return El nodo buscado
     */
    public NodoGrafo getNodo(int indice) {

        return nodos.get(indice);

    }

    /**
     * Brinda posiciones aletorias a los nodos para poder pintarlos
     */
    public void crearPosicionesNodos() {
        int x =0, y =0;
        
        for (NodoGrafo nodo : nodos) 
        {
            do{
                x = random.nextInt(IConstants.panelWidth - IConstants.medidaNodo) + IConstants.medidaNodo;
                y = random.nextInt(IConstants.panelHeight - IConstants.altoSeparador - IConstants.medidaNodo)+ IConstants.altoSeparador - IConstants.medidaNodo;
            }while(inListaPuntos(x, y));
            
            nodo.setPosX(x);
            nodo.setPosY(y);
        }
    }

    private boolean inListaPuntos(int x, int y)
    {
        boolean encontrado = false;
        int medida = IConstants.medidaNodo;
        for (Point punto : puntosEnPantalla) 
        {
            if( ( punto.x + medida > x   &&   x >= punto.x - medida))
                encontrado = true;
            if( ( punto.y + medida > y  &&    y >= punto.y - medida))
                encontrado = true;
        }
        if(!encontrado)
        {
            puntosEnPantalla.add(new Point(x, y));
        }
        return encontrado;
    }
    
    /**
     * Saca ruta a destino
     *
     * @param destino Nodo al cual llegar
     * @return
     */
    public LinkedList<NodoGrafo> getPathTo(NodoGrafo destino) {
        return dijkstra.getRuta(destino);
    }

    /**
     * @param idCamino Identificacion de ruta
     * @param fuente Nodo Fuente
     * @param destino Nodo Destino
     * @param distancia Peso de la ruta
     */
    public void addBorde(String idCamino, int fuente, int destino, int distancia) {
        Borde ida = new Borde(idCamino, nodos.get(fuente), nodos.get(destino), distancia);
        Borde vuelta = new Borde(idCamino, nodos.get(destino), nodos.get(fuente), distancia);
        conexiones.add(ida);
        conexiones.add(vuelta);
    }

    /**
     *
     * @return Lista de nodos del grafo
     */
    public List<NodoGrafo> getNodos() {
        return nodos;
    }

    /**
     *
     * @return Lista de conexiones, puentes o arcos
     */
    public List<Borde> getConexiones() {
        return conexiones;
    }

    @Override
    public void addListener(InvalidationListener il) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListener(InvalidationListener il) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
