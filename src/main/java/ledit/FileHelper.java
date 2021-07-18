package main.java.ledit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

import main.java.command.IEditableFile;

public class FileHelper {
	
	public static List<String> readLinesFromFile(File file) throws IOException{
		System.out.println("Reading file:" + file.getName());
		List<String> lines = null;
		if(file.exists() && file.canRead()) {
			try (BufferedReader br = Files.newBufferedReader(Paths.get(file.getAbsolutePath()))) {
				lines =  br.lines().collect(Collectors.toList());
	        }
		} 
		return lines;
	}

	public static void writeLinesToFile(IEditableFile efile) throws IOException {
		Path path = Paths.get(efile.getFile().getAbsolutePath());
		Files.delete(path);
		try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path,
                StandardOpenOption.CREATE_NEW)) {
			for(String line: efile) {
				bufferedWriter.write(line + "\n");
			}
        }
	}
}
