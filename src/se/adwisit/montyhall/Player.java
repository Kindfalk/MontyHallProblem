package se.adwisit.montyhall;

import java.util.List;
import java.util.Random;

public class Player implements PlayerChoice{
	private boolean allwaysSwitch; // Behavior of the player
	private Random rand = new Random();
	

	/**
	 * @param allwaysSwitch if true: always switch, false: never switch.
	 */
	public Player(boolean allwaysSwitch) {
		this.allwaysSwitch = allwaysSwitch;
	}

	/**
	 * @param itemList A List with Integers that the player can choose from.
	 * @return [Integer] one number from the numberList is selected at random.
	 */
	@Override
	public Integer pickAnItem(List numberList) {
		int index = rand.nextInt(numberList.size());
		return (Integer) numberList.get(index);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean wantToSwitch() {
		return allwaysSwitch;
	}

}
