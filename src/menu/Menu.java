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
	
	// Animações dos botões
	static Animation anOpcoesIn, anSairIn, anTutorialIn, anSobreIn, anCreditosIn;

	static Animation anJogarIn;
	static Animation anOpcoesOut, anSairOut, anTutorialOut, anSobreOut, anCreditosOut;

	static Animation anJogarOut;
	static Animation anTrancaAbrindo;
	
	public String mousep = "no";
	
	SoundPlayer sp;
	
	//public boolean mouseNoCursor = false;
	
	static boolean[] opcoes = {false, false, false, false, false, false}; /** Os valores desse array
	ficam true ou false dependendo de qual botão o mouse fica em cima. Por exemplo: o primeiro
	valor deste array esta associado ao botão que leva para o menu de opções. Se o mouse estiver
	em cima do botão de opções o primeiro valor deste array passa a valer true. Se o mouse não
	estiver em cima do botão do menu de opções o primeiro valor deste array passa a valer false.
	E assim se procede com os outros botões
	**/
	
	static boolean[] iconesLigados = {false, false, false, false, false, false}; /** Este array diz se
	os botões estão "ligados", ou seja, se eles estão com uma animação de "acender" 
	(ficando branco) ou "apagar" (escurecendo).
	**/
	
	static boolean trancaAberta = false; /** Variável que irá valer "true" no momento que a tranca da
	porta precisar ser aberta
	**/
	
	Image porta, olho, iconOpcoes, iconSair, iconTutorial, iconSobre, iconCredito, tranca;
	/** Variáveis Image que servirão como imagens estáticos dos botões escurecidos (quando o
	 * mouse não está em cima deles.
	**/
	
	public Menu(int state) {
		
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

		// VETORES DE IMAGES (que irão para uma variável Animation posteriormente)
		
		// BOTÃO DO MENU DE OPÇÕES
		
		// Acendendo (Mouse em cima)
		Image[] imOpcoesIn = {
				new	Image("res/images/menu/opções/opçoes1.png"),
				new	Image("res/images/menu/opções/opçoes2.png"),
				new	Image("res/images/menu/opções/opçoes3.png"),
				new	Image("res/images/menu/opções/opçoes4.png"),
				new	Image("res/images/menu/opções/opçoes5.png"),
				new	Image("res/images/menu/opções/opçoes6.png"),
		};
		
		// Apagando (Tirando o mouse de cima)
		Image[] imOpcoesOut = {
				new	Image("res/images/menu/opções/opçoes6.png"),
				new	Image("res/images/menu/opções/opçoes5.png"),
				new	Image("res/images/menu/opções/opçoes4.png"),
				new	Image("res/images/menu/opções/opçoes3.png"),
				new	Image("res/images/menu/opções/opçoes2.png"),
				new	Image("res/images/menu/opções/opçoes1.png"),
		};
		
		// ARRAY DE DURAÇÃO RELATIVO A ANIMAÇÃO DO BOTÃO DE OPÇÕES
		
		// Declaracao
		int[] duracaoOpcoes = new int[imOpcoesIn.length];
		
		// Atribuição de valores
		for(int i=0;i<duracaoOpcoes.length;i++) {
			duracaoOpcoes[i]=80;
		}
		
		// BOTÃO DE SAIR
		
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
		
		// BOTÃO DO TUTORIAL
		
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
		
		// ARRAY DE DURAÇÃO DOS BOTÕES DE TUTORIAL E DE SAIR
		
		// Declaração
		int[] duracaoSairTuts = new int[imSairIn.length];
		
		// Atribuição de valores
		for(int i=0;i<duracaoSairTuts.length;i++) {
			duracaoSairTuts[i] = 80;
		}
		
		// BOTÃO DE "SOBRE O JOGO"
		
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
		
		// BOTÃO DOS CRÉDITOS
		
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
		
		// ARRAY DE DURAÇÃO PARA OS BOTÕES RESTANTES (Exceto o botão Jogar)
		
		// Declaração
		int[] duracao3 = new int[4];
		
		// Atribuição de valores
		for(int i=0; i<duracao3.length; i++) {
			duracao3[i] = 80;
		};
		
		// BOTÃO "JOGAR"
		
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
		
		// ARRAY DE DURAÇÃO PARA O BOTÃO JOGAR
		
		// Declaração
		int[] duracaoJogar = new int[imJogarIn.length];
		
		// Atribuição de valores
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
		
		// ARRAY DE DURAÇÃO PARA A TRANCA ABRINDO
		
		// Declaração
		int[] duracaoTranca = new int[imTrancaAbrindo.length];
		
		// Atribuição de valores
		for(int i=0; i<duracaoTranca.length; i++) {
			duracaoTranca[i] = 50;
		};
		
		// ATRIBUIÇÃO DE VALORES ÀS VARIÁVEIS ANIMATIONS
		
		/** Uma variável animation é criada com uma nova instância da classe Animation, recebendo
		 * como parâmetros um array de Imagens e um array de duração com a mesma quantidade de
		 * elementos que o array de Imagens em questão, onde cada valor do array de duração é
		 * associado com uma imagem do Array de Imagens
		 * 
		 * Para cada um dos botões do Menu, é criada uma Animation para a animação dele acendendo
		 * e uma para ele apagando.
		 * 
		 * Depois de criar as animations, usamos o comando stopAt que serve para que a animation
		 * pare em algum frame. Neste caso o último frame dela, que é referenciado pelo
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
		
		// Atribuição de valores ás variáveis Image que servem como imagens estáticas
		
		porta = new Image("res/images/menu/porta/porta.png");
		olho = new Image("res/images/menu/jogar/jogar1.png");
		iconOpcoes = new Image("res/images/menu/opções/opçoes1.png");
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

		g.setColor(Color.white); // Mudar a cor da caneta mágica para branco
		
		porta.draw(220,0); // Desenhar a porta
		
		g.drawString(mousep, 10, 30); // Exibir a posição do mouse
		
		// DESENHO DOS BOTÕES E SUAS ANIMAÇÕES
		
		/**
		 * O raciocínio para os botões debaixo da porta é o mesmo:
		 * 
		 * Há as duas variáveis: uma do array "opcoes" que identifica se o mouse esta em cima do
		 * botão em questão e uma do array "iconesLigados" que serve para identificar se deve
		 * ser desenhado a animação do botão ou sua imagem estática; as duas começam valendo 
		 * "false", e devido à isso é desenhada uma imagem estática (uma variável Image)
		 *  do botão "apagado".
		 * 
		 * Ao passar o mouse em cima de um botão, as variáveis do array opcoes e do array 
		 * iconesLigados referentes ao botão em questão passam à valer "true", fazendo com que em
		 * vez da imagem estática seja desenhada no seu lugar uma Animation do botão "acendendo"
		 * até ela parar no frame onde o botão fica completamente "aceso" (branco).
		 * 
		 * Caso o usuário retire o mouse de cima do botão, a variável do array opcoes referente à
		 * ele retorna para "false", porém a do array iconesLigados referente à ele continua 
		 * valendo "true". Com a variável do array opcoes valendo "false" e a do iconesLigados
		 * valendo "true", é desenhada a animação do botão "apagando" em vez da animação dele
		 * acendendo. A animação dele apagando vai parar no último frame, onde o botão está 
		 * completamente apagado de novo.
		 * 
		 * Após isso, lá embaixo no método update desta classe, um if identifica se a animação do
		 * botão apagando está parada. Caso ela estiver parada, a variável do array iconesLigados
		 * referente ao botão finalmente volta à valer "false", fazendo assim com que o programa
		 * volte a desenhar as imagens estátoicas no lugar das animações. Além disso, as 
		 * animações de acender e apagar sofrem a ação do método restart() da classe Animation do
		 * Slick que basicamente "reseta" as Animations para seus primeiros frames (esses 
		 * comandos se encontram lá embaixo nos ifs da parte mais inferior do método update desta
		 * classe
		 */
		
		if(!iconesLigados[0]) { // Se o botão estiver desligado, desenhe uma imagem estática
			iconOpcoes.draw(302,559);
		}
		else { // Se o botão estiver ligado
			if(opcoes[0]) { // Se o mouse estiver em cima do botão, faça a animação dele ligando
				anOpcoesIn.draw(302,559);
			}
			else { // Se o mouse não estiver em cima dele, faça a animação dele desligando
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
			// Se a tranca não estiver aberta, desenhe uma imagem estática dela fechada.
			tranca.draw(220, 430); 
		} else {
			anTrancaAbrindo.draw(220, 430); /** Do contrário, desenhe a animação da tranca se 
			abrindo **/
		}
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if(!sp.isAlive()) {
			sp.setDaemon(true);
			sp.start();
		}
		
		Input input = gc.getInput(); /** Variável Input para detectar os inputs de teclado do 
		usuário
		**/
		
		int mouseX = Mouse.getX(); // Variável para a posição X do mouse
		int mouseY = Mouse.getY(); // Variável para a posição Y do mouse
		
		/** LEMBRETE:
		 * No Slick2D, aposição 0,0 do mouse é no canto inferior esquerdo da tela, diferente do
		 * 0,0 da tela no geral, que é no canto superior esquerdo mesmo, como nas outras 
		 * linguagens.
		 */
		
		mousep = "X: "+mouseX+" Y: "+mouseY; // Variável para a exibição da posição do mouse
		
		// IFS para identificar a posição do mouse e realizar ações com base nisso
		// (O raciocínio é o mesmo que o apresentado nos comentários do primeiro if)
		
		// Botão de opções
		if((mouseX>303 && mouseX<328) && (mouseY>13 && mouseY<39)){
			iconesLigados[0] = true; // o botão está ligado
			opcoes[0] = true; // o mouse está em cima dele
			
			if(input.isMouseButtonDown(0)) { // Se o botão direito do mouse for clicado
				for(int i=0;i<iconesLigados.length;i++) {
					iconesLigados[i] = false;
				} /** Desliga todas as variáveis referentes aos estados ligado/desligado de
				todos os botões (para garantir que nenhuma variavel do array iconesLigados 
				permaneça true caso sua animação de desligamento não tenha terminado antes de 
				mudar de estado)
				**/
				
				anOpcoesIn.restart(); // Reseta a variável do botão ligando
				
				sbg.enterState(Jogo.menuOpcoes); // Entra no estado do menu de Opções
				sbg.getState(Jogo.menu).leave(gc, sbg);
			}
		}
		
		// Botão Sair
		else if((mouseX>342 && mouseX<368) && (mouseY>13 && mouseY<39)) {
			iconesLigados[1] = true;
			opcoes[1] = true;
			if(input.isMouseButtonDown(0)) {
				gc.exit();
			}
		}
		
		// Botão do tutorial
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
		
		// Botão Sobre o jogo
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
		
		// Botão dos créditos
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
		
		// Botão de gameplay
		else if((mouseX>360 && mouseX<438) && (mouseY>185 && mouseY<271)) {
			iconesLigados[5] = true;
			opcoes[5]=true;
			
			if(input.isMouseButtonDown(0)) { // Se clicar no olho
				
				for(int i=0;i<iconesLigados.length-1;i++) { 
					iconesLigados[i] = false;
					
					/** Todas as variáveis de iconesLigados viram false, exceto à referente ao 
					 * botão de gameplay (por isso iconesLigador.length - 1 desta vez
					**/
				}
				
				trancaAberta = true;
				// A variável que indica se a tranca está aberta vira true
			}
		}
		
		else { 
			
			/** Se o mouse não estiver em cima de nenhum botão, todas as variáveis do array
		opcoes ficam valendo false (no caso do opcoes[5], ele vira false se além de o mouse não 
		estar em cima do olho a tranca também não estiver aberta. Assim, não rodará a animação
		do olho "fechando" em nenhuma hipótese enquanto a tranca se abre
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
		
		/** Abaixo, os ifs que desligam as variáveis do array iconesLigados e resetam as 
		 * animações de ligar e desligar caso a animação dos botões desligando estiver parada. 
		 * (No caso, ele só irá parar quando estiver no seu último frame).
		 */
		
		if(anOpcoesOut.isStopped()) { /** EXEMPLO: se a animação de desligamento do botão opções
		 	parar
			**/
			
			iconesLigados[0] = false; /** Desligue a variável do array iconesLigados referente à
			este botão
			**/
			
			anOpcoesIn.restart(); // Retornar a animação de ligar para o primeiro frame
			anOpcoesOut.restart();  // Retornar a animação de desligar para o primeiro frame
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
			 * Se a tranca estiver aberta e a animação dela abrindo estiver parada, ou seja,
			 * concluída, reseta as animações da tranca e do olho, muda a trancaAberta para
			 * false, assim como as variáveis iconesLigados e opcoes referentes ao botão Jogar
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
	public int getID() { // Getter da variável int de identificação deste estado
		// TODO Auto-generated method stub
		return Jogo.menu; 
	}

	
}
