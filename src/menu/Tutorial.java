package menu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import controleDeJogo.Jogo;

public class Tutorial extends BasicGameState{

	Image fundoTutorial;
	
	public Tutorial(int state) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		fundoTutorial = new Image("res/images/menu/tutorial.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		//g.drawString("Tutorial", 10, 30);
		fundoTutorial.draw();
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_ESCAPE)) {
			sbg.enterState(Jogo.menu);
			sbg.getState(Jogo.tutorial).leave(gc, sbg);
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Jogo.tutorial;
	}

}
