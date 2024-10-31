package pantallas;

/*
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
*/


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import entradas.TecladoMouse;
import online.Cliente;
import personajes.*;
import personajes.PersonajePrefab.Estado;
import utiles.Config;
import utiles.Imagen;
import utiles.InputEvent;
import utiles.Render;



public class PantallaArena implements Screen, TieneFondo, InputEvent {

	
	/*
	World oWorld;
	
	Imagen fondo;
	Box2DDebugRenderer renderer;
	private TiledMap mapa;
	private OrthogonalTiledMapRenderer r;
	//private PersonajePrefab p1;
	*/
	
	SpriteBatch b;
	float velocidad = 0f,velocidad2=0f;
	float  gravedad = 10f;
	protected Imagen fightstage;
	
	Hud hud;
	HudBarra hb;
	
	float time, time2, ts;
	float period= 0.9f;
	TecladoMouse entradas = new TecladoMouse(this);
	public static String e;
	private int opc;
	private   PersonajePrefab p1;
	private  PersonajePrefab p2;
	
	public PantallaArena(String escenario, PersonajePrefab p1, PersonajePrefab p2){
	    this.e = escenario;
	    this.p1=p1;
	    this.p2=p2;
	    
	    
	    if (Cliente.getHiloC().getIdcliente()==0) {
	        System.out.println("soy el cliente 0");
	        Cliente.enviarMensaje("escenarios");
	        p1.setX(450);
	        p1.setY(Config.HEIGHT/3);
	        p2.setX(700);
	        p2.setY(Config.HEIGHT/3);
	    } else {
	        p1.setX(700);
	        p1.setY(Config.HEIGHT/3);
	        p2.setX(450);
	        p2.setY(Config.HEIGHT/3);
	    }
	    
	    
	    p1.setAnimsiones();
	    p2.setAnimsiones();
	    p1.setEstado(Estado.ESTATICO);
	    p2.setEstado(Estado.ESTATICO);
	    setFondo();	
	    Config.addListInput(this);
	}
	    
	protected void Escenarios(Imagen e2, PersonajePrefab p12, PersonajePrefab p22) {
    }
	
	
	
	
	//public float tiempo = 0;
	

	@Override
	public void show() {
		
		/*
		fondo = new Imagen (Recursos.FONDO_ARENA);
		b = Render.batch;
		mapa =  new TmxMapLoader().load(Recursos.MAPA);
		r = new OrthogonalTiledMapRenderer(mapa);
		p1.currentFrame = p1.est.getKeyFrame(1);
		Gdx.input.setInputProcessor(entradas);
		p1 = new PersonajePrefab (est, camDer, camIzq, dis, gol, dan, lev, mue, fes, (TiledMapTileLayer) mapa.getLayers().get(0));
		p1.setPosition(12 * p1.getCapaColision().getWidth(), 22 * p1.getCapaColision().getHeight());
		p1.setSize(60f,60f);
		*/
		
        b= Render.batch;
        hud= new Hud(b);
        hb= new HudBarra();
        
        p1.currentFrame = p1.est.getKeyFrame(1);
        p2.currentFrame = p2.est.getKeyFrame(1);

        Gdx.input.setInputProcessor(entradas);
	}
	
	float a;
	
