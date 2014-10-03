package totheskies;

import java.util.Random;
import java.util.Timer;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpaceshipAI implements Entity {
	private Image image;
	private int x;
	private int y;
	private int vx;
	private Random random = new Random();
	private int count = 2;
	private int Checkmove = 0;
	//private int checkrandom = 0;
	//private int checktime = 0;
	
	public SpaceshipAI(int x, int y, int vx) throws SlickException {
		image = new Image("res/SpaceshipAI.png");
		this.x = x;
		this.y = y;
		this.vx = vx;
	}

	public void update() {
		if (x < 80) {
			x = 80;
			this.vx = 2;
		}
		if (x > 640) {
			x = 640;
			this.vx = -2;
		}
		if(ToTheSkies.timer1000 % 1 == 0) {
			Checkmove = random.nextInt(2);
//			System.out.println("Timer: "+ToTheSkies.timer1000);
//			System.out.println("Count: "+count);
//			System.out.println("Checkmove: "+Checkmove);
			if(Checkmove == 1 && ToTheSkies.timer1000 == count) {
				this.vx = 2;	
				count += 1;
			}
			else if(Checkmove == 0 && ToTheSkies.timer1000 == count){
				this.vx = -2;	
				count += 1;
			}
			
		}
		//if (ToTheSkies.timer1000 % 2 == 0 && checktime == 0) {
			//checkrandom = random.nextInt(2);
			//checktime = 1;
		//}
		//else{
			//checktime = 0;
		//}
		//if(checkrandom == 0) {
			//this.x += 2;
		//}else if(checkrandom == 1) {
			//this.x -= 2;
		//}
		x += vx;
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
		// TODO Auto-generated method stub
		
	}
	
	public boolean isCollide(Bullet b) {
		if (b.getX()-x+80 > 80 && b.getX()-x+80 < 160 && b.getY()-y+70 > 70 && b.getY()-y+70 < 135) {
					return true;
					}
		return false;
	}
}