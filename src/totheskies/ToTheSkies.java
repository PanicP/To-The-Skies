package totheskies;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import totheskies.AsteroidLeft;


public class ToTheSkies extends BasicGame {
	
	public static final int GAME_HEIGHT = 600;
	public static final int GAME_WIDTH = 800;
	public static final float ASTEROIDLEFT_VX = -4;
	public static final float ASTEROIDRIGHT_VX = 4;
	public static final int ASTEROID_COUNT = 4;

	private Image Background;
	private Spaceship Spaceship;
	private SpaceshipAI SpaceshipAI;
	private AsteroidLeft[] AsteroidLeft;
	private AsteroidRight[] AsteroidRight;
	

	public ToTheSkies(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		Background.draw(0,0);
		Spaceship.draw();
		SpaceshipAI.draw();
		for (AsteroidLeft AsteroidLeft : AsteroidLeft) {
			AsteroidLeft.render();
		}
		for (AsteroidRight AsteroidRight : AsteroidRight) {
			AsteroidRight.render();
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		Background = new Image("res/Background.jpg");
		Spaceship = new Spaceship(360,480);
		SpaceshipAI = new SpaceshipAI(360,50);
		initAsteroidLeft();
		initAsteroidRight();
	}

	private void initAsteroidLeft() throws SlickException {
		AsteroidLeft = new AsteroidLeft[ASTEROID_COUNT];
	    for (int i = 0; i < ASTEROID_COUNT; i++) {
	    	AsteroidLeft[i] = new AsteroidLeft (220*i, GAME_HEIGHT/2, ASTEROIDLEFT_VX);
	    }
	}

	private void initAsteroidRight() throws SlickException {
		AsteroidRight = new AsteroidRight[ASTEROID_COUNT];
	    for (int i = 0; i < ASTEROID_COUNT; i++) {
	    	AsteroidRight[i] = new AsteroidRight (600 + (-220)*i, GAME_HEIGHT/2, ASTEROIDRIGHT_VX);
	    }
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
	    for (int i = 0; i < ASTEROID_COUNT; i++) {
	    	AsteroidLeft[i].update();
	    }
	    for (int i = 0; i < ASTEROID_COUNT; i++) {
	    	AsteroidRight[i].update();
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
