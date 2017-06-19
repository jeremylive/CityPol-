package Estructura;
/*Librerias a usar*/
import GamePlay.Jugador;
import java.util.ArrayList;
/**
 *
 * @author live y edgerik
 */
public class NodoThreeBB 
{
    //Variables Globales
    private ArrayList<NodoThreeBB> array_hijos;     //max 4 orden
    private ArrayList<Jugador> array_keys;          //max 3 keys
    private NodoThreeBB derecho;                    //Nodo adyasente
    private NodoThreeBB izquierdo;                  //Nodo adyasente
    private NodoThreeBB nodo_padre;                 //Nodo padre
    private int llaves_totales;                     //Cant max 3
    private boolean valido;                         
    private boolean inserte;                        
 
    //Constructor
    public NodoThreeBB()
    {
        this.array_hijos = new ArrayList();         //Inicializo hijos en null
        this.array_keys = new ArrayList();          //Inicializo keys(Jugador) en null
        this.izquierdo = null;                      //Inicializo null
        this.derecho = null;                        //Inicializo null
        this.nodo_padre = null;                     //Inicializo null
        this.llaves_totales = 0;                    //Inicializo 0 la cant de key
        this.valido = false;
        this.inserte = true;                        
        
    }
    //Gets and Sets
    public ArrayList<NodoThreeBB> getArray_hijos() {
        return array_hijos;
    }
    public void setArray_hijos(ArrayList<NodoThreeBB> array_hijos) {
        this.array_hijos = array_hijos;
    }
    public NodoThreeBB getIzquierdo() {
        return izquierdo;
    }
    public void setIzquierdo(NodoThreeBB nodo_hijo_izq) {
        this.derecho = nodo_hijo_izq;
    }
    public NodoThreeBB getDerecho() {
        return  derecho;
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
        llaves_totales = array_keys.size();
        return llaves_totales;
    }
    public void setCant_keys(int cant_keys) {
        this.llaves_totales = cant_keys;
    }
    //Funciones
    public NodoThreeBB getHijo(int x)
    {
        return array_hijos.get(x);
    }
    public Jugador getKey(int x)
    {
        return array_keys.get(x);
    }
    public void removeKey(Jugador key)
    {
        for (int i = 0; i < getCant_keys(); i++) {
            if(array_keys.get(i).getName().equals(key.getName()))
            {
                array_keys.remove(i-1);
            }
        }
    }
    public void remove(int index)
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
        array_hijos.add(pJugador);
    }
    /**
     * Agrega un Jugador al array de keys del nodo(ALFABETICAMENTE)
     * 
     * @param pJugador
     * @return EL INDICE DONDE FUE INSERTADO EL JUGADOR
     */
    public int addKey(Jugador pJugador)
    {
        //Inicializo variables
        valido = false;
        inserte = true;
        int i = -1;
        //Recorro las llaves
        for (i = 0; i < getCant_keys()-1; i++) {
            valido = true;
            //Caso cuando son iguales, retorna false
            if(array_keys.get(i).getName().equals(pJugador.getName()))
            {
                //No inserta
                System.out.println("No se ha agragado, está repetido");
                inserte = false;
                break;
            }
            //Comparo alfabeticamente, inserto derecha
            if(array_keys.get(i).getName().compareTo(pJugador.getName()) > 0)
            {
                //Inserto
                array_keys.add(i, pJugador);   
                inserte = false;
                break;
            } 
        }
        //Inserto izquierda
        if(!valido || inserte){
            array_keys.add(pJugador); 
        }
        //Retorno el indice
        return i;
    }   
    /**
     * Elimina nodo del arbol
     * 
     * @param child
     * @return TRUE si removio el hijo
     */
    public boolean removeChild(NodoThreeBB child) 
    {
        //Inicializo variable booleana
        valido = false;
        //Si el nodo no tiene hijos, retorno false
        if (getCant_hijos() == 0)
            return valido;
        //Recorro los hijos del nodo de izquierda a derecha
        for (int i = 0; i < getCant_hijos(); i++) {
            //Comparo si son iguales, retorno true
            if (getArray_hijos().get(i).equals(child)) {
                valido = true;

            //Roto el resto de las llaves hacia abajo
            } else if (valido) {
                getArray_hijos().set(i-1, getArray_hijos().get(i)); //(get,igualo)
            }
        }
        //
        if (valido) {
            setCant_keys(getCant_keys()-1);
            getArray_hijos().set(getCant_hijos(),null);   //(get,igualo)
        }
        //Retorno si se inserto o no
        return valido;
    }    
}


   /*
        if (nodo_auxiliar.getPadre() == null) 
        {
            //Nuevo nodo_auxiliar raiz es igual al nodo_auxiliar intermedio 
            nodo_padre = new NodoThreeBB();         //Creo nodo padre
            nodo_padre.addKey(valor_medio);         //Agrego el valor medio al nodo padre
            nodeToSplit.setPadre(nodo_padre);       //actual -> padre
            nodeToSplit.remove(indice_medio);       //Lo remuevo del original

            derecho = new NodoThreeBB();            //Creo nodo derecho                                       
            nodeToSplit.setDerecho(derecho);        //actual -> derecho
            derecho.setPadre(nodo_padre);           //derecho -> padre
            derecho.setIzquierdo(nodeToSplit);      //derecho -> izquierdo            
            derecho.getArray_keys().add(nodeToSplit.getArray_keys().get(indice_medio+1));//Agrego en el nodo de la derecha el ultimo key del nodo actual
            nodeToSplit.remove(indice_medio+1);       //Lo remuevo del original

            raiz = nodo_padre;                      //actualizo raiz con padre
            nodo_auxiliar = raiz;                   //actualizo aux con raiz
            
            nodo_auxiliar.addHijo(nodeToSplit);     //Inserto al final de array el nodo actual
            nodo_auxiliar.addHijo(derecho);         //Inserto al final de array el nodo derecho
*/