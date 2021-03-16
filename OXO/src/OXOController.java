import OXOExceptions.*;

class OXOController
{
    OXOModel gameModel;
    private int numOfCurPly;
    
    public OXOController(OXOModel model)
    {
        gameModel = model;
        numOfCurPly = 0;
        gameModel.setCurrentPlayer(gameModel.getPlayerByNumber(numOfCurPly));
    }

    public void handleIncomingCommand(String command) throws OXOMoveException
    {
    	OXOPlayer p;
    	if(isCellPositionValid(command)) {
    		int row = Character.toLowerCase(command.charAt(0)) - 'a';
    		int col = Integer.parseInt(command.substring(1)) - 1;
    		gameModel.setCellOwner(row, col, gameModel.getCurrentPlayer());
    		if((p = checkWin()) != null) {
    			gameModel.setWinner(p);
    		}
    		else if(p == null && isFull()) {
    			gameModel.setGameDrawn();
    		}
    		else{
    			numOfCurPly = (numOfCurPly + 1) % gameModel.getNumberOfPlayers();
        		gameModel.setCurrentPlayer(gameModel.getPlayerByNumber(numOfCurPly));
    		}
    	}
    }
    
    private boolean isCellPositionValid(String command) throws OXOMoveException{
    	//Invalid Identifier Length
    	if(command.length() != 2) throw new InvalidIdentifierLengthException();
    	
    	//Invalid Identifier Character
    	if(!Character.isLetter(command.charAt(0)) || !Character.isDigit(command.charAt(1)))
    		throw new InvalidIdentifierCharacterException();
    	if((command.charAt(0) > 'z'|| command.charAt(0) < 'A'))
    		throw new InvalidIdentifierCharacterException();
    	
    	//Outside Range
    	int row = Character.toLowerCase(command.charAt(0)) - 'a';
		if((row < 0) || (row >= gameModel.getNumberOfRows()))
			throw new OutsideCellRangeException();
		int col = Integer.parseInt(command.substring(1)) - 1;
		if(col < 0 || col >= gameModel.getNumberOfColumns())
			throw new OutsideCellRangeException();
		
		//Check with the exist cells
		if(gameModel.getCellOwner(row, col) != null) throw new CellAlreadyTakenException();

    	return true;
    }
    
    private boolean isFull() {
    	for(int i = 0; i < gameModel.getNumberOfRows(); i++) {
    		for(int j = 0; j < gameModel.getNumberOfColumns(); j++) {
    			if(gameModel.getCellOwner(i, j) == null) return false;
    		}
    	}
    	return true;
    }
    
    private OXOPlayer checkWin() {
    	boolean flag;
    	int thr = gameModel.getWinThreshold();
    	int totR = gameModel.getNumberOfRows();
    	int totC = gameModel.getNumberOfColumns();
    	//horizontally
    	for(int i = 0; i < totR; i++) {
    		for(int j = 0; j <= totC - thr; j++) {
    			if(gameModel.getCellOwner(i, j) != null) {
        			flag = true;
        			for(int k = 1; k < thr; k++) {
        				if(gameModel.getCellOwner(i, j) != gameModel.getCellOwner(i, j + k))
        					flag = false;
        			}
        			if(flag) return gameModel.getCellOwner(i, j);
    			}
    		}
    	}
    	//vertically
    	for(int i = 0; i <= totR - thr; i++) {
    		for(int j = 0; j < totC; j++) {
    			if(gameModel.getCellOwner(i, j) != null) {
        			flag = true;
        			for(int k = 1; k < thr; k++) {
        				if(gameModel.getCellOwner(i, j) != gameModel.getCellOwner(i + k, j))
        					flag = false;
        			}
        			if(flag) return gameModel.getCellOwner(i, j);
    			}
    		}
    	}    	
    	//diagonally: down right
    	for(int i = 0; i <= totR - thr; i++) {
    		for(int j = 0; j <= totC - thr; j++) {
    			if(gameModel.getCellOwner(i, j) != null) {
        			flag = true;
        			for(int k = 1; k < thr; k++) {
        				if(gameModel.getCellOwner(i, j) != gameModel.getCellOwner(i + k, j + k))
        					flag = false;
        			}
        			if(flag) return gameModel.getCellOwner(i, j);
    			}
    		}
    	}
    	//diagonally: down left
    	for(int i = 0; i <= totR - thr; i++) {
    		for(int j = thr - 1; j < totC; j++) {
    			if(gameModel.getCellOwner(i, j) != null) {
        			flag = true;
        			for(int k = 1; k < thr; k++) {
        				if(gameModel.getCellOwner(i, j) != gameModel.getCellOwner(i + k, j - k))
        					flag = false;
        			}
        			if(flag) return gameModel.getCellOwner(i, j);
    			}
    		}
    	}
    	return null;
    }
}
