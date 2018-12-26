package intermediarios;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import controleDeJogo.Jogo;
import controleDeJogo.VariaveisControle;
import gameplay.camera.Camera;
import gameplay.personagem.Protagonista;
import gameplay.salas.SalaA;

public class MenuToPlayB extends BasicGameState{
	
	Protagonista playerT;
	
	Image sala;
	
	int cont;
	
	
	public MenuToPlayB(int state) {
		
	}

	@Override
	public void init(GameContainer gc, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		
		playerT = new Protagonista(gc, 0, 0, "baixo");
		
		sala = new Image("res/images/fundo/IndCenarioVer4Zoom.png");
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		sala.draw(SalaA.camera.getTranslateX(), SalaA.camera.getTranslateY());
		playerT.setDirecao(SalaA.player.getDirecao());
		playerT.desenhar(g);
		
		cont++;
		g.drawString("cont: "+cont, 10, 10);
		
		System.out.println(playerT.getDirecao());
		System.out.println(SalaA.player.getDirecao());
		
		if(cont==30) {
			cont=0;
			sbg.enterState(Jogo.gameplay);
			sbg.getState(Jogo.menuToPlayB).leave(gc, sbg);
		}
		
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Jogo.menuToPlayB;
	}

}
