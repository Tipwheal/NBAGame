package com.tipwheal.game;

import java.io.*;
import java.util.*;

public class LoginSystem {
	private Map<String, String> map = new HashMap<String, String>();
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
		if (checkName(name)) {
			String password = helper.getInputString("Please enter yout password");
			if (checkPassword(name, password)) {
				Game game = new Game();
				game.start(name);
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
		} else if (map.containsKey(name)) {
			System.out.println("the account is existed.");
			create();
		} else {
			String password = helper.getInputString("Please enter your password:");
			map.put(name, password);
			System.out.println("ok,you create a new account: " + name);
			saveInfo();
			start();
		}
	}

	private void delete() {
		String name = helper.getInputString("Please enter account name to delete.");
		map.remove(name);
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
				map.put(input.split(" ")[0], input.split(" ")[1]);
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
			for (String name : map.keySet()) {
				writer.append(name + " " + map.get(map) + "\r\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean checkName(String name) {
		if (map.containsKey(name)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkPassword(String name, String password) {
		if (password.equals(map.get(name))) {
			return true;
		} else {
			return false;
		}
	}
}
