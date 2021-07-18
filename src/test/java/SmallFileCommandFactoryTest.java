package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.command.IRunableCommand;
import main.java.command.SmallFileCommandFactory;
import main.java.command.UnknownCommand;

public class SmallFileCommandFactoryTest {

	@Test
	public void testNull() {
		SmallFileCommandFactory commandFactory = new SmallFileCommandFactory();
	
		assertNull(commandFactory.getCommand(null, null));
	}

	@Test
	public void testEmpty() {
		SmallFileCommandFactory commandFactory = new SmallFileCommandFactory();
		
		IRunableCommand cmd = commandFactory.getCommand("", null);
	
		assertNull(cmd);
	}
	
	@Test
	public void testUnknown() {
		SmallFileCommandFactory commandFactory = new SmallFileCommandFactory();
		
		IRunableCommand cmd = commandFactory.getCommand("asdadfhgfd", null);
	
		assertTrue(cmd instanceof UnknownCommand);
	}
}
