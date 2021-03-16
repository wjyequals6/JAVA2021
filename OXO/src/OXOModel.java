import java.util.*;

class OXOModel
{
    private OXOPlayer cells[][];
    private ArrayList<ArrayList<OXOPlayer>> cell2D = new ArrayList<ArrayList<OXOPlayer>>();
    private ArrayList<OXOPlayer> players;
    private OXOPlayer currentPlayer;
    private OXOPlayer winner;
    private boolean gameDrawn;
    private int winThreshold;

    public OXOModel(int numberOfRows, int numberOfColumns, int winThresh)
    {
        winThreshold = winThresh;
        players = new ArrayList<OXOPlayer>();
        cells = new OXOPlayer[numberOfRows][numberOfColumns];
        for(int i = 0; i < cells.length; i++) {
        	ArrayList<OXOPlayer> cell1D = new ArrayList<OXOPlayer>();
        	for(int j = 0; j < cells[i].length; j++) {
        		cell1D.add(cells[i][j]);
        	}
        	cell2D.add(cell1D);
        }
        
    }

    public int getNumberOfPlayers()
    {
        return players.size();
    }

    public void addPlayer(OXOPlayer player)
    {	
    	players.add(player);
    }

    public OXOPlayer getPlayerByNumber(int number)
    {
        return players.get(number);
    }

    public OXOPlayer getWinner()
    {
        return winner;
    }

    public void setWinner(OXOPlayer player)
    {
        winner = player;
    }

    public OXOPlayer getCurrentPlayer()
    {
        return currentPlayer;
    }

    public void setCurrentPlayer(OXOPlayer player)
    {
        currentPlayer = player;
    }

    public int getNumberOfRows()
    {
        return cell2D.size();
    }

    public int getNumberOfColumns()
    {
        return cell2D.get(0).size();
    }

    public OXOPlayer getCellOwner(int rowNumber, int colNumber)
    {
        return cell2D.get(rowNumber).get(colNumber);
    }

    public void setCellOwner(int rowNumber, int colNumber, OXOPlayer player)
    {
        cell2D.get(rowNumber).set(colNumber, player);
    }

    public void setWinThreshold(int winThresh)
    {
        winThreshold = winThresh;
    }

    public int getWinThreshold()
    {
        return winThreshold;
    }

    public void setGameDrawn()
    {
        gameDrawn = true;
    }

    public boolean isGameDrawn()
    {
        return gameDrawn;
    }
}
