package intermediarios;

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

public class MenuToPlayA extends BasicGameState{
	
	Image porta;
	Image olho;
	Image tranca;
	
	Image[] botoes;
	
	public MenuToPlayA(int state) {
		
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		porta = new Image("res/images/menu/porta/porta.png");
		olho = new Image("res/images/menu/jogar/jogar19.png");
		tranca = new Image("res/images/menu/carregando/carregando21.png");
		
		botoes = new Image[]{
				new Image("res/images/menu/op��es/op�oes1.png"),
				new Image("res/images/menu/sair/sair1.png"),
				new Image("res/images/menu/tutorial/tutorial0.png"),
				new Image("res/images/menu/sobre/sobre1.png"),
				new Image("res/images/menu/creditos/creditos1.png"),
				};
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		// TODO Auto-generated method stub
		porta.draw(220,0);
		olho.draw(240,151);
		tranca.draw(220, 430); 
		
		botoes[0].draw(302,559);
		botoes[1].draw(341, 559);
		botoes[2].draw(374, 547);
		botoes[3].draw(431, 559);
		botoes[4].draw(470,559);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
		Menu.closeOpening();
		
		sbg.enterState(Jogo.dialogo, new FadeOutTransition(), new FadeInTransition());
		
		sbg.getState(Jogo.menuToPlayA).leave(gc, sbg);
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Jogo.menuToPlayA;
	}

}
