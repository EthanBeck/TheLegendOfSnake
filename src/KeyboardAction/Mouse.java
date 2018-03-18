package KeyboardAction;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import MainHandler.Screen;

public class Mouse implements MouseMotionListener,MouseListener{
	Screen screen;
	public static int mouseX;
	public static int mouseY;
	public boolean onScreen;
	
	public Mouse(Screen screen){
		screen.addMouseMotionListener(this);
		screen.addMouseListener(this);
	}

	public void mouseDragged(MouseEvent e) {
		if(!onScreen)
			return;
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void mouseMoved(MouseEvent e) {
		if(!onScreen)
			return;
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {
		onScreen = true;		
	}

	public void mouseExited(MouseEvent e) {
		onScreen = false;		
		}
}
