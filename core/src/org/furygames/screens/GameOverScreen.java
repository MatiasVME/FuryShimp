package org.furygames.screens;

import org.furygames.furyshimp.FuryShimp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class GameOverScreen extends GenericScreen {
	
	private final float DURATION = 2f; 
	
	private Image splash2;
	private Texture bgTexture;
	private TextureRegion bgRegion;
	private Music music;
	
	private Image splash;
	private TextureRegion splashRegion;
	private Texture splashTexture;
	private ParallelAction pa, pb;

	public GameOverScreen (final FuryShimp universalMonkey) {
		super(universalMonkey);
	}

	@Override
	public void show() {
		super.show();
		
		bgTexture = new Texture("backgrounds/bgbeach.jpg");
		bgRegion = new TextureRegion(bgTexture);
		splash2 = new Image(bgRegion);
		pb = new ParallelAction();
		
		music = Gdx.audio.newMusic(Gdx.files.internal("sounds/levels/Movie Theater Intro_0.mp3"));
		
		splashTexture = new Texture("gameover.png");
		splashRegion = new TextureRegion(splashTexture);
		splash = new Image(splashRegion);
		pa = new ParallelAction();

		splash.setCenterPosition(WIDTH / 2, HEIGHT / 2);
		splash.setOrigin(splash.getWidth() / 2, splash.getHeight() / 2);

		// acciones del splash
		pa.addAction(Actions.fadeOut(DURATION));	
		splash.addAction(pa);
		
		splash2.setAlign(0);
		
		// Cambiar de pantalla 
		Timer.schedule(new Task() {
			@Override
			public void run() {
				universalMonkey.setScreen(universalMonkey.getStatisticScreen());
				splashTexture.dispose();
				bgTexture.dispose();
				music.dispose();
			}
		}, DURATION);

		//insertamos (imagen) dentro del escenario stage
		stage.addActor(splash2);
		stage.addActor(splash);
		music.play();
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		stage.draw();
		stage.act();
	}
	
	@Override
	public void dispose() {

		super.dispose();
	}
}
