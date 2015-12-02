package bettingApp;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JLabel;

import java.io.*;
import java.math.BigDecimal;
import java.util.Random;
import java.awt.event.ActionEvent;

import javax.swing.*;

import java.util.ArrayList;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUI implements ActionListener {
	
	ArrayList<Bet> betsMade = new ArrayList<Bet>();
	DecimalFormat dec = new DecimalFormat("#.##");
	double balance = 10.00;
	//double balance = (double)Math.round(10.00*100) / (double)100;
	boolean hbChecker = false;
	boolean fbChecker = false;
	boolean bbChecker = false;
	
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	JFrame frame = new JFrame();
	JTextField enAmount = new JTextField();
	
	JPanel panel = new JPanel(); //Left-most Panel
	JPanel panel_1 = new JPanel(); //Balance Panel
	JPanel panel_2 = new JPanel(); // Centre Panel
	JPanel panel_3 = new JPanel(); //Bottom Panel
	JPanel panel_4 = new JPanel(); //Right-most Panel
	
	JLabel lblBalance = new JLabel("Balance:");
	JLabel label = new JLabel("\u20AC" + dec.format(balance));
	JLabel lblSelectSport = new JLabel("   Select Sport");
	JLabel lblPleaseEnterThe = new JLabel("Please enter the amount you would like to bet - ");
	
	JButton btnPlaceBet = new JButton("Place Bet");
	JButton btnCheckResults = new JButton("Check Results");
	JButton btnQuit = new JButton("Quit");
	JButton btnHorses = new JButton("Horse Racing");
	JButton btnFootball = new JButton("Football");
	JButton btnBoxing = new JButton("Boxing");
	JButton addBalance = new JButton("Add to Balance");
	JTextField balAdd = new JTextField("");
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
	
	
	JTextField info1 = new JTextField("  Click for Details");
	JTextField info2 = new JTextField("Amount");
	JToggleButton bet1 = new JToggleButton("");
	JToggleButton bet2 = new JToggleButton("");
	JToggleButton bet3 = new JToggleButton("");
	JToggleButton bet4 = new JToggleButton("");
	JToggleButton bet5 = new JToggleButton("");
	JToggleButton bet6 = new JToggleButton("");
	JToggleButton bet7 = new JToggleButton("");
	JToggleButton bet8 = new JToggleButton("");
	JToggleButton bet9 = new JToggleButton("");
	JToggleButton bet10 = new JToggleButton("");
	
	JTextField fBet = new JTextField("");
	JTextField oneStat = new JTextField("?");
	JTextField sBet = new JTextField("");
	JTextField twoStat = new JTextField("?");
	JTextField tBet = new JTextField("");
	JTextField threeStat = new JTextField("?");
	JTextField foBet = new JTextField("");
	JTextField fourStat = new JTextField("?");
	JTextField fiBet = new JTextField("");
	JTextField fiveStat = new JTextField("?");
	JTextField siBet = new JTextField("");
	JTextField sixStat = new JTextField("?");
	JTextField seBet = new JTextField("");
	JTextField sevStat = new JTextField("?");
	JTextField eBet = new JTextField("");
	JTextField eightStat = new JTextField("?");
	JTextField nBet = new JTextField("");
	JTextField nineStat = new JTextField("?");
	JTextField teBet = new JTextField("");
	JTextField tenStat = new JTextField("?");
	
	JButton printReceipt = new JButton("Print Receipt");
	JButton search = new JButton("Search");
	JTextField searchBar = new JTextField("");
	JButton loadBets = new JButton();
	
	String sportStatus = new String("");
	String choice = new String("");
	String selectedChoice = new String("");
	Object[] options = {"Remove Bet", "Close"};
	int counter = -1;
	
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
		
		btnSubmit.addActionListener(this);
		printReceipt.addActionListener(this);
		search.addActionListener(this);
		addBalance.addActionListener(this);
		loadBets.addActionListener(this);
		
		bet1.addActionListener(this);
		bet2.addActionListener(this);
		bet3.addActionListener(this);
		bet4.addActionListener(this);
		bet5.addActionListener(this);
		bet6.addActionListener(this);
		bet7.addActionListener(this);
		bet8.addActionListener(this);
		bet9.addActionListener(this);
		bet10.addActionListener(this);
		
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
			btnHorses.setBounds(15, 231, 110, 23);
			btnHorses.setVisible(false);
		panel.add(btnFootball);
			btnFootball.setBounds(15, 265, 110, 23);
			btnFootball.setVisible(false);
		panel.add(btnBoxing);
			btnBoxing.setBounds(15, 299, 110, 23);
			btnBoxing.setVisible(false);
		panel.add(lblSelectSport);
			lblSelectSport.setBounds(25, 215, 89, 14);
			lblSelectSport.setVisible(false);
		panel.add(balAdd);
			balAdd.setBounds(25, 140, 89, 23);
			balAdd.setVisible(true);
		panel.add(addBalance);
			addBalance.setBounds(10, 170, 120, 23);
			addBalance.setVisible(true);
			
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
			
		panel_2.add(fBet);
			fBet.setEditable(false);
			fBet.setVisible(false);
			fBet.setBounds(15, 10, 300, 23);
		panel_2.add(oneStat);
			oneStat.setEditable(false);
			oneStat.setVisible(false);
			oneStat.setBounds(330, 10, 50, 23);
		panel_2.add(sBet);
			sBet.setEditable(false);
			sBet.setVisible(false);
			sBet.setBounds(15, 40, 300, 23);
		panel_2.add(twoStat);
			twoStat.setEditable(false);
			twoStat.setVisible(false);
			twoStat.setBounds(330, 40, 50, 23);
		panel_2.add(tBet);
			tBet.setEditable(false);
			tBet.setVisible(false);
			tBet.setBounds(15, 70, 300, 23);
		panel_2.add(threeStat);
			threeStat.setEditable(false);
			threeStat.setVisible(false);
			threeStat.setBounds(330, 70, 50, 23);
		panel_2.add(foBet);
			foBet.setEditable(false);
			foBet.setVisible(false);
			foBet.setBounds(15, 100, 300, 23);
		panel_2.add(fourStat);
			fourStat.setEditable(false);
			fourStat.setVisible(false);
			fourStat.setBounds(330, 100, 50, 23);
		panel_2.add(fiBet);
			fiBet.setEditable(false);
			fiBet.setVisible(false);
			fiBet.setBounds(15, 130, 300, 23);
		panel_2.add(fiveStat);
			fiveStat.setEditable(false);
			fiveStat.setVisible(false);
			fiveStat.setBounds(330, 130, 50, 23);
		panel_2.add(siBet);
			siBet.setEditable(false);
			siBet.setVisible(false);
			siBet.setBounds(15, 160, 300, 23);
		panel_2.add(sixStat);
			sixStat.setEditable(false);
			sixStat.setVisible(false);
			sixStat.setBounds(330, 160, 50, 23);
		panel_2.add(seBet);
			seBet.setEditable(false);
			seBet.setVisible(false);
			seBet.setBounds(15, 190, 300, 23);
		panel_2.add(sevStat);
			sevStat.setEditable(false);
			sevStat.setVisible(false);
			sevStat.setBounds(330, 190, 50, 23);
		panel_2.add(eBet);
			eBet.setEditable(false);
			eBet.setVisible(false);
			eBet.setBounds(15, 220, 300, 23);
		panel_2.add(eightStat);
			eightStat.setEditable(false);
			eightStat.setVisible(false);
			eightStat.setBounds(330, 220, 50, 23);
		panel_2.add(nBet);
			nBet.setEditable(false);
			nBet.setVisible(false);
			nBet.setBounds(15, 250, 300, 23);
		panel_2.add(nineStat);
			nineStat.setEditable(false);
			nineStat.setVisible(false);
			nineStat.setBounds(330, 250, 50, 23);
		panel_2.add(teBet);
			teBet.setEditable(false);
			teBet.setVisible(false);
			teBet.setBounds(15, 280, 300, 23);
		panel_2.add(tenStat);
			tenStat.setEditable(false);
			tenStat.setVisible(false);
			tenStat.setBounds(330, 280, 50, 23);
			
		
			
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(160, 346, 395, 104);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		panel_3.add(btnSubmit);
			btnSubmit.setBounds(20, 44, 89, 23);
			btnSubmit.setVisible(false);
		panel_3.add(lblPleaseEnterThe);
			lblPleaseEnterThe.setBounds(20, 11, 269, 23);
			lblPleaseEnterThe.setVisible(false);
		panel_3.add(enAmount);
			enAmount.setBounds(299, 12, 86, 20);
			enAmount.setColumns(10);
			enAmount.setVisible(false);
		panel_3.add(printReceipt);
			printReceipt.setBounds(140, 10, 120, 23);
			printReceipt.setVisible(false);
		panel_3.add(search);
			search.setBounds(140, 40, 120, 23);
			search.setVisible(false);
		panel_3.add(searchBar);
			searchBar.setBounds(140, 70, 120, 23);
			searchBar.setVisible(false);
		panel_3.add(loadBets);
		
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(561, 11, 113, 439);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		panel_4.add(info1);
			info1.setBounds(5, 11, 100, 23);
			info1.setEditable(false);
			info1.setVisible(false);
		panel_4.add(bet1);
			bet1.setBounds(5, 45, 100, 23);
			bet1.setVisible(false);
		panel_4.add(bet2);
			bet2.setBounds(5, 79, 100, 23);
			bet2.setVisible(false);
		panel_4.add(bet3);
			bet3.setBounds(5, 113, 100, 23);
			bet3.setVisible(false);
		panel_4.add(bet4);
			bet4.setBounds(5, 147, 100, 23);
			bet4.setVisible(false);
		panel_4.add(bet5);
			bet5.setBounds(5, 181, 100, 23);
			bet5.setVisible(false);
		panel_4.add(bet6);
			bet6.setBounds(5, 215, 100, 23);
			bet6.setVisible(false);
		panel_4.add(bet7);
			bet7.setBounds(5, 249, 100, 23);
			bet7.setVisible(false);
		panel_4.add(bet8);
			bet8.setBounds(5, 283, 100, 23);
			bet8.setVisible(false);
		panel_4.add(bet9);
			bet9.setBounds(5, 317, 100, 23);
			bet9.setVisible(false);
		panel_4.add(bet10);
			bet10.setBounds(5, 351, 100, 23);
			bet10.setVisible(false);
	}

	
	public void actionPerformed(ActionEvent e) {
		/*
		 * This method handles checking to see if a button has been pressed.
		 * Once it has, calls the switchMenu method and passes a String
		 * detailing what button was pressed.
		 */
		if (e.getSource() == btnPlaceBet) {
			switchMenu("Place Bet");
			info1.setVisible(true);
			bet1.setVisible(true);
			bet2.setVisible(true);
			bet3.setVisible(true);
			bet4.setVisible(true);
			bet5.setVisible(true);
			bet6.setVisible(true);
			bet7.setVisible(true);
			bet8.setVisible(true);
			bet9.setVisible(true);
			bet10.setVisible(true);
			lblSelectSport.setVisible(true);
		} else if (e.getSource() == btnCheckResults) {
			switchMenu("Check Results");
		} else if (e.getSource() == btnQuit) {
			switchMenu("Quit");
		} else if (e.getSource() == addBalance) {
			switchMenu("Add to Balance");
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
			btnSubmit.setVisible(true);
		} else if (e.getSource() == choice2) {
			resetButtonStatus();
			choice2.setSelected(true);
			choice = choice2.getText();
			btnSubmit.setVisible(true);
		} else if (e.getSource() == choice3) {
			resetButtonStatus();
			choice3.setSelected(true);
			choice = choice3.getText();
			btnSubmit.setVisible(true);
		} else if (e.getSource() == choice4) {
			resetButtonStatus();
			choice4.setSelected(true);
			choice = choice4.getText();
			btnSubmit.setVisible(true);
		} else if (e.getSource() == choice5) {
			resetButtonStatus();
			choice5.setSelected(true);
			choice = choice5.getText();
			btnSubmit.setVisible(true);
		} else if (e.getSource() == choice6) {
			resetButtonStatus();
			choice6.setSelected(true);
			choice = choice6.getText();
			btnSubmit.setVisible(true);
		} else if (e.getSource() == choice7) {
			resetButtonStatus();
			choice7.setSelected(true);
			choice = choice7.getText();
			btnSubmit.setVisible(true);
		} else if (e.getSource() == choice8) {
			resetButtonStatus();
			choice8.setSelected(true);
			choice = choice8.getText();
			btnSubmit.setVisible(true);
		} else if (e.getSource() == choice9) {
			resetButtonStatus();
			choice9.setSelected(true);
			choice = choice9.getText();
			btnSubmit.setVisible(true);
		} else if (e.getSource() == choice10) {
			resetButtonStatus();
			choice10.setSelected(true);
			choice = choice10.getText();
			btnSubmit.setVisible(true);
		} else if (e.getSource() == bet1) {
			if (betsMade.isEmpty()) {
			
			} else {
				int n = JOptionPane.showOptionDialog(frame, bet1.getText(), "Edit Bet", 
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				
				if (n == 0) {
					for(int i = 0; i < betsMade.size(); i++) {
						Bet tempBet = betsMade.get(i);
						if(bet1.getText().contains(tempBet.getType())) {
							betsMade.remove(i);
							System.out.print(betsMade.size());
						}
					}
					bet1.setText("");
				} 
			}
			bet1.setSelected(false);
		} else if (e.getSource() == bet2) {
			if (betsMade.isEmpty()) {
			
			} else {
				int n = JOptionPane.showOptionDialog(frame, bet2.getText(), "Edit Bet", 
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				
				if (n == 0) {
					for(int i = 0; i < betsMade.size(); i++) {
						Bet tempBet = betsMade.get(i);
						if(bet2.getText().contains(tempBet.getType())) {
							betsMade.remove(i);
							System.out.print(betsMade.size());
						}
					}
					bet2.setText("");
				} 
			}
			bet2.setSelected(false);
		} else if (e.getSource() == bet3) {
			if (betsMade.isEmpty()) {
			
			} else {
				int n = JOptionPane.showOptionDialog(frame, bet3.getText(), "Edit Bet", 
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				
				if (n == 0) {
					for(int i = 0; i < betsMade.size(); i++) {
						Bet tempBet = betsMade.get(i);
						if(bet3.getText().contains(tempBet.getType())) {
							betsMade.remove(i);
							System.out.print(betsMade.size());
						}
					}
					bet3.setText("");
				} 
			}
			bet3.setSelected(false);
		} else if (e.getSource() == bet4) {
			if (betsMade.isEmpty()) {
			
			} else {
				int n = JOptionPane.showOptionDialog(frame, bet4.getText(), "Edit Bet", 
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				
				if (n == 0) {
					for(int i = 0; i < betsMade.size(); i++) {
						Bet tempBet = betsMade.get(i);
						if(bet4.getText().contains(tempBet.getType())) {
							betsMade.remove(i);
							System.out.print(betsMade.size());
						}
					}
					bet4.setText("");
				} 
			}
			bet4.setSelected(false);
		} else if (e.getSource() == bet5) {
			if (betsMade.isEmpty()) {
			
			} else {
				int n = JOptionPane.showOptionDialog(frame, bet5.getText(), "Edit Bet", 
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				
				if (n == 0) {
					for(int i = 0; i < betsMade.size(); i++) {
						Bet tempBet = betsMade.get(i);
						if(bet5.getText().contains(tempBet.getType())) {
							betsMade.remove(i);
							System.out.print(betsMade.size());
						}
					}
					bet5.setText("");
				}  
			}
			bet5.setSelected(false);
		} else if (e.getSource() == bet6) {
			if (betsMade.isEmpty()) {
			
			} else {
				int n = JOptionPane.showOptionDialog(frame, bet6.getText(), "Edit Bet", 
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				
				if (n == 0) {
					for(int i = 0; i < betsMade.size(); i++) {
						Bet tempBet = betsMade.get(i);
						if(bet6.getText().contains(tempBet.getType())) {
							betsMade.remove(i);
							System.out.print(betsMade.size());
						}
					}
					bet6.setText("");
				} 
			}
			bet6.setSelected(false);
		} else if (e.getSource() == bet7) {
			if (betsMade.isEmpty()) {
			
			} else {
				int n = JOptionPane.showOptionDialog(frame, bet7.getText(), "Edit Bet", 
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				
				if (n == 0) {
					for(int i = 0; i < betsMade.size(); i++) {
						Bet tempBet = betsMade.get(i);
						if(bet7.getText().contains(tempBet.getType())) {
							betsMade.remove(i);
							System.out.print(betsMade.size());
						}
					}
					bet7.setText("");
				} 
			}
			bet7.setSelected(false);
		} else if (e.getSource() == bet8) {
			if (betsMade.isEmpty()) {
			
			} else {
				int n = JOptionPane.showOptionDialog(frame, bet8.getText(), "Edit Bet", 
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				
				if (n == 0) {
					for(int i = 0; i < betsMade.size(); i++) {
						Bet tempBet = betsMade.get(i);
						if(bet8.getText().contains(tempBet.getType())) {
							betsMade.remove(i);
							System.out.print(betsMade.size());
						}
					}
					bet8.setText("");
				} 
			}
			bet8.setSelected(false);
		} else if (e.getSource() == bet9) {
			if (betsMade.isEmpty()) {
			
			} else {
				int n = JOptionPane.showOptionDialog(frame, bet9.getText(), "Edit Bet", 
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				
				if (n == 0) {
					for(int i = 0; i < betsMade.size(); i++) {
						Bet tempBet = betsMade.get(i);
						if(bet9.getText().contains(tempBet.getType())) {
							betsMade.remove(i);
							System.out.print(betsMade.size());
						}
					}
					bet9.setText("");
				}  
			}
			bet9.setSelected(false);
		} else if (e.getSource() == bet10) {
			if (betsMade.isEmpty()) {
			
			} else {
				int n = JOptionPane.showOptionDialog(frame, bet10.getText(), "Edit Bet", 
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				
				if (n == 0) {
					for(int i = 0; i < betsMade.size(); i++) {
						Bet tempBet = betsMade.get(i);
						if(bet10.getText().contains(tempBet.getType())) {
							betsMade.remove(i);
							System.out.print(betsMade.size());
						}
					}
					bet10.setText("");
				} 
			}
			bet10.setSelected(false);
		} else if (e.getSource() == btnSubmit) {
			switchMenu("Submit");
		} else if (e.getSource() == printReceipt) {
			switchMenu("Print Receipt");
		} else if (e.getSource() == search) {
			switchMenu("Search");
		}
	}
	
	public void switchMenu(String menu) {
		if (menu == "Place Bet") {
			btnHorses.setVisible(true);
			btnBoxing.setVisible(true);	
			btnFootball.setVisible(true);
			fBet.setVisible(false);
			sBet.setVisible(false);
			tBet.setVisible(false);
			foBet.setVisible(false);
			fiBet.setVisible(false);
			siBet.setVisible(false);
			seBet.setVisible(false);
			eBet.setVisible(false);
			nBet.setVisible(false);
			teBet.setVisible(false);
			printReceipt.setVisible(false);
			oneStat.setVisible(false);
			twoStat.setVisible(false);
			threeStat.setVisible(false);
			fourStat.setVisible(false);
			fiveStat.setVisible(false);
			sixStat.setVisible(false);
			sevStat.setVisible(false);
			eightStat.setVisible(false);
			nineStat.setVisible(false);
			tenStat.setVisible(false);
			search.setVisible(false);
			searchBar.setVisible(false);
		} else if (menu == "Check Results") {
			if (betsMade.isEmpty()) {
				JOptionPane.showMessageDialog(null, "You have made no bets yet!");
			} else {
				if (btnHorses.isVisible() == true || bet1.isVisible() == true) {
					resultsVisibility();
				}
				if (!bet1.getText().isEmpty()) {
					fBet.setVisible(true);
					oneStat.setVisible(true);
					fBet.setText(bet1.getText());
					oneStat.setText(coinFlip());
					if (oneStat.getText().contains("W")) {
						modifyBalance(0, 1);
					}
				}
				if (!bet2.getText().isEmpty()) {
					sBet.setVisible(true);
					twoStat.setVisible(true);
					sBet.setText(bet2.getText());
					twoStat.setText(coinFlip());
					if (twoStat.getText().contains("W")) {
						modifyBalance(0, 1);
					}
				}
				if (!bet3.getText().isEmpty()) {
					tBet.setVisible(true);
					threeStat.setVisible(true);
					tBet.setText(bet3.getText());
					threeStat.setText(coinFlip());
					if (threeStat.getText().contains("W")) {
						modifyBalance(0, 1);
					}
				}
				if (!bet4.getText().isEmpty()) {
					foBet.setVisible(true);
					fourStat.setVisible(true);
					foBet.setText(bet4.getText());
					fourStat.setText(coinFlip());
					if (fourStat.getText().contains("W")) {
						modifyBalance(0, 1);
					}
				}
				if (!bet5.getText().isEmpty()) {
					fiBet.setVisible(true);
					fiveStat.setVisible(true);
					fiBet.setText(bet5.getText());
					fiveStat.setText(coinFlip());
					if (fiveStat.getText().contains("W")) {
						modifyBalance(0, 1);
					}
				}
				if (!bet6.getText().isEmpty()) {
					siBet.setVisible(true);
					sixStat.setVisible(true);
					siBet.setText(bet6.getText());
					sixStat.setText(coinFlip());
					if (sixStat.getText().contains("W")) {
						modifyBalance(0, 1);
					}
				}
				if (!bet7.getText().isEmpty()) {
					seBet.setVisible(true);
					sevStat.setVisible(true);
					seBet.setText(bet7.getText());
					sevStat.setText(coinFlip());
					if (sevStat.getText().contains("W")) {
						modifyBalance(0, 1);
					}
				}
				if (!bet8.getText().isEmpty()) {
					eBet.setVisible(true);
					eightStat.setVisible(true);
					eBet.setText(bet8.getText());
					eightStat.setText(coinFlip());
					if (eightStat.getText().contains("W")) {
						modifyBalance(0, 1);
					}
				}
				if (!bet9.getText().isEmpty()) {
					nBet.setVisible(true);
					nineStat.setVisible(true);
					nBet.setText(bet9.getText());
					nineStat.setText(coinFlip());
					if (nineStat.getText().contains("W")) {
						modifyBalance(0, 1);
					}
				}
				if (!bet10.getText().isEmpty()) {
					teBet.setVisible(true);
					tenStat.setVisible(true);
					teBet.setText(bet10.getText());
					tenStat.setText(coinFlip());
					if (tenStat.getText().contains("W")) {
						modifyBalance(0, 1);
					}
				}
				search.setVisible(true);
				searchBar.setVisible(true);
				printReceipt.setVisible(true);
			}
		} else if (menu == "Add to Balance") {
			try {
				double addBal = Double.parseDouble(balAdd.getText());
				if (balAdd.getText() == "") {
					JOptionPane.showMessageDialog(null, "Please enter a value before attempting to add to your balance");
				} else if (addBal <= 0) {
					JOptionPane.showMessageDialog(null, "Please enter a value greater than 0");
				} else {
				modifyBalance(0, addBal);
				JOptionPane.showMessageDialog(null, "Money added to account!");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter a number");
			}
			balAdd.setText("");
		}
		else if (menu == "Horse Racing") {
			if (venue1.isVisible() == false) {
				venue1.setVisible(true);
				venue2.setVisible(true);
				venue3.setVisible(true);
			} else {
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
			} else {
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
			} else {
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
			lblPleaseEnterThe.setVisible(true);
			enAmount.setVisible(true);
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
			lblPleaseEnterThe.setVisible(true);
			enAmount.setVisible(true);
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
			lblPleaseEnterThe.setVisible(true);
			enAmount.setVisible(true);
		} else if (menu == "Wembley") {
			choice1.setVisible(true);
			choice1.setText(footTeams[0]);
			choice6.setVisible(true);
			choice6.setText(footTeams[1]);
			lblPleaseEnterThe.setVisible(true);
			enAmount.setVisible(true);
		} else if (menu == "Croke Park") {
			choice1.setVisible(true);
			choice1.setText(footTeams[2]);
			choice6.setVisible(true);
			choice6.setText(footTeams[3]);
			lblPleaseEnterThe.setVisible(true);
			enAmount.setVisible(true);
		} else if (menu == "San Siro") {
			choice1.setVisible(true);
			choice1.setText(footTeams[4]);
			choice6.setVisible(true);
			choice6.setText(footTeams[5]);
			lblPleaseEnterThe.setVisible(true);
			enAmount.setVisible(true);
		}
		else if (menu == "MGM Grand") {
			choice1.setVisible(true);
			choice1.setText(boxers[0]);
			choice6.setVisible(true);
			choice6.setText(boxers[1]);
			lblPleaseEnterThe.setVisible(true);
			enAmount.setVisible(true);
		} else if (menu == "Araneta") {
			choice1.setVisible(true);
			choice1.setText(boxers[2]);
			choice6.setVisible(true);
			choice6.setText(boxers[3]);
			lblPleaseEnterThe.setVisible(true);
			enAmount.setVisible(true);
		} else if (menu == "Blue Horizon") {
			choice1.setVisible(true);
			choice1.setText(boxers[4]);
			choice6.setVisible(true);
			choice6.setText(boxers[5]);
			lblPleaseEnterThe.setVisible(true);
			enAmount.setVisible(true);
		} else if (menu == "Submit"){
			try {
				double amount = Double.parseDouble(enAmount.getText());
				if (choice == "") {
					JOptionPane.showMessageDialog(null, "Please select someone to bet on before attempting to place a bet.");
				} else {
					if (balance >= amount) {
						if (amount > 0) {
							if (sportStatus == "Horse") {
								HorseBet hb = new HorseBet(amount, choice);
								for (int j = 0; j < betsMade.size(); j++) {
									Bet tempBet2 = betsMade.get(j);
									if (hb.getType() == tempBet2.getType()) {
										JOptionPane.showMessageDialog(null, "You cannot bet on the same person twice!");
										hbChecker = true;
									}
								}
								if (hbChecker == false) {
									betsMade.add(hb);
									modifyBalance(amount, 0);
									counter++;
									if (bet1.getText() == "") {
										bet1.setText(hb.getType() + ", Amount: \u20AC" + hb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet2.getText() == "") {
										bet2.setText(hb.getType() + ", Amount: \u20AC" + hb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet3.getText() == "") {
										bet3.setText(hb.getType() + ", Amount: \u20AC" + hb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet4.getText() == "") {
										bet4.setText(hb.getType() + ", Amount: \u20AC" + hb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet5.getText() == "") {
										bet5.setText(hb.getType() + ", Amount: \u20AC" + hb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet6.getText() == "") {
										bet6.setText(hb.getType() + ", Amount: \u20AC" + hb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet7.getText() == "") {
										bet7.setText(hb.getType() + ", Amount: \u20AC" + hb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet8.getText() == "") {
										bet8.setText(hb.getType() + ", Amount: \u20AC" + hb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet9.getText() == "") {
										bet9.setText(hb.getType() + ", Amount: \u20AC" + hb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet10.getText() == "") {
										bet10.setText(hb.getType() + ", Amount: \u20AC" + hb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else {
										JOptionPane.showMessageDialog(null, "You have reached your limit for number of bets made. Please remove a bet or wait until a bet result has come in before making another.");
									}
								}
							} else if (sportStatus == "Football") {
								FootballBet fb = new FootballBet(amount, choice);
								for (int j = 0; j < betsMade.size(); j++) {
									Bet tempBet2 = betsMade.get(j);
									if (fb.getType() == tempBet2.getType()) {
										JOptionPane.showMessageDialog(null, "You cannot bet on the same person twice!");
										fbChecker = true;
									}
								}
								if (fbChecker == false) {
									betsMade.add(fb);
									modifyBalance(amount, 0);
									counter++;
									if (bet1.getText() == "") {
										bet1.setText(fb.getType() + ", Amount: \u20AC" + fb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet2.getText() == "") {
										bet2.setText(fb.getType() + ", Amount: \u20AC" + fb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet3.getText() == "") {
										bet3.setText(fb.getType() + ", Amount: \u20AC" + fb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet4.getText() == "") {
										bet4.setText(fb.getType() + ", Amount: \u20AC" + fb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet5.getText() == "") {
										bet5.setText(fb.getType() + ", Amount: \u20AC" + fb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet6.getText() == "") {
										bet6.setText(fb.getType() + ", Amount: \u20AC" + fb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet7.getText() == "") {
										bet7.setText(fb.getType() + ", Amount: \u20AC" + fb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet8.getText() == "") {
										bet8.setText(fb.getType() + ", Amount: \u20AC" + fb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet9.getText() == "") {
										bet9.setText(fb.getType() + ", Amount: \u20AC" + fb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet10.getText() == "") {
										bet10.setText(fb.getType() + ", Amount: \u20AC" + fb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else {
										JOptionPane.showMessageDialog(null, "You have reached your limit for number of bets made. Please remove a bet or wait until a bet result has come in before making another.");
									}
								}
							} else if (sportStatus == "Boxing") {
								BoxingBet bb = new BoxingBet(amount, choice);
								for (int j = 0; j < betsMade.size(); j++) {
									Bet tempBet2 = betsMade.get(j);
									if (bb.getType() == tempBet2.getType()) {
										JOptionPane.showMessageDialog(null, "You cannot bet on the same person twice!");
										bbChecker = true;
									}
								}
								if (bbChecker == false) {
									betsMade.add(bb);
									modifyBalance(amount, 0);
									counter++;
									if (bet1.getText() == "") {
										bet1.setText(bb.getType() + ", Amount: \u20AC" + bb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet2.getText() == "") {
										bet2.setText(bb.getType() + ", Amount: \u20AC" + bb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet3.getText() == "") {
										bet3.setText(bb.getType() + ", Amount: \u20AC" + bb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet4.getText() == "") {
										bet4.setText(bb.getType() + ", Amount: \u20AC" + bb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet5.getText() == "") {
										bet5.setText(bb.getType() + ", Amount: \u20AC" + bb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet6.getText() == "") {
										bet6.setText(bb.getType() + ", Amount: \u20AC" + bb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet7.getText() == "") {
										bet7.setText(bb.getType() + ", Amount: \u20AC" + bb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet8.getText() == "") {
										bet8.setText(bb.getType() + ", Amount: \u20AC" + bb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet9.getText() == "") {
										bet9.setText(bb.getType() + ", Amount: \u20AC" + bb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else if (bet10.getText() == "") {
										bet10.setText(bb.getType() + ", Amount: \u20AC" + bb.getAmount() + ", Made at: " + sdf.format(cal.getTime()));
									} else {
										JOptionPane.showMessageDialog(null, "You have reached your limit for number of bets made. Please remove a bet or wait until a bet result has come in before making another.");
									}
								}
							} else if (sportStatus == "") {
								JOptionPane.showMessageDialog(null, "You need to choose a sport and someone to bet on before submitting a bet");
							}
							choice = "";
						} 
					} else if (balance < amount) {
						JOptionPane.showMessageDialog(null, "The amount entered exceeds your balance. Please enter a lower amount or add more money to your balance");
					}
				} 
				enAmount.setText("");
				resetButtonStatus();
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
						"Please enter a number in the amount section");
				enAmount.setText("");
			}
			hbChecker = false;
			fbChecker = false;
			bbChecker = false;
		} else if (menu == "Print Receipt") {
			createReceipt();
		} else if (menu == "Search") {
			StringBuilder sb = new StringBuilder();
			sb.append("The following bets contains the characters searched for:\n");
			String message = "";
			String stri = "";
			String striLC = "";
			for (Bet bet1 : betsMade) {
				stri = Double.toString(bet1.getAmount());
				if (bet1.getType().toLowerCase().contains(searchBar.getText().toLowerCase()) || stri.contains(searchBar.getText().toLowerCase())) {
					sb.append(bet1.getType());
					sb.append(" Amount: \u20AC");
					sb.append(stri);
					sb.append("\n");
					System.out.print("Test3");
				}
			}
			message = sb.toString();
			JOptionPane.showMessageDialog(null, message);
			searchBar.setText("");
		} else if (menu == "Quit") {
			System.exit(0);
		}
	}
	
	public static String coinFlip() {
		Random rand = new Random();
		int i = rand.nextInt(2);
		String results = "";
		if (i == 0) {
			results = "Won!";
				
		}
		else {
			results = "Lost!";
				
		}
		return results;
	}
	
	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.frame.setVisible(true);
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
		double bal2;
		if (a > 0) {
			a = a * -1;
			balance = balance + a;
		}
		else {
			balance = balance + b;
		}
		
		//balance = (double)Math.round(balance*100) / (double)100;
		label.setText("\u20AC" + dec.format(balance));
	}
	
	public void resultsVisibility() {
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
		info1.setVisible(false);
		bet1.setVisible(false);
		bet2.setVisible(false);
		bet3.setVisible(false);
		bet4.setVisible(false);
		bet5.setVisible(false);
		bet6.setVisible(false);
		bet7.setVisible(false);
		bet8.setVisible(false);
		bet9.setVisible(false);
		bet10.setVisible(false);
		lblSelectSport.setVisible(false);
		lblPleaseEnterThe.setVisible(false);
		btnSubmit.setVisible(false);
		enAmount.setVisible(false);
	}
	
	public void createReceipt() {
		String fileName = "receipts.txt";

		PrintWriter outputstream = null;
		try {
			outputstream = new PrintWriter(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("File " + fileName + " not found.");
			System.exit(0);
		}
		if (betsMade.isEmpty()) {
			JOptionPane.showMessageDialog(null, "You have made no bets, therefore there are no receipts!");
		} else {

			for (Bet bet : betsMade) {
				outputstream.println("You bet on: " + bet.getType()
						+ "\n Amount: €" + bet.getAmount() + " at: " + sdf.format(cal.getTime()) + "\n");
			}
			JOptionPane.showMessageDialog(null, "Receipts Printed!");
		}

		outputstream.close();
	}
}
