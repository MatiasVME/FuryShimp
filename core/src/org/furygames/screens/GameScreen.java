package org.furygames.screens;

import org.furygames.actors.Bananas;
import org.furygames.actors.Coconut;
import org.furygames.actors.Rock;
import org.furygames.actors.Shimp;
import org.furygames.furyshimp.Collides;
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
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;

public class GameScreen extends GenericScreen {
	
	private Levels levels;
	private Array <Rock> rocks;
	private Array <Bananas> bananas;
	private Array <Coconut> coconuts;
	private Music music;
	private Shimp shimp;
	private Image bg;
	private TextureRegion bgRegion;
	private Texture bgTexture;
	private Image arrowLeft, arrowRigth;
	private Sound woop;
	private Sound hit;
	private VirtualController virtualController;
	private MonkeyInput monkeyInput;
	
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
		woop = new GameSounds().newSound(1);//Sonara el sonido woop al pasar parametro 1
		// Crear el sonido cuando el mono es golpeado.
		hit = new GameSounds().newSound(2);//Sonara el sonido hit al pasar parametro 2
		
		//Definiendo fondo de pantalla
		bgTexture = new Texture("backgrounds/bgbeach.jpg");
		bgRegion = new TextureRegion(bgTexture);
		bg = new Image(bgRegion);
		bg.setCenterPosition(WIDTH / 2, HEIGHT / 2);
		bg.setOrigin(bg.getWidth() / 2, bg.getWidth() / 2);
		
		stage.addActor(bg);
		stage.addActor(createArrowLeft());
		stage.addActor(createArrowRigth());

		// Inputs
		
		virtualController = new VirtualController();
		monkeyInput = new MonkeyInput (virtualController);
		Gdx.input.setInputProcessor(monkeyInput);
		
		shimp = new Shimp(virtualController);
		createMono();
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

	// Crea las rocas y las añade al esceneario
	private void createRocks (int max) {
		// Un número aleatorio entre 1 y max (que son las rocas que aparecerán en
		// pantalla.
		int numOfRocks = MathUtils.random(1, max);

		// Crear las rocas dependiendo del numero aleatorio generado anteriormente.
		for (int i = 0; i < numOfRocks; i++) {
			// Crear el vector origen en una posicion aleatorio de la parte superior
			// de la pantalla.
			Vector2 origin = new Vector2(
					MathUtils.random(0 + Rock.WIDTH / 2, WIDTH - Rock.WIDTH / 2), 
					HEIGHT);
			// Crear el vector destino en una posicion aleatorio de la parte inferior
			// de la pantalla.
			Vector2 destination = new Vector2(
					MathUtils.random(0 + Rock.WIDTH / 2, WIDTH - Rock.WIDTH / 2),
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
	private void createBananas (int max) {
		int numOfBananas = MathUtils.random(1, max);

		for (int i = 0; i < numOfBananas; i++) {
			Vector2 origin = new Vector2(
					MathUtils.random(0 + Rock.WIDTH / 2, WIDTH - Rock.WIDTH / 2), 
					HEIGHT);
			Vector2 destination = new Vector2(
					MathUtils.random(0 + Rock.WIDTH / 2, WIDTH - Rock.WIDTH / 2),
					0);

			bananas.add(new Bananas(origin, destination,
					MathUtils.random(2f, 4f)));
		}

		for (Bananas banana : bananas) {
			stage.addActor(banana);
		}
	}

	// Crea los cocos y los añade al escenario.
	private void createCoconuts (int max) {
		int numOfCoconuts = MathUtils.random(1, max);

		for (int i = 0; i < numOfCoconuts; i++) {
			Vector2 origin = new Vector2(
					MathUtils.random(0 + Rock.WIDTH / 2, WIDTH - Rock.WIDTH / 2), 
					HEIGHT);
			Vector2 destination = new Vector2(
					MathUtils.random(0 + Rock.WIDTH / 2, WIDTH - Rock.WIDTH / 2),
					0);

			coconuts.add(new Coconut(origin, destination,
					MathUtils.random(2f, 4f)));
		}

		for (Coconut coconut : coconuts) {
			stage.addActor(coconut);
		}
	}
	
	// Método level que se llama cada vez que el render es actualizado
	private void level(int level) {
		switch(level){
		case 1:

			// Crear rocas del nivel.
			if (rocks.size == 0 && !FlyingObjets.isFlyingRocks(rocks)) {
				createRocks(2);
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
				createBananas(3);
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
				createCoconuts(3);
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
			jungleSonud();
			
			
			break;
		default:
			break;
		}
	}

	// Por defecto la musica no existe.
	private boolean musicExist = false;
	
	// Musica de la jungla
	private void jungleSonud() {
		// Si no existe musica, colocarla.
		if (!musicExist) {
			// Crear la musica.
			music = new GameSounds().newMusic(1);//Sonara riverside
			// Que se haga un loop con la musica, osea que cuando termine empiece de nuevo
			// indifinidamente.
			music.setLooping(true);
			music.play(); // Reproducir musica.
			// Avisar de que si existe musica.
			musicExist = true;
		}
	}

	private void createMono () {
		stage.addActor(shimp);
	}

	private Image createArrowLeft () {
		TextureRegion txtRegion;
		Texture texture;
		texture = new Texture("extras/arrowleft.png");
		txtRegion = new TextureRegion(texture);
		arrowLeft = new Image(txtRegion);
		arrowLeft.setSize(128, 128);
		arrowLeft.setPosition(0, 240);

		return arrowLeft;
	}
	
	private Image createArrowRigth () {
		TextureRegion txtRegion;
		Texture texture;
		texture = new Texture("extras/arrowrigth.png");
		txtRegion = new TextureRegion(texture);
		arrowRigth = new Image(txtRegion);
		arrowRigth.setSize(128, 128);
		arrowRigth.setPosition(WIDTH - arrowRigth.getWidth(), 240);
		
		return arrowRigth;
	}
}
