package com.tipwheal.game;

import java.util.*;
import java.io.*;

/**
 * Ball Game Manager.<br>
 * contains account, teams, hometeam, visitor, game.
 * 
 * @author Administrator
 *
 */
public class BallGameManager {
	private ArrayList<Team> allTeams;
	private Account account;
	private Team homeTeam;
	private Team visitor;
	private BallGame game;

	/**
	 * constructor.
	 * 
	 * @param account
	 */
	@SuppressWarnings("unchecked")
	public BallGameManager(Account account) {
		this.account = account;
		allTeams = new ArrayList<>();
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("teams.ser"));
			allTeams = (ArrayList<Team>) is.readObject();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * get next game.
	 */
	public void getNextGame() {
		if (!game.getPlayed()) {
			return;
		}
		game = new BallGame();
		int ran = (int) (Math.random() * allTeams.size());
		Team another = allTeams.get(ran);
		ran = (int) (Math.random() + 0.5);
		if (ran == 1) {
			visitor = another;
			homeTeam = account.getTeam();
		} else {
			visitor = account.getTeam();
			homeTeam = another;
		}
	}

	/**
	 * getter for visitor.
	 * 
	 * @return
	 */
	public Team getVisitor() {
		return visitor;
	}

	/**
	 * getter for homeTeam.
	 * 
	 * @return
	 */
	public Team getHomeTeam() {
		return homeTeam;
	}

	/**
	 * show result.
	 */
	public void showResult() {
		game.showResult();
	}
}
