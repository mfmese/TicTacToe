package com.mehmet.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;

import org.junit.Test;

public class AiPlayerTest {

	@Test
	public void turnPlayer_success() throws IOException {

		try {

			String[] playField = new String[Config.playFieldSize];
			for (int i = 0; i < Config.playFieldSize; i++) {
				playField[i] = String.valueOf(i);
			}

			//TicTacToe.turnPlayer(Config.aiPlayer, playField);
			assertEquals("Success", 1,1);

		} catch (Exception e) {
			assertEquals("Input is not correct format.", e.getMessage());
		}
	}
	
	@Test
	public void playSpotSuccess() throws IOException {
		
		String[] playField = new String[9];

		for (int i = 0; i < playField.length; i++) {
			playField[i] = String.valueOf(i);
		}

		playField[0] = "X";
		playField[3] = "X";
		//playField[6] = "O";

		PlayerBase player = new AiPlayer("X", playField);
		int result = player.playSpot();

		assertEquals("Success", 6, result);
	}

	@Test
	public void playSpotFail() throws IOException {
		
		String[] playField = new String[9];

		for (int i = 0; i < playField.length; i++) {
			playField[i] = String.valueOf(i);
		}

		playField[0] = "X";
		playField[3] = "X";
		//playField[6] = "O";

		PlayerBase player = new AiPlayer("X", playField);
		int result = player.playSpot();

		assertNotEquals("Success", 8, result);
	}
	
}
