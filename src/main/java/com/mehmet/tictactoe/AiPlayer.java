package com.mehmet.tictactoe;

import java.util.ArrayList;

public class AiPlayer extends PlayerBase {

	public AiPlayer(String player, String[] playField) {
		super(playField, player);
	}

	public int playSpot() {

		int spot = getBestSpotForAiPlayer(playerName).getSpot();
		playField[Integer.valueOf(spot)] = playerName;
		System.out.println();
		System.out.println("Config.aiPlayer play for " + playerName + ": " + spot);
		return Integer.valueOf(spot);
	}

	private Move getBestSpotForAiPlayer(String player) {

		ArrayList<Integer> emptySpots = getEmptySpotsInPlayField();
		ArrayList<Move> moves = new ArrayList<>();

		Move move = getBestScoreForAiPlayer(emptySpots);
		if (move.getScore() != -1)
			return move;

		for (int i = 0; i < emptySpots.size(); i++) {
			int emptySpot = emptySpots.get(i);

			move.setSpot(Integer.valueOf(playField[emptySpot]));

			playField[emptySpot] = player;

			if (player == Config.AIPLAYER) {
				move.setScore(getBestSpotForAiPlayer(Config.PLAYER1).getScore());
			} else if (player == Config.PLAYER1) {
				move.setScore(getBestSpotForAiPlayer(Config.PLAYER2).getScore());
			} else if (player == Config.PLAYER2) {
				move.setScore(getBestSpotForAiPlayer(Config.AIPLAYER).getScore());
			}

			playField[emptySpot] = String.valueOf(move.getSpot());

			if ((player == Config.AIPLAYER && move.getScore() == 10)
					|| (player == Config.PLAYER1 && move.getScore() == -10)
					|| (player == Config.PLAYER2 && move.getScore() == -10))
				return move;
			else
				moves.add(move);
		}

		return getBestMoveForAiPlayer(moves, player);
	}

	private Move getBestScoreForAiPlayer(ArrayList<Integer> emptySpots) {

		Move move = new Move();
		move.setScore(-1);

		if (isWinner(Config.PLAYER1) || isWinner(Config.PLAYER2))
			move.setScore(-10);
		else if (isWinner(Config.AIPLAYER))
			move.setScore(10);
		else if (emptySpots.isEmpty())
			move.setScore(0);

		return move;
	}

	private Move getBestMoveForAiPlayer(ArrayList<Move> moves, String player) {

		int bestScore = moves.get(0).getScore();
		int bestMove = 0;

		for (int i = 0; i < moves.size(); i++) {
			if (player == Config.AIPLAYER) {
				if (moves.get(i).getScore() > bestScore) {
					bestScore = moves.get(i).getScore();
					bestMove = i;
				}
			} else {
				if (moves.get(i).getScore() < bestScore) {
					bestScore = moves.get(i).getScore();
					bestMove = i;
				}
			}
		}
		return moves.get(bestMove);
	}
}
