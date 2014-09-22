package org.furygames.furyshimp;

public enum Levels {
	
	LEVEL6 (null, 6, 100, 105, 110), 
	LEVEL5 (LEVEL6, 5, 95, 98, 105),
	LEVEL4 (LEVEL5, 4, 110, 115, 125), 
	LEVEL3 (LEVEL4, 3, 105, 110, 115), 
	LEVEL2 (LEVEL3, 2, 80, 86, 90), 
	LEVEL1 (LEVEL2, 1, 95, 100, 105); 
	
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
