package tools;

import java.util.Scanner;

import model.Coordinate;

public class UserInput {

	private final Scanner sc;

	public UserInput(Scanner sc) {
		this.sc = sc;
	}

	public Coordinate askCoordinate() throws ExitGameException {
		String cordiante = sc.nextLine();
		cordiante = invertCoordinate(cordiante);
		for (Coordinate c : Coordinate.values()) {
			if (c.name().equalsIgnoreCase(cordiante)) {
				return c;
			}
		}
		if (cordiante.equalsIgnoreCase("q")) {
			throw new ExitGameException("Kilptél a játékból!");
		}
		System.out.println("Nem megfelelő kordináta! Válassz másikat! :");
		return askCoordinate();
	}

	private String invertCoordinate(String cordiante) {
		return Character.isDigit(cordiante.codePointAt(0)) ? String.valueOf(cordiante.charAt(1)) + String.valueOf(cordiante.charAt(0)) : cordiante;
	}

}