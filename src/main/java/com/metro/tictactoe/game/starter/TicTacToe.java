package com.metro.tictactoe.game.starter;

import com.metro.tictactoe.game.manager.GameManager;

/**
 * Main class that creates the Tic-Tac-Toe game.<br/>
 * You need to run this class to start the game
 */
public class TicTacToe {

	/**
	 * Game Starting main method
	 */
	public static void main(String[] args) {
		// initialize the game necessary data
		GameManager engine = GameManager.getInstance();
		// start the game
		engine.play();

	}

}
