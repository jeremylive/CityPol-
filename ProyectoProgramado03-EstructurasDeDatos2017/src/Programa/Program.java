package Programa;

import Estructura.ThreeBB;
import GamePlay.Jugador;

/**
 *
 * @author live
 */
public class Program 
{
    //Variables globales
    //Clases a usar
    private CityPoli controlador1;
    private CityPoliTablero controlador2;
    //Constructor
    public Program()
    {
        this.controlador1 = new CityPoli();
        this.controlador2 = new CityPoliTablero();
    }
    //main
    public static void main(String[] args) 
    {
        
        Program p = new Program();
        
        ThreeBB t = p.controlador1.getControlador_login().getArbol_b_asterisco();
        
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
        
        t.add(j1);
        t.add(j2);
        t.add(j3);
        t.add(j4);
        
        t.getRaiz();
        String string = t.getString(t.getRaiz(), "", true);
        System.out.println(string);
    }
        
}
