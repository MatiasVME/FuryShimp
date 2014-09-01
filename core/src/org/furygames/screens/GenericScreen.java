package org.furygames.screens;

import org.furygames.furyshimp.FuryShimp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;

public abstract class GenericScreen implements Screen {

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	protected FuryShimp universalMonkey;
	protected Stage stage;
	protected FillViewport fitViewport;
	protected SpriteBatch batch;
	
	public GenericScreen (FuryShimp universalMonkey) {
		this.universalMonkey = universalMonkey;
		fitViewport = new FillViewport(WIDTH, HEIGHT);
		stage = new Stage(fitViewport);
		
		batch = new SpriteBatch();
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		batch.dispose();
	}

}
