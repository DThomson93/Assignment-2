//This class is never directly called by anything. And only serves to act as a blueprint for Horse/Football/Boxing bet classes.
package bettingApp;

import java.util.Random;

public class Bet {

	private double amount = 0;
	private String type;

	public Bet(double amount) {
		setAmount(amount);
		amount = getAmount();
	}

	public void setAmount(double a) {
		amount = amount + a;
	}

	public double getAmount() {
		return amount;
	}

	public String getType() {
		return type;
	}
	
	public static int generateRandom() {
		Random rand = new Random();
		
		int i = rand.nextInt((5 - 1) + 1) + 1;
		return i;
	}
}