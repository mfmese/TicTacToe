package com.mehmet.tictactoe;

public class Move {
	private  int spot;
	private int score;
	
	public int getIndex() {
		return spot;
	}
	public void setIndex(int index) {
		this.spot = index;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

}
