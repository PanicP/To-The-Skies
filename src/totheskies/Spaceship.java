package totheskies;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Spaceship {
	private Image image;
	private int x;
	private int y;
	
	public Spaceship(int x,int y) throws SlickException {
		image = new Image("res/Spaceship.png");
		this.x = x;
		this.y = y;
	}

	public void draw() {
		image.draw(x,y);
		
	}

	public void moveLeft() {
		this.x -= 8;		
	}

	public void moveRight() {
		this.x += 8;	
	}
}
