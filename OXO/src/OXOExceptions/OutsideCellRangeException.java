package OXOExceptions;

public class OutsideCellRangeException extends CellDoesNotExistException{
	int position;
	RowOrColumn type;
	
	public String toString() {
		return "Error : The cell is out of cell range.";
	}
}
