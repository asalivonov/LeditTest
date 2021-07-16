package main.java.command;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IEditableFile extends Iterable<String>{
	 void save() throws IOException ;
	 File getFile();
	 /*
	  * Number of lines in file
	  */
	 int size();
	 void insertLine(String line, int lineNumber);
	 void deleteLine(int lineNumber);
	 String getLine(int lineNumber);
}
