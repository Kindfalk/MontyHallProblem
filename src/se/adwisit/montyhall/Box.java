package se.adwisit.montyhall;

public class Box implements PrizeHolder{
	boolean containsPrize;
	boolean open = false;
	
	/**
	 * A Box holding the Prize
	 * @param containsPrize True if it contains a prize, false if not.
	 */
	public Box(boolean containsPrize) {
		this.containsPrize = containsPrize;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isOpen() {
		return open;
	}

	/**
	 * @return [Boolean] true if it contains a prize, false otherwise
	 */
	public Object getWinnig() {
		open = true;
		return new Boolean(containsPrize);
	}

	/**
	 * {@inheritDoc}
	 */	
	public boolean peakInside() {
		return containsPrize;
	}

	@Override
	public String toString() {
		return "containsPrize: " + containsPrize + ", open: " + open;
	}
	

	
}
