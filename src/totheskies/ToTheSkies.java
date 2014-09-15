package totheskies;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class ToTheSkies extends BasicGame {
	
	private Image Background;

	public ToTheSkies(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		Background.draw(0,0);		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		Background = new Image("res/Background.jpg");
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		try {
			ToTheSkies game = new ToTheSkies("ToTheSkies");
			AppGameContainer appgc = new AppGameContainer(game);
			appgc.setMinimumLogicUpdateInterval(1000 / 60);
			appgc.setDisplayMode(800, 600, false);
			appgc.start();
	    	} catch (SlickException e) {
	    		e.printStackTrace();
	    	}
	}

}
