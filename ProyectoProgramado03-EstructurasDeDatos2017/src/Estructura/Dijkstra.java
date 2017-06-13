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

    private final List<NodoGrafo> nodes;
    private final List<Borde> edges;
    private Set<NodoGrafo> settledNodes;
    private Set<NodoGrafo> unSettledNodes;
    private Map<NodoGrafo, NodoGrafo> predecessors;
    private Map<NodoGrafo, Integer> distance;

    /**
     * Le pasa el grafo al dijkstra
     * @param graph El grafo a manejar
     */
    public Dijkstra(Grafo graph)
    {
        // create a copy of the array so that we can operate on this array
        this.nodes = new ArrayList<>(graph.getNodos());
        this.edges = new ArrayList<>(graph.getConexiones());
    }

    /**
     * Crea un dijkstra para luego darle el grafo y buscar rutas
     */
    public Dijkstra() 
    {    
        this.nodes = null;
        this.edges = null;
    }

    /**
     * Inserta el vertice(nodo)
     * @param source 
     */
    public void execute(NodoGrafo source) 
    {
        settledNodes = new HashSet<>();
        unSettledNodes = new HashSet<>();
        distance = new HashMap<>();
        predecessors = new HashMap<>();
        distance.put(source, 0);
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0) {
            NodoGrafo node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(NodoGrafo node) 
    {
        List<NodoGrafo> adjacentNodes = (List<NodoGrafo>) getNeighbors(node);
        for (NodoGrafo target : adjacentNodes) 
        {
            if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) 
            {
                distance.put(target, getShortestDistance(node) + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }

    }

    private int getDistance(NodoGrafo node, NodoGrafo target)
    {
        for (Borde edge : edges) 
        {
            if (edge.getSource().equals(node) && edge.getDestination().equals(target)) 
            {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<NodoGrafo> getNeighbors(NodoGrafo node) 
    {
        List<NodoGrafo> neighbors = new ArrayList<>();
        for (Borde edge : edges) 
        {
            if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) 
            {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private NodoGrafo getMinimum(Set<NodoGrafo> vertexes) 
    {
        NodoGrafo minimum = null;
        for (NodoGrafo vertex : vertexes) 
        {
            if (minimum == null) 
            {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) 
                {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(NodoGrafo vertex) 
    {
        return settledNodes.contains(vertex);
    }

    private int getShortestDistance(NodoGrafo destination) 
    {
        Integer d = distance.get(destination);
        if (d == null) 
        {
            return Integer.MAX_VALUE;
        } else 
        {
            return d;
        }
    }

    /*
     * This method returns the path from the source to the selected target and
     * NULL if no path exists
     */
    public LinkedList<NodoGrafo> getPath(NodoGrafo target) 
    {
        LinkedList<NodoGrafo> path = new LinkedList<>();
        NodoGrafo step = target;
        // check if a path exists
        if (predecessors.get(step) == null) 
        {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) 
        {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }

}
