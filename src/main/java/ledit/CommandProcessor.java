package main.java.ledit;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

import main.java.command.AbstarctCommandFactory;
import main.java.command.IEditableFile;
import main.java.command.IRunableCommand;

public class CommandProcessor {
	
	AbstarctCommandFactory commandfactory;
	
	CommandProcessor(AbstarctCommandFactory cf){
		commandfactory = cf;
	}
	
		
	void processCommands(IEditableFile tf) throws IOException {
		
		while(readCmd(tf));
		
		System.out.println("Exiting application");
	}

	boolean readCmd(IEditableFile tf) throws IOException {
		String input = readConsole("Enter command:");
		if(input == null || input.isBlank()) {
			return true;
		}	
		IRunableCommand cmd = commandfactory.getCommand(input, tf);
		return cmd.run();
	}
	
	public static String readConsole(String msg) throws IOException {
		System.out.println(msg);
		Console cl = System.console();
		String line = "";
		if(cl == null) {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			line = bufferedReader.readLine();
			
		} else {
			line = System.console().readLine();
		}
		return line;
	}
	
}
