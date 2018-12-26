package gameplay.salas;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import controleDeJogo.Jogo;
import controleDeJogo.VariaveisControle;
import gameplay.camera.Camera;
import gameplay.hud.HUD;
import gameplay.hud.IndiferencaDialogo;
import gameplay.personagem.Protagonista;

public class SalaA extends BasicGameState{
	
	public static boolean entrou = true;
	
	boolean corra = false; //900 a 9300
	
	Polygon esquerdaHit;
	Polygon direitaHit;
	Rectangle[] obstaculos;
		
	public static Protagonista player;
	
	IndiferencaDialogo indTx;
	
	HUD hud;
	
	Image sala;
	Image salaB;
	
	public static Camera camera;
	
	public SalaA(int state) {
		
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		
		sala = new Image("res/images/fundo/IndCenarioVer4Zoom.png");
		
		salaB = new Image("res/images/fundo/IndCenarioVer3Zoom.png");
		
		esquerdaHit = new Polygon(new float[] {420, 1050, 1470, 1050, 1470, 1470, 1050, 1470,
				1050, 2100, 2310, 2100, 2310, 3570, 2100, 3570, 2100, 3150,840,3150, 840, 3990,
				1260, 3990, 1260, 4830, 2310 ,4830, 2310, 5880,1890,5880, 1890, 5670, 1050, 5670,
				1050, 6510,2310,6510,2310,7140, 1890, 7140,1890,7770,2310,7770, 2310, 8610, 1470, 8610,
				1470,9450,420,9450});
		
		direitaHit = new Polygon(new float[] {2730, 1050,1680, 1050,1680,1680,1260, 1680,
				1260, 1890,2520,1890, 2520, 3780, 1890, 3780, 1890, 3360, 1050, 3360, 1050, 3780,
				1470, 3780, 1470, 4620,2520, 4620, 2520,6090, 1680, 6090, 1680, 5880,1260,5880, 1260, 6300,
				2520, 6300, 2520, 7350,2100,7350,2100,7560, 2520,7560,2520,8820,1680,8820,1680,9450,
				2730,9450});
		
		
		
		
		obstaculos = new Rectangle[] {
				new Rectangle(1470,1050,105,210),
				new Rectangle(1050,1680,105,210),
				new Rectangle(1260,1890,210,105),
				new Rectangle(1890,1995,210,105),
				new Rectangle(2415,2310,105,210),
				new Rectangle(2415,2730,105,210),
				new Rectangle(2310,3150,105,210),
				new Rectangle(2100,3570,210,105),
				new Rectangle(1890,3360,105,210),
				new Rectangle(1680,3255,210,105),
				new Rectangle(1260,3150,210,105),
				new Rectangle(945,3360,105,210),
				new Rectangle(1050,3885,210,105),
				new Rectangle(1365,4200,105,210),
				new Rectangle(1680,4620,210,105),
				new Rectangle(2100,4725,210,105),
				new Rectangle(2310,4830,105,210),
				new Rectangle(2415,5460,35,210),
				new Rectangle(2100,5880,210,105),
				new Rectangle(1680,5880,105,210),
				new Rectangle(1680,5670,210,105),
				new Rectangle(1260,5775,210,105),
				new Rectangle(1190,5880,70,210),
				new Rectangle(1155,6090,105,210),
				new Rectangle(1260,6300,210,105),
				new Rectangle(1470,6300,210,140),
				new Rectangle(1890,6440,420,70),
				new Rectangle(2450,6510,70,210),
				new Rectangle(2310,6720,35,210),
				new Rectangle(2450,6930,70,210),
				new Rectangle(2100,7245,210,105),
				new Rectangle(1890,7350,105,210),
				new Rectangle(2100,7665,210,105),
				new Rectangle(2310,7770,105,210),
				new Rectangle(2450,8190,70,210),
				new Rectangle(2415,8400,105,210),
				new Rectangle(2100,8715,210,105),
				new Rectangle(1680,8610,210,105),
				new Rectangle(1610,8820,70,210),
				new Rectangle(1575,9030,105,210),
				new Rectangle(1470,9240,35,210),
		};
		
		
		player = new Protagonista(gc, VariaveisControle.indiceInicialX, VariaveisControle.indiceInicialY, "baixo");
		
		hud = new HUD(VariaveisControle.indiceInicialX, VariaveisControle.indiceInicialY, player);
		
		camera = new Camera(VariaveisControle.indiceInicialX, VariaveisControle.indiceInicialY);
		
		indTx = new IndiferencaDialogo();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
		camera.seguirOJogador(g);
		
		
		sala.draw();
		
		
		
		g.draw(esquerdaHit);
		g.draw(direitaHit);
		
		for(int i=0; i<obstaculos.length;i++) {
			g.draw(obstaculos[i]);
		}
		
		player.desenhar(g);
		
		hud.desenhar(g, gc, player, camera.getTranslateX(), camera.getTranslateY());
		
		//indTx.desenhar(g, camera.getTranslateX(), camera.getTranslateY());
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		Input input = gc.getInput();
		
		if(player.getProtagonistaY()>900 && player.getProtagonistaY()<9300) {
			corra = true;
		} else {
			corra = false;
		}
		
		if(input.isKeyDown(Input.KEY_ESCAPE)) {
			sbg.enterState(Jogo.menu);
			sbg.getState(Jogo.gameplay).leave(gc, sbg);
		}
		
		if((player.getHitbox().intersects(esquerdaHit) || player.getHitbox().intersects(direitaHit))||
				(!player.getSeMexendo()&&corra==true)) {
			
			// REGISTRAR RECORDE
			
			if(player.getProtagonistaY()>900 && player.getProtagonistaY()<9300) {
				System.out.println(player.getProtagonistaY());
				int r = player.getProtagonistaY()-900;
				if(r>VariaveisControle.yRecorde) {
					VariaveisControle.yRecorde = r;
				}
			}
			
			// MOVER O PLAYER PARA O INÍCIO DA SALA
			
			player.setProtagonistaX(1513);
			player.setProtagonistaY(660);
			if(player.direcao.equals("cima")|| player.direcao.equals("baixo")) {
				player.hitbox.setX(player.protagonistaX+40);
				player.hitbox.setY(player.protagonistaY+100);
			}
			
			else if(player.direcao.equals("direita")) {
				player.hitbox.setX(player.protagonistaX+60);
				player.hitbox.setY(player.protagonistaY+100);				
			}
			else if(player.direcao.equals("esquerda")) {
				player.hitbox.setX(player.protagonistaX+15);
				player.hitbox.setY(player.protagonistaY+100);				
			}
				
			camera.setTranslateX(-1175);
			camera.setTranslateY(-435);
			hud.setHudX(1185);
			hud.setHudY(445);
			player.falhou +=1;
		}
		
		for(int i=0; i<obstaculos.length;i++) {
			if(player.getHitbox().intersects(obstaculos[i])) {
				
				// REGISTRAR RECORDE
				
				if(player.getProtagonistaY()>900) {
					System.out.println(player.getProtagonistaY());
					int r = player.getProtagonistaY()-900;
					if(r>VariaveisControle.yRecorde) {
						VariaveisControle.yRecorde = r;
					}
				}
				
				// MOVER O PLAYER PARA O INÍCIO DA SALA
				
				player.setProtagonistaX(1513);
				player.setProtagonistaY(660);
				if(player.direcao.equals("cima")|| player.direcao.equals("baixo")) {
					player.hitbox.setX(player.protagonistaX+40);
					player.hitbox.setY(player.protagonistaY+100);
				}
				
				else if(player.direcao.equals("direita")) {
					player.hitbox.setX(player.protagonistaX+60);
					player.hitbox.setY(player.protagonistaY+100);				
				}
				else if(player.direcao.equals("esquerda")) {
					player.hitbox.setX(player.protagonistaX+15);
					player.hitbox.setY(player.protagonistaY+100);				
				}
				camera.setTranslateX(-1175);
				camera.setTranslateY(-435);
				hud.setHudX(1185);
				hud.setHudY(445);
				player.falhou +=1;
				
			}
		}
		
		// ATUALIZAÇÃO DO PERSONAGEM, HUD E CÂMERA
		
		player.atualizar(gc);
	
		hud.atualizar(player);
		
		camera.atualizar(player);
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Jogo.gameplay;
	}

}
