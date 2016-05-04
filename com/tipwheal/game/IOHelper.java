package com.tipwheal.game;

import java.io.*;

public class IOHelper {

	public String getInputString() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String result = null;
		try {
			result = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String getInputString(String prompt) {
		System.out.println(prompt);
		return getInputString();
	}

	public <E> boolean contains(File file, Class<E> object) {
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
			while (true) {
				E temp = (E) is.readObject();
				if (temp == null) {
					break;
				}
				if (object.equals(temp)) {
					return true;
				}
			}
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
