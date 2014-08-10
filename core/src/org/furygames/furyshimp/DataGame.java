package org.furygames.furyshimp;

public class DataGame {
	private static int level;
	private static int lifes = 3;
	private static int score = 0;
	
	public static int getLevel() {
		return level;
	}
	
	public static void setLevel(int level) {
		DataGame.level = level;
	}
	
	public static int getLifes() {
		return lifes;
	}
	
	public static void setLifes(int lifes) {
		DataGame.lifes = lifes;
	}
	
	public static void removeLife (int lifes) {
		DataGame.lifes -= lifes;
	}
	
	public static int getScore() {
		return score;
	}
	
	public static void setScore(int score) {
		DataGame.score = score;
	}
	
	public static void addScore (int score) {
		DataGame.score += score;
	}
}
