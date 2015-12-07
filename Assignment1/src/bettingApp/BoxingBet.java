/*
 * Fairly straightforward class. Constructor method is called should the user decide to create a boxing bet. 
 * The Boxer he has bet on, and the amount he bet is passed to the constructor. 
 * These variables are letter accessed when printing out receipts.
 */
package bettingApp;

public class BoxingBet extends Bet {

	private String boxer;
	private String type;
	private static String[] boxers = { "Muhammad Ali", "Mike Tyson",
			"Floyd Mayweather", "Manny Pacquiao", "Joe Louis",
			"Sugar Ray Leonard", "George Foreman", "Sugar Ray Robinson",
			"Joe Frazier", "Marvin Hagler" };


	public BoxingBet(double amount, String boxer) {
		super(amount);
		type = boxer;
	}

	public static String[] getBoxers() {
		return boxers;
	}

	public String getType() {
		return type;
	}
	
	/* See FootballBet class for information.
	public static String[] randomBoxingMatch() {
		getFirst();
		getSecond();
		
		String firstB = getFirst();
		String secondB = getSecond();
		
		if (firstB.equals(secondB)) {
			secondB = boxers[generateRandom()];
		}
		
		String tempBoxers[] = {firstB, secondB};
		
		return tempBoxers;
		
	}
	
	public static String getFirst() {
		String fBoxer = boxers[generateRandom()];
		return fBoxer;
	}
	
	public static String getSecond() {
		String sBoxer = boxers[generateRandom()];
		return sBoxer;
	}
	*/
}