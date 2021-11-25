
public interface SnakeInterface {
	void start();
	
	boolean zielGetroffen();

	void kollision();
	
	
	int getFieldWidth();
	
	int getFieldHeight();
	
	int[] getXArray();
	
	int[] getYArray();
	
	int getXvalue(int index);
	
	int getYvalue(int index);
	
	Snake getSchlange();
	
	Target getZiel();

}
