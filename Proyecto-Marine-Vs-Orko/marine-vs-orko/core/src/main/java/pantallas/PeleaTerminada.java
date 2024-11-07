package pantallas;

import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.Viewport;

import online.Cliente;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;

import pantallas.Hud;
import pantallas.HudBarra;
import pantallas.PantallaMenu;
import personajes.PersonajePrefab;
import utiles.Config;
import utiles.Imagen;
import utiles.Render;



	public class PeleaTerminada  extends PantallaArena {
		private SpriteBatch b;
		private boolean fadeInTerminado = false, termina = false;
		private float a = 0;
		private Stage stage;
		private Label label;
		private Viewport viewport;
 
		private float countTime = 0, waitTime = 5;
		private float countTimerEnd = 0, timeEnde = 5;
		private String winner;
		private Imagen endstage;
		
		public PeleaTerminada(String e){
        
			super(e,Cliente.getJ1(),Cliente.getJ1());
        
			if (Cliente.getJ1().getVidaActual()>Cliente.getJ2().getVidaActual()) {
				winner="gano el cliente 1";
				endstage= new Imagen(Cliente.getJ1().getEnd());
				
			} else if (Cliente.getJ2().getVidaActual()>Cliente.getJ2().getVidaActual()){
				winner ="gano el cliente 2";
				endstage=new Imagen(Cliente.getJ2().getEnd());
			}
			
			b= Render.batch;
			viewport = new FitViewport( Config.WIDTH,Config.HEIGHT, new OrthographicCamera());
			stage = new Stage(viewport,b);
			Table table = new Table();
			table.center();
			table.setFillParent(true);
			label = new Label(winner ,new Label.LabelStyle(new BitmapFont(),Color.GOLD));
			table.add(label).expandX().padTop(10);
			table.row();
			table.setScale(200f, 200f);
			stage.addActor(table);
			endstage.setSize(Config.WIDTH,Config.HEIGHT);
		}   
     
   
 
 


		@Override
		public void show() {
			//   fightstage.setTransparencia(1f);
			setFondo();
        }

		@Override
		public void render(float delta) {
			Render.LimpPant();
			procesarFade();
			b.begin();
			endstage.dibujar();
			b.end();
			stage.draw();
		}
		
		private void procesarFade() {
		
			fightstage.setTransparencia(a);
		
			if (!fadeInTerminado) {
			
				a += 0.01f;
				if (a > 1) {
					a = 1;
					fadeInTerminado = true;
				}
			
			} else {
			
				countTime+=0.07f;
				if(countTime > waitTime) {
				
					a -= 0.01f;
					if (a < 0) {
					
						a = 0;
						termina = true;
					}
				}
			}
		
			fightstage.setTransparencia(a);
			if(termina){
			
				countTimerEnd+=0.1f;
				if(countTimerEnd>timeEnde){
				
					Config.ONLINE=false;
					Render.app.setScreen(new PantallaMenu());
					Cliente.enviarMensaje("cerrar");
					Cliente.getHiloC().interrupt();
                
				}
			}
		}
	
	
		@Override
		public void resize(int width, int height) {
		}

		@Override
		public void pause() {
		}

		@Override
		public void resume() {
		}
    
		@Override
		public void hide() {
		}

		@Override
		public void dispose() {  
    	   b.dispose();
    	   fightstage.dispose();
    	   endstage.dispose();
    	   stage.dispose();
		}
	}


