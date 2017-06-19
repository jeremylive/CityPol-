package Estructura;

/**
 * Borde, conexion, camino, vertice o como quiera llamarsele
 * 
 * @author live y edgerik
 */
public class Conexion  
{
    //Variables globales
    private final String id;
    private final NodoGrafo origen;
    private final NodoGrafo destino;
    private final double distancia;
    private boolean iluminarA, iluminarB;
    //Constructor
    public Conexion(String id, NodoGrafo source, NodoGrafo destination, double weight) {
        this.id = id;
        this.origen = source;
        this.destino = destination;
        this.distancia = weight;
    }
    //Gets and sets
    public String getId() {
        return id;
    }
    public NodoGrafo getDestino() {
        return destino;
    }
    public boolean isIluminarA() {
        return iluminarA;
    }
    public void setIluminarA(boolean iluminar) {
        this.iluminarA = iluminar;
        
    }

    public boolean isIluminarB() {
        return iluminarB;
    }

    public void setIluminarB(boolean iluminarB) {
        this.iluminarB = iluminarB;
    }
    
    public NodoGrafo getOrigen() {
        return origen;
    }
    public double getDistancia() {
        return distancia;
    }
    @Override
    public String toString() {
        return origen.toString() + "--" + distancia + "-->" + destino.toString();
    }
}