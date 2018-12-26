package menu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import controleDeJogo.Jogo;
import menu.Menu;

public class Dialogo extends BasicGameState{
	
	Image dialog;
	Image olho;
	Image tranca;
	
	Image[] botoes;
	
	public Dialogo(int state) {
		
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		dialog = new Image("res/images/dialogo/IndiferencaDialogo1.png");
		
		/**botoes = new Image[]{
				new Image("res/images/menu/opções/opçoes1.png"),
				new Image("res/images/menu/sair/sair1.png"),
				new Image("res/images/menu/tutorial/tutorial0.png"),
				new Image("res/images/menu/sobre/sobre1.png"),
				new Image("res/images/menu/creditos/creditos1.png"),
				}; **/
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		// TODO Auto-generated method stub
		dialog.draw(220,0);
				
		/**botoes[0].draw(302,559);
		botoes[1].draw(341, 559);
		botoes[2].draw(374, 547);
		botoes[3].draw(431, 559);
		botoes[4].draw(470,559);**/
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
		Menu.closeOpening();
		
		sbg.enterState(Jogo.menuToPlayB, new FadeOutTransition(), new FadeInTransition());
		
		sbg.getState(Jogo.dialogo).leave(gc, sbg);
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Jogo.menuToPlayA;
	}

}
