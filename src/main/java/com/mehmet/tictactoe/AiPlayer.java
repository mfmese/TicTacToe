package com.mehmet.tictactoe;

import java.util.ArrayList;

public class AiPlayer extends PlayerBase {

	private String player;
	private String[] playField;

	public AiPlayer(String player, String[] playField) {
		super(playField, player);
		this.player = player;
		this.playField = playField;
	}

	public int playSpot() {

		int spot = getBestSpotForAiPlayer(player).getSpotx();
		playField[Integer.valueOf(spot)] = player;
		System.out.println();
		System.out.println("Config.aiPlayer play for " + player + ": " + spot);
		return Integer.valueOf(spot);
	}

	private Move getBestSpotForAiPlayer(String player) {

		ArrayList<Integer> emptySpots = getEmptySpotsInPlayField();
		ArrayList<Move> moves = new ArrayList<Move>();

		Move move = getBestScoreForAiPlayer(emptySpots);
		if (move.getScore() != -1)
			return move;

		for (int i = 0; i < emptySpots.size(); i++) {
			int emptySpot = Integer.valueOf(emptySpots.get(i));

			move.setSpot(Integer.valueOf(playField[emptySpot]));

			playField[emptySpot] = player;

			if (player == Config.aiPlayer) {
				move.setScore(getBestSpotForAiPlayer(Config.player1).getScore());
			} else if (player == Config.player1) {
				move.setScore(getBestSpotForAiPlayer(Config.player1).getScore());
			} else if (player == Config.player1) {
				move.setScore(getBestSpotForAiPlayer(Config.aiPlayer).getScore());
			}

			playField[emptySpot] = String.valueOf(move.getSpotx());

			if ((player == Config.aiPlayer && move.getScore() == 10)
					|| (player == Config.player1 && move.getScore() == -10)
					|| (player == Config.player1 && move.getScore() == -10))
				return move;
			else
				moves.add(move);
		}

		return getBestMoveForAiPlayer(moves, player);
	}

	private Move getBestScoreForAiPlayer(ArrayList<Integer> emptySpots) {

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

	private Move getBestMoveForAiPlayer(ArrayList<Move> moves, String player) {

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
