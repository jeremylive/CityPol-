package GamePlay;

import Programa.IConstants;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author live
 */
public class Retos 
{
    private final ArrayList<Reto> retos;
    private final String[] verbos={"Visit ","Go to ", "Pass around ", "Enjoy the view at ", "Chill... at "};
    private final Random r;
    
    public Retos(){
        r = new Random();
        retos = new ArrayList<>();
        for(int i = 0; i< 3 ; i++)
        {
            retos.add( new Reto(verbos[r.nextInt(verbos.length-1)],r.nextInt(1),IConstants.tipos[r.nextInt(IConstants.tipos.length-1)]) );
        }
    }

    public ArrayList<Reto> getRetos() {
        return retos;
    }
    
}
