import java.util.Random;

public class Snake extends Circle {

	private int bodyParts = 3;
	private Circle[] snakeBody = new Circle[bodyParts];
	static Random random = new Random();
	
	public Snake(int x, int y) {
		super(x = random.nextInt(x) * 50, y=random.nextInt(y) * 50);
		for (int i = 0; i < bodyParts; i++) {
			snakeBody[i] = new Circle(x + i * getCircleSize(), y);
		}
	}

	public void setBodyParts(int body) {
		bodyParts = body;
	}
	
	
	public Circle getSnakeBodyPart(int i) {
		return snakeBody[i];
	}
	
	public void move() {
		for (int i = Panel.spiel.getSchlange().getNumberOfBodyParts(); i > 0; i--) {
			Panel.spiel.getXArray()[i] = Panel.spiel.getXArray()[i - 1];
			Panel.spiel.getYArray()[i] = Panel.spiel.getYArray()[i - 1];
		}
		if (Panel.hoch == true) {
			Panel.spiel.getYArray()[0] -= Panel.spiel.getSchlange().getCircleSize();
		}
		if (Panel.runter == true) {
			Panel.spiel.getYArray()[0] += Panel.spiel.getSchlange().getCircleSize();
		}
		if (Panel.links == true) {
			Panel.spiel.getXArray()[0] -= Panel.spiel.getSchlange().getCircleSize();
		}
		if (Panel.rechts == true) {
			Panel.spiel.getXArray()[0] += Panel.spiel.getSchlange().getCircleSize();
		}
	}

	public int getNumberOfBodyParts() {
		// TODO Auto-generated method stub
		return bodyParts;
	}
}
