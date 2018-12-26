package menu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import controleDeJogo.Jogo;

public class Creditos extends BasicGameState {

	Image fundoCreditos, fundoCreditosEN;
	
	public Creditos(int state) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		fundoCreditos = new Image("res/images/menu/Créditos.png");
		fundoCreditosEN = new Image("res/images/menu/CreditosEN.png");
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		if(Jogo.idioma.equals("Português")) {
			//g.drawString("Sobre os desenvolvedores", 10, 30);
			fundoCreditos.draw();
		}
		
		else if(Jogo.idioma.equals("Inglês")) {
			//g.drawString("About the Developers", 10, 30);
			fundoCreditosEN.draw();
		}
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {		
	
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_ESCAPE)) {
			sbg.enterState(Jogo.menu);
			sbg.getState(Jogo.creditos).leave(gc, sbg);
			//Menu.musica.loop();
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Jogo.creditos;
	}

	
	
}
