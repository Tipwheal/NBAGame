package com.tipwheal.game;

import java.io.*;
import java.util.*;

public class LoginSystem {
	private TreeSet<String> accounts = new TreeSet<>();
	private Map<String, String> map = new HashMap<String, String>();

	public static void main(String[] args) {
		new LoginSystem().start();
	}

	private void start() {
		loadInfo();
		System.out.println("a. log in");
		System.out.println("b. create new account");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String inputLine = reader.readLine();
			switch (inputLine.toLowerCase()) {
			case "a":
				login();
				break;
			case "b":
				create();
				break;
			default:
				System.out.println("Wrong input");
				start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void login() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("please enter your name:");
			String name = reader.readLine();
			if (checkName(name)) {
				System.out.println("Please enter yout password");
				String password = reader.readLine();
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void create() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Please enter your user name:(only characters permitted)");
			String name = reader.readLine();
			if (!name.matches("[A-Z|a-z]+")) {
				System.out.println("wrong name.");
				create();
			} else if (accounts.contains(name)) {
				System.out.println("the account is existed.");
				create();
			} else {
				System.out.println("Please enter your password:");
				String password = reader.readLine();
				accounts.add(name);
				map.put(name, password);
				System.out.println("ok,you create a new account: " + name);
				saveInfo();
				start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
				accounts.add(input.split(" ")[0]);
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
			for (String name : accounts) {
				writer.append(name + " " + map.get(name) + "\r\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean checkName(String name) {
		for (String string : accounts) {
			if (name.equals(string)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkPassword(String name, String password) {
		if (password.equals(map.get(name))) {
			return true;
		}
		return false;
	}
}
