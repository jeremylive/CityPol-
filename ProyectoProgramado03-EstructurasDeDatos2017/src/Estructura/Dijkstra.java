package Estructura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author edgerik
 */

public class Dijkstra 
{

    private List<NodoGrafo> nodos;
    private List<Borde> bordes;
    private Set<NodoGrafo> nodosListos;
    private Set<NodoGrafo> nodosNoListos;
    private Map<NodoGrafo, NodoGrafo> predecesores;
    private Map<NodoGrafo, Double> distancia;

    /**
     * Le pasa el grafo al dijkstra
     * @param graph El grafo a manejar
     */
    public Dijkstra(Grafo graph)
    {
        this.nodos = new ArrayList<>(graph.getNodos());
        this.bordes = new ArrayList<>(graph.getConexiones());
    }

    /**
     * Crea un dijkstra para luego darle el grafo y buscar rutas
     */
    public Dijkstra() 
    {    
        this.nodos = null;
        this.bordes = null;
    }

    /**
     * Busca rutas
     * @param origen Nodo del cual se empezará 
     */
    public void buscarRutas(NodoGrafo origen) 
    {
        nodosListos = new HashSet<>();
        nodosNoListos = new HashSet<>();
        distancia = new HashMap<>();
        predecesores = new HashMap<>();
        distancia.put(origen, 0.0);
        nodosNoListos.add(origen);
        while (nodosNoListos.size() > 0) {
            NodoGrafo nodo = getMinimo(nodosNoListos);
            nodosListos.add(nodo);
            nodosNoListos.remove(nodo);
            encontrarDistanciaMinima(nodo);
        }
    }

    /**
     * Busca en la lista de nodos adyacentes el nodo con la distancia minima
     * @param nodo Con el cual hacer el recorrido
     */
    private void encontrarDistanciaMinima(NodoGrafo nodo) 
    {
        List<NodoGrafo> adyacentes = (List<NodoGrafo>) getAdyacentes(nodo);
        //
        for (NodoGrafo objetivo : adyacentes) 
        {
            if (getDistanciaMasCorta(objetivo) > getDistanciaMasCorta(nodo) + getDistancia(nodo, objetivo)) 
            {
                distancia.put(objetivo, getDistanciaMasCorta(nodo) + getDistancia(nodo, objetivo));
                predecesores.put(objetivo, nodo);
                nodosNoListos.add(objetivo);
            }
        }

    }

    private double getDistancia(NodoGrafo origen, NodoGrafo objetivo)
    {
        for (Borde edge : bordes) 
        {
            if (edge.getOrigen().equals(origen) && edge.getDestino().equals(objetivo)) 
            {
                return edge.getDistancia();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<NodoGrafo> getAdyacentes(NodoGrafo nodo) 
    {
        List<NodoGrafo> neighbors = new ArrayList<>();
        for (Borde borde : bordes) 
        {
            if (borde.getOrigen().equals(nodo) && !estaListo(borde.getDestino())) 
            {
                neighbors.add(borde.getDestino());
            }
        }
        return neighbors;
    }

    /**
     * Busca en adyacentes el nodo mas cercano
     * @param bordes
     * @return El nodo más cercano
     */
    private NodoGrafo getMinimo(Set<NodoGrafo> bordes) 
    {
        NodoGrafo minimo = null;
        for (NodoGrafo borde : bordes) 
        {
            if (minimo == null) 
            {
                minimo = borde;
            } else {
                if (getDistanciaMasCorta(borde) < getDistanciaMasCorta(minimo)) 
                {
                    minimo = borde;
                }
            }
        }
        return minimo;
    }

    /**
     * Revisa si hay conexion
     * @param borde Busca la ruta
     * @return true si existe, false si no
     */
    private boolean estaListo(NodoGrafo borde) 
    {
        return nodosListos.contains(borde);
    }

    /**
     * Busca la distancia minima
     * @param destino
     * @return La distancia minima
     */
    private double getDistanciaMasCorta(NodoGrafo destino) 
    {
        Double d = distancia.get(destino);
        if (d == null) 
        {
            return Integer.MAX_VALUE;
        } else 
        {
            return d;
        }
    }

    /**
     * @param objetivo Al cual se requiere llegar
     * @return Ruta más corta al destino 
     */
    public LinkedList<NodoGrafo> getRuta(NodoGrafo objetivo) 
    {
        LinkedList<NodoGrafo> ruta = new LinkedList<>();
        NodoGrafo paso = objetivo;
        // Verifico si existe conexion
        if (predecesores.get(paso) == null) 
        {
            return null;
        }
        ruta.add(paso);
        //Añado los caminos más cortos desde el destino al origen
        while (predecesores.get(paso) != null) 
        {
            paso = predecesores.get(paso);
            ruta.add(paso);
        }
        // Le damos la vuelta para leerlo correctamente
        Collections.reverse(ruta);
        return ruta;
    }

}
