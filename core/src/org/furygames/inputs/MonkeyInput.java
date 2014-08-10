package org.furygames.inputs;

import org.furygames.screens.GameScreen;

import com.badlogic.gdx.Input;
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
	
<<<<<<< HEAD
=======
	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
			case Input.Keys.LEFT:
				VirtualController.setMoveLeft(true);
				break;
			case Input.Keys.RIGHT:
				VirtualController.setMoveRight(true);
				break;
		}

		return super.keyDown(keycode);
	}
	
	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {
			case Input.Keys.LEFT:
				VirtualController.setMoveLeft(false);
				break;
			case Input.Keys.RIGHT:
				VirtualController.setMoveRight(false);
				break;
		}
		return super.keyUp(keycode);
	}
>>>>>>> 55329b238ff8c925daa743186ac5e7e99a78a80d
}
