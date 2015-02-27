/*
 Sahil Sathe ID-1252972
 Ricky Dua ID-1243947
 Equal Contribution
*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Brick 
{
    public final int topLeftX, topLeftY, width, height;
    public final Color colour;
    public static int NUM_OF_BRICKS = 71;

    public Brick(int topLeftX, int topLeftY, int width, int height, Color colour) {
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.width = width;
        this.height = height;
        this.colour = colour;
    }
    
    public void paintThis(Graphics g)
    {        
        g.setColor(colour);
        g.fillRect(topLeftX, topLeftY, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(topLeftX, topLeftY, width, height);
    }
    
    public Rectangle getBounds()
    {
        return new Rectangle(topLeftX, topLeftY, width, height);
    }
}
