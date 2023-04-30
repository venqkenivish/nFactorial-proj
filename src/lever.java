import java.awt.*;
import java.awt.event.*;

public class lever extends Rectangle {
	public int id;
	public int x,y;
	public static final int lever_return = 10;
	public int lever_delay = lever_return;
	public final int corner1x,corner1y,corner3x,corner3y;
	public static final int size = 2;
	public boolean is_open = true;
	lever( int x, int y, int id){
		super(x*Panel.UNIT_SIZE,y*Panel.UNIT_SIZE,size*Panel.UNIT_SIZE,size*Panel.UNIT_SIZE);
		this.x =x;
		this.y=y;
		this.id = id;
		this.corner1x = x-1;
		this.corner1y = y-1;
		this.corner3x = x+size+1;
		this.corner3y = y+size+1;
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x*Panel.UNIT_SIZE, y*Panel.UNIT_SIZE,size*Panel.UNIT_SIZE,size*Panel.UNIT_SIZE);
		turn(g);
	}
	public void turn(Graphics g){
		if(lever_delay != lever_return && lever_delay != 0){
			lever_delay--;
		}
		else if(lever_delay == 0) {
			lever_delay = lever_return;
		}
		if(is_open) {
			g.setColor(Color.white);
			g.drawLine(x*Panel.UNIT_SIZE+size*Panel.UNIT_SIZE/2,y*Panel.UNIT_SIZE,x*Panel.UNIT_SIZE,y*Panel.UNIT_SIZE-size*Panel.UNIT_SIZE/2);
		}
		else {
			g.setColor(Color.white);
			g.drawLine(x*Panel.UNIT_SIZE+size*Panel.UNIT_SIZE/2,y*Panel.UNIT_SIZE,x*Panel.UNIT_SIZE+size*Panel.UNIT_SIZE,y*Panel.UNIT_SIZE-size*Panel.UNIT_SIZE/2);
		}
	}
}
