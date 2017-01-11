package br.com.zup.domain;

import java.util.List;

import br.com.zup.commands.ICommand;
import br.com.zup.enums.Direction;
import br.com.zup.parsers.CommandParser;

/**
 * Rover
 * @author thyago
 * Represent a rover
 */
public class Rover {
	
	private Coordinate currentCoordinate;
	private Direction currentDirection;
	private Coordinate maximumCoordinate; 
	
	
	public Rover(final Coordinate currentCoordinate, final Direction direction, final Coordinate maximumCoordinate) throws IllegalArgumentException {
		this.currentCoordinate = currentCoordinate;
        this.currentDirection = direction;
        this.maximumCoordinate = maximumCoordinate;
        
        if (currentCoordinate.hasWithinBounds(maximumCoordinate) == false)
        	throw new IllegalArgumentException("The rover exceeded the limit!");
    }
	
	public void move() throws IllegalArgumentException {
		Coordinate positionAfterMove = this.currentCoordinate.newCoordinatesFor(this.currentDirection.getAxisX(), this.currentDirection.getAxisY());

		if (positionAfterMove.hasWithinBounds(maximumCoordinate)){
			this.currentCoordinate = positionAfterMove;
		}
		else
			throw new IllegalArgumentException("Illegal instruction! The rover can't move because exceeded the limit!");
	}

	public void turnLeft(){
		this.currentDirection = this.currentDirection.turnLeft();
	}

	public void turnRight(){
		this.currentDirection = this.currentDirection.turnRight();
	}
	
	public void processCommands(String commandString) throws IllegalArgumentException {
		List<ICommand> roverCommands = new CommandParser(commandString).getCommands();
        for (ICommand command : roverCommands) {
            command.execute(this);
        }
	}
	
	public String currentPosition(){
		return this.currentCoordinate.toString() + " " + this.currentDirection.toString();
	}
}
