package gameplay.camera;

import org.newdawn.slick.Graphics;

import controleDeJogo.VariaveisControle;
import gameplay.personagem.Protagonista;

public class Camera {
	
	private int translateX;
	private int translateY;
	
	private int velocidade = VariaveisControle.velocidade;

	public Camera(int indiceInicialX, int indiceInicialY) {
		translateX = -indiceInicialX;
		translateY = -indiceInicialY;
	}
	
	public void seguirOJogador(Graphics g) {
		g.translate(translateX, translateY);
	}
	
	public void atualizar(Protagonista player) {
		
		if(player.getSeMexendo()) {
			if(player.getDirecao().equals("baixo") && translateY > -9700) {
				translateY -= velocidade;
			}
			
			else if(player.getDirecao().equals("cima") && translateY<-95) {
				translateY += velocidade;
			}
			
			else if(player.getDirecao().equals("direita") && translateX>-2285) {
				translateX -= velocidade;
			}
			
			else if(player.getDirecao().equals("esquerda") && translateX<-95) {
				translateX += velocidade;
			}
		}

	}
	
	public int getTranslateX() {
		return translateX;
	}
	
	public void setTranslateX(int x) {
		translateX = x;
	}
	
	public int getTranslateY() {
		return translateY;
	}
	
	public void setTranslateY(int y) {
		translateY = y;
	}
	
}
