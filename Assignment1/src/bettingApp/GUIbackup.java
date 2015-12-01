package bettingApp;

import java.awt.event.ActionEvent;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

public class GUIbackup implements ActionListener {

	// Basic declarations before we go ahead creating a GUI.

	ArrayList<Bet> betsMade = new ArrayList<Bet>();

	JFrame frame = new JFrame("Place Your Bets!");
	JPanel mainMenuPanel = new JPanel();
	JPanel placeBetPanel = new JPanel();
		JPanel fMatches = new JPanel();
			JPanel fList = new JPanel();
		JPanel bMatches = new JPanel();
			JPanel bList = new JPanel();
		JPanel hRaces = new JPanel();
			JPanel hList = new JPanel();
	JPanel checkResultsPanel = new JPanel();
	JPanel detPanel = new JPanel();

	JButton mainMenuBtn = new JButton("Main Menu.");
	JButton placeBetBtn = new JButton("Place Bet");
	JTextField details = new JTextField();
		JTextField choice1 = new JTextField("Choose your sport");
		//choice1.setHorizontalAlignment(JTextField.CENTER); //Trying to get this to work
		JButton boxBtn = new JButton("Boxing");
			JButton match1 = new JButton("");
			JButton[] fighterList = new JButton[2];
		JButton footBtn = new JButton("Football");
			JButton match2 = new JButton("");
			JButton[] teamList = new JButton[2];
		JButton hrseBtn = new JButton("Horses");
			JButton match3 = new JButton("");
			JComboBox horseList = new JComboBox(HorseBet.randomHorseRace());
			JButton contin = new JButton();
			//JButton[] horseList = new JButton[10];
	//String[] sportTypes = { "Horses", "Football", "Boxing" };
	String[] tempMatch = new String[2];
	String[] tempRace = new String[10];
	//JComboBox sports = new JComboBox(sportTypes);
	JTextField amField = new JTextField("Amount"); //Obsolete
	JTextField enAmount = new JTextField();
	JButton nextBtn = new JButton("Continue");
	JButton submitBtn = new JButton("Submit");
	JButton checkResultsBtn = new JButton("Check your results");
	JTextArea printList = new JTextArea();
	JButton printReceipt = new JButton("Print Receipt");
	JButton mMenu = new JButton("Main Menu");
	JButton exitBtn = new JButton("Quit");
	
	static double startAmount = 10;
	static Bet tempBet = new Bet(startAmount);
	String betStatus = coinFlip();

