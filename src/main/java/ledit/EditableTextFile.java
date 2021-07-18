package main.java.ledit;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import main.java.command.IEditableFile;


public class EditableTextFile implements IEditableFile {
	
	private File file;
	
	private List<String> lines;
	
	public File getFile() {
		return file;
	}
		

	EditableTextFile(File file, List<String> list) throws IOException {
		this.file = file;
		lines = list;
	}
	

	@Override
	public Iterator<String> iterator() {
		return lines.iterator();
	}


	@Override
	public int size() {
		return lines.size();
	}


	@Override
	public void insertLine(String line, int lineNumber) {
		lines.add(lineNumber-1, line);
	}


	@Override
	public String getLine(int lineNumber) {
		return lines.get(lineNumber-1);
	}


	@Override
	public void deleteLine(int lineNumber) {
		lines.remove(lineNumber-1);		
	}
	
	

}
