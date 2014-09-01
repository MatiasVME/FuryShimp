package org.furygames.furyshimp;

public enum Levels {
	
	LEVEL6 (null, 6, 11, 115, 120), // ~
	LEVEL5 (LEVEL6, 5, 11, 118, 120), // Ok
	LEVEL4 (LEVEL5, 4, 11, 125, 140), // Ok
	LEVEL3 (LEVEL4, 3, 11, 130, 145), // Ok
	LEVEL2 (LEVEL3, 2, 10, 110, 115), // Ok
	LEVEL1 (LEVEL2, 1, 10, 100, 110); // 
	
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
		return next == null ? LEVEL6 : next;
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
