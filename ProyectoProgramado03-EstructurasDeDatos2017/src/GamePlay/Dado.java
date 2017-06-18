package GamePlay;

import java.util.Random;

/**
 *
 * @author live
 */
public class Dado 
{
    private Random random;
    private int dice;

    public Dado() {
        random = new Random();
        dice =0;
    }

    public int getDice() {
        return dice;
    }
    
    public int throwDice()
    {
        dice =random.nextInt(6);
        return dice;
    }
    
}
