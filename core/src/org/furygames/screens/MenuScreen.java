package org.furygames.screens;

import org.furygames.furyshimp.FuryShimp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MenuScreen extends GenericScreen {
	
	private Texture ttStartButton;
	private Texture ttCreditButton;
	private Texture ttExitButton;
	
	private Image startButton;
	private Image creditButton;
	private Image exitButton;
	
	private static Music music = null;

	public MenuScreen (final FuryShimp universalMonkey) {
		super(universalMonkey);
		
		music = Gdx.audio.newMusic(Gdx.files.internal("sounds/Salt Marsh Birds.mp3"));
		
		ttStartButton = new Texture ("buttons/start_button.png");
		ttCreditButton = new Texture ("buttons/credit_button.png");
		ttExitButton = new Texture ("buttons/exit_button.png");

		startButton = new Image(ttStartButton);
		creditButton = new Image(ttCreditButton);
		exitButton = new Image(ttExitButton);
		
		startButton.setSize(256f, 128f);
		creditButton.setSize(256f, 128f);
		exitButton.setSize(256f, 128f);		
		
		startButton.setCenterPosition(WIDTH / 2, 600f);
		creditButton.setCenterPosition(WIDTH / 2, 400f);
		exitButton.setCenterPosition(WIDTH / 2, 200f);
	
		startButton.addListener(new ClickListener(){
			@Override 
			public void clicked(InputEvent event, float x, float y){
				universalMonkey.setScreen(universalMonkey.getLevelsScreen());
			}
		});
		
		creditButton.addListener(new ClickListener(){
			@Override 
			public void clicked(InputEvent event, float x, float y){
				universalMonkey.setScreen(universalMonkey.getCreditsScreen());
			}
		});
		
		exitButton.addListener(new ClickListener(){
			@Override 
			public void clicked(InputEvent event, float x, float y){
				Gdx.app.exit();
			}
		});

		stage.addActor(startButton);
		stage.addActor(creditButton);
		stage.addActor(exitButton);
	}

	@Override
	public void show() {
		super.show();
		
		music.setLooping(true);
		music.play();
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		
		stage.draw();
		stage.act();
	}
	
	public static Music getMusic() {
		return music;
	}
}
