package org.furygames.inputs;

import org.furygames.screens.GameScreen;

import com.badlogic.gdx.InputAdapter;

public class MonkeyInput extends InputAdapter {
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		if (screenX <= GameScreen.WIDTH / 2) {
			VirtualController.setMoveLeft(true);
		}
		
		else {
			VirtualController.setMoveRight(true);
		}

		return super.touchDown(screenX, screenY, pointer, button);
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if (screenX <= GameScreen.WIDTH / 2) {
			VirtualController.setMoveLeft(false);
		}
		
		else {
			VirtualController.setMoveRight(false);
		}
		
		return super.touchUp(screenX, screenY, pointer, button);
	}
	
}
