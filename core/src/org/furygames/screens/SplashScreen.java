package org.furygames.screens;

import org.furygames.furyshimp.FuryShimp;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class SplashScreen extends GenericScreen {


	private final float DURATION = 4.2f; // Segundos
	
	private Image splash2;
	private Texture bgTexture; //textura para el fondo
	private TextureRegion bgRegion;
	private Music music;
	
	private Image splash;
	private TextureRegion splashRegion;
	private Texture splashTexture;
	private ParallelAction pa;

	public SplashScreen (FuryShimp universalMonkey) {
		super(universalMonkey);
		
		bgTexture = new Texture("backgrounds/bgbeach.jpg");
		bgRegion = new TextureRegion(bgTexture);
		splash2 = new Image(bgRegion);
		
		//music = Gdx.audio.newMusic(Gdx.files.internal("sounds/levels/Movie Theater Intro.mp3"));
		
		splashTexture = new Texture("logo.png");
		splashRegion = new TextureRegion(splashTexture);
		splash = new Image(splashRegion);
		pa = new ParallelAction();

		splash.setCenterPosition(WIDTH / 2, HEIGHT / 2);
		splash.setOrigin(splash.getWidth() / 2, splash.getHeight() / 2);

		// acciones del splash
		pa.addAction(Actions.fadeOut(DURATION));
		pa.addAction(Actions.rotateBy(17, DURATION));	
		splash.addAction(pa);
		
		splash2.setAlign(0);
		
		// insertamos (imagen) dentro del escenario stage
		stage.addActor(splash2);
		stage.addActor(splash);
	}

	@Override
	public void show() {
		super.show();
		
		// Cambiar de pantalla 
		Timer.schedule(new Task() {
			@Override
			public void run() {
				splashTexture.dispose();
				bgTexture.dispose();
				//music.stop();
				//music.dispose();
				universalMonkey.setScreen(universalMonkey.getMenuScreen());
			}
		}, DURATION);
		
		//music.play();
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		stage.draw();
		stage.act();
	}
}
