/**
 * 
 */
package br.com.zup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import br.com.zup.domain.Coordinate;
import br.com.zup.domain.Rover;
import br.com.zup.parsers.CoordinateParser;
import br.com.zup.parsers.RoverParser;

/**
 * Main
 * @author thyago 
 * Main class
 */
public class Main {

	private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	private static final String WORD = "EXIT";
	/**
	 * @param args command line
	 */
	public static void main(String[] args) {
		
		
		ArrayList<Rover> rovers = new ArrayList<Rover>();

		try {
			
			System.out.print("Please, insert the dimensions of plateau (Format: X Y): ");
			String stringCoordinate = bufferedReader.readLine();
			Coordinate maximumCoordinate = CoordinateParser.getCoordinate(stringCoordinate);
			
			String instruction = "";
			while (!instruction.toUpperCase().equals(WORD)) {
				try {

					System.out.println("Insert initial position for a new rover (example: X Y DIRECTION). Since the parameter DIRECTION can be N, E, W or S.");
					System.out.println("Type [exit] to finish.");
					instruction = bufferedReader.readLine();

					if (instruction.toUpperCase().equals(WORD))
						break;

					try {
						Rover rover = RoverParser.getRover(instruction, maximumCoordinate); 
						
						System.out
								.println("Enter series of instructions telling the rover how to explore the plateau: ");
						String instructions = bufferedReader.readLine();
						rover.processCommands(instructions);
						
						rovers.add(rover);
					} catch (IllegalArgumentException e) {
						System.err.println(e.getMessage() + "\nRetry!");
					}

				} catch (IllegalArgumentException e) {
					System.err.println(e.getMessage());
				}

			}

			if (rovers.size() > 0) {
				for (int i = 0; i < rovers.size(); i++) {
					System.out.println(rovers.get(i).currentPosition());
				}
			} else {
				System.out.println("No result because don't have rovers!");
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
