package com.metro.tictactoe.game.players;

import com.metro.tictactoe.game.enums.PlayersType;

public class PlayerFactory {

	public static Player getPlayer(PlayersType type) {

		if (type == PlayersType.COMPUTER)
			return new ComputerPlayer();
		else
			return new HumanPlayer();
	}
}
