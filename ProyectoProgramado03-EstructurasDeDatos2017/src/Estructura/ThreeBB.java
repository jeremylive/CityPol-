package Estructura;

/*Librerias a usar*/
import GamePlay.Jugador;

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
        this.indice_medio = 2;
        this.largo = 0;
        this.nodo_auxiliar = null;
        this.derecho = null;
        this.izquierdo = null;
        this.nodo_padre = null;
        //this.indice_medio = Math.round(llaves_totales*IConstants.porcentaje_llenado);    //(2*llaves_totales)/3
        this.valor_medio = null;
        this.total_hijos = 0;
    }
    // Gets and Sets    
    public int getTotal_hijos() {
        return total_hijos;
    }
    public void setTotal_hijos(int total_hijos) {
        this.total_hijos = total_hijos;
    }
    public Jugador getValor_medio() {
        return valor_medio;
    }
    public void setValor_medio(Jugador valor_medio) {
        this.valor_medio = valor_medio;
    }
    public Jugador getLlave_menor() {
        return llave_menor;
    }
    public void setLlave_menor(Jugador llave_menor) {
        this.llave_menor = llave_menor;
    }
    public int getLlaves_totales() {
        return llaves_totales;
    }
    public void setLlaves_totales(int llaves_totales) {
        this.llaves_totales = llaves_totales;
    }
    public Jugador getLlave_mayor() {
        return llave_mayor;
    }
    public void setLlave_mayor(Jugador llave_mayor) {
        this.llave_mayor = llave_mayor;
    }
    public int getIndice_medio() {
        return indice_medio;
    }
    public void setIndice_medio(int indice_medio) {
        this.indice_medio = indice_medio;
    }
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
    public boolean logicaCasosArbolBB(Jugador pJugador)
    {
        //Caso izquierdo
        if(nodo_auxiliar.getIzquierdo() != null &&  nodo_auxiliar.getDerecho() == null)
        {
            if(nodo_auxiliar.getIzquierdo().getCant_keys() < 4)
            {
                valor_medio = nodo_auxiliar.getKey(0);                          //Obtengo el jugador q se sube al padre
                
                nodo_padre.addKey(valor_medio);                                 //Agrego el jugador inicial del nodo actual al nodo padre
                
                nodo_auxiliar.remove(0);                                        //Elimino el jugador del nodo actual
                nodo_auxiliar.setPadre(nodo_padre);                             //actual -> padre
       
                index_padre_remove = nodo_auxiliar.getPadre().addKey(pJugador); //Obtengo index donde se inserto la key en el nodo padre 

                //Obtengo el jugador que se inserto en padre anteriormente
                player_aux = nodo_auxiliar.getPadre().getArray_keys().get(index_padre_remove-1);

                nodo_auxiliar.getPadre().remove(index_padre_remove-1);          //Remuevo el Jugador incio del nodo_auxiliar actual

                nodo_auxiliar.getIzquierdo().addKey(player_aux);                //Inserto en el nodo adyasente izquierdo el jugador
 
                nodo_auxiliar.getIzquierdo().setPadre(nodo_auxiliar.getPadre());//izq -> padre
                nodo_auxiliar.getIzquierdo().setDerecho(nodo_auxiliar);         //izq->actual
                nodo_auxiliar.setIzquierdo(nodo_auxiliar.getIzquierdo());       //actual->izq
                return true;
            } 
        }
        //Caso si el nodo adyasente es nulo
        if(nodo_auxiliar.getDerecho() != null && nodo_auxiliar.getIzquierdo() == null)
        {
            //Caso derecho
            if(nodo_auxiliar.getDerecho().getCant_keys() < 4)
            {
                valor_medio = nodo_auxiliar.getKey(nodo_auxiliar.getCant_keys()-1);//Obtengo el jugador q se sube al padre
                
                nodo_padre.addKey(valor_medio);                                 //Agrego el valor inicial al nodo padre
                
                nodo_auxiliar.remove(nodo_auxiliar.getCant_keys()-1);           //Elimino el jugador del nodo actual
                nodo_auxiliar.setPadre(nodo_padre);                             //actual -> padre
                
                index_padre_remove = nodo_auxiliar.getPadre().addKey(pJugador); //Obtengo index donde se inserto la key en el nodo padre 
                    
                //Obtengo el jugador que se inserto en padre anteriormente
                player_aux = nodo_auxiliar.getPadre().getArray_keys().get(index_padre_remove+1);

                nodo_auxiliar.getPadre().remove(index_padre_remove+1);          //Remuevo el Jugador incio del nodo_auxiliar actual

                nodo_auxiliar.getDerecho().addKey(player_aux);                  //Inserto en el nodo adyasente izquierdo el jugador
 
                nodo_auxiliar.getDerecho().setPadre(nodo_auxiliar.getPadre());  //der -> padre
                nodo_auxiliar.getDerecho().setIzquierdo(nodo_auxiliar);         //der->actual
                nodo_auxiliar.setIzquierdo(nodo_auxiliar.getDerecho());         //actual->der   
                return true;
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
                setLlave_menor(nodo_auxiliar.getKey(0));           //Llave inicio
                setLlaves_totales(nodo_auxiliar.getCant_keys());   //Total de llaves
                setLlave_mayor(nodo_auxiliar.getKey(index_final)); //Llave final
                
                //Caso si no tengo hijos
                if (nodo_auxiliar.getCant_hijos() == 0) {    
                    //Inserto alfabeticamente
                    nodo_auxiliar.addKey(pJugador);
                    
                    //Caso base, las keys menor o igual a 3
                    if (nodo_auxiliar.getCant_keys() <= max_keys) { 
                        break;
                    }
                    
                    //Caso cuando las keys son 4--------------------------------
                    //nodo_auxiliar.setPadre(new NodoThreeBB());  //Seteo el padre como un uevo nodo
                    //raiz = nodo_auxiliar.getPadre();            //raiz -> padre
                    
                    //Los 3 casos principales
                    if(!logicaCasosArbolBB(pJugador))   //!false
                    {
                        //Caso SPLIT, Equilibrio el Arbol
                        System.out.println("split.......");
                        split(nodo_auxiliar, pJugador);
                        break;
                    }else{
                        break;
                    }
                }
                //Busqueda en el arbol, alfabeticamente
                if (pJugador.getName().compareTo(llave_menor.getName()) <= 0) { //Busqueda, menores
                    nodo_auxiliar = nodo_auxiliar.getHijo(0);
                    continue;
                }
                if (pJugador.getName().compareTo(llave_mayor.getName()) > 0) {  //Busqueda, mayores
                    nodo_auxiliar = nodo_auxiliar.getHijo(llaves_totales);
                    continue;
                }
                for (int i = 1; i < nodo_auxiliar.getCant_keys(); i++) {        //Busqueda interna de nodos
                    anterior = nodo_auxiliar.getKey(i - 1);
                    siguiente = nodo_auxiliar.getKey(i);
                    //Obtengo el nodo donde se debe insertar alfabeticamente 
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
     * @param nodo_auxiliar 
     */
    private void split(NodoThreeBB pNodo, Jugador pJugador) 
    {
        nodo_auxiliar = pNodo;                                  //Inicializo no auxiliar al nodo_auxiliar que se le hace el split
        setLlaves_totales(nodo_auxiliar.getCant_keys());        //Inicializo el total de llaves
        setTotal_hijos(nodo_auxiliar.getCant_hijos());          //Inicializo el total de hijos
        setIndice_medio((2*llaves_totales) / 3);                //Inicializo el indice medio, osea 2/3* el total de llaves 
        setValor_medio(nodo_auxiliar.getKey(indice_medio));     //Obtengo la pasicion media
       
        /*Caso cuando el padre es nulo*/
        if (nodo_auxiliar.getPadre() == null) 
        {
            //Nuevo nodo_auxiliar raiz es igual al nodo_auxiliar intermedio 
            nodo_padre = new NodoThreeBB();           //Creo nodo padre
            nodo_padre.addKey(valor_medio);           //Agrego el valor medio al nodo padre
            pNodo.setPadre(nodo_padre);               //actual -> padre
            
            raiz.remove(indice_medio);               //Lo remuevo del original

            derecho = new NodoThreeBB();              //Creo nodo derecho                                       
            pNodo.setDerecho(derecho);                //actual -> derecho
            derecho.setIzquierdo(pNodo);              //derecho -> izquierdo(actual)            
            derecho.setPadre(nodo_padre);             //derecho -> padre

            derecho.getArray_keys().add(pNodo.getArray_keys().get(indice_medio-1));//Agrego en el nodo de la derecha el ultimo key del nodo actual
            raiz.remove(indice_medio+1);            //Lo remuevo del original

            raiz = nodo_padre;                      //actualizo raiz con padre
            nodo_auxiliar = raiz;                   //actualizo aux con raiz
            
            raiz.addHijo(pNodo);                //Inserto al final de array el nodo actual
            raiz.addHijo(derecho);             //Inserto al final de array el nodo derecho


        //Si padre no es nulo
        } else {
            nodo_padre = new NodoThreeBB();             //Creo nodo padre
            pNodo.setPadre(nodo_padre);                 //seteo el nuevo padre
   
            logicaCasosArbolBB(pJugador);                       //Logica de casos nodos adyasentes
   
            if (nodo_padre.getCant_keys() > max_keys) { //Si nodo_auxiliar esta lleno(hijos = 4)
                split(nodo_padre, pJugador);                      //Realizo split nuevamente
            }
        }        
    }

    //PRUEBA
    public String getString(NodoThreeBB node, String prefix, boolean isTail) 
    {
        if (node == null) {
            return "El arbol b* no tiene nodos";
        } else {
            
            StringBuilder builder = new StringBuilder();

            builder.append(prefix).append((isTail ? "└── " : "├── "));
            
            for (int i = 0; i < node.getCant_keys(); i++) {
            
                Jugador value = node.getKey(i);

                builder.append(value.getName());
                System.out.println(value.getName());
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




        Caso cuando los nodos adyasentes estan llenos
        if(nodo_auxiliar.getDerecho() != null || nodo_auxiliar.getIzquierdo() != null)
        {
            if(nodo_auxiliar.getDerecho().getCant_keys() > 3 || nodo_auxiliar.getIzquierdo().getCant_keys() > 3)
            {
                valor_medio = nodo_auxiliar.getKey(indice_medio);
                nodo_auxiliar.getPadre().addKey(valor_medio);

            }       
            return true;
        }
    





               //nodo_auxiliar.getPadre().getArray_hijos().get(index_padre_remove-1).addKey(player_aux);
  
    //
    public void recorroArbolBB()
    {
        if(raiz == null){
            //No tiene nodos
        } else {
            
        }
    }
    
    //Corrida en inorden
    int cont=-1;
    public void inOrder(NodoThreeBB nRaiz){
        cont++;
        if (nRaiz != null) {
            inOrder(nRaiz.getIzquierdo());
            System.out.print(nRaiz.getKey(cont-1).getName() + "\n");
            inOrder(nRaiz.getDerecho());
        }
    }



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

            /*
if
            izquierdo = new NodoThreeBB();          //Creo nodo izquierdo
            nodeToSplit.setIzquierdo(izquierdo);    //Seteo el nodo izquierdo
            izquierdo.setPadre(nodo_padre);         //izquierdo -> padre
            izquierdo.setDerecho(nodeToSplit);      //derecha -> izquierda
            for(int i=0; i<indice_medio; i++){      //Inserto las llaves correspondientes
                izquierdo.getArray_keys().add(nodeToSplit.getArray_keys().get(i));
            }
            nodo_auxiliar.addHijo(izquierdo);       //Inserto al final de array el nodo izquierdo
            */

            /*
else
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