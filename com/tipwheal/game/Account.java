package com.tipwheal.game;

import java.io.*;

/**
 * Account.<br>
 * contains team, money, name.
 * 
 * @author Administrator
 *
 */
public class Account implements Serializable {
	private static final long serialVersionUID = -5272688974709690430L;

	private String name;
	private Team team;
	private int money;

	/**
	 * constructor.
	 * 
	 * @param name
	 */
	public Account(String name) {
		this.name = name;
		team = new Team();
		money = 0;
	}

	/**
	 * getter for team.
	 * 
	 * @return
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * getter for moner.
	 * 
	 * @return
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * getter for name.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * add a team.
	 * 
	 * @param t
	 */
	public void addTeam(Team t) {
		if (team == null) {
			team = t;
		} else {
			System.out.println("You already hava a team.");
		}
	}

	/**
	 * delete your team.
	 */
	public void delTeam() {
		if (team != null) {
			team = null;
		} else {
			System.out.println("Sorry,you have no team.");
		}
	}

}
