
package com.mehmet.tictactoe;

import java.io.IOException;

public class TicTacToe {

	public static void main(String[] args) throws IOException {		
		
		//Initiate and Instantiate the playField
		String[] playField = new String[Config.playFieldSize];

		for (int i = 0; i < Config.playFieldSize; i++) {
			playField[i] = String.valueOf(i);
		}
		
		turnPlayer(Config.aiPlayer, playField);
		
	}
	
	// Change the order of the game play in sequance of player1, player2 and aiPlayer
		public static void turnPlayer(String currentPlayer, String[] playField) throws IOException {

			PlayerFactory playerFactory = new PlayerFactory(playField);
			PlayerBase playerBase = playerFactory.getPlayer("AIPLAYER");

			for (int i = 0; i < Config.playFieldSize; i++) {

				if (currentPlayer.equals(Config.player2)) {
					playerBase = playerFactory.getPlayer("AIPLAYER");
					playerBase.playSpot();
					currentPlayer = Config.aiPlayer;
				} else if (currentPlayer.equals(Config.player1)) {
					playerBase = playerFactory.getPlayer("PLAYER2");
					 playerBase.playSpot();
					currentPlayer = Config.player2;
				} else if (currentPlayer.equals(Config.aiPlayer)) {
					playerBase = playerFactory.getPlayer("PLAYER1");
					playerBase.playSpot();
					currentPlayer = Config.player1;
				}

				playerBase.showPlayField();

				if (playerBase.isGaveOver()) {
					break;
				}
			}
		}

	

}
