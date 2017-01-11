/**
 * 
 */
package br.com.zup.parsers;

import br.com.zup.domain.Coordinate;

/**
 * @author thyago
 *
 */
public class CoordinateParser {

	public static Coordinate getCoordinate(String stringCoordinate) throws IllegalArgumentException, NumberFormatException {
		
		String[] splitedString = stringCoordinate.split(" ");
		if ((splitedString.length < 2) || ((splitedString.length > 3)))
			throw new IllegalArgumentException("Invalid Format!");

		int axisX = Integer.parseInt(splitedString[0]);
		int axisY = Integer.parseInt(splitedString[1]);
		
		return new Coordinate(axisX, axisY);		
	}
	
}
