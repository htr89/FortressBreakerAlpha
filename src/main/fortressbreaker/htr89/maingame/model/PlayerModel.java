package main.fortressbreaker.htr89.maingame.model;

public class PlayerModel {

	private String name;

	private int gold;

	private WallModel typeOfWall;

	private RockModel typeOfRock;

	private int numberOfShots;

	private int numberOfHammers;

	private String userId;

	public PlayerModel() {
		name = "Player";
		gold = 50;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String user_ID) {
		this.userId = user_ID;
	}

	public RockModel getTypeOfRock() {
		return typeOfRock;
	}

	public void setTypeOfRock(RockModel typeOfRock) {
		this.typeOfRock = typeOfRock;
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

	public int getNumberOfShots() {
		return numberOfShots;
	}

	public void setNumberOfShots(int numberOfShots) {
		this.numberOfShots = numberOfShots;
	}

	public int getNumberOfHammers() {
		return numberOfHammers;
	}

	public void setNumberOfHammers(int numberOfHammers) {
		this.numberOfHammers = numberOfHammers;
	}

}
