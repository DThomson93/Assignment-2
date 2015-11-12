//This class is never directly called by anything. And only serves to act as a blueprint for Horse/Football/Boxing bet classes.

package bettingApp;

public class Bet {

	private double amount;
	private String type;

	public Bet(double amount) {
		setAmount(amount);
		amount = getAmount();
	}

	public void setAmount(double a) {
		//if (a > 0) {
			amount = a;
		//} else {
			//amount = -1;
		//}
	}

	public double getAmount() {
		return amount;
	}

	public String getType() {
		return type;
	}
}