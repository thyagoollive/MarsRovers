/**
 * 
 */
package br.com.zup.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.zup.domain.Coordinate;
import br.com.zup.parsers.CoordinateParser;

/**
 * @author thyago
 *
 */
public class CoordinateParserTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link br.com.zup.parsers.CoordinateParser#getCoordinate(java.lang.String)}.
	 */
	@Test
	public void testGetCoordinate() {
		Coordinate coordinate = CoordinateParser.getCoordinate("1 5");
		assertEquals("1 5", coordinate.toString());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetCoordinateIllegalArgument(){
		CoordinateParser.getCoordinate("15");
		CoordinateParser.getCoordinate("R");
	}
	
	@Test(expected=NumberFormatException.class)
	public void testGetCoordinateNumberFormat(){
		CoordinateParser.getCoordinate("A A");
		CoordinateParser.getCoordinate("A 1");
		CoordinateParser.getCoordinate("1 A");
	}

}
