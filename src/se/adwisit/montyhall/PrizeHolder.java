package se.adwisit.montyhall;

public interface PrizeHolder {
	/**
	 * @return true if the PrizeHolder has been opened
	 */
	public boolean isOpen();

	/**
	 * @return return the Winning
	 */
	public Object getWinnig();

	/**
	 * @return true if it contains a prize
	 */
	public boolean peakInside();
}
