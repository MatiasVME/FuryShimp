package org.furygames.screens;

import org.furygames.furyshimp.FuryShimp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Array;

public class StatisticsScreen extends GenericScreen {
	
	private int star;
	private Texture background;
	private Array <Texture> stars;
	private BitmapFont bfScore;
	private String score = "999";
	
	private boolean win;
	
	
	public StatisticsScreen(FuryShimp universalMonkey) {
		super(universalMonkey);
		
		background = new Texture("backgrounds/statistics_screen.jpg");
		
		bfScore = new BitmapFont(Gdx.files.internal("fonts/jungle.fnt"),
				Gdx.files.internal("fonts/jungle.png"), false);
		bfScore.setColor(Color.BLACK);
		
		stars = new Array <Texture> ();
		
		// Temp
		setStars(3);
	}
	
	@Override
	public void show() {
		super.show();
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		batch.begin();
			batch.draw(background, 0, 0, GenericScreen.WIDTH, 
					GenericScreen.HEIGHT);
			bfScore.draw(batch, score, GameScreen.WIDTH / 2, 460);
			drawStars();
		batch.end();
	}
	
	@Override
	public void dispose() {

		super.dispose();
	}
	
	public void setTxtNextLevel (String score) {
		this.score = score;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin (boolean win) {
		this.win = win;
	}

	public void setScore(int score) {
		this.score = "" + score;
	}

	public void setStars(int star) {
		this.star = star;
		
		if (stars != null)
			stars.clear();
		
		for (int i = 0; i < star; i++)
			stars.add(new Texture("extras/star.png"));
	}
	
	public void drawStars () {
		if (stars.size > 0) {
			for (int i = 0, x = 128 * 3; i < stars.size; i++, x += 128 + 70) {
				batch.draw(stars.get(i), x, 490, 128, 128);
			}
		}
	}
}
