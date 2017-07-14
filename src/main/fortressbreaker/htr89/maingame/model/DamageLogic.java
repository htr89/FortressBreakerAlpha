package main.fortressbreaker.htr89.maingame.model;

public class DamageLogic {

	private PlayerModel playerModel;
	private AiModel aiModel;
	private int dmgPlayer;
	private int dmgAi;
	private double resAi;
	private double resPlayer;

	public DamageLogic(PlayerModel playerModel, AiModel aiModel) {
		this.playerModel = playerModel;
		this.aiModel = aiModel;
		dmgAi = aiModel.getTypeOfRock().getDamage();
		resPlayer = playerModel.getTypeOfWall().getResistance();
		dmgPlayer = playerModel.getTypeOfRock().getDamage();
		resAi = aiModel.getTypeOfWall().getResistance();
	}

	public void playerDamagesAI() {
		double damage = dmgPlayer - (resAi * dmgPlayer);

		aiModel.getTypeOfWall().setHitPoints(damage);
		System.out.println(aiModel.getTypeOfWall().getHitPoints());
	}

	public void aiDamagesPlayer() {
		double damage = dmgAi - (resPlayer * dmgAi) + 10;
		playerModel.getTypeOfWall().setHitPoints(damage);
		System.out.println("Player hp:" + playerModel.getTypeOfWall().getHitPoints());

	}

}
