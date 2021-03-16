package OXOExceptions;

public class InvalidIdentifierCharacterException  extends InvalidIdentifierException{
	char character;
	RowOrColumn type;
	public String toString() {
		return "Error : Invalid Identifier Character.";
	}
}
