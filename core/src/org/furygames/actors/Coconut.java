package org.furygames.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;

public class Coconut extends Droppable {

	public final static int WIDTH = 122;
	public final static int HEIGHT = 128;
	
	private boolean isLarge = false;

	public Coconut(Vector2 origin, Vector2 destination, float speed, boolean isLarge) {
		super(origin, destination, speed, "actors/coconut.png");
		this.isLarge = isLarge;
		
		textureRegion.setRegion(0, 0, WIDTH, HEIGHT);
		
		if (isLarge)
			setOrigin(WIDTH / 2, HEIGHT / 2);
		else
			setOrigin(WIDTH / 2 / 2, HEIGHT / 2 / 2);

		// Movimiento.
		ParallelAction pa = new ParallelAction();
		pa.addAction(Actions.moveTo(destination.x, destination.y, speed));
		pa.addAction(Actions.rotateBy(MathUtils.random(-360 * 4, 360 * 4), speed));
		addAction(pa);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		
		if (isLarge)
			setSize(WIDTH, HEIGHT);
		else
			setSize(WIDTH / 2, HEIGHT / 2);
	}
}
