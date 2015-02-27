/*
 Sahil Sathe ID-1252972
 Ricky Dua ID-1243947
 Equal Contribution
*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Padel 
{
	//Fields
	public static final int PADDLE_SIZE= 100;
	public static final int PADDLE_THICKNESS = 10;
	public int paddleX= Breakout.FRAMEX/2;//(Breakout.FRAMEX/2)-(PADDLE_SIZE/2);
	public int paddleY = Breakout.FRAMEY;

	//Methods
	public void paintThis(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(paddleX-PADDLE_SIZE/2, paddleY-PADDLE_THICKNESS, PADDLE_SIZE, PADDLE_THICKNESS);
	}

	public Rectangle getBounds()
	{
		return new Rectangle(paddleX-PADDLE_SIZE/2 , paddleY-PADDLE_THICKNESS , PADDLE_SIZE,PADDLE_THICKNESS);
	}
}
