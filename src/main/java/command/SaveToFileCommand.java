package main.java.command;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SaveToFileCommand extends AFileCommand {

	SaveToFileCommand(String[] words, IEditableFile efile) {
		super(words, efile);
	}
	
	@Override
	protected boolean execute() throws IOException {
		System.out.println("Saving file:" + efile.getFile());
		Path path = Paths.get(efile.getFile().getAbsolutePath());
		Files.delete(path);
		try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path,
                StandardOpenOption.CREATE_NEW)) {
			for(String line: efile) {
				bufferedWriter.write(line + "\n");
			}
        }
		return true;
	}

}
