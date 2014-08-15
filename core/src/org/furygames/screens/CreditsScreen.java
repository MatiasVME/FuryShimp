package org.furygames.screens;

import org.furygames.furyshimp.FuryShimp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class CreditsScreen extends GenericScreen {
	
	private Texture logo;
	private TextButton backButton;

	public CreditsScreen(FuryShimp universalMonkey) {
		super(universalMonkey);
		
		logo = new Texture ("logo.png");
	}
	
	@Override
	public void show() {
		super.show();
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		stage.draw();
		stage.act();

		if(Gdx.input.isKeyPressed(Keys.BACK))universalMonkey.setScreen(universalMonkey.getMenuScreen());
	}
}
