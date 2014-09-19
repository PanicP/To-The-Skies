package totheskies;

import java.util.LinkedList;

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
	public static final float BULLET_VY = -6;
	public static final float BULLETAI_VY = 6;
	public static final int ASTEROID_COUNT = 4;
	public static int timer = 0 ;
	public static int timer1000 = 0;
	private int Bullet_Number = 0 ;
	private int BulletAI_Number = 0 ;
	private Image Background;
	private Spaceship Spaceship;
	private SpaceshipAI SpaceshipAI;
	private AsteroidLeft[] AsteroidLeft;
	private AsteroidRight[] AsteroidRight;
	private Bullet[] bullet;
	private BulletAI[] bulletAI;
	private LinkedList<Entity> entities;
	private int CheckBulletAIWithTimer; 

	public ToTheSkies(String title) {
		super(title);
		entities = new LinkedList<Entity>();
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		Background.draw(0,0);
		for(Entity entity : entities) {
			entity.render();
		}
		
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
		SpaceshipAI = new SpaceshipAI(360,50,0);
		bullet = new Bullet[100];
		bulletAI = new BulletAI[100];
		entities.add(Spaceship);
		entities.add(SpaceshipAI);
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
	public void keyPressed(int key, char c) { 
		if (key == Input.KEY_Z || key == Input.KEY_X) {
			if(Bullet_Number == 100){
				Bullet_Number = 0;
			}
				try {
					bullet[Bullet_Number] = new Bullet(Spaceship.getX() + 35,Spaceship.getY() - 10,BULLET_VY);
				} catch (SlickException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			entities.add(bullet[Bullet_Number]);
			Bullet_Number++;
			//System.out.println(Bullet_Number);
		}
		if (key == Input.KEY_Q || key == Input.KEY_W) {
			if(BulletAI_Number == 100){
				BulletAI_Number = 0;
			}
				try {
					bullet[BulletAI_Number] = new Bullet(SpaceshipAI.getX(),SpaceshipAI.getY(),BULLETAI_VY);
				} catch (SlickException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				entities.add(bulletAI[BulletAI_Number]);
				BulletAI_Number++;
				//System.out.println(BulletAI_Number);
				
			}
		}
	

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		timer += delta ;
		timer1000 = timer/1000;
		//timer1000 += 1;
		//System.out.println(timer);
		//if (timer1000 >= 1000) {
			//timer1000 = 0;
			//System.out.println(timer/1000);
		//}
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
	    for (Entity entity : entities) {
	    	entity.update(container, delta);
	    }
	    SpaceshipAI.update();
		//initBulletAI();
	}

	//private void initBulletAI() {
	//	if(CheckBulletAIWithTimer < timer) {
			
			//CheckBulletAIWithTimer = timer;
	//	}
	
	
	public static void main(String[] args) {
		try {
			ToTheSkies game = new ToTheSkies("ToTheSkies");
			AppGameContainer appgc = new AppGameContainer(game);
			appgc.setMinimumLogicUpdateInterval(1000/60);
			appgc.setDisplayMode(800, 600, false);
			appgc.start();
	    	} catch (SlickException e) {
	    		e.printStackTrace();
	    	}
	}

}
