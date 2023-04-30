import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;
import java.util.*;

public class Panel extends JPanel implements Runnable{
	public static final int SCREEN_WIDTH = 1000;
	public static final int SCREEN_HEIGHT = 1000;
	public int GAME_WIDTH= 1000;
	public int GAME_HEIGHT = 1000;
	public static final int UNIT_SIZE = 10;
	static final int PLAYER_SIZE = 4;
	boolean running = false;
	boolean started = false;
	public boolean is_new;
	//test
	player_fire fire = new player_fire(10,10,PLAYER_SIZE);
	lever  lever = new lever(30,30,1);
	gate gate = new gate(20,20,10,1);
	//test;
	Random randomx;
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
	public void start(Graphics g) {
		g.setColor(Color.white);
		g.setFont( new Font("Times New Roman",Font.BOLD, 40));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Type ENTER to start new...", (SCREEN_WIDTH - metrics.stringWidth("Type ENTER to start new..."))/2, (SCREEN_HEIGHT/2 - g.getFont().getSize()));
		g.drawString("Type any key(despite ENTER) to continue...", (SCREEN_WIDTH - metrics.stringWidth("Type any key(despite ENTER) to continue..."))/2, (SCREEN_HEIGHT/2 + g.getFont().getSize()));
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
		if(!started) {
			start(g);
		}
		else
		{
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);
			
		}
		
	}
	public void draw(Graphics g)
	{
		fire.draw(g);
		lever.draw(g);
		gate.draw(g);
		Toolkit.getDefaultToolkit().sync();
	}
	public void move() {
		fire.move();
		if(fire.lever_swith && lever.lever_delay==lever.lever_return&&fire.can_switch) {
			lever.is_open = !lever.is_open;
			lever.lever_delay--;
			gate.is_open = !gate.is_open;
			gate.lever_delay--;
		}
	}
	public void collision(){
		if(fire.x<=0) {
			fire.x=0;
		}
		if(fire.x>=(GAME_WIDTH/UNIT_SIZE)-PLAYER_SIZE) {
			fire.x=(GAME_WIDTH/UNIT_SIZE)-PLAYER_SIZE;
		}
		if(fire.y<=0)  {
			fire.y=0;
		}
		if(fire.y>=(GAME_HEIGHT/UNIT_SIZE)-PLAYER_SIZE) {
			fire.y=(GAME_HEIGHT/UNIT_SIZE)-PLAYER_SIZE;
		}
		//with lever
		if(lever.y<fire.y+PLAYER_SIZE&&lever.y+lever.size>fire.y&&lever.x<fire.x+PLAYER_SIZE&&lever.x+lever.size>fire.x) {
			if(lever.x<=fire.x+PLAYER_SIZE){
				fire.x = lever.x-PLAYER_SIZE;
			}
			if(lever.x+lever.size>=fire.x){
				fire.x = lever.x+lever.size;
			}
			if(lever.y+lever.size>=fire.y){
				fire.y = lever.y+lever.size;
			}
			if(lever.y<=fire.y+PLAYER_SIZE){
				fire.y = lever.y-PLAYER_SIZE;
			}
		}
		if(fire.x+PLAYER_SIZE>=lever.corner1x && lever.corner3x>=fire.x && fire.y+PLAYER_SIZE>=lever.corner1y && lever.corner1y>=fire.y) {
			fire.can_switch=true; 
		}
		else {fire.can_switch=false;}
	}
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			if(!started) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					is_new =true;
					started =true;
				}
				else
				{
					is_new = false;
					started =true;
				}
				
			}
			fire.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			fire.keyReleased(e);
		}
	}
}
