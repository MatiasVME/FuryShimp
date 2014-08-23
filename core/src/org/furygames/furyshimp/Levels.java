package org.furygames.furyshimp;

public enum Levels {
	
	LEVEL10 (null, 10, 0, 1, 2),
	LEVEL9 (LEVEL10, 9, 0, 1, 2),
	LEVEL8 (LEVEL9, 8, 0, 1, 2),
	LEVEL7 (LEVEL8, 7, 0, 1, 2),
	LEVEL6 (LEVEL7, 6, 110, 115, 120), // ~
	LEVEL5 (LEVEL6, 5, 114, 118, 120), // Ok
	LEVEL4 (LEVEL5, 4, 115, 125, 140), // Ok
	LEVEL3 (LEVEL4, 3, 110, 130, 145), // Ok
	LEVEL2 (LEVEL3, 2, 105, 110, 115), // Ok
	LEVEL1 (LEVEL2, 1, 95, 100, 110); // Ok
	
	private final Levels next;
	private int numLevel; // Numero del nivel
	private int minScore; // Puntaje minimo
	private int medScore; // Puntaje medio
	private int excScore; // Puntaje excelente
	
	private Levels (Levels next, int numLevel, int minScore, int medScore, int excScore) {
		this.next = next;
		this.numLevel = numLevel;
		this.minScore = minScore;
		this.medScore = medScore;
		this.excScore = excScore;
	}
	
	public Levels next () {
		return next == null ? LEVEL10 : next;
	}
	
	public int getNumLevel () {
		return numLevel;
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
