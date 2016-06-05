package com.tipwheal.game;

import java.io.*;
import java.util.*;

/**
 * Main system.<br>
 * contains accountName, account, helper, manager.
 * 
 * @author Administrator
 *
 */
public class MainSystem {
	private String accountName;
	private Account account;
	private IOHelper helper;
	private BallGameManager manager;

	/**
	 * Creater for MainSystem
	 * 
	 * @param accountName
	 *            <p>
	 *            account's name
	 */
	public MainSystem(String accountName) {
		this.accountName = accountName;
		helper = new IOHelper();
		manager = new BallGameManager(account);
	}

	/**
	 * start.
	 */
	public void start() {
		loadAccount();
		System.out.println("next. next game");
		System.out.println("team. check team");
		System.out.println("quit. quit");
		switch (helper.getInputString().toLowerCase()) {
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

	/**
	 * load account.
	 */
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

	/**
	 * save account.
	 */
	private void saveAccount() {
		File file = new File("accounts.ser");
		ArrayList<Account> all = new ArrayList<>();
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
			while (true) {
				Object temp = is.readObject();
				if (temp == null) {
					break;
				}
				all.add((Account) temp);
			}
			is.close();
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
			for (Account account : all) {
				if (account.getName().equals(accountName)) {
					all.remove(account);
					all.add(this.account);
					break;
				}
				os.writeObject(account);
			}
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * get next game.
	 */
	private void nextGame() {
		manager.getNextGame();
		System.out.println("Next Game you play with " + manager.getVisitor().getName());
		System.out.println("And " + manager.getHomeTeam() + " is home team");
		System.out.println("enter 'y' to start");
		if (helper.getInputString().equals("y")) {
			account.getTeam().playWith(manager.getVisitor());
		} else {
			System.out.println("you didn't play the game");
			saveAccount();
			start();
		}
		manager.showResult();
	}

	/**
	 * check team.
	 */
	public void checkTeam() {

	}

}
