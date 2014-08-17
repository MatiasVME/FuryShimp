package org.furygames.screens;

import org.furygames.furyshimp.DataGame;
import org.furygames.furyshimp.FuryShimp;
import org.furygames.furyshimp.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Input.Keys;
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
import com.sun.rowset.internal.Row;

public class LevelsScreen extends GenericScreen{

	private Skin skin;
	private Texture bgTexture;
	private TextureRegion bgRegion;
	private Image background;
	private TextButton levelUnoButton;
	private TextButton levelDosButton;
	private TextButton levelTresButton;
	private TextButton levelCuatroButton;
	private TextButton levelCincoButton;
	private TextButton levelSeisButton;
	private TextButton levelSieteButton;
	private TextButton levelOchoButton;
	private TextButton levelNueveButton;
	private TextButton levelDiezButton;
	private Table table;
	private int level;
	
	public LevelsScreen(final FuryShimp universalMonkey) {
		super(universalMonkey);
		
		skin = new Skin(Gdx.files.internal("uiskin/uiskin.json"));
		
		bgTexture = new Texture("backgrounds/bgbeach.jpg");
		bgRegion = new TextureRegion(bgTexture);
		background = new Image(bgRegion);
		
		levelUnoButton = new TextButton("1", skin);
		levelDosButton = new TextButton("2", skin);
		levelTresButton = new TextButton("3", skin);
		levelCuatroButton = new TextButton("4", skin);
		levelCincoButton = new TextButton("5", skin);
		levelSeisButton = new TextButton("6", skin);
		levelSieteButton = new TextButton("7", skin);
		levelOchoButton = new TextButton("8", skin);
		levelNueveButton = new TextButton("9", skin);
		levelDiezButton = new TextButton("10", skin);
		
		table = new Table();
		table.setFillParent(true);
		table.add(levelUnoButton).pad(50).width(100).height(100);
		table.add(levelDosButton).pad(50).width(100).height(100);
		table.add(levelTresButton).pad(50).width(100).height(100);
		table.add(levelCuatroButton).pad(50).width(100).height(100);
		table.add(levelCincoButton).pad(50).width(100).height(100);
		table.row();
		table.add(levelSeisButton).pad(50).width(100).height(100);
		table.add(levelSieteButton).pad(50).width(100).height(100);
		table.add(levelOchoButton).pad(50).width(100).height(100);
		table.add(levelNueveButton).pad(50).width(100).height(100);
		table.add(levelDiezButton).pad(50).width(100).height(100);
		
		//obtenemos el nivel actual (Por defecto nivel 1)
		level = prefs.getInteger("level", 1);
		
		//accedemos al nivel 1
		levelUnoButton.addListener(new ClickListener(){
            @Override 
            public void clicked(InputEvent event, float x, float y){
            	MenuScreen.getMusic().stop();
            	
            	// Dejamos levels en estado de nivel1
            	GameScreen.levels = Levels.LEVEL1;
            	
            	//Recordamos durante la partida el nivel de juego
            	DataGame.setLevel(1);
            	
            	universalMonkey.setScreen(universalMonkey.getGameScreen());
            }
        });
		
		//accedemos al nivel 2
		levelDosButton.addListener(new ClickListener(){
            @Override 
            public void clicked(InputEvent event, float x, float y){
            	MenuScreen.getMusic().stop();
            	
            	if(level > 1) {
            		// Dejamos levels en estado de level2
            		GameScreen.levels = Levels.LEVEL2;
            		
            		//Recordamos durante la partida el nivel de juego
                	DataGame.setLevel(2);
            		
            		universalMonkey.setScreen(universalMonkey.getGameScreen());
            	}
            }
        });
		
		//accedemos al nivel 3
		levelTresButton.addListener(new ClickListener(){
            @Override 
            public void clicked(InputEvent event, float x, float y){
            	MenuScreen.getMusic().stop();
            	
            	if(level > 2) {
            		GameScreen.levels = Levels.LEVEL3;
            		
            		//Recordamos durante la partida el nivel de juego
                	DataGame.setLevel(3);
            		
            		universalMonkey.setScreen(universalMonkey.getGameScreen());
            	}
            }
        });
		
		//accedemos al nivel 4
		levelCuatroButton.addListener(new ClickListener(){
			@Override 
			public void clicked(InputEvent event, float x, float y){
				MenuScreen.getMusic().stop();
		            	
				if(level > 3) {
					GameScreen.levels = Levels.LEVEL4;
		            		
					//Recordamos durante la partida el nivel de juego
					DataGame.setLevel(4);
		            		
					universalMonkey.setScreen(universalMonkey.getGameScreen());
				}
			}
		});
				
		//accedemos al nivel 5
		levelCincoButton.addListener(new ClickListener(){
			@Override 
			public void clicked(InputEvent event, float x, float y){
				MenuScreen.getMusic().stop();
		            	
				if(level > 4) {
					GameScreen.levels = Levels.LEVEL5;
		            		
		            	//Recordamos durante la partida el nivel de juego
		                DataGame.setLevel(5);
		            		
		            	universalMonkey.setScreen(universalMonkey.getGameScreen());
				}
			}
		});
		
		//accedemos al nivel 6
		levelSeisButton.addListener(new ClickListener(){
			@Override 
			public void clicked(InputEvent event, float x, float y){
				MenuScreen.getMusic().stop();			            	
				
				if(level > 5) {
					GameScreen.levels = Levels.LEVEL6;
				            		
					//Recordamos durante la partida el nivel de juego
					DataGame.setLevel(6);
				            		
					universalMonkey.setScreen(universalMonkey.getGameScreen());
				}
			}
		});
				
		//accedemos al nivel 7
		levelSieteButton.addListener(new ClickListener(){
			@Override 
			public void clicked(InputEvent event, float x, float y){
				MenuScreen.getMusic().stop();
				            	
				if(level > 6) {
					GameScreen.levels = Levels.LEVEL7;
				            		
					//Recordamos durante la partida el nivel de juego
					DataGame.setLevel(7);
				            		
				 	universalMonkey.setScreen(universalMonkey.getGameScreen());
				}
			}
		});
				
		//accedemos al nivel 8
		levelOchoButton.addListener(new ClickListener(){
			@Override 
			public void clicked(InputEvent event, float x, float y){
				MenuScreen.getMusic().stop();
				            	
				if(level > 7) {
					GameScreen.levels = Levels.LEVEL8;
				            		
					//Recordamos durante la partida el nivel de juego
					DataGame.setLevel(8);
				            		
				    universalMonkey.setScreen(universalMonkey.getGameScreen());
				}
			}
		});		
				
		//accedemos al nivel 9
		levelNueveButton.addListener(new ClickListener(){
			@Override 
			public void clicked(InputEvent event, float x, float y){
				MenuScreen.getMusic().stop();
				            	
				if(level > 8) {
					GameScreen.levels = Levels.LEVEL9;
				            		
					//Recordamos durante la partida el nivel de juego
					DataGame.setLevel(9);
				            		
					universalMonkey.setScreen(universalMonkey.getGameScreen());
				}
			}
		});
				
		//accedemos al nivel 10
		levelNueveButton.addListener(new ClickListener(){
			@Override 
			public void clicked(InputEvent event, float x, float y){
				MenuScreen.getMusic().stop();
				            	
				if(level > 9) {
					GameScreen.levels = Levels.LEVEL10;
				            		
				       	//Recordamos durante la partida el nivel de juego
				       	DataGame.setLevel(10);
				            		
				       	universalMonkey.setScreen(universalMonkey.getGameScreen());
				}
			}
		});
		
		stage.addActor(background);
		stage.addActor(table);
	}

	@Override
	public void show() {
		super.show();
		
		// Colocar musica en caso de que no se este reproduciendo
		if (!MenuScreen.getMusic().isPlaying())
			MenuScreen.getMusic().play();
		
		// Para que el nivel necesite serlimpiado
    	GameScreen.setNeedNivelClear(true);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		stage.draw();
		stage.act();
		
		if(Gdx.input.isKeyPressed(Keys.BACK))universalMonkey.setScreen(universalMonkey.getMenuScreen());
	}
}
