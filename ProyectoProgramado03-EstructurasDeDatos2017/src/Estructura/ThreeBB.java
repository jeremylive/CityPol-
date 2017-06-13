package Estructura;
/*Librerias a usar*/
import GamePlay.Jugador;
/**
 *
 * @author live y edgerik
 * 
 * Clase del arbol b* 
 */
public class ThreeBB 
{
    // Variables Globales
    private NodoThreeBB raiz;
    private final int orden;
    private final int max_keys;
    private final int min_keys;
    private int size;
    // Constructor
    public ThreeBB()
    {
        this.raiz = null;
        this.orden = 4;
        this.max_keys = 3;
        this.min_keys = 1;
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
        if (raiz == null) {
            raiz = new NodoThreeBB();
            raiz.addKey(pJugador);
        } else {
            NodoThreeBB nodo = raiz;
            while (nodo != null) {
                if (nodo.getCant_hijos() == 0) { //cant_keys
                    nodo.addKey(pJugador);
                    if (nodo.getCant_keys() <= max_keys) {
                        // A-OK
                        break;
                    }                         
                    // Need to split up
                    split(nodo);
                    break;
                }
                // Navigate

                // Lesser or equal
                Jugador lesser = nodo.getKey(0);
                if (pJugador.getName().compareTo(lesser.getName()) <= 0) {
                    nodo = nodo.getHijo(0);    
                    continue;
                }

                // Greater
                int numberOfKeys = nodo.getCant_keys(); //cant_keys
                int last = numberOfKeys - 1;
                Jugador greater = nodo.getKey(last);
                if (pJugador.getName().compareTo(greater.getName()) > 0) {
                    nodo = nodo.getHijo(numberOfKeys);
                    continue;
                }

                // Search internal nodes
                for (int i = 1; i < nodo.getCant_keys(); i++) {
                    Jugador prev = nodo.getKey(i - 1);
                    Jugador next = nodo.getKey(i);
                    if (pJugador.getName().compareTo(prev.getName()) > 0 && pJugador.getName().compareTo(next.getName()) <= 0) {
                        nodo = nodo.getHijo(i);
                        break;
                    }
                }
            }
        }

        size++;

        return true;
    }
    /**
     * 
     */
    private void split(NodoThreeBB nodeToSplit) 
    {
        NodoThreeBB node = nodeToSplit;
        int numberOfKeys = node.getCant_keys();
        int medianIndex = (2*numberOfKeys)/3;
        Jugador medianValue = node.getKey(medianIndex);

        NodoThreeBB left = new NodoThreeBB();
        for (int i = 0; i < medianIndex; i++) {
            left.addKey(node.getKey(i));
        }
        if (node.getCant_hijos() > 0) {
            for (int j = 0; j <= medianIndex; j++) {
                NodoThreeBB c = node.getHijo(j);
                left.addHijo(c);
            }
        }

        NodoThreeBB right = new NodoThreeBB();
        for (int i = medianIndex + 1; i < numberOfKeys; i++) {
            right.addKey(node.getKey(i));
        }
        if (node.getCant_hijos() > 0) {
            for (int j = medianIndex + 1; j < node.getCant_hijos(); j++) {
                NodoThreeBB c = node.getHijo(j);
                right.addHijo(c);
            }
        }

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
        } else {
            // Move the median value up to the parent
            NodoThreeBB parent = node.getPadre();
            parent.addKey(medianValue);
            parent.removeChild(node);
            parent.addHijo(left);
            parent.addHijo(right);

            if (parent.getCant_keys() > max_keys) split(parent);
        }
    }
    
    /**
     * 
     * @param node
     * @param prefix
     * @param isTail
     * @return 
     */
    public String getString(NodoThreeBB node, String prefix, boolean isTail) 
    {
        if (node == null){
            return "El arbol b* no tiene nodos";
        } else {
            System.out.println("Live");
            StringBuilder builder = new StringBuilder();

            builder.append(prefix).append((isTail ? "└── " : "├── "));
            System.out.println(node.getCant_keys());
            for (int i = 0; i < node.getCant_keys(); i++) {
                Jugador value = node.getKey(i);

                builder.append(value.getName());
                
                if (i < node.getCant_keys() - 1)
                    builder.append(", ");
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

