package com.mehmet.tictactoe;

import java.io.IOException;
import java.util.ArrayList;

public abstract class PlayerBase {

	public String playerName;	
	public String[] playField;	

	public PlayerBase() {

	}

	public PlayerBase(String[] playField, String player) {
		this.playField = playField;
		this.playerName = player;
	}

	public abstract int playSpot() throws IOException;

	public ArrayList<Integer> getEmptySpotsInPlayField() {

		ArrayList<Integer> emptySpots = new ArrayList<>();

		for (int i = 0; i < playField.length; i++) {

			if (playField[i].equals(Config.AIPLAYER) || playField[i].equals(Config.PLAYER1)
					|| playField[i].equals(Config.PLAYER2))
				continue;

			emptySpots.add(i);
		}

		return emptySpots;
	}

	// If one player win or no player win until no slot remain in the playField then return true
	public boolean isGaveOver() {

		if (isWinner()) {
			System.out.println("Winner is " + playerName);
			return true;
		} else if (isTieGame()) {
			System.out.println("Tie Game");
			return true;
		}

		return false;
	}

	public void showPlayField() {

		Double playFieldOneSideCount = Math.sqrt(playField.length);

		for (int i = 0; i < Config.PLAYFIELDSIZE; i++) {
			if (i % playFieldOneSideCount == 0) {
				System.out.println();
			}
			System.out.print(" " + playField[i]);
		}

		System.out.println();
		System.out.println("-----------------------");
	}

	public boolean isTieGame() {

		ArrayList<Integer> emptySpots = getEmptySpotsInPlayField();
		boolean isTie = false;
		if (emptySpots.isEmpty()) {
			isTie =  true;
		}

		return isTie;
	}

	public boolean isWinner() {
		return isWinner(playerName);
	}

	public boolean isWinner(String player) {

		int playFieldLength = playField.length;
		Double playFieldOneSideTemp = Math.sqrt(playFieldLength);
		int playFieldOneSide = playFieldOneSideTemp.intValue();
		
		boolean isWin = false;
		if (isWinComboRowAndColumn(player, playFieldLength, playFieldOneSide)
				|| isWinComboDiagonalLeftToRight(player, playFieldLength, playFieldOneSide)
				|| isWinComboDiagonalRightToLeft(player, playFieldLength, playFieldOneSide)) {
			isWin = true;
		}
		return isWin;
	}

	// Check playerType is at the same column And Row in sequance
	private boolean isWinComboRowAndColumn(String player, int playFieldLength, int playFieldOneSide) {

		boolean isColumnWin = true;
		boolean isRowWin = true;

		int index = 0;

		for (int i = 0; i < playFieldOneSide; i++) {

			// column in sequance
			isColumnWin = true;
			for (int j = i; j < playFieldLength; j = j + playFieldOneSide) {
				if (!playField[j].equals(player)) {
					isColumnWin = false;
				}
			}
			if (isColumnWin) {
				return true;
			}

			// row in sequance
			isRowWin = true;
			for (int j = 0; j < playFieldOneSide; j++) {
				if (!playField[index].equals(player)) {
					isRowWin = false;
				}
				index++;
			}
			if (isRowWin) {
				return true;
			}
		}

		return false;
	}

	// Check playertype is at diagonal in sequance from right to left
	private boolean isWinComboDiagonalRightToLeft(String player, int playFieldLength, int playFieldOneSide) {

		boolean isdiagonalWin = true;

		int counter = 1;
		for (int i = playFieldOneSide - 1; i <= playFieldLength - playFieldOneSide; i = counter
				* (playFieldOneSide - 1)) {

			if (!playField[i].equals(player)) {
				isdiagonalWin = false;
			}
			counter++;
		}

		return isdiagonalWin;
	}

	// Check playertype is at diagonal in sequance from left to right
	private boolean isWinComboDiagonalLeftToRight(String player, int playFieldLength, int playFieldOneSide) {

		boolean isdiagonalWin = true;

		int counter = 0;
		for (int i = playFieldOneSide + 1; i < playFieldLength; i = i * counter) {

			if (!playField[i].equals(player)) {
				isdiagonalWin = false;
			}
			counter++;
		}

		return isdiagonalWin;
	}

}
