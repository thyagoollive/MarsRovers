/**
 * 
 */
package br.com.zup.parsers;

import br.com.zup.domain.Coordinate;
import br.com.zup.domain.Rover;
import br.com.zup.enums.Direction;

/**
 * @author thyago
 *
 */
public class RoverParser {

	public static Rover getRover(String stringRover, Coordinate maximumCoordinate) throws IllegalArgumentException, NumberFormatException{
		
		String[] initialPositionSplited = stringRover.split(" ");
		if (initialPositionSplited.length != 3)
			throw new IllegalArgumentException("Invalid Format, Retry!");

		
		int axisX = Integer.parseInt(initialPositionSplited[0]);
		int axisY = Integer.parseInt(initialPositionSplited[1]);

		String direction = initialPositionSplited[2];
				
		return new Rover(new Coordinate(axisX, axisY), Direction.fromString(direction), maximumCoordinate);
		
	}
	
}
