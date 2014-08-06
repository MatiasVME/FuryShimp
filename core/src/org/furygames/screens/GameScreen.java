package org.furygames.screens;

import org.furygames.actors.Bananas;
import org.furygames.actors.Coconut;
import org.furygames.actors.Rock;
import org.furygames.actors.Shimp;
import org.furygames.furyshimp.BackgroundManager;
import org.furygames.furyshimp.Collides;
import org.furygames.furyshimp.Creator;
import org.furygames.furyshimp.FlyingObjets;
import org.furygames.furyshimp.FuryShimp;
import org.furygames.furyshimp.GameSounds;
import org.furygames.furyshimp.Levels;
import org.furygames.furyshimp.Score;
import org.furygames.inputs.MonkeyInput;
import org.furygames.inputs.VirtualController;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public final class GameScreen extends GenericScreen {
	
	private float SECONDS = 180f; // Segundos
	
	private long time;
	
	private Levels levels;
	private Array <Rock> rocks;
	private Array <Bananas> bananas;
	private Array <Coconut> coconuts;
	private Music music;
	private Shimp shimp;
	private BackgroundManager bgManager;
	private Image currentBackground;
	private Sound woop;
	private Sound hit;
	private BitmapFont font;
	private MonkeyInput monkeyInput;
	private boolean musicExist = false;
	private boolean nivelClear = true;
	
	public GameScreen (final FuryShimp universalMonkey) {
		super(universalMonkey);
	}
	
	@Override
	public void show() {
		super.show();
		
		time = TimeUtils.millis();
		
		//establecemos el estilo de los marcadores
		font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.setScale(1.3f);
		
		// Dejar el enums levels en estado de LEVEL1
		levels = Levels.LEVEL1;

		// Inicializar los arrays dinamicos de rocas, bananas y cocos.
		rocks = new Array <Rock> ();
		bananas = new Array <Bananas> ();
		coconuts = new Array <Coconut> ();
		
		// Crear el sonido cuando el mono toma algo.
		woop = GameSounds.newSound(1); // Sonara el sonido woop al pasar parametro 1
		// Crear el sonido cuando el mono es golpeado.
		hit = GameSounds.newSound(2); // Sonara el sonido hit al pasar parametro 2
		
		//Definiendo fondo de pantalla
		bgManager = new BackgroundManager();
		currentBackground = bgManager.getImage(1);
		
		stage.addActor(currentBackground);
		stage.addActor(Creator.createArrowLeft());
		stage.addActor(Creator.createArrowRigth());

		// Movimiento del mono mediante touchScreen
		monkeyInput = new MonkeyInput();
		Gdx.input.setInputProcessor(monkeyInput);
		
		shimp = new Shimp();
		stage.addActor(shimp);
	}    
    
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		switch (levels) {
			case LEVEL1:
				level(1);
				break;
			case LEVEL2:
				level(2);
				break;
			case LEVEL3:
				break;
		}

		// Deteccion de coliciones.
		collidesDetection();
		
		//comprobar vidas del juego
		comprobarVidas();
		
		stage.draw();
		stage.act();
		
		batch.begin();
		//Si el tiempo en ejecucion, que no a parado se le resta el tiempo que hemos almacenado nos dar� el //tiempo en millis que ha pasado, en caso de ser mayor que 1000 es que habr� llegado al segundo
		//Al entrar en el condicional, volvemos  a asignar el tiempo actual de ejecucion a la variable time
		//provocando lo mismo una y otra vez.
		 if(TimeUtils.millis() - time > 1000)
		 {
			 //Esta parte se ejecutar� cada segundo.
			 time= TimeUtils.millis();			 
			 SECONDS--;
			 comprobarTiempo();
		}
		 
		font.draw(batch, String.valueOf("Tiempo: " + SECONDS), Gdx.graphics.getWidth() - 450, Gdx.graphics.getHeight() - 20);
		font.draw(batch, String.valueOf("Puntuacion: " + Score.getScore()), Gdx.graphics.getWidth() - 270, Gdx.graphics.getHeight() - 20);
		font.draw(batch, String.valueOf("Vidas: " + Score.getLifes()), Gdx.graphics.getWidth() - 100, Gdx.graphics.getHeight() - 20);
		batch.end();

		// Condicion si el boton presionado es BACK ejecutar la accion.
		if(Gdx.input.isKeyPressed(Keys.BACK))
			universalMonkey.setScreen(universalMonkey.getMenuScreen());
	}

	private void collidesDetection() {
		// Deteccion shimp banana
		Collides.collidesMonkeyBananas(shimp, bananas, woop);
		
		// Deteccion shimp coconut
		Collides.collidesMonkeyCoconuts(shimp, coconuts, woop);
		
		// Deteccion shimp rock
		Collides.collidesMonkeyRocks(shimp, rocks, hit);
	}
	
	//compruebo si el tiempo no ha expirado
	private void comprobarTiempo() {
		if(SECONDS <= 0)
		{
			finalizarPartida();
		}
	}
	
	//compruebo si el mono tiene vidas
	private void comprobarVidas() {
		if(Score.getLifes() <= 0)
		{
			finalizarPartida();
		}
	}
	
	//metodo que finaliza la partida
	private void finalizarPartida() {
		universalMonkey.setScreen(universalMonkey.getMenuScreen());
		music.dispose();
		musicExist  = false;
		Score.setLifes(3);
		Score.setScore(0);
		SECONDS=180;
		VirtualController.setMoveLeft(false);
		VirtualController.setMoveRight(false);
	}

	// Método level que se llama cada vez que el render es actualizado
	private void level(int level) {
		switch(level){
		case 1:
			
			if (nivelClear) {
				nivelClear = false;
			}
			
			// Crear rocas del nivel.
			if (rocks.size == 0 && !FlyingObjets.isFlyingRocks(rocks)) {
				Creator.createRocks(2, rocks, stage);
			}

			// Si las rocas no estan volando eliminarlas.
			else if (!FlyingObjets.isFlyingRocks(rocks)){
				// Remover Rocas
				for (Rock rock : rocks)
					rock.remove();

				// Vaciar array.
				rocks.clear();
			}

			// Crear bananas del nivel.
			if (bananas.size == 0 && !FlyingObjets.isFlyingBananas(bananas)) {
				Creator.createBananas(3, bananas, stage);
			}

			// Si las bananas no estan volando eliminarlas.
			else if (!FlyingObjets.isFlyingBananas(bananas)){
				// Remover bananas.
				for (Bananas banana : bananas)
					banana.remove();

				// Vaciar array.
				bananas.clear();
			}
			
			// Crear coconuts del nivel.
			if (coconuts.size == 0 && !FlyingObjets.isFlyingCoconut(coconuts)) {
				Creator.createCoconuts(3, coconuts, stage);
			}

			// Si los coconuts no estan volando eliminarlos.
			else if (!FlyingObjets.isFlyingCoconut(coconuts)){
				// Remover coconuts.
				for (Coconut coconut : coconuts)
					coconut.remove();

				// Vaciar array.
				coconuts.clear();
			}
			
			// Sonido.
			if (!musicExist)
				music(1);
			

			
			break;
			
		case 2:
			// Eliminar cosas del nivel1
			if (!nivelClear) {
				currentBackground = bgManager.getImage(2);
				
				// Hack: Accede al primer actor que es el background y lo cambia,
				// esto se podría optimizar de alguna forma, ya que no 
				// necesariamente el primer actor debería ser el background.
				stage.getActors().items[0] = currentBackground;
				
				music.dispose();
				music = null;
				musicExist = false;
				
				//stage.addActor(currentBackground);
				nivelClear = true;
			}
			
			// Crear rocas del nivel.
			if (rocks.size == 0 && !FlyingObjets.isFlyingRocks(rocks)) {
				Creator.createRocks(3, rocks, stage);
				Creator.createLargeRocks(1, rocks, stage);
			}

			// Si las rocas no estan volando eliminarlas.
			else if (!FlyingObjets.isFlyingRocks(rocks)){
				// Remover Rocas
				for (Rock rock : rocks)
					rock.remove();

				// Vaciar array.
				rocks.clear();
			}

			// Crear bananas del nivel.
			if (bananas.size == 0 && !FlyingObjets.isFlyingBananas(bananas)) {
				Creator.createBananas(4, bananas, stage);
				Creator.createLargeBananas(1, bananas, stage);
			}

			// Si las bananas no estan volando eliminarlas.
			else if (!FlyingObjets.isFlyingBananas(bananas)){
				// Remover bananas.
				for (Bananas banana : bananas)
					banana.remove();

				// Vaciar array.
				bananas.clear();
			}
			
			// Crear coconuts del nivel.
			if (coconuts.size == 0 && !FlyingObjets.isFlyingCoconut(coconuts)) {
				Creator.createCoconuts(4, coconuts, stage);
			}

			// Si los coconuts no estan volando eliminarlos.
			else if (!FlyingObjets.isFlyingCoconut(coconuts)){
				// Remover coconuts.
				for (Coconut coconut : coconuts)
					coconut.remove();

				// Vaciar array.
				coconuts.clear();
			}
			
			// Sonido.
			if (!musicExist)
				music(2);
			break;
			
		default:
			break;
		}
	}
	
	// Musica.
	private void music(int track) {
		if (music != null) {
			music.dispose();
			music = null;
		}
		
		// Si no existe musica, colocarla.
		else {
			// Crear la musica.
			music = GameSounds.newMusic(track);
			// Que se haga un loop con la musica, osea que cuando termine empiece de nuevo
			// indifinidamente.
			music.setLooping(true);
			music.play(); // Reproducir musica.
			// Avisar de que si existe musica.
			musicExist  = true;
		}
	}
}
