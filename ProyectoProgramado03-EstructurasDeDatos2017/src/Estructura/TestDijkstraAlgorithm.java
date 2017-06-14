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
import Interfaz.GrafoGUI;
import java.util.ArrayList;
import java.util.List;

public class TestDijkstraAlgorithm {

    private static List<NodoGrafo> nodes;
    private static List<Borde> edges;

    public static void main(String[] args) 
    {
        
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        for (int i = 0; i < 5; i++) 
        {
            NodoGrafo location = new NodoGrafo("Id: " + i, "Node_" + i);
            nodes.add(location);
        }

        Grafo graph = Grafo.getInstance(nodes, edges);
        graph.addBorde("Conexion", 0, 1, 10);
        graph.addBorde("Conexion", 0, 2, 20);
        graph.addBorde("Conexion", 0, 4, 5);
        graph.addBorde("Conexion", 1, 2, 2);
        graph.addBorde("Conexion", 3, 1, 30);
        graph.addBorde("Conexion", 3, 4, 7);

        for (NodoGrafo nodo : graph.getPathFromAtoB(3, 2)) {
            System.out.println(nodo);
        }
        graph.crearPosicionesNodos();
        for (NodoGrafo n : graph.getNodos()) {
            System.out.println(n.getPosX()+ " , "+ n.getPosY());
        }
        
        GrafoGUI interfaz = new GrafoGUI();
        interfaz.setVisible(true);
        interfaz.repaint();
        

    }

}
