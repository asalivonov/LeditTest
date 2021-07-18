package main.java.command;

import java.io.File;

public interface IEditableFile extends Iterable<String>{
	 /**
	 * @return original file
	 */
	File getFile();

	 /**
	 * @return returns Number of lines in file
	 */
	int size();
	 /**
	 * @param line number starting from 1
	 * @param lineNumber number starting from 1 line
	 */
	void insertLine(String line, int lineNumber);
	 /**
	 * @param lineNumber number starting from 1 line
	 */
	void deleteLine(int lineNumber);
	 /**
	 * @param lineNumber number starting from 1 line
	 * @return line
	 */
	String getLine(int lineNumber);
}
