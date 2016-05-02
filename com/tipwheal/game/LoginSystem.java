package com.tipwheal.game;

import java.io.*;
import java.util.*;

public class LoginSystem {
	private Map<String, String> account = new HashMap<String, String>();
	private IOHelper helper = new IOHelper();

	public static void main(String[] args) {
		new LoginSystem().start();
	}

	public void start() {
		loadInfo();
		System.out.println("a. log in");
		System.out.println("b. create new account");
		System.out.println("c. delete account");
		switch (helper.getInputString().toLowerCase()) {
		case "a":
			login();
		case "b":
			create();
		case "c":
			delete();
		default:
			System.out.println("Wrong input");
			start();
		}
	}

	private void login() {
		String name = helper.getInputString("please enter your name:");
		if (account.containsKey(name)) {
			String password = helper.getInputString("Please enter yout password");
			if (account.get(name).equals(password)) {
				MainSystem game = new MainSystem(name);
				game.start();
			} else {
				System.out.println("wrong password.");
				login();
			}
		} else {
			System.out.println("no such account,try again");
			start();
		}
	}

	private void create() {
		String name = helper.getInputString("Please enter your user name:(only characters permitted)");
		if (!name.matches("[A-Z|a-z]+")) {
			System.out.println("wrong name.");
			create();
		} else if (account.containsKey(name)) {
			System.out.println("the account is existed.");
			create();
		} else {
			String password = helper.getInputString("Please enter your password:");
			account.put(name, password);
			System.out.println("ok,you create a new account: " + name);
			saveInfo();
			start();
		}
	}

	private void delete() {
		String name = helper.getInputString("Please enter account name to delete.");
		account.remove(name);
		saveInfo();
		start();
	}

	private void loadInfo() {
		try {
			File file = new File("accounts.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while (true) {
				String input = reader.readLine();
				if (input == null) {
					break;
				}
				account.put(input.split(" ")[0], input.split(" ")[1]);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void saveInfo() {
		File file = new File("accounts.txt");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (String name : account.keySet()) {
				writer.append(name + " " + account.get(name) + "\r\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
