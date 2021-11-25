import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Panel extends JPanel implements MouseListener, KeyListener, ActionListener {
	public static boolean hoch = false;
	public static boolean runter = true;
	public static boolean links = false;
	public static boolean rechts = false;

	static SnakeSpiel spiel = new SnakeSpiel();
	static int offX, offY;

	public Panel() {
		spiel.start();
		this.addMouseListener(this);
		this.addKeyListener(this);
		this.setFocusable(true);
		SnakeTimer.getInstance().start();
	}

	public void paint(Graphics gr) {

		super.paint(gr);

		spiel.kollision();
		spiel.zielGetroffen();
		
		//ZELLENBREITE UND ZELLENHÖHE
		int feldBreite = 50;
		int feldHoehe = 50;

		// OFFSETX UND OFFSETY
		offX = (getWidth() - feldBreite * spiel.getFieldWidth()) / 2;
		offY = (getHeight() - feldHoehe * spiel.getFieldHeight()) / 2;

		//
		for (int i = 0; i <= spiel.getFieldHeight(); i++) {
			gr.drawLine(feldBreite * i + offX, offY, feldBreite * i + offX, spiel.getFieldHeight() * feldHoehe + offY);
		}

		for (int i = 0; i <= spiel.getFieldHeight(); i++) {
			gr.drawLine(offX, feldHoehe * i + offY, spiel.getFieldWidth() * feldBreite + offX, feldHoehe * i + offY);
		}
		
		gr.setColor(Color.YELLOW);
		gr.fillOval(spiel.getZiel().getCircleX() + offX, spiel.getZiel().getCircleY() + offY,
				spiel.getZiel().getCircleSize(), spiel.getZiel().getCircleSize());
		gr.setColor(Color.RED);
		gr.drawOval(spiel.getZiel().getCircleX() + offX, spiel.getZiel().getCircleY() + offY,
				spiel.getZiel().getCircleSize(), spiel.getZiel().getCircleSize());

		for (int i = 0; i < spiel.getSchlange().getNumberOfBodyParts(); i++) {
			gr.setColor(Color.GREEN);
			gr.fillOval(spiel.getXvalue(i) + offX, spiel.getYvalue(i) + offY, spiel.getSchlange().getCircleSize(),
					spiel.getSchlange().getCircleSize());
			gr.setColor(Color.BLACK);
			gr.drawOval(spiel.getXvalue(i) + offX, spiel.getYvalue(i) + offY, spiel.getSchlange().getCircleSize(),
					spiel.getSchlange().getCircleSize());
		}
		
		repaint();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			hoch = true;
			runter = false;
			links = false;
			rechts = false;
			break;
		case KeyEvent.VK_DOWN:
			hoch = false;
			runter = true;
			links = false;
			rechts = false;
			break;
		case KeyEvent.VK_LEFT:
			links = true;
			rechts = false;
			hoch = false;
			runter = false;
			break;
		case KeyEvent.VK_RIGHT:
			rechts = true;
			links = false;
			hoch = false;
			runter = false;
			break;
		}

	}

	public static int getOffY() {
		return offY;
	}

	public static int getOffX() {
		return offX;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		spiel = new SnakeSpiel();
		repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
