package org.furygames.furyshimp;

import org.furygames.screens.CreditsScreen;
import org.furygames.screens.GameOverScreen;
import org.furygames.screens.GameScreen;
import org.furygames.screens.LevelsScreen;
import org.furygames.screens.MenuScreen;
import org.furygames.screens.StadisticsScreen;
import org.furygames.screens.SplashScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class FuryShimp extends Game {

	private SplashScreen splashScreen;
	private LevelsScreen levelsScreen;
	private MenuScreen menuScreen;
	private GameScreen gameScreen;
	private StadisticsScreen stadisticScreen;
	private GameOverScreen gameOverScreen;
	private CreditsScreen creditsScreen;

	@Override
	public void create() {
		splashScreen = new SplashScreen(this);
		gameScreen = new GameScreen(this);
		levelsScreen = new LevelsScreen(this);
		menuScreen = new MenuScreen(this);
		gameOverScreen = new GameOverScreen(this);
		stadisticScreen = new StadisticsScreen(this);
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
	
	public GameScreen getGameScreen () {
		return gameScreen;
	}
	
	public StadisticsScreen getStadisticScreen () {
		return stadisticScreen;
	}
	
	public GameOverScreen getGameOverScreen () {
		return gameOverScreen;
	}
	
	public CreditsScreen getCreditsScreen() {
		return creditsScreen;
	}
}
