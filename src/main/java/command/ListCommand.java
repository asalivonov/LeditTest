package command;

import java.io.IOException;

public class ListCommand extends AFileCommand {

	
	public ListCommand(String[] words, IEditableFile efile) {
		super(words, efile);
	}

	@Override
	protected boolean execute() throws IOException {
		int i = 1;
		 for(String line : efile.getLines()) {
			 System.out.println((i++) + " : " + line);
		 }
		 return true;
	}

}
