package org.furygames.furyshimp;

import org.furygames.screens.CreditsScreen;
import org.furygames.screens.GameOverScreen;
import org.furygames.screens.GameScreen;
import org.furygames.screens.LevelsScreen;
import org.furygames.screens.MenuScreen;
import org.furygames.screens.StatisticsScreen;
import org.furygames.screens.ScoreScreen;
import org.furygames.screens.SplashScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class FuryShimp extends Game {

	private SplashScreen splashScreen;
	private LevelsScreen levelsScreen;
	private MenuScreen menuScreen;
	private ScoreScreen scoreScreen;
	private GameScreen gameScreen;
	private StatisticsScreen statisticScreen;
	private GameOverScreen gameOverScreen;
	private CreditsScreen creditsScreen;

	@Override
	public void create() {
		splashScreen = new SplashScreen(this);
		levelsScreen = new LevelsScreen(this);
		menuScreen = new MenuScreen(this);
		scoreScreen = new ScoreScreen(this);
		gameScreen = new GameScreen(this);
		statisticScreen = new StatisticsScreen(this);
		gameOverScreen = new GameOverScreen(this);
		creditsScreen = new CreditsScreen(this);
		
		setScreen(splashScreen);
		Gdx.input.setCatchBackKey(true); 
	}
	
	public LevelsScreen getLevelsScreen() {
		return levelsScreen;
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
	
	public StatisticsScreen getStatisticScreen () {
		return statisticScreen;
	}
	
	public GameOverScreen getGameOverScreen () {
		return gameOverScreen;
	}
	
	public CreditsScreen getCreditsScreen() {
		return creditsScreen;
	}
}
