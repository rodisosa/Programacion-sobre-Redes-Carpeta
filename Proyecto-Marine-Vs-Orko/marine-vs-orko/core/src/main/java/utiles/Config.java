package utiles;


import java.util.ArrayList;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

//import com.dojan.marinevsorko.pantallas.PantallaArena;


public class Config {
	
	public static final int WIDTH = 896;		// Ancho de la pantalla  
	public static final int HEIGHT = 480;		// Alto de la pantalla
	public static boolean ONLINE=false;
	
	
	
	
	public static final float GRAVEDAD = 0.4f;
	public static final int TAMANIO_TILE = 32;
	public static Camera camara;
	public static SpriteBatch b;
	private static Viewport v;
	
	private static int proporcion;
	
	
	private static ArrayList<InputEvent> listInput= new ArrayList<InputEvent>();
	
	public static  void iniciarCamara(){
		
			camara = new OrthographicCamera(WIDTH,HEIGHT);
	        camara.normalizeUp();
	        v = new FitViewport(WIDTH, HEIGHT, camara); 
	        v.update(WIDTH, HEIGHT,true);
	        Render.batch.setProjectionMatrix(camara.combined);
	}
	 
	public static Viewport getViewport() {
		return v; 
	}
	
	public static void updateCamara(){
		camara.update();
	}
	
	public static ArrayList<InputEvent> getListInput() {
	    return listInput;
	}
	
	public static void addListInput(InputEvent list){
	    listInput.add(list);
	}

	public static void eraseInput(Object pos){
		listInput.remove(pos);
	}
	
	public static float tamanioDeAlgo(int porc,float f){
	    proporcion = porc;
	   return (porc*f/100);
	}
	
	public static float centrado(float f){

	    return (f/2-(Config.tamanioDeAlgo(proporcion,f))/2);
	}
	
	public static float SacarPorcentaje(float nmb, int xyvalue){
        return (nmb*xyvalue/100);
    }
	
	 
	
	
	 
	
	
	
	
	
	
	
	
	 
	 
}
