package GamePlay;
//Bibliotecas a usar
import java.util.Random;
/**
 *
 * @author live y edgerik
 */
public class Dado 
{
    //Variables globales
    private Random random;
    private int dice;
    //Constructor
    public Dado() 
    {
        this.random = new Random();
        this.dice = 0;
    }
    //Gets and Sets
    public int getDice() {
        return dice;
    }
    public int throwDice()
    {
        dice =random.nextInt(6);
        return dice;
    }
}
