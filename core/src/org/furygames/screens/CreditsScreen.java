package org.furygames.screens;

import org.furygames.furyshimp.FuryShimp;

import com.badlogic.gdx.graphics.Texture;

public class CreditsScreen extends GenericScreen {
	
	private Texture logo;
	

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
