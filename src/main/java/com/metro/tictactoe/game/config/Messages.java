package com.metro.tictactoe.game.config;

/**
 * 
 * this class contain all static data that are needed along the application
 *
 */
public class Messages {

	// initial configuration
	public static final String FILE_PATH = "configs";
	public static final int BOARD_MIN_SIZE = 3;
	public static final int BOARD_MAX_SIZE = 10;
	public static final String ILLEGAL_INPUT_EXCEPTION_MESSAGE = "Valid board sizes are between (" + BOARD_MIN_SIZE
			+ ") and (" + BOARD_MAX_SIZE + ") , current is : ";
	public static final String INVALID_FILE_INPUT_FORMAT = "Data Expected from the file in invalid!!\nFound [found]\nPlease ensure that you are using the correct format Digit,Char,Char,Char";
	public static final String INVALID_PLAYERS_CHAR = "One or more Players can't have the same Symbol\nYour input Symbols are:[symbols]";
	public static final String FILE_INPUT_DELIMITER = ",";
	public static final String INITIAL_DATA_LOADED = "Initial Game's Data are loaded correctly!!Enjoy the game";

	// GAME messages instructions
	public static final String SEPARATOR = "=========================================";
	public static final String SEPARATOR_2 = "_______________________________________";
	public static final String INPUT_NOTIFICATION = "Enter X,Y  position: ";
	public static final String PLAYER_WIN = "***Player '[player]' Won The Game***";
	public static final String VALID_MOVE = "Valid move! ['valid']";
	public static final String INVALID_MOVE = "Invalid move! ['valid']";
	public static final String INVALID_INPUT = "Invalid input! ['point']";
	public static final String PLAYER_MOVE_INSTRUCTION = "(player) Make Your Move!";
	public static final String RANDOM_PLAYER_MOVE_INSTRUCTION = "Player 'randomPlayer' Made Move!";

	// engine messages
	public static final int NUMBER_OF_PLAYERS = 3;
	public static final String LOSERS_MSG = " Sorry You Lost the Game!!\nGood Luck next time:)";
	public static final String START_GAME = "\n  *** Welcome to \"Tic Tac Toe 2\" ***\n Please Check \"README\" for Further Details \n\t\tLet's Play:)\n";
	public static final String CURRENT_PLAYER_NUMBER = "\tTos player this game is ([symbol])";
	public static final String BOARD_FULL_DRAW = "Board is Full , No more places to play, It's a Draw";
	// board configurations
	public static final String boardHeader = "   X";
	public static final String boardLabel = "Y";
	public static final String INVALID_FILE_PATH = "Invalid File Path!! Please check the path you entered";
}
