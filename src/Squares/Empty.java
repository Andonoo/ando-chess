package squares;

import game.ChessMove;
import game.PieceType;

public class Empty extends Square{
	public Empty() {
		_type = PieceType.EMPTY;
	}
	public boolean isValidMovement(ChessMove move) {
		return false;
	}
}
