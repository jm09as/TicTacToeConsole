package model;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private final Marking name;
	private List<Coordinate> cordinates = new ArrayList<>();

	public Player(Marking marking) {
		this.name = marking;
	}

	public Marking getName() {
		return name;
	}

	public List<Coordinate> getCordinates() {
		return cordinates;
	}

	public void setCordinates(List<Coordinate> cordinates) {
		this.cordinates = cordinates;
	}

}
