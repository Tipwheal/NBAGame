package com.tipwheal.game;

import java.io.*;
import java.util.*;

public class MainSystem {
	private String accountName;
	private Account account;
	private IOHelper helper;
	private BallGameManager manager;
	
	public MainSystem(String accountName) {
		this.accountName = accountName;
		helper = new IOHelper();
		manager = new BallGameManager();
	}

	public void start() {
		loadAccount();
		System.out.println("next. next game");
		System.out.println("team. check team");
		System.out.println("quit. quit");
		switch(helper.getInputString().toLowerCase()) {
		case "next":
			nextGame();
		case "team":
			checkTeam();
		case "quit":
			return;
		default:
			start();
		}
	}
	
	private void loadAccount() {
		File file = new File("accounts.ser");
		if (!file.exists()) {
			account = new Account(accountName);
			saveAccount();
			start();
		}
		try {
			ObjectInputStream os = new ObjectInputStream(new FileInputStream(file));
			while (true) {
				Account account = (Account) os.readObject();
				if (account.equals(accountName)) {
					this.account = account;
					break;
				}
			}
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void saveAccount() {
		File file = new File("accounts.ser");
		ArrayList<Account> all = new ArrayList<>();
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
			while(true) {
				Object temp = is.readObject();
				if(temp == null) {
					break;
				}
				all.add((Account)temp);
			}
			is.close();
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
			for(Account account:all) {
				if(account.getName().equals(accountName)) {
					all.remove(account);
					all.add(this.account);
					break;
				}
				os.writeObject(account);
			}
			os.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void nextGame() {
		manager.getNextGame();
		System.out.println("Next Game you play with " + manager.enemy().getName());
		System.out.println("And " + manager.homeTeam() + " is home team");
		System.out.println("enter 'y' to start");
		if(helper.getInputString().equals("y")) {
			account.getTeam().playWith(manager.enemy());
		}else {
			System.out.println("you didn't play the game");
			saveAccount();
			start();
		}
		manager.showResult();
	}
	
	private void checkTeam() {
		
	}
}
