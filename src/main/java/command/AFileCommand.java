package command;

import java.io.IOException;
import java.util.List;


abstract class AFileCommand implements IRunableCommand{
	protected String[] params;
	protected IEditableFile efile;
	protected int lineNumer;
	protected String name;
	
	abstract protected boolean execute() throws IOException;
	
	AFileCommand(String[] params, IEditableFile efile){
		this.params = params;
		this.efile = efile;
		name = params[0];
		if(params.length > 1) {
			try {
				lineNumer = Integer.parseInt(params[1]);
			} catch (NumberFormatException e) {
				System.out.println("ERROR please use positive integer for line number");
			}
		}
	}
	
	@Override
	public boolean run() {
		boolean continueEdit = true;
		try {
			continueEdit = execute();
		} catch (IOException e) {
			System.out.println("ERROR while running the command:" + name + " : " + e);
		}
		return continueEdit;
	}
	
	protected void listLines(int lineFrom, int lineTo) {
		List<String> lines = efile.getLines();
		if(lineFrom < 1) lineFrom =1;
		if(lineTo > lines.size()-1) lineTo = lines.size();
		 for(int i = lineFrom-1 ; i<=lineTo-1 ; i++ ) {
			 System.out.println((i+1) + " : " + lines.get(i));
		 }
	}
}
