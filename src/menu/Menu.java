package menu;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import controleDeJogo.*;

import org.lwjgl.input.Mouse;
import threads.SoundPlayer;
// Classe do estado de menu

public class Menu extends BasicGameState{
	
	static Music musica;
	
	// Anima��es dos bot�es
	static Animation anOpcoesIn, anSairIn, anTutorialIn, anSobreIn, anCreditosIn;

	static Animation anJogarIn;
	static Animation anOpcoesOut, anSairOut, anTutorialOut, anSobreOut, anCreditosOut;

	static Animation anJogarOut;
	static Animation anTrancaAbrindo;
	
	public String mousep = "no";
	
	SoundPlayer sp;
	
	//public boolean mouseNoCursor = false;
	
	static boolean[] opcoes = {false, false, false, false, false, false}; /** Os valores desse array
	ficam true ou false dependendo de qual bot�o o mouse fica em cima. Por exemplo: o primeiro
	valor deste array esta associado ao bot�o que leva para o menu de op��es. Se o mouse estiver
	em cima do bot�o de op��es o primeiro valor deste array passa a valer true. Se o mouse n�o
	estiver em cima do bot�o do menu de op��es o primeiro valor deste array passa a valer false.
	E assim se procede com os outros bot�es
	**/
	
	static boolean[] iconesLigados = {false, false, false, false, false, false}; /** Este array diz se
	os bot�es est�o "ligados", ou seja, se eles est�o com uma anima��o de "acender" 
	(ficando branco) ou "apagar" (escurecendo).
	**/
	
	static boolean trancaAberta = false; /** Vari�vel que ir� valer "true" no momento que a tranca da
	porta precisar ser aberta
	**/
	
	Image porta, olho, iconOpcoes, iconSair, iconTutorial, iconSobre, iconCredito, tranca;
	/** Vari�veis Image que servir�o como imagens est�ticos dos bot�es escurecidos (quando o
	 * mouse n�o est� em cima deles.
	**/
	
