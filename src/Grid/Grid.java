package Grid;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Character.Character;
import Food.Foods;
import Food.Item;
import MainHandler.Screen;
public class Grid {
	public static int width = 5000;
	public static int height = 3000;
	public static int border = 10;

	int scale = 20;

	public static ArrayList<Item> items = new ArrayList<>();

	public Grid(int width,int height){
		this.width = width;
		this.height = height;
	}
	public Grid(int width,int height,int numItems){
		this.width = width;
		this.height = height;

		for(int i = 0;i<numItems;i++)
			items.add(new Item((int)(Math.random()*width),(int)(Math.random()*height),"popcorn"));
	}

	public Grid(int numItems){
		String name = "popcorn";

		BufferedImage image = Foods.values()[0].getFood(name).getImage();

		int imageWidth = image.getWidth()/scale;
		int imageHeight = image.getHeight()/scale;


		for(int i = 0;i<numItems;i++){
			int x = (int)(Math.random()*(width+imageWidth+Screen.WIDTH*Screen.SCALE/2));
			int y = (int)(Math.random()*(height+imageHeight+Screen.HEIGHT*Screen.SCALE/2));
			if(x>=Screen.WIDTH*Screen.SCALE/2&&y>=Screen.HEIGHT*Screen.SCALE/2&&y<=height+Screen.HEIGHT*Screen.SCALE/2-imageHeight&&x<=width+Screen.WIDTH*Screen.SCALE/2-imageWidth){
				items.add(new Item(x,y,"popcorn"));
				System.out.println(x + " " + y);
			}
			else
				i--;
		}
	}

	public void displayItems(Graphics2D g){
		int count = 0;
		for(Item item:items){
			if(item.x+item.food.getImage().getWidth()/scale>=Character.xOffset&&item.y+item.food.getImage().getHeight()/scale>=Character.yOffset)
				if(item.x-item.food.getImage().getWidth()/scale<=Character.xOffset+Screen.WIDTH*Screen.SCALE&&item.y-item.food.getImage().getHeight()/scale<=Character.yOffset+Screen.HEIGHT*Screen.SCALE){
					g.drawImage(item.food.getImage(), item.x-(int)Character.xOffset, item.y-(int)Character.yOffset,item.food.getImage().getWidth()/scale,item.food.getImage().getHeight()/scale, null);
					count++;
				}	
			}
		System.out.println(count);
		}

	}
