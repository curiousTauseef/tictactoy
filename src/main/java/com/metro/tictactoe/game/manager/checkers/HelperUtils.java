package com.metro.tictactoe.game.manager.checkers;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Helper Util Class , contain supporting method(s)
 */
public class HelperUtils {
	/**
	 * Generate Random Number between 0 to max
	 * 
	 * @param max
	 * @return random number
	 */
	public static int generateRandomNumber(int max) {
		return ThreadLocalRandom.current().nextInt(0, max);
	}
}
