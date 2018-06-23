package com.metro.tictactoe.game.players;

import com.metro.tictactoe.game.board.Board;
import com.metro.tictactoe.game.config.Messages;
import com.metro.tictactoe.game.manager.GameManager;
import com.metro.tictactoe.game.manager.checkers.ConsoleTableFormer;

/**
 * Abstract Player class. To be subclassed into specific implementations of
 * Players(Human and Computer) for the game.
 */
public abstract class Player implements ManagerObserver {

	/**
	 * Common method among players,<br/>
	 * used to print board with every game turn
	 * 
	 * @param board
	 * @param engine
	 */
	protected void printBoard(Board board, GameManager engine) {

		ConsoleTableFormer.printXHeader();
		ConsoleTableFormer.printYHeader(board, engine);

	}

	/**
	 * Announce the winner
	 */
	@Override
	public void wonGame(Board board, GameManager engine) {
		System.out.println(Messages.SEPARATOR);
		System.out.println(Messages.PLAYER_WIN.replace("[player]", engine.getCharacterOfPlayer(this) + ""));
		printBoard(board, engine);
	}

}
