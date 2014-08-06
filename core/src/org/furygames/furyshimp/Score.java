package org.furygames.furyshimp;

public class Score {
	private static int lifes = 3;
	private static int score = 0;
	
	public static int getLifes() {
		return lifes;
	}
	
	public static void setLifes(int lifes) {
		Score.lifes = lifes;
	}
	
	public static void removeLife (int lifes) {
		Score.lifes -= lifes;
	}
	
	public static int getScore() {
		return score;
	}
	
	public static void setScore(int score) {
		Score.score = score;
	}
	
	public static void addScore (int score) {
		Score.score += score;
	}
}
