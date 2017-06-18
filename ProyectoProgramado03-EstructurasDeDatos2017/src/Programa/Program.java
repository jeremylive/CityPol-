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
        //Inserto, prueba
        l1.EscribirArchivoSecuencial("jeremy",974);
        l1.EscribirArchivoSecuencial("jeremy222",37);
        l1.leerArchivoSecuencial();
        


        //GAMEPLAY
        
        
    }
    
 
}
