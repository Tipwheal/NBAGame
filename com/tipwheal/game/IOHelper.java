package com.tipwheal.game;

import java.io.*;

public class IOHelper {
	
	public String getInputString() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String result = null;
		try {
			result = reader.readLine();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String getInputString(String prompt) {
		System.out.println(prompt);
		return getInputString();
	}
}
