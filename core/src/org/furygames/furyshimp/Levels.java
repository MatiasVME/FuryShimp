package org.furygames.furyshimp;

public enum Levels {
	LEVEL3 (null, 30),
	LEVEL2 (LEVEL3, 20),
	LEVEL1 (LEVEL2, 10);
	
	private final Levels next;
	private int minScore;
	
	private Levels (Levels next, int minScore) {
		this.next = next;
		this.minScore = minScore;
	}
	
	public Levels next () {
		return next == null ? LEVEL3 : next;
	}
	
	public int getMinScore () {
		return minScore;
	}
}
