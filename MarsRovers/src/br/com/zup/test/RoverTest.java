/**
 * 
 */
package br.com.zup.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.zup.domain.Coordinate;
import br.com.zup.domain.Rover;
import br.com.zup.enums.Direction;

/**
 * @author thyago
 *
 */
public class RoverTest {

	private Coordinate maximumAxisCoordinate;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		maximumAxisCoordinate = new Coordinate(5, 5);
	}

	/**
	 * Test method for {@link br.com.zup.domain.Rover#Rover(Coordinate, Direction, Coordinate)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testRoverIllegalArgument(){
		new Rover(new Coordinate(6, 5), Direction.NORTH, this.maximumAxisCoordinate);
	}
	
	/**
	 * Test method for {@link br.com.zup.domain.Rover#currentPosition()}.
	 */
	@Test
	public void testRoverInstruction(){
		Rover rover = new Rover(new Coordinate(5, 1), Direction.EAST, this.maximumAxisCoordinate);
		assertEquals("5 1 E", rover.currentPosition());
	}

	/**
	 * Test method for {@link br.com.zup.domain.Rover#move()}.
	 */
	@Test
	public void testMove() {
		Coordinate currentCoordinate = new Coordinate(1, 1);
		Rover rover1 = new Rover(currentCoordinate, Direction.NORTH, this.maximumAxisCoordinate);
		rover1.move();
		assertEquals("1 2 N", rover1.currentPosition());

		Rover rover2 = new Rover(currentCoordinate, Direction.EAST, this.maximumAxisCoordinate);
		rover2.move();
		assertEquals("2 1 E", rover2.currentPosition());
		
		Rover rover3 = new Rover(currentCoordinate, Direction.WEST, this.maximumAxisCoordinate);
		rover3.move();
		assertEquals("0 1 W", rover3.currentPosition());
		
		Rover rover4 = new Rover(currentCoordinate, Direction.SOUTH, this.maximumAxisCoordinate);
		rover4.move();
		assertEquals("1 0 S", rover4.currentPosition());		
	}
	
	/**
	 * Test method for {@link br.com.zup.domain.Rover#move()}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testMoveExceedNorth(){
		Rover rover1 = new Rover(new Coordinate(5, 5), Direction.NORTH, this.maximumAxisCoordinate);
		rover1.move();
		
		Rover rover2 = new Rover(new Coordinate(5, 5), Direction.EAST, this.maximumAxisCoordinate);
		rover2.move();
		
		Rover rover3 = new Rover(new Coordinate(0, 0), Direction.WEST, this.maximumAxisCoordinate);
		rover3.move();
		
		Rover rover4 = new Rover(new Coordinate(0, 0), Direction.SOUTH, this.maximumAxisCoordinate);
		rover4.move();
	}
	
	/**
	 * Test method for {@link br.com.zup.domain.Rover#turnLeft()}.
	 */
	@Test
	public void testTurnLeft() {
		Rover rover1 = new Rover(new Coordinate(0, 0), Direction.NORTH, this.maximumAxisCoordinate);
		rover1.turnLeft();
		assertEquals("0 0 W", rover1.currentPosition());

		Rover rover2 = new Rover(new Coordinate(0, 0), Direction.EAST, this.maximumAxisCoordinate);
		rover2.turnLeft();
		assertEquals("0 0 N", rover2.currentPosition());
		
		Rover rover3 = new Rover(new Coordinate(0, 0), Direction.WEST, this.maximumAxisCoordinate);
		rover3.turnLeft();
		assertEquals("0 0 S", rover3.currentPosition());
		
		Rover rover4 = new Rover(new Coordinate(0, 0), Direction.SOUTH, this.maximumAxisCoordinate);
		rover4.turnLeft();
		assertEquals("0 0 E", rover4.currentPosition());
	}

	/**
	 * Test method for {@link br.com.zup.domain.Rover#turnRight()}.
	 */
	@Test
	public void testTurnRight() {
		Rover rover1 = new Rover(new Coordinate(0, 0), Direction.NORTH, this.maximumAxisCoordinate);
		rover1.turnRight();
		assertEquals("0 0 E", rover1.currentPosition());

		Rover rover2 = new Rover(new Coordinate(0, 0), Direction.EAST, this.maximumAxisCoordinate);
		rover2.turnRight();
		assertEquals("0 0 S", rover2.currentPosition());
		
		Rover rover3 = new Rover(new Coordinate(0, 0), Direction.WEST, this.maximumAxisCoordinate);
		rover3.turnRight();
		assertEquals("0 0 N", rover3.currentPosition());
		
		Rover rover4 = new Rover(new Coordinate(0, 0), Direction.SOUTH, this.maximumAxisCoordinate);
		rover4.turnRight();
		assertEquals("0 0 W", rover4.currentPosition());
	}

	@Test
	public void mainRoverTest(){
		Coordinate maximumAxisCoordinate = new Coordinate(5, 5);
		
		Rover rover1 = new Rover(new Coordinate(1, 2), Direction.NORTH, maximumAxisCoordinate);
		// LMLMLMLMM
		rover1.turnLeft();
		rover1.move();
		rover1.turnLeft();
		rover1.move();
		rover1.turnLeft();
		rover1.move();
		rover1.turnLeft();
		rover1.move();
		rover1.move();
		assertEquals("1 3 N", rover1.currentPosition());
		
		Rover rover2 = new Rover(new Coordinate(3, 3), Direction.EAST, maximumAxisCoordinate);
		// MMRMMRMRRM
		rover2.move();
		rover2.move();
		rover2.turnRight();
		rover2.move();
		rover2.move();
		rover2.turnRight();
		rover2.move();
		rover2.turnRight();
		rover2.turnRight();
		rover2.move();
		assertEquals("5 1 E", rover2.currentPosition());		
	}

	/**
	 * Test method for {@link br.com.zup.domain.Rover#processCommands(String)}.
	 */
	@Test
	public void processInstructionsTest(){
		Rover rover1 = new Rover(new Coordinate(1, 2), Direction.NORTH, this.maximumAxisCoordinate);
		rover1.processCommands("LMLMLMLMM");
		assertEquals("1 3 N", rover1.currentPosition());
		
		Rover rover2 = new Rover(new Coordinate(3, 3), Direction.EAST, this.maximumAxisCoordinate);
		rover2.processCommands("MMRMMRMRRM");
		assertEquals("5 1 E", rover2.currentPosition());
		
		Rover rover3 = new Rover(new Coordinate(0, 0), Direction.NORTH, this.maximumAxisCoordinate);
		rover3.processCommands("MLLLMRM");
		assertEquals("1 0 S", rover3.currentPosition());
	}
	
	/**
	 * Test method for {@link br.com.zup.domain.Rover#processCommands(String)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void processInstructionsIllegalArgumentTest(){
		Rover rover = new Rover(new Coordinate(3, 3), Direction.NORTH, this.maximumAxisCoordinate);
		rover.processCommands("MMMMMMMM");
	}
}
