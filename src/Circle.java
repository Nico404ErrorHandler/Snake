import java.util.Random;

public class Circle {
	private int circleSize = 50;
	private int circleX, circleY;
	
	public Circle(int x, int y) {
		this.circleX = x;
		this.circleY = y;
	}

	public int getCircleX() {
		return circleX;
	}
	
	public int getCircleY(){
		return circleY;
	}
	
	public int getCircleSize() {
		return circleSize;
	}
}
