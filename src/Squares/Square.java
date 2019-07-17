package squares;

import game.ChessMove;
import game.Player;

public abstract class Square {
	public boolean isOccupiedBy(Player player) {
    	return false;
    }

	public abstract boolean isValidMove(ChessMove move);
}

