package org.furygames.furyshimp;

public enum Levels {
	LEVEL3 (null, 80),
	LEVEL2 (LEVEL3, 70),
	LEVEL1 (LEVEL2, 60);
	
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
