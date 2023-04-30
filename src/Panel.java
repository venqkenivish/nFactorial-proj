import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.*;

public class Panel extends JPanel implements Runnable{
	static final int SCREEN_WIDTH = 1000;
	static final int SCREEN_HEIGHT = 1000;
	public static final int UNIT_SIZE = 10;
	static final int PLAYER_SIZE = 4;
	boolean running = false;
	//test
	player_fire fire = new player_fire(10,10,PLAYER_SIZE);
	//test
	Random random;
	Thread gameThread;
	Image image;
	Graphics graphics;
	Panel(){
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		gameThread = new Thread(this);
		gameThread.start();
	
	}
	public void run() {
		running = true;
		long lastTime = System.nanoTime();
		double amountOfTicks =20.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				move();
				collision();
				repaint();
				delta--;
			}
		}
	}
	public void paint(Graphics g) {
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);
	}
	public void draw(Graphics g)
	{
		fire.draw(g);
		Toolkit.getDefaultToolkit().sync();
	}
	public void move() {
		fire.move();
	}
	public void collision(){
		if(fire.x<=0) {
			fire.x=0;
		}
		if(fire.x>=(SCREEN_WIDTH/UNIT_SIZE)-PLAYER_SIZE) {
			fire.x=(SCREEN_WIDTH/UNIT_SIZE)-PLAYER_SIZE;
		}
		if(fire.y<=0) {
			fire.y=0;
		}
		if(fire.y>=(SCREEN_HEIGHT/UNIT_SIZE)-PLAYER_SIZE) {
			fire.y=(SCREEN_HEIGHT/UNIT_SIZE)-PLAYER_SIZE;
		}
	}
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			fire.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			fire.keyReleased(e);
		}
	}
}
