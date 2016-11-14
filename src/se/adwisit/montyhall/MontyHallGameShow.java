package se.adwisit.montyhall;

import java.util.ArrayList;
import java.util.List;

public class MontyHallGameShow {
	private PlayerChoice player;
	private PuzzleBoard board;

	/**
	 * A game engine to simulate a Monty Hall game show
	 * @param player PlayerChoice the player to play the game
	 * @param board PuzzleBoard the type of board
	 */
	public MontyHallGameShow(PlayerChoice player, PuzzleBoard board) {
		this.player = player;
		this.board = board;
	}

	/**
	 * Run the game numberOfRuns times and returns the number of times that the player have won the game.
	 * @param numberOfRuns How many time that the game will play.
	 * @return The number of times that the player have won the game
	 */
	public Integer run(int numberOfRuns) {
		int turn = 0;
		Integer numberOfWinnings = 0;
		while (turn < numberOfRuns) {
			if (runTheGame()) {
				numberOfWinnings++;
			}
			turn++;
		}
		return numberOfWinnings;
	}

	private boolean runTheGame() {
		board.generateNewBoard();
		Integer playerPick = (Integer) player.pickAnItem(board.getClosedList());
		List<Integer> stillClosed = board.getClosedList();
		stillClosed.remove(playerPick);
		Integer finalPick = new Integer(playerPick);
		if (player.wantToSwitch()) {
			List<Integer> removeItem = new ArrayList<Integer>(stillClosed.size());
			for (Integer index : stillClosed) {
				if(!board.peakInsideAtPosition(index)){
					removeItem.add(index);
					break;
				} 
			}
			for (Integer index : removeItem){
				stillClosed.remove(index);
			}
			
			finalPick = (Integer) player.pickAnItem(stillClosed);
		}
		
		return board.getPrizeAtPosition(finalPick);
	}
	
	
	
	public static void main(String... args){
		int numberOfRuns = 200000;
		Player player1 = new Player(false);
		PuzzleBoard board = new PuzzleBoard();
		MontyHallGameShow game1 = new MontyHallGameShow(player1, board);
		Integer player1Winnings = game1.run(numberOfRuns);
		String p1Text = "Player that never changes its mind";
		System.out.println(p1Text + ": " + player1Winnings + " (" + 100*player1Winnings/numberOfRuns+"%)");
		
		
		Player player2 = new Player(true);
		MontyHallGameShow game2 = new MontyHallGameShow(player2, board);
		Integer player2Winnings = game2.run(numberOfRuns);
		String p2Text = "Player that always changes its mind";
		System.out.println(p2Text + ": " + player2Winnings + " (" + 100*player2Winnings/numberOfRuns+"%)");
		System.out.println("\nThe winner is: " + (player1Winnings > player2Winnings ? p1Text : p2Text));
		
	}
}
