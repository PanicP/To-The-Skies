package totheskies;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class ToTheSkies extends BasicGame {
	
	private Image Background;
	private Spaceship Spaceship;
	private SpaceshipAI SpaceshipAI;

	public ToTheSkies(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		Background.draw(0,0);
		Spaceship.draw();
		SpaceshipAI.draw();
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		Background = new Image("res/Background.jpg");
		Spaceship = new Spaceship(360,480);
		SpaceshipAI = new SpaceshipAI(360,50);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
	    if (input.isKeyDown(Input.KEY_LEFT)) {
	      Spaceship.moveLeft();
	    }
	    if (input.isKeyDown(Input.KEY_RIGHT)) {
	      Spaceship.moveRight();
	    }
		
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
