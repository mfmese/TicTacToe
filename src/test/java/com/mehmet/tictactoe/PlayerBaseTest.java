package com.mehmet.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class PlayerBaseTest {

	@Test
	public void isWinnerRowSequanceSuccess() {

		String[] playField = new String[9];

		for (int i = 0; i < playField.length; i++) {
			playField[i] = String.valueOf(i);
		}

		playField[0] = "O";
		playField[1] = "O";
		playField[2] = "O";

		PlayerBase player = new AiPlayer("O", playField);
		boolean result = player.isWinner();

		assertTrue("Success", result);
	}
	
	@Test
	public void isWinnerRowSequance5X5Success() {

		String[] playField = new String[25];

		for (int i = 0; i < playField.length; i++) {
			playField[i] = String.valueOf(i);
		}

		playField[0] = "O";
		playField[1] = "O";
		playField[2] = "O";
		playField[3] = "O";
		playField[4] = "O";

		PlayerBase player = new AiPlayer("O", playField);
		boolean result = player.isWinner();

		assertTrue("Success", result);
	}

	@Test
	public void isWinnerColumnSequanceSuccess() {

		String[] playField = new String[9];

		for (int i = 0; i < playField.length; i++) {
			playField[i] = String.valueOf(i);
		}

		playField[0] = "O";
		playField[3] = "O";
		playField[6] = "O";

		PlayerBase player = new AiPlayer("O", playField);
		boolean result = player.isWinner();

		assertTrue("Success", result);
	}
	
	@Test
	public void isWinnerDiagonalRightToLeftSuccess() {

		String[] playField = new String[9];

		for (int i = 0; i < playField.length; i++) {
			playField[i] = String.valueOf(i);
		}

		playField[2] = "O";
		playField[4] = "O";
		playField[6] = "O";

		PlayerBase player = new AiPlayer("O", playField);
		boolean result = player.isWinner();

		assertTrue("Success", result);
	}
	
	@Test
	public void isWinnerDiagonalRightToLeft5X5Success() {

		String[] playField = new String[25];

		for (int i = 0; i < playField.length; i++) {
			playField[i] = String.valueOf(i);
		}

		playField[4] = "O";
		playField[8] = "O";
		playField[12] = "O";
		playField[16] = "O";
		playField[20] = "O";

		PlayerBase player = new AiPlayer("O", playField);
		boolean result = player.isWinner();

		assertTrue("Success", result);
	}
	
	@Test
	public void isWinnerDiagonalLeftToRightSuccess() {

		String[] playField = new String[9];

		for (int i = 0; i < playField.length; i++) {
			playField[i] = String.valueOf(i);
		}

		playField[0] = "O";
		playField[4] = "O";
		playField[8] = "O";

		PlayerBase player = new AiPlayer("O", playField);
		boolean result = player.isWinner();

		assertTrue("Success", result);
	}
	
	@Test
	public void isWinnerRowSequanceSuccessFail() {

		String[] playField = new String[9];

		for (int i = 0; i < playField.length; i++) {
			playField[i] = String.valueOf(i);
		}

		playField[0] = "O";
		playField[1] = "O";
		playField[2] = "X";

		PlayerBase player = new AiPlayer("O", playField);
		boolean result = player.isWinner();

		assertFalse("Success", result);
	}

	@Test
	public void isWinnerColumnSequanceSuccessFail() {

		String[] playField = new String[9];

		for (int i = 0; i < playField.length; i++) {
			playField[i] = String.valueOf(i);
		}

		playField[0] = "O";
		playField[3] = "X";
		playField[6] = "O";

		PlayerBase player = new AiPlayer("O", playField);
		boolean result = player.isWinner();

		assertFalse("Success", result);
	}
	
	@Test
	public void isWinnerDiagonalLeftToRightFail() {

		String[] playField = new String[9];

		for (int i = 0; i < playField.length; i++) {
			playField[i] = String.valueOf(i);
		}

		playField[0] = "O";
		playField[4] = "O";
		playField[8] = "X";

		PlayerBase player = new AiPlayer("O", playField);
		boolean result = player.isWinner();

		assertFalse("Success", result);
	}
	
	@Test
	public void isWinnerDiagonalRightToLeftFail() {

		String[] playField = new String[9];

		for (int i = 0; i < playField.length; i++) {
			playField[i] = String.valueOf(i);
		}

		playField[2] = "O";
		playField[4] = "O";
		playField[6] = "X";

		PlayerBase player = new AiPlayer("O", playField);
		boolean result = player.isWinner();

		assertFalse("Success", result);
	}
	
	@Test
	public void isGameOverSuccess() throws IOException {

		String[] playField = new String[9];

		for (int i = 0; i < playField.length; i++) {
			playField[i] = String.valueOf(i);
		}

		playField[2] = "O";
		playField[4] = "O";

		Player player = new Player("O", playField);
		player.playSpot(6);
		boolean result = player.isGaveOver();

		assertTrue("Success", result);
	}
	
	@Test
	public void  isTieGameFalse() {

		String[] playField = new String[9];

		for (int i = 0; i < playField.length; i++) {
			playField[i] = String.valueOf(i);
		}

		playField[2] = "O";
		playField[4] = "O";

		Player player = new Player("O", playField);
		player.playSpot(6);
		boolean result = player.isTieGame();

		assertFalse("Success", result);
	}
}
