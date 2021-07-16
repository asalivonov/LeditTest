package main.java.ledit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
		

	EditableTextFile(String someFile) throws IOException {
		file = new File(someFile);
		CommandProcessor.printHelp();	
		init();
	}
	
	private void init() throws IOException {
		System.out.println("Reading file:" + file.getName());
		try (BufferedReader br = Files.newBufferedReader(Paths.get(file.getAbsolutePath()))) {
            lines = br.lines().collect(Collectors.toList());
        } 

	}
	

	public void save() throws IOException {
		System.out.println("Saving file:" + file.getName());
		Path path = Paths.get(file.getAbsolutePath());
		Files.delete(path);
		try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path,
                StandardOpenOption.CREATE_NEW)) {
			for(String line: lines) {
				bufferedWriter.write(line + "\n");
			}
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
