package com.tipwheal.game;

import java.io.*;
import java.util.*;

/**
 * Team.<br>
 * contains name, members, score.
 * 
 * @author Administrator
 *
 */
public class Team implements Serializable {
	private static final long serialVersionUID = -4808909708684777814L;
	private String name;
	private ArrayList<Player> members = new ArrayList<>();
	private Player[] mMember = new Player[5];
	private int score;

	/**
	 * return num of members.
	 * 
	 * @return
	 */
	public int numOfMembers() {
		return members.size();
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
	 * play with another team.
	 * 
	 * @param another
	 */
	public void playWith(Team another) {
		this.score = 0;
		another.score = 0;
		for (int i = 0; i < 5; i++) {
			this.mMember[i].play(another.mMember[i]);
			this.score += this.mMember[i].getScore();
			another.score += another.mMember[i].getScore();
		}
	}

	/**
	 * getter for name.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter for mMember.
	 * 
	 * @param p
	 */
	public void setMMember(int[] p) {
		for (int i = 0; i < 5; i++) {
			mMember[i] = members.get(p[i]);
		}
	}

}
