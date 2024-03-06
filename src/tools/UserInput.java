package tools;

import java.util.Scanner;

import main.Message;
import model.Coordinate;

public class UserInput {

	private final Scanner sc;

	public UserInput(Scanner sc) {
		this.sc = sc;
	}

	public Coordinate askCoordinate() throws ExitGameException {
		String coordiante = sc.nextLine();
		coordiante = invertCoordinate(coordiante);
		for (Coordinate c : Coordinate.values()) {
			if (c.name().equalsIgnoreCase(coordiante)) {
				return c;
			}
		}
		if (coordiante.equalsIgnoreCase("q")) {
			throw new ExitGameException("Kilptél a játékból!");
		}
		Message.printWrongCoordinate();
		return askCoordinate();
	}

	private String invertCoordinate(String cordiante) {
		return Character.isDigit(cordiante.codePointAt(0)) ? String.valueOf(cordiante.charAt(1)) + String.valueOf(cordiante.charAt(0)) : cordiante;
	}

}