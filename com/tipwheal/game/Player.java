package com.tipwheal.game;

import java.io.*;

public class Player implements Serializable {
	private static final long serialVersionUID = -5847576158378846328L;
	private int serveTime;
	private int score;
	private int ability;
	private int defence;

	public Player() {
		ability = 3;
	}

	public void setAbility(int ability) {
		this.ability = ability;
	}
	
	public int getAbility() {
		return ability;
	}

	public int getServeTime() {
		return serveTime;
	}

	public void setServeTime(int serveTime) {
		this.serveTime = serveTime;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}
	
	public void setDefence(int defence) {
		this.defence = defence;
	}
	
	public int getDefence() {
		return defence;
	}
	
	public void addScore(int add) {
		score += add;
	}
}
