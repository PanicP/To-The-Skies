package totheskies;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Spaceship implements Entity {
	private Image image;
	private int x;
	private int y;
	
	public Spaceship(int x,int y) throws SlickException {
		image = new Image("res/Spaceship.png");
		this.x = x;
		this.y = y;
	}

	public void moveLeft() {
		this.x -= 8;
		update();
	}

	public void moveRight() {
		this.x += 8;	
		update();
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void update() {
		
		if (x < 80) {
			x = 80;
		}
		if (x > 640) {
			x = 640;
		}
	}

	@Override
	public void render() {
		image.draw(x,y);
	}

	@Override
	public void update(GameContainer container, int delta) {
		// TODO Auto-generated method stub
		
	}
	public boolean isCollide(BulletAI b) {
		if (b.getX()-x+80 > 80 && b.getX()-x+80 < 160 && b.getY()-y+70 > 60 && b.getY()-y+70 < 140) {
					return true;
					}
		return false;
	}
}
