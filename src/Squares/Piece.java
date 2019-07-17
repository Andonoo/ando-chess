package squares;

import game.Player;

/**
 * Piece to represents a chess piece on the game board.
 * @author Andrew
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
    
    public boolean isOccupiedBy(Player player) {
    	if (_player.equals(player)) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    protected int getXCoord(int index) {
    	return (index % 8);
    }
    
    protected int getYCoord(int index) {
    	return (index / 8); 
    }
}
