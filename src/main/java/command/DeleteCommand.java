package main.java.command;

import java.io.IOException;
import java.util.List;


public class DeleteCommand extends AFileCommand {

	public DeleteCommand(String[] words, IEditableFile efile) {
		super(words, efile);
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
