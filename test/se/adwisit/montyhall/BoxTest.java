package se.adwisit.montyhall;

import org.junit.Test;

import junit.framework.TestCase;

public class BoxTest extends TestCase{

	@Test
	public void test(){
		boolean containsPrize = true;
		Box box = new Box(containsPrize);
		
		assertEquals(false, box.isOpen());
		
		boolean peakContent = box.peakInside();
		assertEquals(containsPrize, peakContent);
		
		
		boolean win = (boolean) box.getWinnig();
		assertEquals(containsPrize, win);
		assertEquals(true, box.isOpen());
		
	}
	
}
