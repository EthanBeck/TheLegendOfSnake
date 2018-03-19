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
			}
			else
				i--;
		}
		items = sortItems(items);
		for(Item item:items)
			System.out.println(item.x);
	}

	public void displayItems(Graphics2D g){
		int count = 0;
		ArrayList<Item> temp = binarySearch(items, 50);
		for(Item item:temp){
			if(item.x+item.food.getImage().getWidth()/scale>=Character.xOffset&&item.y+item.food.getImage().getHeight()/scale>=Character.yOffset)
				if(item.x-item.food.getImage().getWidth()/scale<=Character.xOffset+Screen.WIDTH*Screen.SCALE&&item.y-item.food.getImage().getHeight()/scale<=Character.yOffset+Screen.HEIGHT*Screen.SCALE){
					g.drawImage(item.food.getImage(), item.x-(int)Character.xOffset, item.y-(int)Character.yOffset,item.food.getImage().getWidth()/scale,item.food.getImage().getHeight()/scale, null);
					count++;
				}	
		}
	}

	public ArrayList<Item> sortItems(ArrayList<Item> items){
		radixSortX(items);
		return items;

	}

	public static ArrayList<Item> radixSortX(ArrayList<Item> list){
		ArrayList<Item> positives = list;
		ArrayList<Item> negatives = new ArrayList<Item>();
		int max = 0;
		for(int i = 0;i<list.size();i++){
			max = max<(int)(Math.log10(Math.abs(list.get(i).x)))?(int)(Math.log10(Math.abs(list.get(i).x))):max;
			if(list.get(i).x<0)
				negatives.add(positives.remove(i--));
			//count++;
		}

		list = positiveRadixX(positives,max,0);
		list.addAll(0,negativeRadixX(negatives,max,0));
		return list;
	}

	public static ArrayList<Item> positiveRadixX(ArrayList<Item> list,int max,int x){
		ArrayList<ArrayList<Item>> radix = new ArrayList<ArrayList<Item>>();

		for(int i = 0;i<10;i++)
			radix.add(new ArrayList<>());

		for(Item num:list){
			int index = (int)((num.x/Math.pow(10, x))%10);
			radix.get(index).add(num);
		}
		list.clear();
		for(ArrayList<Item> all:radix){
			list.addAll(all);
		}
		System.gc();
		return max>x?positiveRadixX(list,max,++x):list;
	}

	public static ArrayList<Item> negativeRadixX(ArrayList<Item> list,int max,int x){
		ArrayList<ArrayList<Item>> radix = new ArrayList<ArrayList<Item>>();

		for(int i = 0;i<10;i++)
			radix.add(new ArrayList<>());

		for(Item num:list){
			int index = (int)(Math.abs((num.x/Math.pow(10, x)))%10);
			radix.get(index).add(num);
		}
		list.clear();
		for(ArrayList<Item> all:radix){
			list.addAll(0,all);
		}
		System.gc();
		return max>x?negativeRadixX(list,max,++x):list;
	}
	public static ArrayList<Item> binarySearch(ArrayList<Item> list,int num){
		int mid = list.size()/2;
		int low = 0;
		int high = list.size()-1;
		ArrayList<Item> items = new ArrayList<>();

		num = Screen.SCALE*Screen.WIDTH/2+50;
			while(mid!=low){
				if(list.get(mid).x+num==Character.xOffset+Screen.SCALE*Screen.WIDTH/2){
					items.add(list.get(mid));
					low = mid;
				}
				if(Character.xOffset+Screen.SCALE*Screen.WIDTH/2<list.get(mid).x+num){
					high = mid;
					mid = (mid+low)/2;
				}
				else if(Character.xOffset+Screen.SCALE*Screen.WIDTH/2>list.get(mid).x+num){
					low = mid;
					mid = (high+mid)/2;
				}
			}
			while(list.get(mid).x-num<Character.xOffset+Screen.SCALE*Screen.WIDTH/2&&mid<list.size()-1&&mid>0)
				items.add(list.get(mid++));
		
		System.out.println(Character.xOffset+Screen.SCALE*Screen.WIDTH/2);
		return items;
	}
}


