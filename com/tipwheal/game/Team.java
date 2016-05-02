package com.tipwheal.game;

import java.io.*;

public class Team implements Serializable {
	private static final long serialVersionUID = -4808909708684777814L;
	private String name;
	private Player[] members;
	private int totalScore;

	public int numOfMembers() {
		return members.length;
	}

	public int getTotalScore() {
		return totalScore;
	}
	
	public void playWith(Team anotherTeam) {
		
	}
	
	public String getName() {
		return name;
	}
}
