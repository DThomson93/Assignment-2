package bettingApp;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;

public class GUI implements ActionListener {

	// Basic declarations before we go ahead creating a GUI.

	ArrayList<Bet> betsMade = new ArrayList<Bet>();

	JFrame frame = new JFrame("Place Your Bets!");
	JPanel mainMenuPanel = new JPanel();
	JPanel placeBetPanel = new JPanel();
	JPanel checkResultsPanel = new JPanel();
	JPanel horsePanel = new JPanel();

	JButton mainMenuBtn = new JButton("Main Menu.");
	JButton placeBetBtn = new JButton("Place Bet");
	JTextField choice1 = new JTextField("Choose your sport");
	String[] sportTypes = { "Horses", "Football", "Boxing" };
	JComboBox sports = new JComboBox(sportTypes);
	JTextField amField = new JTextField("Amount");
	JTextField enAmount = new JTextField();
	JComboBox betChoices = new JComboBox(HorseBet.getHorses());
	JButton submitBtn = new JButton("Submit");
	JButton checkResultsBtn = new JButton("Check your results");
	JTextArea printList = new JTextArea();
	JButton printReceipt = new JButton("Print Receipt");
	JButton mMenu = new JButton("Main Menu");
	JButton exitBtn = new JButton("Quit");

	public GUI() {

		// ---Basic Settings---//
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(190, 200);

		// ---Action Listeners---//
		placeBetBtn.addActionListener(this);
		checkResultsBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		sports.addActionListener(this);
		submitBtn.addActionListener(this);
		printReceipt.addActionListener(this);
		mMenu.addActionListener(this);

		// ---Main Menu---//
		mainMenuPanel.setLayout(null);

		mainMenuPanel.add(placeBetBtn);
		mainMenuPanel.add(checkResultsBtn);
		mainMenuPanel.add(exitBtn);

		placeBetBtn.setBounds(10, 10, 150, 20);
		checkResultsBtn.setBounds(10, 35, 150, 20);
		exitBtn.setBounds(10, 60, 150, 20);

		frame.add(mainMenuPanel);
		frame.setVisible(true);
		// ---End Main Menu---//

		// ---Place Bet Menu---//
		placeBetPanel.setLayout(null);
		placeBetPanel.add(choice1);
		placeBetPanel.add(sports);
		placeBetPanel.add(amField);
		placeBetPanel.add(enAmount);
		placeBetPanel.add(betChoices);
		placeBetPanel.add(submitBtn);

		choice1.setEditable(false);
		amField.setEditable(false);

		choice1.setBounds(10, 10, 150, 20);
		sports.setBounds(10, 35, 150, 20);
		amField.setBounds(10, 60, 150, 20);
		enAmount.setBounds(10, 85, 150, 20);
		betChoices.setBounds(10, 110, 150, 20);
		submitBtn.setBounds(10, 135, 150, 20);
		// ---End Place Bet Menu---//

		// ---Check Results Menu---//
		checkResultsPanel.setLayout(null);
		checkResultsPanel.add(printList);
		printList.setEditable(false);
		checkResultsPanel.add(printReceipt);
		checkResultsPanel.add(mMenu);

		printList.setBounds(10, 10, 150, 20);
		printReceipt.setBounds(10, 35, 150, 20);
		mMenu.setBounds(10, 60, 150, 20);
		// ---End Check Results Menu---//

	}

	public void actionPerformed(ActionEvent e) {
		/*
		 * This method handles checking to see if a button has been pressed.
		 * Once it has, calls the switchMenu method and passes a String
		 * detailing what button was pressed.
		 */
		if (e.getSource() == placeBetBtn) {
			switchMenu("Place Bet");
		} else if (e.getSource() == checkResultsBtn) {
			switchMenu("Check Results");
		} else if (e.getSource() == exitBtn) {
			switchMenu("Quit");
		} else if (e.getSource() == sports) {
			changeBetChoices((String) sports.getSelectedItem());
		} else if (e.getSource() == submitBtn) {
			switchMenu("Submit");
		} else if (e.getSource() == mMenu) {
			switchMenu("Main Menu");
		} else if (e.getSource() == printReceipt) {
			switchMenu("Print Receipt");
		} else if (e.getSource() == exitBtn) {
			switchMenu("Quit");
		}
	}

