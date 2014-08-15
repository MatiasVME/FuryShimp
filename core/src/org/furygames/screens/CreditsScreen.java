package org.furygames.screens;

import org.furygames.furyshimp.DataGame;
import org.furygames.furyshimp.FuryShimp;
import org.furygames.furyshimp.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class CreditsScreen extends GenericScreen {
	
	private Texture ttLogo;
	private Image imgLogo;
	
	private Texture ttBackButton;
	private Image imgBackButton;
	
	private BitmapFont credits;
	private String txtCredits;

	public CreditsScreen(final FuryShimp universalMonkey) {
		super(universalMonkey);
		
		// Logo
		ttLogo = new Texture ("logo.png");
		imgLogo = new Image (ttLogo);
		imgLogo.setSize(512 / 2, 256 / 2);	
		imgLogo.setCenterPosition(GameScreen.WIDTH / 2, GameScreen.HEIGHT - imgLogo.getHeight() / 2);
		
		// Back button
		ttBackButton = new Texture("buttons/back_button.png");
		imgBackButton = new Image(ttBackButton);
		imgBackButton.setSize(128, 128);
		imgBackButton.setPosition(GameScreen.WIDTH - 128f, 0);
		
		// Creditos
		credits = new BitmapFont(Gdx.files.internal("fonts/jungle.fnt"), 
				Gdx.files.internal("fonts/jungle.png"), false);
		credits.setColor(Color.BLUE);
		txtCredits = "\tCredits \n\n" 
				+ "Programers:\n" 
				+ "Victor Gracia Magallon (Spain)\n"
				+ "Matias Munoz Espinoza (Chile)\n\n"
				+ "Graphic Design:\n"
				+ "Hector Pena (Mexico)\n\n"
				+ "Music:\n"
				+ "Matthew Pablo (www.matthewpablo.com)";		
		
		stage.addActor(imgLogo);
		stage.addActor(imgBackButton);
		
		imgBackButton.addListener(new ClickListener(){
            @Override 
            public void clicked(InputEvent event, float x, float y){
            	universalMonkey.setScreen(universalMonkey.getMenuScreen());
            }
        });
	}
	
	@Override
	public void show() {
		super.show();
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		batch.begin();
			credits.drawMultiLine(batch, txtCredits, 100, 500);
		batch.end();
		
		stage.draw();
		stage.act();

		if (Gdx.input.isKeyPressed(Keys.BACK)) 
			universalMonkey.setScreen(universalMonkey.getMenuScreen());
	}
	
	@Override
	public void dispose() {
		ttLogo.dispose();
		
		
		super.dispose();
	}
}
