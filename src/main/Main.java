package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import model.Marking;
import model.Player;
import model.Sign;
import tools.Board;
import tools.ExitGameException;

public class Main {

	public static void main(String[] args) {

		new Main().run();
	}

	private void run() {
		try (Scanner sc = new Scanner(System.in)) {
			Message.printStaterInfo();
			for (boolean stayInPlay = true; stayInPlay; stayInPlay = sc.nextLine().equalsIgnoreCase("i")) {
				session(sc);
				Message.printInfo("%nSzeretnél új játékot kezdeni? (i/n): ");
			}
			Message.printExitInfo("%nViszlát!");
		} catch (Exception e) {
			System.out.println(e.getStackTrace().toString());
		}
	}

	private void session(Scanner sc) {
		Player blue = new Player(Marking.PLAYER_A_MARKING, new ArrayList<>());
		Player red = new Player(Marking.PLAYER_X_MARKING, new ArrayList<>());
		Board board = new Board();
		board.printEmptyBoard(new LinkedList<>(List.of("A", "B", "C")));
		for (Play play = new Play(blue, red, sc); !play.isExit();) {
			try {
				Sign sign = play.askPlayerSign();
				play.round(sign, board);
				play.changePlayer();
			} catch (ExitGameException e) {
				Message.printExitInfo(e.getMessage());
				play.setExit(true);
			}
		}
	}

}
