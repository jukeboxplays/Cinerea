package menu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import controleDeJogo.Jogo;

public class SobreOJogo extends BasicGameState{
	
	Image fundoSobreJogo, fundoSobreJogoEN;
	
	public SobreOJogo(int state) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		fundoSobreJogo = new Image("res/images/menu/SobreOJogo.png");
		fundoSobreJogoEN = new Image("res/images/menu/SobreOJogoEN.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		if(Jogo.idioma.equals("Português")) {
			//g.drawString("Sobre o Jogo", 10, 30);
			fundoSobreJogo.draw();
		}
		
		else if(Jogo.idioma.equals("Inglês")) {
			//g.drawString("About the Game", 10, 30);
			fundoSobreJogoEN.draw();
		}
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_ESCAPE)) {
			sbg.enterState(Jogo.menu);
			sbg.getState(Jogo.menuSobreOJogo).leave(gc, sbg);
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Jogo.menuSobreOJogo;
	}
	


}
