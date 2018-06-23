package com.metro.tictactoe.game.players;

import java.util.Scanner;

import com.metro.tictactoe.game.board.Board;
import com.metro.tictactoe.game.config.Messages;
import com.metro.tictactoe.game.manager.GameManager;

/**
 * Human Player , moves via terminal/commandline Depending on the real players
 * choices and decisions.
 */
public class HumanPlayer extends Player {

	private Scanner in;

	/**
	 * Constructor
	 */
	public HumanPlayer() {
		in = new Scanner(System.in);
	}

	/**
	 * Take the input from Player , validate it and then update the board if the
	 * move is valid, otherwise warn the invalid game and ask the player to replay
	 */
	@Override
	public void makeMove(Board board, GameManager engine) {
		System.out.println(Messages.SEPARATOR);
		System.out.println(Messages.PLAYER_MOVE_INSTRUCTION.replace("player", engine.getCharacterOfPlayer(this) + ""));

		printBoard(board, engine);

		// Prompt user for input
		// input must be in format digit,digit
		System.out.print(Messages.INPUT_NOTIFICATION);
		String point = in.next().replaceAll(" ", "");
		// validating input against digit,digit pattern
		if (point.matches("^\\d(,[\\d])$")) {
			String[] parts = point.split(",");

			int[] pos = new int[] { Integer.parseInt(parts[0]), Integer.parseInt(parts[1]) };
			Boolean validMove = engine.move(this, pos);
			if (validMove != null) {
				if (validMove) {
					System.out.println(Messages.VALID_MOVE.replace("'valid'", pos[0] + "," + pos[1]));
				} else if (!validMove) {
					System.out.println(Messages.INVALID_MOVE.replace("'valid'", pos[0] + "," + pos[1]));
				}
			}
		} else {
			System.out.println(Messages.INVALID_INPUT.replace("'point'", point));
			makeMove(board, engine);
		}

	}

}
