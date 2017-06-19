package Controlador;
/*Librerias a usar*/
import Estructura.ThreeBB;
import GamePlay.Jugador;
import Interfaz.VisualGraphics;
import Programa.CityPoli;
import Programa.CityPoliTablero;
import Programa.IConstants;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author live y edgerik
 */
public class LoginManager 
{
    //Variables globales
    private DataInputStream archivo;
    private DataOutputStream archivo2;
    private String name;
    private int estrellas;
    private String password;
    private FileOutputStream direccion2;
    private FileInputStream direccion;
    private String ruta;
    private String user1, user2, pass1, pass2;
    private Jugador playerA, playerB, pJugador, nuevo_jugador;
    private int boton;
    private String pname, pasword;
    private int largo_bits;
    private String ranked;
    private ArrayList<Integer> datos_ranking;
    private ArrayList<String> datos_nombre;
    private ArrayList<String> datos_pass;
    //Clases a usar
    private ThreeBB arbol_b_asterisco;
    private VisualGraphics vMap;
    private CityPoliTablero controladorTablero;
    //Constructor
    public LoginManager() 
    {
        this.controladorTablero = null;
        this.vMap = null;
        this.ruta = IConstants.ruta;
        this.arbol_b_asterisco = new ThreeBB();
        this.name = "";
        this.estrellas = 0;
        this.password = "";
        this.boton = 0;
        this.direccion2 = null;
        this.archivo2 = null;
        this.direccion = null;
        this.archivo = null;
        this.ranked = "";
        this.datos_ranking = new ArrayList<>();
        this.datos_nombre = new ArrayList<>();
        this.datos_pass =  new ArrayList<>();
    }
    public LoginManager(CityPoli cP1,CityPoliTablero cP) 
    {
        this.controladorTablero = cP;
        this.vMap = cP1.getControl_visual_map();
        this.ruta = IConstants.ruta;
        this.arbol_b_asterisco = new ThreeBB();
        this.name = "";
        this.estrellas = 0;
        this.password = "";
        this.boton = 0;
        this.direccion2 = null;
        this.archivo2 = null;
        this.direccion = null;
        this.archivo = null;
        this.ranked = "";
        this.datos_ranking = new ArrayList<>();
        this.datos_nombre =  new ArrayList<>();
        this.datos_pass =  new ArrayList<>();
    }
    //Gets and Sets

    public String getRanked() {
        return ranked;
    }

    public void setRanked(String ranked) {
        this.ranked = ranked;
    }
    
