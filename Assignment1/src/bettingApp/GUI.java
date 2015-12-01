package bettingApp;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;
import javax.swing.JLabel;

import java.io.*;
import java.util.Random;
import java.awt.event.ActionEvent;

import javax.swing.*;

import java.util.ArrayList;

public class GUI implements ActionListener {
	
	ArrayList<Bet> betsMade = new ArrayList<Bet>();
	double balance = 10;

	JFrame frame = new JFrame();
	JTextField enAmount = new JTextField();
	
	JPanel panel = new JPanel(); //Left-most Panel
	JPanel panel_1 = new JPanel(); //Balance Panel
	JPanel panel_2 = new JPanel(); // Centre Panel
	JPanel panel_3 = new JPanel(); //Bottom Panel
	JPanel panel_4 = new JPanel(); //Right-most Panel
	
	JLabel lblBalance = new JLabel("Balance:");
	JLabel label = new JLabel("\u20AC" + balance);
	JLabel lblSelectSport = new JLabel("   Select Sport");
	JLabel lblPleaseEnterThe = new JLabel("Please enter the amount you would like to bet - ");
	
	JButton btnPlaceBet = new JButton("Place Bet");
	JButton btnCheckResults = new JButton("Check Results");
	JButton btnQuit = new JButton("Quit");
	JButton btnHorses = new JButton("Horse Racing");
	JButton btnFootball = new JButton("Football");
	JButton btnBoxing = new JButton("Boxing");
	JButton btnSubmit = new JButton("Submit");
	JButton venue1 = new JButton();
	JButton venue2 = new JButton();
	JButton venue3 = new JButton();
	JToggleButton choice1 = new JToggleButton("");
	JToggleButton choice2 = new JToggleButton("");
	JToggleButton choice3 = new JToggleButton("");
	JToggleButton choice4 = new JToggleButton("");
	JToggleButton choice5 = new JToggleButton("");
	JToggleButton choice6 = new JToggleButton("");
	JToggleButton choice7 = new JToggleButton("");
	JToggleButton choice8 = new JToggleButton("");
	JToggleButton choice9 = new JToggleButton("");
	JToggleButton choice10 = new JToggleButton("");
	
	
	JTextField info1 = new JTextField("Team    Amount");
	JTextField info2 = new JTextField("Amount");
	JTextField bet1 = new JTextField("");
	JTextField bet2 = new JTextField("");
	JTextField bet3 = new JTextField("");
	JTextField bet4 = new JTextField("");
	JTextField bet5 = new JTextField("");
	JTextField bet6 = new JTextField("");
	JTextField bet7 = new JTextField("");
	JTextField bet8 = new JTextField("");
	JTextField bet9 = new JTextField("");
	JTextField bet10 = new JTextField("");
	
	String sportStatus = new String("");
	String choice = new String("");
	String selectedChoice = new String("");
	//String[] tempList = randomFootballMatch();
	
	private static String[] horseTeams = {"Easy Goer", "Frankel", "Kincsem",
		"Man o' War", "Niatross", "Secretariat", "Bernborough", "Crisp",
		"Valegro", "Ajax", "Adios", "Bold Ruler", "Cigar", "Desert Gold", 
		"Eclipse", "Funny Cide", "Gloaming", "Hyperion", "Iroquois", "Kelso", 
		"Might and Power", "Red Rum", "Seabiscuit", "Totilas", "Vain", "War Admiral", 
		"Zenyatta", "Affirmed", "Alydar", "Emperor"};
	private static String[] footTeams = {"Manchester United", "Manchester City",
		"Arsenal", "Chelsea", "Liverpool", "Barcelona", "Real Madrid",
		"A.C. Milan", "Bayern Munich", "Celtic" };
	private static String[] boxers = {"Muhammad Ali", "Mike Tyson",
		"Floyd Mayweather", "Manny Pacquiao", "Joe Louis",
		"Sugar Ray Leonard", "George Foreman", "Sugar Ray Robinson",
		"Joe Frazier", "Marvin Hagler" };


