
import javax.swing.JFrame;

public class Window extends JFrame{

	Window(){
			
		this.add(new Panel());
		this.setTitle("Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
}