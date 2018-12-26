package gameplay.personagem;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import controleDeJogo.VariaveisControle;
public class Protagonista {
	
	public int protagonistaX;
	public int protagonistaY;
	public int falhou = 0;
	
	public Rectangle hitbox;
	public float hitboxX, hitboxY;
	
	boolean seMexendo = false;
	public String direcao;
	
	private int velocidade = VariaveisControle.velocidade;
	
	Animation andandoDireita, andandoEsquerda, andandoBaixo, andandoCima, idleDireita, 
	idleEsquerda, idleBaixo, idleCima;
	
	public Protagonista(GameContainer gc, int indiceInicialX, int indiceInicialY, String dire) throws SlickException{
		Image[] andD = {
			new Image("res/images/jogador/indiferençaAndandoSprites/direito/direita1.png"),
			new Image("res/images/jogador/indiferençaAndandoSprites/direito/direita2.png"),
			new Image("res/images/jogador/indiferençaAndandoSprites/direito/direita3.png"),
			new Image("res/images/jogador/indiferençaAndandoSprites/direito/direita4.png"),
			new Image("res/images/jogador/indiferençaAndandoSprites/direito/direita5.png"),
			new Image("res/images/jogador/indiferençaAndandoSprites/direito/direita6.png"),
			new Image("res/images/jogador/indiferençaAndandoSprites/direito/direita7.png"),
			new Image("res/images/jogador/indiferençaAndandoSprites/direito/direita8.png"),
			new Image("res/images/jogador/indiferençaAndandoSprites/direito/direita9.png"),
			new Image("res/images/jogador/indiferençaAndandoSprites/direito/direita10.png"),
		};
		
		Image[] andE = {
				new Image("res/images/jogador/indiferençaAndandoSprites/esquerdo/esquerda1.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/esquerdo/esquerda2.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/esquerdo/esquerda3.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/esquerdo/esquerda4.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/esquerdo/esquerda5.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/esquerdo/esquerda6.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/esquerdo/esquerda7.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/esquerdo/esquerda8.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/esquerdo/esquerda9.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/esquerdo/esquerda10.png"),
		};
		
		Image[] andF = {
				new Image("res/images/jogador/indiferençaAndandoSprites/frente/frente1.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/frente/frente2.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/frente/frente3.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/frente/frente4.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/frente/frente5.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/frente/frente6.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/frente/frente7.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/frente/frente8.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/frente/frente9.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/frente/frente10.png"),
		};
		
		Image[] andT = {
				new Image("res/images/jogador/indiferençaAndandoSprites/trás/trás1.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/trás/trás2.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/trás/trás3.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/trás/trás4.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/trás/trás5.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/trás/trás6.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/trás/trás7.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/trás/trás8.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/trás/trás9.png"),
				new Image("res/images/jogador/indiferençaAndandoSprites/trás/trás10.png"),
		};
		
		Image[] idD = {
				new Image("res/images/jogador/indiferençaIdleSprites/direitoIdle/direitoIdle1.png"),
				new Image("res/images/jogador/indiferençaIdleSprites/direitoIdle/direitoIdle2.png"),
				new Image("res/images/jogador/indiferençaIdleSprites/direitoIdle/direitoIdle3.png"),
				new Image("res/images/jogador/indiferençaIdleSprites/direitoIdle/direitoIdle4.png"),
		};
		
		Image[] idE = {
				new Image("res/images/jogador/indiferençaIdleSprites/esquerdoIdle/esquerdoIdle1.png"),
				new Image("res/images/jogador/indiferençaIdleSprites/esquerdoIdle/esquerdoIdle2.png"),
				new Image("res/images/jogador/indiferençaIdleSprites/esquerdoIdle/esquerdoIdle3.png"),
				new Image("res/images/jogador/indiferençaIdleSprites/esquerdoIdle/esquerdoIdle4.png"),
		};
		
		Image[] idF = {
				new Image("res/images/jogador/indiferençaIdleSprites/frenteIdle/frenteIdle1.png"),
				new Image("res/images/jogador/indiferençaIdleSprites/frenteIdle/frenteIdle2.png"),
				new Image("res/images/jogador/indiferençaIdleSprites/frenteIdle/frenteIdle3.png"),
				new Image("res/images/jogador/indiferençaIdleSprites/frenteIdle/frenteIdle4.png")
		};
		
		Image[] idT = {
				new Image("res/images/jogador/indiferençaIdleSprites/trásIdle/trásIdle1.png"),
				new Image("res/images/jogador/indiferençaIdleSprites/trásIdle/trásIdle2.png"),
				new Image("res/images/jogador/indiferençaIdleSprites/trásIdle/trásIdle3.png"),
				new Image("res/images/jogador/indiferençaIdleSprites/trásIdle/trásIdle4.png"),
		};
		
		int[] duracaoIdle = new int[idF.length];
		int[] duracaoAndando = new int[andF.length];
		
		for(int i=0; i<idF.length;i++) {
			duracaoIdle[i] = 90;
		}
		
		for(int i=0; i<andF.length;i++) {
			duracaoAndando[i] = 90;
		}
		
		
		andandoDireita = new Animation(andD, duracaoAndando);
		//andandoDireita.stopAt(9);
		andandoEsquerda = new Animation(andE, duracaoAndando);
		andandoBaixo = new Animation(andF, duracaoAndando);
		andandoCima = new Animation(andT, duracaoAndando);
		
		idleDireita = new Animation(idD, duracaoIdle);
		idleEsquerda = new Animation(idE, duracaoIdle);
		idleBaixo = new Animation(idF, duracaoIdle);
		idleCima = new Animation(idT, duracaoIdle);
		
		protagonistaX = 338 + indiceInicialX;//(gc.getWidth()/2)-(idF[0].getWidth()/2);
		protagonistaY = 225 + indiceInicialY;//(gc.getHeight()/2)-(idF[0].getHeight()/2);
		
		direcao = dire;
		
		hitbox = new Rectangle(protagonistaX+40, protagonistaY+100, 46, idF[0].getHeight()-100);
	
		hitboxX = hitbox.getX();
		hitboxY = hitbox.getY();
	}
	
	
	public void desenhar(Graphics g) {
		if(direcao.equals("baixo")) { // Se a dorecao que o personagem apontar for baixo
			if(seMexendo==false) {// Se nao estiver se mexendo
				idleBaixo.draw(protagonistaX, protagonistaY); // Desenhe a animacao dele ocioso na direcao especificada, nas 
				// posições protagonistaX e protagonistaY
			}
			
			else { // Se não estiver se mexendo
				andandoBaixo.draw(protagonistaX, protagonistaY); // Desenhe a animacao dele se mexendo na direcao especificada, nas
				// posiçoes protagonistaX e protagonistaY que sao determinadas pela 
				// iteracao atual do loop infinito do slick 
			}
		}
		
		else if(direcao.equals("cima")) {
			if(seMexendo==false) {
				idleCima.draw(protagonistaX, protagonistaY);
			}
			
			else {
				andandoCima.draw(protagonistaX, protagonistaY);
			}
		}
		
		else if(direcao.equals("direita")) {
			if(seMexendo==false) {
				idleDireita.draw(protagonistaX, protagonistaY);
			}
			
			else {
				andandoDireita.draw(protagonistaX, protagonistaY);
			}
		}
		
		else if(direcao.equals("esquerda")) {
			if(seMexendo==false) {
				idleEsquerda.draw(protagonistaX, protagonistaY);
			}
			
			else {
				andandoEsquerda.draw(protagonistaX, protagonistaY);
			}
		}
		
		g.setColor(Color.red);
		g.draw(hitbox);
		//System.out.println(hitboxY);
	}
	
	
	public void atualizar(GameContainer gc) {
		
		// Cada sala vai passar para esse método como parâmetro todas as suas variáveis
		// colisaoBaixo, colisaoCima, colisaoDireita e colisaoEsquerda, nesta ordem, na forma de um array de
		// variáveis booleanas, sendo assim, o primeiro elemento do array de parâmetro deste método "colisoes"
		// vai ser a variável colisaoBaixo da sala correspondente, ou seja, colisoes[0] é o mesmo que colisaoBaixo
		
		//Sendo assim:
		
		// colisoes[1] é o mesmo que colisaoCima
		// colisoes[2] é o mesmo que colisaoDireita
		// colisoes[3] é o mesmo que colisaoEsquerda
		
		
		
		Input input = gc.getInput(); 
		
		if(input.isKeyDown(Input.KEY_DOWN)) { // Se apertar para baixo
			direcao = "baixo"; // Faz o personagem se virar para baixo
			seMexendo = true; // Ele vai estar se mexendo
			
			if(protagonistaY < 9925) {
				protagonistaY += velocidade; // O personagem muda a posição Y
				
				hitbox.setX(protagonistaX+40);
				hitbox.setY(protagonistaY+100);
			}
			
		}
		
		else if(input.isKeyDown(Input.KEY_UP)) {
			direcao = "cima";
			seMexendo = true;
			
			if(protagonistaY>320) {
				protagonistaY -= velocidade;
				
				hitbox.setX(protagonistaX+40);
				hitbox.setY(protagonistaY+100);
			}
			
		}
		
		else if(input.isKeyDown(Input.KEY_RIGHT)) {
			direcao = "direita";
			seMexendo = true;
			
			if(protagonistaX<2623) {
				protagonistaX += velocidade;
				
				hitbox.setX(protagonistaX+60);
				hitbox.setY(protagonistaY+100);
			}
			
			
			//hitbox.setWidth(46);
		}
		
		else if(input.isKeyDown(Input.KEY_LEFT)) {
			direcao = "esquerda";
			seMexendo = true;
			
			if(protagonistaX>440) {
				protagonistaX -= velocidade;
				hitbox.setX(protagonistaX+15);
				hitbox.setY(protagonistaY+100);
			}
			
			
			//hitbox.setWidth(46);
		}
		
		else {
			seMexendo = false;
		}
		
		if(!seMexendo&&direcao.equals("esquerda")) {
			hitbox.setX(protagonistaX+5);
		}
		/**hitbox.setX(protagonistaX);
		hitbox.setY(protagonistaY+100);**/
		
	}
	
	// GETTERS E SETTERS ÚTEIS
	
	public boolean getSeMexendo() { // Pegar a variável que diz se o personagem esta se movimentando
		return seMexendo;
	}
	
	public String getDirecao() { // Pegar a direcao pelo qual o personagem esta apontando
		return direcao;
	}
	
	public void setDirecao(String dir) { // Modificar a direcao pelo qual o personagem esta apontando
		direcao = dir;
	}
	
	public int getProtagonistaX() { // Pegar a posicao X do personagem
		return protagonistaX;
	}
	
	public void setProtagonistaX(int x) { // Modificar a posicao X do personagem
		protagonistaX = x;
	}
	
	public int getProtagonistaY() { // Pegar a posicao Y do personagem
		return protagonistaY;
	}
	
	public void setProtagonistaY(int y) { // Modificar a posicao Y do personagem
		protagonistaY = y;
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}

	public int getFalhou() { // Pegar a direcao pelo qual o personagem esta apontando
		return falhou;
	}
	
}


