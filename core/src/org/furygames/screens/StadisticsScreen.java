package org.furygames.screens;

import org.furygames.furyshimp.DataGame;
import org.furygames.furyshimp.FuryShimp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

public class StadisticsScreen extends GenericScreen {
	
	private static int star = -1;
	private static Array <Texture> stars;
	
	private String score = "---";
	private Texture background;
	private BitmapFont bfScore;
	
	// Buttons
	//
	
	private Texture ttResume;
	private Texture ttLevels;
	private Texture ttNextLevel;
	
	private Image resume;
	private Image levels;
	private Image nextLevel;
	
	private static boolean win;
	
	
	public StadisticsScreen(FuryShimp universalMonkey) {
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
	}
	
	@Override
	public void show() {
		super.show();
		
		score = String.valueOf(DataGame.getScore());
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
	
	public static void configStadistics (int stars, boolean win) {
		setStars(stars);
		setWin(win);
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
				GameScreen.setNeedNivelClear(true);
				universalMonkey.setScreen(universalMonkey.getGameScreen());
				super.clicked(event, x, y);
			}
		});
		
		nextLevel.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				GameScreen.setNeedNivelClear(true);
				GameScreen.levels = GameScreen.levels.next();
				universalMonkey.setScreen(universalMonkey.getGameScreen());
				super.clicked(event, x, y);
			}
		});
	}

	public boolean isWin() {
		return win;
	}

	public static void setWin (boolean win) {
		StadisticsScreen.win = win;
	}

	public static void setStars(int star) {
		StadisticsScreen.star = star;
		
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
}
