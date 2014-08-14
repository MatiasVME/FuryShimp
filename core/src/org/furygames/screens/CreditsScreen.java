package org.furygames.screens;

import org.furygames.furyshimp.FuryShimp;

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
		// TODO Auto-generated method stub
		super.show();
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		super.render(delta);
	}
}
