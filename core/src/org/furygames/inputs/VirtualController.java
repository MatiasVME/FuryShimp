package org.furygames.inputs;

public abstract class VirtualController {
	
	private static boolean moveRight;
	private static boolean moveLeft;
	
	public static boolean isMoveLeft() {
		return moveLeft;
	}
	
	public static void setMoveLeft(boolean moveLeft) {
		VirtualController.moveLeft = moveLeft;
	}
	
	public static boolean isMoveRight() {
		return moveRight;
	}
	
	public static void setMoveRight(boolean moveRight) {
		VirtualController.moveRight = moveRight;
	}
}
