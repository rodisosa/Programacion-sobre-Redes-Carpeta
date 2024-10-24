package com.dojan.marinevsorko.entradas;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.dojan.marinevsorko.pantallas.PantallaMenu;

public class TecladoMouse implements InputProcessor{

	private boolean arriba = false, abajo = false;
	PantallaMenu app;
	
	
	
	public TecladoMouse (PantallaMenu app) {
		this.app = app;
	}
	
	
	
	public boolean isArriba() {
		return arriba;
	}

	
	
	public boolean isAbajo() {
		return abajo;
	}

	
	
	@Override
	public boolean keyDown(int keycode) {
		
		app.tiempo = 0;
		
		
		
		if(keycode == Keys.DOWN) {
			abajo = true;
			
			
		} else if(keycode == Keys.UP) {
			arriba = true;
			
		}
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		if(keycode == Keys.DOWN) {
			abajo = false;
		} else if(keycode == Keys.UP) {
			arriba = false;
		}
		
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
