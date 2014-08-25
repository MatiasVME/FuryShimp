package org.furygames.screens;

import org.furygames.furyshimp.FuryShimp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class GameOverScreen extends GenericScreen {
	
	private final float DURATION = 1f; 
	
	private Image background;
	private Texture bgTexture;
	private Music music;
	private ParallelAction pa;

	public GameOverScreen (final FuryShimp universalMonkey) {
		super(universalMonkey);
	}

	@Override
	public void show() {
		super.show();
		
		bgTexture = new Texture("backgrounds/background_gameover.jpg");
		background = new Image(bgTexture);
		
		music = Gdx.audio.newMusic(Gdx.files.internal("sounds/game_over.mp3"));
				
		// Cambiar de pantalla 
		Timer.schedule(new Task() {
			@Override
			public void run() {
				//splashTexture.dispose();
				//bgTexture.dispose();
				music.stop();
				universalMonkey.setScreen(universalMonkey.getLevelsScreen());
			}
		}, DURATION);
		
		music.play();
		
		background.setCenterPosition(WIDTH / 2, HEIGHT / 2);

		pa = new ParallelAction();

		// acciones del splash
		pa.addAction(Actions.fadeOut(DURATION));	
		background.addAction(pa);
			
		// Insertamos (imagen) dentro del escenario stage
		stage.addActor(background);
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
