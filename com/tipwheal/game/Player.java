package com.tipwheal.game;

import java.io.*;

public class Player implements Serializable {
	private static final long serialVersionUID = -5847576158378846328L;
	private int serveTime;
	private int score;
	private int ability;

	public Player() {
		ability = 3;
	}

	public void setAbility(int ability) {
		this.ability = ability;
	}

	public int getServeTime() {
		return serveTime;
	}

	public void setServeTime(int serveTime) {
		this.serveTime = serveTime;
	}

	public int getScore() {
		return score;
	}

	public void playAGame() {
		int ran1 = (int) (Math.random() * 6 + 0.5);
		int ran2 = (int) (Math.random() * 6 + 0.5);
		score = ran1 * ability + ran2;
	}
}
