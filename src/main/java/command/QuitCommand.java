package command;

import java.io.IOException;

public class QuitCommand extends AFileCommand {


	QuitCommand(String[] params, IEditableFile efile) {
		super(params, efile);
	}

	@Override
	protected boolean execute() throws IOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
