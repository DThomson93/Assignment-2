/*
 * Fairly basic class. Constructor is called when user creates a HorseBet. 
 * Amount and Horse user bet on is passed to the constructor. 
 * Later these values would be accessed and printed to the receipt.
 */
package bettingApp;

public class HorseBet extends Bet {

	private String horse;
	private String type;
	private static String[] horses = { "Easy Goer", "Frankel", "Kincsem",
			"Man o' War", "Niatross", "Secretariat", "Bernborough", "Crisp",
			"Desert Gold", "Ajax" };

	public HorseBet(double amount, String horse) {
		super(amount);
		type = horse;
	}

	public static String[] getHorses() {
		return horses;
	}

	public String getType() {
		return type;
	}
}
