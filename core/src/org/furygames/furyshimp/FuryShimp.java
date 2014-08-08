package org.furygames.furyshimp;

import org.furygames.screens.GameOverScreen;
import org.furygames.screens.GameScreen;
import org.furygames.screens.LevelScreen;
import org.furygames.screens.MenuScreen;
import org.furygames.screens.StatisticsScreen;
import org.furygames.screens.ScoreScreen;
import org.furygames.screens.SplashScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class FuryShimp extends Game {

	private SplashScreen splashScreen;
	private LevelScreen levelScreen;
	private MenuScreen menuScreen;
	private ScoreScreen scoreScreen;
	private GameScreen gameScreen;
	private StatisticsScreen nextLevelScreen;
	private GameOverScreen gameOverScreen;

	@Override
	public void create() {
		splashScreen = new SplashScreen(this);
		levelScreen = new LevelScreen(this);
		menuScreen = new MenuScreen(this);
		scoreScreen = new ScoreScreen(this);
		gameScreen = new GameScreen(this);
		nextLevelScreen = new StatisticsScreen(this);
		gameOverScreen = new GameOverScreen(this);
		
		setScreen(splashScreen);
		Gdx.input.setCatchBackKey(true); 
	}
	
	public LevelScreen getLevelScreen() {
		return levelScreen;
	}
	
	public MenuScreen getMenuScreen() {
		return menuScreen;
	}
	
	public ScoreScreen getScoreScreen () {
		return scoreScreen;
	}
	
	public GameScreen getGameScreen () {
		return gameScreen;
	}
	
	public StatisticsScreen getNextLevelScreen () {
		return nextLevelScreen;
	}
	
	public GameOverScreen getGameOverScreen () {
		return gameOverScreen;
	}
}
