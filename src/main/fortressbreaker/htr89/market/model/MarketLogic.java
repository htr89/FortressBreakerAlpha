package main.fortressbreaker.htr89.market.model;

/**
 * This class defines the Market, with its gold amount (that the players can
 * spend).
 * 
 * @author Htr89
 *
 */
public class MarketLogic {
	/**
	 * The max gold coins.
	 */
	public int goldcoins;

	public int payGold(Market aCost) {
		return goldcoins -= aCost.getGoldcoins();

	}

	public int refundGold(Market aCost) {
		return goldcoins += aCost.getGoldcoins();

	}

	public int getGoldcoins() {
		return goldcoins;
	}

	public void setGoldcoins(int goldcoins) {
		this.goldcoins = goldcoins;
	}

	/**
	 * This Enum contains all disposal of the Market, with the respective gold
	 * price and name.
	 * 
	 * @author Htr89
	 *
	 */
	public enum Market {
		MORESECONDS(15, "+30 Seconds"), ROCKS(15, "+5 Weapons"), HAMMERS(15, "+3 Shields");

		private int goldcoins;
		private String robeName;

		private Market(int goldcoins, String robeName) {
			// TODO Auto-generated constructor stub
			this.goldcoins = goldcoins;
			this.robeName = robeName;
		}

		public int getGoldcoins() {
			return goldcoins;
		}

		public String getRobeName() {
			return robeName;
		}
	}
}
