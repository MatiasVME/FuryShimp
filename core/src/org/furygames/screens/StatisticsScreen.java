package org.furygames.screens;

import org.furygames.furyshimp.FuryShimp;
import org.furygames.furyshimp.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

public class StatisticsScreen extends GenericScreen {
	
	private int star = -1;
	private String score = "000";
	private Levels currentLevel = Levels.LEVEL1;
	
	private Texture background;
	private Array <Texture> stars;
	private BitmapFont bfScore;
	
	// Buttons
	//
	
	private Texture ttResume;
	private Texture ttLevels;
	private Texture ttNextLevel;
	
	private Image resume;
	private Image levels;
	private Image nextLevel;
	
	private boolean win;
	
	
	public StatisticsScreen(FuryShimp universalMonkey) {
		super(universalMonkey);
		
		background = new Texture("backgrounds/statistics_screen.jpg");
		
		bfScore = new BitmapFont(Gdx.files.internal("fonts/jungle.fnt"),
				Gdx.files.internal("fonts/jungle.png"), false);
		bfScore.setColor(Color.BLACK);
		
		stars = new Array <Texture> ();
		
		// Botones
		//
		
		ttResume = new Texture ("buttons/resume_button.png");
		ttLevels = new Texture ("buttons/levels_button.png");
		ttNextLevel = new Texture ("buttons/next_button.png");
		
		resume = new Image(ttResume);
		levels = new Image(ttLevels);
		nextLevel = new Image(ttNextLevel);
		
		resume.setSize(128f, 128f);
		levels.setSize(128f, 128f);
		nextLevel.setSize(128f, 128f);
		
		levels.setCenterPosition(300, 200);
		resume.setCenterPosition(700, 220);
		nextLevel.setCenterPosition(1050, 190);
		
		// Añadir actores
		//
		
		stage.addActor(resume);
		stage.addActor(levels);
		stage.addActor(nextLevel);
		
		buttonsListeners();
		
		// Temp
		configStatistics (3, 99, true, Levels.LEVEL1);
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
		
		stage.act();
		stage.draw();
	}
	
	@Override
	public void dispose() {

		super.dispose();
	}
	
	public void configStatistics (int stars, int score, boolean win, Levels currentLevel) {
		setStars(stars);
		setScore(score);
		setWin(win);
		setCurrentLevel(currentLevel);
	}
	
	private void buttonsListeners() {
		levels.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				universalMonkey.setScreen(universalMonkey.getLevelsScreen());
				super.clicked(event, x, y);
			}
		});
		
		resume.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				universalMonkey.setScreen(universalMonkey.getGameScreen());
				super.clicked(event, x, y);
			}
		});
		
		nextLevel.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				currentLevel = currentLevel.next();
				universalMonkey.setScreen(universalMonkey.getGameScreen());
				super.clicked(event, x, y);
			}
		});
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
	
	private void drawStars () {
		final int SEPARATOR = 70;
		
		if (stars.size > 0) {
			for (int i = 0, x = 128 * 3; i < stars.size; i++, x += 128 + SEPARATOR)
				batch.draw(stars.get(i), x, 490, 128, 128);
		}
	}

	public void setCurrentLevel(Levels currentLevel) {
		this.currentLevel = currentLevel;
	}
	
	public Levels getCurrentLevel () {
		return currentLevel;
	}
}
