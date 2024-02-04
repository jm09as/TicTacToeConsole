package tools;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import model.Sign;

public class Board {

	private String[] column;
	private String[] column0;
	private String[] column1;
	private String[] column2;

	public Board() {
		this.column = prepareColumn("");
		this.column0 = prepareColumn("A");
		this.column1 = prepareColumn("B");
		this.column2 = prepareColumn("C");

	}

	private void printColumnsBoard() {
		Arrays.stream(column).forEach(System.out::print);
		System.out.println();
	}

	private void printColumnsBoard(String number) {
		Arrays.stream(column).forEach(System.out::print);
		System.out.println(" %s".formatted(number));
	}

	private void printColumnsBoard(Sign sign, int row) {
		drawPlayerMarking(sign, row);
		switch (row) {
			case 0 -> Arrays.stream(column0).forEach(System.out::print);
			case 1 -> Arrays.stream(column1).forEach(System.out::print);
			case 2 -> Arrays.stream(column2).forEach(System.out::print);
			default -> printColumnsBoard();
		}
		System.out.println();
	}

	private void drawPlayerMarking(Sign sign, int row) {
		switch (row) {
			case 0 -> {
				takePlayerMarking(sign, row, column0);
			}
			case 1 -> {
				takePlayerMarking(sign, row, column1);
			}
			case 2 -> {
				takePlayerMarking(sign, row, column2);
			}
			default -> throw new NoSuchElementException();
		}
	}

	private void takePlayerMarking(Sign sign, int key, String[] column) {
		if (key != sign.getRow()) {
			return;
		}
		for (int i = 0; i < column.length; i++) {
			column[i] = sign.getColumn() == i ? String.valueOf(sign.getMarking().getMarking()) : column[i].equals(" ") ? " " : column[i];
		}
	}

	private void printRowsBoard() {
		for (int i = 0; i <= 60; i++) {
			System.out.print(i % 2 == 0 ? '—' : " ");
		}
		System.out.println();
	}

	public void printBoard(Sign sign) {
		printBoardMargin();
		printRowsBoard();
		for (int i = 0; i < 3; i++) {
			printColumnsBoard();
			printColumnsBoard();
			if (sign == null) {
				printColumnsBoard();
			} else {
				printColumnsBoard(sign, i);
			}
			printColumnsBoard();
			printColumnsBoard();
			printColumnsBoard();
			printRowsBoard();
		}

	}

	public void printEmptyBoard(LinkedList<String> marginNumber) {
		printBoardMargin();
		printRowsBoard();
		for (int i = 0; i < 3; i++) {
			printColumnsBoard();
			printColumnsBoard();
			printColumnsBoard(marginNumber.poll());
			printColumnsBoard();
			printColumnsBoard();
			printColumnsBoard();
			printRowsBoard();
		}

	}

	private String[] prepareColumn(String number) {
		String[] column = new String[61];
		for (int i = 0; i <= 60; i++) {
			column[i] = i % 20 == 0 ? i == 60 ? "| %s".formatted(number) : "|" : " ";
		}
		return column;
	}

	private void printBoardMargin() {
		LinkedList<String> margin = new LinkedList<>(List.of("     1     ", "     2     ", "     3     "));
		for (int i = 0; i < 3; i++) {
			System.out.print(String.format("     %s    ", margin.pollFirst()));
		}
		System.out.println();
	}

}

