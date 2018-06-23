package com.metro.tictactoe.game.players;

import com.metro.tictactoe.game.board.Board;
import com.metro.tictactoe.game.config.Messages;
import com.metro.tictactoe.game.manager.GameManager;
import com.metro.tictactoe.game.manager.checkers.ComputerMoveChecker;

/**
 * Automated Player Depends on Random Moves on empty slots
 */
public class ComputerPlayer extends Player {

	@Override
	public void makeMove(Board board, GameManager manager) {
		System.out.println(Messages.SEPARATOR);
		System.out.println(Messages.RANDOM_PLAYER_MOVE_INSTRUCTION.replace("randomPlayer",
				manager.getCharacterOfPlayer(this) + ""));
		printBoard(board, manager);

		int[] pos = ComputerMoveChecker.generateMovePosition(this, board, manager);
		Boolean validMove = manager.move(this, pos);
		if (validMove != null) {
			if (validMove) {
				System.out.println(Messages.VALID_MOVE.replace("'valid'", pos[0] + "," + pos[1]));
			} else if (!validMove) {
				System.out.println(Messages.INVALID_MOVE.replace("'valid'", pos[0] + "," + pos[1]));
			}
		}
	}

}
