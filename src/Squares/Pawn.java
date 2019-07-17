package squares;

import game.ChessMove;
import game.Player;

public class Pawn extends Piece {
	private boolean _firstMoveSpent;
	
    public Pawn(int x, int y, Player player) {
		super(x, y, player);
		_firstMoveSpent = false;
	}

	public boolean moveTest(int start_x, int start_y, int end_x, int end_y) {
        return true;
    }
	
	public boolean isValidMove(ChessMove move) {
		int startX = getXCoord(move.getOrigin());
		int starty = getXCoord(move.getOrigin());
		int endX = getYCoord(move.getOrigin());
		int endY = getYCoord(move.getOrigin());
		if (!_firstMoveSpent) {
			if (startX == endX && (starty == starty+1 || starty == starty+2)) {
				return true;
			} else {
				return false;
			}
		} else {
			if ((startX == endX))
		}
	}
}
