package com.metro.tictactoe.game.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.metro.tictactoe.game.board.Board;
import com.metro.tictactoe.game.config.GameConfigurationLoader;
import com.metro.tictactoe.game.config.GameInitConfigurations;
import com.metro.tictactoe.game.config.Messages;
import com.metro.tictactoe.game.enums.BoardWinnerPositions;
import com.metro.tictactoe.game.enums.PlayersType;
import com.metro.tictactoe.game.manager.checkers.HelperUtils;
import com.metro.tictactoe.game.manager.checkers.WinnerChecker;
import com.metro.tictactoe.game.players.Player;
import com.metro.tictactoe.game.players.PlayerFactory;

/**
 * This is the Game Starter class that start of the Tic-Tac-Toe 2 game.<br/>
 * <b>P.S.</b> their must be only one instance of this class
 */
public class GameManager implements MoveObserver {

	private static final Logger LOG = Logger.getLogger(GameManager.class.getName());
	private static GameManager manager;
	private GameInitConfigurations configLoader;
	private ArrayList<Player> players;
	private Board board;
	private Player currentPlayer;
	private static int boardSize;

	/**
	 * Constructor. Initializes the ArrayList of players.
	 */
	private GameManager(String filePath) {
		// prepare players list
		preparePlayerList();
		// load board size , players' letters
		configLoader = GameConfigurationLoader.load(filePath);
		/*
		 * defined it globally because it will be needed and scattered along the game
		 * life, can be accessed through it's getter
		 */
		boardSize = configLoader.getBoardSize();
		// initialize gameBoard
		board = new Board();
		LOG.info(Messages.INITIAL_DATA_LOADED);
	}

	/**
	 * get the only instance of the game
	 */
	public static GameManager getInstance() {

		if (manager == null) {
			manager = new GameManager(Messages.FILE_PATH);
		}
		return manager;

	}

	/**
	 * players list
	 */
	private void preparePlayerList() {
		players = new ArrayList<Player>();
		players.add(PlayerFactory.getPlayer(PlayersType.HUMAN));
		players.add(PlayerFactory.getPlayer(PlayersType.HUMAN));
		players.add(PlayerFactory.getPlayer(PlayersType.COMPUTER));
	}

	/**
	 * Start the game
	 */
	public void play() {

		// Display game starting message
		System.out.println(Messages.START_GAME);

		// choosing first player randomly
		int randomNum = HelperUtils.generateRandomNumber(Messages.NUMBER_OF_PLAYERS);
		currentPlayer = players.get(randomNum);

		// displaying sign of the randomly chosen player
		System.out.println(Messages.SEPARATOR_2);

		// prompt nominated player to make the move
		System.out
				.println(Messages.CURRENT_PLAYER_NUMBER.replace("[symbol]", getCharacterOfPlayer(currentPlayer) + ""));
		System.out.println(Messages.SEPARATOR_2);

		promptPlayerForMove();
	}

	/**
	 * End the current game and disable further moves by players.
	 */
	public void endGame(String loserMessage) {
		System.out.println(Messages.SEPARATOR);
		System.out.println(loserMessage);
		System.out.println(Messages.SEPARATOR);
		players = null;
	}

	/**
	 * prompt current player to move
	 */
	private void promptPlayerForMove() {
		// has to be final to be used inside inner class
		final GameManager engine = this;
		Runnable myRunnable = new Runnable() {
			public void run() {
				// remember that current player can be command/computer so it announce the
				// chosen to make his move according to his type
				try {
					currentPlayer.makeMove(board.clone(), engine);
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(myRunnable).start();
	}

	/**
	 * Get the Engine's Board.
	 * 
	 * @return The Engine's Board.
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Get the losing player, if there is one.
	 * 
	 * @return Losing player. `null` is there is currently not a loser.
	 */
	public List<Player> getLosers() {
		Player winner = getWinner();
		List<Player> losers = new ArrayList<>();
		for (Player player : players) {
			if (player != winner) {
				losers.add(player);
			}
		}
		return losers;
	}

	/**
	 * Get the winning player, if there is one.
	 * 
	 * @return The Winning or `null` is there is no winner yet.
	 */
	public Player getWinner() {
		Player player = null;

		BoardWinnerPositions[] positions = BoardWinnerPositions.values();
		for (BoardWinnerPositions boardWinnerPositions : positions) {
			player = WinnerChecker.checkTheWinner(boardWinnerPositions, this);
			if (player != null) {
				return player;
			}
		}
		return player;
	}

	/**
	 * Get the letter being used on the Board for the player.
	 * 
	 * @param player
	 *            The player to retrieve the letter for.
	 * @return The letter for the player.
	 */
	public char getCharacterOfPlayer(Player player) {
		int idx = getIndexOfPlayer(player);
		if (idx == -1) {
			return ' ';
		} else if (idx == 0) {
			return configLoader.getPlayerOne();
		} else if (idx == 1) {
			return configLoader.getPlayerTwo();
		} else {
			return configLoader.getPlayerComputer();
		}
	}

	/**
	 * invoked by players to check on actions
	 */
	@Override
	public Boolean move(Player player, int[] position) {
		// Make the move
		boolean validMove = board.move(player, position);
		// Check if there are any winners
		Player winner = getWinner();

		if (winner != null) {
			winner.wonGame(board, this);
			List<Player> losers = getLosers();
			String losersMsg = getCharacterOfPlayer(losers.get(0)) + " & " + getCharacterOfPlayer(losers.get(1))
					+ Messages.LOSERS_MSG;

			endGame(losersMsg);
			return null;
		}
		// Check if the board is full
		else if (board.isFull()) {
			// Game over
			endGame(Messages.BOARD_FULL_DRAW);
			return null;
		}
		// Check if player's move was successful.
		if (validMove) {
			// Player's move was valid. call for next player.
			currentPlayer = getNextPlayer(currentPlayer);
		}
		promptPlayerForMove();
		return validMove;
	}

	/**
	 * Getting index of certain Player
	 * 
	 * @param player
	 * @return index of the player
	 */
	private int getIndexOfPlayer(Player player) {
		int idx = players.indexOf(player);
		return idx;
	}

	/**
	 * Getting next player in turn
	 * 
	 * @param player
	 * @return
	 */
	private Player getNextPlayer(Player player) {
		int nextIndex = getIndexOfNextPlayer(player);
		if (nextIndex > -1) {
			Player next = players.get(nextIndex);
			return next;
		} else {
			return null;
		}
	}

	/**
	 * Getting index of next player
	 * 
	 * @param player
	 * @return
	 */
	private int getIndexOfNextPlayer(Player player) {
		int idx = getIndexOfPlayer(player);
		idx++;
		if (idx >= players.size()) {
			idx = 0;
		}
		return idx;
	}

	/**
	 * static getter for board size
	 * 
	 * @return
	 */
	public static int getBoardSize() {
		return boardSize;
	}

}
