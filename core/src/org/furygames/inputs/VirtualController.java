package org.furygames.inputs;

public class VirtualController {
	
	private boolean moveRight;
	private boolean moveLeft;
	
	public boolean isMoveLeft() {
		return moveLeft;
	}
	
	public void setMoveLeft(boolean moveLeft) {
		this.moveLeft = moveLeft;
	}
	
	public boolean isMoveRight() {
		return moveRight;
	}
	
	public void setMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}
}
