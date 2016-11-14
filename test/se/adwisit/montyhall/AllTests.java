package se.adwisit.montyhall;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestSuite;

public class AllTests {
	public static junit.framework.TestSuite suite(){
		TestSuite suite = new junit.framework.TestSuite();
		suite.addTestSuite(PlayerTest.class);
		suite.addTestSuite(PuzzleBoardTest.class);
		suite.addTestSuite(BoxTest.class);
		return suite;
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
