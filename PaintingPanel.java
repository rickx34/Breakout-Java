/*
 Sahil Sathe ID-1252972
 Ricky Dua ID-1243947
 Equal Contribution
*/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;
import javax.swing.JPanel;

public class PaintingPanel extends JPanel
{
	public Vector contents;

	public PaintingPanel(Vector contents, Ball ball,Padel paddle)
	{
		super();
		contents.add(ball);
		contents.add(paddle);
		this.contents = contents;
		setPreferredSize(new Dimension(Breakout.FRAMEX,Breakout.FRAMEY));       
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		setBackground(Color.black);

		Ball ball = (Ball) contents.get(contents.size()-2);
		Padel paddle = (Padel) contents.get(contents.size()-1);

		for(int i = 0; i <= Brick.NUM_OF_BRICKS; i++){
			Brick brick = (Brick) contents.get(i);
			brick.paintThis(g);
		}
		paddle.paintThis(g);
		ball.paintThis(g);       
	}
}