	public Menu(int state) {
		
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

		// VETORES DE IMAGES (que ir�o para uma vari�vel Animation posteriormente)
		
		// BOT�O DO MENU DE OP��ES
		
		// Acendendo (Mouse em cima)
		Image[] imOpcoesIn = {
				new	Image("res/images/menu/op��es/op�oes1.png"),
				new	Image("res/images/menu/op��es/op�oes2.png"),
				new	Image("res/images/menu/op��es/op�oes3.png"),
				new	Image("res/images/menu/op��es/op�oes4.png"),
				new	Image("res/images/menu/op��es/op�oes5.png"),
				new	Image("res/images/menu/op��es/op�oes6.png"),
		};
		
		// Apagando (Tirando o mouse de cima)
		Image[] imOpcoesOut = {
				new	Image("res/images/menu/op��es/op�oes6.png"),
				new	Image("res/images/menu/op��es/op�oes5.png"),
				new	Image("res/images/menu/op��es/op�oes4.png"),
				new	Image("res/images/menu/op��es/op�oes3.png"),
				new	Image("res/images/menu/op��es/op�oes2.png"),
				new	Image("res/images/menu/op��es/op�oes1.png"),
		};
		
		// ARRAY DE DURA��O RELATIVO A ANIMA��O DO BOT�O DE OP��ES
		
		// Declaracao
		int[] duracaoOpcoes = new int[imOpcoesIn.length];
		
		// Atribui��o de valores
		for(int i=0;i<duracaoOpcoes.length;i++) {
			duracaoOpcoes[i]=80;
		}
		
		// BOT�O DE SAIR
		
		// Acendendo (Mouse em cima)
		Image[] imSairIn = {
				new Image("res/images/menu/sair/sair1.png"),
				new Image("res/images/menu/sair/sair2.png"),
				new Image("res/images/menu/sair/sair3.png"),
				new Image("res/images/menu/sair/sair4.png"),
				new Image("res/images/menu/sair/sair5.png"),
		};
		
		// Apagando (Tirando o mouse de cima)
		Image[] imSairOut = {
				new Image("res/images/menu/sair/sair5.png"),
				new Image("res/images/menu/sair/sair4.png"),
				new Image("res/images/menu/sair/sair3.png"),
				new Image("res/images/menu/sair/sair2.png"),
				new Image("res/images/menu/sair/sair1.png"),
		};
		
		// BOT�O DO TUTORIAL
		
		// Acendendo (Mouse em cima)
		Image[] imTutorialIn = {
				new Image("res/images/menu/tutorial/tutorial0.png"),
				new Image("res/images/menu/tutorial/tutorial1.png"),
				new Image("res/images/menu/tutorial/tutorial2.png"),
				new Image("res/images/menu/tutorial/tutorial3.png"),
				new Image("res/images/menu/tutorial/tutorial4.png")
		};
		
		// Apagando (Tirando o mouse de cima)
		Image[] imTutorialOut = {
				new Image("res/images/menu/tutorial/tutorial4.png"),
				new Image("res/images/menu/tutorial/tutorial3.png"),
				new Image("res/images/menu/tutorial/tutorial2.png"),
				new Image("res/images/menu/tutorial/tutorial1.png"),
				new Image("res/images/menu/tutorial/tutorial0.png")
		};
		
		// ARRAY DE DURA��O DOS BOT�ES DE TUTORIAL E DE SAIR
		
		// Declara��o
		int[] duracaoSairTuts = new int[imSairIn.length];
		
		// Atribui��o de valores
		for(int i=0;i<duracaoSairTuts.length;i++) {
			duracaoSairTuts[i] = 80;
		}
		
		// BOT�O DE "SOBRE O JOGO"
		
		// Acendendo (Mouse em cima)
		Image[] imSobreIn = {
				new Image("res/images/menu/sobre/sobre1.png"),
				new Image("res/images/menu/sobre/sobre2.png"),
				new Image("res/images/menu/sobre/sobre3.png"),
				new Image("res/images/menu/sobre/sobre4.png")
		};
		
		// Apagando (Tirando o mouse de cima)
		Image[] imSobreOut = {
				new Image("res/images/menu/sobre/sobre4.png"),
				new Image("res/images/menu/sobre/sobre3.png"),
				new Image("res/images/menu/sobre/sobre2.png"),
				new Image("res/images/menu/sobre/sobre1.png")
		};
		
		// BOT�O DOS CR�DITOS
		
		// Acendendo (Mouse em cima)
		Image[] imCreditosIn = {
				new Image("res/images/menu/creditos/creditos1.png"),
				new Image("res/images/menu/creditos/creditos2.png"),
				new Image("res/images/menu/creditos/creditos3.png"),
				new Image("res/images/menu/creditos/creditos4.png")
		};
		
		// Apagando (Tirando o mouse de cima)
		Image[] imCreditosOut = {
				new Image("res/images/menu/creditos/creditos4.png"),
				new Image("res/images/menu/creditos/creditos3.png"),
				new Image("res/images/menu/creditos/creditos2.png"),
				new Image("res/images/menu/creditos/creditos1.png")
		};
		
		// ARRAY DE DURA��O PARA OS BOT�ES RESTANTES (Exceto o bot�o Jogar)
		
		// Declara��o
		int[] duracao3 = new int[4];
		
		// Atribui��o de valores
		for(int i=0; i<duracao3.length; i++) {
			duracao3[i] = 80;
		};
		
		// BOT�O "JOGAR"
		
		// Acendendo (Mouse em cima)
		Image[] imJogarIn = {
				new Image("res/images/menu/jogar/jogar1.png"),
				new Image("res/images/menu/jogar/jogar2.png"),
				new Image("res/images/menu/jogar/jogar3.png"),
				new Image("res/images/menu/jogar/jogar4.png"),
				new Image("res/images/menu/jogar/jogar5.png"),
				new Image("res/images/menu/jogar/jogar6.png"),
				new Image("res/images/menu/jogar/jogar7.png"),
				new Image("res/images/menu/jogar/jogar8.png"),
				new Image("res/images/menu/jogar/jogar9.png"),
				new Image("res/images/menu/jogar/jogar10.png"),
				new Image("res/images/menu/jogar/jogar11.png"),
				new Image("res/images/menu/jogar/jogar12.png"),
				new Image("res/images/menu/jogar/jogar13.png"),
				new Image("res/images/menu/jogar/jogar14.png"),
				new Image("res/images/menu/jogar/jogar15.png"),
				new Image("res/images/menu/jogar/jogar16.png"),
				new Image("res/images/menu/jogar/jogar17.png"),
				new Image("res/images/menu/jogar/jogar18.png"),
				new Image("res/images/menu/jogar/jogar19.png")
		};
		
		// Apagando (Tirando o mouse de cima)S
		Image[] imJogarOut = {
				new Image("res/images/menu/jogar/jogar19.png"),
				new Image("res/images/menu/jogar/jogar18.png"),
				new Image("res/images/menu/jogar/jogar17.png"),
				new Image("res/images/menu/jogar/jogar16.png"),
				new Image("res/images/menu/jogar/jogar15.png"),
				new Image("res/images/menu/jogar/jogar14.png"),
				new Image("res/images/menu/jogar/jogar13.png"),
				new Image("res/images/menu/jogar/jogar12.png"),
				new Image("res/images/menu/jogar/jogar11.png"),
				new Image("res/images/menu/jogar/jogar10.png"),
				new Image("res/images/menu/jogar/jogar9.png"),
				new Image("res/images/menu/jogar/jogar8.png"),
				new Image("res/images/menu/jogar/jogar7.png"),
				new Image("res/images/menu/jogar/jogar6.png"),
				new Image("res/images/menu/jogar/jogar5.png"),
				new Image("res/images/menu/jogar/jogar4.png"),
				new Image("res/images/menu/jogar/jogar3.png"),
				new Image("res/images/menu/jogar/jogar2.png"),
				new Image("res/images/menu/jogar/jogar1.png")
		};
		
		// ARRAY DE DURA��O PARA O BOT�O JOGAR
		
		// Declara��o
		int[] duracaoJogar = new int[imJogarIn.length];
		
		// Atribui��o de valores
		for(int i=0; i<duracaoJogar.length; i++) {
			duracaoJogar[i] = 50;
		};
		
		// TRANCA ABRINDO
	
		Image[] imTrancaAbrindo = {
				new Image("res/images/menu/carregando/carregando1.png"),
				new Image("res/images/menu/carregando/carregando2.png"),
				new Image("res/images/menu/carregando/carregando3.png"),
				new Image("res/images/menu/carregando/carregando4.png"),
				new Image("res/images/menu/carregando/carregando5.png"),
				new Image("res/images/menu/carregando/carregando6.png"),
				new Image("res/images/menu/carregando/carregando7.png"),
				new Image("res/images/menu/carregando/carregando8.png"),
				new Image("res/images/menu/carregando/carregando9.png"),
				new Image("res/images/menu/carregando/carregando10.png"),
				new Image("res/images/menu/carregando/carregando11.png"),
				new Image("res/images/menu/carregando/carregando12.png"),
				new Image("res/images/menu/carregando/carregando13.png"),
				new Image("res/images/menu/carregando/carregando14.png"),
				new Image("res/images/menu/carregando/carregando15.png"),
				new Image("res/images/menu/carregando/carregando16.png"),
				new Image("res/images/menu/carregando/carregando17.png"),
				new Image("res/images/menu/carregando/carregando18.png"),
				new Image("res/images/menu/carregando/carregando19.png"),
				new Image("res/images/menu/carregando/carregando20.png"),
				new Image("res/images/menu/carregando/carregando21.png")
		};
		
		// ARRAY DE DURA��O PARA A TRANCA ABRINDO
		
		// Declara��o
		int[] duracaoTranca = new int[imTrancaAbrindo.length];
		
		// Atribui��o de valores
		for(int i=0; i<duracaoTranca.length; i++) {
			duracaoTranca[i] = 50;
		};
		
		// ATRIBUI��O DE VALORES �S VARI�VEIS ANIMATIONS
		
		/** Uma vari�vel animation � criada com uma nova inst�ncia da classe Animation, recebendo
		 * como par�metros um array de Imagens e um array de dura��o com a mesma quantidade de
		 * elementos que o array de Imagens em quest�o, onde cada valor do array de dura��o �
		 * associado com uma imagem do Array de Imagens
		 * 
		 * Para cada um dos bot�es do Menu, � criada uma Animation para a anima��o dele acendendo
		 * e uma para ele apagando.
		 * 
		 * Depois de criar as animations, usamos o comando stopAt que serve para que a animation
		 * pare em algum frame. Neste caso o �ltimo frame dela, que � referenciado pelo
		 * tamanho do array de imagens usado nela - 1
		**/
		
		anOpcoesIn = new Animation(imOpcoesIn, duracaoOpcoes);
		anOpcoesIn.stopAt(imOpcoesIn.length-1);
		anOpcoesOut = new Animation(imOpcoesOut, duracaoOpcoes);
		anOpcoesOut.stopAt(imOpcoesOut.length-1);
		
		anSairIn = new Animation(imSairIn, duracaoSairTuts);
		anSairIn.stopAt(imSairIn.length-1);
		anSairOut = new Animation(imSairOut, duracaoSairTuts);
		anSairOut.stopAt(imSairOut.length-1);
		
		anTutorialIn = new Animation(imTutorialIn, duracaoSairTuts);
		anTutorialIn.stopAt(imTutorialIn.length-1);
		anTutorialOut = new Animation(imTutorialOut, duracaoSairTuts);
		anTutorialOut.stopAt(imTutorialOut.length-1);
		
		anSobreIn = new Animation(imSobreIn, duracao3);
		anSobreIn.stopAt(imSobreIn.length-1);
		anSobreOut = new Animation(imSobreOut, duracao3);
		anSobreOut.stopAt(imSobreOut.length-1);
		
		anCreditosIn = new Animation(imCreditosIn, duracao3);
		anCreditosIn.stopAt(imCreditosIn.length-1);
		anCreditosOut = new Animation(imCreditosOut, duracao3);
		anCreditosOut.stopAt(imCreditosOut.length-1);
		
		anJogarIn = new Animation(imJogarIn, duracaoJogar);
		anJogarIn.stopAt(imJogarIn.length-1);
		anJogarOut = new Animation(imJogarOut, duracaoJogar);
		anJogarOut.stopAt(imJogarOut.length-1);
		
		anTrancaAbrindo = new Animation(imTrancaAbrindo, duracaoTranca);
		anTrancaAbrindo.stopAt(imTrancaAbrindo.length-1);
		
		// Atribui��o de valores �s vari�veis Image que servem como imagens est�ticas
		
		porta = new Image("res/images/menu/porta/porta.png");
		olho = new Image("res/images/menu/jogar/jogar1.png");
		iconOpcoes = new Image("res/images/menu/op��es/op�oes1.png");
		iconSair = new Image("res/images/menu/sair/sair1.png");
		iconTutorial = new Image("res/images/menu/tutorial/tutorial0.png");
		iconSobre = new Image("res/images/menu/sobre/sobre1.png");
		iconCredito = new Image("res/images/menu/creditos/creditos1.png");
		tranca =  new Image("res/images/menu/carregando/carregando1.png");
		//musica = new Music("res/sound/Musica8Bits.wav");
		sp = new SoundPlayer(sbg, gc);
		//sp.start();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

		g.setColor(Color.white); // Mudar a cor da caneta m�gica para branco
		
		porta.draw(220,0); // Desenhar a porta
		
		g.drawString(mousep, 10, 30); // Exibir a posi��o do mouse
		
		// DESENHO DOS BOT�ES E SUAS ANIMA��ES
		
		/**
		 * O racioc�nio para os bot�es debaixo da porta � o mesmo:
		 * 
		 * H� as duas vari�veis: uma do array "opcoes" que identifica se o mouse esta em cima do
		 * bot�o em quest�o e uma do array "iconesLigados" que serve para identificar se deve
		 * ser desenhado a anima��o do bot�o ou sua imagem est�tica; as duas come�am valendo 
		 * "false", e devido � isso � desenhada uma imagem est�tica (uma vari�vel Image)
		 *  do bot�o "apagado".
		 * 
		 * Ao passar o mouse em cima de um bot�o, as vari�veis do array opcoes e do array 
		 * iconesLigados referentes ao bot�o em quest�o passam � valer "true", fazendo com que em
		 * vez da imagem est�tica seja desenhada no seu lugar uma Animation do bot�o "acendendo"
		 * at� ela parar no frame onde o bot�o fica completamente "aceso" (branco).
		 * 
		 * Caso o usu�rio retire o mouse de cima do bot�o, a vari�vel do array opcoes referente �
		 * ele retorna para "false", por�m a do array iconesLigados referente � ele continua 
		 * valendo "true". Com a vari�vel do array opcoes valendo "false" e a do iconesLigados
		 * valendo "true", � desenhada a anima��o do bot�o "apagando" em vez da anima��o dele
		 * acendendo. A anima��o dele apagando vai parar no �ltimo frame, onde o bot�o est� 
		 * completamente apagado de novo.
		 * 
		 * Ap�s isso, l� embaixo no m�todo update desta classe, um if identifica se a anima��o do
		 * bot�o apagando est� parada. Caso ela estiver parada, a vari�vel do array iconesLigados
		 * referente ao bot�o finalmente volta � valer "false", fazendo assim com que o programa
		 * volte a desenhar as imagens est�toicas no lugar das anima��es. Al�m disso, as 
		 * anima��es de acender e apagar sofrem a a��o do m�todo restart() da classe Animation do
		 * Slick que basicamente "reseta" as Animations para seus primeiros frames (esses 
		 * comandos se encontram l� embaixo nos ifs da parte mais inferior do m�todo update desta
		 * classe
		 */
		
		if(!iconesLigados[0]) { // Se o bot�o estiver desligado, desenhe uma imagem est�tica
			iconOpcoes.draw(302,559);
		}
		else { // Se o bot�o estiver ligado
			if(opcoes[0]) { // Se o mouse estiver em cima do bot�o, fa�a a anima��o dele ligando
				anOpcoesIn.draw(302,559);
			}
			else { // Se o mouse n�o estiver em cima dele, fa�a a anima��o dele desligando
				anOpcoesOut.draw(302, 559);
			}
		}
		
		if(!iconesLigados[1]) {
			iconSair.draw(341, 559);
		}
		else {
			if(opcoes[1]) {
				anSairIn.draw(341,559);
			}
			else {
				anSairOut.draw(341, 559);
			}
		}
		
		if(!iconesLigados[2]) {
			iconTutorial.draw(374, 547);
		} else {
			if(opcoes[2]) {
				anTutorialIn.draw(374, 547);
			}
			else {
				anTutorialOut.draw(374, 547);
			}
		}
		
		if(!iconesLigados[3]) {
			iconSobre.draw(431, 559);
		} else {
			if(opcoes[3]) {
				anSobreIn.draw(431, 559);
			}
			else {
				anSobreOut.draw(431, 559);
			}
		}
		
		if(!iconesLigados[4]) {
			iconCredito.draw(470,559);
		} else {
			if(opcoes[4]) {
				anCreditosIn.draw(470, 559);
			}
			else {
				anCreditosOut.draw(470, 559);
			}
		}
		
		if(!iconesLigados[5]) { 
			olho.draw(240,151); 
		} else {
			if(opcoes[5]) {
				anJogarIn.draw(240, 151);
			} else {
				anJogarOut.draw(240, 151);
			}
		}
		
		if(!trancaAberta) { 
			// Se a tranca n�o estiver aberta, desenhe uma imagem est�tica dela fechada.
			tranca.draw(220, 430); 
		} else {
			anTrancaAbrindo.draw(220, 430); /** Do contr�rio, desenhe a anima��o da tranca se 
			abrindo **/
		}
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if(!sp.isAlive()) {
			sp.setDaemon(true);
			sp.start();
		}
		
		Input input = gc.getInput(); /** Vari�vel Input para detectar os inputs de teclado do 
		usu�rio
		**/
		
		int mouseX = Mouse.getX(); // Vari�vel para a posi��o X do mouse
		int mouseY = Mouse.getY(); // Vari�vel para a posi��o Y do mouse
		
		/** LEMBRETE:
		 * No Slick2D, aposi��o 0,0 do mouse � no canto inferior esquerdo da tela, diferente do
		 * 0,0 da tela no geral, que � no canto superior esquerdo mesmo, como nas outras 
		 * linguagens.
		 */
		
		mousep = "X: "+mouseX+" Y: "+mouseY; // Vari�vel para a exibi��o da posi��o do mouse
		
		// IFS para identificar a posi��o do mouse e realizar a��es com base nisso
		// (O racioc�nio � o mesmo que o apresentado nos coment�rios do primeiro if)
		
		// Bot�o de op��es
		if((mouseX>303 && mouseX<328) && (mouseY>13 && mouseY<39)){
			iconesLigados[0] = true; // o bot�o est� ligado
			opcoes[0] = true; // o mouse est� em cima dele
			
			if(input.isMouseButtonDown(0)) { // Se o bot�o direito do mouse for clicado
				for(int i=0;i<iconesLigados.length;i++) {
					iconesLigados[i] = false;
				} /** Desliga todas as vari�veis referentes aos estados ligado/desligado de
				todos os bot�es (para garantir que nenhuma variavel do array iconesLigados 
				permane�a true caso sua anima��o de desligamento n�o tenha terminado antes de 
				mudar de estado)
				**/
				
				anOpcoesIn.restart(); // Reseta a vari�vel do bot�o ligando
				
				sbg.enterState(Jogo.menuOpcoes); // Entra no estado do menu de Op��es
				sbg.getState(Jogo.menu).leave(gc, sbg);
			}
		}
		
		// Bot�o Sair
		else if((mouseX>342 && mouseX<368) && (mouseY>13 && mouseY<39)) {
			iconesLigados[1] = true;
			opcoes[1] = true;
			if(input.isMouseButtonDown(0)) {
				gc.exit();
			}
		}
		
		// Bot�o do tutorial
		else if((mouseX>374 && mouseX<425) && (mouseY>32 && mouseY<54)) {
			iconesLigados[2] = true;
			opcoes[2] = true;
			
			if(input.isMouseButtonDown(0)) {
				
				for(int i=0;i<iconesLigados.length;i++) {
					iconesLigados[i] = false;
				}
				
				anTutorialIn.restart();
				sbg.enterState(Jogo.tutorial);
				sbg.getState(Jogo.menu).leave(gc, sbg);
			}
		}
		
		// Bot�o Sobre o jogo
		else if((mouseX>430 && mouseX<457) && (mouseY>11 && mouseY<41)) {
			iconesLigados[3] = true;
			opcoes[3]=true;
		
			if(input.isMouseButtonDown(0)) {
				
				for(int i=0;i<iconesLigados.length;i++) {
					iconesLigados[i] = false;
				}
				
				anSobreIn.restart();
				sbg.enterState(Jogo.menuSobreOJogo);
				sbg.getState(Jogo.menu).leave(gc, sbg);
				
			}
		}
		
		// Bot�o dos cr�ditos
		else if((mouseX>469 && mouseX<499) && (mouseY>11 && mouseY<41)) {
			iconesLigados[4] = true;
			opcoes[4]=true;
			
			if(input.isMouseButtonDown(0)) {
				
				for(int i=0;i<iconesLigados.length;i++) {
					iconesLigados[i] = false;
				}
				
				anCreditosIn.restart();
				sbg.enterState(Jogo.creditos);
				sbg.getState(Jogo.menu).leave(gc, sbg);
				
			}
		}
		
		// Bot�o de gameplay
		else if((mouseX>360 && mouseX<438) && (mouseY>185 && mouseY<271)) {
			iconesLigados[5] = true;
			opcoes[5]=true;
			
			if(input.isMouseButtonDown(0)) { // Se clicar no olho
				
				for(int i=0;i<iconesLigados.length-1;i++) { 
					iconesLigados[i] = false;
					
					/** Todas as vari�veis de iconesLigados viram false, exceto � referente ao 
					 * bot�o de gameplay (por isso iconesLigador.length - 1 desta vez
					**/
				}
				
				trancaAberta = true;
				// A vari�vel que indica se a tranca est� aberta vira true
			}
		}
		
		else { 
			
			/** Se o mouse n�o estiver em cima de nenhum bot�o, todas as vari�veis do array
		opcoes ficam valendo false (no caso do opcoes[5], ele vira false se al�m de o mouse n�o 
		estar em cima do olho a tranca tamb�m n�o estiver aberta. Assim, n�o rodar� a anima��o
		do olho "fechando" em nenhuma hip�tese enquanto a tranca se abre
			**/
			
			opcoes[0] = false;
			opcoes[1] = false;
			opcoes[2] = false;
			opcoes[3] = false;
			opcoes[4] = false;
			if(!trancaAberta) {
				opcoes[5] = false;
			}
			
		}
		
		/** Abaixo, os ifs que desligam as vari�veis do array iconesLigados e resetam as 
		 * anima��es de ligar e desligar caso a anima��o dos bot�es desligando estiver parada. 
		 * (No caso, ele s� ir� parar quando estiver no seu �ltimo frame).
		 */
		
		if(anOpcoesOut.isStopped()) { /** EXEMPLO: se a anima��o de desligamento do bot�o op��es
		 	parar
			**/
			
			iconesLigados[0] = false; /** Desligue a vari�vel do array iconesLigados referente �
			este bot�o
			**/
			
			anOpcoesIn.restart(); // Retornar a anima��o de ligar para o primeiro frame
			anOpcoesOut.restart();  // Retornar a anima��o de desligar para o primeiro frame
		}
		
		if(anSairOut.isStopped()) {
			iconesLigados[1] = false;
			anSairIn.restart();
			anSairOut.restart();
		}
		
		if(anTutorialOut.isStopped()) {
			iconesLigados[2] = false;
			anTutorialIn.restart();
			anTutorialOut.restart();
		}
		
		if(anSobreOut.isStopped()) {
			iconesLigados[3] = false;
			anSobreIn.restart();
			anSobreOut.restart();
		}
		
		if(anCreditosOut.isStopped()) {
			iconesLigados[4] = false;
			anCreditosIn.restart();
			anCreditosOut.restart();
		}
		
		if(anJogarOut.isStopped()) {
			iconesLigados[5] = false;
			anJogarIn.restart();
			anJogarOut.restart();
		}
		
		if(anTrancaAbrindo.isStopped()) { 
			
			/**
			 * Se a tranca estiver aberta e a anima��o dela abrindo estiver parada, ou seja,
			 * conclu�da, reseta as anima��es da tranca e do olho, muda a trancaAberta para
			 * false, assim como as vari�veis iconesLigados e opcoes referentes ao bot�o Jogar
			 * e muda o jogo para o estado de gameplay 
			 */
			

			sbg.enterState(Jogo.menuToPlayA);
			//sbg.enterState(Jogo.gameplay, new FadeOutTransition(), new FadeInTransition());
			sbg.getState(Jogo.menu).leave(gc, sbg);
		}
		
		//System.out.println("trancaAberta: "+trancaAberta+" anTrancaAbrindo.isStopped(): "+anTrancaAbrindo.isStopped());
		
	}
	
	public static void closeOpening() {
		trancaAberta = false;
		anTrancaAbrindo.restart();
		iconesLigados[5] = false;
		opcoes[5] = false;
		anJogarIn.restart();
		anJogarOut.restart();
	}
	
	@Override
	public int getID() { // Getter da vari�vel int de identifica��o deste estado
		// TODO Auto-generated method stub
		return Jogo.menu; 
	}

	
}
