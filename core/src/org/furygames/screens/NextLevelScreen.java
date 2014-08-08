package org.furygames.screens;

import org.furygames.furyshimp.FuryShimp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class NextLevelScreen extends GenericScreen {

	private final int DURATION = 3;
	
	private BitmapFont bfNextLevel;
	private String txtNextLevel = "Has accedido al siguiente nivel";
	
	public NextLevelScreen(FuryShimp universalMonkey) {
		super(universalMonkey);
	}
	
	@Override
	public void show() {
		bfNextLevel = new BitmapFont(Gdx.files.internal("fonts/jungle.fnt"),
				Gdx.files.internal("fonts/jungle.png"), false);
		
		// Cambiar de pantalla 
		Timer.schedule(new Task() {
			@Override
			public void run() {
				universalMonkey.setScreen(universalMonkey.getLevelScreen());
			}
		}, DURATION);
		
		super.show();
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		batch.begin();
		bfNextLevel.draw(batch, txtNextLevel, GameScreen.WIDTH / 2, GameScreen.HEIGHT / 2);
		batch.end();
	}
	
	@Override
	public void dispose() {

		super.dispose();
	}
	
	public void setTxtNextLevel (String txtNextLevel) {
		this.txtNextLevel = txtNextLevel;
	}
}
