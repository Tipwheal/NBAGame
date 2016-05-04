package com.tipwheal.game;

import java.io.*;

public class Account implements Serializable {
	private static final long serialVersionUID = -5272688974709690430L;

	private String name;
	private Team team;
	private int money;

	public Account(String name) {
		this.name = name;
		team = new Team();
		money = 0;
	}

	public Team getTeam() {
		return team;
	}

	public int getMoney() {
		return money;
	}

	public String getName() {
		return name;
	}

}
