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
        for (int i = 0; i < 11; i++) {
            NodoGrafo location = new NodoGrafo("Node_" + i, "Node_" + i);
            nodes.add(location);
        }

        addLane("Edge_0", 0, 1, 85);
        addLane("Edge_1", 0, 2, 217);
        addLane("Edge_2", 0, 4, 173);
        addLane("Edge_3", 2, 6, 186);
        addLane("Edge_4", 2, 7, 103);
        addLane("Edge_5", 3, 7, 183);
        addLane("Edge_6", 5, 8, 250);
        addLane("Edge_7", 8, 9, 84);
        addLane("Edge_8", 7, 9, 167);
        addLane("Edge_9", 4, 9, 502);
        addLane("Edge_10", 9, 10, 40);
        addLane("Edge_11", 1, 10, 600);

        // Lets check from location Loc_1 to Loc_10
        Grafo graph = new Grafo(nodes, edges);
        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.execute(nodes.get(0));
        LinkedList<NodoGrafo> path = dijkstra.getPath(nodes.get(10));

        try{
            for (NodoGrafo vertex : path) {
                System.out.println(vertex);
            }
        }catch(NullPointerException e)
        {
            System.out.println("No hay ruta");
        }

    }

    private static void addLane(String laneId, int sourceLocNo, int destLocNo,int duration) 
    {
        Borde lane = new Borde(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration );
        edges.add(lane);
    }
    

}

