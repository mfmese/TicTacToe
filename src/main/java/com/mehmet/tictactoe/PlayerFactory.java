package com.mehmet.tictactoe;

public class PlayerFactory {

	String[] playField;

	public PlayerFactory(String[] playField) {
		this.playField = playField;
	}

	public PlayerBase getPlayer(String playerType) {

		switch (playerType) {
		case "PLAYER1":
			return new Player(Config.PLAYER1, playField);
		case "PLAYER2":
			return new Player(Config.PLAYER2, playField);
		case "AIPLAYER":
			return new AiPlayer(Config.AIPLAYER, playField);
		default:
			return null;
		}
	}
}
