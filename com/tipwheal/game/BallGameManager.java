package com.tipwheal.game;

import java.util.*;
import java.io.*;

public class BallGameManager {
	private ArrayList<Team> allTeams;
	private Account account;
	private Team homeTeam;
	private Team visitor;
	private BallGame game;

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

	public Team getVisitor() {
		return visitor;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void showResult() {
		game.showResult();
	}
}
