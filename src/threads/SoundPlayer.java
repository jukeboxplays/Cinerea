package threads;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import controleDeJogo.Jogo;

public class SoundPlayer extends Thread {
	
	static int estadoAtual = 0;
	
	boolean jogoRodando;
	
	int cs;
	
	Music musica;
	
	Music musica2;
	
	StateBasedGame sbg;
	
	GameContainer gc;
		
	public SoundPlayer(StateBasedGame s, GameContainer g) throws SlickException{
		musica = new Music("res/sound/Musica8Bits.wav");
		musica2 = new Music("res/sound/Dark_Souls_OST_-_Great_Grey_Wolf_Sif-8tuWvGee4T0.wav");
		sbg = s;
		g = gc;
		//agc = a;
	}
	
	public void run() {
		while(true) {
			cs = sbg.getCurrentStateID();
			//System.out.println(cs);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(cs==Jogo.menu) {
				if(musica2.playing()) {
					musica2.stop();
				}
		
				if(!musica.playing()) {
					musica.play();
				}
			}
			else if(cs==Jogo.menuSobreOJogo || cs==Jogo.menuOpcoes || cs==Jogo.creditos || cs==Jogo.tutorial) {
				musica.stop();
				if(!musica2.playing()) {
					musica2.play();
				}
			}
			else {
				musica.stop();	
				musica2.stop();
			}
			
		}
	}
	
}
