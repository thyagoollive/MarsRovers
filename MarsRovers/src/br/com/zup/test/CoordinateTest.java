/**
 * 
 */
package br.com.zup.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.zup.domain.Coordinate;
import br.com.zup.enums.Direction;

/**
 * @author thyago
 *
 */
public class CoordinateTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link br.com.zup.domain.Coordinate#newCoordinatesFor(int, int)}.
	 */
	@Test
	public void testNewCoordinatesFor() {
		Coordinate initialCoordinate = new Coordinate(1, 1);
		Direction currentDirection = Direction.NORTH;
		
		Coordinate positionAfterMove = null;
		
		positionAfterMove = initialCoordinate.newCoordinatesFor(currentDirection.getAxisX(), currentDirection.getAxisY());
		assertEquals("1 2", positionAfterMove.toString());
		
		currentDirection = Direction.EAST;
		positionAfterMove = initialCoordinate.newCoordinatesFor(currentDirection.getAxisX(), currentDirection.getAxisY());
		assertEquals("2 1", positionAfterMove.toString());
		
		currentDirection = Direction.SOUTH;
		positionAfterMove = initialCoordinate.newCoordinatesFor(currentDirection.getAxisX(), currentDirection.getAxisY());
		assertEquals("1 0", positionAfterMove.toString());
		
		currentDirection = Direction.WEST;
		positionAfterMove = initialCoordinate.newCoordinatesFor(currentDirection.getAxisX(), currentDirection.getAxisY());
		assertEquals("0 1", positionAfterMove.toString());
	}

	/**
	 * Test method for {@link br.com.zup.domain.Coordinate#toString()}.
	 */
	@Test
	public void testToString() {
		Coordinate coordinates = new Coordinate(5, 3);
		assertEquals("5 3", coordinates.toString());
	}

	/**
	 * Test method for {@link br.com.zup.domain.Coordinate#hasWithinBounds(br.com.zup.domain.Coordinate)}.
	 */
	@Test
	public void testHasWithinBounds() {
		Coordinate limitCoordinate = new Coordinate(5, 5);
		assertTrue(new Coordinate(0, 0).hasWithinBounds(limitCoordinate));
		assertTrue(new Coordinate(0, 5).hasWithinBounds(limitCoordinate));
		assertTrue(new Coordinate(5, 5).hasWithinBounds(limitCoordinate));
		assertFalse(new Coordinate(6, 0).hasWithinBounds(limitCoordinate));
		assertFalse(new Coordinate(0, 6).hasWithinBounds(limitCoordinate));
		assertFalse(new Coordinate(6, 6).hasWithinBounds(limitCoordinate));
	}
	
	@Test(expected=NullPointerException.class)
	public void testHasWithinBoundsNull(){
		assertTrue(new Coordinate(0, 0).hasWithinBounds(null));
	}

}
