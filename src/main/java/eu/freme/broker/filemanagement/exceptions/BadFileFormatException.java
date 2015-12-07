package eu.freme.broker.filemanagement.exceptions;

@SuppressWarnings("serial")
public class BadFileFormatException extends RuntimeException{

	public BadFileFormatException(String msg){
		super(msg);
	}
}
