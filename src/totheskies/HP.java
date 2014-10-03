package totheskies;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class HP implements Entity{
	private Image image;
	private float x;
	private float y;
	
	public HP(float x, float y) throws SlickException {
		image = new Image("res/HPbar.png");
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void render() {
		image.draw(x,y);		
	}

	@Override
	public void update(GameContainer container, int delta) {
		// TODO Auto-generated method stub
		
	}
}
