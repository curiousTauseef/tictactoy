package com.metro.tictactoe.game.manager.checkers;

import com.metro.tictactoe.game.board.Board;
import com.metro.tictactoe.game.enums.BoardWinnerPositions;
import com.metro.tictactoe.game.manager.GameManager;
import com.metro.tictactoe.game.players.Player;

/**
 * 
 * Class to check if their is a winner with each game (horizontal,vertical,left
 * diagonal and right diagonal), if yes it return it
 *
 */
public class WinnerChecker {
	/**
	 * find our if their is a winner
	 * 
	 * @param position
	 *            -enum to specify search position
	 * @param engine
	 * @return winner or null(no winner)
	 */
	public static Player checkTheWinner(BoardWinnerPositions position, GameManager engine) {
		Board board = engine.getBoard();
		// search horizontally
		if (position == BoardWinnerPositions.HORIZONTAL) {
			return checkWinnerFromHorizontalPosition(board);
		}
		// search vertically
		else if (position == BoardWinnerPositions.VERTICAL) {
			return checkWinnerFromVerticalPlayer(board);
		}
		// search left diagonal
		else if (position == BoardWinnerPositions.LEFT_DIAGONAL) {
			return CheckWinnerFromLeftDiagonal(board);
		}
		// search right diagonal
		else if (position == BoardWinnerPositions.RIGHT_DIAGONAL) {
			return checkWinnerFromRightDiagonal(board);
		}

		return null;
	}

	/**
	 * checking if their is a winner vertically
	 * 
	 * @param board
	 * @return the winner or null(no winner)
	 */
	private static Player checkWinnerFromVerticalPlayer(Board board) {
		for (int x = 0; x < GameManager.getBoardSize(); x++) {

			boolean result = false;
			for (int y = 0; y < GameManager.getBoardSize(); y++) {
				if (y < GameManager.getBoardSize() - 1) {
					if ((board.getPlayerAtGivenPosition(new int[] { x, y }) != null
							&& board.getPlayerAtGivenPosition(new int[] { x, y + 1 }) != null)
							&& board.getPlayerAtGivenPosition(new int[] { x, y }) == board
									.getPlayerAtGivenPosition(new int[] { x, y + 1 })) {
						result = true;
					} else {
						result = false;
						break;
					}
				}
			}
			if (result) {
				return board.getPlayerAtGivenPosition(new int[] { x, 0 });
			}
		}
		return null;
	}

	/**
	 * checking if their is a winner horizontally
	 * 
	 * @param board
	 * @return the winner or null(no winner)
	 */

	private static Player checkWinnerFromHorizontalPosition(Board board) {
		for (int y = 0; y < GameManager.getBoardSize(); y++) {

			boolean result = false;
			for (int x = 0; x < GameManager.getBoardSize(); x++) {
				if (x < GameManager.getBoardSize() - 1) {
					if ((board.getPlayerAtGivenPosition(new int[] { x, y }) != null
							&& board.getPlayerAtGivenPosition(new int[] { x + 1, y }) != null)
							&& board.getPlayerAtGivenPosition(new int[] { x, y }) == board
									.getPlayerAtGivenPosition(new int[] { x + 1, y })) {
						result = true;
					} else {
						result = false;
						break;
					}
				}
			}
			if (result) {
				return board.getPlayerAtGivenPosition(new int[] { 0, y });
			}
		}
		return null;
	}

	/**
	 * checking if their is a winner right diagonal
	 * 
	 * @param board
	 * @return the winner or null(no winner)
	 */
	private static Player checkWinnerFromRightDiagonal(Board board) {
		boolean diag = false;
		for (int i = GameManager.getBoardSize() - 1; i > 0; i--) {

			if ((board.getPlayerAtGivenPosition(new int[] { i, (GameManager.getBoardSize() - 1) - i }) != null
					&& board.getPlayerAtGivenPosition(new int[] { i - 1, (GameManager.getBoardSize() - i) }) != null)
					&& board.getPlayerAtGivenPosition(new int[] { i, (GameManager.getBoardSize() - 1) - i }) == board
							.getPlayerAtGivenPosition(new int[] { i - 1, (GameManager.getBoardSize() - i) })) {
				diag = true;
			} else {
				diag = false;
				break;
			}

		}

		if (diag) {
			return board.getPlayerAtGivenPosition(new int[] { GameManager.getBoardSize() - 1, 0 });
		}
		return null;
	}

	/**
	 * checking if their is a winner left diagonal
	 * 
	 * @param board
	 * @return the winner or null(no winner)
	 */
	private static Player CheckWinnerFromLeftDiagonal(Board board) {
		boolean diag = false;
		for (int i = 0; i < GameManager.getBoardSize(); i++) {
			if (i < GameManager.getBoardSize() - 1) {
				if ((board.getPlayerAtGivenPosition(new int[] { i, i }) != null
						&& board.getPlayerAtGivenPosition(new int[] { i + 1, i + 1 }) != null)
						&& board.getPlayerAtGivenPosition(new int[] { i, i }) == board
								.getPlayerAtGivenPosition(new int[] { i + 1, i + 1 })) {
					diag = true;
				} else {
					diag = false;
					break;
				}
			}
		}

		if (diag) {
			return board.getPlayerAtGivenPosition(new int[] { 0, 0 });
		}
		return null;
	}
}
