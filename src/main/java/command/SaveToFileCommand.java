package main.java.command;

import java.io.IOException;

import main.java.ledit.FileHelper;

public class SaveToFileCommand extends AFileCommand {

	SaveToFileCommand(String[] words, IEditableFile efile) {
		super(words, efile);
	}
	
	@Override
	protected boolean execute() throws IOException {
		System.out.println("Saving file:" + efile.getFile());
		FileHelper.writeLinesToFile(efile);
		return true;
	}

}
