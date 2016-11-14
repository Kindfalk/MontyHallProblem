package se.adwisit.montyhall;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PlayerTest extends junit.framework.TestCase {

	@Test
	public void test() {
		boolean wantToSwitch = true;
		
		PlayerChoice playerChoice = new Player(wantToSwitch);

		boolean value = playerChoice.wantToSwitch();
		assertEquals(wantToSwitch, value);
		
		
		Integer firstValue = new Integer(1);
		Integer secondValue = new Integer(2);
		List<Integer> numberList = new ArrayList<Integer>();
		numberList.add(firstValue);
		numberList.add(secondValue);
		
		Integer playerSelection = (Integer) playerChoice.pickAnItem(numberList);
		assertEquals(firstValue, playerSelection);
		
	}

}
