package Character;

import Grid.Grid;
import KeyboardAction.Keys;
import MainHandler.Screen;

public class Character {
	public double x = 0;
	public double y = 0;
	
	public double xOffset = 450;
	public double yOffset = 450;
	
	public int width = 60;
	public int height = 60;
	
	public double speed = 1.5;
	
	
	public Character(){
		
	}
	public Character(int x,int y){
		this.x = x;
		this.y = y;
		xOffset = 500;
		yOffset = 500;
	}
	
	public void movement()
	{
		if((Keys.movement>>0)%2==1){//left
			if(xOffset>=Grid.width-(Screen.WIDTH*Screen.SCALE/2)&&x>Screen.WIDTH*Screen.SCALE/2)
				x-=speed;
			else if(xOffset<=Screen.WIDTH*Screen.SCALE/2&&x-width/2>Grid.border)
				x-=speed;
			else if(xOffset>Screen.WIDTH*Screen.SCALE/2)
				xOffset-=speed;
		}
		if((Keys.movement>>3)%2==1){//up
			if(yOffset>=Grid.height-(Screen.HEIGHT*Screen.SCALE/2)&&y>Screen.HEIGHT*Screen.SCALE/2)
				y-=speed;
			else if(yOffset<=Screen.HEIGHT*Screen.SCALE/2&&y-height/2>Grid.border)
				y-=speed;
			else if(yOffset>Screen.HEIGHT*Screen.SCALE/2)
				yOffset-=speed;
		}
		if((Keys.movement>>2)%2==1){//right
			if(xOffset<=Screen.WIDTH*Screen.SCALE/2&&x<Screen.WIDTH*Screen.SCALE/2)
				x+=speed;
			else if(xOffset>=Grid.width-(Screen.WIDTH*Screen.SCALE/2)&&x+width/2<Screen.WIDTH*Screen.SCALE-Grid.border)
				x+=speed;
			else if(xOffset<Grid.width-(Screen.WIDTH*Screen.SCALE/2))
				xOffset+=speed;
		}
		if((Keys.movement>>1)%2==1){//down
			if(yOffset<=Screen.HEIGHT*Screen.SCALE/2&&y<Screen.HEIGHT*Screen.SCALE/2)
				y+=speed;
			else if(yOffset>=Grid.height-(Screen.HEIGHT*Screen.SCALE/2)&&y+height/2<Screen.HEIGHT*Screen.SCALE-Grid.border)
				y+=speed;
			else if(yOffset<Grid.height-(Screen.HEIGHT*Screen.SCALE/2))
				yOffset+=speed;
		}
	}
}
