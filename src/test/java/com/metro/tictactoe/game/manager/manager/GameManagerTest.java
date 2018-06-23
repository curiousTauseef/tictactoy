package com.metro.tictactoe.game.manager.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.metro.tictactoe.game.board.Board;
import com.metro.tictactoe.game.manager.GameManager;
import com.metro.tictactoe.game.players.ComputerPlayer;
import com.metro.tictactoe.game.players.HumanPlayer;

public class GameManagerTest {

	private GameManager manager;

	@Before
	public void setUp() throws Exception {
		manager = GameManager.getInstance();
	}

	/**
	 * Getting sure that singleton class working just fine
	 */
	@Test
	public void testGetInstance() {
		GameManager man = GameManager.getInstance();
		assertEquals(manager, man);
	}

	@Test
	public void testGetBoard() {
		Board board = manager.getBoard();
		assertNotNull(board);
	}

	@Test
	public void testMove_1() {
		Boolean result = manager.move(new HumanPlayer(), new int[] { 0, 0 });
		assertTrue(result);
	}

	@Test
	public void testMove_2() {
		Boolean result = manager.move(new ComputerPlayer(), new int[] { 0, 0 });
		assertFalse(result);

	}

	@Test
	public void testMove_3() {

		Boolean result2 = manager.move(new ComputerPlayer(), new int[] { 1, 0 });
		assertTrue(result2);
	}

	@Test
	public void testMove_4() {
		Boolean result = manager.move(new HumanPlayer(), new int[] { 0, 1 });
		assertTrue(result);
	}

	@Test
	public void testGetBoardSize() {
		assertEquals(3, GameManager.getBoardSize());

	}

}
