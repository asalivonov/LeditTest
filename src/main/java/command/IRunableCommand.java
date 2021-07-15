package command;

public interface IRunableCommand {
	
	/*
	 * Returns false only if we are finished editing
	 */
	boolean run();
}
