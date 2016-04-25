package com.tipwheal.game;

import java.io.*;

public class Game {
	Player player;
	public void start(String name) {
		loadPlayer(name);
		if(player.getTeam()!=null){
			
		}
		while(true) {
			
		}
	}
	
	private void loadPlayer(String name) {
		try {
			File file = new File(name + ".ser");
			if(!file.exists()) {
				file.createNewFile();
			}
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
			player = (Player)is.readObject();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
