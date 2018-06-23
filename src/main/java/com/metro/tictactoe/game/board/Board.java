package com.metro.tictactoe.game.board;

import com.metro.tictactoe.game.manager.GameManager;
import com.metro.tictactoe.game.players.Player;

/**
 * Class representing the game board for handling the data of the Tic-Tac-Toe
 * board.
 * 
 * <pre>
 *   0 1 2
 * 0|x| | |
 *  -------
 * 1| |o| |
 *  -------
 * 2|c| | |
 *  -------
 * </pre>
 */

public class Board implements Cloneable {

	/**
	 * Tic Tac Toe Board
	 */
	private Player[][] board;

	/**
	 * initializing the board size
	 */
	public Board() {
		board = new Player[GameManager.getBoardSize()][GameManager.getBoardSize()];
	}

	/**
	 * Player attempts to make a move.
	 * 
	 * @param player
	 *            Player making the move.
	 * @param position
	 *            Position of the move.
	 * @return Move was valid (successful).
	 */
	public boolean move(Player player, int[] position) {
		// Check if position is already taken.
		if (getPlayerAtGivenPosition(position) == null) {
			// position empty
			return setPlayerAtGivenPosition(player, position);
		} else {
			// position occupied
			return false;
		}
	}

	/**
	 * since the board will be shared among 3 players , original board must be kept
	 * from being changed or modified by any, by providing a copies for that who
	 * will need it
	 */
	@Override
	public Board clone() throws CloneNotSupportedException {
		Board copy = new Board();
		for (int x = 0; x < GameManager.getBoardSize(); x++) {
			for (int y = 0; y < GameManager.getBoardSize(); y++) {
				int[] pos = { x, y };
				Player curr = getPlayerAtGivenPosition(pos);
				copy.move(curr, pos);
			}
		}
		return copy;
	}

	/**
	 * Check if the board is full.
	 * 
	 * @return If the board is full. Therefore, game over.
	 */
	public boolean isFull() {
		boolean full = true;
		for (int x = 0; x < GameManager.getBoardSize(); x++) {
			for (int y = 0; y < GameManager.getBoardSize(); y++) {
				int[] pos = { x, y };
				Player curr = getPlayerAtGivenPosition(pos);
				if (curr == null) {
					full = false;
					break;
				}
			}
			if (!full) {
				break;
			}
		}
		return full;
	}

	/**
	 * Get the player at the given position.
	 * 
	 * @param position
	 *            The X,Y position to inspect a player.
	 * @return Player at the position specified.
	 */
	public Player getPlayerAtGivenPosition(int[] position) {
		if (position[0] < board.length && position[1] < board[position[0]].length) {
			return board[position[0]][position[1]];
		} else {
			return null;
		}
	}

	/**
	 * Set the Player to mark at the position given.
	 * 
	 * @param player
	 *            Player to mark the position specified.
	 * @param position
	 *            The X,Y position to be considered for a certain players area.
	 * @return
	 */
	private boolean setPlayerAtGivenPosition(Player player, int[] position) {
		if (position[0] < board.length && position[1] < board[position[0]].length) {
			board[position[0]][position[1]] = player;
			return true;
		} else {
			return false;
		}
	}
}
