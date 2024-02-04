package main;

import model.Coordinate;

public class Message {

	public static void printStaterInfo() {
		System.out.printf("%nÜdvözöllek a \"TicTacToe Console\" játékban!%n%n" + //
				"Két játékos játszik egymás ellen a RED és a BLUE.%n" + //
				"A kordinántát két féle képpen adhatod meg, vagy számmal vagy betűvel kezded. pl:(a1, 1a)%n" + //
				"a 'q' karakter kiléptet a játszmából.%n" + //
				"A BLUE játékos kezd a 'O' jellel.%n%n");
	}

	public static void printExitInfo(String exit) {
		System.out.printf(exit);
	}

	public static void printInfo(String info) {
		System.out.printf(info);
	}

	public static void printAskPlayer(String curentName) {
		System.out.printf("%s Add meg a kordinátát: ".formatted(curentName.toUpperCase().replaceFirst("PLAYER", " PLAYER")));
	}

	public static void printCoordianteUsage(Coordinate coordinate) {
		System.out.print(coordinate == null ? "" : "Ez a kordináta (%s) már fel lett használva!".formatted(coordinate.name()));
	}

	public static void printGameStatus(boolean checkWin, String currentName) {
		System.out.println(checkWin ? String.format("%s MEGNYERTED A JÁTÉKOT !!!", currentName) : "");
	}

	public static void printWrongCoordinate() {
		System.out.print("Nem megfelelő kordináta! Válassz másikat! :");
	}

}
