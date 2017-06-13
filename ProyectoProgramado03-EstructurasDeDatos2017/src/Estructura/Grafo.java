package Estructura;


import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author edgerik
 */
public class Grafo 
{
    private final List<NodoGrafo> nodos;
    private final List<Borde> conexiones;
    private Dijkstra dijkstra;
    
    
    public Grafo() 
    {
        this.nodos = null;
        this.conexiones = null;
        this.dijkstra = null;
    }
    
    /**
     * Constru del grafo
     * @param nodos Lista de nodos
     * @param conexiones Lista de arcos o bordes
     */
    public Grafo(List<NodoGrafo> nodos, List<Borde> conexiones)
    {
        this.nodos = nodos;
        this.conexiones = conexiones;
        this.dijkstra = new Dijkstra();
    }
    
    /**
     * Agregar nodo a la lista
     * @param nuevo El nodo a insertar
     */
    public void addNodo(NodoGrafo nuevo)
    {
        nodos.add(nuevo);
    }
    
    /** 
     * Tomar las rutas más cercanas a nodos
     * @param nodo El nodo del cual sacar rutas
     */
    public void getPaths(NodoGrafo nodo)
    {
        dijkstra = new Dijkstra(this);
        dijkstra.execute(nodo);
    }
    
    
    /**
     * Saca ruta a destino
     * @param destino Nodo al cual llegar
     * @return 
     */
    public LinkedList<NodoGrafo> pathTo(NodoGrafo destino)
    {
        return dijkstra.getPath(destino);
    }
    
    /**
     * @param laneId      Identificacion de ruta
     * @param sourceLocNo Nodo Fuente
     * @param destLocNo   Nodo Destino
     * @param duration    Peso de la ruta
     */
    public void addBorde(String laneId, int sourceLocNo, int destLocNo,int duration) 
    {
        Borde lane = new Borde(laneId,nodos.get(sourceLocNo), nodos.get(destLocNo), duration );
        conexiones.add(lane);
    }

    public List<NodoGrafo> getNodos() 
    {
        return nodos;
    }

    public List<Borde> getConexiones() 
    {
        return conexiones;
    }



    
}
