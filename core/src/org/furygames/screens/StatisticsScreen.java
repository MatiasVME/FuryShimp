package org.furygames.screens;

import org.furygames.furyshimp.FuryShimp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class StatisticsScreen extends GenericScreen {
	
	private BitmapFont bfNextLevel;
	private String txtNextLevel = "ssss";
	
	private boolean win;
	
	
	public StatisticsScreen(FuryShimp universalMonkey) {
		super(universalMonkey);
	}
	
	@Override
	public void show() {
		bfNextLevel = new BitmapFont(Gdx.files.internal("fonts/jungle.fnt"),
				Gdx.files.internal("fonts/jungle.png"), false);
		
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

	public boolean isWin() {
		return win;
	}

	public void setWin (boolean win) {
		this.win = win;
	}
}
