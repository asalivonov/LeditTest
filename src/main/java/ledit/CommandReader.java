package ledit;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandReader {
	
	static final String HELP = "Usage:\r\n"
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
	
	
	static void processCommands(TextFile tf) throws IOException {
		
		while(readCmd(tf)) {
			
		}
		
		System.out.println("Exiting application");
	}

	static boolean readCmd(TextFile tf) throws IOException {
		String line = readConsole("Enter command:");
		if(line.isBlank()) {
			return true;
		}
		
		String[] words = line.split(" ");
		String cmd = words[0];
		int lineNumer = -1;
		if(words.length > 1) {
			try {
				lineNumer = Integer.parseInt(words[1]);
			} catch (NumberFormatException e) {
				System.out.println("ERROR please use positive integer for line number");
			}
		}
		System.out.println("Command:" + cmd);
		switch (cmd) {
		case "i":
		case "ins": {
			tf.insert(lineNumer, readConsole("Enter new line:"));
			break;
		}
		case "l":
		case "list": {
			tf.listLines();
			break;
		}
		case "d":
		case "del": {
			tf.delete(lineNumer);
			break;
		}
		case "s":
		case "save": {
			tf.save();
			break;
		}
		case "q" :
		case "quit": return false;
		default:
			System.out.println("ERROR Command:" + cmd);
			printHelp();
		}
		return true;
	}
	
	private static String readConsole(String msg) throws IOException {
		System.out.println(msg);
		Console cl = System.console();
		String line = "";
		if(cl == null) {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			line = bufferedReader.readLine();
			
		} else {
			line = System.console().readLine();
		}
		return line;
	}
	
	
	public static void printHelp() {
		System.out.println(HELP);
	}
}
