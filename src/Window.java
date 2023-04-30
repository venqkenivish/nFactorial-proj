
import java.awt.*;
import javax.swing.*;

public class Window extends JFrame{

	Window(){
		this.add(new Panel());
		this.setTitle("Game");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}