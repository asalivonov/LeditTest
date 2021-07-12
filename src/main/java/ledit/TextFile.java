package ledit;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;


public class TextFile extends File{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8836026921094898581L;
	
	
	private List<String> lines;

	TextFile(String someFile) throws IOException{
		super(someFile);
		CommandReader.printHelp();
		
		init();
	}
	
	private void init() throws IOException {
		System.out.println("Reading file:" + getName());
		try (BufferedReader br = Files.newBufferedReader(Paths.get(getAbsolutePath()))) {
            lines = br.lines().collect(Collectors.toList());
        } 

	}
	

	public void save() throws IOException {
		System.out.println("Saving file:" + getName());
		Path path = Paths.get(getAbsolutePath());
		Files.delete(path);
		try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path,
                StandardOpenOption.CREATE_NEW)) {
			for(String line: lines) {
				bufferedWriter.write(line + "\n");
			}

        }
		
	}

	public void listLines() {
		int i = 1;
		 for(String line : lines) {
			 System.out.println((i++) + " : " + line);
		 }
	}
	
	public void listLines(int lineFrom, int lineTo) {
		if(lineFrom < 1) lineFrom =1;
		if(lineTo > lines.size()-1) lineTo = lines.size();
		 for(int i = lineFrom-1 ; i<=lineTo-1 ; i++ ) {
			 System.out.println((i+1) + " : " + lines.get(i));
		 }
	}
	
	public void delete(int line) {
		//-1 because we start form 0
		if(line >= 1 && line < lines.size()-1) {
			lines.remove(line-1);
			System.out.println("deleted line:" + line);
			listLines(line - 2, line + 2);
		} else {
			System.out.println("ERROR incorrect line number");
		}
		
	}
	
	public void insert(int line, String newLine) {
		if(line > 1 && line < lines.size()-1) {
			lines.add(line - 1, newLine);
			System.out.println("New line inserted:");
			listLines(line - 2, line + 2);
		} else {
			System.out.println("ERROR incorrect line number");
		}
		
	}
	
	

}
