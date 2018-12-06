package com.mehmet.tictactoe;

import java.util.ArrayList;

public class AiPlayer extends PlayerBase {

	private String playerType;
	private String[] playField;

	public AiPlayer(String playerType, String[] playField) {
		super(playField, playerType);
		this.playerType = playerType;
		this.playField = playField;
	}

	public int playSpot() {

		int spot = getBestSpot(playerType).getIndex();
		playField[Integer.valueOf(spot)] = playerType;
		System.out.println();
		System.out.println("Config.aiPlayer play for " + playerType + ": " + spot);
		return Integer.valueOf(spot);
	}

	private Move getBestSpot(String player) {

		ArrayList<Integer> emptySpots = getEmptySpotsInPlayField();
		ArrayList<Move> moves = new ArrayList<Move>();

		// Get the best Score for Config.aiPlayer
		Move move = getBestScore(emptySpots);
		if (move.getScore() != -1)
			return move;

		for (int i = 0; i < emptySpots.size(); i++) {
			int emptySpot = Integer.valueOf(emptySpots.get(i));

			move.setIndex(Integer.valueOf(playField[emptySpot]));

			playField[emptySpot] = player;

			if (player == Config.aiPlayer) {
				move.setScore(getBestSpot(Config.player1).getScore());
			} else if (player == Config.player1) {
				move.setScore(getBestSpot(Config.player1).getScore());
			} else if (player == Config.player1) {
				move.setScore(getBestSpot(Config.aiPlayer).getScore());
			}

			playField[emptySpot] = String.valueOf(move.getIndex());

			if ((player == Config.aiPlayer && move.getScore() == 10)
					|| (player == Config.player1 && move.getScore() == -10)
					|| (player == Config.player1 && move.getScore() == -10))
				return move;
			else
				moves.add(move);
		}

		return getBestMove(moves, player);
	}

	private Move getBestScore(ArrayList<Integer> emptySpots) {

		Move move = new Move();
		move.setScore(-1);

		if (isWinner(Config.player1) || isWinner(Config.player2))
			move.setScore(-10);
		else if (isWinner(Config.aiPlayer))
			move.setScore(10);
		else if (emptySpots.isEmpty())
			move.setScore(0);

		return move;
	}

	private Move getBestMove(ArrayList<Move> moves, String player) {

		int bestScore = moves.get(0).getScore();
		int bestMove = 0;

		for (int i = 0; i < moves.size(); i++) {
			if (player == Config.aiPlayer) {
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
