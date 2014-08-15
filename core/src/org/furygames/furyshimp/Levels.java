package org.furygames.furyshimp;

public enum Levels {
	
	LEVEL10 (null, 65, 70, 80),
	LEVEL9 (LEVEL10, 65, 70, 80),
	LEVEL8 (LEVEL9, 65, 70, 80),
	LEVEL7 (LEVEL8, 65, 70, 80),
	LEVEL6 (LEVEL7, 65, 70, 80),
	LEVEL5 (LEVEL6, 65, 70, 80),
	LEVEL4 (LEVEL5, 65, 70, 80),
	LEVEL3 (LEVEL4, 100, 110, 120),
	LEVEL2 (LEVEL3, 90, 100, 110),
	LEVEL1 (LEVEL2, 65, 70, 80);
	
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
		return next == null ? LEVEL10 : next;
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
