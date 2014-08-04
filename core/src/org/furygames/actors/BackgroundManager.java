package org.furygames.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class BackgroundManager extends Actor implements Disposable {
	
	private final float WIDTH = 1280f;
	private final float HEIGHT = 720f;
	private final int TOTAL_BACKGROUNDS = 3;
		
	private Texture [] backgrounds;	
	private int selected;
	
	public BackgroundManager (int bg) {
		backgrounds = new Texture [TOTAL_BACKGROUNDS];
		selected = bg;
		
		setImage(bg);
		
		setSize(WIDTH, HEIGHT);
	}

	@Override
	public void dispose() {
		for (Texture background : backgrounds)
			background.dispose();
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(backgrounds[selected], getX(), getY(), getOriginX(), getOriginY(),
				getWidth(), getHeight(), getScaleX(), getScaleY());
		
		super.draw(batch, parentAlpha);
	}
	
	public void setImage (int bg) {
		selected = bg;
		
		switch (bg) {
		case 1:
			backgrounds[bg - 1] = new Texture("backgrounds/bgjungle.jpg");
			break;
		case 2:
			backgrounds[bg - 1] = new Texture("backgrounds/bgbeach.jpg");
			break;
		case 3:
			backgrounds[bg - 1] = new Texture("backgrounds/bgmountains.jpg");
			break;
		default:
			break;
		}
	}

}
