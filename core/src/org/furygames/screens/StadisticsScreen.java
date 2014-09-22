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
	
	private Image imgBackground;
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
		
		imgBackground = new Image(background);
		resume = new Image(ttResume);
		levels = new Image(ttLevels);
		nextLevel = new Image(ttNextLevel);
		
		imgBackground.setSize(WIDTH, HEIGHT);
		resume.setSize(437f, 281f);
		levels.setSize(422f, 323f);
		nextLevel.setSize(323f, 277f);
		
		imgBackground.setCenterPosition(WIDTH / 2, HEIGHT / 2);
		levels.setCenterPosition(282, 195);
		resume.setCenterPosition(718, 215);
		nextLevel.setCenterPosition(1068, 180);

        // Debug
		// configStadistics(3, true);
		// DataGame.setScore(999);
		
		// Añadir actores
		//
		
		stage.addActor(imgBackground);
		stage.addActor(resume);
		stage.addActor(levels);
		stage.addActor(nextLevel);
		
		buttonsListeners();
	}
	
	@Override
	public void show() {
		super.show();
		
		score = String.valueOf(DataGame.getScore());
		
		MenuScreen.getMusic().play();
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		stage.act();
		stage.draw();
		
		batch.begin();
			bfScore.draw(batch, score, GameScreen.WIDTH / 2, 460);
			drawStars();
		batch.end();
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
				MenuScreen.getMusic().stop();
				GameScreen.setNeedNivelClear(true);
				universalMonkey.setScreen(universalMonkey.getGameScreen());
				
				super.clicked(event, x, y);
			}
		});
		
		nextLevel.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				int MAX_LEVEL = 6;
				
				MenuScreen.getMusic().stop();
				GameScreen.setNeedNivelClear(true);
				
				if (GameScreen.levels.getNumLevel() == MAX_LEVEL)
					universalMonkey.setScreen(universalMonkey.getCreditsScreen());
				else {
					GameScreen.levels = GameScreen.levels.next();
					universalMonkey.setScreen(universalMonkey.getGameScreen());
				}
				
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
				batch.draw(stars.get(i), x, 515, 128, 128);
		}
	}
}
