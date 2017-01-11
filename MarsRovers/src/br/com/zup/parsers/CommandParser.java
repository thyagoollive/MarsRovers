/**
 * 
 */
package br.com.zup.parsers;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.zup.commands.*;

/**
 * @author thyago
 *
 */
public class CommandParser {

    @SuppressWarnings("serial")
	private static Map<Character, ICommand> characterToCommandMap = new HashMap<Character, ICommand>() {{
        put('L', new TurnLeftCommand());
        put('R', new TurnRightCommand());
        put('M', new MoveCommand());
    }};

    private String commandString;

    public CommandParser(final String commandString) {
        this.commandString = commandString;
    }

    public List<ICommand> getCommands() throws InvalidParameterException {
        if(isNullOrEmpty(commandString))
        	throw new InvalidParameterException("Command is empty, retry!");
        
        return buildCommandsList(commandString);
    }

    private List<ICommand> buildCommandsList(final String commandString) throws InvalidParameterException {
        List<ICommand> commands = new ArrayList<ICommand>();
		for (int i = 0; i < commandString.length(); i++) {
			Character command = commandString.charAt(i);
			ICommand mappedCommand = characterToCommandMap.get(command);
			if (mappedCommand != null)
				commands.add(mappedCommand);
			else
				throw new InvalidParameterException("Invalid command for the rover! [" + String.valueOf(command) + "].");
		}
        return commands;
    }

    private boolean isNullOrEmpty(final String commandString) {
        return (null == commandString || commandString.trim().length() == 0);
    }

}
