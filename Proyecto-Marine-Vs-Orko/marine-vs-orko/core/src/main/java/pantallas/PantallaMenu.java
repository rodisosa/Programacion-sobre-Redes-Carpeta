package pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import entradas.TecladoMouse;
import online.Cliente;
import utiles.*;

public class PantallaMenu implements Screen{

	
	
	Imagen fondo;
	SpriteBatch b;
	Texto opciones[] = new Texto[2];
	int opc = 1;
	String textos[] = {"ONLINE", "SALIR"};
	public float tiempo = 0;
	TecladoMouse entradas = new TecladoMouse(this);
	
	Cliente cl;
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void show() {
		
		entradas.startInput();
		
		fondo = new Imagen (Recursos.FONDO_MENU);
		
		fondo.setSize(Config.WIDTH, Config.HEIGHT);
		
		b = Render.batch;	
		
		Gdx.input.setInputProcessor(entradas);
		
		int avance = 50;
		
		for(int i = 0; i < opciones.length; i++) {	
			
			opciones[i] = new Texto(Recursos.FUENTE_MENU, 45, Color.WHITE, true);
			opciones[i].setTexto(textos[i]);
			opciones[i].setPosicion( ( Config.WIDTH / 2 ) - ( opciones[i].getAncho() / 2 ) , ( ( Config.HEIGHT / 2) + ( opciones[0].getAlto() / 2 ) ) - ( ( opciones[i].getAlto() * i ) + ( avance * i ) ) );	
		}
	}

	private void inputwait() {

        synchronized(entradas){
            try {
                entradas.wait(100);
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
        }
    }
	
	public  void labelInput(){
		 
		if(entradas.isAbajo()){ 	//entradas = input entrys
			inputwait();			
			if(tiempo > 0.5f){ 	//tiempo = time
				tiempo = 0;
				opc++;			// opc= option;
				if(opc > 2){
					opc = 1;
				}
			}
		}
		if(entradas.isArriba()){
			inputwait();
			if(tiempo > 0.5f){
				tiempo = 0;
				opc--;
				if(opc < 1){
					opc = 2;
				}
			}
		}
		
		for(int i = 0; i < opciones.length; i++) {
			
			if (i==(opc-1)) {
				opciones[i].setColor(Color.YELLOW);
			} else {
				opciones[i].setColor(Color.WHITE);
			}
		}
		
		if(entradas.isEnter()){
			inputwait();
	
			switch(opc){

				case 1:
					cl= new Cliente();
					entradas.stopInput();
					break;
					
				case 2:
					Gdx.app.exit();
					break;
			}
		}
	}
	
	@Override
	public void render(float delta) {
		Render.LimpPant();

		b.begin();
		
		fondo.dibujar();
		
		for(int i = 0; i < opciones.length; i++) {	
			opciones[i].dibujar();
		}
		
		tiempo += delta;
		labelInput();
		
		b.end();
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
		dispose();
		b.dispose();
	}
}