package com.mehmet.tictactoe;

public class PlayerFactory {

	String[] playField;

	public PlayerFactory(String[] playField) {
		this.playField = playField;
	}

	public PlayerBase getPlayer(String playerType) {

		switch (playerType) {
		case "PLAYER1":
			return new Player(Config.player1, playField);
		case "PLAYER2":
			return new Player(Config.player2, playField);
		case "AIPLAYER":
			return new AiPlayer(Config.aiPlayer, playField);
		default:
			return null;
		}
	}
}
