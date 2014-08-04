package org.furygames.inputs;

import org.furygames.screens.GameScreen;

import com.badlogic.gdx.InputAdapter;

public class MonkeyInput extends InputAdapter {
	
	private VirtualController vc;
	
	public MonkeyInput (VirtualController vc) {
		this.vc = vc;
	}
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		if (screenX <= GameScreen.WIDTH / 2) {
			System.out.println("Izquierda!");
			vc.setMoveLeft(true);
		}
		
		else {
			System.out.println("Derecha!");
			vc.setMoveRight(true);
		}

		return super.touchDown(screenX, screenY, pointer, button);
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if (screenX <= GameScreen.WIDTH / 2) {
			vc.setMoveLeft(false);
		}
		
		else {
			vc.setMoveRight(false);
		}
		
		return super.touchUp(screenX, screenY, pointer, button);
	}
}
