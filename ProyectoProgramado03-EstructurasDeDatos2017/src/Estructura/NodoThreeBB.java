package Estructura;
/*Librerias a usar*/
import GamePlay.Jugador;
import java.util.ArrayList;
/**
 *
 * @author live
 */
public class NodoThreeBB 
{
    //Variables Globales
    private ArrayList<NodoThreeBB> array_hijos;     //max 4 orden
    private ArrayList<Jugador> array_keys;          //max 3 keys
    private NodoThreeBB derecho;                    //Nodo adyasente
    private NodoThreeBB izquierdo;                  //Nodo adyasente
    private NodoThreeBB nodo_padre;                 //Nodo padre
    private int cant_keys;                          //Cant max 3
    //Constructor
    public NodoThreeBB()
    {
        this.array_hijos = new ArrayList();         //Inicializo hijos en null
        this.array_keys = new ArrayList();          //Inicializo keys(Jugador) en null
        this.izquierdo = null;                  //Inicializo null
        this.derecho = null;                  //Inicializo null
        this.nodo_padre = null;                     //Inicializo null
        this.cant_keys = 0;                         //Inicializo 0 la cant de key
    }
    //Gets and Sets
    public ArrayList<NodoThreeBB> getArray_hijos() {
        return array_hijos;
    }
    public void setArray_hijos(ArrayList<NodoThreeBB> array_hijos) {
        this.array_hijos = array_hijos;
    }
    public NodoThreeBB getIzquierdo() {
        return derecho;
    }
    public void setIzquierdo(NodoThreeBB nodo_hijo_izq) {
        this.derecho = nodo_hijo_izq;
    }
    public NodoThreeBB getDerecho() {
        return izquierdo;
    }
    public void setDerecho(NodoThreeBB nodo_der) {
        array_keys.set(0, nodo_padre.getArray_keys().get(nodo_padre.getArray_keys().size()-1));     
    }
    public NodoThreeBB getPadre()
    {
        return nodo_padre;
    }
    public void setPadre(NodoThreeBB pNodo)
    {
        nodo_padre = pNodo;
    }   
    public ArrayList<Jugador> getArray_keys() {
        return array_keys;
    }
    public void setArray_keys(Jugador array_keys) {
        this.array_keys.add(array_keys);
    }
    public int getCant_keys() {
        cant_keys = array_keys.size();
        return cant_keys;
    }
    public void setCant_keys(int cant_keys) {
        this.cant_keys = cant_keys;
    }
    public NodoThreeBB getHijo(int x)
    {
        //
        return array_hijos.get(x);
    }
    public Jugador getKey(int x)
    {
        //
        return array_keys.get(x);
    }
    //Funciones
    public void removeKey(Jugador key)
    {
        String name = key.getName();
        for (int i = 0; i < getCant_keys(); i++) {
            if(array_keys.get(i).getName().equals(key.getName()))
            {
                array_keys.remove(i);
            }
        }
    }
    public void remove(Jugador pJugador, int index)
    {
        for (int i = 0; i < getCant_keys(); i++) {
            array_keys.remove(i);    
        }
    }
    public int getCant_hijos()
    {
        return getArray_hijos().size();
    }
    public void addHijo(NodoThreeBB pJugador)
    {
        //
        array_hijos.add(pJugador);
    }
    public int addKey(Jugador pJugador)
    {
        //
        System.out.println(getCant_keys());
        boolean entry = false;
        boolean si = true;
        int i = -1;
        //
        for (i = 0; i < getCant_keys(); i++) {
            entry = true;
            //Caso cuando son iguales, retorna false
            if(array_keys.get(i).getName().equals(pJugador.getName()))
            {
                //No inserta
                System.out.println("No se ha agragado, está repetido");
                si = false;
                break;
            }
            //Comparo alfabeticamente alfabeticamente
            if(array_keys.get(i).getName().compareTo(pJugador.getName()) > 0)
            {
                //Inserto
                array_keys.add(i, pJugador);   
                si = false;
                break;
            } 
        }
        //Inserto  
        if(!entry || si){
            array_keys.add(pJugador); 
        }
        return i;
    }   
    public boolean removeChild(NodoThreeBB child) {
        boolean found = false;
        if (getCant_hijos() == 0)
            return found;
        for (int i = 0; i < getCant_hijos(); i++) {
            if (getArray_hijos().get(i).equals(child)) {
                found = true;
            } else if (found) {
                // shift the rest of the keys down
                //getArray_hijos().get(i - 1) = getArray_hijos().get(i);
                getArray_hijos().set(i-1, getArray_hijos().get(i));
            }
        }
        if (found) {
            setCant_keys(getCant_keys()-1);
            //getArray_hijos().get(getCant_hijos()) = null;
            getArray_hijos().set(getCant_hijos(),null);
        }
        return found;
    }
}
