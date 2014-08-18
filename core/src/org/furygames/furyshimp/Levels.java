package org.furygames.furyshimp;

public enum Levels {
	
	LEVEL10 (null, 10, 65, 70, 80),
	LEVEL9 (LEVEL10, 9, 65, 70, 80),
	LEVEL8 (LEVEL9, 8, 65, 70, 80),
	LEVEL7 (LEVEL8, 7, 65, 70, 80),
	LEVEL6 (LEVEL7, 6, 65, 70, 80),
	LEVEL5 (LEVEL6, 5, 65, 70, 80),
	LEVEL4 (LEVEL5, 4, 65, 70, 80),
	LEVEL3 (LEVEL4, 3, 100, 110, 120),
	LEVEL2 (LEVEL3, 2, 100, 105, 110),
	LEVEL1 (LEVEL2, 1, 95, 100, 110);
	
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
