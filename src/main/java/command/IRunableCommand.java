package main.java.command;

public interface IRunableCommand {
	
	/**
	 * @return false only if we are finishing editing the file
	 */
	boolean run();
}
