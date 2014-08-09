package org.furygames.screens;

import org.furygames.furyshimp.DataGame;
import org.furygames.furyshimp.FuryShimp;
import org.furygames.furyshimp.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class LevelsScreen extends GenericScreen{

	private Skin skin;
	private Texture bgTexture;
	private TextureRegion bgRegion;
	private Image background;
	private TextButton levelUnoButton;
	private TextButton levelDosButton;
	private TextButton levelTresButton;
	private Table table;
	private int level;
	
	public LevelsScreen(final FuryShimp universalMonkey) {
		super(universalMonkey);
	}
	
	@Override
	public void show() {
		super.show();
		
		skin = new Skin(Gdx.files.internal("uiskin/uiskin.json"));
		
		bgTexture = new Texture("backgrounds/bgbeach.jpg");
		bgRegion = new TextureRegion(bgTexture);
		background = new Image(bgRegion);
		
		levelUnoButton = new TextButton("1", skin);
		levelDosButton = new TextButton("2", skin);
		levelTresButton = new TextButton("3", skin);
		
		table = new Table();
		table.setFillParent(true);
		table.add(levelUnoButton).pad(50).width(100).height(100);
		table.add(levelDosButton).pad(50).width(100).height(100);
		table.add(levelTresButton).pad(50).width(100).height(100);

		//obtenemos el nivel actual (Por defecto nivel 1)
		level = prefs.getInteger("level", 1);
		
		//accedemos al nivel 1
		levelUnoButton.addListener(new ClickListener(){
            @Override 
            public void clicked(InputEvent event, float x, float y){
            	
            	// Dejamos levels en estado de nivel1
            	GameScreen.levels = Levels.LEVEL1;
            	
            	universalMonkey.setScreen(universalMonkey.getGameScreen());
            	
            	//Recordamos durante la partida el nivel de juego
            	DataGame.setLevel(1);
            }
        });
		
		//accedemos al nivel 2
		levelDosButton.addListener(new ClickListener(){
            @Override 
            public void clicked(InputEvent event, float x, float y){
            
            	if(level > 1)
            	{
            		// Dejamos levels en estado de level2
            		GameScreen.levels = Levels.LEVEL2;
            		
            		universalMonkey.setScreen(universalMonkey.getGameScreen());
            		
            		//Recordamos durante la partida el nivel de juego
                	DataGame.setLevel(2);
            	}
        	
            }
        });
		
		//accedemos al nivel 3
		levelTresButton.addListener(new ClickListener(){
            @Override 
            public void clicked(InputEvent event, float x, float y){
            	
            	if(level > 2)
            	{
            		GameScreen.levels = Levels.LEVEL3;
            		
            		universalMonkey.setScreen(universalMonkey.getGameScreen());
            		
            		//Recordamos durante la partida el nivel de juego
                	DataGame.setLevel(3);
            	}
            	
            }
        });
		
		stage.addActor(background);
		stage.addActor(table);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		stage.draw();
		stage.act();
	}

}
