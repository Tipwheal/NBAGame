package com.tipwheal.game;

import java.io.*;
import java.util.*;

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

	@SuppressWarnings("unchecked")
	public <E> boolean contains(File file, Class<E> object) {
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
			TreeSet<E> set = (TreeSet<E>) is.readObject();
			is.close();
			return set.contains(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
