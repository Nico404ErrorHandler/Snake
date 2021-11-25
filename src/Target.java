import java.util.Random;

public class Target extends Circle {

	private int targetNumber = 0;
	static Random zufall = new Random();
	
	
	public Target(int x, int y) {
		super(x = zufall.nextInt(x) * 50, y = zufall.nextInt(y) * 50);
		targetNumber++;
	}
	
	public int getTargetNumber() {
		return targetNumber;
	}
	
	
		
	}


