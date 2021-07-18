package main.java.command;

public class SmallFileCommandFactory extends AbstarctCommandFactory{
	

	
	public IRunableCommand getCommand(String input, IEditableFile efile) {
		IRunableCommand cmd = null;
		if(input == null || input.isBlank()) {
			return null;
		}
		
		String[] words = input.split(" ");
		String cmdName = words[0];
		System.out.println("Command:" + cmdName);
		
		
		switch (cmdName) {
		case "i":
		case "ins": cmd = new InsertCommand(words, efile);
			break;
		case "l":
		case "list": cmd = new ListCommand(words, efile);
			break;
		case "d":
		case "del": cmd = new DeleteCommand(words, efile);
			break;
		case "s":
		case "save": cmd = new SaveToFileCommand(words, efile);
			break;
		case "q" :
		case "quit": cmd = new QuitCommand(words, efile);
			break;
		default:
			cmd = new UnknownCommand();
		}
		
		return cmd;
	}



}
