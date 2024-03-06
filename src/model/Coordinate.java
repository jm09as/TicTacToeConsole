package model;

import java.util.List;

public enum Coordinate {

	A1(0, 10),
	A2(0, 30),
	A3(0, 50),
	B1(1, 10),
	B2(1, 30),
	B3(1, 50),
	C1(2, 10),
	C2(2, 30),
	C3(2, 50);

	private int row;
	private int column;

	Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public static List<List<Coordinate>> getWinList() {
		return List.of(List.of(A1, A2, A3), //
				List.of(B1, B2, B3), //
				List.of(C1, C2, C3), //
				List.of(A1, B1, C1), //
				List.of(A3, B3, C3), //
				List.of(A2, B2, C2), //
				List.of(A1, B2, C3), //
				List.of(A3, B2, C1)) //
		;
	}

}
