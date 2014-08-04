package org.furygames.furyshimp;

import org.furygames.actors.Bananas;
import org.furygames.actors.Coconut;
import org.furygames.actors.Rock;
import org.furygames.screens.GameScreen;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

public class Creator {
	// Crea las rocas y las añade al esceneario
	public static void createRocks (int max, Array <Rock> rocks, Stage stage) {
		// Un número aleatorio entre 1 y max (que son las rocas que aparecerán en
		// pantalla.
		int numOfRocks = MathUtils.random(1, max);

		// Crear las rocas dependiendo del numero aleatorio generado anteriormente.
		for (int i = 0; i < numOfRocks; i++) {
			// Crear el vector origen en una posicion aleatorio de la parte superior
			// de la pantalla.
			Vector2 origin = new Vector2(
					MathUtils.random(0 + Rock.WIDTH / 2, GameScreen.WIDTH - Rock.WIDTH / 2), 
					GameScreen.HEIGHT);
			// Crear el vector destino en una posicion aleatorio de la parte inferior
			// de la pantalla.
			Vector2 destination = new Vector2(
					MathUtils.random(0 + Rock.WIDTH / 2, GameScreen.WIDTH - Rock.WIDTH / 2),
					0);

			// Añade las rocas al array de rocas, con una velocidad aleatoria.
			rocks.add(new Rock(origin, destination,
					MathUtils.random(2f, 4f)));
		}

		// Recorre el Array rocks para añadir cada roca al escenario
		for (Rock rock : rocks) {
			stage.addActor(rock);
		}
	}

	// Crea las bananas y las añade al escenario.
	public static void createBananas (int max, Array <Bananas> bananas, Stage stage) {
		int numOfBananas = MathUtils.random(1, max);

		for (int i = 0; i < numOfBananas; i++) {
			Vector2 origin = new Vector2(
					MathUtils.random(0 + Rock.WIDTH / 2, GameScreen.WIDTH - Rock.WIDTH / 2), 
					GameScreen.HEIGHT);
			Vector2 destination = new Vector2(
					MathUtils.random(0 + Rock.WIDTH / 2, GameScreen.WIDTH - Rock.WIDTH / 2),
					0);

			bananas.add(new Bananas(origin, destination,
					MathUtils.random(2f, 4f)));
		}

		for (Bananas banana : bananas) {
			stage.addActor(banana);
		}
	}

	// Crea los cocos y los añade al escenario.
	public static void createCoconuts (int max, Array <Coconut> coconuts, Stage stage) {
		int numOfCoconuts = MathUtils.random(1, max);

		for (int i = 0; i < numOfCoconuts; i++) {
			Vector2 origin = new Vector2(
					MathUtils.random(0 + Rock.WIDTH / 2, GameScreen.WIDTH - Rock.WIDTH / 2), 
					GameScreen.HEIGHT);
			Vector2 destination = new Vector2(
					MathUtils.random(0 + Rock.WIDTH / 2, GameScreen.WIDTH - Rock.WIDTH / 2),
					0);

			coconuts.add(new Coconut(origin, destination,
					MathUtils.random(2f, 4f)));
		}

		for (Coconut coconut : coconuts) {
			stage.addActor(coconut);
		}
	}
}
