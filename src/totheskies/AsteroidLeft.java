package totheskies;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class AsteroidLeft {
	static public final int WIDTH = 80; 
	static public final int HEIGHT = 75;
	private Image AsteroidLeft;
	private float x;
	private float y;
	
	 public AsteroidLeft(float x, float y) throws SlickException {
		 this.x = x;
		 this.y = y;
		 AsteroidLeft = new Image("res/AsteroidLeft.png");
	 }
	 
	 public void render() {
		 AsteroidLeft.draw(x - WIDTH/2, ToTheSkies.GAME_HEIGHT - (y + 88));
	 }

}
