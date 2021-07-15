package ledit;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import command.IEditableFile;

import java.util.stream.Collectors;


public class EditableTextFile implements IEditableFile {
	
	private File file;
	
	private List<String> lines;
	
	public File getFile() {
		return file;
	}
	
	public List<String> getLines(){
		return lines;
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
	
	

}
