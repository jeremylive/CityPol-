package Interfaz;

import Estructura.Conexion;
import Estructura.Grafo;
import Estructura.NodoGrafo;
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
 * @author live
 */
public class VisualGraphics extends Thread {

    private Graphics panelDB, dbg;
    private Grafo controlador_grafo;
    private final VisualMap interfaz;
    private Image dbImage;
    private boolean terminar;

    public VisualGraphics(VisualMap mapa, Grafo controlador) {
        this.panelDB = mapa.getGraphics();
        interfaz = mapa;
        terminar = false;
        controlador_grafo = controlador;
    }

    public void setControlador_grafo(Grafo controlador_grafo) {
        this.controlador_grafo = controlador_grafo;
    }

    public void setPanelDB(Graphics panelDB) {
        this.panelDB = panelDB;
    }

    public boolean isTerminar() {
        return terminar;
    }

    public void setTerminar(boolean terminar) {
        this.terminar = terminar;
    }

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


    public void paintTablero(Graphics panel) {

        
        //Pintado del grafo
        //g.setColor(Color.GREEN);
        int medida = IConstants.medidaNodo / 2;
        int x, y;
        ArrayList<Conexion> conexiones;
        ArrayList<NodoGrafo> nodos;
        if (controlador_grafo != null) {
            conexiones = (ArrayList<Conexion>) controlador_grafo.getConexiones();
            try{
            if (conexiones != null) {
                for (Conexion conexion : conexiones) {
                    panel.setColor(Color.white);
                    NodoGrafo origen = conexion.getOrigen();
                    NodoGrafo destino = conexion.getDestino();
                    //Dibuja la linea de origen a destino
                    if(conexion.isIluminar()){
                        panel.setColor(Color.GREEN);
                    }
                    panel.drawLine(origen.getPosX() + medida, origen.getPosY() + medida, destino.getPosX() + medida, destino.getPosY() + medida);

                    x = getMid(origen.getPosX(), destino.getPosX());
                    y = getMid(origen.getPosY(), destino.getPosY());

                    //Pone el texto en medio del la linea con el peso correspondiente
                    panel.setColor(Color.black);
                    panel.drawString(Double.toString(conexion.getDistancia()), x, y);
                }
            }
            } catch (ConcurrentModificationException e) {
                System.out.println("Se ha cambiado el grafo  conexiones");
            }
            medida *= 2;
            try {
                nodos = (ArrayList<NodoGrafo>) controlador_grafo.getNodos();
                if (nodos != null) {
                    for (NodoGrafo nodo : nodos) {
                        //g.fillOval(nodo.getPosX(), nodo.getPosY(), medida * 5/4, medida);
                        panel.drawImage(nodo.getLugar().getFoto_lugar(), nodo.getPosX(), nodo.getPosY(), interfaz);

                        //g.setColor(Color.BLACK);
                        panel.drawString(nodo.getName(), nodo.getPosX() - (medida / 4), nodo.getPosY() - (medida - medida / 4));
                    }
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("Se ha cambiado el grafo nodos");
            }

        }

    }

    /**
     *
     */
    @Override
    public void run() {
        System.out.println("Comienza a pintar el grafo");
        while (!terminar) {
            interfaz.repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(VisualGraphics.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Termina de pintar");
    }
}
