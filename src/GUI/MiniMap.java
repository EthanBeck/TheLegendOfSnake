package GUI;

import java.awt.Color;
import java.awt.Graphics;

import Food.Item;
import Grid.Grid;

public class MiniMap {
	public static final int width = 100;
	public static final int height = 75;
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
		g.fillRoundRect(xOffset, yOffset, width, height,10,10);
		for(Item item:Grid.items){
			drawItem(g,item);
		}
		g.setColor(Color.RED);
		g.fillOval(pointerX-dotRadius+xOffset, pointerY-dotRadius+yOffset,dotRadius*2,dotRadius*2);
		g.setColor(Color.black);
	}
	
	public void updatePointer(double x, double y) {
		pointerX = (int)(x/xMax*width);
		pointerY = (int)(y/yMax*height);
	}
	public void drawItem(Graphics g,Item item){
		g.setColor(Color.BLACK);
		int xx = (int)((double)(item.x-item.food.getImage().getWidth()/4)/xMax*width);
		int yy = (int)((double)(item.y-item.food.getImage().getHeight()/10)/yMax*height);
		g.fillOval(xx+xOffset-1, yy+yOffset-1,2,2);
	}
}