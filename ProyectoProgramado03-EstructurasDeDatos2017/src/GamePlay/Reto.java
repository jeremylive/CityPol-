package GamePlay;
/**
 *
 * @author live y edgerik
 */
public class Reto 
{
    //Variables globales
    public final String verbo;
    public int cantidad;
    public final String tipoLugar;
    //Constructor
    public Reto(String verbo, int cantidad, String tipoLugar) 
    {
        this.verbo = verbo;
        this.cantidad = cantidad;
        this.tipoLugar = tipoLugar;
    }
    
    @Override
    public String toString(){
        return verbo + 1 + " " + tipoLugar;
    }
}
