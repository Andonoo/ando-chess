package squares;

import game.ChessMove;
import game.PieceType;
import game.Player;

public abstract class Square {
	protected PieceType _type;
	
	public boolean isOccupiedBy(Player player) {
    	return false;
    }

	public abstract boolean isValidMovement(ChessMove move);

	public PieceType getType() {
		return _type;
	}
}

