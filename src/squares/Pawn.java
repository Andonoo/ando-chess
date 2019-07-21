package squares;

import game.ChessMove;
import game.PieceType;
import game.Player;

/**
 * Represents a pawn piece in a game of chess.
 * 
 * @author Andrew Donovan
 *
 */
public class Pawn extends Piece {
	private boolean _firstMoveSpent;
	
    public Pawn(int x, int y, Player player) {
		super(x, y, player);
		_firstMoveSpent = false;
		if (player.equals(Player.WHITE)) {
			_type = PieceType.WPAWN;
		} else {
			_type = PieceType.BPAWN;
		}
	}

	/**
	 * Tests whether the provided move is valid in terms of directional movement for a pawn
	 * of this colour.
	 */
	protected boolean pieceMoveValid(int startX, int startY, int endX, int endY) {
		// Testing for straight move up or down (depending on colour)
		if (startX == endX) {
			if (!_firstMoveSpent && _player.equals(Player.BLACK)) {
				if (endY == startY - 2 || endY == startY - 1) {
					return true;
				} else {
					return false;
				}
			} else if (_firstMoveSpent && _player.equals(Player.BLACK)) {
				if (endY == startY - 1) {
					return true;
				} else {
					return false;
				}
			} else if (!_firstMoveSpent && _player.equals(Player.WHITE)) {
				if (endY == startY + 2 || endY == startY + 1) {
					return true;
				} else {
					return false;
				}
			} else {
				if (endY == startY + 1) {
					return true;
				} else {
					return false;
				}
			}
		// Testing for diagonal take move
		} else {
			if (_player.equals(Player.BLACK)) {
				if (endX == startX-1 && endY == startY-1) {
					return true;
				} else if (endX == startX+1 && endY == startY-1) {
					return true;
				} else {
					return false;
				}
			} else {
				if (endX == startX+1 && endY == startY+1) {
					return true;
				} else if (endX == startX-1 && endY == startY+1) {
					return true;
				} else {
					return false;
				}
			}
		}
	}
}
