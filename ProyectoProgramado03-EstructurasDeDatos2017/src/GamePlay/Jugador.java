package GamePlay;
/*Librerias a usar*/


/**
 *
 * @author live
 */
public class Jugador 
{
    //Variables Globales
    private String name;
    private double ranking;
    //Constructor
    public Jugador()
    {
        this.name = "";
        this.ranking = 0;
    }

    public Jugador(String name, double ranking) 
    {
        this.name = name;
        this.ranking = ranking;
    }
    
    //Gets and Sets
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
    
    public double getRanking() 
    {
        return ranking;
    }

    public void setRanking(double ranking) 
    {
        this.ranking = ranking;
    }

    //Funciones
    
    //...


}
