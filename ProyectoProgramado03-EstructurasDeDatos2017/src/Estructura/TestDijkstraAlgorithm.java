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
import java.util.Random;

public class TestDijkstraAlgorithm {

    private static List<NodoGrafo> nodes;
    private static List<Borde> edges;
    
    public static void main(String[] args) 
    {
        Grafo nuevo = new Grafo();
        JsonManager jm = new JsonManager();
        jm.setGrafo(nuevo);
        //jm.getJSONFromAPI("restaurant",48.8587737,2.3491262);
        ArrayList<String> tipos = new ArrayList<>();
        tipos.add("park");
        tipos.add("museum");
        tipos.add("restaurant");
        tipos.add("cafe");
        tipos.add("church");
        jm.construirGrafo(tipos, 48.8587737,2.3491262);
        //jm.construirGrafo(tipos, 9.935949, -84.077431);
        
        
        
        GrafoGUI interfaz = new GrafoGUI();
        interfaz.update(nuevo);
        interfaz.setVisible(true);
        
        Grafo n = new Grafo();
        jm.setGrafo(n);
        jm.construirGrafo(tipos, 9.935949, -84.077431);
        
        interfaz.update(n);
        
    }

}
