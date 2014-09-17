package totheskies;

import org.newdawn.slick.GameContainer;

public interface Entity {
	void render ();
	void update (GameContainer container, int delta);
}
