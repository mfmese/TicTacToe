package com.mehmet.tictactoe;

import java.io.IOException;
import java.util.ArrayList;

public abstract class PlayerBase {

	private String[] playField;
	private String player;

	public PlayerBase() {

	}

	public PlayerBase(String[] playField, String player) {
		this.playField = playField;
		this.player = player;
	}

	public abstract int playSpot() throws IOException;

	public ArrayList<Integer> getEmptySpotsInPlayField() {

		ArrayList<Integer> emptySpots = new ArrayList<Integer>();

		for (int i = 0; i < playField.length; i++) {

			if (playField[i].equals(Config.aiPlayer) || playField[i].equals(Config.player1)
					|| playField[i].equals(Config.player2))
				continue;

			emptySpots.add(i);
		}

		return emptySpots;
	}

	// If one player win or no player win until no slot remain in the playField then return true
	public boolean isGaveOver() {

		if (isWinner()) {
			System.out.println("Winner is " + player);
			return true;
		} else if (isTieGame()) {
			System.out.println("Tie Game");
			return true;
		}

		return false;
	}

	public void showPlayField() {

		Double playFieldOneSideCount = Math.sqrt(Double.valueOf(playField.length));

		for (int i = 0; i < Config.playFieldSize; i++) {
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
		if (emptySpots.isEmpty()) {
			return true;
		}

		return false;
	}

	public boolean isWinner() {
		return isWinner(player);
	}

	public boolean isWinner(String player) {

		int playFieldLength = playField.length;
		Double playFieldOneSideTemp = Math.sqrt(Double.valueOf(playFieldLength));
		int playFieldOneSide = playFieldOneSideTemp.intValue();
		
		if (isWinComboRowAndColumn(player, playFieldLength, playFieldOneSide)) {
			return true;
		}

		if (isWinComboDiagonalLeftToRight(player, playFieldLength, playFieldOneSide)) {
			return true;
		}

		if (isWinComboDiagonalRightToLeft(player, playFieldLength, playFieldOneSide)) {
			return true;
		}

		return false;
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
