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
			"Valegro", "Ajax", "Adios", "Bold Ruler", "Cigar", "Desert Gold", 
			"Eclipse", "Funny Cide", "Gloaming", "Hyperion", "Iroquois", "Kelso", 
			"Might and Power", "Red Rum", "Seabiscuit", "Totilas", "Vain", "War Admiral", 
			"Zenyatta", "Affirmed", "Alydar", "Emperor"};
	
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
	
	/* Much like the FootballBet and BoxingBet methods, this was intended to generate random Horse Races for each venue.
	 * The amount of work required for ensuring that no duplicates names were shown in each race and in each venue was deemed too much for too little gain.
	 * Because of this, the idea was scrapped in favour of focusing on core elements of the program.
	public static String[] randomHorseRace() {
		String tempHorses[] = {"Easy Goer", "Frankel", "Kincsem", "Man o' War",
				"Niatross", "Secretariat", "Bernborough", "Crisp", "Valegro", "Ajax"};
		
		return tempHorses;
		
	}
	
	public static String getFirst() {
		String[] tempMatch = horses;
		String fTeam = tempMatch[generateRandom()];
		return fTeam;
	}
	
	public static String getSecond() {
		String[] tempMatch = horses;
		String sTeam = tempMatch[generateRandom()];
		return sTeam;
	}
	*/
}
