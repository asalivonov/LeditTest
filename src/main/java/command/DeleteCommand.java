package main.java.command;

import java.io.IOException;


public class DeleteCommand extends AFileCommand {

	public DeleteCommand(String[] params, IEditableFile efile) {
		super(params, efile);
	}

	@Override
	protected boolean execute() throws IOException {
		//-1 because we start form 0
		if(lineNumer >= 1 && lineNumer < efile.size()-1) {
			efile.deleteLine(lineNumer);
			System.out.println("deleted line:" + lineNumer);
			listLines(lineNumer - 2, lineNumer + 2);
		} else {
			System.out.println("ERROR incorrect line number");
		}
		
		return true;
	}

}
