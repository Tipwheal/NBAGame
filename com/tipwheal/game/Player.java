package com.tipwheal.game;

import java.io.*;

public class Player implements Serializable {
	private static final long serialVersionUID = -5847576158378846328L;
	private int score;
	private int ability;
	private int defence;

	public Player() {
		ability = 3;
		defence = 1;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setAbility(int ability) {
		this.ability = ability;
	}

	public int getAbility() {
		return ability;
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
