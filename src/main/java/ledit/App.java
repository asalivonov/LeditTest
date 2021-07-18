package main.java.ledit;

import java.io.File;
import java.io.IOException;
import java.util.List;

import main.java.command.IEditableFile;
import main.java.command.TextFactoryProducer;

public class App {
	
	static final String TEST_FILE = "test.txt";
	public static final String HELP = "Usage:\r\n"
			+ "lineeditor c:\\temp\\myfile.txt\r\n"
			+ "(displays a >> prompt)\r\n"
			+ " \r\n"
			+ "Commands:\r\n"
			+ "list - list each line in n:xxx format, e.g.\r\n"
			+ "1: first line\r\n"
			+ "2: second line\r\n"
			+ "3: last line\r\n"
			+ "del n - delete line at n\r\n"
			+ "ins n - insert a line at n\r\n"
			+ "save - saves to disk\r\n"
			+ "quit - quits the editor and returns to the command line";

    public static void main(String[] args) {
    	System.out.println("Working Directory = " + System.getProperty("user.dir"));
    	System.out.println(App.HELP);
    	IEditableFile someFile = null;

		try {
			someFile = getEditableFile(args);
		} catch (Exception e1) {
			System.out.println("CRITICAL ERROR Please secify correct file in UTF8 format");
		}
		if(someFile != null) {
			try {
				CommandProcessor cp = new CommandProcessor(TextFactoryProducer.getFactory(false));
				cp.processCommands(someFile);
			} catch (IOException e) {
				System.out.println("CRITICAL ERROR during command execution");
			}
		}
        
    }
    
    private static IEditableFile getEditableFile(String[] args) throws IOException {
    	IEditableFile someFile = null;
    	
    	if(args != null && args.length > 0) {
    		File file = new File(args[0]);
    		if(file.exists() && file.canRead()) {
    			List<String> lines = FileHelper.readLinesFromFile(file);
    			someFile = new EditableTextFile(file, lines);
    		}
    	}
    	
    	return someFile;
		//return new EditableTextFile(new File(TEST_FILE));
    }
}
