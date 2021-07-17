package main.java.command;

public class UnknownCommand implements IRunableCommand{

	@Override
	public boolean run() {
		System.out.println("ERROR Command is unknown!");
		return true;
	}

}
