package main.java.command;

import java.io.IOException;

import main.java.ledit.CommandProcessor;


public class InsertCommand extends AFileCommand {


	InsertCommand(String[] params, IEditableFile efile) {
		super(params, efile);
	}


	@Override
	protected boolean execute() throws IOException {
		if(efile.size() == 0) {
			System.out.println("WARNING Looks like you are adding the first line to the empty file");
		}
		if(lineNumer > 0 && (lineNumer <= efile.size()) || (efile.size() == 0 && lineNumer == 1)) {
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
