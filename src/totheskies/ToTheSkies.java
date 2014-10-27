package totheskies;

import java.util.ArrayList;
import java.util.LinkedList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import totheskies.AsteroidLeft;


public class ToTheSkies extends BasicGame {
	
	public static final int GAME_HEIGHT = 600;
	public static final int GAME_WIDTH = 800;
	public static final float ASTEROIDLEFT_VX = -4;
	public static final float ASTEROIDRIGHT_VX = 4;
	public static final float BULLET_VY = -6;
	public static final float BULLETAI_VY = 12;
	public static final int ASTEROID_COUNT = 4;
	public static final int HPBAR_X = 15 ;
	public static final int HPBAR_Y = 405 ;
	public static final int HPBARAI_X = 735 ;
	public static final int HPBARAI_Y = 25 ;
	public static int timer = 0 ;
	public static int timer1000 = 0;
	public static int HPcount = 10;
	public static int HPcountAI = 10;
	
	private Sound soundshoot;
	private Sound soundgothit;
	private Sound soundhitAI;
	private Music music;
	private Image background;
	private HP hp;
	private HPAI hpAI;
	private HPbar hpbar;
	private HPbarAI hpbarAI;
	private Spaceship spaceship;
	private SpaceshipAI spaceshipAI;
	private AsteroidLeft[] asteroidLeft;
	private AsteroidRight[] asteroidRight;
	private ArrayList<Bullet> bullet = new ArrayList<Bullet>();
	private ArrayList<BulletAI> bulletAI = new ArrayList<BulletAI>();
	private LinkedList<Entity> entities; 
	private int countCollide = 0;
	private boolean isStarted;
	//private boolean isGameOver;
	