    public ArrayList<String> getDatos_nombre() {
        return datos_nombre;
    }
    public void setDatos_nombre(String pdatos_nombre) {
        this.datos_nombre.add(pdatos_nombre);
    }
    public ArrayList<String> getDatos_pass() {
        return datos_pass;
    }
    public void setDatos_pass(String pdatos_pass) {
        this.datos_pass.add(pdatos_pass);
    }
    public int getLargoBits(){
        return largo_bits;
    }
    public int getBoton() {
        return boton;
    }
    public void setBoton(int boton) {
        this.boton = boton;
    }
    public String getUser1() {
        return user1;
    }
    public void setUser1(String user1) {
        this.user1 = user1;
    }
    public String getUser2() {
        return user2;
    }
    public void setUser2(String user2) {
        this.user2 = user2;
    }
    public String getPass1() {
        return pass1;
    }
    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }
    public String getPass2() {
        return pass2;
    }
    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }
    public Jugador getPlayerA() {
        return playerA;
    }
    public void setPlayerA(Jugador playerA) {
        this.playerA = playerA;
    }
    public Jugador getPlayerB() {
        return playerB;
    }
    public void setPlayerB(Jugador playerB) {
        this.playerB = playerB;
    }
    public VisualGraphics getvMap() {
        return vMap;
    }
    public void setvMap(VisualGraphics vMap) {
        this.vMap = vMap;
    }
    public CityPoliTablero getControladorTablero() {
        return controladorTablero;
    }
    public void setControladorTablero(CityPoliTablero controladorTablero) {
        this.controladorTablero = controladorTablero;
    }
    public ArrayList<Integer> getDatos_ranking() {
        return datos_ranking;
    }
    public void setDatos_ranking(int datos_ranking) {
        this.datos_ranking.add(datos_ranking);   
    }
    public String getName() {
        return name;
    }
    public int getEstrellas() {
        return estrellas;
    }
    public ThreeBB getArbol_b_asterisco() {
        return arbol_b_asterisco;
    }
    public void setArbol_b_asterisco(ThreeBB arbol_b_asterisco) {
        this.arbol_b_asterisco = arbol_b_asterisco;
    }
    //Funciones
    /**
     * Reconstruyo el arbol en base al archivo secuencial
     * 
     */
    public void reconstruyoArbol() 
    {
        try{
            System.out.println("Reconstruyo el arbol b asterisvo\n");
            direccion = new FileInputStream(ruta);
            archivo = new DataInputStream(direccion);
            largo_bits =  archivo.available();
            while(largo_bits > 0){
                //Obtengo datos
                name = archivo.readUTF();
                estrellas = archivo.readInt();
                password = archivo.readUTF();
                //Creo jugador  
                //System.out.println(name);
                pJugador = new Jugador(name, estrellas, password);
                //inserto al arbol, reconstruyo el arbol
                getArbol_b_asterisco().add(pJugador);
                //Inserto datos a usar mas adelante
                setDatos_nombre(name);
                setDatos_pass(password);
            }
            archivo.close();
        } 
            catch(FileNotFoundException fnfe) {}
	    catch (IOException ioe) {}
    }

    /**
     * LEER EL ARCHIVO SECUENCIAL, USA EL BARRIDO SECUENCIAL
     * 
     * @return  
     * @throws java.io.IOException 
     */
    public void leerArchivoSecuencial() 
    {
        //datos_nombre = null;
        //datos_pass = null;
        try{
            System.out.println("Leer archivo secuencial\n");
            direccion = new FileInputStream(ruta);
            archivo = new DataInputStream(direccion);
            largo_bits =  archivo.available();
            while(largo_bits > 0){
                name = archivo.readUTF();
                estrellas = archivo.readInt();
                password = archivo.readUTF();
                //System.out.println("n:"+name);
                ranked += "\n"+"nombre: "+name+" - estrellas: "+estrellas+" - Password: "+password;
                //setDatos_nombre(name);
                //setDatos_ranking(estrellas);
            }     
            
            archivo.close();
        } 
            catch(FileNotFoundException fnfe) {}
	    catch (IOException ioe) {}

    }
    
    /**
     *  ESCRIBE EN EL ARCHIVO SECUENCIAL, EL NOMBER Y LAS ESTRELLAS
     * 
     * @param name
     * @param estrellas
     * @param pass
     */
    public void EscribirArchivoSecuencial(String name, int estrellas, String pass)
    {
        try{
            System.out.println("Escirbo en el archivo secuencial\n");
            direccion2 = new FileOutputStream(ruta, true);
            archivo2 = new DataOutputStream(direccion2);
            archivo2.writeUTF(name);
            archivo2.writeInt(estrellas);
            archivo2.writeUTF(pass);
            archivo2.close();
        }
            catch(FileNotFoundException fnfe) {}
            catch (IOException ioe) {}    
    }
    
    /**
     * 
     */
    public void menu()
    {
        //precargo el arbol
        
        reconstruyoArbol();
        
        //String a = getArbol_b_asterisco().getString(getArbol_b_asterisco().getRaiz(), "", true);
        //System.out.println(a);
        if(getBoton() == 1)
        {
            registroUser();
        }else if(getBoton() == 2)
        {
            //Incio partida
            empizaJuego();
        }
    }
    
    /**
     * Boton Registro
     * 
     */
    public void registroUser()  
    {
        //Accion del boton    
        pname = JOptionPane.showInputDialog("Digite su nombre");
        pasword = JOptionPane.showInputDialog("Digite su clave");
        //Creo perfil de jugador con sus datos
        nuevo_jugador = new Jugador(pname, 0, pasword);
        //Inserto al arbol el jugar creado
        getArbol_b_asterisco().add(nuevo_jugador);
        //Insertar al archivo secuencial
        EscribirArchivoSecuencial(pname, 0, pasword);
    }
    
    /**
     * START PROGRAM USER
     * @param pMap
     * @param cp
     * @throws java.io.IOException
     */
    public void empizaJuego() 
    {
        //------------------------Nueva partida----------------------------
        boolean ciclo = false;
        boolean ciclo2 = false;
//        while(!(ciclo && ciclo2))
//        {
            //Pido Info
            pidoInfo();

            //Autifico los usuarios
            if(autetifico(getUser1(), getPass1())){   // Si existe, inserto Player al arbol
                
                playerA = new Jugador(getUser1(), 0, getPass1());
                ciclo = true;
            }

            if(autetifico(getUser2(), getPass2())){   // Si existe, inserto Player al arbol
                
                playerB = new Jugador(getUser2(), 0, getPass2());
                ciclo2 = true;
            } 
            
            if(!ciclo){
                JOptionPane.showMessageDialog(null, "No existe el perfil del jugador -> 1", "USUARIO INVALIDO", 2);
            }
            if(!ciclo2){
                JOptionPane.showMessageDialog(null, "No existe el perfil del jugador -> 2", "USUARIO INVALIDO", 2);
            }
//        }
        if(ciclo && ciclo2){
            JOptionPane.showMessageDialog(null, "FELICIDADES, ENTRASTE AL MUNDO DE CITYPOLI", "BIENVENIDO", 2);
            controladorTablero = new CityPoliTablero(playerA, playerB, this);
            controladorTablero.start();
        }
    }

    public void pidoInfo()
    {
        //Pido info
        user1 = JOptionPane.showInputDialog("Digite su usuario Jugador 1");
        pass1 = JOptionPane.showInputDialog("Digite su clave Jugador 1");
        user2 = JOptionPane.showInputDialog("Digite su usuario Jugador 2");
        pass2 = JOptionPane.showInputDialog("Digite su clave Jugador 2");
    }

    /**
     * True si el user existe en el archivo secuencial
     * 
     * @param pName
     * @param pPass
     * @return 
     */
    public boolean autetifico(String pName, String pPass)     
    {
        boolean result = false;
        int contador = -1;
        for (String pstring : getDatos_nombre()) {
            contador++;
            System.out.println(pstring);
            if(pstring.equals(pName)){
                System.out.println(getDatos_pass().get(contador));
                if(getDatos_pass().get(contador).equals(pPass)){
                    result = true;
                    return result;
                }
                
            }
        }
        return result;
    }
    
    /**
     * Boton muestra ranking
     * 
     * @return 
     * @throws java.io.IOException
     */
    public String botonR()
    {
        //Obtengo los nombres y las estrellas de todos los usuarios
        leerArchivoSecuencial();
        
        //Ordeno con el mergesort
        //ordenoMer();
       
        return getRanked();
    }
    
    /**
     * Funcion que ordena el String de nombres de todos los usuarios
     */
    public void ordenoMer()
    {
        String[] mersort = null;
        int contador = 0;
        for (String pStr : getDatos_nombre()) {
            mersort[contador] = pStr;
        }
        
        mergesort(mersort, 0, mersort.length-1);
    }
    
    /**
     * Algoritmos mersort, capaz de dividir el String entre dos, hasta
     * que no pueda mas y va ordenando cada uno hasta q sean de largo 1
     * y se van volviendo a unir, ya ordenados....
     */ 
     
    public void mergesort(String[] array_nombres,int izq, int der)
    {
        if(izq < der){
            int medio = (izq + der) / 2;
            mergesort(array_nombres, izq, medio);
            mergesort(array_nombres, medio+1, der);
            merge(array_nombres,izq,medio,der);
        }
        
    }
    
    public void merge(String[] array_nombres,int izq, int m, int der)
    {
        int i, j , k;
        String[] B = new String[array_nombres.length];
        for(i=izq; i<=der;i++){     //copia ambas mitades en el array auxiliar
            B[i] = array_nombres[i];
            
            i=izq; j=m+1; k=izq;
            while(i<=m && j<=der){  //Element max
                if(B[i].equals(B[j]))
                {
                    array_nombres[k++]=B[i++];
                }else
                {
                    array_nombres[k++]=B[j++];
                }
                while(i<=m){
                    array_nombres[k++] = B[i++];
                }
            }
        }
    }
}

/*




    public ArrayList<String> botonRankName() throws IOException
    {
        
        //Cargo el nombre y ranking y los muestro 
        //leerArchivoSecuencial();
        return getDatos_nombre();
    }  

    public ArrayList<Integer> botonRank() throws IOException
    {
        
        //Cargo el nombre y ranking y los muestro 
        //leerArchivoSecuencial();
        return getDatos_ranking();
    }  






        direccion2 = new FileOutputStream(ruta, true);
        archivo2 = new DataOutputStream(direccion2);
        direccion = new FileInputStream(ruta);
        archivo = new DataInputStream(direccion);
*/