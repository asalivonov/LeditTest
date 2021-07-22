package main.java.command;

import java.io.IOException;


public class DeleteCommand extends AFileCommand {

	public DeleteCommand(String[] params, IEditableFile efile) {
		super(params, efile);
	}

	@Override
	protected boolean execute() throws IOException {
		//-1 because we start form 0
		if(lineNumer > 0 && lineNumer <= efile.size()) {
			efile.deleteLine(lineNumer);
			System.out.println("deleted line:" + lineNumer);
			listLines(lineNumer - 2, lineNumer + 2);
		} else {
			System.out.println("ERROR incorrect line number, line number should be between 1 and " + efile.size());
		}
		
		return true;
	}

}
