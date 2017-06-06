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
    private ArrayList<NodoThreeBB> array_hijos;
    private ArrayList<Jugador> array_keys;
    private NodoThreeBB nodo_hijo_izq;
    private NodoThreeBB nodo_hijo_der;
    private NodoThreeBB nodo_padre;
    private int cant_keys;
    //Constructor
    public NodoThreeBB()
    {
        this.array_hijos = new ArrayList();
        this.array_keys = new ArrayList();
        this.nodo_hijo_der = null;
        this.nodo_hijo_izq = null;
        this.nodo_padre = null;
        this.cant_keys = 0;
    }
    //Gets and Sets
    public ArrayList<NodoThreeBB> getArray_hijos() {
        return array_hijos;
    }

    public void setArray_hijos(ArrayList<NodoThreeBB> array_hijos) {
        this.array_hijos = array_hijos;
    }

    public NodoThreeBB getNodo_hijo_izq() {
        return nodo_hijo_izq;
    }

    public void setNodo_hijo_izq(NodoThreeBB nodo_hijo_izq) {
        this.nodo_hijo_izq = nodo_hijo_izq;
    }

    public NodoThreeBB getNodo_hijo_der() {
        return nodo_hijo_der;
    }

    public void setNodo_hijo_der(NodoThreeBB nodo_hijo_der) {
        this.nodo_hijo_der = nodo_hijo_der;
    }

    public NodoThreeBB getPadre()
    {
        return nodo_padre;
    }
    
    public void setPadre(NodoThreeBB pNodo)
    {
        nodo_padre = pNodo;
    }
        
    public int getArray_keys() {
        return array_keys.size();
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
    public int getCant_hijos()
    {
        return getArray_hijos().size();
    }
    
    public void addHijo(NodoThreeBB pJugador)
    {
        //
        array_hijos.add(pJugador);
    }
    
    public void addKey(Jugador pJugador)
    {
        //
        System.out.println(getCant_keys());
        boolean entry = false;
        for (int i = 0; i < getCant_keys(); i++) {
            entry = true;
            if(array_keys.get(i).getName().compareTo(pJugador.getName()) < 0)
            {
                array_keys.add(i, pJugador);                
                break;
            } 
        }
        if(!entry){
            array_keys.add(pJugador); 
        }
        //System.out.println(array_keys.size());
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
    

    //....


}
