package command;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IEditableFile extends Iterable<String>{
	 void save() throws IOException ;
	 List<String> getLines();
	 File getFile();
}
