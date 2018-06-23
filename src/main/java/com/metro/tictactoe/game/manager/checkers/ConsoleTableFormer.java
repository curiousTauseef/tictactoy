package com.metro.tictactoe.game.manager.checkers;

import java.util.stream.IntStream;

import com.metro.tictactoe.game.board.Board;
import com.metro.tictactoe.game.config.Messages;
import com.metro.tictactoe.game.manager.GameManager;
import com.metro.tictactoe.game.players.Player;

/**
 * consider it as decorator class,used to draw the table everytime is needed
 * 
 * @author lenovo
 *
 */
public class ConsoleTableFormer {

	/**
	 * Printing the X Header of the board<br/>
	 * 
	 * <pre>
	 *           X
	 *       0|1|2|3|...
	 * </pre>
	 */
	public static void printXHeader() {

		System.out.format("%" + GameManager.getBoardSize() + "S", " ");

		StringBuilder col = new StringBuilder();

		System.out.println(Messages.boardHeader);

		IntStream.range(0, GameManager.getBoardSize()).forEach(x -> {
			col.append(String.valueOf(x));
			if (x < GameManager.getBoardSize() - 1)
				col.append("|");
		});
		System.out.println("    " + col);
	}

	/**
	 * Printing Y side header of the board
	 * 
	 * <pre>
	 *   0|
	 * Y 1|
	 *   2|
	 *   ...
	 * </pre>
	 * 
	 * @param board
	 * @param engine
	 */
	public static void printYHeader(Board board, GameManager engine) {
		StringBuilder vertical = new StringBuilder();

		IntStream.range(0, GameManager.getBoardSize()).forEach(y -> {
			if (y == GameManager.getBoardSize() / 2) {
				vertical.append(Messages.boardLabel);
			} else {
				vertical.append(" ");
			}
			vertical.append(" " + y);

			IntStream.range(0, GameManager.getBoardSize()).forEach(x -> {
				int[] pos = { x, y };
				Player curr = board.getPlayerAtGivenPosition(pos);
				vertical.append("|" + engine.getCharacterOfPlayer(curr));

			});
			vertical.append("\n");
		});
		System.out.println(vertical.toString());
	}
}
