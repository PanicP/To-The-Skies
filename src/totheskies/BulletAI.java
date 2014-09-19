package totheskies;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BulletAI implements Entity {
	private Image image;
	private float x;
	private float y;
	private float vy;
	
	public BulletAI(float x, float y, float vy) throws SlickException {
		image = new Image("res/BulletAI.png");
		this.x = x;
		this.y = y;
		this.vy = vy;
	}

	@Override
	public void render() {
		image.draw(x,y);
		
	}

	@Override
	public void update(GameContainer container, int delta) {
		y += vy;
		
	}

}
