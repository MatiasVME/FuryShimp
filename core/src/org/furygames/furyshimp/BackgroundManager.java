package org.furygames.furyshimp;

import org.furygames.screens.GameScreen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class BackgroundManager {
	
	private final float WIDTH = 1280f;
	private final float HEIGHT = 720f;
	private final int TOTAL_BACKGROUNDS = 4;
		
	private Texture [] ttBackgrounds;	
	private Image [] imgBackgrounds;
	
	public BackgroundManager () {
		ttBackgrounds = new Texture [TOTAL_BACKGROUNDS];
		imgBackgrounds = new Image [TOTAL_BACKGROUNDS];
		
		// Inicializar backgrounds
		ttBackgrounds[0] = new Texture ("backgrounds/bgjungle.jpg");
		ttBackgrounds[1] = new Texture ("backgrounds/bgbeach.jpg");
		ttBackgrounds[2] = new Texture ("backgrounds/bgmountains.jpg");
		ttBackgrounds[3] = new Texture ("backgrounds/bgbeach2.jpg");
		
		// Inicializar actores img
		imgBackgrounds[0] = new Image(ttBackgrounds[0]);
		imgBackgrounds[1] = new Image(ttBackgrounds[1]);
		imgBackgrounds[2] = new Image(ttBackgrounds[2]);
		imgBackgrounds[3] = new Image(ttBackgrounds[3]);
		
		// Le damos tamaño a los actores
		imgBackgrounds[0].setSize(WIDTH, HEIGHT);
		imgBackgrounds[1].setSize(WIDTH, HEIGHT);
		imgBackgrounds[2].setSize(WIDTH, HEIGHT);
		imgBackgrounds[3].setSize(WIDTH, HEIGHT);
		
		// Le damos posición a los actores
		imgBackgrounds[0].setCenterPosition(GameScreen.WIDTH / 2, GameScreen.HEIGHT / 2);
		imgBackgrounds[1].setCenterPosition(GameScreen.WIDTH / 2, GameScreen.HEIGHT / 2);
		imgBackgrounds[2].setCenterPosition(GameScreen.WIDTH / 2, GameScreen.HEIGHT / 2);
		imgBackgrounds[3].setCenterPosition(GameScreen.WIDTH / 2, GameScreen.HEIGHT / 2);
	}
	
	public Image getImage(int img) {
		switch (img) {
			case 1:
				return imgBackgrounds[0];
			case 2:
				return imgBackgrounds[1];
			case 3:
				return imgBackgrounds[2];
			case 4:
				return imgBackgrounds[3];
			default:
				break;
		}
		
		return null;
	}
}
