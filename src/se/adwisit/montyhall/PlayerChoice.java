package se.adwisit.montyhall;

import java.util.List;

public interface PlayerChoice {
	/**
	 * @param itemList A List with items that the player can choose from.
	 * @return [Object] one item from the numberList is selected at random.
	 */
	public Object pickAnItem(List itemList);
	
	/**
	 * @return true if the player want to switch, false if not.
	 */
	public boolean wantToSwitch();
}
