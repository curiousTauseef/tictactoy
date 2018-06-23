package com.metro.tictactoe.game.config;

/**
 * 
 * configuration holder Use this class to hold game initial data <br/>
 * read from config file<br/>
 * <b>P.S. :</b> if i have option , i would use <b>LOMBOK</b> in creating this
 * class
 *
 */
public class GameInitConfigurations {

	/**
	 * board size varies from 3 to 10
	 */
	private int boardSize;
	/**
	 * terminal player
	 */
	private Character playerOne;
	/**
	 * terminal player
	 */
	private Character playerTwo;
	/**
	 * auto player
	 */
	private Character playerComputer;

	public int getBoardSize() {
		return boardSize;
	}

	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}

	public Character getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(Character playerOne) {
		this.playerOne = playerOne;
	}

	public Character getPlayerTwo() {
		return playerTwo;
	}

	public void setPlayerTwo(Character playerTwo) {
		this.playerTwo = playerTwo;
	}

	public Character getPlayerComputer() {
		return playerComputer;
	}

	public void setPlayerComputer(Character playerComputer) {
		this.playerComputer = playerComputer;
	}

	@Override
	public String toString() {
		return "GameInitConfigurations [boardSize=" + boardSize + ", playerOne=" + playerOne + ", playerTwo="
				+ playerTwo + ", playerComputer=" + playerComputer + "]";
	}

}
