package com.tipwheal.game;

import java.io.*;
import java.util.*;

/**
 * Team Manager.<br>
 * contains an arraylist team.
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("unchecked")
public class TeamManager {
	private static ArrayList<String> teams;

	/**
	 * initialize.
	 */
	static {
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("teamNames.ser"));
			teams = (ArrayList<String>) is.readObject();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * check if it's a valid team name.
	 * 
	 * @param teamName
	 * @return
	 */
	public static boolean validTeamName(String teamName) {
		for (String team : teams) {
			if (teamName.equals(team)) {
				return true;
			}
		}
		return false;
	}
}
