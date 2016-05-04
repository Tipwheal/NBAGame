package com.tipwheal.game;

import java.io.*;

public class Team implements Serializable {
	private static final long serialVersionUID = -4808909708684777814L;
	private String name;
	private Player[] members;
	private int score;

	public int numOfMembers() {
		return members.length;
	}

	public int getScore() {
		return score;
	}
	
	public void playWith(Team another) {
		score = 0;
		another.score = 0;
		for(Player player:members) {
			player.playAGame();
			score += player.getScore();
		}
		for(Player player:another.members) {
			player.playAGame();
			another.score += player.getScore();
		}
	}
	
	public String getName() {
		return name;
	}
}
