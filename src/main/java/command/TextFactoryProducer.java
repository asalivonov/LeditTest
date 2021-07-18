package main.java.command;

public class TextFactoryProducer {
	
	public static AbstarctCommandFactory getFactory(boolean bigFile){   
	      if(bigFile){
	    	  //TODO This not implemented yet, the idea is not to load full file in memory and use cache file
	    	  System.out.println("Currently we are supporting only small files, but will try to read provided file to the memory!");
	         return getFactory(false) ;         
	      }else{
	         return new SmallFileCommandFactory();
	      }
	   }

}
