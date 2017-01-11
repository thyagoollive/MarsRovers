/**
 * 
 */
package br.com.zup.commands;

import br.com.zup.domain.Rover;

/**
 * @author thyago
 *
 */
public class MoveCommand implements ICommand {

	/* (non-Javadoc)
	 * @see br.com.zup.commands.ICommands#execute(br.com.zup.domain.Rover)
	 */
	@Override
	public void execute(Rover rover) {
		rover.move();
	}

}
