package totheskies;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class AsteroidRight {
	static public final int WIDTH = 80; 
	static public final int HEIGHT = 75;
	private Image AsteroidRight;
	private float x;
	private float y;
	private float vx;
	
	 public AsteroidRight(float x, float y, float vx) throws SlickException {
		 this.x = x;
		 this.y = y;
		 this.vx = vx;
		 AsteroidRight = new Image("res/AsteroidRight.png");		 
	 }
	 
	 public void render() {
		 AsteroidRight.draw(x - WIDTH/2, ToTheSkies.GAME_HEIGHT - (y - AsteroidLeft.ASTEROID_SPACE));
	 }
	 
	 public boolean isCollide(Bullet b) {
			if (Math.abs(b.getX()-x) < 39 && Math.abs(b.getY()-y-60) < 37) {
						return true;
						}
			return false;
	 }
	 
	 public boolean isCollide(BulletAI b) {
			if (Math.abs(b.getX()-x) < 39 && Math.abs(b.getY()-y)+25 < 37) {
						return true;
						}
			return false;
	 }

	 public void update() {
		 x += vx;
		 if (x == 800) {
			 x = -80;
		 }
	 }

}
