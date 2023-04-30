import java.awt.*;
import java.awt.event.*;

public class block extends Rectangle{
	block(int x, int y){
		super(x*Panel.UNIT_SIZE,y*Panel.UNIT_SIZE,Panel.UNIT_SIZE,Panel.UNIT_SIZE);
	}
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x*Panel.UNIT_SIZE, y*Panel.UNIT_SIZE,Panel.UNIT_SIZE,Panel.UNIT_SIZE);
	}
}
