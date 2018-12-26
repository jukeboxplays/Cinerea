package controleDeJogo;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import threads.SoundPlayer;

public class Jogo extends StateBasedGame{
	
	static AppGameContainer agc; // Variável que comportará um AppGameContainer para iniciar o jogo
	static int largura = 800; // largura da tela
	static int altura = 600; // altura da tela
	
	//static GameContainer gc;
	
	public static SoundPlayer sp;
	
	public static String idioma = "Português";

	public static final int menu = 0; // Inicializa a variavel int "menu" que serï¿½ o valor 
	// associado ao estado menu do jogo, neste caso 0
	
	public static final int gameplay = 1; // Inicializa a variavel int "play" que serï¿½ o valor 
	// associado ao estado de gameplay do jogo, neste caso 1
	
	public static final int menuOpcoes = 2;
	public static final int menuSobreOJogo = 3;
	public static final int creditos = 4;
	public static final int tutorial = 5;
	public static final int animLogo = 6;
	public static final int menuToPlayA = 7;
	public static final int menuToPlayB = 8;
	public static final int dialogo = 9;
	
	public Jogo(String name) throws SlickException{
		super(name); // "super" significa que ele ta chamando, nesse caso, a variï¿½vel "name"
		// da classe StateBasedGame(que essa classe "Principal" herda)
		// e a iguala a variavel "name" deste mï¿½todo
		
		this.addState(new menu.Menu(menu)); // Adiciona um estado de jogo cujo parï¿½metro ï¿½ uma nova
		// instï¿½ncia da classe Menu (que foi criada neste projeto). A classe Menu por sua vez,
		// recebe como parï¿½metro o "valor int "menu" que serve para identificï¿½-la".
		
		this.addState(new gameplay.salas.SalaA(gameplay)); // Adiciona um estado de jogo cujo parï¿½metro ï¿½ uma nova
		// instï¿½ncia da classe Play (que foi criada neste projeto). A classe Play por sua vez,
		// recebe como parï¿½metro o "valor int "play" que serve para identificï¿½-la".
		
		this.addState(new menu.MenuOpcoes(menuOpcoes));
		this.addState(new menu.SobreOJogo(menuSobreOJogo));
		this.addState(new menu.Creditos(creditos));
		this.addState(new menu.Tutorial(tutorial));
		this.addState(new cutscenes.AnimLogo(animLogo));
		this.addState(new intermediarios.MenuToPlayA(menuToPlayA));
		this.addState(new intermediarios.MenuToPlayB(menuToPlayB));
		this.addState(new menu.Dialogo(dialogo));
	}
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		this.getState(menu).init(gc, this);
		this.getState(menuOpcoes).init(gc, this);
		this.getState(gameplay).init(gc, this);
		this.getState(menuSobreOJogo).init(gc, this);
		this.getState(creditos).init(gc, this);
		this.getState(tutorial).init(gc, this);
		this.getState(animLogo).init(gc, this);
		this.getState(menuToPlayA).init(gc, this);
		this.getState(menuToPlayB).init(gc,  this);
		this.getState(dialogo);
		
		this.enterState(gameplay);
		
	}

	public static void main(String[] args) { // MÉTODO PRINCIPAL
			
		try { // A configuração do AppGameContainer precisa ser feita dentro de um bloco try/catch
			
			agc = new AppGameContainer(new Jogo("Cinérea"));
			// Nova instância da classe AppGameContainer que por sua vez tem uma nova instância
			// da classe Jogo como parâmetro
			
			agc.setDisplayMode(largura, altura, false); // Configura o tamanho da janela.
			// Se estiver "false" inicializa em uma janela, se estiver "true" inicializa em
			// tela cheia
			
			agc.setShowFPS(false); // true mostra o FPS e false não mostra
			
			agc.setTargetFrameRate(60); // Diz qual o FPS à se tentar atingir 
			// (igual ao "clock.tick(fps)" do pygame)
			
			agc.setVSync(true); // Liga a sincronização vertical
			
			agc.start(); // Inicializa o AppGameContainer, no caso a classe Jogo
			
		}catch(SlickException e) {
			e.printStackTrace();
			
		}
	
	}
	
}
