package org.furygames.actors;

import org.furygames.inputs.VirtualController;
import org.furygames.screens.GameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;


public class Shimp extends GenericActor {

	private static final int SPRITE_WIDTH = 480;
	private static final int SPRITE_HEIGHT = 210;
	private static final float SPEED = 250f;

	private static TextureRegion frame;
	private TextureRegion[] dudeFrames;
	private Animation dudeAnimation;
	private float duracion = 0;
	private boolean moveLeft;
	private boolean moveRight;
	
	public Shimp() {
		super("actors/mono.png");
		
		textureRegion = new TextureRegion(texture, SPRITE_WIDTH, SPRITE_HEIGHT);

		TextureRegion[][] temp = textureRegion.split(SPRITE_WIDTH / 6, SPRITE_HEIGHT / 3);
		dudeFrames = new TextureRegion[temp.length * temp[0].length];
		
		int indice = 0;
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				dudeFrames[indice++] = temp[i][j];
			}
		}
		
		// Temp: solución momentanea del problema del parpadeo,
		// hace que se repita un frame.
		dudeFrames[dudeFrames.length - 1] = dudeFrames[0];
		
		dudeAnimation = new Animation(0.03f, dudeFrames);
		
		setCenterPosition(GameScreen.WIDTH / 2, 30f);
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		
		duracion += delta;
		frame = dudeAnimation.getKeyFrame(duracion, true);
		textureRegion = frame;
		
		if (VirtualController.isMoveLeft()) {
			setPosition(getX() - SPEED * delta, getY());
			
			moveLeft = true;
			moveRight = false;
		}
		
		else if (VirtualController.isMoveRight()) {
			setPosition(getX() + SPEED * delta, getY());
			
			moveLeft = false;
			moveRight = true;
		}
		
		if (moveRight && !textureRegion.isFlipX())
			textureRegion.flip(true, false);
		if (moveLeft && textureRegion.isFlipX())
			textureRegion.flip(true, false);
		
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		
		setSize(128, 128);
	}
}




