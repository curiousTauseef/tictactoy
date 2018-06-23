package com.metro.tictactoe.game.manager;

import com.metro.tictactoe.game.players.Player;

/**
 * Interface for passing messages from Player to GameManager.
 */

public interface MoveObserver {

	/**
	 * Player makes a move.
	 * 
	 * @param player
	 *            Player who is making the move.
	 * @param position
	 *            Position of the move.
	 * @return Move was valid (successful).
	 */
	Boolean move(Player player, int[] position);

}
