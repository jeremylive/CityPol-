package Estructura;

import Programa.IConstants;
import java.awt.Point;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Random;
import javafx.beans.InvalidationListener;

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
public class Grafo extends Observable{

    private List<NodoGrafo> nodos;
    private List<Borde> conexiones;
    private Dijkstra dijkstra;
    private Random random;
    private ArrayList<Point> puntosEnPantalla;
    private ArrayList<Borde> rutaActualA;
    private ArrayList<Borde> rutaActualB;
    
    /**
     * Por si acaso
     */
    public Grafo() {
        this.nodos = new ArrayList<>();
        this.conexiones = new ArrayList<>();
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
     *
    public synchronized static Grafo getInstance(List<NodoGrafo> nodos, List<Borde> conexiones) {
        if (Instance == null) {
            Instance = new Grafo(nodos, conexiones);
        }
        return Instance;
    }
    
    public synchronized static Grafo cambiarInstancia(List<NodoGrafo> nodos, List<Borde> conexiones)
    {
        Instance = new Grafo(nodos, conexiones);
        return Instance;
    }

    /**
     *
     * @return Instancia global de Grafo
     *
    public synchronized static Grafo getInstance() {
        if (Instance == null) {
            Instance = new Grafo();
        }
        return Instance;

    }
*/
    /**
     * Agregar nodo a la lista
     *
     * @param nuevo El nodo a insertar
     */
    public void addNodo(NodoGrafo nuevo) 
    {
        nodos.add(nuevo);
    }

    /**
     * Tomar las rutas más cercanas a nodos
     *
     * @param nodo El nodo del cual sacar rutas
     */
    public void getDijkstraPaths(NodoGrafo nodo) 
    {
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
    public LinkedList<NodoGrafo> getPathFromAtoB(int fuente, int destino) 
    {
        getDijkstraPaths(getNodo(fuente));
        return getPathTo(getNodo(destino));
    }

    /**
     * Devuelve el nodo en la lista de nodos del grafo
     *
     * @param indice para buscar en lista
     * @return El nodo buscado
     */
    public NodoGrafo getNodo(int indice) 
    {
        return nodos.get(indice);
    }

    /**
     * Brinda posiciones aletorias a los nodos para poder pintarlos
     */
    public void crearPosicionesNodos() 
    {
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

    /**
     * Mide las distancias de nodo a nodo y crea conexiones entre ellos
     * dependiendo del la latitud y longitud del Lugar del Nodo
     */
    public void crearConexiones()
    {
        double distanciaX, distanciaY, hipotenusa;
        for (NodoGrafo origen : nodos) {
            NodoGrafo destino;
            for(int i = 0; i< IConstants.conexionesPorNodo;i++)
            {
                int ran = random.nextInt(nodos.size());
                destino = nodos.get(ran);
                distanciaX = getDistancia(origen.getLugar().getLatitud()    ,   destino.getLugar().getLatitud());
                distanciaY = getDistancia(origen.getLugar().getLongitud()   ,   destino.getLugar().getLongitud());
                distanciaX = Math.pow(distanciaX, 2);
                distanciaY = Math.pow(distanciaY, 2);
                hipotenusa = Math.sqrt(distanciaX + distanciaY);
                hipotenusa = hipotenusa * IConstants.escalaDistancia;
                DecimalFormat df2 = new DecimalFormat(".#");
                hipotenusa = Double.valueOf(df2.format(hipotenusa));
                addBorde("", origen , destino, hipotenusa);
            }
            
        }
    }
    
    /**
     * Saca la distancia de una coordenada
     * @param origen nodo inicio
     * @param destino nodo al cual llegar
     * @return la distancia de origen a destino
     */
    private double getDistancia(double origen, double destino)
    {
        double diferencia;
        
        if(origen < destino)
            diferencia = destino - origen;
        else
            diferencia = origen - destino;
        
        return diferencia;
    }
    
    /**
     * Dice si la posicion aleatoria dada es valida
     * @param x en pantalla
     * @param y en pantalla
     * @return true si el punto(x,y) es valido
     */
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
    public LinkedList<NodoGrafo> getPathTo(NodoGrafo destino) 
    {
        return dijkstra.getRuta(destino);
    }

    public void lightUpPath(NodoGrafo origen, NodoGrafo destino){
        
    }
    
    /**
     * @param idCamino Identificacion de ruta
     * @param fuente Nodo Fuente
     * @param destino Nodo Destino
     * @param distancia Peso de la ruta
     */
    public void addBorde(String idCamino, NodoGrafo fuente, NodoGrafo destino, double distancia) 
    {
        
        boolean existe = false;
        for (Borde conexion : conexiones) 
        {
            if( conexion.getOrigen().equals(fuente) && conexion.getDestino().equals(destino))
            {
                existe = true;
                break;
            }
        }
        if(!existe){
            Borde ida = new Borde(idCamino, fuente, destino, distancia);
            Borde vuelta = new Borde(idCamino, destino, fuente, distancia);

            conexiones.add(ida);
            conexiones.add(vuelta);
        }
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

    
}
