package GamePlay;

import java.util.Random;

/**
 *
 * @author live
 */
public class Dado 
{
    Random random;

    public Dado() {
        random = new Random();
    }
    
    public int throwDice()
    {
        return random.nextInt(6);
    }
    
}
