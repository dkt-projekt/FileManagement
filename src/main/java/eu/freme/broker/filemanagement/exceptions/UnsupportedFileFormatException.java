package eu.freme.broker.filemanagement.exceptions;

@SuppressWarnings("serial")
public class UnsupportedFileFormatException extends RuntimeException{

	public UnsupportedFileFormatException(String msg){
		super(msg);
	}
}