	@Override
	public void render(float delta) {
		
		
		/*
		Render.LimpPant();
		r.setView((OrthographicCamera) Config.camara);
		r.render();
		r.getBatch().begin();
		p1.draw(r.getBatch());
		r.getBatch().end();
		
		tiempo += delta;
		
		//p1.setRegion(p1.velocidad.x < 0 ? p1.camIzq.getKeyFrame(p1.tiempoAnimacion) : p1.velocidad.x > 0 ? p1.camDer.getKeyFrame(p1.tiempoAnimacion) : p1.est.getKeyFrame(p1.tiempoAnimacion));

		if(entradas.isA()) {
			p1.velocidad.x = -p1.rapidez;
			p1.setRegion(p1.camIzq.getKeyFrame(p1.tiempoAnimacion));
			
		} else {
			p1.velocidad.x = 0;
			p1.setRegion(p1.est.getKeyFrame(p1.tiempoAnimacion));
		}
		if(entradas.isD()) {
			p1.setRegion(p1.camDer.getKeyFrame(p1.tiempoAnimacion));
			p1.velocidad.x = p1.rapidez;
		}
		if(entradas.isC()) {
			p1.setRegion(p1.dis.getKeyFrame(p1.tiempoAnimacion));
			entradas.setC(false);
		} else {
			entradas.setC(false);
		}
		/*
		if(entradas.isW()) {
			if (tiempo > 1) {
				
				tiempo = 0;
				if(p1.puedeSaltar) {
					p1.velocidad.y = 1000;
					
					} else {
						p1.velocidad.y = 0;
						p1.puedeSaltar = false;
					}
			}
		*/	
			
		
		
		
		
		inputSelec();
        time += delta;
        time2 += delta;
        ts+=delta;
        
        if (ts>08f ) {
        	movement();
        	ts=0;
        }
        
        Render.LimpPant();
       
        b.begin();
        
        fightstage.dibujar();
        b.draw(p1.currentFrame, p1.getX(), p1.getY());
        b.draw(p2.currentFrame, p2.getX(), p2.getY());
        a+=0.1f;
        
        b.end();
        
        
        b.begin();
        hb.dibujar();
        b.end();
		
        ActualizarBarras();

        hud.mostrarHud();
        hud.getCuentaAtras().setText(hud.getSec());

        
        if (hud.getSec()<=0) {
        	hud.terminarTimer();
        	Render.app.setScreen(new PeleaTerminada(e));
        	
        } else if (p1.getVidaActual()<=0 ||p2.getVidaActual()<=0 ) {
        	Render.app.setScreen(new PeleaTerminada(e));
        }
	}
	
