import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class player_fire extends player {
	boolean lever_swith  = false;
	player_fire(int x, int y,int size){
		super(x,y,size);
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SHIFT) {
			is_jump=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_W) {
			up=1;
		}
		if(e.getKeyCode()==KeyEvent.VK_A) {
			left=1;
		}
		if(e.getKeyCode()==KeyEvent.VK_S) {
			down=1;
		}
		if(e.getKeyCode()==KeyEvent.VK_D) {
			right=1;
		}
		if(e.getKeyCode()==KeyEvent.VK_F) {
			lever_swith = true;
		}
		move();
	}
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SHIFT) {
			
		}
		if(e.getKeyCode()==KeyEvent.VK_W) {
			up=0;
		}
		if(e.getKeyCode()==KeyEvent.VK_A) {
			left=0;
		}
		if(e.getKeyCode()==KeyEvent.VK_S) {
			down=0;
		}
		if(e.getKeyCode()==KeyEvent.VK_D) {
			right=0;
		}
		if(e.getKeyCode()==KeyEvent.VK_F) {
			lever_swith = false;
		}
		move();
	}

	public void move() {
		y = y-(int)up;
		x = x+(int)right;
		y = y+(int)down;
		x = x-(int)left;
		if(is_jump)
		{
			if(jump_delay ==0)
			{
				jump_delay = jump_return;
				is_jump = false;
			}
			else
			{
				jump_delay--;
			}
		}
	}
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x*Panel.UNIT_SIZE, y*Panel.UNIT_SIZE, (int)PLAYER_SIZE*Panel.UNIT_SIZE, (int)PLAYER_SIZE*Panel.UNIT_SIZE);
		jump(g);
	}
}