	public GUI() {
		
		/***Basic Settings***/
		
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(16, 11, 139, 439);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		/***End Basic Settings***/
		
		/***Action Listeners***/
		
		btnPlaceBet.addActionListener(this);
		btnCheckResults.addActionListener(this);
		btnQuit.addActionListener(this);
		btnHorses.addActionListener(this);
		btnFootball.addActionListener(this);
		btnBoxing.addActionListener(this);
		btnSubmit.addActionListener(this);
		venue1.addActionListener(this);
		venue2.addActionListener(this);
		venue3.addActionListener(this);
		choice1.addActionListener(this);
		choice2.addActionListener(this);
		choice3.addActionListener(this);
		choice4.addActionListener(this);
		choice5.addActionListener(this);
		choice6.addActionListener(this);
		choice7.addActionListener(this);
		choice8.addActionListener(this);
		choice9.addActionListener(this);
		choice10.addActionListener(this);
		
		/***End Action Listeners***/
		
		/***Main Menu***/
		
		panel.add(btnPlaceBet);
			btnPlaceBet.setBounds(10, 11, 119, 23);
		panel.add(btnCheckResults);
			btnCheckResults.setBounds(10, 45, 119, 23);
		panel.add(btnQuit);
			btnQuit.setBounds(10, 79, 119, 23);
		panel.add(panel_1);
			panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_1.setBounds(10, 340, 119, 88);
			panel_1.setLayout(null);
		panel_1.add(lblBalance);
			lblBalance.setBounds(10, 11, 57, 21);
		panel_1.add(label);
			label.setBounds(38, 43, 46, 14);
		panel.add(btnHorses);
			btnHorses.setBounds(22, 231, 89, 23);
			btnHorses.setVisible(false);
		panel.add(btnFootball);
			btnFootball.setBounds(22, 265, 89, 23);
			btnFootball.setVisible(false);
		panel.add(btnBoxing);
			btnBoxing.setBounds(22, 299, 89, 23);
			btnBoxing.setVisible(false);
		panel.add(lblSelectSport);
			lblSelectSport.setBounds(22, 215, 89, 14);
			lblSelectSport.setVisible(false);
			
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(159, 11, 397, 326);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
			
		panel_2.add(venue1);
			venue1.setVisible(false);
			venue1.setBounds(15, 11, 110, 23);
		panel_2.add(venue2);
			venue2.setVisible(false);
			venue2.setBounds(140, 11, 110, 23);
		panel_2.add(venue3);
			venue3.setVisible(false);
			venue3.setBounds(265, 11, 110, 23);
		panel_2.add(choice1);
			choice1.setVisible(false);
			choice1.setBounds(45, 45, 130, 23);
		panel_2.add(choice2);
			choice2.setVisible(false);
			choice2.setBounds(45, 79, 130, 23);
		panel_2.add(choice3);
			choice3.setVisible(false);
			choice3.setBounds(45, 113, 130, 23);
		panel_2.add(choice4);
			choice4.setVisible(false);
			choice4.setBounds(45, 147, 130, 23);
		panel_2.add(choice5);
			choice5.setVisible(false);
			choice5.setBounds(45, 181, 130, 23);
		panel_2.add(choice6);
			choice6.setVisible(false);
			choice6.setBounds(215, 45, 130, 23);	
		panel_2.add(choice7);
			choice7.setVisible(false);
			choice7.setBounds(215, 79, 130, 23);
		panel_2.add(choice8);
			choice8.setVisible(false);
			choice8.setBounds(215, 113, 130, 23);
		panel_2.add(choice9);
			choice9.setVisible(false);
			choice9.setBounds(215, 147, 130, 23);
		panel_2.add(choice10);
			choice10.setVisible(false);
			choice10.setBounds(215, 181, 130, 23);
			
		
			
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(160, 346, 395, 104);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		panel_3.add(btnSubmit);
			btnSubmit.setBounds(20, 44, 89, 23);
		panel_3.add(lblPleaseEnterThe);
			lblPleaseEnterThe.setBounds(20, 11, 269, 23);
		panel_3.add(enAmount);
			enAmount.setBounds(299, 12, 86, 20);
			enAmount.setColumns(10);
		
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(561, 11, 113, 439);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		panel_4.add(info1);
			info1.setBounds(5, 11, 100, 23);
			info1.setEditable(false);
		panel_4.add(bet1);
			bet1.setBounds(5, 45, 100, 23);
			bet1.setEditable(false);
		panel_4.add(bet2);
			bet2.setBounds(5, 79, 100, 23);
			bet2.setEditable(false);
		panel_4.add(bet3);
			bet3.setBounds(5, 113, 100, 23);
			bet3.setEditable(false);
		panel_4.add(bet4);
			bet4.setBounds(5, 147, 100, 23);
			bet4.setEditable(false);
		panel_4.add(bet5);
			bet5.setBounds(5, 181, 100, 23);
			bet5.setEditable(false);
		panel_4.add(bet6);
			bet6.setBounds(5, 215, 100, 23);
			bet6.setEditable(false);
		panel_4.add(bet7);
			bet7.setBounds(5, 249, 100, 23);
			bet7.setEditable(false);
		panel_4.add(bet8);
			bet8.setBounds(5, 283, 100, 23);
			bet8.setEditable(false);
		panel_4.add(bet9);
			bet9.setBounds(5, 317, 100, 23);
			bet9.setEditable(false);
		panel_4.add(bet10);
			bet10.setBounds(5, 351, 100, 23);
			bet10.setEditable(false);
	}

	
	public void actionPerformed(ActionEvent e) {
		/*
		 * This method handles checking to see if a button has been pressed.
		 * Once it has, calls the switchMenu method and passes a String
		 * detailing what button was pressed.
		 */
		if (e.getSource() == btnPlaceBet) {
			switchMenu("Place Bet");
		} else if (e.getSource() == btnCheckResults) {
			switchMenu("Check Results");
		} else if (e.getSource() == btnQuit) {
			switchMenu("Quit");
		} else if (e.getSource() == btnHorses) {
			switchMenu("Horse Racing");
			venue1.setText("Cheltenham");
			venue2.setText("Tramore");
			venue3.setText("Musselburgh");
			sportStatus = "Horse";
		} else if (e.getSource() == btnFootball) {
			switchMenu("Football");
			venue1.setText("Wembley");
			venue2.setText("Croke Park");
			venue3.setText("San Siro");
			sportStatus = "Football";
		} else if (e.getSource() == btnBoxing) {
			switchMenu("Boxing");
			venue1.setText("MGM Grand");
			venue2.setText("Araneta");
			venue3.setText("Blue Horizon");
			sportStatus = "Boxing";
		} else if (e.getSource() == btnSubmit) {
			switchMenu("Submit");
		} else if (e.getSource() == venue1) {
			if (sportStatus.equals("Horse")) {
				switchMenu("Cheltenham");
			} else if (sportStatus.equals("Football")) {
				switchMenu("Wembley");
			} else {
				switchMenu("MGM Grand");
			}
			resetButtonStatus();
		} else if (e.getSource() == venue2) {
			if (sportStatus.equals("Horse")) {
				switchMenu("Tramore");
			} else if (sportStatus.equals("Football")) {
				switchMenu("Croke Park");
			} else {
				switchMenu("Araneta");
			}
			resetButtonStatus();
		} else if (e.getSource() == venue3) {
			if (sportStatus.equals("Horse")) {
				switchMenu("Musselburgh");
			} else if (sportStatus.equals("Football")) {
				switchMenu("San Siro");
			} else {
				switchMenu("Blue Horizon");
			}
			resetButtonStatus();
		} else if (e.getSource() == choice1) {
			resetButtonStatus();
			choice1.setSelected(true);
			choice = choice1.getText();
		} else if (e.getSource() == choice2) {
			resetButtonStatus();
			choice2.setSelected(true);
			choice = choice2.getText();
		} else if (e.getSource() == choice3) {
			resetButtonStatus();
			choice3.setSelected(true);
			choice = choice3.getText();
		} else if (e.getSource() == choice4) {
			resetButtonStatus();
			choice4.setSelected(true);
			choice = choice4.getText();
		} else if (e.getSource() == choice5) {
			resetButtonStatus();
			choice5.setSelected(true);
			choice = choice5.getText();
		} else if (e.getSource() == choice6) {
			resetButtonStatus();
			choice6.setSelected(true);
			choice = choice6.getText();
		} else if (e.getSource() == choice7) {
			resetButtonStatus();
			choice7.setSelected(true);
			choice = choice7.getText();
		} else if (e.getSource() == choice8) {
			resetButtonStatus();
			choice8.setSelected(true);
			choice = choice8.getText();
		} else if (e.getSource() == choice9) {
			resetButtonStatus();
			choice9.setSelected(true);
			choice = choice9.getText();
		} else if (e.getSource() == choice10) {
			resetButtonStatus();
			choice10.setSelected(true);
			choice = choice10.getText();
		} else if (e.getSource() == btnSubmit) {
			switchMenu("Submit");
		}
		
		//else if (e.getSource() == printReceipt) {
			//switchMenu("Print Receipt");
		//}
	}
	
