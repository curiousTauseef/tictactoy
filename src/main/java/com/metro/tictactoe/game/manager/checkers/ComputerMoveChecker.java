package com.metro.tictactoe.game.manager.checkers;

import com.metro.tictactoe.game.board.Board;
import com.metro.tictactoe.game.manager.GameManager;
import com.metro.tictactoe.game.players.ComputerPlayer;

/**
 * 
 * Class act like utilities for computer moves
 *
 */
public class ComputerMoveChecker {

	/**
	 * generate random move position for computer as a player
	 * 
	 * @param player
	 * @param board
	 * @param engine
	 * @return the generated point
	 */
	public static int[] generateMovePosition(ComputerPlayer player, Board board, GameManager engine) {
		boolean validMove = false;
		int[] pos;
		// generate random position and be sure that it is valid(not equipied) , if not
		// it regenerate again
		do {
			// Generate move position
			pos = new int[] { generateRandomPosition(), generateRandomPosition() };
			// move
			validMove = board.move(player, pos);
		} // Check if move was valid.
		while (!validMove);
		// Move generated should be valid.
		return pos;
	}

	/**
	 * @return the randomly generated position
	 */
	private static int generateRandomPosition() {
		int randomNum = HelperUtils.generateRandomNumber(GameManager.getBoardSize());
		return randomNum;
	}

}