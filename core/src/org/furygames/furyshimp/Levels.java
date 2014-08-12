package org.furygames.furyshimp;

public enum Levels {
	LEVEL3 (null, 100, 110, 120),
	LEVEL2 (LEVEL3, 90, 100, 110),
	LEVEL1 (LEVEL2, 80, 90, 100);
	
	private final Levels next;
	private int minScore; // Puntaje minimo
	private int medScore; // Puntaje medio
	private int excScore; // Puntaje excelente
	
	private Levels (Levels next, int minScore, int medScore, int excScore) {
		this.next = next;
		this.minScore = minScore;
		this.medScore = medScore;
		this.excScore = excScore;
	}
	
	public Levels next () {
		return next == null ? LEVEL3 : next;
	}
	
	public int getMinScore () {
		return minScore;
	}

	public int getMedScore() {
		return medScore;
	}

	public int getExcScore() {
		return excScore;
	}
}
