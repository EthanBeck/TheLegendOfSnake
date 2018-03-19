package Food;

import java.awt.Graphics;

public class Item {
	public Foods food = Foods.values()[0].getFood("chicken");
	
	public int x;
	public int y;
	
	public int width;
	public int height;
	
	boolean inBag;
	
	int scale = 20;
	
	
	
	public Item(String name, boolean inBag){
		food = Foods.values()[0].getFood(name);
		this.inBag = inBag;
		
	}
	
	public Item(int x,int y){
		this.x = x;
		this.y = y;
		
		width = food.getImage().getWidth();
		height = food.getImage().getHeight();
	}
	
	public Item(int x,int y,String name){
		this.x = x;
		this.y = y;
		
		food = Foods.values()[0].getFood(name);
		
		width = food.getImage().getWidth();
		height = food.getImage().getHeight();
	}
	
	public void displayItem(Graphics g){
		
	}
}
