package com.tipwheal.game;

import java.io.*;

public class Team implements Serializable {
	private static final long serialVersionUID = -4808909708684777814L;
	private Player[] members;
	private int score;

	public int numOfMembers() {
		return members.length;
	}

	public int getScore() {
		return score;
	}
}
