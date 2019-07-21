package squares;

import game.PieceType;
import game.Player;

/**
 * Represents a bishop piece in a game of chess.
 * 
 * @author Andrew Donovan
 *
 */
public class Bishop extends Piece{
    public Bishop(int x, int y, Player player) {
		super(x, y, player);
		if (player.equals(Player.WHITE)) {
			_type = PieceType.WBISHOP;
		} else {
			_type = PieceType.BBISHOP;
		}
	}

	/**
	 * Tests whether the provided move is valid for a bishop of this colour.
	 */
	protected boolean pieceMoveValid(int startX, int startY, int endX, int endY) {
		if ((Math.abs(endX - startX) == Math.abs(endY - startY))) {
			return true;
		} else {
			return false;
		}
	}
}
