package Controlador;
/*Librerias a usar*/
import Estructura.ThreeBB;
import GamePlay.Jugador;
import Interfaz.VisualMap;
import Programa.CityPoli;
import Programa.CityPoliTablero;
import Programa.IConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
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
    private FileOutputStream direccion2;
    private FileInputStream direccion;
    private String ruta;
    private String datos_ranking;
    //Clases a usar
    private ThreeBB arbol_b_asterisco;
    private VisualMap vMap;
    //Constructor
    public LoginManager() 
    {
        this.ruta = IConstants.ruta;
        try {
            this.direccion2 = new FileOutputStream(ruta, true);
            this.archivo2 = new DataOutputStream(direccion2);
            this.direccion = new FileInputStream(ruta);
            this.archivo = new DataInputStream(direccion);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.arbol_b_asterisco = new ThreeBB();
        this.name = "";
        this.estrellas = 0;
        this.datos_ranking = "";
    }
    //Gets and Sets
    
    public String getDatos_ranking() {
        return datos_ranking;
    }
    public void setDatos_ranking(String datos_ranking) {
        this.datos_ranking += datos_ranking;   
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
     * 
     */
    public void insertaNodosArbol() throws IOException
    {
        try{
            while(archivo.available() > 0){
                //Obtengo datos
                name = archivo.readUTF();
                estrellas = archivo.readInt();
                //Creo jugador
                Jugador pJugador = new Jugador(name, estrellas);
                //inserto al arbol
                arbol_b_asterisco.getRaiz().addKey(pJugador);
                //prueba
                System.out.println("nombre: "+name+"\nestrellas: "+estrellas);
            }       
        } 
            catch(FileNotFoundException fnfe) {}
	    catch (IOException ioe) {}
            archivo.close();
    }
    /**
     * LEER EL ARCHIVO SECUENCIAL, USA EL BARRIDO SECUENCIAL
     * 
     * @param ruta 
     */
    public String leerArchivoSecuencial() throws IOException
    {
        try{
            while(archivo.available() > 0){
                name = archivo.readUTF();
                estrellas = archivo.readInt();
                datos_ranking = "nombre: "+name+"\nestrellas: "+estrellas;
                System.out.println(datos_ranking);
                
            }       
        } 
            catch(FileNotFoundException fnfe) {}
	    catch (IOException ioe) {}
            archivo.close();
        
        return datos_ranking;
    }
    
    /**
     *  ESCRIBE EN EL ARCHIVO SECUENCIAL, EL NOMBER Y LAS ESTRELLAS
     * 
     * @param ruta 
     */
    public void EscribirArchivoSecuencial(String name, int estrellas)
    {
        try{
            
            archivo2.writeUTF(name);
            archivo2.writeInt(estrellas);
            //archivo2.close();
        }
            catch(FileNotFoundException fnfe) {}
            catch (IOException ioe) {}    
    }
   
    
    /**
     * Boton Registro
     * 
     */
    public void registroUser()
    {
        //Accion del boton
        //new Registro().setVisible(true);
        String name = JOptionPane.showInputDialog("Digite su nombre");
        String pasword = JOptionPane.showInputDialog("Digite su clave");

        //Creo perfil de jugador con sus datos
        Jugador nuevo_jugador = new Jugador(name, 0, pasword);

        //Insertar al archivo secuencial
        EscribirArchivoSecuencial(name, estrellas);

    }
    
    /**
     * START PROGRAM USER
     * @param pMap
     * @param cp
     * @throws java.io.IOException
     */
    public void empizaJuego(VisualMap pMap, CityPoliTablero cp) throws IOException
    {
        //Nueva partida
        //Autifico los usuarios
        String user1, user2, pass1, pass2;
        Jugador playerA, playerB;
        user1 = JOptionPane.showInputDialog("Digite su usuario Jugador 1");
        pass1 = JOptionPane.showInputDialog("Digite su clave Jugador 1");
        if(autetifico(user1, pass1)){
            pMap.setname1(user1);
            playerA = new Jugador(user1, 0);
            cp.setJugadorA(playerA);
            //Inserto al arbol el jugar creado
            getArbol_b_asterisco().add(playerA);
        }
        user2 = JOptionPane.showInputDialog("Digite su usuario Jugador 2");
        pass2 = JOptionPane.showInputDialog("Digite su clave Jugador 2");
        if(autetifico(user2, pass2)){
            pMap.setname2(user2);
            playerB = new Jugador(user2, 0);
            cp.setJugadorB(playerB);
            //Inserto al arbol el jugar creado
            getArbol_b_asterisco().add(playerB);
        }

        
        System.out.println("user1 "+user1+"\nuser2"+user2);
        //Obtengo controlador
        vMap = pMap;
    }

    /**
     * True si el user existe en el archivo secuencial
     * 
     * @param pName
     * @param pPass
     * @return 
     */
    public boolean autetifico(String pName, String pPass)     {
        boolean result = false;
        try{
            while(archivo.available() > 0){
                
                name = archivo.readUTF();
                estrellas = archivo.readInt();
                
                if(name ==pName){
                    //Si esta el nombre existe el user
                    Jugador player = new Jugador(name, estrellas);
                    result = true;
                    return result;
                }
                //datos_ranking = "nombre: "+name+"\nestrellas: "+estrellas;
                //System.out.println(datos_ranking);
               
            }       
        } 
            catch(FileNotFoundException fnfe) {}
	    catch (IOException ioe) {}
            try {
                archivo.close();
            } catch (IOException ex) {
                Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return result;
    }
    
    
    /**
     * Boton muestra ranking
     * 
     */
    public void botonRank() throws IOException
    {
        
        //
        //Cargo el nombre y ranking y los muestro 
        String ranking_total = leerArchivoSecuencial();
        vMap.getRank().getRanking().setText(ranking_total);
        
        
    }

    
    /**
     * 
     * 
     */
    public void precargoElArbol()
    {
        //Precargo el arbol, osea 
        
        
    }
    
}
