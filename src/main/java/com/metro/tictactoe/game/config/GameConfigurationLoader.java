package com.metro.tictactoe.game.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * 
 * This is Data loader class <br/>
 * it read data from file , then parse them with delimeter ','<br/>
 * and finally form {@link GameInitConfigurations} object to be used further in
 * the game processing<br/>
 * should be called first
 *
 */
public class GameConfigurationLoader {

	private static final Logger LOG = Logger.getLogger(GameConfigurationLoader.class.getName());

	/**
	 * load data from file
	 * 
	 * @param filePath
	 *            - obtained from configuration file
	 * @return {@link GameInitConfigurations} object that contain essential game
	 *         configurations
	 * @throws IOException,IllegalArgumentException
	 */
	public static GameInitConfigurations load(String filePath) {
		GameInitConfigurations configs = new GameInitConfigurations();
		try {
			BufferedReader reader = readFile(filePath);
			String line;
			while ((line = reader.readLine()) != null) {
				/*
				 * Validating the input against the expected format d,c,c,c
				 */
				// regex state that string start with digit , parts separated with (,) and each
				// consists exactly of one character
				if (line.matches("^(((?!(0))\\d|1\\d|2))(,[^,])*$")) {
					/*
					 * Splitting input according to the delimter (,) expected array size is 4 ,
					 * board_size , player1_symbol,player2_symbol,player3_symbol respectively
					 */
					String[] configTokens = line.split(Messages.FILE_INPUT_DELIMITER);
					// board size
					int boardSize = Integer.parseInt(configTokens[0]);
					// as pre-condition boardsize must be between 3 and 10,checking is done
					// if condition violated system will throw warning and stop, otherwise it will
					// set the board size
					checkAndAssignBoardSize(configs, boardSize);
					
					char playerOne = configTokens[1].charAt(0);
					char playerTwo = configTokens[2].charAt(0);
					char playerThree = configTokens[3].charAt(0);
					/*
					 * make sure that players have different symbols
					 */
					checkAndAssignPlayersSymbols(configs, playerOne, playerTwo, playerThree);

				} else {
					LOG.warning(Messages.INVALID_FILE_INPUT_FORMAT.replace("[found]", line));
					System.exit(0);
				}
			}
		} catch (IOException | NullPointerException e) {
			/*
			 * if file path was wrong, warning will be shown and system exits
			 */
			LOG.warning(Messages.INVALID_FILE_PATH);
			System.exit(0);

		}

		return configs;
	}

	private static void checkAndAssignBoardSize(GameInitConfigurations configs, int boardSize) {
		if (boardSize < Messages.BOARD_MIN_SIZE || boardSize > Messages.BOARD_MAX_SIZE) {
			LOG.warning(Messages.ILLEGAL_INPUT_EXCEPTION_MESSAGE + boardSize);
			System.exit(0);
		} else {
			configs.setBoardSize(boardSize);
		}
	}

	private static void checkAndAssignPlayersSymbols(GameInitConfigurations configs, char playerOne, char playerTwo,
			char playerThree) {
		if (Stream.of(playerOne, playerTwo, playerThree).distinct().count() == Messages.NUMBER_OF_PLAYERS) {
			// player 1 symbol
			configs.setPlayerOne(playerOne);
			// player 2 symbol
			configs.setPlayerTwo(playerTwo);
			// player 3 symbol
			configs.setPlayerComputer(playerThree);
		} else {
			/*
			 * if two or more players have the same symbol, show warning and exit
			 */
			LOG.warning(Messages.INVALID_PLAYERS_CHAR.replace("symbols",
					playerOne + "," + playerTwo + "," + playerThree));
			System.exit(0);
		}
	}

	private static BufferedReader readFile(String filePath) {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(GameConfigurationLoader.class.getClassLoader().getResourceAsStream(filePath)));
		return reader;
	}

}
