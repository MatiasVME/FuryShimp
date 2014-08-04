package org.furygames.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public abstract class GenericActor extends Actor implements Disposable {

	protected Texture texture;
	protected TextureRegion textureRegion;
	// Rectangulo que tendrán en comun todos los elementos, sirve 
	// para la detección de coliciones.
	protected Rectangle rect;
	protected boolean alive = true; // Esta vivo?
	
	// El constructor recibe la ruta de la imagen.
	public GenericActor (String path) {
		// Crea una nueva textura según la ruta que le pasemos.
		texture = new Texture (path);
		// Se crea un TextureRegion dependiendo de la textura.
		textureRegion = new TextureRegion (texture);
		
		// Se setea el origen del objeto, esot es especialmente útil para hacer
		// rotanciones, o escalados, respecto a un origen diferente. En este caso
		// las rotaciones se harán respecto al centro.
		setOrigin(getWidth() / 2, getHeight() / 2);
		
		// Se crea el nuevo rectangulo con las posiciones y el tamaño de la imagen,
		// esto es util para la deteccion de coliciones.
		rect = new Rectangle(getX(), getY(), getWidth(), getHeight());
	}
	
	@Override
	public void dispose () {
		// Se elimina la textura cuando se utiliza dispose.
		texture.dispose();
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// Se dibuja el textureRegion
		batch.draw(textureRegion, getX(), getY(), getOriginX(), getOriginY(),
				getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}
	
	@Override
	public void act (float delta) {
		super.act(delta);
		
		// Cada vez que se actualize la posición de la imagen, también se actualiza
		// la posición del rectangulo, que es el que detecta coliciones.
		rect.set(getX(), getY(), getWidth(), getHeight());
	}
	
	public Rectangle getRectangle () {
		return rect;
	}
	
	public boolean isAlive () {
		return alive;
	}
	
	public void setAlive (boolean alive) {
		this.alive = alive;
	}
}
