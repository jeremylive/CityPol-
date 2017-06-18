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
    private int size;               //Total de nodos
    private Jugador llave_menor;    //Obtengo el primer Jugador 
    private int llaves_totales;     //Cantidad total de keys
    private int index_final;        //Recorrido arbol
    private Jugador llave_mayor;    //Recorrido arbol
    private Jugador anterior;       //Recorrido arbol
    private Jugador siguiente;      //Recorrido arbol
    private Jugador player_aux;     //Recorrido arbol
    private int index_padre_remove; //Recorrido arbol  
    private NodoThreeBB nodo_auxiliar;//SPLIT
    private NodoThreeBB izquierdo;    //SPLIT
    private NodoThreeBB derecho;      //SPLIT
    private int indice_medio;         //SPLIT 
    private Jugador valor_medio;      //SPLIT
    private int total_hijos;          //SPLIT

    // Constructor
    public ThreeBB() {
        this.raiz = null;           //Inicializo nodo PADRE en null
        this.orden = 4;             //Inicializo orden en 4
        this.max_keys = 3;          //Inicializo max de KEYS en 3
        this.min_keys = 1;          //Inicializo min de KEYS en 1
        this.size = 0;              //Inicializo SIZE en 0
        this.llave_menor = new Jugador();
        this.llaves_totales = 0;
        this.index_final = 0;
        this.llave_mayor = new Jugador();
        this.anterior = new Jugador();
        this.siguiente = new Jugador();
        this.player_aux = new Jugador();
        this.index_padre_remove = 0;
        this.nodo_auxiliar = new NodoThreeBB();
        this.derecho = new NodoThreeBB();
        this.izquierdo = new NodoThreeBB();
        this.indice_medio = llaves_totales*IConstants.porcentaje_llenado;    //(2*llaves_totales)/3
        this.valor_medio = nodo_auxiliar.getKey(indice_medio);
        this.total_hijos = 0;
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
    /**
     * Inserto un Key(Jugador) en un array simpre alfabeticamente y efectuando los casos del arbol b asterisco
     * 
     * @param pJugador
     * @return TRUE si se inserto
     */
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
                llave_menor = nodo.getKey(0);           //Llave inicio
                llaves_totales = nodo.getCant_keys();   //Total de llaves
                index_final = llaves_totales - 1;       //Indice final
                llave_mayor = nodo.getKey(index_final); //Llave final
                
                //Caso si no tengo hijos
                if (nodo.getCant_hijos() == 0) {          
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
                if (pJugador.getName().compareTo(llave_menor.getName()) <= 0) {
                    nodo = nodo.getHijo(0);
                    continue;
                }

                //Mayores
                if (pJugador.getName().compareTo(llave_mayor.getName()) > 0) {
                    nodo = nodo.getHijo(llaves_totales);
                    continue;
                }

                //Busqueda interna de nodos
                for (int i = 1; i < nodo.getCant_keys(); i++) {
                    anterior = nodo.getKey(i - 1);
                    siguiente = nodo.getKey(i);
                    //Obtengo los nodos del arbol de izquierda a derecha
                    if (pJugador.getName().compareTo(anterior.getName()) > 0 && pJugador.getName().compareTo(siguiente.getName()) <= 0) {
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
     *  EQUILIBRIA EL ARBOL B ASTERISCO, SPLIT
     * 
     * @param nodeToSplit 
     */
    private void split(NodoThreeBB nodeToSplit) 
    {
        //Inicializo no auxiliar al nodo que se le hace el split
        nodo_auxiliar = nodeToSplit;
        //Inicializo el total de llaves
        llaves_totales = nodo_auxiliar.getCant_keys();
        total_hijos = nodo_auxiliar.getCant_hijos();
        //Inicializo el indice medio, osea 2/3* el total de llaves 
        indice_medio = llaves_totales*IConstants.porcentaje_llenado; //(2*llaves_totales)/3
        //Obtengo la pasicion media
        valor_medio = nodo_auxiliar.getKey(indice_medio);
        /*Divido el nodo en dos*/
        /*1*/
        //Insertar keys al nodo izquierdo en base al nodo aux, del 0 al indice intermedio
        for (int i = 0; i < indice_medio; i++) {
            izquierdo.addKey(nodo_auxiliar.getKey(i));
        }
        //Si el nodo tiene mas de 0 hijos, entra
        if (total_hijos > 0) {
            //Insertar nodos al nodo izquierdo en base al nodo aux, del 0 al indice intermedio
            for (int j = 0; j <= indice_medio; j++) {
                NodoThreeBB c = nodo_auxiliar.getHijo(j);   //Obtengo el hijo
                izquierdo.addHijo(c);   //Inserto el nodo al final del array hijos del nodo izquierdo 
            }
        }
        /*2*/
        //Inserto del indice intermedio al indice final en el nodo derecho
        for (int i = indice_medio + 1; i < llaves_totales; i++) {
            derecho.addKey(nodo_auxiliar.getKey(i));
        }
        //Si el nodo tiene mas de 0 hijos, entra
        if (total_hijos > 0) {
            //Insertar nodos al nodo derecho en base al nodo aux, del 0 al indice intermedio
            for (int j = indice_medio + 1; j < nodo_auxiliar.getCant_hijos(); j++) {
                NodoThreeBB c = nodo_auxiliar.getHijo(j);   //Obtengo el hijo
                derecho.addHijo(c);     //Inserto el nodo al final del array hijos del nodo derecho
            }
        }
        /*Caso cuando el padre es nulo*/
        if (nodo_auxiliar.getPadre() == null) 
        {
            //Nuevo nodo raiz es igual al nodo intermedio 
            NodoThreeBB newRoot = new NodoThreeBB();
            newRoot.addKey(valor_medio);
            nodo_auxiliar.setPadre(newRoot);        //seteo el nuevo padre
            raiz = newRoot;                         //actualizo raiz con padre
            nodo_auxiliar = raiz;                   //actualizo aux con raiz
            nodo_auxiliar.addHijo(izquierdo);       //Inserto al final de array
            nodo_auxiliar.addHijo(derecho);         //Inserto al final de array
        //Si padre no es nulo
        } else {
            //Nuevo nodo padre, lo inicializo al padre del aux
            NodoThreeBB parent = nodo_auxiliar.getPadre();
            
            parent.addKey(valor_medio);             //Inserto valor medio(Jugador)
            parent.removeChild(nodo_auxiliar);      //Elimino el nodo aux
            parent.addHijo(izquierdo);              //Inserto al final de array
            parent.addHijo(derecho);                //Inserto al final de array
            //Si nodo esta lleno(hijos = 4)
            if (parent.getCant_keys() > max_keys) {
                split(parent);                      //Realizo split nuevamente
            }
        }
    }

    //PRUEBA
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
}
