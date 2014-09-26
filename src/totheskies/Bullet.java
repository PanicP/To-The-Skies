package totheskies;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bullet implements Entity{
	
	public static final int BULLET_SPEED = 4;
	private Image image;
	private float x;
	private float y;
	private float vy;
	
	public Bullet(float x, float y, float vy) throws SlickException {
		image = new Image("res/Bullet.png");
		this.x = x;
		this.y = y;
		this.vy = vy;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}

	@Override
	public void render() {
		image.draw(x,y);
		
	}
	

	@Override
	public void update(GameContainer container, int delta) {
		y += vy;
	//	for (AsteroidLeft AsteroidsLeft : ToTheSkies.asteroidLeft) {
	//		if (x <= AsteroidsLeft.getX() + 80 && x >= AsteroidsLeft.getX() && y <= AsteroidsLeft.getY() + 75 && y >= AsteroidsLeft.getY()) {
	//			System.out.println("Collide!");
	//		}
	//	}
	}
}