	public void switchMenu(String menu) {
		/*
		 * This method is called from the actionPerformed method. It is passed a
		 * String detailing what button was pressed. Depending on what button
		 * was pressed, and what String passed. Different things occur.
		 */
		double amount = 0;
		if (menu == "Place Bet") {
			mainMenuPanel.setVisible(false);
			frame.add(placeBetPanel);
			placeBetPanel.setVisible(true);
			enAmount.setText("");
		} else if (menu == "Check Results") {
			mainMenuPanel.setVisible(false);
			frame.add(checkResultsPanel);
			checkResultsPanel.setVisible(true);
			if (betsMade.isEmpty() == true) {
				printList.setText("No bets made yet");
			} else {
				for (Bet bet : betsMade) {
					printList.setText("Bets made: " + betsMade.size());
				}
			}
		} else if (menu == "Submit") {
			/*
			 * I found using a try/catch here was a good idea seeing as we're
			 * looking to see if the textField contains numbers. Since you can't
			 * parse alphabet characters, the program will throw an exception if
			 * there is anything but a number in there.
			 */
			try {
				frame.remove(placeBetPanel);
				mainMenuPanel.setVisible(true);
				String check = (String) sports.getSelectedItem();
				//Original placement --- int amount = 0;
				amount = Double.parseDouble(enAmount.getText());
				if (amount > 0) {
					if (check.equals("Horses")) {
						String horse = (String) betChoices.getSelectedItem();
						HorseBet hb = new HorseBet(amount, horse);
						betsMade.add(hb);
						//JOptionPane.showMessageDialog(null,
								//"Bet placed!");
					} else if (check.equals("Boxing")) {
						String boxer = (String) betChoices.getSelectedItem();
						BoxingBet bb = new BoxingBet(amount, boxer);
						betsMade.add(bb);
						//JOptionPane.showMessageDialog(null,
								//"Bet placed!");
					} else {
						String team = (String) betChoices.getSelectedItem();
						FootballBet fb = new FootballBet(amount, team);
						betsMade.add(fb);
						//JOptionPane.showMessageDialog(null,
								//"Bet placed!");
					}
				} else {
					enAmount.setText("");
					JOptionPane.showMessageDialog(null,
							"Please enter a number value greater than 0");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
						"Please enter a number in the amount section");
			}
		} else if (menu == "Main Menu") {
			frame.remove(checkResultsPanel);
			mainMenuPanel.setVisible(true);
		} else if (menu == "Print Receipt") {
			createReceipt();
		} else if (menu == "Quit") {
			System.exit(0);
		}
	}

	public void changeBetChoices(String betType) {
		betChoices.removeAllItems();
		if (betType.equals("Horses")) {
			for (String str : HorseBet.getHorses()) {
				betChoices.addItem(str);
			}
		} else if (betType.equals("Boxing")) {
			for (String str : BoxingBet.getBoxers()) {
				betChoices.addItem(str);
			}
		} else {
			for (String str : FootballBet.getTeams()) {
				betChoices.addItem(str);
			}
		}
	}

	//public void displayDetails() {

	//}

	public void createReceipt() {
		String fileName = "receipts.txt";

		PrintWriter outputstream = null;
		try {
			outputstream = new PrintWriter(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("File " + fileName + " not found.");
			System.exit(0);
		}

		for (Bet bet : betsMade) {
			outputstream.println("You bet on: " + bet.getType()
					+ "\n Amount: €" + bet.getAmount() + "\n");
		}

		outputstream.close();
		System.out.println("Receipt printed!");
	}

	public static void main(String[] args) {
		GUI gui = new GUI();
	}

}