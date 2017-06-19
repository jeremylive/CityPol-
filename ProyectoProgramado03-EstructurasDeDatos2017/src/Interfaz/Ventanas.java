package Interfaz;

import Controlador.LoginManager;
import Programa.CityPoli;
import Programa.CityPoliTablero;

/**
 *
 * @author live y edgerik
 */
public class Ventanas 
{
    //Variables globales
    private Menu menu;
    private Ranking ranking; 
    
    //Constructor
    public Ventanas(CityPoli cP, CityPoliTablero cP2)
    {
        //
        this.menu = new Menu(cP, cP2);
        this.ranking = new Ranking();
    }
    //gets and sets

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }
    
}
