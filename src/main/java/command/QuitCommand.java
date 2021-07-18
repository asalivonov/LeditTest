package main.java.command;

import java.io.IOException;

public class QuitCommand extends AFileCommand {


	QuitCommand(String[] params, IEditableFile efile) {
		super(params, efile);
	}

	@Override
	protected boolean execute() throws IOException {
		//TODO some code to ask user if he/she wants to save before exit
		return false;
	}
	
	
	

}
