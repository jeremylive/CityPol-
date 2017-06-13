/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

/**
 * Borde, conexion, camino, vertice o como quiera llamarsele
 * @author edgerik
 */
public class Borde  {
    private final String id;
    private final NodoGrafo origen;
    private final NodoGrafo destino;
    private final int distancia;
    public Borde(String id, NodoGrafo source, NodoGrafo destination, int weight) {
        this.id = id;
        this.origen = source;
        this.destino = destination;
        this.distancia = weight;
    }

    public String getId() {
        return id;
    }
    public NodoGrafo getDestino() {
        return destino;
    }

    public NodoGrafo getOrigen() {
        return origen;
    }
    public int getDistancia() {
        return distancia;
    }

    @Override
    public String toString() {
        return origen.toString() + "--" + distancia + "-->" + destino.toString();
    }


}