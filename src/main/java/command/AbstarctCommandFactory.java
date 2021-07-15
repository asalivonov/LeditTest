package command;

import java.util.HashMap;

public abstract class AbstarctCommandFactory {
	private HashMap<String, Runnable> commands = new HashMap<>();
	
	
	public void registerCommand(String cmdName, Runnable cmd) {
		if(cmdName != null && cmd != null) {
			commands.put(cmdName, cmd);
		}
	}
	public abstract IRunableCommand getCommand(String input, IEditableFile efile);
}
