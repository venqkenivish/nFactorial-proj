import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class player extends Rectangle {
	int PLAYER_SIZE;
	public static final int jump_return = 20;
	public int jump_delay = jump_return;
	public int x;
	public int y;
	public boolean is_jump = false;
	int up=0,down=0,right=0,left=0;
	Timer timer;
	player(int x, int y,int size)
	{
		super(x*Panel.UNIT_SIZE,y*Panel.UNIT_SIZE,size*Panel.UNIT_SIZE,size*Panel.UNIT_SIZE);
		this.PLAYER_SIZE = size;
		this.x = x;
		this.y =y;
	}
	public void jump(Graphics g){
		if(is_jump) {
			g.setColor(Color.white);
			g.drawLine(x*Panel.UNIT_SIZE,y*Panel.UNIT_SIZE,(x+PLAYER_SIZE)*Panel.UNIT_SIZE,y*Panel.UNIT_SIZE);
			g.drawLine((x+PLAYER_SIZE)*Panel.UNIT_SIZE,y*Panel.UNIT_SIZE,(x+PLAYER_SIZE)*Panel.UNIT_SIZE,(y+PLAYER_SIZE)*Panel.UNIT_SIZE);
			g.drawLine((x+PLAYER_SIZE)*Panel.UNIT_SIZE,(y+PLAYER_SIZE)*Panel.UNIT_SIZE,x*Panel.UNIT_SIZE,(y+PLAYER_SIZE)*Panel.UNIT_SIZE);
			g.drawLine(x*Panel.UNIT_SIZE,(y+PLAYER_SIZE)*Panel.UNIT_SIZE,x*Panel.UNIT_SIZE,y*Panel.UNIT_SIZE);
		}
	}
}
