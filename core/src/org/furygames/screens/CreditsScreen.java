package org.furygames.screens;

import org.furygames.furyshimp.FuryShimp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class CreditsScreen extends GenericScreen {
	
	private Texture ttBackButton;
	private Image imgBackButton;
	
	private Texture credits;

	public CreditsScreen(final FuryShimp universalMonkey) {
		super(universalMonkey);
		
		credits = new Texture ("backgrounds/background_credits.jpg");
		
		// Back button
		ttBackButton = new Texture("buttons/back_button.png");
		imgBackButton = new Image(ttBackButton);
		imgBackButton.setSize(80, 82);
		imgBackButton.setPosition(GameScreen.WIDTH - 128f, 0);
		
		imgBackButton.addListener(new ClickListener(){
            @Override 
            public void clicked(InputEvent event, float x, float y){
            	universalMonkey.setScreen(universalMonkey.getMenuScreen());
            }
        });
		
		stage.addActor(imgBackButton);
	}
	
	@Override
	public void show() {
		super.show();
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		batch.begin();
			batch.draw(credits, 0, 0);
		batch.end();
		
		stage.act();
		stage.draw();

		if (Gdx.input.isKeyPressed(Keys.BACK)) 
			universalMonkey.setScreen(universalMonkey.getMenuScreen());
	}
	
	@Override
	public void dispose() {
		ttBackButton.dispose();
		batch.dispose();
		
		super.dispose();
	}
}
