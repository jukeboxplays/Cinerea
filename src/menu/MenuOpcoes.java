package menu;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import controleDeJogo.Jogo;

public class MenuOpcoes extends BasicGameState{

	private String mousep;
	
	private boolean noPortugues = false;
	
	private boolean noIngles = false;
	
	Image opcoesF;
	
	public MenuOpcoes(int state) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		opcoesF = new Image("res/images/menu/MenuOpcoes.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g) throws SlickException {
		g.drawString(mousep, 10, 30);
		
		opcoesF.draw();
		
		g.setColor(Color.black);
		
		
		// PORTUGUï¿½S
		if(Jogo.idioma.equals("Português")) {
			g.drawString("Menu de Opções", 50, 50);
			
			g.drawString("Idioma:", 50, 100);
			g.drawString("Português | Inglês", 50, 130);
			
			g.setLineWidth(4);
			
			if(noPortugues) {
				g.drawRect(48, 125, 85, 30);
			}
			
			else if(noIngles) {
				g.drawRect(155, 125, 60, 30);
			}
		}
		
		// INGLï¿½S
		else if(Jogo.idioma.equals("Inglês")) {
			g.drawString("Options Menu", 50, 50);
			
			g.drawString("Language:", 50, 100);
			g.drawString("Portuguese | English", 50, 130);
			
			g.setLineWidth(4);
			
			if(noPortugues) {
				g.drawRect(48, 125, 95, 30);
			}
			
			else if(noIngles) {
				g.drawRect(164, 125, 70, 30);
			}
		}
		
		
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();
		mousep = "X: "+mouseX+" Y: "+mouseY;
		
		if(input.isKeyDown(Input.KEY_ESCAPE)) {
			sbg.enterState(Jogo.menu);
			sbg.getState(Jogo.menuOpcoes).leave(gc, sbg);
		}
		
		
		// PORTUGUï¿½S
		if(Jogo.idioma.equals("Português")) {
			if((mouseX>51 && mouseX<133) && (mouseY>450 && mouseY<471)){
				noPortugues = true;
				
				if(input.isMouseButtonDown(0)) {
					Jogo.idioma = "Português";
				}
			}
			
			else if((mouseX>158 && mouseX<213) && (mouseY>450 && mouseY<471)){
				noIngles = true;
				
				if(input.isMouseButtonDown(0)) {
					Jogo.idioma = "Inglês";
				}
			}
			
			else {
				noPortugues = false;
				noIngles = false;
			}
		}
		
		// INGLï¿½S
		else if(Jogo.idioma.equals("Inglês")) {
			if((mouseX>51 && mouseX<133) && (mouseY>450 && mouseY<471)){
				noPortugues = true;
				
				if(input.isMouseButtonDown(0)) {
					Jogo.idioma = "Português";
				}
			}
			
			else if((mouseX>158 && mouseX<213) && (mouseY>450 && mouseY<471)){
				noIngles = true;
				
				if(input.isMouseButtonDown(0)) {
					Jogo.idioma = "Inglês";
				}
			}
			
			else {
				noPortugues = false;
				noIngles = false;
			}
		}
		
		
		
		
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Jogo.menuOpcoes;
	}

}
