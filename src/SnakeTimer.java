import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class SnakeTimer implements ActionListener {
	private static SnakeTimer instance = null;
	private static int takt = 300;
	private int i;
	private Timer timer = new Timer(takt, this);

	private SnakeTimer() {
	}

	static public SnakeTimer getInstance() {
		if (instance == null) {
			instance = new SnakeTimer();
		}
		return instance;
	}

	public void start() {
		i = 0;
		timer.start();
	}

	public void stop() {
		timer.stop();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Panel.spiel.getSchlange().move();
	}
	
	
	public int getTime(){
		return i;
	}

}
