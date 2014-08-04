package org.furygames.actors;

import com.badlogic.gdx.math.Vector2;

// Clase droppable (lanzable), que es la clase en común que tienen los objetos que
// son lanzados como las rocas, los platanos, etc. 

public abstract class Droppable extends GenericActor {

	private float speed;
	private Vector2 origin;
	private Vector2 destination;
	
	public Droppable(Vector2 origin, Vector2 destination, float speed, String path) {
		super(path);
		
		setOrigin(origin); // Origen del objeto
		setDestination(destination); // Destino del objeto
		setSpeed(speed); // Velociddad del objeto
		
		// Posicionar desde el centro al objeto en pantalla.
		setCenterPosition(origin.x, origin.y);
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public Vector2 getOrigin() {
		return origin;
	}

	public void setOrigin(Vector2 origin) {
		this.origin = origin;
	}

	public Vector2 getDestination() {
		return destination;
	}

	public void setDestination(Vector2 destination) {
		this.destination = destination;
	}
}
