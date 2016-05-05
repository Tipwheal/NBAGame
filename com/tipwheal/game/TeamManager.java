package com.tipwheal.game;

import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class TeamManager {
	private static ArrayList<String> teams;

	static {
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("teamNames.ser"));
			teams = (ArrayList<String>) is.readObject();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean validTeamName(String teamName) {
		for (String team : teams) {
			if (teamName.equals(team)) {
				return true;
			}
		}
		return false;
	}
}