	public ToTheSkies(String title) {
		super(title);
		entities = new LinkedList<Entity>();
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		background.draw(0,0);
		for (Entity entity : entities) {
			entity.render();
		}
		for (Bullet bullets : bullet) {
			bullets.render();
		}
		for (BulletAI bulletsAI : bulletAI) {
			bulletsAI.render();
		}
		for (AsteroidLeft AsteroidsLeft : asteroidLeft) {
			AsteroidsLeft.render();
		}
		for (AsteroidRight AsteroidsRight : asteroidRight) {
			AsteroidsRight.render();
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		background = new Image("res/Background.jpg");
		music = new Music("res/SpaceSoundTrack.ogg");
		music.loop();
		music.setVolume(4.0f);
		soundshoot = new Sound("res/shoot.ogg");
		soundgothit = new Sound("res/gothit.ogg");
		soundhitAI = new Sound("res/hitAI.ogg");
		hp = new HP(HPBAR_X,HPBAR_Y);
		hpAI = new HPAI(HPBARAI_X,HPBARAI_Y);
		hpbar = new HPbar(HPBAR_X + 10,HPBAR_Y + 10);
		hpbarAI = new HPbarAI(HPBARAI_X + 10,HPBARAI_Y + 10);
		spaceship = new Spaceship(360,480);
		spaceshipAI = new SpaceshipAI(360,50,0);
		entities.add(hp);
		entities.add(hpAI);
		entities.add(hpbar);
		entities.add(hpbarAI);
		entities.add(spaceship);
		entities.add(spaceshipAI);
		initAsteroidLeft();
		initAsteroidRight();
	}

	private void initAsteroidLeft() throws SlickException {
		asteroidLeft = new AsteroidLeft[ASTEROID_COUNT];
	    for (int i = 0; i < ASTEROID_COUNT; i++) {
	    	asteroidLeft[i] = new AsteroidLeft (220*i, GAME_HEIGHT/2, ASTEROIDLEFT_VX);
	    }
	}

	private void initAsteroidRight() throws SlickException {
		asteroidRight = new AsteroidRight[ASTEROID_COUNT];
	    for (int i = 0; i < ASTEROID_COUNT; i++) {
	    	asteroidRight[i] = new AsteroidRight (600 + (-220)*i, GAME_HEIGHT/2, ASTEROIDRIGHT_VX);
	    }
	}
	
	@Override
	public void keyPressed(int key, char c) { 
		if (key == Input.KEY_ENTER) {
			isStarted = true;
		}
		if (key == Input.KEY_Z || key == Input.KEY_X) {			
			try {
				bullet.add(new Bullet(spaceship.getX()+35,spaceship.getY()-10,BULLET_VY));
				soundshoot.play();
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
	/*public  void reset() throws SlickException{
		if (isStarted == true){
			hp = new HP(HPBAR_X,HPBAR_Y);
			hpAI = new HPAI(HPBARAI_X,HPBARAI_Y);
			hpbar = new HPbar(HPBAR_X + 10,HPBAR_Y + 10);
			hpbarAI = new HPbarAI(HPBARAI_X + 10,HPBARAI_Y + 10);
			spaceship = new Spaceship(360,480);
			spaceshipAI = new SpaceshipAI(360,50,0);
			entities.add(hp);
			entities.add(hpAI);
			entities.add(hpbar);
			entities.add(hpbarAI);
			entities.add(spaceship);
			entities.add(spaceshipAI);
			initAsteroidLeft();
			initAsteroidRight();
		//isGameOver = false ;
		}
	}*/

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		//if(!isGameOver)
		//{
			if (isStarted == true) {
				timer += delta ;
				timer1000 = timer/1000;
				spaceshipAI.update();
		//timer1000 += 1;
		//System.out.println(timer);
		//if (timer1000 >= 1000) {
			//timer1000 = 0;
			//System.out.println(timer/1000);
		//}
				if (input.isKeyDown(Input.KEY_LEFT)) {
					spaceship.moveLeft();
				}
				if (input.isKeyDown(Input.KEY_RIGHT)) {
					spaceship.moveRight();
				}
	    
				for (int i = 0; i < ASTEROID_COUNT; i++) {
					asteroidLeft[i].update();
				}
				for (int i = 0; i < ASTEROID_COUNT; i++) {
					asteroidRight[i].update();
				}
				for (Entity entity : entities) {
					entity.update(container, delta);
				}
	    
				for (Bullet bullets : bullet) {
					bullets.update(container, delta);
				}
				for (BulletAI bulletsAI : bulletAI) {
					bulletsAI.update(container, delta);
				}
				if (timer % 7 == 0 && timer > 1000) {
					bulletAI.add(new BulletAI(spaceshipAI.getX()+38,spaceshipAI.getY()+63,BULLETAI_VY));
				}
				for (int i = 0 ; i < ASTEROID_COUNT ; i++) {
					for (int j = 0 ; j < bullet.size() ; j++) {
						Bullet temp = bullet.get(j);
						if (asteroidLeft[i].isCollide(temp)) {
							System.out.println("COllide" + countCollide);
							countCollide++;
							bullet.remove(j);
						}
						if (asteroidRight[i].isCollide(temp)) {
							System.out.println("COllide" + countCollide);
							countCollide++;
							bullet.remove(j);
						}
					}
				}
				for (int j = 0 ; j < bullet.size() ; j++) {
					Bullet temp = bullet.get(j);
					if (spaceshipAI.isCollide(temp)) {
						System.out.println("COllide" + countCollide);
						countCollide++;
						HPcountAI--;
						bullet.remove(j);
						soundhitAI.play();
					}	
				}
	    
				for (int f = 0 ; f < ASTEROID_COUNT ; f++) {
					for (int e = 0 ; e < bulletAI.size() ; e++) {
						BulletAI tempAI = bulletAI.get(e);
						if (asteroidLeft[f].isCollide(tempAI)) {
							System.out.println("COllide" + countCollide);
							countCollide++;
							bulletAI.remove(e);
						}
						if (asteroidRight[f].isCollide(tempAI)) {
							System.out.println("COllide" + countCollide);
							countCollide++;
							bulletAI.remove(e);
						}
					}
				}
				for (int k = 0 ; k < bulletAI.size() ; k++) {
					BulletAI tempAI = bulletAI.get(k);
					if (spaceship.isCollide(tempAI)) {
						System.out.println("COllide" + countCollide);
						countCollide++;
						HPcount--;
						bulletAI.remove(k);
						soundgothit.play();
					}
				}
				if (HPcount == 0 || HPcountAI == 0)
				{
					isStarted = false;
					//isGameOver = true;
				}
			}
		}
		//initBulletAI();
	//}

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
