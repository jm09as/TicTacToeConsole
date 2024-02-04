package model;

public enum Marking {

	PLAYER_A_MARKING('O'),
	PLAYER_X_MARKING('X');

	private char marking;

	Marking(char marking) {
		this.marking = marking;
	}

	public char getMarking() {
		return marking;
	}

}