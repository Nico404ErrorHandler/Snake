import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LayoutManager extends JFrame {
	private Panel mitte;
	
	public LayoutManager() {
		
		mitte = new Panel();
		
		this.setSize(1000, 1000);
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.CENTER, mitte);
		
		JPanel buttonOut = new JPanel(new FlowLayout());
		JPanel buttonIn = new JPanel(new GridLayout(1,1));
		JButton button = new JButton("Neustart");
		
		JPanel titelMiddle = new JPanel(new FlowLayout());
		JLabel titel = new JLabel("Snake - Nico Isheim - 690222");
		
		buttonIn.add(button);
		buttonOut.add(buttonIn);
		this.add(BorderLayout.SOUTH, buttonOut);
		titelMiddle.add(titel);
		this.add(BorderLayout.NORTH, titelMiddle);
		
		button.addActionListener(mitte);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
}
