package GamePlay;
//Bibliotecas a usar
import java.util.ArrayList;
/**
 *
 * @author live y edgerik
 */
public final class HttpPlaces 
{
    //Variables globales
    public ArrayList<Carta> mazoLugares;
    //Constructor
    public HttpPlaces()
    {
        this.mazoLugares = new ArrayList<>();
        addCarta("Costa Rica", 9.935949, -84.077431);
        addCarta("Francia", 48.8587737,2.3491262);
        addCarta("Tokio", 35.702820, 139.737846);
//        addCarta("Canada", 53.4514207,-77.3915374);
        addCarta("Londres", 51.5287718,-0.2417003);
        addCarta("Moscu",55.752175, 37.620053);
//        addCarta("Egipto", 30.045062, 31.235458);
        
    }
    /**
     * Inserto carta al mazo
     * @param nombre
     * @param lat
     * @param lng 
     */
    public void addCarta(String nombre, Double lat, Double lng)
    {
        mazoLugares.add(new Carta(nombre, lat, lng));
    }

    /**
     * Lista de cartas de lugar para el Gameplay
     * @return lista de Carta
     */
    public ArrayList<Carta> getMazoLugares() 
    {
        return mazoLugares;
    }
    
    /**
     * Busca en el mazo por nombre de lugar, 
     * @param lugar Nombre con el cual buscar
     * @return La carta encontrada o null si no se encontro
     */
    public Carta getCartaPorNombre(String lugar)
    {
        for (Carta carta : mazoLugares) 
        {
            if(carta.getNombreLugar().equals(lugar))
            {
                return carta;
            }
        }
        return null;
    }
}
