package org.furygames.screens;

import org.furygames.furyshimp.DataGame;
import org.furygames.furyshimp.FuryShimp;
import org.furygames.furyshimp.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
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
	private Texture imgLock;
	private TextureRegion lock;
	private Button levelUnoButton;
	private Button levelDosButton;
	private Button levelTresButton;
	private Button levelCuatroButton;
	private Button levelCincoButton;
	private Button levelSeisButton;
	private Table table;
	private int level;
	private Texture ttBackButton;
	private Image imgBackButton;
	
	public LevelsScreen(final FuryShimp universalMonkey) {
		super(universalMonkey);
		
		skin = new Skin(Gdx.files.internal("uiskin/uiskin.json"));
		
		bgTexture = new Texture("backgrounds/bg-levels.jpg");
		bgRegion = new TextureRegion(bgTexture);
		background = new Image(bgRegion);
		
		imgLock = new Texture(Gdx.files.internal("extras/lock.png"));
		lock = new TextureRegion(imgLock);
		
		// Back button
		ttBackButton = new Texture("buttons/back_button.png");
		imgBackButton = new Image(ttBackButton);
		imgBackButton.setSize(80, 82);
		imgBackButton.setPosition(GameScreen.WIDTH - 128f, 0);
		
		imgBackButton.addListener(new ClickListener(){
            @Override 
            public void clicked(InputEvent event, float x, float y){
            	universalMonkey.setScreen(universalMonkey.getMenuScreen());
            }
        });
	}

	@Override
	public void show() {
		super.show();
		
		//universalMonkey.myRequestHandler.showOrLoadInterstital();
		
		// Colocar musica en caso de que no se este reproduciendo
		if (!MenuScreen.getMusic().isPlaying())
			MenuScreen.getMusic().play();
		
		// obtenemos el nivel actual (Por defecto nivel 1)
		if (GameScreen.getPreferences() != null)
			level = GameScreen.getPreferences().getInteger("max-level", 1);
		
		// Para que el nivel necesite serlimpiado
    	GameScreen.setNeedNivelClear(true);
    	
    	level = GameScreen.getPreferences().getInteger("max-level", 1);
		
		if(level >= 0)
		{
			levelUnoButton = new TextButton("1", skin);
			
			//accedemos al nivel 1
			levelUnoButton.addListener(new ClickListener(){
	            @Override 
	            public void clicked(InputEvent event, float x, float y){
	                	MenuScreen.getMusic().stop();

	            		// Dejamos levels en estado de level2
	            		GameScreen.levels = Levels.LEVEL1;
	            		
	            		//Recordamos durante la partida el nivel de jue1go
	                	DataGame.setLevel(1);
	            		
	            		universalMonkey.setScreen(universalMonkey.getGameScreen());
	            }
	        });
			
		}else{
			levelUnoButton = new Button(new Image(lock), skin);
		}
		
		if(level >= 2)
		{
			levelDosButton = new TextButton("2", skin);
			
			//accedemos al nivel 2
			levelDosButton.addListener(new ClickListener(){
	            @Override 
	            public void clicked(InputEvent event, float x, float y){
	            	
	                	MenuScreen.getMusic().stop();

	            		// Dejamos levels en estado de level2
	            		GameScreen.levels = Levels.LEVEL2;
	            		
	            		//Recordamos durante la partida el nivel de juego
	                	DataGame.setLevel(2);
	            		
	            		universalMonkey.setScreen(universalMonkey.getGameScreen());
	            }
	        });
		}else{
			levelDosButton = new Button(new Image(lock), skin);
		}
		
		if(level >= 3)
		{
			levelTresButton = new TextButton("3", skin);
			
			//accedemos al nivel 3
			levelTresButton.addListener(new ClickListener(){
	            @Override 
	            public void clicked(InputEvent event, float x, float y){
	     
	            		MenuScreen.getMusic().stop();
	            		GameScreen.levels = Levels.LEVEL3;
	            		
	            		//Recordamos durante la partida el nivel de juego
	                	DataGame.setLevel(3);
	            		
	            		universalMonkey.setScreen(universalMonkey.getGameScreen());
	            }
	        });
		}else{
			levelTresButton = new Button(new Image(lock), skin);
		}
		
		if(level >= 4)
		{
			levelCuatroButton = new TextButton("4", skin);
			
			//accedemos al nivel 4
			levelCuatroButton.addListener(new ClickListener(){
				@Override 
				public void clicked(InputEvent event, float x, float y){
					MenuScreen.getMusic().stop();

						GameScreen.levels = Levels.LEVEL4;
			            		
						//Recordamos durante la partida el nivel de juego
						DataGame.setLevel(4);
			            		
						universalMonkey.setScreen(universalMonkey.getGameScreen());
				}
			});
		}else{
			levelCuatroButton = new Button(new Image(lock), skin);
		}
		
		if(level >= 5)
		{
			levelCincoButton = new TextButton("5", skin);
			
			//accedemos al nivel 5
			levelCincoButton.addListener(new ClickListener(){
				@Override 
				public void clicked(InputEvent event, float x, float y){
						MenuScreen.getMusic().stop();
						GameScreen.levels = Levels.LEVEL5;
			            		
						//Recordamos durante la partida el nivel de juego
						DataGame.setLevel(5);
			            		
						universalMonkey.setScreen(universalMonkey.getGameScreen());
				}
			});
		}else{
			levelCincoButton = new Button(new Image(lock), skin);
		}
		
		if(level >= 6)
		{
			levelSeisButton = new TextButton("6", skin);
			
			//accedemos al nivel 6
			levelSeisButton.addListener(new ClickListener(){
				@Override 
				public void clicked(InputEvent event, float x, float y){			
						MenuScreen.getMusic().stop();	
						GameScreen.levels = Levels.LEVEL6;
					            		
						//Recordamos durante la partida el nivel de juego
						DataGame.setLevel(6);
					            		
						universalMonkey.setScreen(universalMonkey.getGameScreen());
				}
			});
					
		}else{
			levelSeisButton = new Button(new Image(lock), skin);
		}
		
		table = new Table();
		table.setFillParent(true);
		table.add(levelUnoButton).pad(50).width(100).height(100);
		table.add(levelDosButton).pad(50).width(100).height(100);
		table.add(levelTresButton).pad(50).width(100).height(100);
		table.row();
		table.add(levelCuatroButton).pad(50).width(100).height(100);
		table.add(levelCincoButton).pad(50).width(100).height(100);
		table.add(levelSeisButton).pad(50).width(100).height(100);
		
		stage.addActor(background);
		stage.addActor(table);
		stage.addActor(imgBackButton);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		stage.draw();
		stage.act();
		
		if(Gdx.input.isKeyPressed(Keys.BACK))universalMonkey.setScreen(universalMonkey.getMenuScreen());
	}
}
