package command;

import java.io.IOException;
import java.util.List;

import ledit.CommandProcessor;

public class InsertCommand extends AFileCommand {


	InsertCommand(String[] params, IEditableFile efile) {
		super(params, efile);
	}


	@Override
	protected boolean execute() throws IOException {
		String newLine = CommandProcessor.readConsole("Enter new line:");
		List<String> lines = efile.getLines();
		if(lineNumer > 1 && lineNumer < lines.size()-1) {
			lines.add(lineNumer - 1, newLine);
			System.out.println("New line inserted:");
			listLines(lineNumer - 2, lineNumer + 2);
		} else {
			System.out.println("ERROR incorrect line number");
		}
		return true;
	}

}
