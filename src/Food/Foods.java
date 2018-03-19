package Food;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum Foods {
	POPCORN("popcorn",10),
	CHICKEN("chicken",25);
	
	private BufferedImage image;
	private String name;
	private int count;
	
	Foods(String name, int count){
		this.name = name;
		
		try {
			image = ImageIO.read(new File("Images/"+name+".png"));
		} catch (IOException e) {
			image = new BufferedImage(null, null, false, null);
		}
	}

	public String getName(){
		return name;
	}
	public BufferedImage getImage(){
		return image;
	}
	
	public Foods getFood(String name){
		for(Foods food:Foods.values()){
			if(name.equalsIgnoreCase(food.getName()))
				return food;
		}
		return Foods.values()[0];
	}
}
