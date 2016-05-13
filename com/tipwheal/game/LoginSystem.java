package com.tipwheal.game;

import java.io.*;
import java.util.*;

public class LoginSystem {
	private Map<String, String> account = new HashMap<String, String>();
	private IOHelper helper = new IOHelper();

	public static void main(String[] args) {
		new LoginSystem().start();
	}

	/**
	 * load all accounts' info and start the game
	 * <p>
	 * get input and switch<br>
	 * then jump to
	 * <p>
	 * log in<br>
	 * create new account<br>
	 * delete account<br>
	 * show all accounts
	 */
	public void start() {
		loadInfo();
		System.out.print("LoginSystem: ");
		switch (helper.getInputString().toLowerCase()) {
		case "login":
			login();
		case "create":
			create();
		case "delete":
			delete();
		case "show":
			show();
		case "help":
			help();
		default:
			System.out.println("Wrong input");
			start();
		}
	}

	/**
	 * get name and password and check<br>
	 * if wrong name jump to start<br>
	 * if wrong password login() again
	 */
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

	/**
	 * creat an new account and save to "accounts.ser"<br>
	 * if already exist,jump to start<br>
	 * if wrong format,create again<br>
	 * create an new account and save<br>
	 * then start()
	 */
	private void create() {
		String name = helper.getInputString("Please enter your user name:(only characters permitted)");
		if (!name.matches("[A-Z|a-z]+")) {
			System.out.println("wrong name.");
			create();
		} else if (account.containsKey(name)) {
			System.out.println("the account is existed.");
			start();
		} else {
			String password = helper.getInputString("Please enter your password:");
			account.put(name, password);
			System.out.println("ok,you create a new account: " + name);
			saveInfo();
			start();
		}
	}

	/**
	 * enter account name<br>
	 * enter password<br>
	 * if right name enter password<br>
	 * if wrong name jump to start<br>
	 * wrong password delete() again
	 */
	private void delete() {
		String name = helper.getInputString("Please enter account name to delete.");
		if (account.containsKey(name)) {
			String password = helper.getInputString("Please enter the password");
			if (password.equals(account.get(name))) {
				account.remove(name);
				saveInfo();
			} else {
				System.out.println("Sorry, wrong password.");
				delete();
			}
		} else {
			System.out.println("No such account.");
			start();
		}
	}

	/**
	 * load info in "accounts.ser"
	 */
	@SuppressWarnings("unchecked")
	private void loadInfo() {
		try {
			File file = new File("accounts.ser");
			if (!file.exists()) {
				file.createNewFile();
				saveInfo();
			}
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
			account = (HashMap<String, String>) is.readObject();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * show all accounts' name
	 */
	private void show() {
		for (String name : account.keySet()) {
			System.out.println(name);
		}
		start();
	}

	/**
	 * show all commands
	 */
	private void help() {
		String[] list = { "login", "help", "create", "delete", "show" };
		for (String string : list) {
			System.out.println(string);
		}
	}

	/**
	 * save accounts to "accounts.ser"
	 */
	private void saveInfo() {
		File file = new File("accounts.ser");
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(account);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
