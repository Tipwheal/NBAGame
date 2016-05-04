package com.tipwheal.game;

public class BallGame {
	private boolean played;
	private Team homeTeam;
	private Team visitor;
	private String gameResult;

	public void play() {
		homeTeam.playWith(visitor);
		played = true;
	}

	public void showResult() {

	}

	public void setHomeTeam(Team team) {
		homeTeam = team;
	}

	public void setVisitor(Team team) {
		visitor = team;
	}

	public String getResult() {
		return gameResult;
	}

	public boolean getPlayed() {
		return played;
	}
}
