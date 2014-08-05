package org.furygames.furyshimp;

public class Score {
	private static int badScore = 0;
	private static int goodScore = 0;
	
	public int getBadScore() {
		return badScore;
	}
	
	public static void setBadScore(int badScore) {
		Score.badScore = badScore;
	}
	
	public int getGoodScore() {
		return goodScore;
	}
	
	public static void setGoodScore(int goodScore) {
		Score.goodScore = goodScore;
	}
}
