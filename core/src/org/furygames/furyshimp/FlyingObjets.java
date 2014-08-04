package org.furygames.furyshimp;

import org.furygames.actors.Bananas;
import org.furygames.actors.Coconut;
import org.furygames.actors.Rock;

import com.badlogic.gdx.utils.Array;

// Clase para tratar los objetos que estan volando, esto sirve, por ejemplo, 
// para no seguir creando objetos cuando estan volando en el aire.

public class FlyingObjets {

	// Las rocas estan en el volando?
	public static boolean isFlyingRocks (Array <Rock> rocks) {
		// Por defecto las rocas no estan volando.
		boolean isFlying = false;

		// Recorrer el array de rocas que es pasado como parametro, y ver
		// si estan volando.
		for (Rock rock : rocks) {
			// Si la roca no tiene acciones asociadas, significa que 
			// ya no esta volando
			if (rock.getActions().size == 0)
				isFlying = false; // No esta volando

			// De lo contrario si esta volando.
			else
				return true;
		}

		return isFlying;
	}
	
	// Las bananas estan volando?
	public static boolean isFlyingBananas(Array <Bananas> bananas) {
		boolean isFlying = false;

		for (Bananas banana : bananas) {
			if (banana.getActions().size == 0)
				isFlying = false;

			else
				return true;
		}

		return isFlying;
	}
	
	// Los cocos estan volando?
	public static boolean isFlyingCoconut(Array <Coconut> coconuts) {
		boolean isFlying = false;

		for (Coconut coconut : coconuts) {
			if (coconut.getActions().size == 0)
				isFlying = false;

			else
				return true;
		}

		return isFlying;
	}
}
