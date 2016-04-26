package com.tipwheal.game;

import java.io.*;

public class Account implements Serializable {

	private static final long serialVersionUID = -5272688974709690430L;

	private Team team;
	private int money;
	private Team[] enemies;

	public Account() {
		team = new Team();
		money = 0;
		enemies = new Team[19];
	}

	public Team getTeam() {
		return team;
	}

	public int getMoney() {
		return money;
	}

	public Team[] getEnemies() {
		return enemies;
	}

}
