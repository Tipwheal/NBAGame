package com.tipwheal.game;

import java.io.Serializable;
import java.util.Random;

/**
 * Player.<br>
 * contains score, ability, defence, team.
 * 
 * @author Administrator
 *
 */
public class Player implements Serializable {
	private static final long serialVersionUID = -5847576158378846328L;
	private int score;
	private int ability;
	private int defence;
	private int totalScore;
	private String team;

	public Player() {
		ability = 3;
		defence = 1;
	}

	/**
	 * setter for score.
	 * 
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * getter for score.
	 * 
	 * @return
	 */
	public int getScore() {
		return score;
	}

	/**
	 * setter for ability.
	 * 
	 * @param ability
	 */
	public void setAbility(int ability) {
		this.ability = ability;
	}

	/**
	 * getter for ability.
	 * 
	 * @return
	 */
	public int getAbility() {
		return ability;
	}

	/**
	 * setter for defence.
	 * 
	 * @param defence
	 */
	public void setDefence(int defence) {
		this.defence = defence;
	}

	/**
	 * getter for defence.
	 * 
	 * @return
	 */
	public int getDefence() {
		return defence;
	}

	/**
	 * add score.
	 * 
	 * @param add
	 */
	public void addScore(int add) {
		score += add;
	}

	/**
	 * setter for team.
	 * 
	 * @param team
	 */
	public void setTeam(String team) {
		this.team = team;
	}

	/**
	 * getter for team.
	 * 
	 * @return
	 */
	public String getTeam() {
		return team;
	}

	/**
	 * play with another Player.
	 * 
	 * @param another
	 */
	public void play(Player another) {
		this.score = 0;
		another.score = 0;
		Random rnd = new Random();
		this.score += rnd.nextInt(6) * (this.ability - another.defence);
		another.score += rnd.nextInt(6) * (another.ability - this.defence);
		this.totalScore += this.score;
		another.totalScore += another.score;
	}

	/**
	 * getter for totalScore.
	 * 
	 * @return
	 */
	public int getTotalScore() {
		return totalScore;
	}
}
