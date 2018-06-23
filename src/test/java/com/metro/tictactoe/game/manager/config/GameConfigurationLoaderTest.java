package com.metro.tictactoe.game.manager.config;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.metro.tictactoe.game.config.GameConfigurationLoader;
import com.metro.tictactoe.game.config.GameInitConfigurations;

public class GameConfigurationLoaderTest {

	@Test
	public void testLoad() {
		GameInitConfigurations loader = GameConfigurationLoader.load("configs");
		assertEquals(3, loader.getBoardSize());
		assertEquals('X', loader.getPlayerOne().charValue());
		assertEquals('O', loader.getPlayerTwo().charValue());
		assertEquals('C', loader.getPlayerComputer().charValue());
	}

}
