package squares;

import game.ChessMove;
import game.PieceType;
import game.Player;

/**
 * Represents a rook piece in a game of chess.
 * 
 * @author Andrew Donovan
 *
 */
public class Rook extends Piece{
    public Rook(int x, int y, Player player) {
		super(x, y, player);
		if (player.equals(Player.WHITE)) {
			_type = PieceType.WROOK;
		} else {
			_type = PieceType.BROOK;
		}
	}

    /**
	 * Tests whether the provided move is valid for a rook of this colour.
	 */
	protected boolean pieceMoveValid(int startX, int startY, int endX, int endY) {
		if ((startX == endX &&  startY != endY) || (startY == endY && startX != endX)) {
			return true;
		} else {
			return false;
		}
	}
}

