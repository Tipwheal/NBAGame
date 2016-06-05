package com.tipwheal.game;

/**
 * Ball Game.<br>
 * contains a boolean palyed, two Teams, a String gameResult.
 * 
 * @author Administrator
 *
 */
public class BallGame {
	private boolean played;
	private Team homeTeam;
	private Team visitor;
	private String gameResult;

	/**
	 * play a game.
	 */
	public void play() {
		homeTeam.playWith(visitor);
		played = true;
	}

	/**
	 * showResult.
	 */
	public void showResult() {

	}

	/**
	 * set home team.
	 * 
	 * @param team
	 */
	public void setHomeTeam(Team team) {
		homeTeam = team;
	}

	/**
	 * set visitor.
	 * 
	 * @param team
	 */
	public void setVisitor(Team team) {
		visitor = team;
	}

	/**
	 * getter for result.
	 * 
	 * @return
	 */
	public String getResult() {
		return gameResult;
	}

	/**
	 * getter for played.
	 * 
	 * @return
	 */
	public boolean getPlayed() {
		return played;
	}
}