	public void switchMenu(String menu) {
		if (menu == "Place Bet") {
			btnHorses.setVisible(true);
			btnBoxing.setVisible(true);	
			btnFootball.setVisible(true);
		} else if (menu == "Check Results") {
			if (btnHorses.isVisible() == true) {
				btnHorses.setVisible(false);
				btnBoxing.setVisible(false);
				btnFootball.setVisible(false);
				venue1.setVisible(false);
				venue2.setVisible(false);
				venue3.setVisible(false);
				choice1.setVisible(false);
				choice2.setVisible(false);
				choice3.setVisible(false);
				choice4.setVisible(false);
				choice5.setVisible(false);
				choice6.setVisible(false);
				choice7.setVisible(false);
				choice8.setVisible(false);
				choice9.setVisible(false);
				choice10.setVisible(false);
			}
		} else if (menu == "Horse Racing") {
			if (venue1.isVisible() == false) {
				venue1.setVisible(true);
				venue2.setVisible(true);
				venue3.setVisible(true);
			}
			if (choice1.isVisible() == true) {
				choice1.setVisible(false);
				choice2.setVisible(false);
				choice3.setVisible(false);
				choice4.setVisible(false);
				choice5.setVisible(false);
				choice6.setVisible(false);
				choice7.setVisible(false);
				choice8.setVisible(false);
				choice9.setVisible(false);
				choice10.setVisible(false);
			}
		} else if (menu == "Football") {
			if (venue1.isVisible() == false) {
				venue1.setVisible(true);
				venue2.setVisible(true);
				venue3.setVisible(true);
			}
			if (choice1.isVisible() == true) {
				choice1.setVisible(false);
				choice2.setVisible(false);
				choice3.setVisible(false);
				choice4.setVisible(false);
				choice5.setVisible(false);
				choice6.setVisible(false);
				choice7.setVisible(false);
				choice8.setVisible(false);
				choice9.setVisible(false);
				choice10.setVisible(false);
			}
		} else if (menu == "Boxing") {
			if (venue1.isVisible() == false) {
				venue1.setVisible(true);
				venue2.setVisible(true);
				venue3.setVisible(true);
			}
			if (choice1.isVisible() == true) {
				choice1.setVisible(false);
				choice2.setVisible(false);
				choice3.setVisible(false);
				choice4.setVisible(false);
				choice5.setVisible(false);
				choice6.setVisible(false);
				choice7.setVisible(false);
				choice8.setVisible(false);
				choice9.setVisible(false);
				choice10.setVisible(false);
			}
		} else if (menu == "Cheltenham") {
			choice1.setVisible(true);
			choice1.setText(horseTeams[0]);
			choice2.setVisible(true);
			choice2.setText(horseTeams[1]);
			choice3.setVisible(true);
			choice3.setText(horseTeams[2]);
			choice4.setVisible(true);
			choice4.setText(horseTeams[3]);
			choice5.setVisible(true);
			choice5.setText(horseTeams[4]);
			choice6.setVisible(true);
			choice6.setText(horseTeams[5]);
			choice7.setVisible(true);
			choice7.setText(horseTeams[6]);
			choice8.setVisible(true);
			choice8.setText(horseTeams[7]);
			choice9.setVisible(true);
			choice9.setText(horseTeams[8]);
			choice10.setVisible(true);
			choice10.setText(horseTeams[9]);
		} else if (menu == "Tramore") {
			choice1.setVisible(true);
			choice1.setText(horseTeams[10]);
			choice2.setVisible(true);
			choice2.setText(horseTeams[11]);
			choice3.setVisible(true);
			choice3.setText(horseTeams[12]);
			choice4.setVisible(true);
			choice4.setText(horseTeams[13]);
			choice5.setVisible(true);
			choice5.setText(horseTeams[14]);
			choice6.setVisible(true);
			choice6.setText(horseTeams[15]);
			choice7.setVisible(true);
			choice7.setText(horseTeams[16]);
			choice8.setVisible(true);
			choice8.setText(horseTeams[17]);
			choice9.setVisible(true);
			choice9.setText(horseTeams[18]);
			choice10.setVisible(true);
			choice10.setText(horseTeams[19]);
		} else if (menu == "Musselburgh") {
			choice1.setVisible(true);
			choice1.setText(horseTeams[20]);
			choice2.setVisible(true);
			choice2.setText(horseTeams[21]);
			choice3.setVisible(true);
			choice3.setText(horseTeams[22]);
			choice4.setVisible(true);
			choice4.setText(horseTeams[23]);
			choice5.setVisible(true);
			choice5.setText(horseTeams[24]);
			choice6.setVisible(true);
			choice6.setText(horseTeams[25]);
			choice7.setVisible(true);
			choice7.setText(horseTeams[26]);
			choice8.setVisible(true);
			choice8.setText(horseTeams[27]);
			choice9.setVisible(true);
			choice9.setText(horseTeams[28]);
			choice10.setVisible(true);
			choice10.setText(horseTeams[29]);
		} else if (menu == "Wembley") {
			choice1.setVisible(true);
			choice1.setText(footTeams[0]);
			choice6.setVisible(true);
			choice6.setText(footTeams[1]);
		} else if (menu == "Croke Park") {
			choice1.setVisible(true);
			choice1.setText(footTeams[2]);
			choice6.setVisible(true);
			choice6.setText(footTeams[3]);
		} else if (menu == "San Siro") {
			choice1.setVisible(true);
			choice1.setText(footTeams[4]);
			choice6.setVisible(true);
			choice6.setText(footTeams[5]);
		}
		else if (menu == "MGM Grand") {
			choice1.setVisible(true);
			choice1.setText(boxers[0]);
			choice6.setVisible(true);
			choice6.setText(boxers[1]);
		} else if (menu == "Araneta") {
			choice1.setVisible(true);
			choice1.setText(boxers[2]);
			choice6.setVisible(true);
			choice6.setText(boxers[3]);
		} else if (menu == "Blue Horizon") {
			choice1.setVisible(true);
			choice1.setText(boxers[4]);
			choice6.setVisible(true);
			choice6.setText(boxers[5]);
		} else if (menu == "Submit"){
			try {
				double amount = Double.parseDouble(enAmount.getText());
				if (amount > 0) {
					if (sportStatus == "Horse") {
						HorseBet hb = new HorseBet(amount, choice);
						betsMade.add(hb);
						modifyBalance(amount, 0);
					} else if (sportStatus == "Football") {
						FootballBet fb = new FootballBet(amount, choice);
						betsMade.add(fb);
						modifyBalance(amount, 0);
					} else {
						BoxingBet bb = new BoxingBet(amount, choice);
						betsMade.add(bb);
						modifyBalance(amount, 0);
					}
				}
				for (Bet bet : betsMade) {
					bet1.setText(bet.getType() + " Amount: €" + bet.getAmount() + "\n");
				}
				enAmount.setText("");
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
						"Please enter a number in the amount section");
			}
		}
		
