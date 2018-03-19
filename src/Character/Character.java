package Character;

import java.awt.Graphics;

import GUI.MiniMap;
import Grid.Grid;
import KeyboardAction.Keys;
import KeyboardAction.Mouse;
import MainHandler.Screen;

public class Character {
	public static double x = 0;
	public static double y = 0;

	public static double xOffset = 450;
	public static double yOffset = 450;

	public int width = 60;
	public int height = 60;

	public double speed = 4;
	
	double degrees = 0;

	MiniMap map = new MiniMap(Screen.WIDTH*Screen.SCALE-MiniMap.width-Grid.border,Screen.HEIGHT*Screen.SCALE-MiniMap.height-Grid.border);
	//Bag bag = new Bag();
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
		updateAngle();
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
		map.updatePointer(xOffset-(Screen.WIDTH*Screen.SCALE/2)+x,yOffset-(Screen.HEIGHT*Screen.SCALE/2)+y);
	}
	
	public void updateAngle(){
		degrees = -(Math.atan((double)(Mouse.mouseY-y)/(Mouse.mouseX-x))*58)+90;
			if((Mouse.mouseX-x)>=0)
				degrees+=180;
	}
	
	
	public void displayCharacter(Graphics g){

		g.fillOval((int)x-width/2,(int)y-height/2,width,height);
	}
	
	public void displayMap(Graphics g){
		map.displayGui(g);
	}
	
	public void displayCannon(Graphics g){

		int angles = 720;
		double angle = 360/(double)angles;
		double arc = angle/2;
		g.drawLine((int)x, (int)y, (int)x+(int)(Math.sin(Math.toRadians((int)((degrees+arc)/angle)*angle))*-100), (int)y+(int)(Math.cos(Math.toRadians((int)((degrees+arc)/angle)*angle))*-100));
	}
}
