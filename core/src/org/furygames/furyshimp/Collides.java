package org.furygames.furyshimp;

import org.furygames.actors.Bananas;
import org.furygames.actors.Coconut;
import org.furygames.actors.Rock;
import org.furygames.actors.Shimp;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.Array;

public class Collides {
	
	public static void collidesMonkeyBananas (Shimp shimp, Array <Bananas> bananas, Sound sound) {
		// Recorrer el array de bananas para ver si una de ellas intersecta a shimp.
		for (Bananas banana : bananas) {
			// Si el rectangulo de shimp intersecta a el rectangulo de banana y si
			// la banana esta viva.
			if (Intersector.overlaps(shimp.getRectangle(), banana.getRectangle()) 
					&& banana.isAlive()) {
				banana.clear(); // Borra la banana del array.
				banana.setVisible(false); // Hace que la banana esté invisible.
				banana.setAlive(false); // Hace que la vanana no este viva.
				
				if (sound != null)
					sound.play();
				
				//sumamos 2 puntos de puntuacion del mono
				DataGame.addScore(2);
			}
		}
	}
	
	// Colicion shimp rock
	public static void collidesMonkeyCoconuts (Shimp shimp, Array <Coconut> coconuts, Sound sound) {
		for (Coconut coconut : coconuts) {
			if (Intersector.overlaps(shimp.getRectangle(), coconut.getRectangle()) 
					&& coconut.isAlive()) {
				coconut.clear();
				coconut.setVisible(false);
				coconut.setAlive(false);
				
				if (sound != null)
					sound.play();
				
				//sumamos 1 punto de puntuacion del mono
				DataGame.addScore(1);
			}
		}
	}
	
	// Colicion shimp rock
	public static void collidesMonkeyRocks (Shimp shimp, Array <Rock> rocks, Sound sound) {
		for (Rock rock : rocks) {
			if (Intersector.overlaps(shimp.getRectangle(), rock.getRectangle()) 
					&& rock.isAlive()) {
				rock.clear();
				rock.setVisible(false);
				rock.setAlive(false);
				
				if (sound != null)
					sound.play();
				
				//restamos 1 vida del mono
				DataGame.removeLife(1);
			}
		}
	}
}
