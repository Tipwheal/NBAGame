package com.tipwheal.game;

import java.io.*;

public class Game {
	private Account account;
	private String accountName;
	private IOHelper helper;

	public Game() {
		helper = new IOHelper();
	}

	public void start(String name) {
		accountName = name;
		start();
	}

	public void start() {
		loadInfo();
		while (true) {
			System.out.println("a. start a random game");
			System.out.println("b. create new enemies");
			System.out.println("c. hire players");
			System.out.println("d. fire players");
			System.out.println("e. reset account");
			System.out.println("f. log out");
			System.out.println("g. exit");
			switch (helper.getInputString()) {
			case "a":
				startRandomGame();
			case "b":
				createNewEnemies();
			case "c":
				hirePlayers();
			case "d":
				firePlayers();
			case "e":
				account = new Account();
				start();
			case "f":
				saveInfo();
				new LoginSystem().start();
			case "g":
				return;
			}
		}
	}

	private void loadInfo() {
		try {
			File file = new File(accountName + ".ser");
			if (!file.exists()) {
				createNewAccount();
			}
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
			account = (Account) is.readObject();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createNewAccount() {
		account = new Account();
		saveInfo();
	}

	private void saveInfo() {
		try {
			File file = new File(accountName + ".ser");
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(account);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void startRandomGame() {
		if (account.getTeam().numOfMembers() < 10) {
			System.out.println("Sorry,you have not enough players,hire some first please.");
			start();
		} else if (account.getEnemies().length == 0) {

		}
	}

	private void createNewEnemies() {

	}

	private void hirePlayers() {

	}

	private void firePlayers() {

	}
}
