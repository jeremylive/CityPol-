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
    private final int max_keys;     //Max de KEYS q puede tener un nodo_auxiliar
    private final int min_keys;     //Min de KEYS q puede tener un nodo_auxiliar
    private int size;               //Total de nodos
    private Jugador llave_menor;    //Obtengo el primer Jugador 
    private int llaves_totales;     //Cantidad total de keys
    private int index_final;        //Recorrido arbol
    private Jugador llave_mayor;    //Recorrido arbol
    private Jugador anterior;       //Recorrido arbol
    private Jugador siguiente;      //Recorrido arbol
    private Jugador player_aux;     //Recorrido arbol
    private int index_padre_remove; //Recorrido arbol  
    private int largo;              //Recorrido arbol 
    private NodoThreeBB nodo_auxiliar;//SPLIT
    private NodoThreeBB izquierdo;    //SPLIT
    private NodoThreeBB derecho;      //SPLIT
    private NodoThreeBB nodo_padre;   //SPLIT
    private int indice_medio;         //SPLIT 
    private Jugador valor_medio;      //SPLIT
    private int total_hijos;          //SPLIT

    // Constructor
    public ThreeBB() {
        this.raiz = null;                       //Inicializo nodo_auxiliar PADRE en null
        this.orden = 4;                         //Inicializo orden en 4
        this.max_keys = 3;                      //Inicializo max de KEYS en 3
        this.min_keys = 1;                      //Inicializo min de KEYS en 1
        this.size = 0;                          //Inicializo SIZE en 0
        this.llave_menor = null;       
        this.llaves_totales = 0;                
        this.index_final = 0;
        this.llave_mayor = null;
        this.anterior = null;
        this.siguiente = null;
        this.player_aux = null;
        this.index_padre_remove = 0;
        this.largo = 0;
        this.nodo_auxiliar = null;
        this.derecho = null;
        this.izquierdo = null;
        this.nodo_padre = null;
        this.indice_medio = Math.round(llaves_totales*IConstants.porcentaje_llenado);    //(2*llaves_totales)/3
        this.valor_medio = null;
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
    /*FUNCIONES-----------------------------------------*/
    /**
     * 
     */
    public boolean logicaCasosArbolBB()
    {
        if(largo == max_keys+1) //largo==4
        {
            //Caso si el nodo adyasente es nulo
            if(nodo_auxiliar.getDerecho() != null)
            {
                //Caso derecho
                if(nodo_auxiliar.getDerecho().getCant_keys() < 4)
                {
                    //Inserto padre
                    player_aux = nodo_auxiliar.getPadre().getArray_keys().get(index_padre_remove+1);

                    //Remuevo la key final del nodo_auxiliar actual
                    nodo_auxiliar.remove(largo);

                    //Verifico que el key no sea nulo
                    if(player_aux != null)
                    {
                        //Inserto alfabeticamente en el array del nodo_auxiliar derecho
                        nodo_auxiliar.getDerecho().addKey(player_aux);
                        //Borro el key en padre
                        nodo_auxiliar.getPadre().removeKey(player_aux);
                    }     
                    return true;
                }
            }
            //Caso izquierdo
            if(nodo_auxiliar.getDerecho() != null)
            {
                if(nodo_auxiliar.getIzquierdo().getCant_keys() < 4)
                {
                    //Inserto padre
                    player_aux = nodo_auxiliar.getPadre().getArray_keys().get(index_padre_remove-1);

                    //Remuevo la key incio del nodo_auxiliar actual
                    nodo_auxiliar.remove(0);

                    //Verifico que el key no sea nulo
                    if(player_aux != null)
                    {
                        //Inserto alfabeticamente en el array del nodo_auxiliar derecho
                        nodo_auxiliar.getIzquierdo().addKey(player_aux);
                        //Borro el key en padre
                        nodo_auxiliar.getPadre().removeKey(player_aux);
                    } 
                    return true;
                } 
            }
        }
        return false;
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
            nodo_auxiliar = raiz;
            //Caso recursivo, sale hasta que inserta el nodo_auxiliar
            while (nodo_auxiliar != null) {
                //Inicializo variables
                llave_menor = nodo_auxiliar.getKey(0);           //Llave inicio
                llaves_totales = nodo_auxiliar.getCant_keys();   //Total de llaves
                index_final = llaves_totales - 1;       //Indice final
                llave_mayor = nodo_auxiliar.getKey(index_final); //Llave final
                //System.out.println(nodo_auxiliar.getPadre().getKey(0).getName());
                //System.out.println(nodo_auxiliar.getPadre().getKey(0).getRanking());
                //Caso si no tengo hijos
                if (nodo_auxiliar.getCant_hijos() == 0) {          
                    //Inserto alfabeticamente
                    nodo_auxiliar.addKey(pJugador);
                    //Caso base
                    if (nodo_auxiliar.getCant_keys() <= max_keys) { 
                        break;
                    }
                    //Caso cuando las keys son 4
                    largo = nodo_auxiliar.getCant_keys();
                    //Obtengo index de nodo_auxiliar insertado padre 
                    nodo_auxiliar.setPadre(new NodoThreeBB());
                    raiz = nodo_auxiliar.getPadre();
                    
                    index_padre_remove = nodo_auxiliar.getPadre().addKey(pJugador);
                    //Casos
                    if(!logicaCasosArbolBB())
                    {
                        //Equilibrio el Arbol
                        System.out.println("split.......");
                        split(nodo_auxiliar);
                        break;
                    }else{
                        break;
                    }
                    
                }
                
                //Menor o igual
                if (pJugador.getName().compareTo(llave_menor.getName()) <= 0) {
                    nodo_auxiliar = nodo_auxiliar.getHijo(0);
                    continue;
                }

                //Mayores
                if (pJugador.getName().compareTo(llave_mayor.getName()) > 0) {
                    nodo_auxiliar = nodo_auxiliar.getHijo(llaves_totales);
                    continue;
                }
                System.out.println(nodo_auxiliar.getCant_keys());
                //Busqueda interna de nodos
                for (int i = 1; i < nodo_auxiliar.getCant_keys(); i++) {
                    anterior = nodo_auxiliar.getKey(i - 1);
                    siguiente = nodo_auxiliar.getKey(i);
                    //Obtengo los nodos del arbol de izquierda a derecha
                    if (pJugador.getName().compareTo(anterior.getName()) > 0 && pJugador.getName().compareTo(siguiente.getName()) <= 0) {
                        nodo_auxiliar = nodo_auxiliar.getHijo(i);
                        break;
                    }
                }
            }
        }
        //Aumento el total de nodos 
        size++;
        //Retorna true, se inserto el nodo_auxiliar
        return true;
    }

    /**
     *  EQUILIBRIA EL ARBOL B ASTERISCO, SPLIT
     * 
     * @param nodeToSplit 
     */
    private void split(NodoThreeBB nodeToSplit) 
    {
        //Inicializo no auxiliar al nodo_auxiliar que se le hace el split
        nodo_auxiliar = nodeToSplit;
        //Inicializo el total de llaves
        llaves_totales = nodo_auxiliar.getCant_keys();
        total_hijos = nodo_auxiliar.getCant_hijos();
        //Inicializo el indice medio, osea 2/3* el total de llaves 
        indice_medio = Math.round(llaves_totales*IConstants.porcentaje_llenado); //(2*llaves_totales)/3
        //Obtengo la pasicion media
        valor_medio = nodo_auxiliar.getKey(indice_medio);
       
        /*Caso cuando el padre es nulo*/
        if (nodo_auxiliar.getPadre() == null) 
        {
            //Nuevo nodo_auxiliar raiz es igual al nodo_auxiliar intermedio 
            nodo_padre = new NodoThreeBB();         //Creo nodo padre
            nodo_padre.addKey(valor_medio);         //Agrego el valor medio
            nodeToSplit.setPadre(nodo_padre);       //seteo el nuevo padre
            
            raiz = nodo_padre;                      //actualizo raiz con padre
            nodo_auxiliar = raiz;                   //actualizo aux con raiz

            derecho = new NodoThreeBB();            //Creo nodo derecho                                       
            nodeToSplit.setDerecho(derecho);        //Seteo el nodo derecho  
            derecho.setPadre(nodo_padre);           //derecho -> padre
            derecho.setIzquierdo(nodeToSplit);      //derecho -> izquierdo
            System.out.println(indice_medio);
            derecho.getArray_keys().add(nodeToSplit.getArray_keys().get(indice_medio+1));//

            nodo_auxiliar.addHijo(nodeToSplit);     //Inserto al final de array el nodo actual
            nodo_auxiliar.addHijo(derecho);         //Inserto al final de array el nodo derecho
            
            /*
            izquierdo = new NodoThreeBB();          //Creo nodo izquierdo
            nodeToSplit.setIzquierdo(izquierdo);    //Seteo el nodo izquierdo
            izquierdo.setPadre(nodo_padre);         //izquierdo -> padre
            izquierdo.setDerecho(nodeToSplit);      //derecha -> izquierda
            for(int i=0; i<indice_medio; i++){      //Inserto las llaves correspondientes
                izquierdo.getArray_keys().add(nodeToSplit.getArray_keys().get(i));
            }
            nodo_auxiliar.addHijo(izquierdo);       //Inserto al final de array el nodo izquierdo
            */
        //Si padre no es nulo
        } else {
            /*
            nodo_padre = nodo_auxiliar.getPadre();      //Nuevo nodo_auxiliar padre, lo inicializo al padre del aux
            nodo_padre.addKey(valor_medio);             //Inserto valor medio(Jugador)  
            nodo_padre.removeChild(nodo_auxiliar);      //Elimino el nodo_auxiliar
            
            derecho = new NodoThreeBB();                //Creo nodo derecho                                       
            nodeToSplit.setDerecho(derecho);            //Seteo el nodo derecho
            derecho.setIzquierdo(nodeToSplit);          //derecho -> izquierdo
            derecho.setPadre(nodo_padre);               //derecho -> padre
            derecho.getArray_keys().add(nodeToSplit.getArray_keys().get(indice_medio+1));//Obtengo la key, para insertarla en un nodo
            nodo_padre.addHijo(derecho);                //Inserto al final de array
          
                
            nodo_padre.addHijo(izquierdo);              //Inserto al final de array
            */
            nodo_padre = new NodoThreeBB();
            nodeToSplit.setPadre(nodo_padre);       //seteo el nuevo padre
            
            logicaCasosArbolBB();
            if (nodo_padre.getCant_keys() > max_keys) { //Si nodo_auxiliar esta lleno(hijos = 4)
                split(nodo_padre);                      //Realizo split nuevamente
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


/*
        //Insertar keys al nodo_auxiliar izquierdo en base al nodo_auxiliar aux, del 0 al indice intermedio
        for (int i = 0; i < indice_medio; i++) {
            izquierdo.addKey(nodo_auxiliar.getKey(i));
        }
        //Si el nodo_auxiliar tiene mas de 0 hijos, entra
        if (total_hijos > 0) {
            //Insertar nodos al nodo_auxiliar izquierdo en base al nodo_auxiliar aux, del 0 al indice intermedio
            for (int j = 0; j <= indice_medio; j++) {
                NodoThreeBB c = nodo_auxiliar.getHijo(j);   //Obtengo el hijo
                izquierdo.addHijo(c);   //Inserto el nodo_auxiliar al final del array hijos del nodo_auxiliar izquierdo 
            }
        }
        
        //Inserto del indice intermedio al indice final en el nodo_auxiliar derecho
        for (int i = indice_medio + 1; i < llaves_totales; i++) {
            derecho.addKey(nodo_auxiliar.getKey(i));
        }
        //Si el nodo_auxiliar tiene mas de 0 hijos, entra
        if (total_hijos > 0) {
            //Insertar nodos al nodo_auxiliar derecho en base al nodo_auxiliar aux, del 0 al indice intermedio
            for (int j = indice_medio + 1; j < nodo_auxiliar.getCant_hijos(); j++) {
                NodoThreeBB c = nodo_auxiliar.getHijo(j);   //Obtengo el hijo
                derecho.addHijo(c);     //Inserto el nodo_auxiliar al final del array hijos del nodo_auxiliar derecho
            }
        }
        
*/