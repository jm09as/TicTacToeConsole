package model;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private final Marking name;
	private List<Coordinate> coordinates = new ArrayList<>();

	public Player(Marking marking) {
		this.name = marking;
	}

	public Marking getName() {
		return name;
	}

	public List<Coordinate> getCoordinates() {
		return coordinates;
	}

	public void setCordinates(List<Coordinate> coordinates) {
		this.coordinates = coordinates;
	}

}
