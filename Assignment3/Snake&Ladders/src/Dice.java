import java.util.Random;

public class Dice {
	static final int numFace = 2;
	
	public Dice(){
		//initialized
	}
	public int roll(){
		Random rand = new Random();
		int x = rand.nextInt(numFace-1)+1;
		return x;
	}
}