	private void movement(){

        System.out.println(p1.getEstado());
        System.out.println(p2.getEstado());
        p1.setY(p1.getY() + (velocidad -= gravedad));

        if(p1.getY() <= Config.HEIGHT/3){
            p1.setY(Config.HEIGHT/3);
            p1.setEstado(Estado.ESTATICO);

            Cliente.enviarMensaje("estatico");
        }

        p2.setY(p2.getY() + (velocidad2 -= gravedad));

        if(p2.getY() <= Config.HEIGHT/3){
            p2.setY(Config.HEIGHT/3);
            Cliente.enviarMensaje("estatico");

        }
       
        if((entradas.isW() && p1.getEstado() == Estado.ESTATICO) || ((entradas.isW() && entradas.isD()) && p1.getEstado() == Estado.CAMINAR) ){
            
            p1.setEstado(Estado.ESTATICO);
            velocidad = 50;
            Cliente.enviarMensaje("arriba");
            
        } else if(entradas.isX() && (!p1.a2) || (!p1.dis.isAnimationFinished(time) && p1.a1) ) {
            p1.a1 = true;
            p1.setEstado(Estado.DISPARAR);
            Cliente.enviarMensaje("ataqued");
            
        } else if(entradas.isC() && (!p1.a1) || (!p1.gol.isAnimationFinished(time) && p1.a2) ) {
            p1.a2 = true;
            p1.setEstado(Estado.GOLPEAR);
            Cliente.enviarMensaje("golpear");
            
        } else if(entradas.isD() && (!p1.a2 && !p1.a1)) {
            p1.setEstado(Estado.CAMINAR);
            p1.setX(p1.getX() + 20);
            Cliente.enviarMensaje("derecha");
            
        } else if(entradas.isA() && (!p1.a2 && !p1.a1)) {
            p1.setEstado(Estado.CAMINARI);
            p1.setX(p1.getX() - 20);
            Cliente.enviarMensaje("izquierda");
            
        } else {
           Cliente.enviarMensaje("estatico");
        }
        
        p1.setEstadoAnterior(p1.getEstado());

        switch(p1.getEstado()){						//----------------------------------------------------------
        
        
        	case DISPARAR:
            	p1.currentFrame = p1.dis.getKeyFrame(time);
            	flip();
            	if(p1.dis.isAnimationFinished(time)){
            		time = 0;
            	}
            	p1.a2 = false;
            	
            	break;
            
            
            
            case GOLPEAR:
            	p1.currentFrame = p1.gol.getKeyFrame(time);
            	flip();
            	if(p1.gol.isAnimationFinished(time)){
            		time = 0;
            	}
            	p1.a1 = false;
            	
            break;
            
            case CAMINAR:
            	p1.currentFrame = p1.camDer.getKeyFrame(time);
            	if(p1.currentFrame.isFlipX()){
            		p1.currentFrame.flip(true, false);
            	}
            	if(p1.camDer.isAnimationFinished(time)){
            		time = 0;
            	}
            	break;
            
            case CAMINARI:
            	p1.currentFrame = p1.camDer.getKeyFrame(time);
            	if(!p1.currentFrame.isFlipX()){
            		p1.currentFrame.flip(true, false);
            	}
            	if(p1.camDer.isAnimationFinished(time)){
            		time = 0;
            	}
            	break;
            
            case DANO:
            	p1.currentFrame = p1.dan.getKeyFrame(time);
            	flip();
            	break;
            
            default:
            	p1.a1 = false;
            	p1.a2 = false;
            	
            	p1.currentFrame = p1.est.getKeyFrame(time,true);
            	flip();
                break;
        }

        p2.setEstadoAnterior(p2.getEstado());

        switch(p2.getEstado()){						//----------------------------------------------------------
	
		
    		case DISPARAR:
    		
    			p2.currentFrame = p2.dis.getKeyFrame(time2);
    			flip2();
    			if(p2.dis.isAnimationFinished(time2)){
    				time2 = 0;
    			}
    			p2.a2 = false;
    			break;
    
    
    		case GOLPEAR:
    
    			p2.currentFrame = p2.gol.getKeyFrame(time2);
    			flip2();
    			if(p2.gol.isAnimationFinished(time2)){
    				time2 = 0;
    			}
    			p2.a1 = false;
    			break;
    
    
    		case CAMINAR:
    			p2.currentFrame = p2.camDer.getKeyFrame(time2);
    			if(p2.currentFrame.isFlipX()){
    				p2.currentFrame.flip(true, false);
    			}
    			if(p2.camDer.isAnimationFinished(time2)){
    				time2 = 0;
    			}
    			break;
    
    
    		case CAMINARI:
    			p2.currentFrame = p2.camDer.getKeyFrame(time2);
    			if(!p2.currentFrame.isFlipX()){
    				p2.currentFrame.flip(true, false);
    			}
    			if(p2.camDer.isAnimationFinished(time2)){
    				time2 = 0;
    			}
    			break;
    
    
    		case DANO:
    			p1.currentFrame = p2.dan.getKeyFrame(time);
    			flip2();
    			break;
            
            
    		default:
    			p2.a1 = false;
    			p2.a2 = false;
    
    			p2.currentFrame = p2.est.getKeyFrame(time2,true);
    			flip2();
    			break;
        }

        Cliente.enviarMensaje("posx,"+p1.getX());
        Cliente.enviarMensaje("posy"+p1.getY());

	}
	
