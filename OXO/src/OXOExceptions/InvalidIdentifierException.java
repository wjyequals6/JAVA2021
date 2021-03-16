package OXOExceptions;

class InvalidIdentifierException extends CellDoesNotExistException{
	public String toString() {
		return "Error : Invalid Identifier.";
	}
}
