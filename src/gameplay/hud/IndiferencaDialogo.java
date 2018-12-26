package gameplay.hud;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class IndiferencaDialogo {
	
	Animation indiferencaText;
	
	public IndiferencaDialogo() throws SlickException{
		Image[] indiFr = {
			new Image("res/images/dialogo/indiferencaDialogo1.png"),
			new Image("res/images/dialogo/indiferencaDialogo2.png"),
			new Image("res/images/dialogo/indiferencaDialogo3.png"),
			new Image("res/images/dialogo/indiferencaDialogo4.png"),
			new Image("res/images/dialogo/indiferencaDialogo5.png"),
			new Image("res/images/dialogo/indiferencaDialogo6.png"),
			new Image("res/images/dialogo/indiferencaDialogo7.png"),
			new Image("res/images/dialogo/indiferencaDialogo8.png"),
			new Image("res/images/dialogo/indiferencaDialogo9.png"),
		};
		
		int[] duracaoIndText = new int[indiFr.length];
		
		for(int i=0; i<duracaoIndText.length;i++) {
			duracaoIndText[i] = 80;
		}
		
		indiferencaText = new Animation(indiFr, duracaoIndText);
	}
	
	public void desenhar(Graphics g, int translateX, int translateY) {
		indiferencaText.draw(-translateX, -translateY);
		System.out.println(translateX+" "+translateY);
	}

}
