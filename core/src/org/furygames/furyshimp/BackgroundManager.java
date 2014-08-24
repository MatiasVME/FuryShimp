package org.furygames.furyshimp;

import org.furygames.screens.GameScreen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class BackgroundManager {
	
	private final float WIDTH = 1280f;
	private final float HEIGHT = 720f;
	private final int TOTAL_BACKGROUNDS = 10;
		
	private Texture [] ttBackgrounds;	
	private Image [] imgBackgrounds;
	
	public BackgroundManager () {
		ttBackgrounds = new Texture [TOTAL_BACKGROUNDS];
		imgBackgrounds = new Image [TOTAL_BACKGROUNDS];
		
		// Inicializar backgrounds
		ttBackgrounds[0] = new Texture ("backgrounds/bg-level-1.jpg");
		ttBackgrounds[1] = new Texture ("backgrounds/bg-level-2.jpg");
		ttBackgrounds[2] = new Texture ("backgrounds/bg-level-3.jpg");
		ttBackgrounds[3] = new Texture ("backgrounds/bg-level-4.jpg");
		ttBackgrounds[4] = new Texture ("backgrounds/bg-level-5.jpg");
		ttBackgrounds[5] = new Texture ("backgrounds/bg-level-6.jpg");
		ttBackgrounds[6] = new Texture ("backgrounds/bg-level-7.jpg");
		ttBackgrounds[7] = new Texture ("backgrounds/bg-level-8.jpg");
		ttBackgrounds[8] = new Texture ("backgrounds/bg-level-9.jpg");
		ttBackgrounds[9] = new Texture ("backgrounds/bg-level-10.jpg");
		
		for (int i = 0; i < TOTAL_BACKGROUNDS; i++) {
			// Inicializar actores img
			imgBackgrounds[i] = new Image(ttBackgrounds[i]);
			// Le damos tamaño a los actores
			imgBackgrounds[i].setSize(WIDTH, HEIGHT);
			// Le damos posición a los actores
			imgBackgrounds[i].setCenterPosition(GameScreen.WIDTH / 2, GameScreen.HEIGHT / 2);
		}
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
			case 5:
				return imgBackgrounds[4];
			case 6:
				return imgBackgrounds[5];
			case 7:
				return imgBackgrounds[6];
			case 8:
				return imgBackgrounds[7];
			case 9:
				return imgBackgrounds[8];
			case 10:
				return imgBackgrounds[9];
			default:
				break;
		}
		
		return null;
	}
}
