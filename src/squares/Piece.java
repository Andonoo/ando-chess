package squares;

import game.ChessMove;
import game.Player;

/**
 * Piece to represents a chess piece on the game board.
 * @author Andrew Donovan
 *
 */
public abstract class Piece extends Square{
	int _x;
    int _y;
    Player _player;

    /**
     * Constructs a chess piece 
     * @param x
     * @param y
     * @param player
     */
    public Piece(int x, int y, Player player) {
        _x = x;
        _y = y;
        _player = player;
    }
    
    /**
     * Tests if this piece is controlled by the given player (black or white)
     */
    public boolean isOccupiedBy(Player player) {
    	if (_player.equals(player)) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    /**
     * @param index of this piece (0-63)
     * @return the x coordinate of this piece 
     */
    protected int getXCoord(int index) {
    	return (index % 8);
    }
    
    /**
     * @param index of this piece (0-63)
     * @return the y coordinate of this piece 
     */
    protected int getYCoord(int index) {
    	return (index / 8); 
    }
    
    
    public final boolean isValidMovement(ChessMove move) {
    	int startX = getXCoord(move.getOrigin());
		int startY = getYCoord(move.getOrigin());
		int endX = getXCoord(move.getDestination());
		int endY = getYCoord(move.getDestination());
		// Testing if move is within bounds of board
		if (endY > 7 || endY < 0 || endX > 7 || endX < 0) {
			return false;
		// Testing piece specific movement conditions
		} else {
			return pieceMoveValid(startX, startY, endX, endY);
		}
    }

	protected abstract boolean pieceMoveValid(int startX, int startY, int endX, int endY);
}
