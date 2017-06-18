package Estructura;

/*Librerias a usar*/
import GamePlay.Jugador;
import Programa.IConstants;

/**
 *
 * @author live y edgerik
 *
 * Clase del arbol b*
 */
public class ThreeBB {

    // Variables Globales
    private NodoThreeBB raiz;       //Nodo PADRE
    private final int orden;        //Max de hijos q puede tener PADRE
    private final int max_keys;     //Max de KEYS q puede tener un nodo
    private final int min_keys;     //Min de KEYS q puede tener un nodo
    private int size;               //
    // Constructor

    public ThreeBB() {
        this.raiz = null;           //Inicializo nodo PADRE en null
        this.orden = 4;             //Inicializo orden en 4
        this.max_keys = 3;          //Inicializo max de KEYS en 3
        this.min_keys = 1;          //Inicializo min de KEYS en 1
        this.size = 0;              //Inicializo SIZE en 0
    }

    // Gets and Sets
    public NodoThreeBB getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoThreeBB raiz) {
        this.raiz = raiz;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // Funciones a usar en el arbol b*    
    public boolean add(Jugador pJugador) 
    {
        //Caso base, si no existe el arbol
        if (raiz == null) {
            raiz = new NodoThreeBB();
            raiz.addKey(pJugador);
        //Caso logica
        } else {
            //Creo auxiliar para hacer la corrida 
            NodoThreeBB nodo = raiz;
            //Caso recursivo, sale hasta que inserta el nodo
            while (nodo != null) {
                //Inicializo variables
                Jugador lesser = nodo.getKey(0);          //
                int numberOfKeys = nodo.getCant_keys();   //cant_keys
                int last = numberOfKeys - 1;              //
                Jugador greater = nodo.getKey(last);
                Jugador prev;
                Jugador next;
                
                int index_padre_remove;     
                Jugador player_aux;

                //
                if (nodo.getCant_hijos() == 0) {          //cant_keys
                    //Inserto alfabeticamente
                    nodo.addKey(pJugador);
                    //Caso base
                    if (nodo.getCant_keys() <= max_keys) { 
                        break;
                    }
                    //Caso cuando las keys son 4
                    int largo = nodo.getCant_keys();
                    if(largo == 4)
                    {
                        //Caso derecho
                        if(nodo.getDerecho().getCant_keys() < 4 && nodo.getDerecho() != null)
                        {
                            //Inserto padre
                            index_padre_remove = nodo.getPadre().addKey(pJugador);
                            player_aux = nodo.getPadre().getArray_keys().get(index_padre_remove+1);
                            
                            //Remuevo la key final del nodo actual
                            nodo.remove(largo);
                            
                            //Verifico que el key no sea nulo
                            if(player_aux != null)
                            {
                                //Inserto alfabeticamente en el array del nodo derecho
                                nodo.getDerecho().addKey(player_aux);
                                //Borro el key en padre
                                nodo.getPadre().removeKey(player_aux);
                            } 
                            break;
                        //Caso izquierdo     
                        }else if(nodo.getIzquierdo().getCant_keys() < 4 && nodo.getIzquierdo()!= null)
                        {
                            //Obtengo index de nodo insertado padre 
                            index_padre_remove = nodo.getPadre().addKey(pJugador);
                            //Inserto padre
                            player_aux = nodo.getPadre().getArray_keys().get(index_padre_remove-1);
                            
                            //Remuevo la key incio del nodo actual
                            nodo.remove(0);
                            
                            //Verifico que el key no sea nulo
                            if(player_aux != null)
                            {
                                //Inserto alfabeticamente en el array del nodo derecho
                                nodo.getIzquierdo().addKey(player_aux);
                                //Borro el key en padre
                                nodo.getPadre().removeKey(player_aux);
                            } 
                            break;
                        } 
                    }
                    //Equilibrio el Arbol
                    split(nodo);
                    break;
                }
                
                //Menor o igual
                if (pJugador.getName().compareTo(lesser.getName()) <= 0) {
                    nodo = nodo.getHijo(0);
                    continue;
                }

                //Mayores
                if (pJugador.getName().compareTo(greater.getName()) > 0) {
                    nodo = nodo.getHijo(numberOfKeys);
                    continue;
                }

                //Busqueda interna de nodos
                for (int i = 1; i < nodo.getCant_keys(); i++) {
                    prev = nodo.getKey(i - 1);
                    next = nodo.getKey(i);
                    //Obtengo los nodos del arbol de izquierda a derecha
                    if (pJugador.getName().compareTo(prev.getName()) > 0 && pJugador.getName().compareTo(next.getName()) <= 0) {
                        nodo = nodo.getHijo(i);
                        break;
                    }
                }
            }
        }
        //Aumento el total de nodos 
        size++;
        //Retorna true, se inserto el nodo
        return true;
    }

    /**
     *
     */
    private void split(NodoThreeBB nodeToSplit) {
        //
        NodoThreeBB node = nodeToSplit;
        NodoThreeBB left = new NodoThreeBB();
        NodoThreeBB right = new NodoThreeBB();
        int numberOfKeys = node.getCant_keys();
        int medianIndex = numberOfKeys*IConstants.porcentaje_llenado; //(2*numberOfKeys)/3
        Jugador medianValue = node.getKey(medianIndex);
        //
        for (int i = 0; i < medianIndex; i++) {
            left.addKey(node.getKey(i));
        }
        //
        if (node.getCant_hijos() > 0) {
            for (int j = 0; j <= medianIndex; j++) {
                NodoThreeBB c = node.getHijo(j);
                left.addHijo(c);
            }
        }
        //
        for (int i = medianIndex + 1; i < numberOfKeys; i++) {
            right.addKey(node.getKey(i));
        }
        //
        if (node.getCant_hijos() > 0) {
            for (int j = medianIndex + 1; j < node.getCant_hijos(); j++) {
                NodoThreeBB c = node.getHijo(j);
                right.addHijo(c);
            }
        }
        //
        if (node.getPadre() == null) {
            // new raiz, height of tree is increased
            NodoThreeBB newRoot = new NodoThreeBB();

            newRoot.addKey(medianValue);
            //node.parent = newRoot;
            node.setPadre(newRoot);
            raiz = newRoot;
            node = raiz;
            node.addHijo(left);
            node.addHijo(right);
        //
        } else {
            // Move the median value up to the parent
            NodoThreeBB parent = node.getPadre();
            
            parent.addKey(medianValue);
            parent.removeChild(node);
            parent.addHijo(left);
            parent.addHijo(right);
            //
            if (parent.getCant_keys() > max_keys) {
                split(parent);
            }
        }
    }

    /**
     *
     * @param node
     * @param prefix
     * @param isTail
     * @return
     */
    public String getString(NodoThreeBB node, String prefix, boolean isTail) {
        if (node == null) {
            return "El arbol b* no tiene nodos";
        } else {
            System.out.println("Live");
            StringBuilder builder = new StringBuilder();

            builder.append(prefix).append((isTail ? "└── " : "├── "));
            System.out.println(node.getCant_keys());
            for (int i = 0; i < node.getCant_keys(); i++) {
                Jugador value = node.getKey(i);

                builder.append(value.getName());

                if (i < node.getCant_keys() - 1) {
                    builder.append(", ");
                }
            }
            builder.append("\n");

            if (node.getArray_hijos() != null) {
                for (int i = 0; i < node.getCant_hijos() - 1; i++) {
                    NodoThreeBB obj = node.getHijo(i);
                    builder.append(getString(obj, prefix + (isTail ? "    " : "│   "), false));
                }
                if (node.getCant_hijos() >= 1) {
                    NodoThreeBB obj = node.getHijo(node.getCant_hijos() - 1);
                    builder.append(getString(obj, prefix + (isTail ? "    " : "│   "), true));
                }
            }
            return builder.toString();
        }
    }
    //...

}
