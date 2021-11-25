import javax.swing.JFrame;

public class Frame extends JFrame {
	public Frame() {
		Panel centeredPanel = new Panel();
		add(centeredPanel);
		this.setSize(1000, 1000);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
}
