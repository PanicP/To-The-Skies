package totheskies;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class HPbar implements Entity{
	private Image image1;
	private Image image2;
	private Image image3;
	private Image image4;
	private Image image5;
	private Image image6;
	private Image image7;
	private Image image8;
	private Image image9;
	private Image image10;
	private float x;
	private float y;
	
	public HPbar(float x, float y) throws SlickException {
		image10 = new Image("res/HP10.png");
		image9 = new Image("res/HP9.png");
		image8 = new Image("res/HP8.png");
		image7 = new Image("res/HP7.png");
		image6 = new Image("res/HP6.png");
		image5 = new Image("res/HP5.png");
		image4 = new Image("res/HP4.png");
		image3 = new Image("res/HP3.png");
		image2 = new Image("res/HP2.png");
		image1 = new Image("res/HP1.png");
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void render() {
		if (ToTheSkies.HPcount == 10) {
			image10.draw(x,y);
		}
		if (ToTheSkies.HPcount == 9) {
			image9.draw(x,y+15);
		}
		if (ToTheSkies.HPcount == 8) {
			image8.draw(x,y+30);
		}
		if (ToTheSkies.HPcount == 7) {
			image7.draw(x,y+45);
		}
		if (ToTheSkies.HPcount == 6) {
			image6.draw(x,y+60);
		}
		if (ToTheSkies.HPcount == 5) {
			image5.draw(x,y+75);
		}
		if (ToTheSkies.HPcount == 4) {
			image4.draw(x,y+90);
		}
		if (ToTheSkies.HPcount == 3) {
			image3.draw(x,y+105);
		}
		if (ToTheSkies.HPcount == 2) {
			image2.draw(x,y+120);
		}
		if (ToTheSkies.HPcount == 1) {
			image1.draw(x,y+135);
		}
			
	}

	@Override
	public void update(GameContainer container, int delta) {
		
	}
}
