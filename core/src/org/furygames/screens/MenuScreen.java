package org.furygames.screens;

import org.furygames.furyshimp.FuryShimp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MenuScreen extends GenericScreen {

	private Skin skin;
	private TextButton startButton;
	private Table table;
	private TextButton scoreButton;

	public MenuScreen (final FuryShimp universalMonkey) {
		super(universalMonkey);
	}

	@Override
	public void show() {
		super.show();

		skin = new Skin(Gdx.files.internal("uiskin/uiskin.json"));

		startButton = new TextButton("Start", skin);
		scoreButton = new TextButton("Score", skin);

		table = new Table();
		table.setFillParent(true);
		table.add(startButton).pad(50).width(400f).height(100);
		table.row();
		table.add(scoreButton).pad(50).width(400f).height(100);

		startButton.addListener(new ClickListener(){
			@Override 
			public void clicked(InputEvent event, float x, float y){
				universalMonkey.setScreen(universalMonkey.getGameScreen());
			}
		});

		scoreButton.addListener(new ClickListener(){
			@Override 
			public void clicked(InputEvent event, float x, float y){
				universalMonkey.setScreen(universalMonkey.getScoreScreen());
			}
		});

		stage.addActor(table);
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		stage.draw();
		stage.act();

		// Condicion si el boton presionado es BACK ejecutar la accion salir de la app
		if(Gdx.input.isKeyPressed(Keys.BACK))Gdx.app.exit();
	}

}
