package personajes;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;



public class Marine extends PersonajePrefab {
	
	@Override
    public String getNombre() {
        return "Marine";
    }

	@Override
	public void setAnimsiones() {
    
		textureAtlas = new TextureAtlas("SpriteSheets/Marine/Estatico.atlas");
		est = new Animation<TextureRegion>(1f/4F, textureAtlas.getRegions());

		textureAtlas = new TextureAtlas("SpriteSheets/Marine/Caminar.atlas");
		camDer = new Animation<TextureRegion>(1f/8F, textureAtlas.getRegions());


		textureAtlas = new TextureAtlas("SpriteSheets/Marine/Disparar.atlas");
		dis = new Animation<TextureRegion>(1f/3F, textureAtlas.getRegions());

		textureAtlas = new TextureAtlas("SpriteSheets/Marine/Golpear.atlas");
		gol = new Animation<TextureRegion>(1f/5F, textureAtlas.getRegions());
    
		textureAtlas = new TextureAtlas("SpriteSheets/Marine/Dano.atlas");
		dan = new Animation<TextureRegion>(1f/3F, textureAtlas.getRegions());

		textureAtlas = new TextureAtlas("SpriteSheets/Marine/Morir.atlas");
		mue = new Animation<TextureRegion>(1f/6F, textureAtlas.getRegions());
		
		textureAtlas = new TextureAtlas("SpriteSheets/Marine/Levantar.atlas");
		lev = new Animation<TextureRegion>(1f/4F, textureAtlas.getRegions());

		textureAtlas = new TextureAtlas("SpriteSheets/Marine/Festejar.atlas");
		fes = new Animation<TextureRegion>(1f/2F, textureAtlas.getRegions());

	}

    }