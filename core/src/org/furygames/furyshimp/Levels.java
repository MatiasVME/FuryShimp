package org.furygames.furyshimp;

public enum Levels {
	LEVEL3 (null, 80, 85, 90),
	LEVEL2 (LEVEL3, 80, 85, 90),
	LEVEL1 (LEVEL2, 80, 85, 90);
	
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
