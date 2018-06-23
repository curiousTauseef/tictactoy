package com.metro.tictactoe.game.manager.checker;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.metro.tictactoe.game.manager.checkers.HelperUtils;

public class HelperUtilsTest {

	@Test
	public void testGenerateRandomNumber() {
		int randomNumber = HelperUtils.generateRandomNumber(10);
		assertTrue(0 <= randomNumber && randomNumber <= 10);
	}

}
