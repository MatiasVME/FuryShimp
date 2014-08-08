package org.furygames.furyshimp;

public enum Levels {
	LEVEL3 (null),
	LEVEL2 (LEVEL3),
	LEVEL1 (LEVEL2);
	
	private final Levels next;
	
	private Levels (Levels next) {
		this.next = next;
	}
	
	public Levels next () {
		return next == null ? LEVEL3 : next;
	}
}
