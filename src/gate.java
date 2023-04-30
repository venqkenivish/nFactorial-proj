import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class gate extends Rectangle {
	public int id;
	public int x,y;
	public int end_x,end_y;
	public int length;
	public static final int lever_return = 10;
	public int lever_delay = lever_return;
	double angle = 0;
	public boolean is_open = true;
	public static final int size = 2;
	gate(int x ,int y, int length,int id){
		super(x*Panel.UNIT_SIZE,y*Panel.UNIT_SIZE,size*Panel.UNIT_SIZE,size*Panel.UNIT_SIZE);
		this.end_x = x-length;
		this.end_y = y;
		this.length = length;
		this.x =x;
		this.y=y;
		this.id = id; 
		
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x*Panel.UNIT_SIZE, y*Panel.UNIT_SIZE,size*Panel.UNIT_SIZE,size*Panel.UNIT_SIZE);
		status(g);
	}
	public void status(Graphics g) {
		if(lever_delay != lever_return && lever_delay != 0){
			if(is_open) {
				angle = angle + 10.0;
				end_x = x-(int)(length*Math.cos(Math.toRadians(angle)));
				end_y = y- (int)(length*Math.sin(Math.toRadians(angle)));
				System.out.println(end_x);
				System.out.println(end_y);
			}
			else {
				angle = angle - 10.0;
				end_x = x +(int)(length*Math.cos(Math.toRadians(angle)));
				end_y = y-(int)(length*Math.sin(Math.toRadians(angle)));
				System.out.println(end_x);
				System.out.println(end_y);
				
			}
			lever_delay--;
			g.setColor(Color.white);
		}
		else if(lever_delay == 0) {
			lever_delay = lever_return;
		}
		g.drawLine(x*Panel.UNIT_SIZE,y*Panel.UNIT_SIZE,end_x*Panel.UNIT_SIZE,end_y*Panel.UNIT_SIZE);
	}
}
