package main.java.command;

import java.io.File;

public interface IEditableFile extends Iterable<String>{
	 File getFile();
	 /*
	  * returns Number of lines in file
	  */
	 int size();
	 void insertLine(String line, int lineNumber);
	 void deleteLine(int lineNumber);
	 String getLine(int lineNumber);
}
