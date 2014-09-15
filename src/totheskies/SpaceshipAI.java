package totheskies;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpaceshipAI {
	private Image image;
	private int x;
	private int y;
	
	public SpaceshipAI(int x,int y) throws SlickException {
		image = new Image("res/SpaceshipAI.png");
		this.x = x;
		this.y = y;
	}

	public void draw() {
		image.draw(x,y);
		
	}
}