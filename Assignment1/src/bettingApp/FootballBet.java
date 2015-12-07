/*
 * Straight forward class. Constructor method is called if the user decides to create a FootballBet. 
 * Passes the Team he has bet on and the amount to the constructor. 
 * Later these variables are accessed to be printed onto the receipt.
 */
package bettingApp;

public class FootballBet extends Bet {

	private String team;
	private String type;
	private static String[] teams = { "Manchester United", "Manchester City",
			"Arsenal", "Chelsea", "Liverpool", "Barcelona", "Real Madrid",
			"A.C. Milan", "Bayern Munich", "Celtic" };

	/*
	 * Original idea for the teams array was to show the user a list of matches
	 * being played at the current time (this would be chosen randomly). Player
	 * could choose a match, then variables would randomly choose two teams from
	 * the array. Two variables would be created: a and b. They would be
	 * assigned generateRandom() value and then two Strings would be created for
	 * the teams. For example: String team1 = teams[a];. This would be done in
	 * similar ways with Boxing and Horse Racing.
	 */
	public FootballBet(double amount, String team) {
		super(amount);
		type = team;
	}

	public static String[] getTeams() {
		return teams;
	}

	public String getType() {
		return type;
	}
	
	/* Redundant code that was planning to be used for generating random football/boxing matches in each venue. 
	 * The idea was that you would pick two teams at random from the String array, check them against each other, and if they weren't the same, assign them to firstTeam and secondTeam.
	 * Ultimately I decided that while this idea fit the scope of the project, it would have taken away my time from more important aspects of the program such as basic functionality and achieving the goals of the design brief.
	 * As a result, the idea was scrapped.
	public static String[] randomFootballMatch() {
		getFirst();
		getSecond();
		
		String firstT = getFirst();
		String secondT = getSecond();
		
		if (firstT.equals(secondT)) {
			secondT = teams[generateRandom()];
		}
		
		String tempBoxers[] = {firstT, secondT};
		
		return tempBoxers;
		
	}
	
	public static String getFirst() {
		String[] tempMatch = teams;
		String fTeam = tempMatch[generateRandom()];
		return fTeam;
	}
	
	public static String getSecond() {
		String[] tempMatch = teams;
		String sTeam = tempMatch[generateRandom()];
		return sTeam;
	}
	*/
}
