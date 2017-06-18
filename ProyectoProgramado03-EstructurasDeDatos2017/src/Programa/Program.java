package Programa;

import Controlador.LoginManager;
import Estructura.ThreeBB;
import GamePlay.Jugador;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author live y edgerik
 */
public class Program 
{
    //Variables globales

    //Clases a usar
    private static CityPoli controlador1;
    private static CityPoliTablero controlador2;

    public static void main(String[] args) throws IOException 
    {
        //Inicializo Constroladores principales del program CITYPOLI
        controlador1 = new CityPoli();
        controlador2 = new CityPoliTablero();
        
        //Pueba escrivo en el archivo
        
        
        //PRECARGiO EL ARBOL Y COMIENZO EL LOGIN
        //ThreeBB arbol_asterico = controlador1.getArbolB();
        LoginManager l1 = controlador1.getControlador_login();
        l1.EscribirArchivoSecuencial("C:\\Users\\Usuario1\\Desktop\\GitHub\\CityPol-\\ProyectoProgramado03-EstructurasDeDatos2017\\src\\GamePlay\\perfiles.as", "jeremy",999);
        l1.EscribirArchivoSecuencial("C:\\Users\\Usuario1\\Desktop\\GitHub\\CityPol-\\ProyectoProgramado03-EstructurasDeDatos2017\\src\\GamePlay\\perfiles.as", "jeremy222",33);
        l1.leerArchivoSecuencial("C:\\Users\\Usuario1\\Desktop\\GitHub\\CityPol-\\ProyectoProgramado03-EstructurasDeDatos2017\\src\\GamePlay\\perfiles.as");
        


        //GAMEPLAY
        
        
    }
    
 
}
