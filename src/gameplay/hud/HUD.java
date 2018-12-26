package gameplay.hud;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import controleDeJogo.VariaveisControle;
import gameplay.personagem.Protagonista;
import gameplay.salas.SalaA;
import menu.Menu;

public class HUD {
	
	int fpsX, fpsY;
	int mousepX, mousepY;
	int hudPX, hudPY;
	int hudTX, hudTY;
	int hudRX, hudRY;
	int hudDX, hudDY;
	String mousep;
	
	private int velocidade = VariaveisControle.velocidade;
	
	public HUD(int indiceInicialX, int indiceInicialY, Protagonista player) {
		
		fpsX = 10+indiceInicialX;
		fpsY = 10+indiceInicialY;
		mousepX = 50+indiceInicialX; 
		mousepY = 80+indiceInicialY;
		hudPX = 50+indiceInicialX; 
		hudPY = 130+indiceInicialY;
		hudTX = 50+indiceInicialX; 
		hudTY = 180+indiceInicialY;
		hudRX = 10+indiceInicialX; 
		hudRY = 30+indiceInicialY;
		hudDX = 50+indiceInicialX;
		hudDY = 230+indiceInicialY;
	}
	
	public void desenhar(Graphics g, GameContainer gc, Protagonista player,
			int translateX, int translateY) {
		
		g.drawString("Recorde: "+VariaveisControle.yRecorde+" pixels na Y", hudRX, hudRY);
		
		g.setColor(Color.red);
		
		g.drawString("FPS: "+gc.getFPS(), fpsX, fpsY);
		
		g.drawString("Personagem X: "+player.getProtagonistaX()+" Personagem Y: "+player.getProtagonistaY(), hudPX, hudPY);
		
		//g.drawString(mousep, mousepX, mousepY); // Usa a caneta mágica para escrever a posição do mouse
		// na tela, com a cor que colocamos na caneta
	
		g.drawString("TranslateX: "+ translateX + " TranslateY: "+ translateY, hudTX, hudTY);
		
		g.drawString("FALHOU: " + player.getFalhou(), hudDX, hudDY);
		
	}
	
	public void atualizar(Protagonista player) {
		
		/**System.out.println("fpsX: "+fpsX+" / fpsY: "+ fpsY);
		System.out.println("mousepX: "+mousepX+" / mousepY: "+mousepY);
		System.out.println("hudPX: "+hudPX+" / hudPY: "+hudPY);
		System.out.println("hudTX: "+hudTX+" / hudTY: "+hudTY);**/
		
		int mouseX = Mouse.getX(); // Variável com a posição X do Mouse
		int mouseY = Mouse.getY(); // Variável com a posição Y do Mouse
		
		mousep = "Mouse X: "+mouseX+" -- Mouse Y: "+mouseY; // Aqui a variável "mousep", que foi
		// inicializada no início da classe, recebe as coordenadas do mouse em forma de String
		// concatenada com variáveis int (mas que acabam virando string por conta do tipo da 
		// variável "mousep" ser do tipo String
		
		
		if(player.getSeMexendo()) {
			if(player.getDirecao().equals("baixo") && fpsY<9715) {
				fpsY += velocidade;
				mousepY += velocidade;
				hudPY += velocidade;
				hudTY += velocidade;
				hudRY += velocidade;
				hudDY += velocidade;
				
			}
			
			else if(player.getDirecao().equals("cima") && fpsY>105) {
				fpsY -= velocidade;
				mousepY -= velocidade;
				hudPY -= velocidade;
				hudTY -= velocidade;
				hudRY -= velocidade;
				hudDY -= velocidade;
			}
			
			else if(player.getDirecao().equals("direita") && fpsX<2295) {
				fpsX += velocidade;
				mousepX += velocidade;
				hudPX += velocidade;
				hudTX += velocidade;
				hudRX += velocidade;
				hudDX += velocidade;
			}
			
			else if(player.getDirecao().equals("esquerda") && fpsX>105) {
				fpsX -= velocidade;
				mousepX -= velocidade;
				hudPX -= velocidade;
				hudTX -= velocidade;
				hudRX -= velocidade;
				hudDX -= velocidade;
			}
		}
	
	
	}
	
	public void setHudX(int x) {
		fpsX = x;
		hudRX = x;
		mousepX = x+40;
		hudPX = x+40;
		hudTX = x+40;
		hudDX = x+40;
	}
	
	public void setHudY(int y) {
		fpsY = y;
		hudRY = y+20;
		mousepY = y+70;
		hudPY = y+120;
		hudTY = y+170;
		hudDY = y+220;
	}

}
