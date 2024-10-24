package com.dojan.marinevsorko.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import com.dojan.marinevsorko.entradas.TecladoMouse;
import com.dojan.marinevsorko.utiles.*;


public class PantallaMenu implements Screen{

	
	
	Imagen fondo;
	SpriteBatch b;
	Texto opciones[] = new Texto[3];
	int opc = 1;
	String textos[] = {"LOCAL", "ONLINE", "SALIR"};
	public float tiempo = 0;
	
	TecladoMouse entradas = new TecladoMouse(this);
	
	@Override
	public void show() {
		fondo = new Imagen (Recursos.FONDO_MENU);
		b = Render.batch;	
		
		Gdx.input.setInputProcessor(entradas);
		
		int avance = 50;
		
		for(int i = 0; i < opciones.length; i++) {	
			
			opciones[i] = new Texto(Recursos.FUENTE_MENU, 45, Color.WHITE, true);
			opciones[i].setTexto(textos[i]);
			opciones[i].setPosicion( ( Config.WIDTH / 2 ) - ( opciones[i].getAncho() / 2 ) , ( ( Config.HEIGHT / 2) + ( opciones[0].getAlto() / 2 ) ) - ( ( opciones[i].getAlto() * i ) + ( avance * i ) ) );	
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
		
		if(entradas.isAbajo()) {
			if (tiempo > 0.09f) {
				tiempo = 0;
				opc++;
				if( opc > 3) {
					opc = 1;
				}
			}
		}
				
		if(entradas.isArriba()) {
			if (tiempo > 0.09f) {
				tiempo = 0;
				opc--;
				if( opc < 1) {
					opc = 3;
				}
			}
		}
		
		if(entradas.isEnter()) {
			
			if (tiempo > 0.09f) {
				
				switch(opc) {
					case 1:
					tiempo = 0;
					Render.app.setScreen(new PantallaArena());
					break;
					
					case 2:
						break;
						
					case 3:
						Gdx.app.exit();
						break;
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
		
		b.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		dispose();
		b.dispose();
	}
	
	
	
	
	

}
