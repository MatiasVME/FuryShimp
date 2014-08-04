package org.furygames.screens;

import org.furygames.actors.Bananas;
import org.furygames.actors.Coconut;
import org.furygames.actors.Rock;
import org.furygames.actors.Shimp;
import org.furygames.furyshimp.Collides;
import org.furygames.furyshimp.Creator;
import org.furygames.furyshimp.FlyingObjets;
import org.furygames.furyshimp.FuryShimp;
import org.furygames.furyshimp.GameSounds;
import org.furygames.furyshimp.Levels;
import org.furygames.inputs.MonkeyInput;
import org.furygames.inputs.VirtualController;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;

public final class GameScreen extends GenericScreen {
	
	private Levels levels;
	private Array <Rock> rocks;
	private Array <Bananas> bananas;
	private Array <Coconut> coconuts;
	private Music music;
	private Shimp shimp;
	private Image bg;
	private TextureRegion bgRegion;
	private Texture bgTexture;
	private Sound woop;
	private Sound hit;
	private VirtualController virtualController;
	private MonkeyInput monkeyInput;
	private boolean musicExist = false;
	
	public GameScreen (final FuryShimp universalMonkey) {
		super(universalMonkey);
	}
	
	@Override
	public void show() {
		super.show();
		
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
		bgTexture = new Texture("backgrounds/bgbeach.jpg");
		bgRegion = new TextureRegion(bgTexture);
		bg = new Image(bgRegion);
		bg.setCenterPosition(WIDTH / 2, HEIGHT / 2);
		
		stage.addActor(bg);
		stage.addActor(Creator.createArrowLeft());
		stage.addActor(Creator.createArrowRigth());

		// Inputs
		
		virtualController = new VirtualController();
		monkeyInput = new MonkeyInput (virtualController);
		Gdx.input.setInputProcessor(monkeyInput);
		
		shimp = new Shimp(virtualController);
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
				break;
			case LEVEL3:
				break;
		}

		// Detección de coliciones.
		collidesDetection();

		stage.draw();
		stage.act();
		
		// Inputs
		//

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

	// Método level que se llama cada vez que el render es actualizado
	private void level(int level) {
		switch(level){
		case 1:

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
				music(2);
			
			
			break;
		default:
			break;
		}
	}
	
	// Musica de la jungla
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
