/*
 Sahil Sathe ID-1252972
 Ricky Dua ID-1243947
 Equal Contribution
*/
package Assignment1;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Breakout extends TimerTask
{
	public Vector vector;
	public Ball ball;
	public Padel paddle;
	public static PaintingPanel panel;
	public boolean gameRunning =  false;
	static int FRAMEX = 441;
	static int FRAMEY = 500;
	public int score;

	public Breakout(){
		//fields for bricks
		int brickY = 0;
		int row = 1;
		int brickX = 0;
		int brickWidth = 50;
		int height = 30;
		Color colour = Color.CYAN;
		score = Brick.NUM_OF_BRICKS;
		vector = new Vector();

		//this loop adds all the bricks to the vector
		for(int i = 0; i <= Brick.NUM_OF_BRICKS; i++) {

			if(i>0)
			{
				brickX++;
			}
			//if "i" reaches end of the row it starts again from brickX = 0 and y = 20*row
			if(i == 9 * row)
			{    
				brickY = (height+1) * row;
				row++;
				brickX = 0;
				//chaages colour every second row in 2 rows
				if(i==18){		
					colour = Color.RED;
				}
				if(i==36){			
					colour = Color.yellow;
				}
				if(i==54){
					colour =  new Color(23, 235, 132);//random green colour
				}
			}
			vector.add(i, new Brick(brickX*brickWidth, brickY, brickWidth, height, colour));//adding all brick to vector
		}

		paddle = new Padel();
		ball = new Ball((FRAMEX/2),482,7,Color.WHITE,8);
		panel = new PaintingPanel(vector, ball, paddle);
	}

	public static void main(String[] args) {

		Timer t = new Timer();
		Breakout b = new Breakout();
		t.schedule(b, 0,40); 
		showGUI(b);
	}

	public static void showGUI(Breakout k){
		JFrame frame = new JFrame("Breakout");
		frame.addKeyListener(k.new KeyListenerClass());
		frame.add(panel);
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void run() {
		//if game is running move the ball and handle collisions.
		if(gameRunning == true){
			ball.move();
			panel.repaint();
			handleCollisions();	
			System.out.println(vector.size());
		}
	}

	public void beginGame(){
		gameRunning = true;
	}

	public void stopGame(){

		//when ball goes below jframe it pops out a message you lose, @ param "2" that is the ball and the padel in the
		//contents vector. when vector.size() == 2 means no bricks left
		if(vector.size() > 2){
			gameRunning = false;
			JDialog jDialog = new JDialog();
			jDialog.add(new JLabel("You Lose"));
			JOptionPane.showMessageDialog(jDialog, "You Lose");

		}

		if(vector.size() == 2){	
			//if all bricks are gone, it pops out a message "you win"
			gameRunning = false;
			JDialog jDialog = new JDialog();
			jDialog.add(new JLabel("You Win"));
			JOptionPane.showConfirmDialog(jDialog, "You Win");
		}
	}

	public void handleCollisions(){
		//collision handling of ball between bricks and padel
		if(gameRunning == true){

			if(ball.x<0){
				ball.reflect(true, false);
			}

			if(ball.x>Breakout.FRAMEX){
				ball.reflect(true, false);
			}

			if(ball.y<0){
				ball.reflect(false, true);
			}

			if(ball.y>Breakout.FRAMEY){
				stopGame(); 
			}
			//brick collision handling
			for(int i = 0; i<=Brick.NUM_OF_BRICKS; i++){
				Brick brick = (Brick) vector.get(i);

				if(ball.getBounds().intersects(brick.getBounds())){
					ball.reflect(false, true);
					Brick.NUM_OF_BRICKS--;
					score--;
					vector.remove(brick);
					panel.contents.remove(brick);				
				}
			}
			//padel collision handling
			if (ball.getBounds().intersects(paddle.getBounds())) { 
				ball.reflect(false, true);
			}
		}
	}

	private class KeyListenerClass implements KeyListener{
		//key listener for arrows keys and spacebar
		
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()){
			case KeyEvent.VK_RIGHT: 
				paddle.paddleX += 20; 
				break; 
			case KeyEvent.VK_LEFT: 
				paddle.paddleX -= 20; 
				break; 
			case KeyEvent.VK_SPACE: 
				beginGame(); 
				break; 
			}
		}

		public void keyReleased(KeyEvent e) {

		}

		public void keyTyped(KeyEvent e) {
		}		
	}
}