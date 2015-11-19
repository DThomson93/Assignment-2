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
			"Zenyatta", "Affirmed", "Alydar"};
	
	//Backup Horses is accessed if a duplicate is detected in the races displayed. backupHorses contains names that are not typically used when generating a race, so this reduces the likelihood of further identical horses.
	private static String[] backupHorses = {""};

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
}
