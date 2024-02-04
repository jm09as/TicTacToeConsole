package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Coordinate;
import model.Player;
import model.Sign;
import tools.Board;
import tools.ExitGameException;
import tools.UserInput;

public class Play {

	private boolean exit;
	private boolean choosePlayer;
	private final Player bluePlayer;
	private final Player redPlayer;
	private final Scanner sc;

	public Play(Player bluePlayer, Player redPlayer, Scanner sc) {
		this.bluePlayer = bluePlayer;
		this.redPlayer = redPlayer;
		this.sc = sc;
	}

	public void round(Sign sign, Board board) {
		board.printBoard(sign);
		Message.printGameStatus(exit = checkWin(), getCurrentName().toLowerCase().replaceAll("player", "").toUpperCase());
	}

	public Sign askPlayerSign() throws ExitGameException {
		Sign sign = new Sign();
		sign.setMarking(getPlayer().getName());
		UserInput input = new UserInput(sc);
		Message.printAskPlayer(getCurrentName());
		Coordinate coordinate;
		coordinate = getCoordinate(input);
		sign.setColumn(coordinate.getColumn());
		sign.setRow(coordinate.getRow());
		getPlayer().getCordinates().add(coordinate);
		return sign;
	}

	private Coordinate getCoordinate(UserInput input) throws ExitGameException {
		Coordinate coordinate = null;
		do {
			Message.printCoordianteUsage(coordinate);
			coordinate = input.askCoordinate();
		} while (checkUsedCoordinate(coordinate));
		return coordinate;
	}

	private boolean checkUsedCoordinate(Coordinate coordinate) {
		List<Coordinate> allCoordiante = new ArrayList<>(redPlayer.getCordinates());
		allCoordiante.addAll(bluePlayer.getCordinates());
		return allCoordiante.contains(coordinate);
	}

	private String getCurrentName() {
		try {
			return this.getClass().getDeclaredField(choosePlayer ? "redPlayer" : "bluePlayer").getName();
		} catch (NoSuchFieldException | SecurityException e) {
			throw new RuntimeException();
		}
	}

	private Player getPlayer() {
		return choosePlayer ? redPlayer : bluePlayer;
	}

	public boolean changePlayer() {
		return choosePlayer = choosePlayer == false ? true : false;
	}

	public boolean checkWin() {
		int result = 3;
		for (var cwinList : Coordinate.getWinList()) {
			int i = 0;
			for (var playerCordiante : getPlayer().getCordinates()) {
				if (!cwinList.contains(playerCordiante)) {
					continue;
				}
				if (result == ++i) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isExit() {
		return exit;
	}

}
