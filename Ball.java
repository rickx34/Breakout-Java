/*
 Sahil Sathe ID-1252972
 Ricky Dua ID-1243947
 Equal Contribution
*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {

	public int x, y;
	public final int radius;
	public final Color colour;
	public double dirX;
	public double dirY;
	public int speed;

	public Ball(int x, int y, int radius, Color colour, int speed){

		this.x = x;//center
		this.y = y;//center
		this.radius = radius;
		this.colour = colour;
		this.speed = speed;


		Random random = new Random();
		dirX = random.nextDouble();
		dirY = random.nextDouble();

		dirX = dirX / Math.sqrt(dirX*dirX + dirY*dirY);
		dirY = dirY / Math.sqrt(dirX*dirX + dirY*dirY);
	}
	public void paintThis(Graphics g){
		g.setColor(colour);
		g.fillOval(x-radius,y-radius,radius*2,radius*2);
	}

	public Rectangle getBounds(){
		return new Rectangle(x-radius,y-radius,radius*2, radius*2);
	}

	public void move(){
		x = (int) Math.round(x-dirX*speed);
		y = (int) Math.round(y-dirY*speed); 
	}

	public void reflect(boolean vertical, boolean horizontal){

		if(vertical==true){
			dirX *= -1;
		}

		if(horizontal==true) {
			dirY *= -1;
		}
	}    
}
