package org.furygames.actors;

import org.furygames.inputs.VirtualController;
import org.furygames.screens.GameScreen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;


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
	private boolean isMoving = false;
	
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

		// Si se esta moviendo los frames avanzan
		if (isMoving)
			frame = dudeAnimation.getKeyFrame(duracion, true);
		// Si no se esta moviendo se queda en un frame
		else
			frame = dudeAnimation.getKeyFrame(1);
		
		textureRegion = frame;
		
		isMoving = false;
		
		if (VirtualController.isMoveLeft()) {
			
			if (getX() >= 0)
				setPosition(getX() - SPEED * delta, getY());
			
			moveLeft = true;
			moveRight = false;
			isMoving = true;
		}
		
		else if (VirtualController.isMoveRight()) {
			
			if (getX() <= GameScreen.WIDTH - getWidth())
				setPosition(getX() + SPEED * delta, getY());
			
			moveLeft = false;
			moveRight = true;
			isMoving = true;
		}
		
		if (moveRight && !textureRegion.isFlipX())
			textureRegion.flip(true, false);
		
		else if (moveLeft && textureRegion.isFlipX())
			textureRegion.flip(true, false);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		
		Color col = getColor();
		batch.setColor(col.r, col.g, col.b, col.a * parentAlpha);
				
		setSize(128, 128);
	}
}




