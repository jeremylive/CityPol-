/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

/**
 * Vertex
 * @author edgerik
 */
public class Borde  {
    private final String id;
    private final NodoGrafo source;
    private final NodoGrafo destination;
    private final int weight;
    public Borde(String id, NodoGrafo source, NodoGrafo destination, int weight) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }
    public NodoGrafo getDestination() {
        return destination;
    }

    public NodoGrafo getSource() {
        return source;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return source + " " + destination;
    }


}