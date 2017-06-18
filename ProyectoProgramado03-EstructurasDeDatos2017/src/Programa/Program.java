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
        //Logica archivo secuencial
        //l1.EscribirArchivoSecuencial("jeremy",974);
        //l1.EscribirArchivoSecuencial("jeremy222",37);
        //Cargo el arbol asterisco
        //l1.leerArchivoSecuencial();
        //

        //Prueba arbol b*
        ThreeBB b1 = l1.getArbol_b_asterisco();
      
 
        Jugador j1 = new Jugador();
        j1.setName("Jeremy");
        j1.setRanking(9.5);
        
        Jugador j2 = new Jugador();
        j2.setName("Edgerik");
        j2.setRanking(8.5);
        
        Jugador j3 = new Jugador();
        j3.setName("Alison");
        j3.setRanking(7.5);
        
        Jugador j4 = new Jugador();
        j4.setName("Melanie");
        j4.setRanking(10.5);
        
        Jugador j5 = new Jugador();
        j5.setName("Brayan");
        j5.setRanking(13.5);  
      
        Jugador j6 = new Jugador();
        j6.setName("simon");
        j6.setRanking(16.5);
        
        b1.add(j1);
        b1.add(j2);
        b1.add(j3);
        b1.add(j4);
        b1.add(j6);
        
        String a = b1.getString(b1.getRaiz(), "", true);
        System.out.println(a);
        //b1.inOrder(b1.getRaiz());
        
        
        //GAMEPLAY
        controlador2.start();
        
    }
    
 
}
