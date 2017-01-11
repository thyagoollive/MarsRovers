/**
 * 
 */
package br.com.zup.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.zup.commands.ICommand;
import br.com.zup.commands.MoveCommand;
import br.com.zup.commands.TurnLeftCommand;
import br.com.zup.commands.TurnRightCommand;
import br.com.zup.parsers.CommandParser;

/**
 * @author thyago
 *
 */
public class CommandParserTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link br.com.zup.parsers.CommandParser#getCommands()}.
	 */
	@Test
	public void testGetCommands() {
		CommandParser commandParser = new CommandParser("MLR");
		List<ICommand> commands = commandParser.getCommands();
		assertEquals(3, commands.size());
		assertTrue(commands.get(0) instanceof MoveCommand);
		assertTrue(commands.get(1) instanceof TurnLeftCommand);
		assertTrue(commands.get(2) instanceof TurnRightCommand);
	}
	
	@Test(expected=InvalidParameterException.class)
	public void testGetCommandException(){
		CommandParser commandParser = new CommandParser("ACABATE");
		commandParser.getCommands();
	}

}
