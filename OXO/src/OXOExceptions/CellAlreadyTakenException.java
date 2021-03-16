package OXOExceptions;

public class CellAlreadyTakenException extends OXOMoveException {
	public String toString() {
		return "Error : The cell has already been taken.";
	}
}
