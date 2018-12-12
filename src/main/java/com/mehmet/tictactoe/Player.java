package com.mehmet.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player extends PlayerBase{

	public Player(String player, String[] playField) {
		super(playField, player);
	}

	public void playSpot(int spot) {		
		setPlayField(spot, getPlayerName());
	}
	
	public int playSpot() throws IOException {

		String spot = "-1";
		boolean isValid = false;
		while (!isValid) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Enter spot for " + getPlayerName() + ": ");

				spot = br.readLine();

				isValid = isValid(spot);

				if (!isValid) {
					System.out.println(spot + " is already used. Please used empty spot");
				}
			} catch (NumberFormatException nfe) {
				System.err.println("Invalid Format! Please type correct format");
			}
		}
		
		setPlayField(Integer.valueOf(spot), getPlayerName());
		
		return Integer.valueOf(spot);
	}

	private boolean isValid(String spot) {

		for (int i = 0; i < getPlayField().length; i++) {
			if (spot.equals(getPlayField(i))) {
				return true;
			}
		}
		return false;
	}
	
	
}
