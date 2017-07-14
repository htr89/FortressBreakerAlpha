package main.fortressbreaker.htr89.maingame.model;

public class AiModel {

	private String name;

	private int gold;

	private WallModel typeOfWall;

	private RockModel typeOfRock;

	public AiModel() {
		name = "Nicolas Strongarm";
		gold = 50;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public WallModel getTypeOfWall() {
		return typeOfWall;
	}

	public void setTypeOfWall(WallModel typeOfWall) {
		this.typeOfWall = typeOfWall;
	}

	public RockModel getTypeOfRock() {
		return typeOfRock;
	}

	public void setTypeOfRock(RockModel typeOfRock) {
		this.typeOfRock = typeOfRock;
	}

}
