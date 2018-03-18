package GUI;

import java.awt.Color;
import java.awt.Graphics;

import Grid.Grid;

public class MiniMap {
	final int width = 100;
	final int height = 75;
	final int xOffset;
	final int yOffset;
	
	int pointerX = 0;
	int pointerY = 0;

	final int xMax = Grid.width;
	final int yMax = Grid.height;
	
	final int dotRadius = 2;
	
	public MiniMap(){
		xOffset = 100;
		yOffset = 100;
	}
	public MiniMap(int x,int y){
		xOffset = x;
		yOffset = y;
	}
	
	public void displayGui(Graphics g){
		g.setColor(new Color(229, 241, 255,100));
		g.fillRect(xOffset, yOffset, width, height);
		g.setColor(Color.RED);
		g.fillOval(pointerX-dotRadius+xOffset, pointerY-dotRadius+yOffset,dotRadius*2,dotRadius*2);
	}
	
	public void updatePointer(double x, double y) {
		pointerX = (int)(x/xMax*width);
		pointerY = (int)(y/yMax*height);
		
	}
}