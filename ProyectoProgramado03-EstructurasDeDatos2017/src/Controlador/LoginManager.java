package Controlador;
/*Librerias a usar*/
import Estructura.ThreeBB;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    //Clases a usar
    private ThreeBB arbol_b_asterisco;
    //Constructor
    public LoginManager() 
    {
        this.ruta = "C:\\Users\\Usuario1\\Desktop\\GitHub\\CityPol-\\ProyectoProgramado03-EstructurasDeDatos2017\\src\\GamePlay\\perfiles.as";
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
    }
    //Gets and Sets

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
     * LEER EL ARCHIVO SECUENCIAL, USA EL BARRIDO SECUENCIAL
     * 
     * @param ruta 
     */
    public void leerArchivoSecuencial() throws IOException
    {
        try{
            while(archivo.available() > 0){
                name = archivo.readUTF();
                estrellas = archivo.readInt();
                System.out.println("nombre: "+name+"\nestrellas: "+estrellas);

            }       
        } 
            catch(FileNotFoundException fnfe) {}
	    catch (IOException ioe) {}
            archivo.close();
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
}
