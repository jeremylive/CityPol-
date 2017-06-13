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
    private List<NodoGrafo> nodos;
    private List<Borde> conexiones;
    private Dijkstra dijkstra;
    
    
    public Grafo() 
    {
        this.nodos = null;
        this.conexiones = null;
        this.dijkstra = new Dijkstra();
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
        dijkstra.buscarRutas(nodo);
    }
    
    /**
     * 
     * @param indice
     * @return El nodo buscado
     */
    public NodoGrafo getNodo(int indice){
        
        return nodos.get(indice);
        
    }
            
           
    
    /**
     * Saca ruta a destino
     * @param destino Nodo al cual llegar
     * @return 
     */
    public LinkedList<NodoGrafo> pathTo(NodoGrafo destino)
    {
        return dijkstra.getRuta(destino);
    }
    
    /**
     * @param idCamino      Identificacion de ruta
     * @param fuente      Nodo Fuente
     * @param destino     Nodo Destino
     * @param distancia   Peso de la ruta
     */
    public void addBorde(String idCamino, int fuente, int destino,int distancia) 
    {
        Borde ida = new Borde(idCamino,nodos.get(fuente), nodos.get(destino), distancia );
        Borde vuelta = new Borde (idCamino, nodos.get(destino),nodos.get(fuente),distancia);
        conexiones.add(ida);
        conexiones.add(vuelta);
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
