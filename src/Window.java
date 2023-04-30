
import java.awt.*;
import javax.swing.*;

public class Window extends JFrame{

	Panel panel;
	
	Window(){
		panel = new Panel();
		this.add(panel);
		this.setTitle("Game");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}