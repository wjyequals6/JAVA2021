package OXOExceptions;

public class InvalidIdentifierLengthException extends InvalidIdentifierException{
	int length;
	
	public String toString() {
		return "Error : Invalid Identifier Length.";
	}
}
