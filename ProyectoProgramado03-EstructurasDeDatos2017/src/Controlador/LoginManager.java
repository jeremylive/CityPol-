package Controlador;
/*Librerias a usar*/
import Estructura.ThreeBB;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
    //Clases a usar
    private ThreeBB arbol_b_asterisco;
    //Constructor
    public LoginManager()
    {
        this.archivo = null;
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
    public void leerArchivoSecuencial(String ruta) throws IOException
    {
        try{
            archivo = new DataInputStream(new FileInputStream(ruta));
            while(archivo.available() >= 0){
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
    public void EscribirArchivoSecuencial(String ruta, String name, int estrellas)
    {
        try{
            archivo2 = new DataOutputStream(new FileOutputStream(ruta));
            archivo2.writeUTF(name);
            archivo2.writeInt(estrellas);
            archivo2.close();
        }
            catch(FileNotFoundException fnfe) {}
            catch (IOException ioe) {}    
    }
}
