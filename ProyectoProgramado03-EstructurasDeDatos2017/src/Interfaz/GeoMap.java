package Interfaz;

import Estructura.Conexion;
import Estructura.Grafo;
import Estructura.NodoGrafo;
import Programa.CityPoliTablero;
import Programa.IConstants;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author live y edgerik
 */
public class GeoMap extends Thread {

    //Variables globales
    private Grafo controlador_grafo;
    private final VisualGraphics interfaz;
    private boolean terminar;
    private CityPoliTablero tablero;

    //Constructor
    public GeoMap(VisualGraphics mapa, Grafo controlador, CityPoliTablero tablero) {
        this.interfaz = mapa;
        this.terminar = false;
        this.controlador_grafo = controlador;
        this.tablero = tablero;
    }

    //Sets and Get
    public void setControlador_grafo(Grafo controlador_grafo) {
        this.controlador_grafo = controlador_grafo;
    }

    public boolean isTerminar() {
        return terminar;
    }

    public void setTerminar(boolean terminar) {
        this.terminar = terminar;
    }

    //Funciones-----------------------------
    /**
     * Obtengo el pundo intermedio entre dos nodos
     *
     * @param origen
     * @param destino
     * @return
     */
    public int getMid(int origen, int destino) {
        int diferencia;
        if (origen < destino) {
            diferencia = destino - origen;
        } else {
            diferencia = origen - destino;
            origen = destino;
        }
        origen += diferencia / 2;
        return origen;
    }

    /**
     * Grafico el tablero
     *
     * @param panel
     */
    public void paintTablero(Graphics panel) {

        //Pintado del grafo
        //g.setColor(Color.GREEN);
        int medida = IConstants.medidaNodo / 2;
        int x, y;
        ArrayList<Conexion> conexiones;
        ArrayList<NodoGrafo> nodos;
        if (controlador_grafo != null) {
            conexiones = (ArrayList<Conexion>) controlador_grafo.getConexiones();
            try {
                if (conexiones != null) {
                    for (Conexion conexion : conexiones) {
                        panel.setColor(Color.white);
                        NodoGrafo origen = conexion.getOrigen();
                        NodoGrafo destino = conexion.getDestino();
                        //Dibuja la linea de origen a destino
                        if (tablero.isInRutaA(conexion)) {
                            panel.setColor(Color.GREEN);
                        }
                        if(tablero.isInRutaB(conexion)){
                            panel.setColor(Color.red);
                        }
                        if(tablero.isInRutaA(conexion) && tablero.isInRutaB(conexion)){
                            panel.setColor(Color.blue);
                        }
                        panel.drawLine(origen.getPosX() + medida, origen.getPosY() + medida, destino.getPosX() + medida, destino.getPosY() + medida);
                        
                        x = getMid(origen.getPosX(), destino.getPosX());
                        y = getMid(origen.getPosY(), destino.getPosY());

                        //Pone el texto en medio del la linea con el peso correspondiente
                        panel.drawString(Double.toString(conexion.getDistancia()), x, y);
                    }
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("Se ha cambiado el grafo  conexiones");
            }
            medida *= 2;
            try {
                nodos = (ArrayList<NodoGrafo>) controlador_grafo.getNodos();
                if (nodos != null) 
                {
                    for (NodoGrafo nodo : nodos) 
                    {
                        panel.drawImage(nodo.getLugar().getFoto_lugar(), nodo.getPosX(), nodo.getPosY(), interfaz);
                        if(nodo.equals(tablero.getPosA()))
                            panel.setColor(Color.green);
                        if(nodo.equals(tablero.getPosB()))
                            panel.setColor(Color.red);
                        
                        if(nodo.equals(tablero.getPosA())&& nodo.equals(tablero.getPosB()))
                            panel.setColor(Color.blue);
                        
                        if(nodo.equals(tablero.getPosA()) || nodo.equals(tablero.getPosB())) 
                            panel.fillOval(nodo.getPosX(), nodo.getPosY(), medida * 5/4 +20, medida+20);
                        
                        if(nodo.isIsProcesado())
                        {
                            panel.setColor(Color.PINK);
                            panel.fillOval(nodo.getPosX(), nodo.getPosY(), medida, medida);
                        }
                        panel.setColor(Color.BLACK);
                        
                        if(nodo.equals(tablero.getDestinoA())){
                            panel.setColor(Color.GREEN);
                        }
                        if(nodo.equals(tablero.getDestinoB())){
                            panel.setColor(Color.red);
                        }
                        if(nodo.equals(tablero.getDestinoA()) && nodo.equals(tablero.getDestinoB())){
                            panel.setColor(Color.GREEN);
                        }
                        panel.drawString(nodo.getName(), nodo.getPosX() - (medida / 4), nodo.getPosY() - (medida - medida / 4));
                    }
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("Se ha cambiado el grafo nodos");
            }
            
        }
    }

    /**
     * Corre hilo
     */
    @Override
    public void run() {
        System.out.println("Comienza a pintar el grafo");
        while (!terminar) {
            interfaz.paneDB();
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(GeoMap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Termina de pintar");
    }
}