		else if (menu == "Quit") {
			System.exit(0);
		}
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
		GUI gui = new GUI();
		gui.frame.setVisible(true);
		/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		*/
	}
	
	public static String[] randomBoxingMatch() {
		
		String firstB = getFirstBoxer();
		String secondB = getSecondBoxer();
		
		if (firstB.equals(secondB)) {
			secondB = boxers[generateRandom()];
		}
		
		String tempBoxers[] = {firstB, secondB};
		
		return tempBoxers;
		
	}
	
	public static String getFirstBoxer() {
		String fBoxer = boxers[generateRandom()];
		return fBoxer;
	}
	
	public static String getSecondBoxer() {
		String sBoxer = boxers[generateRandom()];
		return sBoxer;
	}
	
	
	/*
	public static String[] randomFootballMatch() {
		
		String firstT = getTeam();
		String secondT = getTeam();
		String thirdT = getTeam();
		String fourthT = getTeam();
		String fifthT = getTeam();
		String sixthT = getTeam();
		
		String tempTeams[] = {firstT, secondT, thirdT, fourthT, fifthT, sixthT};
		
		return tempTeams;
		
	}
	
	*/
	
	public static String getTeam() {
		String[] tempMatch = footTeams;
		String fTeam = tempMatch[generateRandom()];
		return fTeam;
	}

	
	public static int generateRandom() {
		Random rand = new Random();
		
		int i = rand.nextInt((5 - 1) + 1) + 1;
		return i;
	}
	
	public void resetButtonStatus() {
		choice1.setSelected(false);
		choice2.setSelected(false);
		choice3.setSelected(false);
		choice4.setSelected(false);
		choice5.setSelected(false);
		choice6.setSelected(false);
		choice7.setSelected(false);
		choice8.setSelected(false);
		choice9.setSelected(false);
		choice10.setSelected(false);
	}
	
	public void modifyBalance(double a, double b) {
		
		if (a > 0) {
			a = a * -1;
			balance = balance + a;
		}
		else {
			balance = balance + b;
		}
		
		label.setText("\u20AC" + balance);
	}

}