	public GUIbackup() {

		// ---Basic Settings--- //
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(190, 200);

		// ---Action Listeners--- //
		placeBetBtn.addActionListener(this);
		submitBtn.addActionListener(this);
			boxBtn.addActionListener(this);
				match1.addActionListener(this);
					fighterList[0] = new JButton();
					fighterList[1] = new JButton();
					fighterList[0].addActionListener(this);
					fighterList[1].addActionListener(this);
			footBtn.addActionListener(this);
				match2.addActionListener(this);
					teamList[0] = new JButton();
					teamList[1] = new JButton();
					teamList[0].addActionListener(this);
					teamList[1].addActionListener(this);
			hrseBtn.addActionListener(this);
				match3.addActionListener(this);
					horseList.addActionListener(this);
					
		checkResultsBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		nextBtn.addActionListener(this);
		printReceipt.addActionListener(this);
		mMenu.addActionListener(this);

		// ---Main Menu--- //
		mainMenuPanel.setLayout(null);

		mainMenuPanel.add(placeBetBtn);
		mainMenuPanel.add(checkResultsBtn);
		mainMenuPanel.add(exitBtn);

		placeBetBtn.setBounds(10, 10, 150, 20);
		checkResultsBtn.setBounds(10, 35, 150, 20);
		exitBtn.setBounds(10, 60, 150, 20);	

		frame.add(mainMenuPanel);
		frame.setVisible(true);
		// ---End Main Menu--- //

		// ---Initial Sport/Match Choice Menu--- //
		placeBetPanel.setLayout(null);
		placeBetPanel.add(choice1);
		placeBetPanel.add(boxBtn);
		placeBetPanel.add(footBtn);
		placeBetPanel.add(hrseBtn);
		placeBetPanel.add(nextBtn);

		choice1.setEditable(false);

		choice1.setBounds(10, 10, 150, 20);
		boxBtn.setBounds(10, 35, 150, 20);
		footBtn.setBounds(10, 60, 150, 20);
		hrseBtn.setBounds(10, 85, 150, 20);
		nextBtn.setBounds(180, 135, 150, 20);
		// ---End Initial Sport/Match Menu--- //
		
		
		// ---Elaborate Match Menu--- //
		bMatches.setLayout(null);
		bMatches.add(match1);
		match1.setBounds(10, 10, 150, 20);
			bList.setLayout(null);
			bList.add(fighterList[0]);
				fighterList[0].setBounds(10, 10, 150, 20);
			bList.add(fighterList[1]);
				fighterList[1].setBounds(10, 35, 150, 20);
		
		fMatches.setLayout(null);
		fMatches.add(match2);
		match2.setBounds(10, 10, 150, 20);
			fList.setLayout(null);
			fList.add(teamList[0]);
				teamList[0].setBounds(10, 10, 150, 20);
			fList.add(teamList[1]);
				teamList[1].setBounds(10, 35, 150, 20);
		
		hRaces.setLayout(null);
		hRaces.add(match3);
		match3.setBounds(10, 10, 150, 20);
			hList.setLayout(null);
			hList.add(horseList);
				horseList.setBounds(10, 10, 150, 20);
				horseList.setSize(10, horseList.getPreferredSize().height);
				
		detPanel.setLayout(null);
		detPanel.add(details);
			details.setBounds(10, 10, 150, 20);
		detPanel.add(amField);
			amField.setBounds(10, 35, 150, 20);
		detPanel.add(enAmount);
			enAmount.setBounds(10, 60, 150, 20);
		detPanel.add(submitBtn);
			submitBtn.setBounds(10, 85, 150, 20);
				
		// ---End Elaborate Match Menu ---//
		// ---Check Results Menu--- //
		checkResultsPanel.setLayout(null);
		checkResultsPanel.add(printList);
		printList.setEditable(false);
		checkResultsPanel.add(printReceipt);
		checkResultsPanel.add(mMenu);

		printList.setBounds(10, 10, 150, 20);
		printReceipt.setBounds(10, 35, 150, 20);
		mMenu.setBounds(10, 60, 150, 20);
		// ---End Check Results Menu--- //

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
		} else if (e.getSource() == nextBtn) {
			switchMenu("Next");
		} else if (e.getSource() == boxBtn) {
			switchMenu("BoxingMatches");
		} else if (e.getSource() == footBtn) {
			switchMenu("FootMatches");
		} else if (e.getSource() == hrseBtn) {
			switchMenu("HorseMatches");
		} else if (e.getSource() == match3) {
			switchMenu("Cheltenham");
		} else if (e.getSource() == match2) {
			switchMenu("CrokePark");
		} else if (e.getSource() == match1) {
			switchMenu("NationalStadium");
		} else if (e.getSource() == fighterList[0]) {
			switchMenu("Boxer1");
		} else if (e.getSource() == fighterList[1]) {
			switchMenu("Boxer2");
		} else if (e.getSource() == teamList[0]) {
			switchMenu("Football1");
		} else if (e.getSource() == teamList[1]) {
			switchMenu("Football2");
		} else if (e.getSource() == horseList) {
			switchMenu("horseChoice");
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
			frame.setSize(190, 200);
			mainMenuPanel.setVisible(false);
			frame.add(placeBetPanel);
			placeBetPanel.setVisible(true);
			enAmount.setText("");
		} else if (menu == "BoxingMatches") {
			frame.setSize(190, 200);
			placeBetPanel.setVisible(false);
			frame.add(bMatches);
			bMatches.setVisible(true);
			match1.setText("National Stadium");
		} else if (menu == "FootMatches") {
			frame.setSize(190, 200);
			placeBetPanel.setVisible(false);
			frame.add(fMatches);
			fMatches.setVisible(true);
			match2.setText("Croke Park");
		} else if (menu == "HorseMatches") {
			frame.setSize(190, 200);
			placeBetPanel.setVisible(false);
			frame.add(hRaces);
			hRaces.setVisible(true);
			match3.setText("Cheltenham");
		} else if (menu == "Cheltenham") {
			match1.setText("");
			frame.setSize(190, 200);
			hRaces.setVisible(false);
			frame.add(hList);
			tempRace = HorseBet.getHorses();
			frame.add(horseList);
		} else if (menu == "CrokePark") {
			match1.setText("");
			frame.setSize(190, 200);
			tempMatch = FootballBet.randomFootballMatch();
			teamList[0].setText(tempMatch[0]);
			teamList[1].setText(tempMatch[1]);
			fMatches.setVisible(false);
			frame.add(fList);
		} else if (menu == "NationalStadium") {
			match1.setText("");
			frame.setSize(190, 200);
			tempMatch = BoxingBet.randomBoxingMatch();
			fighterList[0].setText(tempMatch[0]);
			fighterList[1].setText(tempMatch[1]);
			bMatches.setVisible(false);
			frame.add(bList);
		} else if (menu == "Boxer1") {
			frame.setSize(190, 200);
			details.setText(tempMatch[0]);
			details.setEditable(false);
			amField.setEditable(false);
			bList.setVisible(false);
			frame.add(detPanel);
		} else if (menu == "Boxer2") {
			frame.setSize(190, 200);
			details.setText(tempMatch[1]);
			details.setEditable(false);
			amField.setEditable(false);
			bList.setVisible(false);
			frame.add(detPanel);
		} else if (menu == "Football1") {
			frame.setSize(190, 200);
			details.setText(tempMatch[0]);
			details.setEditable(false);
			amField.setEditable(false);
			fList.setVisible(false);
			frame.add(detPanel);
		} else if (menu == "Football2") {
			frame.setSize(190, 200);
			details.setText(tempMatch[1]);
			details.setEditable(false);
			amField.setEditable(false);
			fList.setVisible(false);
			frame.add(detPanel);
		} else if (menu == "horseChoice") {
			frame.setSize(190, 200);
			details.setText(tempMatch[0]);
			details.setEditable(false);
			amField.setEditable(false);
			hList.setVisible(false);
			frame.add(detPanel);
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
			
		/*}  else if (menu == "Submit") {
			
			 * I found using a try/catch here was a good idea seeing as we're
			 * looking to see if the textField contains numbers. Since you can't
			 * parse alphabet characters, the program will throw an exception if
			 * there is anything but a number in there.
			 
			try {
				frame.remove(placeBetPanel);
				mainMenuPanel.setVisible(true);
				frame.setSize(190,200);
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
			*/
		} else if (menu == "Submit") {
			try {
				frame.remove(detPanel);
				mainMenuPanel.setVisible(true);
				frame.setSize(190, 200);
				try {
					amount = Double.parseDouble(enAmount.getText());
					double tAmount = tempBet.getAmount();
						if (tAmount < amount) {
							JOptionPane.showMessageDialog(null, "The amount entered is greater than the amount stored on your account. Please enter more money into your account, or bet less money.");
						}
						else {
							amount = amount * -1;
							tempBet.setAmount(amount);
						}
				} catch (Exception e) {
					
				}
				
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter a number in the amount section");
			}
		}
		else if (menu == "Main Menu") {
			frame.remove(checkResultsPanel);
			mainMenuPanel.setVisible(true);
		} else if (menu == "Print Receipt") {
			createReceipt();
		} else if (menu == "Quit") {
			System.exit(0);
		}
	}
	
	/* Old Code used to switch combo box values depending on whether user selected Football/Horse/Boxing in above Combo box

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
	
	*/

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
	
	public static String coinFlip() {
		Random rand = new Random();
		int i = rand.nextInt(2);
		String results = "";
		if (i == 0) {
			results = "You have won!";
			
		}
		else {
			results = "You have lost!";
			
		}
		return results;
	}

	public static void main(String[] args) {
		GUIbackup gui = new GUIbackup();
	}

}