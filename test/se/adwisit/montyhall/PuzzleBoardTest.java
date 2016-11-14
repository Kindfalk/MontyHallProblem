package se.adwisit.montyhall;

import java.util.List;

import org.junit.Test;

public class PuzzleBoardTest extends junit.framework.TestCase {

	@Test
	public void test() {
		PuzzleBoard manager = new PuzzleBoard();

		manager.generateNewBoard();

		List<Integer> stillClosed = manager.getClosedList();
		assertEquals(3, stillClosed.size());

		List<PrizeHolder> cheatList = manager.getCheatListForTesting();
		for (int index = 0; index < cheatList.size(); index++) {
			assertEquals(true, stillClosed.contains(index));
		}

		// get prize == open
		boolean prize0 = manager.getPrizeAtPosition(0);
		assertEquals(true, cheatList.get(0).isOpen());
		assertEquals(false, cheatList.get(1).isOpen());
		assertEquals(false, cheatList.get(2).isOpen());
		prize0 = manager.getPrizeAtPosition(1);
		assertEquals(true, cheatList.get(0).isOpen());
		assertEquals(true, cheatList.get(1).isOpen());
		assertEquals(false, cheatList.get(2).isOpen());
		prize0 = manager.getPrizeAtPosition(2);
		assertEquals(true, cheatList.get(0).isOpen());
		assertEquals(true, cheatList.get(1).isOpen());
		assertEquals(true, cheatList.get(2).isOpen());

		// number of winnings is == 1
		int numberOfWinnings = 0;
		manager.generateNewBoard();
		cheatList = manager.getCheatListForTesting();
		for (int index = 0; index < cheatList.size(); index++) {
			if (manager.getPrizeAtPosition(index))
				numberOfWinnings++;
		}
		assertEquals(1, numberOfWinnings);

		// test peakAtPosition
		manager.generateNewBoard();
		cheatList = manager.getCheatListForTesting();
		for (int index = 0; index < cheatList.size(); index++) {
			assertEquals(cheatList.get(index).peakInside(), (boolean) manager.peakInsideAtPosition(index));
		}

		// check the winnings position
		manager.generateNewBoard();
		cheatList = manager.getCheatListForTesting();
		for (int index = 0; index < cheatList.size(); index++) {
			if (cheatList.get(index).peakInside()) {
				assertEquals(new Boolean(true), manager.getPrizeAtPosition(index));
			}
		}

	}

}
