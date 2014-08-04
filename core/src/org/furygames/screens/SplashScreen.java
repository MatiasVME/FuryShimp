package org.furygames.screens;

import org.furygames.furyshimp.FuryShimp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class SplashScreen extends GenericScreen {


	private final float DURATION = 1f; // Segundos

	private Image splash;
	private TextureRegion splashRegion;
	private Texture splashTexture;
	private ParallelAction pa;

	public SplashScreen (final FuryShimp universalMonkey) {
		super(universalMonkey);
	}

	@Override
	public void show() {
		super.show();

		splashTexture = new Texture("splash.png");
		splashRegion = new TextureRegion(splashTexture);
		splash = new Image(splashRegion);
		pa = new ParallelAction();

		splash.setCenterPosition(WIDTH / 2, HEIGHT / 2);
		splash.setOrigin(splash.getWidth() / 2, splash.getHeight() / 2);

		// acciones del splash
		pa.addAction(Actions.fadeOut(DURATION));
		pa.addAction(Actions.rotateBy(20, DURATION));	
		splash.addAction(pa);

		// Cambiar de pantalla 
		Timer.schedule(new Task() {
			@Override
			public void run() {
				universalMonkey.setScreen(universalMonkey.getMenuScreen());
				splashTexture.dispose();
			}
		}, DURATION);

		//insertamos (imagen) dentro del escenario stage
		stage.addActor(splash);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.draw();
		stage.act();
	}
}
