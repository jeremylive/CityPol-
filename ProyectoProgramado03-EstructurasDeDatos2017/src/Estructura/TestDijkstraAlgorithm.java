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
        Grafo.getInstance();
        JsonManager jm = new JsonManager();
        //jm.getJSONFromAPI("restaurant",48.8587737,2.3491262);
        jm.getJSONFromAPI("park", 9.935949, -84.077431);
        jm.getJSONFromAPI("restaurante", 9.935949, -84.077431);
        jm.getJSONFromAPI("museum", 9.935949, -84.077431);
        Grafo.getInstance().crearPosicionesNodos();
        
        
        GrafoGUI interfaz = new GrafoGUI();
        interfaz.setVisible(true);
    }

}
