package OXOExceptions;

class CellDoesNotExistException extends OXOMoveException {
	public String toString() {
		return "Error : The cell doesn't exist.";
	}
}
