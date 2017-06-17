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
    private static CityPoli controlador1;
    private static CityPoliTablero controlador2;

    public static void main(String[] args) 
    {
        //Inicializo Constroladores principales del program CITYPOLI
        controlador1 = new CityPoli();
        controlador2 = new CityPoliTablero();
        
        //CARGA DEL ARBOL Y COMIENZO DE LOGIN
        ThreeBB arbol_asterico = controlador1.getArbolB();
        
        //GAMEPLAY
        
        
    }
        
}
