package totheskies;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class AsteroidLeft {
	static public final int WIDTH = 80; 
	static public final int HEIGHT = 75;
	static public final int ASTEROID_SPACE = 10;
	private Image AsteroidLeft;
	private float x;
	private float y;
	private float vx;
	
	 public AsteroidLeft(float x, float y, float vx) throws SlickException {
		 this.x = x;
		 this.y = y;
		 this.vx = vx;
		 AsteroidLeft = new Image("res/AsteroidLeft.png");		 
	 }
	 
	 public void render() {
		 AsteroidLeft.draw(x - WIDTH/2, ToTheSkies.GAME_HEIGHT - (y + HEIGHT + ASTEROID_SPACE));
	 }
	 public float getX() {
		return x;
	 }
		
	 public float getY() {
		return y;
	 }


	 public void update() {
		 x += vx;
		 if (x == -80) {
			 x = 800;
		 }
	 }
	 public boolean isCollide(Bullet b) {
			if (Math.abs(b.getX()-x) < 39 && Math.abs(b.getY()-y + 55) < 37) {
					return true;
				}
			return false;
	 }
	 
	 public boolean isCollide(BulletAI b) {
		 	if (Math.abs(b.getX()-x) < 39 && Math.abs(b.getY()-y+65) < 37) {
		 			return true;
				}
		 	return false;
	 }
}
