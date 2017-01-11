/**
 * 
 */
package br.com.zup.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.zup.enums.Direction;

/**
 * @author thyago
 *
 */
public class DirectionsTest {


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

	}

	/**
	 * Test method for {@link br.com.zup.enums.Direction#toString()}.
	 */
	@Test
	public void testToString() {
		assertEquals("N", Direction.NORTH.toString());
		assertEquals("E", Direction.EAST.toString());
		assertEquals("W", Direction.WEST.toString());
		assertEquals("S", Direction.SOUTH.toString());
	}

	/**
	 * Test method for {@link br.com.zup.enums.Direction#fromString(java.lang.String)}.
	 */
	@Test
	public void testFromString() {
		assertEquals(Direction.NORTH, Direction.fromString("N"));
		assertEquals(Direction.EAST, Direction.fromString("E"));
		assertEquals(Direction.WEST, Direction.fromString("W"));
		assertEquals(Direction.SOUTH, Direction.fromString("S"));
	}
	
	/**
	 * Test method for {@link br.com.zup.enums.Direction#fromString(java.lang.String)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testFromStringException(){
		Direction.fromString("A");
	}


}
