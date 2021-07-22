package main.java.command;

import java.io.IOException;

import main.java.ledit.CommandProcessor;


public class InsertCommand extends AFileCommand {


	InsertCommand(String[] params, IEditableFile efile) {
		super(params, efile);
	}


	@Override
	protected boolean execute() throws IOException {
		if(lineNumer > 0 && lineNumer <= efile.size()) {
			String newLine = CommandProcessor.readConsole("Enter new line:");
			efile.insertLine(newLine, lineNumer);
			System.out.println("New line inserted:");
			listLines(lineNumer - 2, lineNumer + 2);
		} else {
			System.out.println("ERROR incorrect line number, line number should be between 1 and " + efile.size());
		}
		return true;
	}

}
