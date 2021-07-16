package main.java.ledit;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import main.java.command.IEditableFile;


public class EditableTextFile implements IEditableFile {
	
	private File file;
	
	private List<String> lines;
	
	public File getFile() {
		return file;
	}
		

	EditableTextFile(File file) throws IOException {
		this.file = file;
		CommandProcessor.printHelp();	
		init();
	}
	
	private void init() throws IOException {
		System.out.println("Reading file:" + file.getName());
		try (BufferedReader br = Files.newBufferedReader(Paths.get(file.getAbsolutePath()))) {
            lines = br.lines().collect(Collectors.toList());
        } 

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
