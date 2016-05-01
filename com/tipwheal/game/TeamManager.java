package com.tipwheal.game;

import java.io.*;
import java.util.*;

public class TeamManager {
	private static ArrayList<String> teams;
	
	static {
		teams = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("teams.txt"));
			while(true) {
				String team = reader.readLine();
				if(team == null) {
					break;
				}
				teams.add(team);
			}
			reader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean validTeamName(String teamName) {
		for(String team:teams) {
			if(teamName.equals(team)) {
				return true;
			}
		}
		return false;
	}
}
