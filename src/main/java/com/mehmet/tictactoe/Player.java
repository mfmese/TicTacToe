package com.mehmet.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player extends PlayerBase{

	private String playerType;
	private String[] playField;

	public Player(String playerType, String[] board) {
		super(board, playerType);
		this.playerType = playerType;
		this.playField = board;
	}

	public void playSpot(int spot) {
		
		playField[Integer.valueOf(spot)] = playerType;
	}
	
	public int playSpot() throws IOException {

		String spot = "-1";
		boolean isValid = false;
		while (!isValid) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Enter spot for " + playerType + ": ");

				spot = br.readLine();

				isValid = isValid(spot);

				if (!isValid) {
					System.out.println(spot + " is already used. Please used empty spot");
				}
			} catch (NumberFormatException nfe) {
				System.err.println("Invalid Format! Please type correct format");
			}
		}
		
		playField[Integer.valueOf(spot)] = playerType;
		
		return Integer.valueOf(spot);
	}

	private boolean isValid(String spot) {

		for (int i = 0; i < playField.length; i++) {
			if (spot.equals(playField[i])) {
				return true;
			}
		}
		return false;
	}
	
	
}
