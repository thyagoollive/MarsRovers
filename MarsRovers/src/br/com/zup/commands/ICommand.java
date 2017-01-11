/**
 * 
 */
package br.com.zup.commands;

import br.com.zup.domain.Rover;

/**
 * @author thyago
 *
 */
public interface ICommand {
	public void execute(final Rover rover);
	
}
