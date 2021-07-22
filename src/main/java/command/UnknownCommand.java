package main.java.command;

public class UnknownCommand implements IRunableCommand{

	@Override
	public boolean run() {
		System.out.println("ERROR Command is unknown! Please use following commands: \n del \n ins \n save \n quit");
		return true;
	}

}
