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
	private Table table;
	private TextButton startButton;
	private TextButton creditButton;
	private TextButton exitButton;

	public MenuScreen (final FuryShimp universalMonkey) {
		super(universalMonkey);
	}

	@Override
	public void show() {
		super.show();

		skin = new Skin(Gdx.files.internal("uiskin/uiskin.json"));

		startButton = new TextButton("Start", skin);
		creditButton = new TextButton("Credits", skin);
		exitButton = new TextButton("Exit", skin);
		
		final float pad = 40;
		final float width = 400f;
		final float height = 100f;

		table = new Table();
		table.setFillParent(true);
		table.add(startButton).pad(pad).width(width).height(height);
		table.row();
		table.add(creditButton).pad(pad).width(width).height(height);
		table.row();
		table.add(exitButton).pad(pad).width(width).height(height);

		startButton.addListener(new ClickListener(){
			@Override 
			public void clicked(InputEvent event, float x, float y){
				universalMonkey.setScreen(universalMonkey.getLevelsScreen());
			}
		});
		
		creditButton.addListener(new ClickListener(){
			@Override 
			public void clicked(InputEvent event, float x, float y){
				universalMonkey.setScreen(universalMonkey.getCreditsScreen());
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
