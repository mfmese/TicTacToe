package com.mehmet.tictactoe;

import java.io.IOException;
import java.util.ArrayList;

public abstract class PlayerBase {

	private String[] playField;
	private String playerType;

	public PlayerBase() {

	}

	public PlayerBase(String[] playField, String playerType) {
		this.playField = playField;
		this.playerType = playerType;
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

		boolean isWinner = false;
		boolean isTie = false;

		isWinner = isWinner();
		if (isWinner)
			System.out.println("Winner is " + playerType);

		isTie = isTieGame();
		if (isTie)
			System.out.println("Tie Game");

		return isWinner || isTie;
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
		return isWinner(playerType);
	}
	
	public boolean isWinner(String playerType) {

		if (isWinComboRowAndColumn(playerType)) {
			return true;
		}

		if (isWinComboDiagonalLeftToRight(playerType)) {
			return true;
		}

		if (isWinComboDiagonalRightToLeft(playerType)) {
			return true;
		}

		return false;
	}

	// Check playerType is at the same column And Row in sequance
	private boolean isWinComboRowAndColumn(String playerType) {

		int playFieldSizeTotal = playField.length;
		Double playFieldOneSideTemp = Math.sqrt(Double.valueOf(playFieldSizeTotal));
		int playFieldOneSide = playFieldOneSideTemp.intValue();

		boolean isColumnWin = true;
		boolean isRowWin = true;

		int index = 0;

		for (int i = 0; i < playFieldOneSide; i++) {

			// column in sequance
			isColumnWin = true;
			for (int j = i; j < playFieldSizeTotal; j = j + playFieldOneSide) {
				if (!playField[j].equals(playerType)) {
					isColumnWin = false;
				}
			}
			if (isColumnWin) {
				return true;
			}

			// row in sequance
			isRowWin = true;
			for (int j = 0; j < playFieldOneSide; j++) {
				if (!playField[index].equals(playerType)) {
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
	private boolean isWinComboDiagonalRightToLeft(String playerType) {

		int playFieldSizeTotal = playField.length;
		Double playFieldOneSideTemp = Math.sqrt(Double.valueOf(playFieldSizeTotal));
		int playFieldOneSide = playFieldOneSideTemp.intValue();
		boolean isdiagonalWin = true;

		int counter = 1;
		for (int i = playFieldOneSide - 1 ; i <= playFieldSizeTotal - playFieldOneSide; i = counter * (playFieldOneSide - 1)) {

			if (!playField[i].equals(playerType)) {
				isdiagonalWin = false;
			}
			counter++;
		}

		return isdiagonalWin;
	}

	// Check playertype is at diagonal in sequance from left to right
	private boolean isWinComboDiagonalLeftToRight(String playerType) {

		int playFieldSizeTotal = playField.length;
		Double playFieldOneSideTemp = Math.sqrt(Double.valueOf(playFieldSizeTotal));
		int playFieldOneSide = playFieldOneSideTemp.intValue();
		boolean isdiagonalWin = true;

		int counter = 0;
		for (int i = playFieldOneSide + 1; i < playFieldSizeTotal; i = i * counter) {

			if (!playField[i].equals(playerType)) {
				isdiagonalWin = false;
			}			
			counter++;
		}

		return isdiagonalWin;
	}

}
