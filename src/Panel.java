import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;


public class Panel extends JPanel implements ActionListener{
	static final int SCREEN_WIDTH = 1300;
	static final int SCREEN_HEIGHT = 750;
	Panel(){
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	
	}
	void startGame() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			
			}
		}
}
