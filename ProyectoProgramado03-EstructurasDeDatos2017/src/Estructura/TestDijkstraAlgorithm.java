/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

/**
 *
 * @author edgerik
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestDijkstraAlgorithm {
    
    private static List<NodoGrafo> nodes;
    private static List<Borde> edges;
    
    public static void main(String[] args) {
        
        nodes = new ArrayList<>();
        
        edges = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            NodoGrafo location = new NodoGrafo("Id: " + i, "Node_" + i);
            nodes.add(location);
        }

        Grafo graph = new Grafo(nodes, edges);
        graph.addBorde("Conexion", 0, 1, 10);
        graph.addBorde("Conexion", 0, 2, 20);
        graph.addBorde("Conexion", 0, 4, 5);
        graph.addBorde("Conexion", 1, 2, 2);
        graph.addBorde("Conexion", 3, 1, 30);
        graph.addBorde("Conexion", 3, 4, 7);
        
        ;
        System.out.println("Del nodo 4 al 1");
        try{
            for (NodoGrafo vertex : graph.getPathFromAtoB(4, 1)) {
                System.out.println(vertex);
            }
        }catch(NullPointerException e)
        {
            System.out.println("No hay ruta");
        }
        System.out.println("Del nodo 3 al 2");
        
        
        try{
            for (NodoGrafo vertex : graph.getPathFromAtoB(3, 0)) {
                System.out.println(vertex);
            }
        }catch(NullPointerException e)
        {
            System.out.println("No hay ruta");
        }

    }

 

}

