package com.tipwheal.game;

import java.io.*;

public class Player implements Serializable {
	private static final long serialVersionUID = -5847576158378846328L;
	private int serveTime;

	public int getServeTime() {
		return serveTime;
	}

	public void setServeTime(int serveTime) {
		this.serveTime = serveTime;
	}
}
