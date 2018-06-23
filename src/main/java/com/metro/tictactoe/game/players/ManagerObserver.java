package com.metro.tictactoe.game.players;

import com.metro.tictactoe.game.board.Board;
import com.metro.tictactoe.game.manager.GameManager;

/**
 * Interface for passing messages from Engine to Player.
 */
public interface ManagerObserver {
	/**
	 * Notify the Player that it is their turn to make a move.
	 * 
	 * @param board
	 *            The game Board.
	 * @param engine
	 *            The game Engine.
	 */
	void makeMove(Board board, GameManager engine);

	/**
	 * Notify the Player that they have won.
	 * 
	 * @param board
	 *            The game Board.
	 * @param engine
	 *            The game Engine.
	 */
	void wonGame(Board board, GameManager engine);

}
