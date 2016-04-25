package com.tipwheal.game;

import java.io.*;

public class Team implements Serializable {
	private Player[] members;
	private int score;
	
	public int numOfMembers() {
		return members.length;
	}
}
