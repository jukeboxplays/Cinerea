package cutscenes;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import controleDeJogo.Jogo;

public class AnimLogo extends BasicGameState {
	
	Animation animAnim;

	public AnimLogo(int state) {	
		
	}
		
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		Image[] anFrames = {
				new Image("res/images/animlogo/logo-fatec.jpg"),
				new Image("res/images/animlogo/logo-fatec.jpg"),
				new Image("res/images/animlogo/logo-fatec.jpg"),
				new Image("res/images/animlogo/logo-fatec.jpg"),
				new Image("res/images/animlogo/logo-fatec.jpg"),
				new Image("res/images/animlogo/logo-fatec.jpg"),
				new Image("res/images/animlogo/logo-fatec.jpg"),
				new Image("res/images/animlogo/logo-fatec.jpg"),
				new Image("res/images/animlogo/logo-fatec.jpg"),
				new Image("res/images/animlogo/logo-fatec.jpg"),
				new	Image("res/images/animlogo/redSunset1.png"),
				new	Image("res/images/animlogo/redSunset2.png"),
				new	Image("res/images/animlogo/redSunset3.png"),
				new	Image("res/images/animlogo/redSunset4.png"),
				new	Image("res/images/animlogo/redSunset5.png"),
				new	Image("res/images/animlogo/redSunset6.png"),
				new	Image("res/images/animlogo/redSunset7.png"),
				new	Image("res/images/animlogo/redSunset8.png"),
				new	Image("res/images/animlogo/redSunset9.png"),
				new	Image("res/images/animlogo/redSunset10.png"),
				new	Image("res/images/animlogo/redSunset11.png"),
				new	Image("res/images/animlogo/redSunset12.png"),
				new	Image("res/images/animlogo/redSunset13.png"),
				new	Image("res/images/animlogo/redSunset14.png"),
				new	Image("res/images/animlogo/redSunset15.png"),
				new	Image("res/images/animlogo/redSunset16.png"),
				new	Image("res/images/animlogo/redSunset17.png"),
				new	Image("res/images/animlogo/redSunset18.png"),
				new	Image("res/images/animlogo/redSunset19.png"),
				new	Image("res/images/animlogo/redSunset20.png"),
				new	Image("res/images/animlogo/redSunset21.png"),
				new	Image("res/images/animlogo/redSunset22.png"),
				new	Image("res/images/animlogo/redSunset23.png"),
				new	Image("res/images/animlogo/redSunset24.png"),
				new	Image("res/images/animlogo/redSunset25.png"),
				new	Image("res/images/animlogo/redSunset26.png"),
				new	Image("res/images/animlogo/redSunset27.png"),
				new	Image("res/images/animlogo/redSunset28.png"),
				new	Image("res/images/animlogo/redSunset29.png"),
				new	Image("res/images/animlogo/redSunset30.png"),
				new	Image("res/images/animlogo/redSunset31.png"),
				new	Image("res/images/animlogo/redSunset32.png"),
				new	Image("res/images/animlogo/redSunset33.png"),
				new	Image("res/images/animlogo/redSunset34.png"),
				new	Image("res/images/animlogo/redSunset35.png"),
				new	Image("res/images/animlogo/redSunset36.png"),
				new	Image("res/images/animlogo/redSunset37.png"),
				new	Image("res/images/animlogo/redSunset38.png"),
				new	Image("res/images/animlogo/redSunset39.png"),
				new	Image("res/images/animlogo/redSunset40.png"),
				new	Image("res/images/animlogo/redSunset41.png"),
				new	Image("res/images/animlogo/redSunset42.png"),
				new	Image("res/images/animlogo/redSunset43.png"),
				new	Image("res/images/animlogo/redSunset44.png"),
				new	Image("res/images/animlogo/redSunset45.png"),
				new	Image("res/images/animlogo/redSunset46.png"),
				new	Image("res/images/animlogo/redSunset47.png"),
				new	Image("res/images/animlogo/redSunset48.png"),
				new	Image("res/images/animlogo/redSunset49.png"),
				new	Image("res/images/animlogo/redSunset50.png"),
				new	Image("res/images/animlogo/redSunset51.png"),
				new	Image("res/images/animlogo/redSunset52.png"),
				new	Image("res/images/animlogo/redSunset53.png"),
				new	Image("res/images/animlogo/redSunset54.png"),
				new	Image("res/images/animlogo/redSunset55.png"),
				new	Image("res/images/animlogo/redSunset56.png"),
				new	Image("res/images/animlogo/redSunset57.png"),
				new	Image("res/images/animlogo/redSunset58.png"),
				new	Image("res/images/animlogo/redSunset59.png"),
				new	Image("res/images/animlogo/redSunset60.png"),
				new	Image("res/images/animlogo/redSunset61.png"),
				new	Image("res/images/animlogo/redSunset62.png"),
				new	Image("res/images/animlogo/redSunset63.png"),
				new	Image("res/images/animlogo/redSunset64.png"),
				new	Image("res/images/animlogo/redSunset65.png"),
				new	Image("res/images/animlogo/redSunset66.png"),
				new	Image("res/images/animlogo/redSunset67.png"),
				new	Image("res/images/animlogo/redSunset68.png"),
				new	Image("res/images/animlogo/redSunset69.png"),
				new	Image("res/images/animlogo/redSunset70.png"),
				new	Image("res/images/animlogo/redSunset71.png"),
				new	Image("res/images/animlogo/redSunset72.png"),
				new	Image("res/images/animlogo/redSunset73.png"),
				new	Image("res/images/animlogo/redSunset74.png"),
				new	Image("res/images/animlogo/redSunset75.png"),
				new	Image("res/images/animlogo/redSunset76.png"),
				new	Image("res/images/animlogo/redSunset77.png"),
				new	Image("res/images/animlogo/redSunset78.png"),
				new	Image("res/images/animlogo/redSunset79.png"),
				new	Image("res/images/animlogo/redSunset80.png"),
				new	Image("res/images/animlogo/redSunset81.png"),
				new	Image("res/images/animlogo/redSunset82.png"),
				new	Image("res/images/animlogo/redSunset83.png"),
				new	Image("res/images/animlogo/redSunset84.png"),
				new	Image("res/images/animlogo/redSunset85.png"),
				new	Image("res/images/animlogo/redSunset86.png"),
				new	Image("res/images/animlogo/redSunset87.png"),
				new	Image("res/images/animlogo/redSunset88.png"),
				new	Image("res/images/animlogo/redSunset89.png"),
				new	Image("res/images/animlogo/redSunset90.png"),
				new	Image("res/images/animlogo/redSunset91.png"),
				new	Image("res/images/animlogo/redSunset92.png"),
				new	Image("res/images/animlogo/redSunset93.png"),
				new	Image("res/images/animlogo/redSunset94.png"),
				new	Image("res/images/animlogo/redSunset95.png"),
				new	Image("res/images/animlogo/redSunset96.png"),
				new	Image("res/images/animlogo/redSunset97.png"),
				new	Image("res/images/animlogo/redSunset98.png"),
				new	Image("res/images/animlogo/redSunset99.png"),
				new	Image("res/images/animlogo/redSunset100.png"),
				new	Image("res/images/animlogo/redSunset101.png"),
				new	Image("res/images/animlogo/redSunset102.png"),
				new	Image("res/images/animlogo/redSunset103.png"),
				new	Image("res/images/animlogo/redSunset104.png"),
				new	Image("res/images/animlogo/redSunset105.png"),
				new	Image("res/images/animlogo/redSunset106.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset107.png"),
				new	Image("res/images/animlogo/redSunset108.png"),
				new	Image("res/images/animlogo/redSunset109.png"),
				new	Image("res/images/animlogo/redSunset110.png"),
				new	Image("res/images/animlogo/redSunset111.png"),
				new	Image("res/images/animlogo/redSunset112.png"),
				new	Image("res/images/animlogo/redSunset113.png"),
				new	Image("res/images/animlogo/redSunset114.png"),
				new	Image("res/images/animlogo/redSunset115.png"),
				new	Image("res/images/animlogo/redSunset116.png"),
				new	Image("res/images/animlogo/redSunset117.png"),
				new	Image("res/images/animlogo/redSunset118.png"),
				new	Image("res/images/animlogo/redSunset119.png"),
				new	Image("res/images/animlogo/redSunset120.png"),
				new	Image("res/images/animlogo/redSunset121.png"),
				new	Image("res/images/animlogo/redSunset122.png"),
				new	Image("res/images/animlogo/redSunset123.png"),
				new	Image("res/images/animlogo/redSunset124.png"),
				new	Image("res/images/animlogo/redSunset125.png"),
				new	Image("res/images/animlogo/redSunset126.png"),
				new	Image("res/images/animlogo/redSunset127.png"),
				new	Image("res/images/animlogo/redSunset128.png"),
				new	Image("res/images/animlogo/redSunset129.png"),
				new	Image("res/images/animlogo/redSunset130.png"),
				new	Image("res/images/animlogo/redSunset131.png"),
				new	Image("res/images/animlogo/redSunset132.png"),
				new	Image("res/images/animlogo/redSunset133.png"),
				new	Image("res/images/animlogo/redSunset134.png"),
				new	Image("res/images/animlogo/redSunset135.png"),
				new	Image("res/images/animlogo/redSunset136.png")
			
		};
		
		int[] duracaoAnim = new int[anFrames.length];
		
		for(int i=0; i<anFrames.length; i++) {
			duracaoAnim[i] = 80;
		}
		
		animAnim = new Animation(anFrames, duracaoAnim);
		animAnim.stopAt(anFrames.length-1);
	}
	
	@Override
	public void render(GameContainer arg0, StateBasedGame sbg, Graphics arg2) throws SlickException {
			
		
			animAnim.draw();
			
		
		
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
		if(animAnim.isStopped()) {
			sbg.enterState(Jogo.menu);
			sbg.getCurrentState().leave(gc, sbg);
		}
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Jogo.animLogo;
	}

	
	

}