	private void ActualizarBarras() {
		
	    if (p1.getVidaActual()!=p1.getVidamax()) {
	           hb.Restarvida1(p1.getVidaActual());
	    }
	    
	    if (p2.getVidaActual()!=p2.getVidamax()) {
	        hb.Restarvida2(100-p2.getVidaActual());
	    }
	}
	
	
	public int inputSelec() {
		
	    if(!Config.ONLINE){
	    	try {
	            synchronized(entradas){
	                  entradas.wait(90);
	            }
	    	} catch (InterruptedException e) {
	    		e.printStackTrace();
	        }
	    	
	    	if (entradas.isAbajo()) {
	    		if (opc==0) {
	    			opc=3;
	    		} else {
	    			opc--;
	    		}
	        }
	    	
	        if (entradas.isArriba()) {
	        	if(opc==3){
	        		opc=0;
	        	} else {
	        		opc++;
	        	}
	        }
	    }
	    return opc;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void flip(){
        if(p1.getX() > p2.getX() && !p1.currentFrame.isFlipX()){
            p1.currentFrame.flip(true, false);
        }
        else if(p1.getX() < p2.getX() && p1.currentFrame.isFlipX()){
        p1.currentFrame.flip(true, false);
        }
    }
	
	public void flip2(){

        if(p2.getX() > p1.getX() && !p2.currentFrame.isFlipX()){
            p2.currentFrame.flip(true, false);
        }
        else if(p2.getX() < p1.getX() && p2.currentFrame.isFlipX()){
        p2.currentFrame.flip(true, false);
        }
    }
	
	public void setFondo() {
	    fightstage= new Imagen(e);
	    fightstage.setSize(Config.tamanioDeAlgo(100, Config.WIDTH),Config.tamanioDeAlgo(100, Config.HEIGHT));
	    fightstage.setPosition(Config.centrado(Config.WIDTH), Config.centrado(Config.HEIGHT));
	}
	
	public void handleInput() {
        // System.out.println("handle input de escenario");
		
        if (Cliente.getMsg().equals("hp")) {
            if (Cliente.getHiloC().getPersona()==0) {
                p1.setVidaActual((int)Cliente.getCantidad());
                p1.setEstado(Estado.DANO);
                // synchronized(entradas){
                //     try {
                //         entradas.wait(500);
                //     } catch (InterruptedException e) {
                //         // TODO Auto-generated catch block
                //         e.printStackTrace();
                //     }
                // }
            }
            else if(Cliente.getHiloC().getPersona()==1){
                p2.setVidaActual((int)Cliente.getCantidad());
                p2.setEstado(Estado.DANO);
                // synchronized(entradas){
                //     try {
                //         entradas.wait(500);
                //     } catch (InterruptedException e) {
                //         // TODO Auto-generated catch block
                //         e.printStackTrace();
                //     }
                // }
            }
        }

       if (Cliente.getHiloC().MiPropioMensaje()) {

    	   switch (Cliente.getMsg()) {
        
            	case "posx":
            		p1.setX(Cliente.getCantidad());
            		break;
            
            	case "izquierda":
            		break;
            
            	case "derecha":
            		break;
            
            	case "arriba":
            		break;
            
            	case "disparar":
            		p1.setEstado(Estado.DISPARAR);
            		break;
            
            	case "golpear":
            		p1.setEstado(Estado.GOLPEAR);
            		break;
            
            	default:
            		break;
    	   }
        
       } else if(!Cliente.getHiloC().MiPropioMensaje()) {

    	   switch (Cliente.getMsg()) {
         
    	   		case "posx":
    	   			p2.setX(Cliente.getCantidad());
    	   			break;
            
    	   		case "izquierda":
    	   			p2.setEstado(Estado.CAMINARI);
    	   			break;
            
    	   		case "derecha":
    	   			p2.setEstado(Estado.CAMINAR);
    	   			break;
            
    	   		case "arriba":
    	   			velocidad2=50;
    	   			p2.setEstado(Estado.ESTATICO);
    	   			break;
            
    	   		case "stance":
    	   			p2.setEstado(Estado.ESTATICO);
    	   			break;
            
    	   		case "ataquef":
    	   			p2.setEstado(Estado.DISPARAR);
    	   			break;
            
    	   		case "ataquem":
    	   			p2.setEstado(Estado.GOLPEAR);
    	   			break;
            
    	   		default:
    	   			break;
    	   }
    	   
    	   Cliente.enviarMensaje("posx,"+p1.getX());
    	   Cliente.enviarMensaje("posy"+p1.getY());
       }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
		dispose();
	}

	@Override
	public void dispose() {
		//dispose();
		//r.dispose();
		//p1Atlas.dispose();
		
		p1.dispose();
	    p2.dispose();
	    b.dispose();
	    hud.dispose();
	   	fightstage.dispose();
	    hb.dispose();
		
		
	}
}
