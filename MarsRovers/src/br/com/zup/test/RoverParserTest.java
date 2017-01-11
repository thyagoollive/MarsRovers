/**
 * 
 */
package br.com.zup.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.zup.domain.Coordinate;
import br.com.zup.domain.Rover;
import br.com.zup.parsers.RoverParser;

/**
 * @author thyago
 *
 */
public class RoverParserTest {

	private Coordinate maximumCoordinate;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		maximumCoordinate = new Coordinate(5, 5);
	}

	/**
	 * Test method for {@link br.com.zup.parsers.RoverParser#getRover(java.lang.String, br.com.zup.domain.Coordinate)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetRoverInvalidParameter() {
		RoverParser.getRover("65 N", this.maximumCoordinate);
		RoverParser.getRover("6 N", this.maximumCoordinate);
		RoverParser.getRover("6 5 N", this.maximumCoordinate);
	}
	
	/**
	 * Test method for {@link br.com.zup.parsers.RoverParser#getRover(java.lang.String, br.com.zup.domain.Coordinate)}.
	 */
	@Test(expected=NumberFormatException.class)
	public void testGetRoverNumberFormat(){
		RoverParser.getRover("6 R N", this.maximumCoordinate);		
	}
	
	/**
	 * Test method for {@link br.com.zup.parsers.RoverParser#getRover(java.lang.String, br.com.zup.domain.Coordinate)}.
	 */
	@Test
	public void testGetRover() {
		Rover rover = RoverParser.getRover("4 3 W", this.maximumCoordinate);
		assertEquals("4 3 W", rover.currentPosition());		
	}


}
