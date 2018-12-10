
package com.mehmet.tictactoe;

import java.io.IOException;
import java.util.Random;

public class TicTacToe {

	public static void main(String[] args) throws IOException {

		// Initiate and Instantiate the playField
		String[] playField = new String[Config.PLAYFIELDSIZE];

		for (int i = 0; i < Config.PLAYFIELDSIZE; i++) {
			playField[i] = String.valueOf(i);
		}

		String[] randomPlayerChooseOptions = { Config.AIPLAYER, Config.PLAYER1, Config.PLAYER2 };

		Random random = new Random();

		int selectPlayerIndex = random.nextInt(randomPlayerChooseOptions.length);

		String selectedPlayer = randomPlayerChooseOptions[selectPlayerIndex];

		turnPlayer(selectedPlayer, playField);

	}

	// Change the order of the game play in sequance of player1, player2 and
	// aiPlayer
	public static void turnPlayer(String currentPlayer, String[] playField) throws IOException {

		PlayerFactory playerFactory = new PlayerFactory(playField);
		PlayerBase playerBase = playerFactory.getPlayer("AIPLAYER");

		PlayerBase aiPlayer = playerFactory.getPlayer("AIPLAYER");
		PlayerBase player1 = playerFactory.getPlayer("PLAYER1");
		PlayerBase player2 = playerFactory.getPlayer("PLAYER2");

		for (int i = 0; i < Config.PLAYFIELDSIZE; i++) {

			if (currentPlayer.equals(Config.AIPLAYER)) {
				playerBase = player1;
				player1.playSpot();
				currentPlayer = Config.PLAYER1;
			} else if (currentPlayer.equals(Config.PLAYER1)) {
				playerBase = player2;
				player2.playSpot();
				currentPlayer = Config.PLAYER2;
			} else if (currentPlayer.equals(Config.PLAYER2)) {
				playerBase = aiPlayer;
				aiPlayer.playSpot();
				currentPlayer = Config.AIPLAYER;
			}
			playerBase.showPlayField();

			if (playerBase.isGaveOver()) {
				break;
			}
		}
	}

}
