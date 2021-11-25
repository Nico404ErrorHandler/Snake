
public class SnakeSpiel implements SnakeInterface {

	public boolean inGame = true;
	private boolean getroffen = true;
	private int zeilenAnzahl = 10;
	private int spaltenAnzahl = 10;
	private Snake schlange = new Snake(10, 10);
	private Target ziel = new Target(10, 10);

	private int[] xAxis = new int[zeilenAnzahl * spaltenAnzahl];
	private int[] yAxis = new int[zeilenAnzahl * spaltenAnzahl];

	public void start() {
		for (int i = 0; i < getSchlange().getNumberOfBodyParts(); i++) {
			xAxis[i] = getSchlange().getSnakeBodyPart(i).getCircleX();
			yAxis[i] = getSchlange().getSnakeBodyPart(i).getCircleY();
		}
	}

	public boolean zielGetroffen() {
		if (xAxis[0] == getZiel().getCircleX() && yAxis[0] == getZiel().getCircleY()) {
			getSchlange().setBodyParts(getSchlange().getNumberOfBodyParts() + 1);
			ziel = new Target(10, 10);
			return getroffen;
		} else {
			return false;
		}
	}

	public void kollision() {

		System.out.println(yAxis[0]);
		for (int i = getSchlange().getNumberOfBodyParts(); i > 0; i--) {
			if ((i > 4) && (xAxis[0] == xAxis[i]) && (yAxis[0] == yAxis[i])) {
				inGame = false;
			}
		}
		if (yAxis[0] >= spaltenAnzahl * getSchlange().getCircleSize()) {
			inGame = false;
			
		}
		if (yAxis[0] < 0) {
			inGame = false;
		}
		if (xAxis[0] >= zeilenAnzahl * getSchlange().getCircleSize()) {
			inGame = false;
		}
		if (xAxis[0] < 0) {
			inGame = false;
		}
		if (!inGame) {
			SnakeTimer.getInstance().stop();
		}
	}
	
	/*public void verloren() {
		if (SnakeTimer.getInstance().ge) {
			
		}
	}*/

	public int getFieldWidth() {
		return zeilenAnzahl;
	}

	public int getFieldHeight() {
		return spaltenAnzahl;
	}

	public int[] getXArray() {
		return xAxis;
	}

	public int[] getYArray() {
		return yAxis;
	}

	public int getXvalue(int index) {
		return xAxis[index];
	}

	public int getYvalue(int index) {
		return yAxis[index];
	}

	public Snake getSchlange() {
		return schlange;
	}

	public Target getZiel() {
		return ziel;
	}

}
