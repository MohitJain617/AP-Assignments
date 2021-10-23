import java.util.Random;

import javax.swing.event.SwingPropertyChangeSupport;

public class Dice {
	static final int numFace = 2;
	
	public Dice(){
		//initialized
	}
	public int roll(){
		Random rand = new Random();
		int x = rand.nextInt(numFace)+1;
		return x;
	}
	public static void main(String args[]){
		Dice d = new Dice();
		for(int i = 0; i < 10; i ++){
			System.out.println(d.roll());
		}
	}
}
