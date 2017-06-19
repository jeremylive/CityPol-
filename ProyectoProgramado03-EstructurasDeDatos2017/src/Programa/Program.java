package Programa;

import Controlador.LoginManager;
import Estructura.ThreeBB;
import GamePlay.Jugador;
import Interfaz.Menu;
import Interfaz.Ventanas;
import Interfaz.VisualMap;
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
    private static Ventanas ventanas;
    private static VisualMap vMap;
    public static LoginManager login;

    public static void main(String[] args) throws IOException 
    {
        //Inicializo Constroladores principales del program CITYPOLI
        controlador1 = new CityPoli();
        controlador2 = null;
        
        //Incializo controlador principal
        login = controlador1.getControlador_login(controlador1, controlador2);
 
        //Inicializo las ventanas a usar
        ventanas = new Ventanas(controlador1, controlador2);
        
        //Hago la interfaz menu true
        ventanas.getMenu().setVisible(true);
    }
    
 
}

        /*



        //l1.EscribirArchivoSecuencial("jeremy",974);
        //l1.EscribirArchivoSecuencial("jeremy222",37);
        //Cargo el arbol asterisco
        //l1.leerArchivoSecuencial();
        //


        //Corre el b*
        //Prueba arbol b*
        ThreeBB b1 = l1.getArbol_b_asterisco();
      
 
        Jugador j1 = new Jugador();
        j1.setName("aJeremy");
        j1.setRanking(9.5);
        
        Jugador j2 = new Jugador();
        j2.setName("bEdgerik");
        j2.setRanking(8.5);
        
        Jugador j3 = new Jugador();
        j3.setName("cAlison");
        j3.setRanking(7.5);
        
        Jugador j4 = new Jugador();
        j4.setName("dMelanie");
        j4.setRanking(10.5);
        
        Jugador j5 = new Jugador();
        j5.setName("eBrayan");
        j5.setRanking(13.5);  
      
        Jugador j6 = new Jugador();
        j6.setName("fsimon");
        j6.setRanking(16.5);
        
        b1.add(j2);
        b1.add(j3);
        b1.add(j5);
        b1.add(j6);
        b1.add(j1);
        b1.add(j4);
       
            
        String a = b1.getString(b1.getRaiz(), "", true);
        System.out.println(a);
        //b1.inOrder(b1.getRaiz());
        
        */