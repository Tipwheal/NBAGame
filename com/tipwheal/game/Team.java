package com.tipwheal.game;

import java.io.*;
import java.util.*;

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
		initAGame();
		another.initAGame();
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			int index = random.nextInt(members.length);
			double interferenceA = members[index].getDefence() * 0.1;
			double interferenceB = another.members[index].getDefence() * 0.1;
			double hitRateA = members[index].getAbility() * 0.1 * (1 - interferenceB);
			double hitRateB = another.members[index].getAbility() * 0.1 * (1 - interferenceA);
			boolean shootedA = hitRateA >= random.nextDouble();
			boolean shootedB = hitRateB >= random.nextDouble();
			int scoreA = shootedA ? random.nextDouble() >= 0.7 ? 3 : 2 : 0;
			int scoreB = shootedB ? random.nextDouble() >= 0.7 ? 3 : 2 : 0;
			members[index].addScore(scoreA);
			another.members[index].addScore(scoreB);
		}
	}

	public String getName() {
		return name;
	}

	private void initAGame() {
		score = 0;
		for (Player p : members) {
			p.setScore(0);
		}
	}
}
