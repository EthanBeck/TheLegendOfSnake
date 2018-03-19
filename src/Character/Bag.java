package Character;

import java.util.ArrayList;

import Food.Item;

public class Bag {
	public int bagSize = 10;
	public ArrayList<Item> items = new ArrayList<>(); // implement food later 
	
	public Bag(){
		items.add(new Item("popcorn",true));
	}
}
