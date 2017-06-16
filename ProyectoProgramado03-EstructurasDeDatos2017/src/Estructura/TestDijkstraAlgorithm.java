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
import Controlador.JsonManager;
import Interfaz.GrafoGUI;
import Programa.IConstants;
import java.util.ArrayList;
import java.util.List;

public class TestDijkstraAlgorithm {

    private static List<NodoGrafo> nodes;
    private static List<Borde> edges;

    public static void main(String[] args) 
    {
        
        nodes = new ArrayList<>();
    for (int i = 0; i < 10; i++) 
        {
            NodoGrafo location = new NodoGrafo("" + i, "N"+i);
            nodes.add(location);
        }

        
        edges = new ArrayList<>();
        Grafo graph = Grafo.getInstance(nodes, edges);
        graph.addBorde("Conexion", 0, 1, 10);
        graph.addBorde("Conexion", 0, 2, 20);
        graph.addBorde("Conexion", 0, 4, 5);
        graph.addBorde("Conexion", 1, 2, 2);
        graph.addBorde("Conexion", 3, 1, 30);
        graph.addBorde("Conexion", 3, 4, 7);
        graph.addBorde("", 9, 8, 49);
        graph.addBorde("", 0, 7, 6);
        graph.addBorde("", 6, 5, 30);
        graph.addBorde("", 5, 9, 40);

        for (NodoGrafo nodo : graph.getPathFromAtoB(3, 2)) {
            System.out.println(nodo);
        }
        graph.crearPosicionesNodos();
        for (NodoGrafo n : graph.getNodos()) {
            System.out.println(n.getPosX()+ " , "+ n.getPosY());
        }
        
//        GrafoGUI interfaz = new GrafoGUI();
//        interfaz.setVisible(true);
//        
        JsonManager jm = new JsonManager();
        jm.getJSONFromAPI(IConstants.APIRequest);

    }

}
